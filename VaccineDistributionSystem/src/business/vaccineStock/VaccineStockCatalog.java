/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.vaccineStock;

import business.vaccine.Vaccine;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class VaccineStockCatalog {
    
    private ArrayList<VaccineStock> vaccineStockList;
    
    public VaccineStockCatalog()
    {
        vaccineStockList = new ArrayList<>();
    }

    public ArrayList<VaccineStock> getVaccineStockList() {
        return vaccineStockList;
    }

    public void setVaccineStockList(ArrayList<VaccineStock> vaccineStockList) {
        this.vaccineStockList = vaccineStockList;
    }
    
    public VaccineStock createVaccineStock(Vaccine vaccine,int quantity)
    {
        VaccineStock vaccineStock = new VaccineStock(vaccine,quantity);
        vaccineStockList.add(vaccineStock);
        return vaccineStock; 
    }
    
    //Removal of Node Product
    public void removeNodeProduct(VaccineStock vaccineStock)
    {
        vaccineStockList.remove(vaccineStock);
    }
    
    public boolean isPresent(Vaccine vaccine)
    {
        for(VaccineStock vaccineStock:vaccineStockList)
        {
            if(vaccineStock.getVaccine()==vaccine)
            {
                return true;
            }
        }
        return false;
    }
    
    public VaccineStock getVaccineStock(Vaccine vaccine)
    {
        for(VaccineStock vaccineStock:vaccineStockList)
        {
            if(vaccineStock.getVaccine()==vaccine)
                return vaccineStock;
        }
        return null;
    }
    
}
