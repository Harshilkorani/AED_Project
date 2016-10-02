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
import business.site.Site;
import javax.swing.JPanel;
import userinterface.systemAdmin.SystemAdminJPanel;

/**
 *
 * @author Harshil
 */
public class SystemAdminRole extends Role{
    
    
    public SystemAdminRole()
    {
        super(Role.RoleType.SystemAdmin.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization enterpriseOrganization, Site site, Organization nodeOrganization, Business business) {
        
    SystemAdminJPanel systemAdminWorkAreaJPanel = new SystemAdminJPanel (userProcessContainer,account,business);
        return systemAdminWorkAreaJPanel;
    
    }
    
}
