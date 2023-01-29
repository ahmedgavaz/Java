/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author Petya Tetevenska
 */
public class Serialization { //a class with methods for test purposes of the serialization
    public static void main(String[] args){
    CarManager carM = CarManager.getTheCarManager();
    
    carM.serialize();
    carM.deserialize();
    for(Car cars : carM.carsList){
        System.out.println(cars);
    }
    
    ParkingSpacesManager manager = ParkingSpacesManager.getTheSpacesManager();
    manager.spacesList.add(new ParkingSpaces(15, "available"));
    manager.serialize();
    manager.deserialize();
    for(ParkingSpaces spaces : manager.spacesList){
        System.out.println(spaces);
    }
    }
}
