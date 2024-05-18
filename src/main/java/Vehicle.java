package main.java;

// parent class, stores basic information for all types of vehicles
public class Vehicle {
    private int year;
    private String model;
    private int milage;
    private int seats;
    private double estimatedRentPrice;
    private double rentPrice;
    private String transmission;

    // constructor
    public Vehicle(int year, String model, int seats, String transmission, double estimatedRentPrice) {
        this.year = year;
        this.model = model;
        this.milage = 0;
        this.seats = seats;
        this.transmission = transmission;
        this.estimatedRentPrice = estimatedRentPrice;
        rentPrice = 0.0;
    }

    // get the year of the vehicle
    public int getYear() {
        return year;
    }

    // get the model of the vehicle
    public String getModel() {
        return model;
    }

    // get the milage of the vehicle
    public int getMilage() {
        return milage;
    }

    // get the number of seats of the vehicle
    public int getSeats() {
        return seats;
    }

    // get the estimated rent price of the vehicle
    public double getEstimatedRentPrice() {
        return estimatedRentPrice;
    }

    // get the type of vehicle
    public String getVehicleType() {
        return "Vehicle";
    }

    // get the rent price of the vehicle
    public double getRentPrice() {
        return rentPrice;
    }

    // Get the type of transmission of the vehicle
    public String getTransmission() {
        return transmission;
    }

    // add milage to the vehicle
    public void addMilage(int mile) {
        milage += mile;
    }

    // set the rent price of the vehicle
    public void setRentPrice(double price) {
        this.rentPrice = price;
    }

    // set a random price with a given range
    public void setRandomPrice(int range) {
        rentPrice = (getEstimatedRentPrice() - range) + (Math.random() * range * 2);
        if (rentPrice < 0) rentPrice = 0;
        if (rentPrice < 30) rentPrice += range / 4;
    }

    // list all the information of a vehicle
    public void listInfo() {
        //System.out.printf("%-10s%-25s%-25s%-10s%-15s%-25s%-25s\n", "YEAR", "TYPE", "MODEL", "SEATS", "TRANSMISSION", "EST. RENT PRICE", "RENT PRICE");
        System.out.printf("%-10d%-25s%-25s%-10d%-25f%-25f\n", getYear(), "Vehicle", getModel(), getSeats(), getTransmission(), getEstimatedRentPrice(), getRentPrice());
    }
}
