package remedyadminapp

class Profile {
    User user // profile is attached to a user Object
    String fullName
    String email
    String phoneNumber

    static constraints = {
        fullName blank: false
        email blank: true
        phoneNumber blank: true
    }
}
