/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.medicalenterpriseOrganizations;

import business.organization.Organization;
import business.role.ProviderRole;
import business.role.Role;

import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class ProviderManagementOrganization extends Organization {

    
    public ProviderManagementOrganization(String organizationName) {
        super(organizationName, Organization.OrganizationType.ProviderManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
    
        ArrayList<business.role.Role> roles=new ArrayList<>();
        roles.add(new ProviderRole());
        return roles;    
    }
    
}
