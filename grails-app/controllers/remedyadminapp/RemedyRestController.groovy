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

    def remedyList() {
        def resList =  []
        Remedy.list().each { remedy ->
            JSONRemedyItem remedyItem = new JSONRemedyItem()
            remedyItem.id = remedy.id
            remedyItem.description = remedy.description
            remedyItem.status = remedy.status
            remedyItem.errorType = remedy.errorType
            remedyItem.area = remedy.area
            remedyItem.machine = remedy.machine
            resList << remedyItem
        }
        respond resList
    }

    def index() {
        println "index"
        respond Remedy.list()
    }

    def show(Integer id) {
        println "show"
        def remedy = Remedy.get(id)
        def remedyItem = new JSONRemedyItem()
        remedyItem.id = remedy.id
        remedyItem.description = remedy.description
        remedyItem.status = remedy.status
        remedyItem.errorType = remedy.errorType
        remedyItem.area = remedy.area
        remedyItem.machine = remedy.machine
        println "remedy.photo "  +remedy.photo.class
        String fileString = new String(remedy.photo,"UTF-8");
        println "remedy.photo "  +remedy.photo.class
        remedyItem.photo = fileString
        respond remedyItem
    }

    def save(SaveRemedy remedyInstance) {
        println "heps"
        println "description ${remedyInstance.description} "
        def f = request.getFile('photo')

        println f
        println f.bytes
        println f.contentType
        //println "f ${remedyInstance.photo} "
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
        newRemedy.photo = f.bytes
        newRemedy.save flush: true

        respond newRemedy, status: 201
    }
}



class JSONRemedyItem {
    Long id
    String description
    Status status;
    Area area
    Machine machine
    ErrorType errorType
    byte[] photo
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





