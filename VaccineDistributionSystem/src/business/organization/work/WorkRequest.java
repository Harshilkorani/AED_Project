/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.work;

import business.organization.useraccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Harshil
 */
public abstract class WorkRequest {
    
    private int workRequestId;
    private static int workRequestCounter=100;
    private String workRequestType;
    private UserAccount senderUserAccount;
    private UserAccount receivingUserAccount;
    private Date requestDate;
    private Date resolveDate;
    private UserAccount originalSender;
    private String status = StatusType.Received.getValue();
    
    //Enum for work Request status
   public enum StatusType
    {
        Assigned("Assigned"),Received("Received"),Pending("Pending"),
        InProcess("In Process"), Rejected("Rejected"), OnHold("On Hold"),
        VaccineRequested("Vaccine Requested"),Forwarded("Forwarded"),
        Completed("Completed"),Disptached("Dispatched"),Delivered("Delivered");
        
        private String value;
        
        private StatusType(String value)
        {
            this.value=value;
        }
        
        public String getValue()
        {
            return value;
        }
    }
    
    
    //Enum Type for new Work Request
     public enum WorkRequestType {
     VaccineWorkRequestToProvider("Vaccine Work Request to Provider"),
     VaccineWorkRequestToDPH("Vaccine Work Request to DPH"),
     VaccineWorkRequestToCDC("Vaccine Work Request to CDC"),
     VaccineWorkRequestToDistributor("Vaccine Work Request to Distributor"),
     BillingWorkRequestToProviderByDistributor("Billing Work Request to Provider by Distributor")
     ;
     
     private String value;
     private WorkRequestType(String value) 
     {
            this.value = value;
     }
     public String getValue() 
     {
            return value;
     }
   }
     
     //Constructor 
     public WorkRequest(String workRequestType)
     {
         requestDate = new Date();
         this.workRequestType = workRequestType;
         workRequestId = workRequestCounter++;
     }

    //Getter and Setter
    public int getWorkRequestId() {
        return workRequestId;
    }

    public void setWorkRequestId(int workRequestId) {
        this.workRequestId = workRequestId;
    }

    public String getWorkRequestType() {
        return workRequestType;
    }

    public void setWorkRequestType(String workRequestType) {
        this.workRequestType = workRequestType;
    }

    public UserAccount getSenderUserAccount() {
        return senderUserAccount;
    }

    public void setSenderUserAccount(UserAccount senderUserAccount) {
        this.senderUserAccount = senderUserAccount;
    }

    public UserAccount getReceivingUserAccount() {
        return receivingUserAccount;
    }

    public void setReceivingUserAccount(UserAccount receivingUserAccount) {
        this.receivingUserAccount = receivingUserAccount;
    }

    
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(this.workRequestId);
    }

    public UserAccount getOriginalSender() {
        return originalSender;
    }

    public void setOriginalSender(UserAccount originalSender) {
        this.originalSender = originalSender;
    }
    
    
    
}
