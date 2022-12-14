package Raw_Data;

public class Engine {
    int speed;
    int power;

    public  Engine(int speed, int power){
        this.speed=speed;
        this.power=power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }
}
