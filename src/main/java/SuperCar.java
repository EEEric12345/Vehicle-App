package main.java;

// supercar class, stores more information for supercars
public class SuperCar extends Car {
    private String horsePower;
    private String accleration;

    // constructor
    public SuperCar(int year, String model, int seats, String transmission, double estimatedRentPrice, String horsePower, String accleration, String driveTrain) {
        super(year, model, seats, transmission, estimatedRentPrice, driveTrain);
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
        //System.out.printf("%-5s%-10s%-15s%-25s%-10s%-15s%-15s%-15s%-15s%-20s%-20s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "DRIVE TRAIN", "TRANSMISSION", "ACCLERAION", "HORSE POWER", "EST. RENT PRICE/DAY", "RENT PRICE/DAY");
        System.out.printf("%-10i%-15s%-25s%-10i%-15s%-15s%-15s%-15s%-20d%-20d\n", getYear(), getVehicleType(), getModel(), getSeats(), getDriveTrain(), getTransmission(), getAccleration(), getHorsePower(), getEstimatedRentPrice(), getRentPrice());
    }
}
