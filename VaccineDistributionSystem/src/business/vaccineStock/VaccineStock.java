/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.vaccineStock;

import business.vaccine.Vaccine;

/**
 *
 * @author Harshil
 */
public class VaccineStock {
    
    private int vaccineStockQuantity;
    private Vaccine vaccine;
    private int vaccineID;
    
    public VaccineStock(Vaccine vaccine,int vaccineStock)
    {
        this.vaccineStockQuantity = vaccineStock;
        this.vaccine = vaccine;
    }

    public int getVaccineStockQuantity() {
        return vaccineStockQuantity;
    }

    public void setVaccineStockQuantity(int vaccineStockQuantity) {
        this.vaccineStockQuantity = vaccineStockQuantity;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
    
    public String toString()
    {
        return this.getVaccine().getVaccineName();
    }
    
    
}
