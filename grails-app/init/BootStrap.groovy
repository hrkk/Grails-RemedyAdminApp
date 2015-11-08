import dk.roninit.remedy.Area
import dk.roninit.remedy.ErrorType
import dk.roninit.remedy.Machine
import dk.roninit.remedy.Profile
import dk.roninit.remedy.Remedy
import dk.roninit.remedy.Role
import dk.roninit.remedy.Status
import dk.roninit.remedy.User
import dk.roninit.remedy.UserRole
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        def result = '################## running in UNCLEAR mode.'
        println "Application starting ... "
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                result = 'now running in DEV mode.'
                seedUserRole()
                seedTestData()
                break;
            case Environment.TEST:
                result = 'now running in TEST mode.'
                break;
            case Environment.PRODUCTION:
                result = 'now running in PROD mode.'
                // TODO delete this...
                seedUserRole()
                seedTestData()
                break;
        }
        println "current environment: $Environment.current"
        println "$result"
    }
    def destroy = {
        println "Application shutting down... "
    }

    private void seedUserRole() {
        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()

        def profile1 = new Profile(fullName: "remedy",  email: "admin@admin.dk", phoneNumber: "123-333")
        def profile2 = new Profile(fullName: "Test1 Testesen", email: "test1@test.dk", phoneNumber: "9873-333")

        def adminUser = new User(username: "remedy", password: "remedy123", profile: profile1 ).save(failOnError: true)
        def appUser1 = new User(username: "test1", password: "password", profile: profile2 ).save(failOnError: true)

        UserRole.create adminUser, adminRole, true
        UserRole.create adminUser, userRole, true
        UserRole.create appUser1, userRole, true


        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 3
    }

    private void seedTestData() {
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
        def user = User.findById(2)
        remedy = new Remedy(user: user, description: "Some simple test remedy", status: status, area: area, machine: machine, errorType: errorType)

        assert remedy.save(failOnError: true, flush: true, insert: true)
    }
}
