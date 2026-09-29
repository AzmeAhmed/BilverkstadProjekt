public class Vehicle {
    private String regNumber;
    private String make;
    private String model;
    private int yearBuilt;
    private double baseHourlyRate;
    private boolean isRepaired;


    public Vehicle(String regNumber, String make, String model, int yearBuilt, double baseHourlyRate, boolean isRepaired) {


        this.regNumber = regNumber;
        this.make = make;
        this.model = model;
        this.yearBuilt = yearBuilt;
        this.baseHourlyRate = baseHourlyRate;
        this.isRepaired = isRepaired;


    }
}