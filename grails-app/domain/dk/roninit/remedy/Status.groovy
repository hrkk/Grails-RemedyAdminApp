package dk.roninit.remedy

/**
 * Created with IntelliJ IDEA.
 * User: kasper
 * Date: 25/08/15
 * Time: 13.50
 * To change this template use File | Settings | File Templates.
 */
class Status {
    /* Default (injected) attributes of GORM */
    Long    id
    Long    version

    /* Automatic timestamping of GORM */
    Date    dateCreated
    Date    lastUpdated

    String displayText
}
