/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Harshil
 */
public class Validation {
    
    public static boolean validateTableSelection(JTable table, int noOfRows)
    {
        if(table.getSelectedRowCount()==noOfRows)
        return true;
        else return false;
    }
    
    public static boolean validateTextFieldsForAmount(JTextField textField)
    {
        try
        {
            Double value=Double.parseDouble(textField.getText().trim());
            if(value<=0)
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    
    public static boolean validateTextFieldForPercentage(JTextField textField)
    {
        try
        {
            Double percentage=Double.parseDouble(textField.getText().trim());
            if(percentage<=100.0 &&percentage>=0.0)
            {
                return true;
            }
            else
             return false;
            
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public static boolean validateTextAreaForNonEmpty(JTextArea txtArea )
    {
        if(txtArea.getText().trim().equalsIgnoreCase(""))
        {
            return false;
        }
        else return true;
    }
    
    public static boolean validateTextFieldsForNonEmpty(JTextField textField)
    {
        if(textField.getText().trim().equalsIgnoreCase(""))
        {
            return false;
        }
        else return true;
    }
    
    public static boolean validateTextFieldsForString(JTextField textField)
    {
        return true;
    }
   
    public static boolean validateTextFieldsForInteger(JTextField textField)
    {
        try
        {
            int a=Integer.parseInt(textField.getText().trim());
            if(a<0)
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    
    public static boolean validateTextFieldsForNumber(JTextField textField)
    {
        return true;
    }
    
    public static boolean validateTextFieldsForPhoneNumber(JTextField textField)
    {
        Pattern patternMobileNumber = Pattern.compile("\\d{10}");
        Matcher matcher = patternMobileNumber.matcher(textField.getText().trim());
        return matcher.matches();
    }
    
    public static boolean validateTextFieldsForEmailId(JTextField textField)
    {
        try
        {
        String patternEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Boolean flag = textField.getText().trim().matches(patternEmail);
        return flag;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public static boolean validateTextFieldsForUserName(JTextField txtUserName)
    {
        return true;
    }
    
    
    
    public static boolean validateComboBoxForSelection(JComboBox comboBox)
    {
        if(comboBox.getSelectedIndex()!=-1)
        return true;
        else 
        return false;
        
    }
    
    public static boolean validateTextFieldForPassword(JTextField txtPassowrd)
    {
       return true;
    }
    
    
}
