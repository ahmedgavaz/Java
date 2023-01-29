/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.io.Serializable;


/**
 *
 * @author Petya Tetevenska
 */
public class Car implements Serializable {
 private int id;
 private String nameOfUser;
 
    public int getId() {
        return id;
    }
 
    public String getNameOfUser() {
        return nameOfUser;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }
 
    public Car(int id, String nameOfUser) {  //creating a contructor to model which attributes the objects of class Car should have
        this.id = id;
        this.nameOfUser = nameOfUser;
    }   
    @Override
    public String toString(){
        return this.id + "  " + this.nameOfUser;
    }
}
