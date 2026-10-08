// Concrete subclass demonstrating Method Overriding and Inheritance
public class Truck extends Vehicle implements Serviceable {
    private int maxLoad; // Subclass-specific field

    public Truck(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, int maxLoad) {
        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.maxLoad = maxLoad;
    }

    // Method Overriding: Specialized calculation based on vehicle type criteria
    @Override
    public double calculateRepairCost(int hours) {
        double basePrice = hours * getBaseHourlyRate();
        return basePrice + (this.maxLoad * 500);
    }

    @Override
    public void performDiagnostic() {
        System.out.println("Kontrollerar hydrauliksystem och tunga mekaniska komponenter på lastbilen...");
    }
}
