package main.java;

// user class, stores the username and password of a user
public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Get the username of the user
    public String getUsername() {
        return username;
    }

    // Get the password of the user
    public String getPassword() {
        return password;
    }
}