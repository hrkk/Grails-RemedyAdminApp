package remedyadminapp

class Remedy {
    def springSecurityService
    /* Default (injected) attributes of GORM */
    Long    id
    Long    version

    /* Automatic timestamping of GORM */
    Date    dateCreated
    Date    lastUpdated
    String description
    Status status     // many-to-one relationship from Remedy to Status.
    Area area
    Machine machine
    ErrorType errorType
    byte[] photo // tells GORM to store is as a BLOB


    static hasMany = [logs: Log]
    static belongsTo = [ user: User ]   // when the user is deleted all his remedy's is deleted too

    static constraints = {

        id()
        photo nullable: true, maxSize: 2 * 1024 * 1024
        user nullable: true
    }

    def beforeInsert() {
        println "beforeInsert for remedy : status ${status.id}"
        def user = springSecurityService.currentUser
        if(!user)
            user = User.findById(1)   // added for test purpose...
        def fullName = "Default need for testdata"
        if(user?.profile?.fullName)
            fullName = user?.profile?.fullName

        this.addToLogs(new remedyadminapp.Log(statusChangeByName: fullName, status: status, user: user));
        this.setUser(user)
    }

    def beforeUpdate() {
        println "beforeUpdate for remedy with id ${this.id} status: ${status.id}"
        def user = springSecurityService.currentUser
        if(user?.profile?.fullName) {
            def fullName = user?.profile?.fullName
            println "fullName =" + fullName
            def log = new remedyadminapp.Log(statusChangeByName: fullName, status: status, remedy: this, user : user)
            this.addToLogs(log);
        }
        this.setUser(user)
    }
}
