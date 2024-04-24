package main.java;

// supercar class, stores more information for supercars
public class SuperCar extends Vehicle {
    private String horsePower;
    private String accleration;

    // constructor
    public SuperCar(int year, String model, int seats, String transmission, double estimatedRentPrice, String horsePower, String accleration) {
        super(year, model, seats, transmission, estimatedRentPrice);
        this.horsePower = horsePower;
        this.accleration = accleration;
        
    }
    
    // get the horse power of the supercar
    public String getHorsePower() {
        return horsePower;
    }

    // get the 60 mile accleration of the supercar
    public String getAccleration() {
        return accleration;
    }

    // gets the type of the supercar
    @Override
    public String getVehicleType() {
        return "SuperCar";
    }

    // list all the information of a supercar
    @Override
    public void listInfo() {
        //System.out.printf("%-10s%-25s%-25s%-10s%-15s%-15s%-15s%-15s%-15s%-15s\n", "YEAR", "TYPE", "MODEL", TRAIN", "TRANSMISSION", "Horse Power", "Accleration", "EST. RENT PRICE", "RENT PRICE");
        System.out.printf("%-10i%-25s%-25s%-10i%-15s%-15s%-15s%-15d%-15d\n", getYear(), getVehicleType(), getModel(), getSeats(), getTransmission(), getHorsePower(), getAccleration(), getEstimatedRentPrice(), getRentPrice());
    }
}
