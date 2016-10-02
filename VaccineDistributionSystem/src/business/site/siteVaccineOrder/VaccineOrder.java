/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.site.siteVaccineOrder;

import business.communication.Contact;
import business.communication.Location;
import business.organization.useraccount.UserAccount;
import business.person.Person;
import business.vaccine.Vaccine;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Harshil
 */
    public class VaccineOrder {
    
    private int vaccineOrderID;
    private Date vaccineOrderDate;
    private String vaccineOrderStatus;
    private UserAccount userAccount;
    
    private ArrayList<VaccineOrderItem> vaccineOrderItemList;
    
    private VaccineMasterOrderCatalog subVaccineOrderCatalog;
    
    private static int orderCounter = 100;
    
    public VaccineOrder() {
        vaccineOrderItemList = new ArrayList<>();
        vaccineOrderID = orderCounter ++;    
        subVaccineOrderCatalog = new VaccineMasterOrderCatalog();
    }

    public int getVaccineOrderID() {
        return vaccineOrderID;
    }

    public void setVaccineOrderID(int vaccineOrderID) {
        this.vaccineOrderID = vaccineOrderID;
    }

    public Date getVaccineOrderDate() {
        return vaccineOrderDate;
    }

    public void setVaccineOrderDate(Date vaccineOrderDate) {
        this.vaccineOrderDate = vaccineOrderDate;
    }

    public ArrayList<VaccineOrderItem> getVaccineOrderItemList() {
        return vaccineOrderItemList;
    }

    public void setVaccineOrderItemList(ArrayList<VaccineOrderItem> vaccineOrderItemList) {
        this.vaccineOrderItemList = vaccineOrderItemList;
    }

    public VaccineMasterOrderCatalog getSubVaccineOrderCatalog() {
        return subVaccineOrderCatalog;
    }

    public void setSubVaccineOrderCatalog(VaccineMasterOrderCatalog subVaccineOrderCatalog) {
        this.subVaccineOrderCatalog = subVaccineOrderCatalog;
    }

    public String getVaccineOrderStatus() {
        return vaccineOrderStatus;
    }

    public void setVaccineOrderStatus(String vaccineOrderStatus) {
        this.vaccineOrderStatus = vaccineOrderStatus;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
    public VaccineOrderItem createVaccineOrderItem(Vaccine vaccine,int quantity)
    {
        VaccineOrderItem vaccineOrderItem = new VaccineOrderItem(vaccine,quantity);
        vaccineOrderItemList.add(vaccineOrderItem);
        return vaccineOrderItem;
    }

    
    public void removeVaccineOrderItem(VaccineOrderItem vaccineOrderItem)
    {
        vaccineOrderItemList.remove(vaccineOrderItem);
    }
    
    public String toString()
    {
        return String.valueOf(this.vaccineOrderID);
    }
    
}
