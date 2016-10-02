/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import static business.organization.Organization.MedicalEnterpriseOrganizationType.SitesManagement;
import static business.organization.Organization.OrganizationType.SitesManagement;
import business.organization.medicalenterpriseOrganizations.ProviderManagementOrganization;
import business.organization.medicalenterpriseOrganizations.SitesManagementOrganization;
import business.organization.siteOrganization.InventoryManagementOrg;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class OrganizationDirectory {
    
    //Data Members
   ArrayList<Organization> organizationList;
    
   //Constructor
   public OrganizationDirectory() {
       organizationList = new ArrayList<>();
   }
   
   //Getter and Setter 
   public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
   public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
   
   //Creation of Organization 
   public Organization createOrganization(Organization.OrganizationType type, String organizationName) {
       Organization organization = null;
       
       
        if(Organization.OrganizationType.InventoryManagement.getValue().equals(type.getValue()))
       {
           organization = new InventoryManagementOrg(organizationName);
           organizationList.add(organization);
       }
        else  if(Organization.OrganizationType.SitesManagement.getValue().equals(type.getValue()))
       { 
           organization = new SitesManagementOrganization(organizationName);
           organizationList.add(organization);
       }
        else if(Organization.OrganizationType.ProviderManagement.getValue().equals(type.getValue()))
        {
            organization = new ProviderManagementOrganization(organizationName);
           organizationList.add(organization);
        }
        
       return organization;
    
}
   
}
