package remedyadminapp

import grails.rest.RestfulController
import org.springframework.http.HttpStatus

// curl -H "Authorization: Basic bWU6cGFzc3dvcmQ=, Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/userRest/index
// curl -H "Authorization: Basic bWU6cGFzc3dvcmQ=, Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/userRest/profile
// curl -H "Authorization: Basic bWU6cGFzc3dvcmQ=, Content-Type: application/json" -X GET http://www.roninit.dk/RemedyAdminApp/userRest/profile

class UserRestController extends RestfulController {
    def springSecurityService
    static responseFormats = ['json', 'xml']
    UserRestController() {
        super(User)
    }

    def validate() {
            respond status: HttpStatus.OK
    }

    def profile(int id) {
        println "profile "
        User user
        if(!id) {
            user = springSecurityService.currentUser
            println "springSecurityService.currentUser ${user}"
        }
        else {
            user = User.findById(id)
            println "User.findById(id) ${user}"
        }
        println "before respond"
        respond user.profile, status: HttpStatus.OK
    }

    def profile2(int id) {
        println "profile2 "
        User user
        if(!id) {
            user = springSecurityService.currentUser
            println "springSecurityService.currentUser ${user}"
        }
        else {
            user = User.findById(id)
            println "User.findById(id) ${user}"
        }
        println "before respond"
        ProfileJson json = new ProfileJson(fullName: user.profile.fullName)
        respond json, status: HttpStatus.OK
    }
}

class ProfileJson {
    String  fullName;
}
