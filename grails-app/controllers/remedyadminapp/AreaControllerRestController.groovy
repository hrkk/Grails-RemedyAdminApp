package remedyadminapp

import grails.rest.RestfulController

// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/
// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/show/1
class AreaControllerRestController extends RestfulController {
    static responseFormats = ['json', 'xml']
    AreaControllerRestController() {
        super(Area)
    }
}