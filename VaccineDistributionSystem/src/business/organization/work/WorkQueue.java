/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.work;

import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;
    
    
    //Constructor
    public WorkQueue()
    {
        workRequestList=new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(ArrayList<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }
    
    
    /*
    
    public WorkRequest createWorkRequest(String workRequestType)
    {
        if(workRequestType.equalsIgnoreCase(WorkRequest.WorkRequestType.VaccineWorkRequestToProvider.getValue()))
        {
            WorkRequest workRequest = new VaccineWorkRequestToProvider();
            workRequestList.add(workRequest);
            return workRequest;
        }
        /*
        else if(workRequestType.equalsIgnoreCase(WorkRequest.WorkRequestType.VaccineWorkRequestToDPH.getValue()))
        {
            WorkRequest workRequest = new VaccineWorkRequestToDPH();
            workRequestList.add(workRequest);
            return workRequest;
        }
        else if(workRequestType.equalsIgnoreCase(WorkRequest.WorkRequestType.VaccineWorkRequestToCDC.getValue()))
        {
            WorkRequest workRequest = new VaccineWorkRequestToCDC();
            workRequestList.add(workRequest);
            return workRequest;
        }
        else if(workRequestType.equalsIgnoreCase(WorkRequest.WorkRequestType.VaccineWorkRequestToDistributor.getValue()))
        {
            WorkRequest workRequest = new VaccineWorkRequestToDistributor();
            workRequestList.add(workRequest);
            return workRequest;
        }
        else if(workRequestType.equalsIgnoreCase(WorkRequest.WorkRequestType.BillingWorkRequestToProviderByDistributor.getValue()))
        {
            WorkRequest workRequest = new BillingWorkRequestToProviderByDistributor();
            workRequestList.add(workRequest);
            return workRequest;
        }
                
        return null;
    }
    
    
    public void removeWorkRequest(WorkRequest workRequest)
    {
        workRequestList.remove(workRequest);
    }
    
    */
    
}
