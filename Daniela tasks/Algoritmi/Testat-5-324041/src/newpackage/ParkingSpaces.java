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
public class ParkingSpaces implements Serializable {
 
    private int position;
    private String status;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ParkingSpaces(int position, String status) {
        this.position = position;
        this.status = status;
    }
    
    @Override
    public String toString(){
        return this.position + "  " + this.status;
    }
}
