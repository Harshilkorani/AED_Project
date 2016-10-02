/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Harshil
 */
public abstract class Role {
    
      //Data Members
   private String roleType;
   
   //Constructor
   Role(String roleType)
   {
       this.roleType=roleType;
   }
    
    //Enum for possible roles in the system
     public enum RoleType {
     SystemAdmin("System Administrator"),
     CDCEnterpriseAdmin("CDC Enterprise Admin"),
     DPHEnterpriseAdmin("DPH Enterprise Admin"),
     ManufacturerEnterpriseAdmin("Manufacturer Enterprise Admin"),
     DistributorEnterpriseAdmin("Distributor Enterprise Admin"),
     MedicalEnterpriseAdmin("Medical Enterprise Admin"),
     SiteConfiguratorRole("Site Configurator Role"),
     ProviderRole("Provider Role"),
     InventoryManagerRole("Inventory Manager Role"),
     HospitalAdminRole("Hospital Admin Role"),
     ClinicAdminRole("ClinicAdminRole"),
     PharmacyAdminRole("Pharmacy Admin Role");
      
     private String value;
     private RoleType(String value) 
     {
            this.value = value;
     }
     public String getValue() 
     {
            return value;
     }
   }

    //Getter and Setter
    public String getRoleType() {
        return roleType;
    }
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    
    public String toString()
    {
        return this.getRoleType();
    }
    
    
   //Declaration of Abstract method for creation of Work area for a particular role in a particular hierarchy
   
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization enterpriseOrganization, business.site.Site site, Organization nodeOrganization, Business business);

    
}
