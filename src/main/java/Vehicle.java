// Abstract superclass demonstrating Inheritance and Encapsulation
public abstract class Vehicle {
    // Private fields to restrict direct access (Encapsulation)
    private String regNumber;
    private String make;
    private String model;
    private int yearBuilt;
    private double baseHourlyRate;
    private boolean isRepaired;

    // Constructor with built-in validation checks (Data validation logic)
    public Vehicle(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired) {
        if (regNumber == null || regNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty.");
        }
        if (yearBuilt < 2000 || yearBuilt > 2026) {
            throw new IllegalArgumentException("Manufacturing year must be between 2000 and 2026.");
        }
        this.regNumber = regNumber;
        this.make = make;
        this.model = model;
        this.yearBuilt = yearBuilt;
        this.baseHourlyRate = baseHourlyRate;
        this.isRepaired = isRepaired;
    }

    // Abstract method signature for polymorphic cost calculations in subclasses
    public abstract double calculateRepairCost(int hours);

    // Getters and Setters ensuring safe access to encapsulated data
    public String getRegNumber() { return regNumber; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYearBuilt() { return yearBuilt; }
    public double getBaseHourlyRate() { return baseHourlyRate; }
    public boolean isRepaired() { return isRepaired; }
    public void setRepaired(boolean repaired) { this.isRepaired = repaired; }
}

