/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.vaccineEcoSystem;

import business.network.Network;
import business.organization.Organization;
import business.role.Role;
import business.role.SystemAdminRole;
import business.site.siteVaccineOrder.VaccineMasterOrderCatalog;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class VaccineEcoSystem extends Organization{
    
    //Start of Network tree in the Vaccine EcoSystem
    private Network rootNetwork;
    private VaccineMasterOrderCatalog systemWideVaccineMasterOrderCatalog;
    
    
    //Constructor
    //Passes the Organization Name and Organization Type as  "SYSTEM" to the the organization class
    //Creation of 'Globe' Network takes place at this step
    public VaccineEcoSystem(String systemName, String rootNetworkName, String rootNetworkType)
    {
        super(systemName,"SYSTEM");
        rootNetwork = new Network(rootNetworkName,rootNetworkType);
        systemWideVaccineMasterOrderCatalog = new VaccineMasterOrderCatalog();
    }
    
    //Getter and Setter Methods
    public Network getRootNetwork() {
        return rootNetwork;
    }
    public void setRootNetwork(Network rootNetwork) {
        this.rootNetwork = rootNetwork;
    }
 
    public boolean checkIfUserNameIsPresent(String userName)
    {
      
        for(Network network:getAllNetwork())
        {
            if(network.getEnterpriseDirectory().checkIfUserNameIsPresent(userName))
            {
                return true;
            }   
        }
        return false;
    }
    
    
    public ArrayList<Network> getAllNetwork()
    {
        
        ArrayList<Network> finalNetworkList = new ArrayList<>();
        finalNetworkList.add(rootNetwork);
        for(Network country: rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
           finalNetworkList.add(country);
            for(Network state:country.getSubNetworkDirectory().getNetworkList())
            {
               finalNetworkList.add(state);
                for(Network city: state.getSubNetworkDirectory().getNetworkList())
                {
                    finalNetworkList.add(city);
                }
            }
        }
        return finalNetworkList;
}

    public VaccineMasterOrderCatalog getSystemWideVaccineMasterOrderCatalog() {
        return systemWideVaccineMasterOrderCatalog;
    }

    public void setSystemWideVaccineMasterOrderCatalog(VaccineMasterOrderCatalog systemWideVaccineMasterOrderCatalog) {
        this.systemWideVaccineMasterOrderCatalog = systemWideVaccineMasterOrderCatalog;
    }
       
    //Method to return the array list of supported roles by System organization
    @Override
    public ArrayList<Role> getSupportedRoles() {
    
        ArrayList<Role> roles;
        roles=new ArrayList<>();
        roles.add(new SystemAdminRole());
        return roles;    
    }

}