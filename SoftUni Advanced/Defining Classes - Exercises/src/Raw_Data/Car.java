package Raw_Data;

import java.util.ArrayList;
import java.util.List;

public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    List<Tires> tires = new ArrayList<>();

    public Car(String model,int engsp,int engpow,int cargow,String cargot,double tp1, int ta1,double tp2, int ta2,double tp3, int ta3,double tp4, int ta4){
        this.model=model;
        this.engine= new Engine(engsp,engpow);
        this.cargo=new Cargo(cargow,cargot);
        this.tires.add(new Tires(tp1,ta1));
        this.tires.add(new Tires(tp2,ta2));
        this.tires.add(new Tires(tp3,ta3));
        this.tires.add(new Tires(tp4,ta4));
    }
}
