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
        System.out.println("Successfully added " + mile + " miles to " + year + " " + model);
    }

    // set the milage of the vehicle
    public void setMilage(int mile) {
        this.milage = mile;
        System.out.println("Successfully set the milage of " + year + " " + model + " to " + milage);
    }

    // set the rent price of the vehicle
    public void setRentPrice(double price) {
        this.rentPrice = price;
        System.out.println("Successfully set the rent price of " + year + " " + model + " to " + rentPrice);
    }

    // list all the information of a vehicle
    public void listInfo() {
        //System.out.printf("%-10s%-25s%-25s%-10s%-15s%-15s%-15s\n", "YEAR", "TYPE", "MODEL", "SEATS", "TRANSMISSION", "EST. RENT PRICE", "RENT PRICE");
        System.out.printf("%-10i%-25s%-25s%-10i%-15d%-15d\n", getYear(), "Vehicle", getModel(), getSeats(), getTransmission(), getEstimatedRentPrice(), getRentPrice());
    }
}
