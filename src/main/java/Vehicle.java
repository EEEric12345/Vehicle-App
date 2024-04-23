package main.java;


// parent class, stores basic information for all types of vehicles
public class Vehicle {
    private int year;
    private String model;
    private int milage;
    private int seats;
    private double estimatedRentPrice;
    private double rentPrice;

    // constructor
    public Vehicle(int year, String model, int seats, double estimatedRentPrice) {
        this.year = year;
        this.model = model;
        this.milage = 0;
        this.seats = seats;
        this.estimatedRentPrice = estimatedRentPrice;
        rentPrice = 0.0;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public int getMilage() {
        return milage;
    }

    public int getSeats() {
        return seats;
    }

    public double getEstimatedRentPrice() {
        return estimatedRentPrice;
    }

    public String getVehicleType() {
        return "Vehicle";
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void addMilage(int mile) {
        milage += mile;
        System.out.println("Successfully added " + mile + " miles to " + year + " " + model);
    }

    public void setMilage(int mile) {
        this.milage = mile;
        System.out.println("Successfully set the milage of " + year + " " + model + " to " + milage);
    }

    public void setRentPrice(double price) {
        this.rentPrice = price;
        System.out.println("Successfully set the rent price of " + year + " " + model + " to " + rentPrice);
    }


    public void listInfo() {
        //System.out.printf("%-10s%-25s%-25s%-10s%-15s%-15s\n", "YEAR", "TYPE", "MODEL", "SEATS", "EST. RENT PRICE", "RENT PRICE");
        System.out.printf("%-10i%-25s%-25s%-10i%-15d%-15d\n", year, "Vehicle", model, seats, estimatedRentPrice, rentPrice);
    }
}
