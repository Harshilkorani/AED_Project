/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.employee;

import business.communication.Contact;
import business.person.Person;

/**
 *
 * @author Harshil
 */
public class Employee {
    
    static int employeeCounter = 2500;
    private int employeeId;
    Person person;
    
    private Contact contact;

    public Employee(String firstName, String lastName)
    {
        employeeId=employeeCounter++;
        contact=new Contact();
        person = new Person(firstName, lastName);
        
    }

   
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
 
    @Override
    public String toString()
    {
        return employeeId+"";
    }
    
}
