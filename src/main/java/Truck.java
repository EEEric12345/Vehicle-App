package main.java;

// truck class, stores more information for trucks
public class Truck extends Vehicle {
    private String bedLength;
    private int doors;

    // constructor
    public Truck(int year, String model, int seats, String transmission, double estimatedRentPrice, String bedLength, int doors) {
        super(year, model, seats, transmission, estimatedRentPrice);
        this.bedLength = bedLength;
        this.doors = doors;
        
    }
    
    // get the bed length of the truck
    public String getBedLength() {
        return bedLength;
    }

    // get the numbers of doors of the truck
    public int getDoors() {
        return doors;
    }

    // gets the type of the truck
    @Override
    public String getVehicleType() {
        return "Truck";
    }

    // list all the information of a truck
    @Override
    public void listInfo() {
        //System.out.printf("%-5s%-10s%-15s%-25s%-10s%-10s%-15s%-15s%-20s%-20s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "DOORS", "BED LENGTH", "TRANSMISSION", "EST. RENT PRICE/DAY", "RENT PRICE/DAY");
        System.out.printf("%-10d%-15s%-25s%-10d%-10d%-15s%-15s%-20f%-20f\n", getYear(), getVehicleType(), getModel(), getSeats(), getDoors(), getBedLength(), getTransmission(), getEstimatedRentPrice(), getRentPrice());
    }
}
