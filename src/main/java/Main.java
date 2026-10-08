import java.util.InputMismatchException;
import java.util.Scanner;

// User Interface layer - Kept intentionally simple and detached from business logic
public class Main {
    public static void main(String[] args) {
        WorkshopManager manager = new WorkshopManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- VERKSTADENS MENY ---");
            System.out.println("1. Lämna in fordon");
            System.out.println("2. Visa alla fordon");
            System.out.println("3. Reparera fordon (Beräkna kostnad)");
            System.out.println("4. Visa statistik (Totalkostnad)");
            System.out.println("5. Utför diagnostik");
            System.out.println("6. Avsluta");
            System.out.print("Välj ett alternativ (1-6): ");

            int choice = 0;

            // Exception Handling: Catching incorrect input scanner data to prevent application crash
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Fel! Skriv en siffra.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Välj typ (1. Bil | 2. Lastbil | 3. MC): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Registreringsnummer: ");
                    String reg = scanner.nextLine();
                    System.out.print("Märke: ");
                    String brand = scanner.nextLine();
                    System.out.print("Modell: ");
                    String model = scanner.nextLine();
                    System.out.print("Tillverkningsår (2000-2026): ");
                    int year = scanner.nextInt();
                    System.out.print("Timpris (double): ");
                    double rate = scanner.nextDouble();
                    scanner.nextLine();

                    // Instantiating specific objects using matching variables
                    if (type == 1) {
                        System.out.print("Är det en elbil? (true/false): ");
                        boolean isElectric = scanner.nextBoolean();
                        manager.addVehicle(new Car(reg, brand, model, year, rate, false, isElectric));
                    } else if (type == 2) {
                        System.out.print("Max lastvikt (kg): ");
                        int maxLoad = scanner.nextInt();
                        manager.addVehicle(new Truck(reg, brand, model, year, rate, false, maxLoad));
                    } else if (type == 3) {
                        System.out.print("Motorstorlek (cc): ");
                        int cc = scanner.nextInt();
                        manager.addVehicle(new Motorcycle(reg, brand, model, year, rate, false, cc));
                    }
                    scanner.nextLine();
                    System.out.println("Fordonet har sparats framgångsrikt!");
                    break;

                case 2:
                    System.out.println("\n--- Alla fordon i verkstaden ---");
                    if (manager.getAllVehicles().isEmpty()) {
                        System.out.println("Inga fordon inlämnade.");
                    }
                    for (Vehicle vehicle : manager.getAllVehicles()) {
                        System.out.println("Regnr: " + vehicle.getRegNumber() + " | " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    break;

                case 3:
                    System.out.print("Ange regnr för fordonet: ");
                    Vehicle found = manager.findVehicle(scanner.nextLine());
                    if (found != null) {
                        System.out.print("Ange antal beräknade reparationstimmar: ");
                        int hours = scanner.nextInt();
                        scanner.nextLine();
                        // Polymorphic execution through dynamic dispatch
                        System.out.println("Kostnad: " + found.calculateRepairCost(hours) + " kr");
                    } else {
                        System.out.println("Fordonet hittades inte.");
                    }
                    break;

                case 4:
                    System.out.println("Total beräknad kostnad för alla fordon: " + manager.calculateTotalRepairCost() + " kr");
                    break;

                case 5:
                    System.out.print("Ange registreringsnummer för diagnostik: ");
                    String searchReg = scanner.nextLine();
                    Vehicle foundVehicle = manager.findVehicle(searchReg);

                    if (foundVehicle != null) {
                        // Checking interface capabilities using 'instanceof' before casting types safely
                        if (foundVehicle instanceof Serviceable) {
                            Serviceable serviceableVehicle = (Serviceable) foundVehicle;
                            serviceableVehicle.performDiagnostic();
                        } else {
                            System.out.println("Detta fordon stödjer inte elektronisk diagnostik (ej Serviceable).");
                        }
                    } else {
                        System.out.println("Fordonet hittades inte i verkstaden.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Programmet avslutas. Tack för idag!");
                    break;

                default:
                    System.out.println("Felaktigt val, välj mellan (1-6).");
                    break;
            }
        }
        scanner.close();
    }
}
