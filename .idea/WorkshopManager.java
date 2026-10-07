import java.util.ArrayList;

public class WorkshopManager {
    private ArrayList<Vehicle> vehicles;

    public WorkshopManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }


    public Vehicle findvehicle(String regNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegNumber().equals(regNumber)) {
                return vehicle;
            }
        }

        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public double calculateTotalRepairCost() {
        double total = 0;

        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateTotalRepairCost();
            }

            return total;

    }
}








