package dk.roninit.remedy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userCount: User.count()]
    }

    def show(User user) {
        respond user
    }

    def create() {
        respond new User(params)
    }

    def register() {
        respond new UserCmd()
    }

    @Transactional
    def save2(UserCmd userInstance) {
//        if (userInstance == null) {
//            notFound()
//            return
//        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'register'
            return
        }

        // 1 profile
        def newProfile = new Profile(fullName: userInstance.fullName, email: userInstance.email, phoneNumber: userInstance.phoneNumber)


        def newUser = new User(username: userInstance.username, password: userInstance.password, profile: newProfile, enabled: userInstance.enabled ).save(failOnError: true)


        def roleUser = Role.findByAuthority('ROLE_USER')
        UserRole.create newUser, roleUser, true


        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userInstance.label', default: 'User'), newUser.id])
                redirect action:"index", method:"GET"
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }

    @Transactional
    def save(User user) {
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'create'
            return
        }

        user.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(User user) {
        respond user
    }

    @Transactional
    def update(User user) {
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'edit'
            return
        }

        user.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    @Transactional
    def delete(User user) {

        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        user.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

class UserCmd {
    String username
    String password
    boolean enabled = true

    String fullName
    String email
    String phoneNumber
//    static hasMany = [areas: Area, machines: Machine]

    static constraints = {
        username blank: false, unique: true
        password blank: false
        fullName blank: false
        email nullable: true, blank: true
        phoneNumber nullable: true, blank: true
    }
}
