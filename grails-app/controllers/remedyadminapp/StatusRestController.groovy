package remedyadminapp

import grails.rest.RestfulController


// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/
class StatusRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    StatusRestController () {
        super(Status)
    }
}
