package remedyadminapp

class Remedy {
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

    List logs
    static hasMany = [logs: Log]

    static constraints = {
        photo nullable: true, maxSize: 2 * 1024 * 1024
    }

    def beforeInsert() {
        println "beforeInsert for remedy"
        this.addToLogs(new remedyadminapp.Log(statusChangeByName: "TBD get Name by UserID", status: Status.findById(1)));
    }

    def beforeUpdate() {
        println "afterUpdate for remedy with id ${this.id}"
        this.addToLogs(new remedyadminapp.Log(statusChangeByName: "TBD get Name by UserID", status: Status.findById(1)));
    }
}
