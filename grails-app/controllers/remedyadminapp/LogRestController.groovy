package remedyadminapp

import grails.rest.RestfulController

// curl -H "Authorization: Basic bWU6cGFzc3dvcmQ=, Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/logRest/
// curl -H "Authorization: Basic bWU6cGFzc3dvcmQ=, Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/
class LogRestController extends RestfulController {
    static responseFormats = ['json']

    LogRestController(){
        super(remedyadminapp.Log)
    }

    def getUser(int id){
        def user = User.findById(id)
     //   def user = log.user

        def jSONUser = new JSONUser(fullName: user.profile.fullName, email: user?.profile?.email, phoneNumber: user?.profile?.phoneNumber)
        respond jSONUser, status: 200
    }
}

class JSONUser {
    String fullName
    String email
    String phoneNumber
}
