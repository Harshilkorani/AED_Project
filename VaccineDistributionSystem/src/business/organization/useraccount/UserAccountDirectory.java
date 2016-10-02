/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.useraccount;

import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory()
    {
        userAccountList=new ArrayList<>();
    }
    
   public UserAccount createUserAccount()
   {
       UserAccount userAccount=new UserAccount();
       userAccountList.add(userAccount);
       return userAccount;
   }
   
   public void removeUserAccount(UserAccount userAccount)
   {
       userAccountList.remove(userAccount);
   }
    
    public UserAccount authenticateUserAccount(String userName, String password)
    {
        
        for(UserAccount userAccount:userAccountList)
        {
            
            if(userAccount.getUsername().equalsIgnoreCase(userName) && userAccount.getPassword().equalsIgnoreCase(password))
            {
                return userAccount;
            }
        }
        
        return null;
    }
    
    public boolean userNameIsPresent(String userName)
    {
         for(UserAccount userAccount:userAccountList)
        {
            if(userAccount.getUsername().equalsIgnoreCase(userName))
            {
                return true;
            }
        }
         return false;
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
}
