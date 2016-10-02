/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.CDCEnterpriseRole;
import business.role.Role;
import business.site.siteVaccineOrder.VaccineMasterOrderCatalog;
import business.vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class CDCEnterprise extends Enterprise{

    private VaccineCatalog approvedVaccineCatalog;
    
    public CDCEnterprise(String organizationName)
    {
        super(organizationName, Enterprise.EnterpriseType.CDCEnterprise.getValue());
        
        this.approvedVaccineCatalog = new VaccineCatalog();
    }

    public VaccineCatalog getApprovedVaccineCatalog() {
        return approvedVaccineCatalog;
    }

    public void setApprovedVaccineCatalog(VaccineCatalog approvedVaccineCatalog) {
        this.approvedVaccineCatalog = approvedVaccineCatalog;
    }    
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
        
        ArrayList<Role> roles=new ArrayList<>();
        roles.add(new CDCEnterpriseRole());
        return roles;
    
    }
    
}
