import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 50.0, 150);

        assertEquals(50.0, myEngine.getCurrentFuel(),0.0);
        assertEquals(FuelType.ELECTRIC, myEngine.getFuelType());
        assertEquals(150.0, myEngine.getMaxFuel(), 0.0);
    }

    @Test
    public void testEngineGo() {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 50.0, 150);

        assertTrue(myEngine.go());
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        
        // has capacity and passenger not already on board
        Car myCar = new Car(1);
        Passenger p = new Passenger("Jordan");

        assertTrue(myCar.addPassenger(p));

        // has a capacity of 0 and passenger not already on board
        Car myCars = new Car (0);
        Passenger c = new Passenger ("Chiashi");

        assertFalse(myCars.addPassenger(c));

        // has capacity and passenger already on board 
        Car car = new Car (2);
        Passenger k = new Passenger("Kassidy");

        car.addPassenger(k);

        assertFalse(car.addPassenger(k));

    }

    @Test
    public void testCarRemovePassenger() {
        
        // passenger is on board
        Car myCars = new Car(1);
        Passenger c = new Passenger ("Chiashi");

        myCars.addPassenger(c);
        
        assertTrue(myCars.removePassenger(c));


        // passenger is not on board
        Car cars = new Car (1);
        Passenger k = new Passenger("Kassidy");

        assertFalse(cars.removePassenger(k));

    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
       Car myCar = new Car(2);
       Passenger myPassenger = new Passenger("Kiara");

       myPassenger.boardCar(myCar);

       assertTrue(myPassenger.getBoardsCar());
    }

    @Test
    public void testPassengerBoardCarFull() {
        // Create a car with a capacity of one and two passengers 
        // Ensures that the second passenger cannot board the car
        
        Car myCar = new Car(1);
        Passenger myPassenger = new Passenger("Kiara");
        Passenger myPassenger2 = new Passenger("John");
        
       myPassenger.boardCar(myCar);
       myPassenger2.boardCar(myCar);

       assertFalse(myPassenger2.getBoardsCar());

    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train myTrain = new Train(FuelType.ELECTRIC, 50.0, 100.0, 5, 25);

        assertEquals(FuelType.ELECTRIC, myTrain.getEngine().getFuelType()); // accesses the getEngine method from specific instance myTrain, then accesses getFuelType method from the engine class through getter for engine
        assertEquals(50.0, myTrain.getEngine().getCurrentFuel(), 0.0);
        assertEquals(100.0, myTrain.getEngine().getMaxFuel(), 0.0);

        assertEquals(5, myTrain.getMaxCapacity() / 25); // takes the max capacity of entire train and divides by 25 (max capacity of passengers per car)
        assertEquals(25, myTrain.getMaxCapacity() / 5); // takes the max capacity of entire train and divides by 5 (total cars) 


    }

    @Test
    public void testTrainPassengerCount() {
        Train myTrain = new Train(FuelType.ELECTRIC, 50.0, 100.0, 5, 25);

        Car myCar = myTrain.getCar(0);

        Passenger c = new Passenger ("Chiashi");
        Passenger p = new Passenger ("Preston");

        myCar.addPassenger(c);
        myCar.addPassenger(p);



        assertEquals(2, myTrain.getMaxCapacity()-myTrain.seatsRemaining());


    }

    @Test
    public void testTrainGetCar() {
        Train myTrain = new Train(FuelType.ELECTRIC, 50.0, 100.0, 5, 25);
 
 
        Car car1 = myTrain.getCar(1);
        Car car2 = myTrain.getCar(2);
 
 
        assertNotNull(car1); //Checks to make sure that the car object is not null
        assertNotNull(car2);
 
 
        assertEquals(25, car1.getCapacity());
        assertEquals(25, car2.getCapacity());
        
    }

    @Test
    public void testTrainPrintManifest() {
        Train myTrain = new Train(FuelType.ELECTRIC, 50.0, 100.0, 5, 25);

        Car myCar = myTrain.getCar(0); // first car at index 0

        Passenger c = new Passenger ("Chiashi");
        Passenger p = new Passenger ("Preston");

        myCar.addPassenger(c);
        myCar.addPassenger(p);

        Car myCar_2 = myTrain.getCar(1); // second car at index 1
       
        Passenger k = new Passenger ("Kiara");
        Passenger v = new Passenger ("Victoria");

        myCar_2.addPassenger(k);
        myCar_2.addPassenger(v);

        myTrain.printManifest(); // because print manifest is not returning anything, cannot use an assertion in this case


    }
    
}
