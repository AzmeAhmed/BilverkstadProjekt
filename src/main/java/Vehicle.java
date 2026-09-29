public class Vehicle {
    private String regNumber;
    private String make;
    private String model;
    private int yearBuilt;
    private double hourlyRate;
    private boolean isRepaired;


    public Vehicle(String regNumber, String make, String model, int yearBuilt, double hourlyRate, boolean isRepaired) {


        this.regNumber = regNumber;
        this.make = make;
        this.model = model;
        this.yearBuilt = yearBuilt;
        this.hourlyRate = hourlyRate;
        this.isRepaired = isRepaired;


    }
}