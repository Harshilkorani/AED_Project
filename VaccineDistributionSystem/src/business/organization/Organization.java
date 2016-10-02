/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.employee.EmployeeDirectory;
import business.organization.medicalenterpriseOrganizations.ProviderManagementOrganization;
import business.organization.useraccount.UserAccountDirectory;
import business.organization.work.WorkQueue;
import business.role.Role;
import business.site.siteVaccineOrder.VaccineMasterOrderCatalog;
import com.sun.javafx.tk.quantum.MasterTimer;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public abstract class Organization{
    
    static int organizationCounter = 1500;
    private int organizationId;
    private String organizationName;
    private String organizationType;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;
    //private VaccineMasterOrderCatalog vaccineMasterOrderCatalog;
    
   public enum OrganizationType
   {
        //DirectOrganizations that will inherit Organization
        Enterprise("Enterprise"),
        Site("Site"),
        //Organizations of a Site
        InventoryManagement("Inventory Management"),
        //Site Management
        SitesManagement("Site Management"),
        ProviderManagement("Provider Management");
            
        private String value;
        private OrganizationType(String value) 
        {
            this.value = value;
        }
        public String getValue() 
        {
            return value;
        }
   }
   
       
    public Organization(String organizationName, String organizationType)
    {
        organizationId = organizationCounter++;   
        this.organizationName = organizationName;
        this.organizationType = organizationType;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        workQueue = new WorkQueue();
      //  vaccineMasterOrderCatalog = new VaccineMasterOrderCatalog();
    } 
    
    
   public enum SiteOrganizations
   {     
        InventoryManagement("Inventory Management");
        private String value;
        private SiteOrganizations(String value) 
        {
            this.value = value;
        }
        public String getValue() 
        {
            return value;
        }
   }
    
    public enum MedicalEnterpriseOrganizationType
   {    
        //Organizations of a Product Supplier Enterprise
        SitesManagement("Site Management"),
        ProviderManagement("Provider Management");
        private String value;
        private MedicalEnterpriseOrganizationType(String value) 
        {
            this.value = value;
        }
        public String getValue() 
        {
            return value;
        }
   }   
   
    abstract   public ArrayList<Role> getSupportedRoles();

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }
    
    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

     
    @Override
    public String toString()
    {
        return organizationId+"";
    }
    
}
