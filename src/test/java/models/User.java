package models;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;

//@Data
//@AllArgsConstructor
//@Builder
public class User {
    private double id;
    private String username;
    private String firsName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public User(double id, String username, String firsName, String lastName, String email, String password, String phone, int userStatus) {
        this.id = id;
        this.username = username;
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public double getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserStatus() {
        return userStatus;
    }
}
