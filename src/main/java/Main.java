package main.java;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

// Main class, all screens
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Store> stores = new ArrayList<Store>();
    private static ArrayList<User> users = new ArrayList<User>();
    private static int currentUserIndex = -1;
    private static int currentStoreIndex = -1;
    private static boolean isSetUp = false;
    private static boolean isExit = false;

    // main method, distribution system for all methods in Main
    public static void main(String[] args) {
        while (!isExit) {
            if (!isSetUp) {
                buildVehicles();
            } else if (currentUserIndex == -1) {
                currentStoreIndex = -1;
                loginScreen();
            } else if (currentStoreIndex == -1) {
                makeRandomPrices();
                selectStoreScreen();
            } else {
                storeScreen();
            }
        }
    }

    // display login screen
    public static void loginScreen() {
        System.out.println("\n-----Welcome To Vehicle Rental Manager-----");
        System.out.println("1. Log In");
        System.out.println("2. Create Account");
        System.out.println("3. Exit");
        System.out.println("Please Select an Option:");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                login();
                break;
            case "2":
                register();
                break;
            case "3":
                isExit = true;
                break;
            default:
                System.out.println("Error: Invalid Option, Please Try Again.");
                break;
        }
    }

    // display select store screen
    public static void selectStoreScreen() {
        System.out.println("\nWelcome " + users.get(currentUserIndex).getUsername() + "!");
        System.out.println("-----Please Select a Store-----");
        System.out.println("1. Store 1");
        System.out.println("2. Store 2");
        System.out.println("3. Store 3");
        System.out.println("4. Log Out");
        System.out.println("5. Exit");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                currentStoreIndex = 0;
                break;
            case "2":
                currentStoreIndex = 1;
                break;
            case "3":
                currentStoreIndex = 2;
                break;
            case "4":
                currentUserIndex = -1;
                break;
            case "5":
                isExit = true;
                break;
            default:
                System.out.println("Error: Invalid Option, Please Try Again.");
                break;
        }
    }

    // display the store screen
    public static void storeScreen() {
        System.out.println("\nWelcome " + users.get(currentUserIndex).getUsername() + " to Store" + (currentStoreIndex + 1) + "!");
        System.out.println("-----Your Current Rentals-----");
        stores.get(currentStoreIndex).getCurrentRents(users.get(currentUserIndex));
        System.out.println("-----Please Select an Option-----");
        System.out.println("1. Rent a Vehicle");
        System.out.println("2. Return a Vehicle");
        System.out.println("3. View All Avaliable Vehicles");
        System.out.println("4. Quit Store");
        System.out.println("5. Exit");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                rentVehicle();
                break;
            case "2":
                returnVehicle();
                break;
            case "3":
                stores.get(currentStoreIndex).listVehicles();
                break;
            case "4":
                currentStoreIndex = -1;
                break;
            case "5":
                isExit = true;
                break;
            default:
                System.out.println("Error: Invalid Option, Please Try Again.");
                break;
        }
    }

    // display the login option
    public static void login() {
        System.out.println("Username:");
        String user = scanner.nextLine();
        System.out.println("Password:");
        String pass = scanner.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user) && users.get(i).getPassword().equals(pass)) {
                currentUserIndex = i;
                return;
            }
        }
        System.out.println("Error: Invalid Username or Password!");
        return;
    }

    // display the register option
    public static void register() {
        System.out.println("Username:");
        String user = scanner.nextLine();
        System.out.println("Password:");
        String pass = scanner.nextLine();
        if (user.equals("") || pass.equals("")) System.out.println("Error: Username or Password Cannot be Empty!");
        users.add(new User(user, pass));
        System.out.println("Successfully Registered!");
        currentUserIndex = users.size() - 1;
    }

    // display the rent vehicle option
    public static void rentVehicle() {
        System.out.println("Please Enter the ID of the Vehicle You'd Like to Rent:");
        try {
            stores.get(currentStoreIndex).rentVehicle(Integer.parseInt(scanner.nextLine()), users.get(currentUserIndex));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please Enter a Valid ID");
        }
    }

    // display the return vehicle option
    public static void returnVehicle() {
        System.out.println("Please Enter the Model of the Vehicle You'd Like to Return:");
        String model = scanner.nextLine();
        System.out.println("Please Enter the Amount of Miles You Drove:");
        try {
            stores.get(currentStoreIndex).returnVehicle(model, users.get(currentUserIndex), Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please Enter a Valid Milage");
        }
    }

    // makes random prices for all vehicles in all stores
    public static void makeRandomPrices() {
        int randPriceRange = 20;
        for (Store store : stores) {
            store.makeRandomPrices(randPriceRange);
            randPriceRange += 20;
        }
    }

    // build all the vehicles for all the stores for testing
    public static void buildVehicles() {
        System.out.println("\nSetting Up Demo Build...");
        long start = System.currentTimeMillis();
        stores.addAll(Arrays.asList(new Store(), new Store(), new Store()));
        // store 1
        stores.get(0).addVehicle(new Car(2022, "Toyota Camry", 5, "Automatic", 41, "FWD"));
        stores.get(0).addVehicle(new Car(2020, "Honda Fit", 5, "Automatic", 43, "FWD"));
        stores.get(0).addVehicle(new Car(2019, "Ford Fusion", 5, "Automatic", 74, "FWD"));
        stores.get(0).addVehicle(new Car(2021, "Nissan Altima", 5, "Automatic", 51, "FWD"));
        stores.get(0).addVehicle(new Motorcycle(2022, "Harley Davidson 883", 2, "Manual", 249, "25.7 inch", "564 lb"));
        stores.get(0).addVehicle(new Motorcycle(2023, "Yamaha YZF-R3", 2, "Manual", 80, "30.7 inch", "375 lb"));
        stores.get(0).addVehicle(new Motorcycle(2022, "Honda Rebel 500", 2, "Manual", 85, "27.2 inch", "408 lb"));
        stores.get(0).addVehicle(new Motorcycle(2019, "Kawasaki Ninja 400", 2, "Manual", 193, "30.9 inch", "366 lb"));
        stores.get(0).addVehicle(new Truck(2021, "Ford F-150 Lariat", 5, "Automatic", 157, "65 inch", 4));
        stores.get(0).addVehicle(new Truck(2022, "Chevrolet Silverado", 5, "Automatic", 177, "81 inch", 4));
        stores.get(0).addVehicle(new Truck(2022, "Ram 1500 BigHorn", 5, "Automatic", 151, "66 inch", 4));
        stores.get(0).addVehicle(new Truck(2022, "Toyota Tacoma 2WD", 5, "Automatic", 120, "60 inch", 4));
        stores.get(0).addVehicle(new SuperCar(2018, "Ford Mustang gt500", 4, "Manual", 399, "RWD", "3.6s", "740"));
        stores.get(0).addVehicle(new SuperCar(2012, "Lexus LFA", 2, "Semi-Automatic", 1381, "RWD", "3.6s", "553"));
        stores.get(0).addVehicle(new SuperCar(2019, "Porsche 911 GT2 RS", 2, "Semi-Automatic", 1750, "RWD", "2.6s", "700"));
        stores.get(0).addVehicle(new SuperCar(2019, "Lamborghini Huracan", 2, "Semi-Automatic", 1550, "RWD", "2.5s", "630"));
        // store 2
        stores.get(1).addVehicle(new Car(2021, "Chevrolet Tahoe", 8, "Automatic", 136, "4WD"));
        stores.get(1).addVehicle(new Car(2023, "Toyota Corolla", 5, "Automatic", 42, "FWD"));
        stores.get(1).addVehicle(new Car(2019, "Ford Fusion", 5, "Automatic", 74, "FWD"));
        stores.get(1).addVehicle(new Car(2024, "Kia K5", 5, "Automatic", 56, "FWD"));
        stores.get(1).addVehicle(new Motorcycle(2022, "Ducati Scrambler 1100", 2, "Manual", 238, "31.9 inch", "403 lb"));
        stores.get(1).addVehicle(new Motorcycle(2023, "Suzuki SV650M3", 2, "Manual", 142, "30.9 inch", "432 lb"));
        stores.get(1).addVehicle(new Motorcycle(2022, "Honda Rebel 500", 2, "Manual", 85, "27.2 inch", "408 lb"));
        stores.get(1).addVehicle(new Motorcycle(2019, "Kawasaki Ninja 400", 2, "Manual", 193, "30.9 inch", "366 lb"));
        stores.get(1).addVehicle(new Truck(2019, "GMC Sierra 1500", 5, "Automatic", 134, "68 inch", 4));
        stores.get(1).addVehicle(new Truck(2024, "Nissan Titan", 5, "Automatic", 153, "78 inch", 4));
        stores.get(1).addVehicle(new Truck(2021, "Honda Ridgeline Sport", 5, "Automatic", 124, "75 inch", 4));
        stores.get(1).addVehicle(new Truck(2022, "Jeep Gladiator Sport S", 5, "Automatic", 122, "72 inch", 4));
        stores.get(1).addVehicle(new SuperCar(2019, "Ferrari 488 Pista", 4, "Semi-Automatic", 1595, "RWD", "2.9s", "710"));
        stores.get(1).addVehicle(new SuperCar(2021, "Mclaren 720s", 2, "Semi-Automatic", 1995, "RWD", "2.5s", "710"));
        stores.get(1).addVehicle(new SuperCar(2023, "Chevrolet Corvette C8", 2, "Semi-Automatic", 750, "RWD", "2.6s", "670"));
        stores.get(1).addVehicle(new SuperCar(2019, "Lamborghini Huracan", 2, "Semi-Automatic", 1550, "AWD", "2.5s", "630"));
        // store 3
        stores.get(2).addVehicle(new Car(2020, "Chevrolet Spark", 5, "Automatic", 33, "FWD"));
        stores.get(2).addVehicle(new Car(2023, "BMW 3 Series", 5, "Automatic", 133, "AWD"));
        stores.get(2).addVehicle(new Car(2024, "Mercedes-Benz C-class", 5, "Automatic", 181, "AWD"));
        stores.get(2).addVehicle(new Car(2024, "Kia K5", 5, "Automatic", 56, "FWD"));
        stores.get(2).addVehicle(new Motorcycle(2021, "BMW G310R", 2, "Manual", 202, "30.9 inch", "349 lb"));
        stores.get(2).addVehicle(new Motorcycle(2023, "Triumph Street Twin 900", 2, "Manual", 134, "30.1 inch", "437 lb"));
        stores.get(2).addVehicle(new Motorcycle(2023, "KTM 390 Adventure", 2, "Manual", 130, "33.6 inch", "329 lb"));
        stores.get(2).addVehicle(new Motorcycle(2024, "Indian Scout Bobber 60", 2, "Manual", 247, "25.6 inch", "553 lb"));
        stores.get(2).addVehicle(new Truck(2023, "Ford Ranger XL", 5, "Automatic", 509, "69 inch", 4));
        stores.get(2).addVehicle(new Truck(2020, "Chevrolet Colorado LT", 5, "Automatic", 88, "78 inch", 4));
        stores.get(2).addVehicle(new Truck(2021, "Honda Ridgeline Sport", 5, "Automatic", 124, "75 inch", 4));
        stores.get(2).addVehicle(new Truck(2022, "Jeep Gladiator Sport S", 5, "Automatic", 122, "72 inch", 4));
        stores.get(2).addVehicle(new SuperCar(2022, "Lamborghini SVJ", 4, "Semi-Automatic", 3995, "AWD", "2.8s", "770"));
        stores.get(2).addVehicle(new SuperCar(2021, "Ferrari 812 Superfast", 2, "Semi-Automatic", 1990, "RWD", "2.8s", "611"));
        stores.get(2).addVehicle(new SuperCar(2023, "Chevrolet Corvette C8", 2, "Semi-Automatic", 750, "RWD", "2.6s", "670"));
        stores.get(2).addVehicle(new SuperCar(2019, "Audi R8 V10", 2, "Semi-Automatic", 995, "AWD", "3.2s", "611"));
        // make randon prices for vehicles
        makeRandomPrices();

        long end = System.currentTimeMillis();
        long executionTime = end - start;
        isSetUp = true;
        if (executionTime == 1) System.out.println("Successfully Set Up Demo in " + executionTime + " Millisecond!");
        else System.out.println("Successfully Loaded Demo in " + executionTime + " Milliseconds!");
    }
}