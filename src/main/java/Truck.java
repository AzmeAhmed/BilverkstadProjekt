public class Truck extends Vehicle {

    private int maxLoad;

    public Truck(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, boolean isElectric, int maxLoad) {
        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.maxLoad = maxLoad;
    }

    @Override
    public double calculateRepairCost(int hours) {
        double basePrice = hours * getBaseHourlyRate();

        double totalPrice = basePrice + (this.maxLoad * 500);

        return totalPrice;


    }
}
