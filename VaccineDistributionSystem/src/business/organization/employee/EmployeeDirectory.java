/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.employee;

import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;
    
    public  EmployeeDirectory()
    {
        employeeList=new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public Employee createEmployee(String firstName, String lastName)
    {
        Employee employee=new Employee(firstName, lastName);
        employeeList.add(employee);
        return employee;
    }
    
    public void removeEmployee(Employee employee)
    {
        employeeList.remove(employee);
    }
    
    public boolean isPresent(Employee employee)
    {
        for(Employee emp:employeeList)
        {
            if(employee==emp)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPresent(String firstName, String lastName, String emailId)
    {
        for(Employee employee:employeeList)
        {
            if(employee.getPerson()!=null)
            {
            if(employee.getPerson().getFirstName().equalsIgnoreCase(firstName) &&
               employee.getPerson().getLastName().equalsIgnoreCase(lastName) &&
               employee.getContact().getEmailId().equalsIgnoreCase(emailId))
            {
                return true;
            }
            }
            else
            {
                
            }
        }
        return false;
    }
    
    
}
