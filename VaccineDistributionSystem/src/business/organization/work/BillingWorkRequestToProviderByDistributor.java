/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.work;

import business.site.siteVaccineOrder.VaccineOrder;

/**
 *
 * @author Harshil
 */
public class BillingWorkRequestToProviderByDistributor extends WorkRequest{
    
    
    VaccineOrder vaccineOrder;
    
    public BillingWorkRequestToProviderByDistributor()
    {
        super(WorkRequest.WorkRequestType.VaccineWorkRequestToProvider.getValue());
    }

    public VaccineOrder getVaccineOrder() {
        return vaccineOrder;
    }

    public void setVaccineOrder(VaccineOrder vaccineOrder) {
        this.vaccineOrder = vaccineOrder;
    }
    
    
    
}
