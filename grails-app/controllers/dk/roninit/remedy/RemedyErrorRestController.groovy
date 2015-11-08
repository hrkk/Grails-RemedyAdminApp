package dk.roninit.remedy

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured('ROLE_USER')
class RemedyErrorRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    RemedyErrorRestController() {
        super(ErrorType)
    }
}
