package dk.roninit.remedy

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class ErrorTypeController {

    static scaffold = ErrorType

}
