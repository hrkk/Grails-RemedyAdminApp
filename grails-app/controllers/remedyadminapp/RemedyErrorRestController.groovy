package remedyadminapp

import grails.rest.RestfulController

class RemedyErrorRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    RemedyErrorRestController() {
        super(ErrorType)
    }
}
