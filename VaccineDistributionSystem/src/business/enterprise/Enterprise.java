/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.communication.Contact;
import business.communication.Location;
import business.organization.Organization;
import business.organization.OrganizationDirectory;
import business.site.siteVaccineOrder.VaccineMasterOrderCatalog;

/**
 *
 * @author Harshil
 */
public abstract class Enterprise extends Organization {
    
    //Data Members
    private String enterpriseType;
    private Contact enterpriseContact;
    private Location enterpriseHeadquarters;  
    private OrganizationDirectory organizationDirectory;
    private VaccineMasterOrderCatalog vaccineMasterOrderCatalog;
    
    
    
    public Enterprise(String organizationName, String enterpriseType){ 
        super(organizationName,Organization.OrganizationType.Enterprise.getValue() );
        enterpriseHeadquarters=new Location();
        enterpriseContact=new Contact();
        organizationDirectory=new OrganizationDirectory();
        this.enterpriseType=enterpriseType;
        this.vaccineMasterOrderCatalog = new VaccineMasterOrderCatalog();
    }
  
    //Enum for the possible Type of Enterprises in the System
     public enum EnterpriseType{
        ManufacturerEnterprise("Manufacturer Enterprise"),
        CDCEnterprise("CDC Enterprise"),
        DPHEnterprise("DPH Enterprise"),
        DistributorEnterprise("Distributor Enterprise"),
        MedicalEnterprise("Medical Enterprise");
        
        private String value;
        private EnterpriseType(String value) 
        {
            this.value = value;
        }
        public String getValue() 
        {
            return value;
        }
   }

     
    public String getEnterpriseType() {
        return enterpriseType;
    }
    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public Contact getEnterpriseContact() {
        return enterpriseContact;
    }

    public void setEnterpriseContact(Contact enterpriseContact) {
        this.enterpriseContact = enterpriseContact;
    }

    public Location getEnterpriseHeadquarters() {
        return enterpriseHeadquarters;
    }

    public void setEnterpriseHeadquarters(Location enterpriseHeadquarters) {
        this.enterpriseHeadquarters = enterpriseHeadquarters;
    }

    public VaccineMasterOrderCatalog getVaccineMasterOrderCatalog() {
        return vaccineMasterOrderCatalog;
    }

    public void setVaccineMasterOrderCatalog(VaccineMasterOrderCatalog vaccineMasterOrderCatalog) {
        this.vaccineMasterOrderCatalog = vaccineMasterOrderCatalog;
    }
   
    
    
}
