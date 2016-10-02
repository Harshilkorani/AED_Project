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
import userinterface.cdcenterprise.CDCEnterpriseJPanel;

/**
 *
 * @author Harshil
 */
public class CDCEnterpriseRole extends Role{

    public CDCEnterpriseRole()
    {
        super(Role.RoleType.CDCEnterpriseAdmin.getValue());
    }
        

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization enterpriseOrganization, Site site, Organization nodeOrganization, Business business) {
    
        CDCEnterpriseJPanel cdcPanel = new CDCEnterpriseJPanel(userProcessContainer,account,network,enterprise,enterpriseOrganization,business);
        return cdcPanel;
    }
    
   
}
