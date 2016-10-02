/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.vaccineEcoSystem.VaccineEcoSystem;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class NetworkDirectory {
    
     //Variable Declaration
    private ArrayList<Network> networkList;
 
    //Constructor
    //Initialization of Network list
    private VaccineEcoSystem vaccineEcosystem = business.Business.getInstance().getVaccineEcoSystem();
    public NetworkDirectory()
    {
        networkList = new ArrayList<>();       
    }

    //Getter and Setter
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    //Creation and Removal of Network object in Network Directory
    public Network createNetwork(String networkName, String networkType){
        Network network=new Network(networkName, networkType);
        networkList.add(network);
        return network;
    }
    public void removeNetwork(Network network){
        networkList.remove(network);
    } 
    
    public boolean isPresent(Network network)
    {
        for(Network net:networkList)
        {
            if(net==network)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPresent(String networkName)
    {
        for(Network network:networkList)
        {
            if(network.getNetworkName().equalsIgnoreCase(networkName))
            {
                return true;
            }
        }
        return false;
    }
    
}
