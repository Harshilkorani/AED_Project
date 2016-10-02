/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.medicalenterpriseOrganizations;

import business.organization.Organization;
import business.role.Role;
import business.role.SiteConfiguratorRole;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class SitesManagementOrganization extends Organization{

    public SitesManagementOrganization(String organizationName) {
        super(organizationName, Organization.OrganizationType.SitesManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
    
        ArrayList<business.role.Role> roles=new ArrayList<>();
        roles.add(new SiteConfiguratorRole());
        return roles;    
    }
    
}
