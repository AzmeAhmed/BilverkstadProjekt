public abstract class Vehicle {
    // Encapsulated data fields for the vehicle properties
    private String regNumber;
    private String make;
    private String model;
    private int yearBuilt;
    private double baseHourlyRate;
    private boolean isRepaired;

    public Vehicle(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired) {

        // Validation: Reg number cannot be empty
        if (regNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty");
        }

        // Validation: Year must be between 2000 and 2026
        if (yearBuilt < 2000 || yearBuilt > 2026) {
            throw new IllegalArgumentException("Manufacturing year of the Vehicles must be between 2000 and 2026");
        }

        this.regNumber = regNumber;
        this.make = make;
        this.model = model;
        this.yearBuilt = yearBuilt;
        this.baseHourlyRate = baseHourlyRate;
        this.isRepaired = isRepaired;
    }

    // Getters and Setters for data access
    public String getRegNumber() { return regNumber; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYearBuilt() { return yearBuilt; }
    public double getBaseHourlyRate() { return baseHourlyRate; }
    public boolean isRepaired() { return isRepaired; }

    // Setter to update the status when the vehicle is fixed
    public void setRepaired(boolean repaired) { isRepaired = repaired; }

    // Abstract method for polymorphic cost calculation in subclasses
    public abstract double calculateRepairCost(int hours);
}

