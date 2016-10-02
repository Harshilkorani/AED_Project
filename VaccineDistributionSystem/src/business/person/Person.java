/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

/**
 *
 * @author Harshil
 */
public class Person {

    private int personId;
    private String firstName;
    private String lastName;    
    
    private static int personCounter=1000;
    //Constructor
    public Person(String firstName, String lastName)
    {
        personId=personCounter++;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    
    //Getter and Setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
