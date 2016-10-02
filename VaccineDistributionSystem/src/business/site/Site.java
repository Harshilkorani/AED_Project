/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.site;

import business.communication.Contact;
import business.communication.Location;
import business.organization.Organization;
import business.organization.OrganizationDirectory;
import business.organization.siteOrganization.InventoryManagementOrg;
import business.role.Role;
import business.vaccineStock.VaccineStockCatalog;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public abstract class Site extends Organization{
    
    private int siteId;
    private String sitetype;
    private Location location;
    private Contact contact;
    private OrganizationDirectory siteOrganizationDirectory;  
    private static int siteCounter = 1000;
    private InventoryManagementOrg primaryInventoryManagementOrg = new InventoryManagementOrg("Primary Inventory Management");
    private VaccineStockCatalog vaccineStockCatalog;

    
    public Site(String siteName, String sitetype, Location location, Contact contact) {
        
        super(siteName, Organization.OrganizationType.Site.getValue());
        this.siteId = siteCounter++;
        this.sitetype = sitetype;
        this.location=location;
        this.contact=contact;
        siteOrganizationDirectory = new OrganizationDirectory();
        siteOrganizationDirectory.getOrganizationList().add(primaryInventoryManagementOrg);
        vaccineStockCatalog = new VaccineStockCatalog();
        
    }

    
    
    public enum SiteTypes
   {
        Hospital("Hospital"),
        Clinic("Clinic"),
        Pharmacy("Pharmacy");
        private String value;
        private SiteTypes(String value) 
        {
            this.value = value;
        }
        public String getValue() 
        {
            return value;
        }
   }
    
    abstract   public ArrayList<Role> getSupportedRoles();

    public String getSitetype() {
        return sitetype;
    }

    public void setSitetype(String sitetype) {
        this.sitetype = sitetype;
    }

    

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public OrganizationDirectory getSiteOrganizationDirectory() {
        return siteOrganizationDirectory;
    }

    public void setSiteOrganizationDirectory(OrganizationDirectory siteOrganizationDirectory) {
        this.siteOrganizationDirectory = siteOrganizationDirectory;
    }

    public VaccineStockCatalog getVaccineStockCatalog() {
        return vaccineStockCatalog;
    }

    public void setVaccineStockCatalog(VaccineStockCatalog vaccineStockCatalog) {
        this.vaccineStockCatalog = vaccineStockCatalog;
    }
    
    
    
    
    @Override
    public String toString()
    {
       return String.valueOf(this.getOrganizationName());
    }
    
    
    
}
