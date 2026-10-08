import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        WorkshopManager manager = new WorkshopManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("VERKSTADENS MENY");
            System.out.println("1. Lämna in fordon");
            System.out.println("2. Visa alla fordon");
            System.out.println("3. Reparera fordon");
            System.out.println("4. Visa statistik (Totalkostnad)");
            System.out.println("5. Avsluta");
            System.out.println("Välj ett alternativ (1-5):");

            int choice = 0;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Fel! Skriv en siffra");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("1. Bil | 2.Lastbil | 3.MC : ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Reg nr");
                    String reg = scanner.nextLine();
                    System.out.println("Märke");
                    String brand = scanner.nextLine();


                    if (type == 1) {
                        System.out.println("Dörrar: ");
                        manager.addVehicle(new Car(reg, brand, scanner.nextInt()));
                    } else if (type == 2) {
                        System.out.println("Max lastvikt: ");
                        manager.addVehicle(new Truck(reg, brand, scanner.nextDouble()));

                    } else if (type == 3) {
                        System.out.println("Sidovagn (Sant/Falskt: )");
                        manager.addVehicle(new Motorcycle(reg, brand, scanner.nextBoolean()));
                    }
                    scanner.nextLine();
                    System.out.println("sparat");
                    break;

                case 2:
                    for (Vehicle vehicle : manager.getAllVehicles()) {
                        System.out.println(vehicle);
                    }
                    break;
                case 3:
                    System.out.println("Reg nr: ");
                    Vehicle found = manager.findVehicle(scanner.nextLine());
                    if (found != null) {
                        System.out.println("Kostnad: " + found.calculateRepairCost() + "kr");
                    } else {
                        System.out.println("Hittades inte");
                    }
                    break;
                case 4:
                    System.out.println("Totalkostnad" + manager.calculateTotalRepairCost() + "kr");
                    break;

                case 5:
                    System.out.println("Ange registreringsbnummer");
                    String searchReg = scanner.nextLine();
                    Vehicle foundVehicle = manager.findVehicle(searchReg);

                    if (foundVehicle != null) {
                        if (foundVehicle instanceof Serviceable) {
                            Serviceable serviceableVehicle = (Serviceable) foundVehicle;
                        } else {
                            System.out.println("fordonet kan inte repareras");
                        }
                    } else {
                        System.out.println("Fordonet hittades inte i verkstaden");
                    }
                    break;


                case 6:
                    running = false;
                    System.out.println("programmet avslutas");
                    break;
                default:
                    System.out.println("felaktigt val välj mellan (1-6) ");
                    break;
            }

        }

    }
}






