package dk.roninit.remedy

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController


// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/
@Secured('ROLE_USER')
class StatusRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    StatusRestController () {
        super(Status)
    }
}
