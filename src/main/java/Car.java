public class Car extends Vehicle {

    private boolean isElectric;

    public Car(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, boolean isElectric) {
        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.isElectric = isElectric;
    }


    @Override
    public double calculateRepairCost(int hours) {
        double basePrice = hours * getBaseHourlyRate();

        if (isElectric) {
            basePrice = basePrice * 1.15;
        }

        return basePrice;
    }
}
