/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.useraccount;

import business.communication.Contact;
import business.communication.Location;
import business.organization.employee.Employee;
import business.organization.work.WorkQueue;
import business.role.Role;

/**
 *
 * @author Harshil
 */
public class UserAccount {
    
    private int userAccountId;
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private static int userAccountCounter = 100;
    private Contact contact;
    private Location location;
    //Constructor
    public UserAccount() {
        userAccountId = userAccountCounter++;
        
        this.workQueue = new WorkQueue();
        contact = new Contact();
        location = new Location();
    }
    
    //Getter and Setter
    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
       
    @Override
    public String toString()
    {
        return this.username;
    }
    
    
}
