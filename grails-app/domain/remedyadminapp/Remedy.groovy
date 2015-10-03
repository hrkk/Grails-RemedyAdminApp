package remedyadminapp

class Remedy {
    String description
    Status status     // many-to-one relationship from Remedy to Status.
    Area area
    Machine machine
    ErrorType errorType
    byte[] photo // tells GORM to store is as a BLOB

    static constraints = {
        photo nullable: true, maxSize: 2 * 1024 * 1024
    }
}
