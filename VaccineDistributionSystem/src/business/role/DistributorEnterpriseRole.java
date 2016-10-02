/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.Business;
import business.enterprise.Enterprise;
import business.enterprise.MedicalEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.useraccount.UserAccount;
import business.site.Site;
import javax.swing.JPanel;
import userinterface.distributorEnterprise.DistributorEnterpriseJPanel;
import userinterface.distributorEnterprise.ManageApprovedVaccineStockCatalogJPanel;

/**
 *
 * @author Harshil
 */
public class DistributorEnterpriseRole extends Role{
    
    
    public DistributorEnterpriseRole()
    {
        super(Role.RoleType.DistributorEnterpriseAdmin.getValue());
    }


    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization enterpriseOrganization, Site site, Organization nodeOrganization, Business business) {
       
        DistributorEnterpriseJPanel distributorPanel = new DistributorEnterpriseJPanel(userProcessContainer,account,network,enterprise,enterpriseOrganization,business);
        return distributorPanel;
    
    }
    
}
