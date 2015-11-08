package dk.roninit.remedy

class Machine {

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
