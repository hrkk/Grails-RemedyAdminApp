package remedyadminapp

class Profile {
    User user // profile is attached to a user Object
    String fullName

    static constraints = {
        fullName blank: false

    }
}
