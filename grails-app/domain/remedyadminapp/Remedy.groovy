package remedyadminapp

class Remedy {
    String description
    Status status     // many-to-one relationship from Remedy to Status.
    Area area
    Machine machine
    ErrorType errorType

    static constraints = {
    }
}
