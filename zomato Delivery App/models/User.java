package models;

public class User {
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String location;

    public User(int userId, String name, String email, String phoneNumber, String location) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }
}