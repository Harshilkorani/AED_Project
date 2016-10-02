/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.employee.Employee;
import business.organization.useraccount.UserAccount;
import business.role.Role;
import business.role.SystemAdminRole;
import business.vaccineEcoSystem.VaccineEcoSystem;

/**
 *
 * @author Harshil
 */
public class ConfigureABusiness {
    private static Object systemOrg;
    
    public static Business configureBusiness()
    {
        Business business=Business.getInstance();
        
        
          VaccineEcoSystem vaccineEcoSystem = new VaccineEcoSystem ("Vaccine SYSTEM","Globe",Network.NetworkType.GLOBE.getValue() );
          business.setVaccineEcoSystem(vaccineEcoSystem);
                    
          //Configuring Employee and Administrator for System
          Employee employee= vaccineEcoSystem.getEmployeeDirectory().createEmployee("Harshil Korani","");
          Role systemAdminRole=new SystemAdminRole();
          
          //Creating user Account for System Administrator
          UserAccount systemAdminUserAccount= vaccineEcoSystem.getUserAccountDirectory().createUserAccount();
          systemAdminUserAccount.setEmployee(employee);
          systemAdminUserAccount.setRole(systemAdminRole);
          systemAdminUserAccount.setUsername("sysAdmin");
          systemAdminUserAccount.setPassword("sysAdmin");
                    
        return business;
    }
    
}
