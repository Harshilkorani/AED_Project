/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.systemAdmin;

import business.Business;
import business.communication.Contact;
import business.communication.Location;
import business.enterprise.Enterprise;
import business.organization.useraccount.UserAccount;
import business.utility.Validation;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.ManageOrganizationEmployeeJPanel;
import userinterface.ManageOrganizationUserJPanel;

/**
 *
 * @author Harshil
 */
public class ConfigureEnterpriseJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConfigureEnterpriseJPanel
     */
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Business business;
    
    public ConfigureEnterpriseJPanel(JPanel userProcessContainer,UserAccount userAccount ,Enterprise enterprise, Business business) {
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        
        initComponents();
        initializeFormData();
    }
    
    private void initializeFormData()
    {
        lblConfigureEnterprise.setText("Configure - "+enterprise.getOrganizationName());
        populateFormDataWith(enterprise);
    }
    

    private void enableValidators(boolean flag)
    {
        lblNodeNameValidator.setEnabled(flag);
        lblPrimaryPhoneNumberValidator.setEnabled(flag);
        lblEmailIdValidator.setEnabled(flag);
        
    }
    
    private void setValidatorsToDefault()
    {
        lblNodeNameValidator.setText("");
        lblPrimaryPhoneNumberValidator.setText("");
        lblSecondaryPhoneNoVal.setText("");
        lblEmailIdValidator.setText("");
    }
    
    public boolean validateFormFields()
    {
        enableValidators(false);
        setValidatorsToDefault();
         
        if(!txtPrimaryPhoneNumber.getText().trim().equalsIgnoreCase(""))
        {
                if(!Validation.validateTextFieldsForPhoneNumber(txtPrimaryPhoneNumber))
                {
                    lblPrimaryPhoneNumberValidator.setText("Please enter valid Primary Phone Number");
                   
                }
        }
            
        if(!txtSecondaryPhoneNumber.getText().trim().equalsIgnoreCase(""))
        {
                if(!Validation.validateTextFieldsForPhoneNumber(txtSecondaryPhoneNumber))
                {
                    lblSecondaryPhoneNoVal.setText("Please enter valid Secondary Phone Number");
                }
        }
            
            
        if(!txtEmailId.getText().trim().equalsIgnoreCase(""))
        {
                if(!Validation.validateTextFieldsForEmailId(txtEmailId))
                {
                    lblEmailIdValidator.setText("Please enter valid email id");
                }
        }
          
        if
        (
                !lblNodeNameValidator.getText().equalsIgnoreCase("")||
                !lblPrimaryPhoneNumberValidator.getText().equalsIgnoreCase("")||
                !lblEmailIdValidator.getText().equalsIgnoreCase("")||
                !lblSecondaryPhoneNoVal.getText().equalsIgnoreCase("")
        )
        {
                enableValidators(true);
                return false;
        }
        else return true;
                        
    }
    
    
 private boolean validateForUniqueEnterpriseName(String enterpriseName)
 {
     //Write the code For Validation
     return true;
 }
    
 
 private void fillEnterpriseWithFormData(Enterprise enterprise)
    {
        enterprise.setOrganizationName(txtNodeName.getText().trim());
        
        Location location = enterprise.getEnterpriseHeadquarters();
        Contact contact = enterprise.getEnterpriseContact();
        
        location.setAddressLine1(txtAddressLine1.getText().trim());
        location.setAddressLine2(txtAddressLine2.getText().trim());
        location.setCity(txtCity.getText().trim());
        location.setState(txtState.getText().trim());
        location.setCountry(txtCountry.getText().trim());
        
        contact.setPrimaryPhoneNumber(txtPrimaryPhoneNumber.getText().trim());
        contact.setSecondaryPhoneNumber(txtSecondaryPhoneNumber.getText().trim());
        contact.setEmailId(txtEmailId.getText().trim());
        
    }
    
    
     private void viewForm(boolean flag)
    {
        
        lblNodeName.setEnabled(flag);
        txtNodeName.setEnabled(flag);
        
        lblLocation.setEnabled(flag);
        
        txtNodeName.setEnabled(flag);
        txtAddressLine1.setEnabled(flag);
        txtAddressLine2.setEnabled(flag);
        txtCity.setEnabled(flag);
        txtState.setEnabled(flag);
        txtCountry.setEnabled(flag);
        
        lblAddressLine1.setEnabled(flag);
        lblAddressLine2.setEnabled(flag);
        lblCity.setEnabled(flag);
        lblState.setEnabled(flag);
        lblCountry.setEnabled(flag);

        lblContact.setEnabled(flag);
        
        lblPrimaryPhoneNumber.setEnabled(flag);
        lblSecondaryPhoneNumber.setEnabled(flag);
        lblEmailId.setEnabled(flag);
        txtPrimaryPhoneNumber.setEnabled(flag);
        txtSecondaryPhoneNumber.setEnabled(flag);
        txtEmailId.setEnabled(flag);
        
        
        btnUpdateOrCreate.setEnabled(flag);
        
        if(flag==false)
        {
            btnUpdateOrCreate.setText("Update or Create");
        }
    }
    
    private void populateFormDataWith(Enterprise enterprise)
    {  
        
        txtNodeName.setText(enterprise.getOrganizationName());
        txtAddressLine1.setText(enterprise.getEnterpriseHeadquarters().getAddressLine1());
        txtAddressLine2.setText(enterprise.getEnterpriseHeadquarters().getAddressLine2());
        txtCity.setText(enterprise.getEnterpriseHeadquarters().getCity());
        txtState.setText(enterprise.getEnterpriseHeadquarters().getState());
        txtCountry.setText(enterprise.getEnterpriseHeadquarters().getCountry());
        txtPrimaryPhoneNumber.setText(enterprise.getEnterpriseContact().getPrimaryPhoneNumber());
        txtSecondaryPhoneNumber.setText(enterprise.getEnterpriseContact().getSecondaryPhoneNumber());
        txtEmailId.setText(enterprise.getEnterpriseContact().getEmailId());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblConfigureEnterprise = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        jPanelDataForm = new javax.swing.JPanel();
        btnUpdateOrCreate = new javax.swing.JButton();
        lblNodeName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLocation = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        lblAddressLine2 = new javax.swing.JLabel();
        txtAddressLine2 = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtNodeName = new javax.swing.JTextField();
        lblAddressLine1 = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        txtAddressLine1 = new javax.swing.JTextField();
        lblNodeNameValidator = new javax.swing.JLabel();
        txtPrimaryPhoneNumber = new javax.swing.JTextField();
        lblPrimaryPhoneNumber = new javax.swing.JLabel();
        lblSecondaryPhoneNumber = new javax.swing.JLabel();
        txtSecondaryPhoneNumber = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        lblEmailId = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblPrimaryPhoneNumberValidator = new javax.swing.JLabel();
        lblEmailIdValidator = new javax.swing.JLabel();
        lblSecondaryPhoneNoVal = new javax.swing.JLabel();
        btnManageEmployee = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(102, 102, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 104, -1, -1));

        lblConfigureEnterprise.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConfigureEnterprise.setText("Configuring Enterprise");
        add(lblConfigureEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 114, -1, -1));

        btnView.setBackground(new java.awt.Color(102, 102, 255));
        btnView.setText("EDIT");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 164, 100, -1));

        jPanelDataForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDataForm.setEnabled(false);
        jPanelDataForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdateOrCreate.setBackground(new java.awt.Color(102, 102, 255));
        btnUpdateOrCreate.setText("Save");
        btnUpdateOrCreate.setEnabled(false);
        btnUpdateOrCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrCreateActionPerformed(evt);
            }
        });
        jPanelDataForm.add(btnUpdateOrCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 140, 30));

        lblNodeName.setText("Name:");
        lblNodeName.setEnabled(false);
        jPanelDataForm.add(lblNodeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));
        jPanelDataForm.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 620, 10));

        lblLocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLocation.setText("LOCATION");
        lblLocation.setEnabled(false);
        jPanelDataForm.add(lblLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        lblCity.setText("City:");
        lblCity.setEnabled(false);
        jPanelDataForm.add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtCountry.setEnabled(false);
        txtCountry.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        lblAddressLine2.setText("Address Line 2:");
        lblAddressLine2.setEnabled(false);
        jPanelDataForm.add(lblAddressLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtAddressLine2.setEnabled(false);
        txtAddressLine2.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtAddressLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        txtState.setEnabled(false);
        txtState.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        lblState.setText("State:");
        lblState.setEnabled(false);
        jPanelDataForm.add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtCity.setEnabled(false);
        txtCity.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        txtNodeName.setEditable(false);
        txtNodeName.setEnabled(false);
        txtNodeName.setPreferredSize(new java.awt.Dimension(200, 25));
        txtNodeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNodeNameActionPerformed(evt);
            }
        });
        jPanelDataForm.add(txtNodeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 180, -1));

        lblAddressLine1.setText("Address Line 1:");
        lblAddressLine1.setEnabled(false);
        jPanelDataForm.add(lblAddressLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lblCountry.setText("Country:");
        lblCountry.setEnabled(false);
        jPanelDataForm.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtAddressLine1.setEnabled(false);
        txtAddressLine1.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtAddressLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));
        jPanelDataForm.add(lblNodeNameValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        txtPrimaryPhoneNumber.setEnabled(false);
        txtPrimaryPhoneNumber.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtPrimaryPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        lblPrimaryPhoneNumber.setText("Primary Phone No:");
        lblPrimaryPhoneNumber.setEnabled(false);
        jPanelDataForm.add(lblPrimaryPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        lblSecondaryPhoneNumber.setText("Secondary Phone No:");
        lblSecondaryPhoneNumber.setEnabled(false);
        jPanelDataForm.add(lblSecondaryPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        txtSecondaryPhoneNumber.setEnabled(false);
        txtSecondaryPhoneNumber.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtSecondaryPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        txtEmailId.setEnabled(false);
        txtEmailId.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        lblEmailId.setText("Email Id:");
        lblEmailId.setEnabled(false);
        jPanelDataForm.add(lblEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        lblContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblContact.setText("CONTACT");
        lblContact.setEnabled(false);
        jPanelDataForm.add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        lblPrimaryPhoneNumberValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblPrimaryPhoneNumberValidator.setPreferredSize(new java.awt.Dimension(250, 20));
        jPanelDataForm.add(lblPrimaryPhoneNumberValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, 20));

        lblEmailIdValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailIdValidator.setPreferredSize(new java.awt.Dimension(250, 20));
        jPanelDataForm.add(lblEmailIdValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, 20));

        lblSecondaryPhoneNoVal.setForeground(new java.awt.Color(255, 0, 0));
        lblSecondaryPhoneNoVal.setPreferredSize(new java.awt.Dimension(250, 20));
        jPanelDataForm.add(lblSecondaryPhoneNoVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, 20));

        add(jPanelDataForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 194, 660, 380));

        btnManageEmployee.setBackground(new java.awt.Color(102, 102, 255));
        btnManageEmployee.setText("Manage Employee");
        btnManageEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmployeeActionPerformed(evt);
            }
        });
        add(btnManageEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 200, -1));

        btnManageUsers.setBackground(new java.awt.Color(102, 102, 255));
        btnManageUsers.setText("Manage Users/Admins");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });
        add(btnManageUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed

        viewForm(true);
        populateFormDataWith(enterprise);

    }//GEN-LAST:event_btnViewActionPerformed

    private void btnUpdateOrCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrCreateActionPerformed

        if(validateFormFields())
        {
            //Validation of Brand Name if it gets changed
            if(!txtNodeName.getText().trim().equalsIgnoreCase(enterprise.getOrganizationName()))
            {
                if(! validateForUniqueEnterpriseName(txtNodeName.getText().trim()))
                {
                    JOptionPane.showMessageDialog(null, "Node is already present in the database","",JOptionPane.INFORMATION_MESSAGE);
                    txtNodeName.setEnabled(true);
                    return;
                }
            }

            //Update Operation
            fillEnterpriseWithFormData(enterprise);
            JOptionPane.showMessageDialog(null,"Data saved successfully","SUCCESS", JOptionPane.INFORMATION_MESSAGE);

            viewForm(false);

        }
    }//GEN-LAST:event_btnUpdateOrCreateActionPerformed

    private void txtNodeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNodeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNodeNameActionPerformed

    private void btnManageEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeeActionPerformed
       
        
        ManageOrganizationEmployeeJPanel panel = new ManageOrganizationEmployeeJPanel(userProcessContainer,userAccount,enterprise,business);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Configure Employee of Amazon Enterprise", panel);
        layout.next(userProcessContainer);
                
    }//GEN-LAST:event_btnManageEmployeeActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
        
        ManageOrganizationUserJPanel panel=new ManageOrganizationUserJPanel(userProcessContainer,userAccount,enterprise,business);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Configure users/admins of Amzon Enterprise", panel);
        layout.next(userProcessContainer);
            
    }//GEN-LAST:event_btnManageUsersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnManageEmployee;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnUpdateOrCreate;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanelDataForm;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddressLine1;
    private javax.swing.JLabel lblAddressLine2;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblConfigureEnterprise;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblEmailIdValidator;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblNodeName;
    private javax.swing.JLabel lblNodeNameValidator;
    private javax.swing.JLabel lblPrimaryPhoneNumber;
    private javax.swing.JLabel lblPrimaryPhoneNumberValidator;
    private javax.swing.JLabel lblSecondaryPhoneNoVal;
    private javax.swing.JLabel lblSecondaryPhoneNumber;
    private javax.swing.JLabel lblState;
    private javax.swing.JTextField txtAddressLine1;
    private javax.swing.JTextField txtAddressLine2;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtNodeName;
    private javax.swing.JTextField txtPrimaryPhoneNumber;
    private javax.swing.JTextField txtSecondaryPhoneNumber;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}
