package dk.roninit.remedy
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class HomeController {

    def index() {

    }
}
