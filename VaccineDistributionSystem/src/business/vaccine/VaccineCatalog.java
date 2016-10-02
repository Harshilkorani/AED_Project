/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.vaccine;

import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class VaccineCatalog {
    
    private ArrayList<Vaccine> vaccineList;
    
    public VaccineCatalog()
    {
        vaccineList = new ArrayList<>();
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(ArrayList<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }
    
    public Vaccine createVaccine(String vaccineName)
    {
        Vaccine vaccine = new Vaccine(vaccineName);
        vaccineList.add(vaccine);
        return vaccine;
    }
    
    //Removal of Vaccine
    public void removeVaccine(Vaccine vaccine)
    {
        vaccineList.remove(vaccine);
    }
    
    public boolean isPresent(Vaccine vaccine)
    {
        for(Vaccine vacc:vaccineList)
        {
            if(vacc==vaccine)
            {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean isPresent(String vaccineName)
    {
        for(Vaccine vacc:vaccineList)
        {
            if(vacc.getVaccineName().equalsIgnoreCase(vaccineName))
                return true;
        }
        return false;  
    }
    
    
}
