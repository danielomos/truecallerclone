package africa.semicolon.callerapp.dtos.requests;

public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String PhoneNumber;
    private String password;
    private String username;


//    public String getFirstName() {
//
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPhoneNumber() {
//        return PhoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        PhoneNumber = phoneNumber;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
