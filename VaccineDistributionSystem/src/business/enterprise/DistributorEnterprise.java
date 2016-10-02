/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.DistributorEnterpriseRole;
import business.role.Role;
import business.site.siteVaccineOrder.VaccineMasterOrderCatalog;
import business.vaccine.VaccineCatalog;
import business.vaccineStock.VaccineStockCatalog;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class DistributorEnterprise extends Enterprise{
    
    
   // private VaccineCatalog approvedVaccineCatalog;
   // private VaccineMasterOrderCatalog vaccineMasterOrderCatalog;
    private VaccineStockCatalog vaccineStockCatalog;
    
    public DistributorEnterprise(String organizationName)
    {
        super(organizationName, Enterprise.EnterpriseType.DistributorEnterprise.getValue());
        
     //   vaccineMasterOrderCatalog = new VaccineMasterOrderCatalog();
        this.vaccineStockCatalog = new VaccineStockCatalog();
        
    }

    
    public VaccineStockCatalog getVaccineStockCatalog() {
        return vaccineStockCatalog;
    }

    public void setVaccineStockCatalog(VaccineStockCatalog vaccineStockCatalog) {
        this.vaccineStockCatalog = vaccineStockCatalog;
    }
    

    @Override
    public ArrayList<Role> getSupportedRoles() {
        
        ArrayList<Role> roles=new ArrayList<>();
        roles.add(new DistributorEnterpriseRole());
        return roles;
    
    }
    

}
