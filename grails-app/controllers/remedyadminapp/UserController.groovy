package remedyadminapp



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import static sun.management.ConnectorAddressLink.importFrom

@Transactional(readOnly = true)
class UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    def show(User userInstance) {
        respond userInstance
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


        /*
         def chuck = new User(
                 loginId: "chuck_norris",
                 passwordHash: springSecurityService.encodePassword("highkick"),
                 profile: new Profile(fullName: "Chuck Norris", email: "chuck@nowhere.net"),
                 dateCreated: now).save(failOnError: true)
          */

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
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'create'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userInstance.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }

    def edit(User userInstance) {
        respond userInstance
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(User userInstance) {

        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userInstance.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

@grails.validation.Validateable
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

