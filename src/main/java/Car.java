// Concrete subclass extending Vehicle and implementing the Serviceable interface contract
public class Car extends Vehicle implements Serviceable {
    private boolean isElectric; // Subclass-specific field

    // Constructor passing core attributes to parent constructor using 'super'
    public Car(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, boolean isElectric) {
        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.isElectric = isElectric;
    }

    // Method Overriding: Specialized polymorphic implementation for calculating cost
    @Override
    public double calculateRepairCost(int hours) {
        double basePrice = hours * getBaseHourlyRate();
        if (isElectric) {
            basePrice = basePrice * 1.50; // 50% electric vehicle surcharge
        }
        return basePrice;
    }

    // Fulfilling the interface contract behavior
    @Override
    public void performDiagnostic() {
        System.out.println("Kör fullständig elektronisk och batteribaserad diagnostikscan på bilen...");
    }
}
