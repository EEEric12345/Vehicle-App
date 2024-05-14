package main.java;
import java.util.ArrayList;

// Store class, stores all avaliable vehicles in a store
public class Store {
    private ArrayList<Rent> rents;

    // Constructor
    public Store() {
        rents = new ArrayList<Rent>();
    }

    // add a vehicle to the store
    public void addVehicle(Vehicle vehicle) {
        rents.add(new Rent(vehicle));
    }

    // rent out a vehicle from the store
    public void rentVehicle(int index, User user) {
        if (index >= rents.size()) {
            System.out.println("Error: Vehicle Not Found. Please Try Again!");
            return;
        }
        rents.get(index).setStatues(true);
        rents.get(index).setUser(user);
        System.out.println("Successfully Rented " + rents.get(index).getVehicle().getYear() + " " + rents.get(index).getVehicle().getModel() + "!");
    }

    // return a vehicle to the store
    public void returnVehicle(String model, User user, int mile) {
        for (Rent rent : rents) {
            if (rent.getVehicle().getModel().equals(model) && rent.getStatues() && rent.getUser().equals(user)) {
                rent.getVehicle().addMilage(mile);
                rent.setStatues(false);
                rent.setUser();
                System.out.println("Successfully Returned " + rent.getVehicle().getYear() + " " + rent.getVehicle().getModel() + "!");
                return;
            }
        }
        System.out.println("Error: Vehicle Not Found. Please Try Again!");
    }

    // lists the vehicles a user rented
    public void getCurrentRents(User user) {
        boolean isRent = false;
        for (Rent rent : rents) {
            if (rent.getUser().equals(user)) {
                if (!isRent) {
                    isRent = true;
                    System.out.printf("%-5s%-20s\n", "YEAR", "MODEL");
                }
                System.out.println(rent.getVehicle().getYear() + " " + rent.getVehicle().getModel());
            }
        }
        if (!isRent) {
            System.out.println("You Currently Have No Rents in this Store");
        }
    }

    // list all vehicles in the store(not rented out)
    public void listVehicles() {
        boolean onCar = false;
        boolean onMotorcycle = false;
        boolean onSuperCar = false;
        boolean onTruck = false;
        for (int i = 0; i < rents.size(); i++) {
            if (rents.get(i).getStatues() == false) {
                if (rents.get(i).getVehicle().getVehicleType().equals("Car")) {
                    if (onCar == false) {
                        System.out.println("\n-----Cars-----");
                        System.out.printf("%-5s%-10s%-15s%-25s%-10s%-15s%-15s%-20s%-20s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "DRIVE TRAIN", "TRANSMISSION", "EST. RENT PRICE/DAY", "RENT PRICE/DAY");
                        onCar = true;
                    }
                    System.out.printf("%-5i", i);
                    rents.get(i).getVehicle().listInfo();
                }
                if (rents.get(i).getVehicle().getVehicleType().equals("Motorcycle")) {
                    if (onMotorcycle == false) {
                        System.out.println("-".repeat(150));
                        System.out.println("\n-----Motorcycles-----");
                        System.out.printf("%-5s%-10s%-15s%-25s%-10s%-10s%-15s%-15s%-20s%-20s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "WEIGHT", "SEAT HEIGHT", "TRANSMISSION", "EST. RENT PRICE/DAY", "RENT PRICE/DAY");
                        onMotorcycle = true;
                    }
                    System.out.printf("%-5i", i);
                    rents.get(i).getVehicle().listInfo();
                }
                if (rents.get(i).getVehicle().getVehicleType().equals("SuperCar")) {
                    if (onSuperCar == false) {
                        System.out.println("-".repeat(150));
                        System.out.println("\n-----Super Cars-----");
                        System.out.printf("%-5s%-10s%-15s%-25s%-10s%-15s%-15s%-15s%-15s%-20s%-20s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "DRIVE TRAIN", "TRANSMISSION", "ACCLERAION", "HORSE POWER", "EST. RENT PRICE/DAY", "RENT PRICE/DAY");
                        onSuperCar = true;
                    }
                    System.out.printf("%-5i", i);
                    rents.get(i).getVehicle().listInfo();
                }
                if (rents.get(i).getVehicle().getVehicleType().equals("Truck")) {
                    if (onTruck == false) {
                        System.out.println("-".repeat(150));
                        System.out.println("\n-----Trucks-----");
                        System.out.printf("%-5s%-10s%-15s%-25s%-10s%-10s%-15s%-15s%-20s%-20s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "DOORS", "BED LENGTH", "TRANSMISSION", "EST. RENT PRICE/DAY", "RENT PRICE/DAY");
                        onTruck = true;
                    }
                    System.out.printf("%-5i", i);
                    rents.get(i).getVehicle().listInfo();
                }
            }
        }
    }
}

