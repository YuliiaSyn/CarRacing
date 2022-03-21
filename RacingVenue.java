/* Yuliia Synytska */

import java.util.ArrayList;

public class RacingVenue {
    
    ArrayList<Car> carList;
    Car winner;
    
    RacingVenue(){
        carList = new ArrayList<Car>();
        winner = null;
    }
    
    public void addCar(Car c){
        carList.add(c);
    }
    
    public ArrayList<Car> getCars(){
        return carList;
    }
    
    public Car getWinner(){
        return winner;
    }
    
    public String toString(){
        String s =  "";
        for (int a = 0; a < carList.size(); a++) {
            s += carList.get(a).toString()+"\n";
        }
        return s;
    }
    
}
