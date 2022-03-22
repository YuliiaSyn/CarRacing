import java.util.ArrayList;

/**
 * Class which creates the list of Car objects and decides the winner via randomization
 * @author Yuliia Synytska
 * @modified by: Kevin Pinto
 */

public class RacingVenue {

    ArrayList<Car> carList;
    Car winner;

    public RacingVenue() {
        carList = new ArrayList<Car>();
        winner = null;
    }

    public void addCar(Car c) {
        carList.add(c);
    }

    public ArrayList<Car> getCars() {
        return carList;
    }

    public Car getWinner() {
        return winner;
    }

    public String toString() {
        String s = "";
        for (int a = 0; a < carList.size(); a++) {
            s += carList.get(a).toString() + "\n";
        }
        return s;
    }

}