import java.util.ArrayList;

public class Train implements TrainRequirements{

    //Attributes
    private ArrayList<Car>  cars;
    private Engine engine;

    /**
     * initilizes the objects and arraylist
     * @param fuelType
     * @param currentFuelLevel
     * @param fuelCapacity
     * @param Car
     * @param passengerCapacity
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        
        this.cars = new ArrayList<Car>();
        for (int i = 0; i < nCars; i++){
            Car car = new  Car(passengerCapacity);
            cars.add(car);
        }

        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);

    }
    /**
     * it gets the Engine 
     * @return engine
     */
    public Engine getEngine(){
        return this.engine;

    }
    /**
     * returns the specific car
     * @return the ith car
     * @param int i
     */
    public Car getCar(int i){
        return this.cars.get(i);

    }
    /**
     * gets maximun capacity of all the cars
     * @return max
     */
    public int getMaxCapacity(){
        int max = 0;
        for (Car car : cars) {
            max += car.getCapacity();

        }
        return max;
            
    } 
    /**
     * gets the number of remaining open seats accross all cars
     * @return seats
     */
    public int seatsRemaining(){
        int seats = 0;
        for (Car car : cars) {
            seats += car.seatsRemaining();

        }
        return seats;
    }
    /**
     * prints a roster of all passengers on board
     */
    public void printManifest(){
        for (Car car : cars) {
           car.printManifest();
        }
    
    }

}
