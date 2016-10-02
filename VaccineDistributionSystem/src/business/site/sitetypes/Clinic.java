/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.site.sitetypes;

import business.communication.Contact;
import business.communication.Location;
import business.role.ClinicAdminRole;
import business.role.Role;
import business.site.Site;
import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class Clinic extends Site{
    
    public Clinic(String siteName, Location location, Contact contact)
    {
        super(siteName, Site.SiteTypes.Clinic.getValue(),location,contact);
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
    
        ArrayList<business.role.Role> roles=new ArrayList<>();
        roles.add(new ClinicAdminRole());
        return roles;
    
    }
    
}
