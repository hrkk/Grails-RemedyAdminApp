package remedyadminapp

import grails.rest.RestfulController
import org.springframework.http.HttpStatus

import javax.servlet.ServletOutputStream

// curl -H "Content-Type: application/json" -X GET http://localhost:8080/RemedyAdminApp/remedyRest/index
// curl -H "Content-Type: application/json" -X POST -d '{"description":"face2", "statusId":1, "areaId":1}' http://localhost:8080/RemedyAdminApp/remedyRest/save
class RemedyRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    RemedyRestController() {
        super(Remedy)
    }

    def showImage(int id) {
        println "id ${id}"
        def remedy = Remedy.get(id)
        def arrayOfBytes = remedy.getPhoto()
        if(arrayOfBytes!=null) {
            response.setContentType("image/jpeg");
            response.setContentLength(arrayOfBytes.length);
            ServletOutputStream stream = response.getOutputStream();
            stream.write(arrayOfBytes);
            stream.flush();
        }
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


           def logs = remedy.getLogs().sort {
               it.id
           }
            logs = logs.reverse()

            logs.each { remedyadminapp.Log log ->
                def jSONLog = new JSONLog()
                jSONLog.status = log.status
                jSONLog.lastUpdated =  getNiceDate(log.lastUpdated)
                jSONLog.statusChangeByName = log.statusChangeByName
                remedyItem.logs.add(jSONLog)
            }
            remedyItem.assignedTo = remedy.user.profile.fullName
            resList << remedyItem
        }
        respond resList
    }

    protected String getNiceDate(Date date) {
        def now = new Date()
        def diff = Math.abs(now.time - date.time)
        final long second = 1000
        final long minute = second * 60
        final long hour = minute * 60
        final long day = hour * 24
        def niceTime = ""
        long calc = 0;
        calc = Math.floor(diff / day)
        if (calc) {
            niceTime += calc + " day" + (calc > 1 ? "s " : " ")
            diff %= day
        }
        calc = Math.floor(diff / hour)
        if (calc) {
            niceTime += calc + " hour" + (calc > 1 ? "s " : " ")
            diff %= hour
        }
        calc = Math.floor(diff / minute)
        if (calc) {
            niceTime += calc + " minute" + (calc > 1 ? "s " : " ")
            diff %= minute
        }
        if (!niceTime) {
            niceTime = "Right now"
        } else {
            niceTime += (date.time > now.time) ? "from now" : "ago"
        }
        return niceTime
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
        println "description ${remedyInstance.description} "
        def f = request?.getFile('photo')

        println f
        println f.bytes
        println f.contentType


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

        //respond newRemedy, status: 201
        respond status: 201
    }

    def saveNoImage(SaveRemedy remedyInstance) {
        println "description ${remedyInstance.description} "

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

        //respond newRemedy, status: 201
        respond status: 201
    }

    def updateNoImage(UpdateRemedy remedyInstance) {
        println "description ${remedyInstance.description} "

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

        def updateRemedy = Remedy.findById(remedyInstance.id)
        updateRemedy.description = remedyInstance.description
        updateRemedy.status = status
        updateRemedy.area = area
        updateRemedy.machine = machine
        updateRemedy.errorType = errorType

        updateRemedy.save(flush: true)
      //  updateRemedy.save()

        //respond updateRemedy, status: 201
        respond status: 201
    }
}
class JSONLog {
    String lastUpdated
    Status status;
    String statusChangeByName
}


class JSONRemedyItem {
    Long id
    String description
    Status status;
    Area area
    Machine machine
    ErrorType errorType
    byte[] photo
    def logs = []
    String assignedTo
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


class UpdateRemedy {
    Long id
    String description
    Long statusId
    Long areaId
    Long machineId
    Long errorTypeId

    static constraints = {
        id blank: false, nullable: false
        description blank: false, nullable: false
        statusId blank: false, nullable: false
        areaId blank: false, nullable: false
        machineId blank: false, nullable: false
        errorTypeId blank: false, nullable: false
    }
}




