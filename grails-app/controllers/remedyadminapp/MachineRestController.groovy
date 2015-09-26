package remedyadminapp

import grails.rest.RestfulController

class MachineRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    MachineRestController() {
        super(Machine)
    }
}
