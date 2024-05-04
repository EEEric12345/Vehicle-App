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
    }

    // lists the vehicles a user rented
    public void getCurrentRents(User user) {
        System.out.printf("%-5s%-20s\n", "YEAR", "MODEL");
        for (Rent rent : rents) {
            if (rent.getUser().equals(user)) {
                System.out.println(rent.getVehicle().getYear() + " " + rent.getVehicle().getModel());
            }
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
                        System.out.println("-----Cars-----");
                        onCar = true;
                    }
                    System.out.printf("%-5s%-10s%-25s%-25s%-10s%-15s%-15s%-15s%-15s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "DRIVE TRAIN", "TRANSMISSION", "EST. RENT PRICE", "RENT PRICE");
                    System.out.printf("%-5i", i);
                    rents.get(i).getVehicle().listInfo();
                }
                if (rents.get(i).getVehicle().getVehicleType().equals("Motorcycle")) {
                    if (onMotorcycle == false) {
                        System.out.println("\n-----Motorcycles-----");
                        onMotorcycle = true;
                    }
                    System.out.printf("%-5s%-10s%-25s%-25s%-10s%-10s%-15s%-15s%-15s%-15s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "WEIGHT", "SEAT HEIGHT", "TRANSMISSION", "EST. RENT PRICE", "RENT PRICE");
                    System.out.printf("%-5i", i);
                    rents.get(i).getVehicle().listInfo();
                }
                if (rents.get(i).getVehicle().getVehicleType().equals("SuperCar")) {
                    if (onSuperCar == false) {
                        System.out.println("\n-----Super Cars-----");
                        onSuperCar = true;
                    }
                    System.out.printf("%-5s%-10s%-25s%-25s%-10s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "YEAR", "TYPE", "MODEL", "TRAIN", "TRANSMISSION", "Horse Power", "Accleration", "EST. RENT PRICE", "RENT PRICE");
                    System.out.printf("%-5i", i);
                    rents.get(i).getVehicle().listInfo();
                }
                if (rents.get(i).getVehicle().getVehicleType().equals("Truck")) {
                    if (onTruck == false) {
                        System.out.println("\n-----Trucks-----");
                        onTruck = true;
                    }
                    System.out.printf("%-5s%-10s%-25s%-25s%-10s%-10s%-15s%-15s%-15s%-15s\n", "ID", "YEAR", "TYPE", "MODEL", "SEATS", "DOORS", "BED LENGTH", "TRANSMISSION", "EST. RENT PRICE", "RENT PRICE");
                }
            }
        }
    }
}

