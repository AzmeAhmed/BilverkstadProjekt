import java.util.ArrayList;

// Data controller separating database logic from the presentation layer (Main menu)
public class WorkshopManager {
    // Arraylist showcasing Subtype Polymorphism (Stores mixed subclasses as common Vehicle type)
    private ArrayList<Vehicle> vehicles;

    public WorkshopManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Linear search utility using object identification fields
    public Vehicle findVehicle(String regNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegNumber().equalsIgnoreCase(regNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    // Dynamic Method Invocation: Polymorphically calling the correct subclass calculation method
    public double calculateTotalRepairCost(int hours) {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateRepairCost(hours);
        }
        return total;
    }
}

