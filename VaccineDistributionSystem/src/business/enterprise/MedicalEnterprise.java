/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.MedicalEnterpriseRole;
import business.role.Role;
import business.site.SiteDirectory;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class MedicalEnterprise extends Enterprise{

    private SiteDirectory siteDirectory;
    
    public MedicalEnterprise(String organizationName)
    {
        super(organizationName, Enterprise.EnterpriseType.MedicalEnterprise.getValue());
        siteDirectory = new SiteDirectory();
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
    
        ArrayList<Role> roles=new ArrayList<>();
        roles.add(new MedicalEnterpriseRole());
        return roles;
    
    
    }

    public SiteDirectory getSiteDirectory() {
        return siteDirectory;
    }

    public void setSiteDirectory(SiteDirectory siteDirectory) {
        this.siteDirectory = siteDirectory;
    }
    
    
    
    
}
