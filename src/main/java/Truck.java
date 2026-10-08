public abstract class Truck extends Vehicle {

    private int maxLoad;

    public Truck(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, boolean isElectric, int maxLoad) {
        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.maxLoad = maxLoad;
    }

    @Override
    public double calculateRepairCost(int hours) {
        // Calculate initial cost based on hours and the base hourly rate
        double basePrice = hours * getBaseHourlyRate();

        // Add an extra flat fee of 500 kr per ton based on max load capacity
        double totalPrice = basePrice + (this.maxLoad * 500);

        return totalPrice;
    }
}