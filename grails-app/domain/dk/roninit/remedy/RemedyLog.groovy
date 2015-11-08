package dk.roninit.remedy

class RemedyLog {
    /* Default (injected) attributes of GORM */
    Long    id
    Long    version

    /* Automatic timestamping of GORM */
    Date    dateCreated
    Date    lastUpdated

    String statusChangeByName // changed by user id
    Status status

    static belongsTo = [remedy:Remedy]
    User user // Log is attached to a user Object

    static constraints = {
        user nullable: true
    }

    static mapping = {
        sort dateCreated:"desc"
    }
}
