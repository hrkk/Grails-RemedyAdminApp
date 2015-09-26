package remedyadminapp

import grails.rest.RestfulController
import org.springframework.http.HttpStatus

// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/remedyRest/index
// curl -H "Content-Type: application/json" -X POST -d '{"description":"face2", "statusId":1, "areaId":1}' http://localhost:8080/RemedyAdminApp/remedyRest/save
class RemedyRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    RemedyRestController() {
        super(Remedy)
    }

    def index() {
        println "index"
        respond Remedy.list()
    }

    def show(Integer id) {
        println "show"
        respond Remedy.get(id)
    }

    def save(SaveRemedy remedyInstance) {
        println "heps"
        println "description ${remedyInstance.description} "
       // println "status ${remedyInstance.status} "

        if (remedyInstance == null) {
            respond status: HttpStatus.BAD_REQUEST
        }

        if (remedyInstance.hasErrors()) {
            println "Errors ${remedyInstance.errors}"
            respond status: HttpStatus.BAD_REQUEST
        }

        Status status = Status.findById remedyInstance.statusId
        Area area = Area.findById remedyInstance.areaId
        Machine machine = Machine.findById remedyInstance.machineId
        ErrorType errorType = ErrorType.findById remedyInstance.errorTypeId

        def newRemedy = new Remedy(description: remedyInstance.description, status: status, area: area, machine: machine, errorType: errorType)

        newRemedy.save flush: true

        respond newRemedy, status: 201
    }
}

class SaveRemedy {
    String description
    Long statusId
    Long areaId
    Long machineId
    Long errorTypeId

    static constraints = {
        description blank: false, nullable: false
        statusId blank: false, nullable: false
        areaId blank: false, nullable: false
        machineId blank: false, nullable: false
        errorTypeId blank: false, nullable: false
    }
}





