package dk.roninit.remedy

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/
// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/show/1

/*
import org.apache.commons.codec.binary.Base64

String userCredentials = "me:password";
String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
 */
// curl -H "Authorization: Basic bWU6cGFzc3dvcmQ=, Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/areaControllerRest/

@Secured('ROLE_USER')
class AreaControllerRestController extends RestfulController {
    static responseFormats = ['json', 'xml']
    AreaControllerRestController() {
        super(Area)
    }
}