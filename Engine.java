public class Engine implements EngineRequirements {

    // Attributes 
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;


    /**
     * the constructor will initialize the current fuel level, fuel type, and max fuel level objects 
     * @param f
     * @param currentFuelLevel
     * @param maxFuelLevel
     */


    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel) {
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;

    }

    /**
     * getter for fuel type
     * @return the fuel type
     */

    public FuelType getFuelType() {
        return this.f;
    }


    /**
     * getter for maxFuel level 
     * @return the maxFuel level
     */

    public double getMaxFuel() {
        return this.maxFuelLevel;
    }


    /**
     * getter for currentFuel level
     * @return the currentFuel level 
     */

    public double getCurrentFuel() {
        return this.currentFuelLevel;
    }

    /**
     * resets Engine's current fuel level to maximum level
     */


    public void refuel() {
        this.currentFuelLevel = maxFuelLevel;
    }

    /**
     * will decrease current fuel level by 2, print out the current fuel level, and checks if it is greater than 0
     * @return true or false depending on if fuel level is above 0
     */


    public Boolean go() {
        this.currentFuelLevel -= 2;
        System.out.println(currentFuelLevel);
        if (this.currentFuelLevel > 0) {
            return true;
        } else {
            return false;
        }
    }


}