package main.java;

// car class, stores more information for cars
public class Car extends Vehicle {
    private String driveTrain;

    // constructor
    public Car(int year, String model, int seats, String transmission, double estimatedRentPrice, String driveTrain) {
        super(year, model, seats, transmission, estimatedRentPrice);
        this.driveTrain = driveTrain;
        
    }
    
    // get the drive train of the car
    public String getDriveTrain() {
        return driveTrain;
    }

    // gets the type of the car
    @Override
    public String getVehicleType() {
        return "Car";
    }

    // list all the information of a car
    @Override
    public void listInfo() {
        //System.out.printf("%-10s%-25s%-25s%-10s%-15s%-15s%-15s%-15s\n", "YEAR", "TYPE", "MODEL", "SEATS", "DRIVE TRAIN" "TRANSMISSION", "EST. RENT PRICE", "RENT PRICE");
        System.out.printf("%-10i%-25s%-25s%-10i%-15s%-15d%-15d\n", getYear(), getVehicleType(), getModel(), getSeats(), getDriveTrain(), getTransmission(), getEstimatedRentPrice(), getRentPrice());
    }
}
