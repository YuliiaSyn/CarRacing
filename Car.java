/* Yuliia Synytska */

public class Car {
    
    private int speed;
    private String wheels;
    private int tyres;
    private String engine;

    public Car(int speed, String wheels, int tyres, String engine) {
        this.speed = speed;
        this.wheels = wheels;
        this.tyres = tyres;
        this.engine = engine;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public int getTyres() {
        return tyres;
    }

    public void setTyres(int tyres) {
        this.tyres = tyres;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Speed: " + speed + ", Wheels: " + wheels + ", Tyres: " + tyres + ", Engine: " + engine;
    }
    
}
