package remedyadminapp



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RemedyController {

    static scaffold = true

}
