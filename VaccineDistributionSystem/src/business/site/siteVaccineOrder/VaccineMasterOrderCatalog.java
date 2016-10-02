/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.site.siteVaccineOrder;

import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class VaccineMasterOrderCatalog {
    
    private ArrayList<VaccineOrder> vaccineOrderList;
    
    public VaccineMasterOrderCatalog()
    {
        vaccineOrderList = new ArrayList<>();
    }

    public ArrayList<VaccineOrder> getVaccineOrderList() {
        return vaccineOrderList;
    }

    public void setVaccineOrderList(ArrayList<VaccineOrder> vaccineOrderList) {
        this.vaccineOrderList = vaccineOrderList;
    }
    
    public VaccineOrder createVaccineOrder(VaccineOrder vaccineOrder)
    {
        VaccineOrder vo = vaccineOrder;
        vaccineOrderList.add(vo);
        return vo;
    }
    
    public void removeVaccineOrder(VaccineOrder vaccineOrder)
    {
        vaccineOrderList.remove(vaccineOrder);
    }
  
    
    
}
