package remedyadminapp

import grails.rest.RestfulController

/**
 * Created with IntelliJ IDEA.
 * User: kasper
 * Date: 18/09/15
 * Time: 20.43
 * To change this template use File | Settings | File Templates.
 */
class NoseRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    NoseRestController() {
        super(Nose)
    }
}
