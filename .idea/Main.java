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
        }

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Fel! Skriv en siffra");
                scanner.next();
                continue;

            }

        }
    }
}



