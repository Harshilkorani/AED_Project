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
import userinterface.ManageOrganizationsJPanel;

/**
 *
 * @author Harshil
 */
public class MedicalEnterpriseRole extends Role{

    public MedicalEnterpriseRole()
    {
        super(Role.RoleType.MedicalEnterpriseAdmin.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization enterpriseOrganization, Site site, Organization nodeOrganization, Business business) {
        
    ManageOrganizationsJPanel managePanel = new ManageOrganizationsJPanel(userProcessContainer,account, enterprise, business);
        return managePanel;
    
    }
    
}
