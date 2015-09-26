import grails.util.Environment
import remedyadminapp.Area
import remedyadminapp.Machine
import remedyadminapp.Nose
import remedyadminapp.Remedy
import remedyadminapp.ErrorType
import remedyadminapp.Status

class BootStrap {

    def init = { servletContext ->
        def result = '################## running in UNCLEAR mode.'
        println "Application starting ... "
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                result = 'now running in DEV mode.'
                seedTestData()
                break;
            case Environment.TEST:
                result = 'now running in TEST mode.'
                break;
            case Environment.PRODUCTION:
                result = 'now running in PROD mode.'
                seedTestData()
                break;
        }
        println "current environment: $Environment.current"
        println "$result"
    }
    def destroy = {
        println "Application shutting down... "
    }

    private void seedTestData() {

        Nose nose1 = new Nose(name: "nose1")
        assert nose1.save(failOnError:true, flush:true, insert: true)
        def area = null
        println "Start loading areas into database"
        area = new Area(displayText: 'Area1')
        assert area.save(failOnError:true, flush:true, insert: true)
        area.errors = null

        area = new Area(displayText: 'Area2')
        assert area.save(failOnError:true, flush:true, insert: true)
        area.errors = null

        assert Area.count == 2;
        println "Finished loading $Area.count areas into database"

        def status = null
        println "Start loading statuss into database"
        status = new Status(displayText: 'New')
        assert status.save(failOnError:true, flush:true, insert: true)
        status.errors = null

        status = new Status(displayText: 'Open')
        assert status.save(failOnError:true, flush:true, insert: true)
        status.errors = null

        status = new Status(displayText: 'New (re-assign)')
        assert status.save(failOnError:true, flush:true, insert: true)
        status.errors = null

        status = new Status(displayText: 'Fixed')
        assert status.save(failOnError:true, flush:true, insert: true)
        status.errors = null

        status = new Status(displayText: 'Closed')
        assert status.save(failOnError:true, flush:true, insert: true)
        status.errors = null

        assert Status.count == 5;
        println "Finished loading $Area.count areas into database"


        def machine = null
        println "Start loading machines into database"
        machine = new Machine(displayText: 'Machine1')
        assert machine.save(failOnError:true, flush:true, insert: true)
        machine.errors = null

        println "Start loading machines into database"
        machine = new Machine(displayText: 'Machine2')
        assert machine.save(failOnError:true, flush:true, insert: true)
        machine.errors = null

        println "Start loading machines into database"
        machine = new Machine(displayText: 'Machine3')
        assert machine.save(failOnError:true, flush:true, insert: true)
        machine.errors = null

        assert Machine.count == 3;
        println "Finished loading $Machine.count machines into database"


        def errorType = null
        println "Start loading errors into database"
        errorType = new ErrorType(displayText: 'Fatal')
        assert errorType.save(failOnError:true, flush:true, insert: true)
        errorType.errors = null


        errorType = new ErrorType(displayText: 'Cricical')
        assert errorType.save(failOnError:true, flush:true, insert: true)
        errorType.errors = null


        errorType = new ErrorType(displayText: 'Nice to have')
        assert errorType.save(failOnError:true, flush:true, insert: true)
        errorType.errors = null


        assert Machine.count == 3;
        println "Finished loading $ErrorType.count machines into database"


        def remedy = null
        println "Start loading remedy into database"
        remedy = new Remedy(description: "Some simple test remedy", status: status, area: area, machine: machine, errorType: errorType)
        assert remedy.save(failOnError: true, flush: true, insert: true)



    }

}
