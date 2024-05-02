package main.java;

// Rent class, stores rent statues of a vehicle in a store
public class Rent {
    private Vehicle vehicle;
    private boolean statues;
    private User user;

    // Constructor
    public Rent(Vehicle vehicle) {
        this.vehicle = vehicle;
        statues = false;
        user = null;
    }

    // Get the vehicle stored
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Get the rent statues of the vehicle
    public boolean getStatues() {
        return statues;
    }

    // Set the rent statues of the vehicle
    public void setStatues(boolean statues) {
        this.statues = statues;
    }

    // Get the current user who rented the vehicle
    public User getUser() {
        return user;
    }

    // Set the current user
    public void setUser(User user) {
        this.user = user;
    }

    // Remove a current user
    public void setUser() {
        this.user = null;
    }
}
