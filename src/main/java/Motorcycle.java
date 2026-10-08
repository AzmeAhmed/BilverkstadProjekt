// Concrete subclass extending Vehicle (Non-abstract to allow instantiation)
public class Motorcycle extends Vehicle {
    private int engineCc; // Subclass-specific field

    public Motorcycle(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, int engineCc) {
        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.engineCc = engineCc;
    }

    // Method Overriding: Custom calculation logic for engine displacement limits
    @Override
    public double calculateRepairCost(int hours) {
        double basePrice = hours * getBaseHourlyRate();
        if (this.engineCc > 600) {
            basePrice = basePrice + 250;
        }
        return basePrice;
    }

    public int getEngineCc() {
        return this.engineCc;
    }
}

