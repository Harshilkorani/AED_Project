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
import userinterface.medicalEnterprise.Site.Hospital.HospitalAdminJPanel;

/**
 *
 * @author Harshil
 */
public class HospitalAdminRole extends Role{

    public HospitalAdminRole() {
        
        super(Role.RoleType.HospitalAdminRole.getValue());
    }


    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Network network, Enterprise enterprise, Organization enterpriseOrganization, Site site, Organization nodeOrganization, Business business) {
    
        HospitalAdminJPanel hospitalAdminJPanel = new HospitalAdminJPanel (userProcessContainer,account,network,(MedicalEnterprise)enterprise,enterpriseOrganization,site,business);
        return hospitalAdminJPanel;
    
    }
    
}
