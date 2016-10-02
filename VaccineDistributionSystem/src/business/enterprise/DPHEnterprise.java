/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.DPHEnterpriseRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class DPHEnterprise extends Enterprise{

    public DPHEnterprise(String organizationName)
    {
        super(organizationName, Enterprise.EnterpriseType.DPHEnterprise.getValue());
       
    }
    
   
    @Override
    public ArrayList<Role> getSupportedRoles() {
        
        ArrayList<Role> roles=new ArrayList<>();
        roles.add(new DPHEnterpriseRole());
        return roles;
    
    }
    
}
