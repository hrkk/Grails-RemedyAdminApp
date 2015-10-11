package remedyadminapp

import grails.rest.RestfulController
import org.springframework.http.HttpStatus

// curl -H "Authorization: Basic bWU6cGFzc3dvcmQ=, Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/userRest/index

class UserRestController extends RestfulController {
    def springSecurityService
    static responseFormats = ['json', 'xml']
    UserRestController() {
        super(User)
    }

    def validate() {
            respond status: HttpStatus.OK
    }
}
