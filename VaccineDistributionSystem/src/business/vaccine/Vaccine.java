/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.vaccine;

/**
 *
 * @author Harshil
 */
public class Vaccine {
    
    private int vaccineID;
    private String vaccineName;
    private int vaccinePrice;
    private static int vaccineIDCounter = 1;
    
    public Vaccine(String vaccineName)
    {
        this.vaccineID = vaccineIDCounter++;
        this.vaccineName = vaccineName;
        this.vaccinePrice = vaccinePrice;
    }
        
 
    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getVaccineID() {
        return vaccineID;
    }

    public int getVaccinePrice() {
        return vaccinePrice;
    }

    public void setVaccinePrice(int vaccinePrice) {
        this.vaccinePrice = vaccinePrice;
    }
    
    
    
    public String toString()
    {
        return vaccineName;
    }
    
}
