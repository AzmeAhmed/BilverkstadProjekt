public class Motorcycle extends Vehicle {

    private int engineCc;

    public Motorcycle(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, int engineCc) {


        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.engineCc = engineCc;


    }
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
