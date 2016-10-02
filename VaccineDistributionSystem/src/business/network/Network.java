/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.communication.Location;
import business.enterprise.CDCEnterprise;
import business.enterprise.DPHEnterprise;
import business.enterprise.DistributorEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.Enterprise.EnterpriseType;
import static business.enterprise.Enterprise.EnterpriseType.DPHEnterprise;
import business.enterprise.EnterpriseDirectory;
import business.enterprise.MedicalEnterprise;
import business.vaccineEcoSystem.VaccineEcoSystem;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class Network {
    
    
     //Data Members
    private static int counter=1;
    private int networkId;
    private String networkName;
    private String networkType;
    private NetworkDirectory subNetworkDirectory;   
    private EnterpriseDirectory enterpriseDirectory;
    private Enterprise enterprise;
    private VaccineEcoSystem vaccineEcoSystem = business.Business.getInstance().getVaccineEcoSystem();
    
    
    //Enum for Possible Networks in the system
    public enum NetworkType
   {
        GLOBE("GLOBE"),
        COUNTRY("Country"),
        STATE("State"),
        City("City");
                
        private String value;
        private NetworkType(String value) 
        {
            this.value = value;
        }
        public String getValue() 
        {
            return value;
        }
   }
    
    //Constructor
    //Accepts the Network Name and the Network Hierarchy type such as Country, State, City and Area
    //Creates sub Network Directory
    //Creates Enterprise Directory
    
    public Network(String networkName, String networkType)
    {
        networkId = counter++;
        this.networkName = networkName;
        this.networkType = networkType;
        
        subNetworkDirectory = new NetworkDirectory();
        enterpriseDirectory = new EnterpriseDirectory();
    }

     //Getter and Setter
    public String getNetworkType() {
        return networkType;
    }
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }
    public NetworkDirectory getSubNetworkDirectory() {
        return subNetworkDirectory;
    }
    public void setSubNetworkDirectory(NetworkDirectory subNetworkDirectory) {
        this.subNetworkDirectory = subNetworkDirectory;
    }
    public int getNetworkId() {
        return networkId;
    }
    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }
    public String getNetworkName() {
        return networkName;
    }
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }   

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    
    
    public Network findCityNetwork(String countryName, String stateName, String cityName)
    {
        Network rootNetwork=this;
        for(Network countryNetwork:rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
            for(Network stateNetwork:countryNetwork.getSubNetworkDirectory().getNetworkList())
            {
                for(Network cityNetwork:stateNetwork.getSubNetworkDirectory().getNetworkList())
                {
                    if(countryNetwork.getNetworkName().equalsIgnoreCase(countryName) && stateNetwork.getNetworkName().equalsIgnoreCase(stateName)&& cityNetwork.getNetworkName().equalsIgnoreCase(cityName))
                    {
                        return cityNetwork;
                    }   
                }
            }
        }
        return null;
    }
    
    public Network findStateNetwork(String countryName, String stateName)
    {
        Network rootNetwork=this;
        for(Network countryNetwork:rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
            for(Network stateNetwork:countryNetwork.getSubNetworkDirectory().getNetworkList())
            {
                if(countryNetwork.getNetworkName().equalsIgnoreCase(countryName) && stateNetwork.getNetworkName().equalsIgnoreCase(stateName))
                {
                    return stateNetwork;
                }   
            }
        }
        return null;
    }
    
    public  Network findCountryNetwork(String countryName)
    {
        Network rootNetwork = this;
        for(Network countryNetwork:rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
            if(countryNetwork.getNetworkName().equalsIgnoreCase(countryName))
            return countryNetwork;
        }
        return null;
    }
    
    public Network getParentNetwork()
    {
        //For Globe , there is no parent Network
       if(this.networkType.equalsIgnoreCase(Network.NetworkType.GLOBE.getValue()))
       {
           return vaccineEcoSystem.getRootNetwork();
       }
            
       for(Network net: vaccineEcoSystem.getAllNetwork())
       {
           if(net.getSubNetworkDirectory().isPresent(this))
           {
               return net;
           }
       }
       return null;
    }
    
    
    public Network getParentNetwork(Network network)
    {
        //For Globe , there is no parent Network
       if(network.networkType.equalsIgnoreCase(Network.NetworkType.GLOBE.getValue()))
       {
           return vaccineEcoSystem.getRootNetwork();
       }
        
       for(Network net: vaccineEcoSystem.getAllNetwork())
       {
           if(net.getSubNetworkDirectory().isPresent(network))
           {
               return net;
           }
       }
       return null;
    }
    
    
    public EnterpriseDirectory getAllCDCEnterprise()
    {
        EnterpriseDirectory cdcEnterpriseDirectory = new EnterpriseDirectory();
        for(Enterprise enterprise:enterpriseDirectory.getEnterpriseList())
        {
            if(enterprise instanceof CDCEnterprise)
            {
                cdcEnterpriseDirectory.getEnterpriseList().add(enterprise);
            }
        }
        return cdcEnterpriseDirectory;
    }
    
    
    public EnterpriseDirectory getAllMedicalEnterprise()
    {
        EnterpriseDirectory medicalEnterpriseDirectory = new EnterpriseDirectory();
        for(Enterprise enterprise:enterpriseDirectory.getEnterpriseList())
        {
            if(enterprise instanceof MedicalEnterprise)
            {
                medicalEnterpriseDirectory.getEnterpriseList().add(enterprise);
            }
        }
        return medicalEnterpriseDirectory;
    }
    
    public EnterpriseDirectory getAllDistributorEnterprise()
    {
        EnterpriseDirectory distributorEnterpriseDirectory = new EnterpriseDirectory();
        for(Enterprise enterprise:enterpriseDirectory.getEnterpriseList())
        {
            if(enterprise instanceof DistributorEnterprise)
            {
                distributorEnterpriseDirectory.getEnterpriseList().add(enterprise);
            }
        }
        return distributorEnterpriseDirectory;
        
    }
    
    public EnterpriseDirectory getAllDPHEnterprise()
    {
        EnterpriseDirectory dphEnterpriseDirectory = new EnterpriseDirectory();
        for(Enterprise enterprise:enterpriseDirectory.getEnterpriseList())
        {
            if(enterprise instanceof DPHEnterprise)
            {
                dphEnterpriseDirectory.getEnterpriseList().add(enterprise);
            }
        }
        return dphEnterpriseDirectory;
        
    }
         
    @Override
    public String toString()
    {
        return networkName;
    }
    
    
}
