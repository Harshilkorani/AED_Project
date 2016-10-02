/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.siteOrganization;

import business.organization.Organization;
import business.role.InventoryManagerRole;
import business.role.Role;
import static business.role.Role.RoleType.InventoryManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class InventoryManagementOrg extends Organization{

    public InventoryManagementOrg(String organizationName)
    {
        super(organizationName, Organization.OrganizationType.InventoryManagement.getValue());        
    }
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
        
        ArrayList<business.role.Role> roles = new ArrayList<>();
        roles.add(new InventoryManagerRole());
        return roles;
    
    }
    
}
