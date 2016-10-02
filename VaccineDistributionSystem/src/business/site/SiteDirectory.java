/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.site;

import business.communication.Contact;
import business.communication.Location;
//import static business.site.Site.SiteTypes.Hospital;
import business.site.sitetypes.Clinic;
import business.site.sitetypes.Hospital;
import business.site.sitetypes.Pharmacy;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class SiteDirectory {
    
    private ArrayList<Site> siteList;

    public SiteDirectory() {
                siteList = new ArrayList<>();
    }
 public ArrayList<Site> getSiteList()
    {
        return siteList;
    }

    //Getter and Setter
    public void setSiteList(ArrayList<Site> siteList) {
        this.siteList = siteList;
    }

    //Creation of New Node
    public Site createSite(String siteName, String type, Location location, Contact contact) {
        Site site = null;
        if(Site.SiteTypes.Hospital.getValue().equals(type))
        {
            site = new Hospital(siteName, location, contact);
            siteList.add(site);
        }
        else if(Site.SiteTypes.Clinic.getValue().equals(type))
        {
            site = new Clinic(siteName,location,contact);
            siteList.add(site);
        }
        else if(Site.SiteTypes.Pharmacy.getValue().equals(type))
        {
            site = new Pharmacy(siteName, location, contact);
            siteList.add(site);
        }
        return site;
    }
 
  //Removal of Node
 public void removeSite(Site site)
 {
     siteList.remove(site);
 }
 
 //check for node
 public boolean isPresent(Site site)
 {
     for(Site tempSite:siteList)
     {
         if(tempSite == site)
             return true;
     }
     return false;
 }
 
 
 //check for Node name
 public boolean isPresent(String siteName)
 {
     for(Site site:siteList)
     {
         if(site.getOrganizationName().equalsIgnoreCase(siteName))
         {
             return true;
         }
     }
     
     return false;
 }
    
}
