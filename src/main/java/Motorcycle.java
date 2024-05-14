package main.java;

// motorcycle class, stores more information for motorcycles
public class Motorcycle extends Vehicle {
    private String weight;
    private String seatHeight;

    // constructor
    public Motorcycle(int year, String model, int seats, String transmission, double estimatedRentPrice, String seatHeight, String weight) {
        super(year, model, seats, transmission, estimatedRentPrice);
        this.weight = weight;
        this.seatHeight = seatHeight;
        
    }
    
    // get the seat height of the motorcycle
    public String getSeatHeight() {
        return seatHeight;
    }

    // get the weight of the motorcycle
    public String getWeight() {
        return weight;
    }

    // gets the type of the motorcycle
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }

    // list all the information of a motorcycle
    @Override
    public void listInfo() {
        //System.out.printf("%-5s%-10s%-15s%-25s%-10s%-10s%-15s%-15s%-20s%-20s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "WEIGHT", "SEAT HEIGHT", "TRANSMISSION", "EST. RENT PRICE/DAY", "RENT PRICE/DAY");
        System.out.printf("%-10i%-15s%-25s%-10i%-10s%-15s%-15s%-20d%-20d\n", getYear(), getVehicleType(), getModel(), getSeats(), getWeight(), getSeatHeight(), getVehicleType(), getTransmission(), getEstimatedRentPrice(), getRentPrice());
    }
}
