package models.request;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;

import java.util.Objects;

//@Data
//@AllArgsConstructor
//@Builder
public class User {
    private double id;
    private String username;
    private final String firsName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String phone;
    private final int userStatus;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(id, user.id) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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
