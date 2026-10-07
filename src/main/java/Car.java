public class Car extends Vehicle {

    private boolean isElectric;

    public Car(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, boolean isElectric) {
        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.isElectric = isElectric;
    }

    @Override
    public double calculateRepairCost(int hours) {
        // Calculate initial cost using the base hourly rate from the parent class
        double basePrice = hours * getBaseHourlyRate();


        // Apply a 15% electric vehicle premium if applicable
        if (isElectric) {
            basePrice = basePrice * 1.15;
        }

        return basePrice;
    }
}
