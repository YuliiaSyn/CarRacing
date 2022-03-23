
import java.util.Random;
import java.util.ArrayList;

/**
 * Class containing all the necessary information for the cars that will be used in the race
 *
 * @author Yuliia Synytska
 * @modified by: Kevin Pinto
 */


public class Car {


    //    Declaring all the necessary attributes
    private int speed;
    private String wheels;
    private String tyres;
    private String engine;
    private Random rand = new Random();
    Tier speedTier;


    public enum Tier {
        LOW, MED, HIGH;
    }

    public Car(int speed, String wheels, String tyres, String engine) {
        this.speed = speed;
        this.wheels = wheels;
        this.tyres = tyres;
        this.engine = engine;
    }


    public Car randomCar() {

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
        this.tyres = possibleTyres.get(rand.nextInt(4));
        setTyres(tyres);


        ArrayList<String> possibleEngines = new ArrayList<String>();
        possibleEngines.add("Honda");
        possibleEngines.add("Toyota");
        possibleEngines.add("Ford");
        possibleEngines.add("Nissan");
        possibleEngines.add("BMW");
        this.engine = possibleEngines.get(rand.nextInt(4));
        setEngine(engine);


        String aTire = getTyres();
        String aEngine = getEngine();
        String aWheel = getWheels();
        Tier tireTier;
        Tier engineTier;
        Tier wheelTier;

        switch (aTire) {
            case "Michelin":
            case "Goodyear":
                tireTier = Tier.HIGH;
                break;

            case "BFGoodrich":
                tireTier = Tier.LOW;
                break;

            case "Continental":
            case "Yokohama":
            default:
                tireTier = Tier.MED;
                break;
        }

        switch (aEngine) {
            case "Honda":
            case "Ford":
                engineTier = Tier.LOW;
                break;

            case "BMW":
                engineTier = Tier.HIGH;
                break;

            case "Toyota":
            case "Nissan":
            default:
                engineTier = Tier.MED;
                break;
        }

        switch (aWheel) {
            case "Enkei":
            case "BBS":
                wheelTier = Tier.LOW;
                break;

            case "Vossen":
                wheelTier = Tier.HIGH;
                break;

            case "HRE Performance":
            case "Konig":
            default:
                wheelTier = Tier.MED;
                break;
        }

        if (tireTier == Tier.LOW && (engineTier == Tier.LOW || wheelTier == Tier.LOW)) {
            speedTier = Tier.LOW;

        } else if (tireTier == Tier.MED && (engineTier == Tier.MED || wheelTier == Tier.MED)) {
            speedTier = Tier.MED;

        } else if (tireTier == Tier.HIGH && (engineTier == Tier.HIGH || wheelTier == Tier.HIGH)) {
            speedTier = Tier.HIGH;
        }

        switch (speedTier) {
            case LOW:
                speed = rand.nextInt(3);
                setSpeed(speed);
                break;

            case MED:
                speed = rand.nextInt(7);
                setSpeed(speed);
                break;
            case HIGH:
                speed = rand.nextInt(9);
                setSpeed(speed);
                break;
            default:
                speed = rand.nextInt(5);
                setSpeed(speed);
                break;
        }

        return randomCar();
    }


    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }


    public String getTyres() {
        return tyres;
    }

    public void setTyres(String tyres) {
        this.tyres = tyres;
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


    @Override
    public String toString() {
        return "Speed: " + speed + ", Wheels: " + wheels + ", Tyres: " + tyres + ", Engine: " + engine;
    }

}