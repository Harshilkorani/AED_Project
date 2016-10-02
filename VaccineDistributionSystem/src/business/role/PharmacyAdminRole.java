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
import userinterface.medicalEnterprise.Site.Pharmacy.PharmacyAdminJPanel;

/**
 *
 * @author Harshil
 */
public class PharmacyAdminRole extends Role{

    public PharmacyAdminRole() {
        
        super(Role.RoleType.PharmacyAdminRole.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization enterpriseOrganization, Site site, Organization nodeOrganization, Business business) {
    
        PharmacyAdminJPanel pharmacyAdminJPanel = new PharmacyAdminJPanel (userProcessContainer,account,network,(MedicalEnterprise)enterprise,enterpriseOrganization,site,business);
        return pharmacyAdminJPanel;
    
    }
    
}
