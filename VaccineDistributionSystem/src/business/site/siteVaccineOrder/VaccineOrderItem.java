/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.site.siteVaccineOrder;

import business.vaccine.Vaccine;

/**
 *
 * @author Harshil
 */
public class VaccineOrderItem {
    
    private Vaccine vaccine;
    private int quantity=0;
    private int orderItemId;
    private int vaccinePrice;
    
    private static int orderItemCounter =1;
    
    public VaccineOrderItem(Vaccine vaccine, int quantity)
    {
        this.orderItemId = orderItemCounter++;
        this.quantity = quantity;
        this.vaccine = vaccine;
        this.vaccinePrice = vaccine.getVaccinePrice();
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getVaccinePrice() {
        return vaccinePrice;
    }

    public void setVaccinePrice(int vaccinePrice) {
        this.vaccinePrice = vaccinePrice;
    }
    
    public String toString()
    {
        return vaccine.getVaccineName();
    }
    
    
}
