package remedyadminapp

class Log {
    /* Default (injected) attributes of GORM */
    Long    id
    Long    version

    /* Automatic timestamping of GORM */
    Date    dateCreated
    Date    lastUpdated

    String statusChangeByName // change to user id
    Status status

    static belongsTo = [remedy:Remedy]

    static constraints = {
    }
}
