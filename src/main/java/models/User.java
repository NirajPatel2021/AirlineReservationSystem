package models;

import java.util.Objects;

/**
 * Data model used to provide a Java representation of the 'user' table within our database.
 * If we write a query to retrieve a record from the database,
 * then the User class provides an easy way to represent the record that we just retrieved from our user table.
 */
public class User {
    private int userID;
    private String paymentInfo;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = firstName + " " + lastName;
    }

    private String fullName;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) && Objects.equals(paymentInfo, user.paymentInfo) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(userName, user.userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
