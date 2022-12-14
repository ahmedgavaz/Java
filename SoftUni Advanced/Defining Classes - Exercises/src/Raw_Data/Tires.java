package Raw_Data;

public class Tires {
    double pressure;
    int age;

    public Tires(double pressure,int age){
        this.pressure=pressure;
        this.age=age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public int get() {
        return age;
    }

    public Double getPressure() {
        return pressure;
    }
}
