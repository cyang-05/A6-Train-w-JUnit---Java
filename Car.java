import java.util.ArrayList;


public class Car implements CarRequirements {

    // Attributes 
    private ArrayList <Passenger>  passengersOnboard;
    private int maxCapacity;



    /**
     * the constructor
     * will initialize the maxCapcity and arraylist for passengers on baord
     * @param maxCapacity
     */

    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>();
    }


    /**
     * the getter for max capacity
     * @return maxCapacity
     */

    public int getCapacity() {
        return this.maxCapacity;
    }


    /**
     * the getter for seatsRemaining method 
     * @return number of seats remaining 
     */

    public int seatsRemaining() {
        return this.maxCapacity - passengersOnboard.size();
    }


    /**
     * checks to see if car is full and passenger is already on board. if not, adds passenger to array list
     * @param p
     * @return true if passenger is added to car or false if cannot add passenger
     */

    public Boolean addPassenger(Passenger p) {
        int cap = passengersOnboard.size();
        if (cap < maxCapacity && !passengersOnboard.contains(p)) {
            passengersOnboard.add(p);
            return true;

        } else {
                return false;
        }
        

    }

    /**
     * checks to see if passenger is already on board. if so, passenger will be removed
     * @param p
     * @return true if function is able to remove passenger from car or false if not
     */

    public Boolean removePassenger(Passenger p) {        
        if (passengersOnboard.contains(p)) {
            passengersOnboard.remove(p);
            return true;
        
        } else {
            return false;
        }
    }


    /**
     * prints out list of passengers on board. if no passengers present, will print out that car is empty.
     * 
     */

    public void printManifest() {
        System.out.println("Passengers on Board: ");
        if (!passengersOnboard.isEmpty()) {          
            System.out.println(passengersOnboard);
        } else {
            System.out.println("This car is EMPTY.");
        }
    }
}

