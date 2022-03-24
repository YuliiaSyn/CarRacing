import java.util.ArrayList;
import java.util.Collections;

/**
 * Class which creates the list of Car objects and decides the winner via randomization
 * @author Yuliia Synytska
 * @modified by: Kevin Pinto
 * @modified by: Alland Timas
 */

public class RacingVenue {

    ArrayList<Car> carList;
    Car car;
    String x;

    public RacingVenue() {
        carList = new ArrayList<Car>();
    }

    public void addCar(Car c) {
        carList.add(c);
    }

    public ArrayList<Car> getCars() {
        return carList;
    }
    
    public void generateCar(){
        this.car = new Car();
        carList.add(this.car);
    }
    public int returnLapSpeed(){
        return this.car.getSpeed();
    }
    //Alland Timas
    //creates a local arraylist that is used to sort the cars by speed
    //uses Collection class to sort the cars by the shortest lap time(10 seconds base - speed to determine lap time)
    //adds any cars that match the shortest lap time to winner list and returns winnerlist 
    public String determineWinner(){
        ArrayList<String> winnerList = new ArrayList<>();
        String x = "";
        ArrayList<Integer> carSpeed = new ArrayList<>();
        for (Car car : carList) {
            carSpeed.add(car.getLapTime());
        }
        Integer max = Collections.min(carSpeed);
        for (Car c : carList) {
            if(c.getLapTime() == max){
                x = c.toString();
                winnerList.add(x);
            }
        }
        return winnerList.toString();
        
        
    }
    public String toString() {
        String s = "";
        for (int a = 0; a < carList.size(); a++) {
            s += carList.get(a).toString() + "\n";
        }
        return s;
    }

}