public class Passenger implements PassengerRequirements {
    
    private String name;
    private Boolean boardsCar;

  

/** 
   * Constructor for passenger name
   * @param name
   */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * "getter" which gets the name of the passenger
     * @return name of passenger
    */
    public String getName() {
        return name;
    }
    /**
     * "setter" for the name of the passenger
     * @param name (new name of passenger)
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * prints the name of passenger in an understandable way
     */
    public String toString() {
        return "Passenger: " + name;
     }
    /**
     * Passenger boards a train car
     * @param c specific car that passenger boards
     */

    public Boolean getBoardsCar() {
        return boardsCar;
    }

    public void setBoardsCar(Boolean boardsCar) {
        this.boardsCar = boardsCar;
    }
    
    @Override
    public void boardCar(Car c) {
       if (c.addPassenger(this)){
       this.boardsCar = true;
        System.out.println(name +  " " + "boarded the car");
       }  else {
        this.boardsCar = false;
        System.out.println(name + " " +"could not board car");
       }
    }
    /**
     * Passenger gets off car
     * @param c (car passenger is leaving)
     */
    @Override
    public void getOffCar(Car c) {
       if (c.removePassenger(this)) {
        System.out.println(name + " "+ "got off car");
       } else {
        System.out.println(name +  " " + "did not remove, passenger may not be in car");
       }
    }
    // public static void main(String[] args) {
    //     Passenger passenger1 = new Passenger("Kiara");
    //     Passenger passenger2 = new Passenger("John");
    //     System.out.println(passenger1);
        
    //     Car testCar = new Car(1);
        
    //    passenger1.boardCar(testCar);
    //    passenger1.getOffCar(testCar);
    //    passenger2.boardCar(testCar);
    // }
}
