/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Organization;
import business.site.Site;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;
   
    
    //Constructor
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<>();
    }

    //Getter and Setter
    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    //Creation of Enterprise
    public Enterprise createEnterprise(Enterprise.EnterpriseType type,String enterpriseName)
    {
        Enterprise enterprise=null;
        if(type.getValue().equals(Enterprise.EnterpriseType.CDCEnterprise.getValue()))
        {
            enterprise = new CDCEnterprise(enterpriseName);
        }
        else if(type.getValue().equals(Enterprise.EnterpriseType.DPHEnterprise.getValue()))
        {
           enterprise = new DPHEnterprise(enterpriseName);
        }
        else if(type.getValue().equals(Enterprise.EnterpriseType.DistributorEnterprise.getValue()))
        {
           enterprise = new DistributorEnterprise(enterpriseName);
        }
        /*else if(type.getValue().equals(Enterprise.EnterpriseType.ManufacturerEnterprise.getValue()))
        {
           enterprise = new ManufacturerEnterprise(enterpriseName);
        }*/
        else if(type.getValue().equals(Enterprise.EnterpriseType.MedicalEnterprise.getValue()))
        {
           enterprise = new MedicalEnterprise(enterpriseName);
        }
        
        
        enterpriseList.add(enterprise);
        
            return enterprise;
     
    }
    
    //Removal of Enterprise
    public void removeEnterprise(Enterprise enterprise)
    {
        enterpriseList.remove(enterprise);
    }
    
    
    
    
    //check for Employees across the enterprise directory
    public boolean checkIfEmployeeIsPresent(String firstName, String lastName, String emailId)
    {
        for(Enterprise enterprise:enterpriseList)
        {
                //Enterprise level emlployee list check
                if(enterprise.getEmployeeDirectory().isPresent(firstName, lastName, emailId))
                return true;
                
                //Organizations inside the enterprise, employee list check
                for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                {
                   if(organization.getEmployeeDirectory().isPresent(firstName, lastName, emailId))
                   return true;
                }
                
                //Nodes inside Product Supplier. employee list check
                if(enterprise instanceof MedicalEnterprise)
                {
                    MedicalEnterprise medicalEnterprise =(MedicalEnterprise)enterprise;
                    for(Site site: medicalEnterprise.getSiteDirectory().getSiteList())
                    {
                        //Node level employee list check
                        if(site.getEmployeeDirectory().isPresent(firstName, lastName, emailId))
                        return true;
                        
                        //Organizations inside the Node, employee list check
                        for(Organization organization: site.getSiteOrganizationDirectory().getOrganizationList())
                        {
                            if(organization.getEmployeeDirectory().isPresent(firstName, lastName, emailId))
                            return true;
                        }
                    }
                }
        }
        return false;
    }
     
    
    public boolean checkIfUserNameIsPresent(String userName)
    {
        for(Enterprise enterprise:enterpriseList)
        {
                //Enterprise level User Name check
                if(enterprise.getUserAccountDirectory().userNameIsPresent(userName))
                return true;
                
                //Organizations inside the enterprise, UserName  check
                for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                {
                   if(organization.getUserAccountDirectory().userNameIsPresent(userName))
                   return true;
                }
                
                //Nodes inside Product Supplier. User Name check
                if(enterprise instanceof MedicalEnterprise)
                {
                    MedicalEnterprise medicalEnterprise=(MedicalEnterprise)enterprise;
                    for(Site site: medicalEnterprise.getSiteDirectory().getSiteList())
                    {
                        //Node level employee list check
                        if(site.getUserAccountDirectory().userNameIsPresent(userName))
                        return true;
                        
                        //Organizations inside the Node, employee list check
                        for(Organization organization: site.getSiteOrganizationDirectory().getOrganizationList())
                        {
                            if(organization.getUserAccountDirectory().userNameIsPresent(userName))
                            return true;
                        }
                    }
                }
        }
        return false;
    }
    
    
    
   public boolean checkIfEnterpriseIsPresent(Enterprise enterprise)
   {
       for(Enterprise tempEnterprise: enterpriseList)
       {
           if(tempEnterprise==enterprise)
           {
               return true;
           }
       }
       return false;
   }
    
    
    
}
