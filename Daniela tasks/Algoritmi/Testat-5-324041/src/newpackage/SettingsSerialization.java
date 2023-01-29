/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.io.*;
import java.io.IOException;



/**
 *
 * @author Petya Tetevenska
 */
public class SettingsSerialization {
    
    public static void serialize(Settings settings){
        try {
            new ObjectOutputStream(new FileOutputStream("Settings.ser")).writeObject(settings);
        } catch (IOException ex) {
            System.out.println("Something went wrong during settings serialization!");
        }
    }
    
    public static Settings deserialize(){
        try {
           Settings settings = (Settings) new ObjectInputStream(new FileInputStream("Settings.ser")).readObject();
           return settings;
        } catch (Exception ex) {
            System.out.println("Something went wrong during settings deserialization!");
            return null;
        }
    }
}
