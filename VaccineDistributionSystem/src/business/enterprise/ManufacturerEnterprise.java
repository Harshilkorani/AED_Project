/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.ManufacturerEnterpriseRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class ManufacturerEnterprise extends Enterprise{
    
    public ManufacturerEnterprise(String organizationName)
    {
        super(organizationName, Enterprise.EnterpriseType.ManufacturerEnterprise.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
    
        ArrayList<Role> roles=new ArrayList<>();
        roles.add(new ManufacturerEnterpriseRole());
        return roles;
        
    }
    
}
