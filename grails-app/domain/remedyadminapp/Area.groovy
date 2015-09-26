package remedyadminapp

class Area {
    /* Default (injected) attributes of GORM */
    Long    id
    Long    version

    /* Automatic timestamping of GORM */
    Date    dateCreated
    Date    lastUpdated


    String displayText


    static constraints = {
    }
}
