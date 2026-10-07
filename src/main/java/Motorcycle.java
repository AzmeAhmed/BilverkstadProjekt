public class Motorcycle extends Vehicle {

    private int engineCc;

    public Motorcycle(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired, int engineCc) {


        super(regNumber, make, model, yearBuilt, baseHourlyRate, isRepaired);
        this.engineCc = engineCc;

    }
}
