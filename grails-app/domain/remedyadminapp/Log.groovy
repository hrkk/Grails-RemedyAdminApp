package remedyadminapp

class Log {
    /* Default (injected) attributes of GORM */
    Long    id
    Long    version

    /* Automatic timestamping of GORM */
    Date    dateCreated
    Date    lastUpdated

    String statusChangeByName // changed by user id
    Status status

    static belongsTo = [remedy:Remedy]

    static constraints = {
    }

    static mapping = {
        sort dateCreated:"desc"
    }
}
