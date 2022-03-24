import java.util.Random;
import java.util.ArrayList;

/**
 * Class to create the Cars to be raced with randomized tires, wheels, engine, and speed
 *
 * @author Yuliia Synytska
 * @modified by: Kevin Pinto
 */


public class Car {


    //Declaring necessary car attributes
    private int speed;
    private String wheels;
    private String tires;
    private String engine;
    private int lapTime;
    private String color;

    //Creating random number generator
    private final Random rand = new Random();
    int speedTier;

    /**
     * Default constructors for Car
     */
    public Car(int speed, String wheels, String tyres, String engine) {
        this.speed = speed;
        this.wheels = wheels;
        this.tires = tyres;
        this.engine = engine;
    }

    public Car() {
        randomCar();
        color ="";
    }

    /**
     * Method which creates an ArrayList of all possible wheels, tires, and engines. Then uses random number
     * generator to assign one of each. */
    public void randomCar() {

        ArrayList<String> possibleWheels = new ArrayList<String>();
        possibleWheels.add("Enkei");
        possibleWheels.add("BBS");
        possibleWheels.add("HRE Performance");
        possibleWheels.add("Konig");
        possibleWheels.add("Vossen");
        this.wheels = possibleWheels.get(rand.nextInt(4));
        setWheels(wheels);


        ArrayList<String> possibleTyres = new ArrayList<String>();
        possibleTyres.add("Michelin");
        possibleTyres.add("Goodyear");
        possibleTyres.add("Continental");
        possibleTyres.add("Yokohama");
        possibleTyres.add("BFGoodrich");
        this.tires = possibleTyres.get(rand.nextInt(4));
        setTyres(tires);


        ArrayList<String> possibleEngines = new ArrayList<String>();
        possibleEngines.add("Honda");
        possibleEngines.add("Toyota");
        possibleEngines.add("Ford");
        possibleEngines.add("Nissan");
        possibleEngines.add("BMW");
        this.engine = possibleEngines.get(rand.nextInt(4));
        setEngine(engine);



        /** A number value in the form of a 'tier' is assigned to each of the tires, engine, and wheels based on
         * the randomly assigned attributes. The values are totaled up, and 3 thresholds then makeup a 'speedTier' of
         * 0, 1, or 2, which ultimately decides the cars 'top speed'
         *  */
        String aTire = getTires();
        String aEngine = getEngine();
        String aWheel = getWheels();
        int tireTier = 0, engineTier = 0, wheelTier = 0;

        switch (aTire) {
            case "Michelin":
            case "Goodyear":
                tireTier = 2;
                break;

            case "BFGoodrich":
                tireTier = 0;
                break;

            case "Continental":
            case "Yokohama":
            default:
                tireTier = 1;
                break;
        }

        switch (aEngine) {
            case "Honda":
            case "Ford":
                engineTier = 0;
                break;

            case "BMW":
                engineTier = 2;
                break;

            case "Toyota":
            case "Nissan":
            default:
                engineTier = 1;
                break;
        }

        switch (aWheel) {
            case "Enkei":
            case "BBS":
                wheelTier = 0;
                break;

            case "Vossen":
                wheelTier = 2;
                break;

            case "HRE Performance":
            case "Konig":
            default:
                wheelTier = 1;
                break;
        }

        if ((tireTier + engineTier + wheelTier) <= 1) {
            speedTier = 0;

        } else if ((tireTier + engineTier + wheelTier) <= 3) {
            speedTier = 1;

        } else if ((tireTier + engineTier + wheelTier) <= 5) {
            speedTier = 2;
        }

        switch (speedTier) {
            case 0:
                speed = rand.nextInt(3);
                setSpeed(speed);
                setLapTime(10 - speed);
                break;

            case 1:
                speed = rand.nextInt(4);
                setSpeed(speed);
                setLapTime(10 - speed);
                break;
            case 2:
                speed = rand.nextInt(6);
                setSpeed(speed);
                setLapTime(10 - speed);
                break;
            default:
                speed = rand.nextInt(5);
                setSpeed(speed);
                setLapTime(10 - speed);
                break;
        }
    }

    public int getLapTime() {
        return lapTime;
    }

    public void setLapTime(int lapTime) {
        this.lapTime = lapTime;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }


    public String getTires() {
        return tires;
    }

    public void setTyres(String tyres) {
        this.tires = tyres;
    }


    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return " \nCar Color: " + color + ", Speed: " + speed + ", Wheels: " + wheels + ", Tires: " + tires + ", Engine: " + engine;
    }

}