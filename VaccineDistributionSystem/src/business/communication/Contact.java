/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.communication;

/**
 *
 * @author Harshil
 */
public class Contact {
    
    private String emailId;
    private String primaryPhoneNumber;
    private String secondaryPhoneNumber;

    //Constructor
    public Contact()
    {
        
    }
    
    //Getter and Setter
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }
    
    public void setContactData(String primaryPhoneNo, String secondaryPhoneNo, String emailId)
    {
        this.setEmailId(emailId);
        this.setPrimaryPhoneNumber(primaryPhoneNo);
        this.setSecondaryPhoneNumber(secondaryPhoneNo);
    }
    
}
