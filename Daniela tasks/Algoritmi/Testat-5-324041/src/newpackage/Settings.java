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
public class Settings implements Serializable {
    public String programName;
    public String programVersion;
    public String programLicensee;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(String programVersion) {
        this.programVersion = programVersion;
    }

    public String getProgramLicensee() {
        return programLicensee;
    }

    public void setProgramLicensee(String programLicensee) {
        this.programLicensee = programLicensee;
    }

    public Settings(String programName, String programVersion, String programLicensee) {
        this.programName = programName;
        this.programVersion = programVersion;
        this.programLicensee = programLicensee;
    }
    
    @Override
    public String toString(){
        return this.programName + " " + this.programVersion + " " + this.programLicensee;
    }
}
