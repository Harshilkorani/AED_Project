/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.vaccineEcoSystem.VaccineEcoSystem;

/**
 *
 * @author Harshil
 */
public class Business {
    
    private static Business business;
    private VaccineEcoSystem vaccineEcoSystem;
    
    public Business()
    {
        
    }
    
    //singleton pattern to make only one instance of Business
    public static Business getInstance()
    {
        if(business == null)
        {
            business = new Business();
        }
        return business;
    }
    
    //getter and setter for Vaccine Eco System
    public VaccineEcoSystem getVaccineEcoSystem() {
        return vaccineEcoSystem;
    }

    public void setVaccineEcoSystem(VaccineEcoSystem vaccineEcoSystem) {
        this.vaccineEcoSystem = vaccineEcoSystem;
    }
    
}
