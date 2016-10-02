/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import business.Business;
import business.organization.Organization;
import business.organization.employee.Employee;
import business.organization.useraccount.UserAccount;
import business.role.Role;
import business.utility.Validation;
import business.vaccineEcoSystem.VaccineEcoSystem;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshil
 */
public class ManageOrganizationUserJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganizationUserJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount managingUserAccount;
    private Organization organization;
    private UserAccount userAccountForView;
    private VaccineEcoSystem vaccineEcoSystem;
    
    
    
    public ManageOrganizationUserJPanel(JPanel userProcessContainer, UserAccount managingUserAccount, Organization organization, Business business) {
        initComponents();
        
        this.vaccineEcoSystem = business.getVaccineEcoSystem();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.managingUserAccount = managingUserAccount;
        
        populateFormData();
    }
    
    
    private void populateFormData()
    {
        populateRolesComboBox(organization);
    }
    
    
          
      
      private void viewForm(boolean flag)
      {
          lblUserName.setEnabled(flag);
          txtUserName.setEnabled(flag);
          
          lblPassword.setEnabled(flag);
          txtPassword.setEnabled(flag);
          
          lblEmployee.setEnabled(flag);
          jComboBoxEmployee.setEnabled(flag);
          
          lblName.setEnabled(flag);
          lblEmailId.setEnabled(flag);
          
          btnUpdateOrCreate.setEnabled(flag);
          
          
          if(flag==true)
          {
              populateEmployeeComboBox(organization);
          }
          
          if(flag==false)
          {
              jComboBoxEmployee.removeAllItems();
              txtUserName.setText("");
              txtPassword.setText("");
          }
      }
      
      private void populateEmployeeComboBox(Organization organization)
      {
          jComboBoxEmployee.removeAllItems();
          for(Employee employee:organization.getEmployeeDirectory().getEmployeeList())
          {
              jComboBoxEmployee.addItem(employee);
          }
      }                                        

   private void setValidatorsToDefault()
   {
       lblPasswordValidator.setText("");
       lblUserNameValidator.setText("");
   }
    
     private void enableAllValidationLabels(boolean flag)
    {
                lblUserNameValidator.setVisible(flag);
                lblPasswordValidator.setVisible(flag);
    }
    
      private Employee getSelectedEmployee(JComboBox jComboBoxEmployee)
    {
        Employee employee=null;
        if(jComboBoxEmployee.getSelectedItem()!=null)
        {
        employee=(Employee)jComboBoxEmployee.getSelectedItem();
        }
        return employee;
    }
   
   
   
   private boolean validateForUniqueUserName(String userName)
   {
       return (! vaccineEcoSystem.checkIfUserNameIsPresent(userName));
      
   }
   
      
       private boolean validateFormFieldsForUserAccountData()
    {
        
        enableAllValidationLabels(false);
        setValidatorsToDefault();
        if(!Validation.validateTextFieldsForNonEmpty(txtUserName))
        {
            lblUserNameValidator.setText("Please enter user name");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtPassword))
        {
            lblPasswordValidator.setText("Please enter Password");
        }
        
        if(!lblPasswordValidator.getText().equalsIgnoreCase("") | !lblUserNameValidator.getText().equalsIgnoreCase(""))
        {
            enableAllValidationLabels(true);
            return false;
        }
        else
        {
            if(!Validation.validateTextFieldsForUserName(txtUserName))
            {
                lblUserNameValidator.setText("Please enter valid username");
            }
            if(!Validation.validateTextFieldForPassword(txtPassword))
            {
                lblPasswordValidator.setText("Please enter valid password");
            }
            
            if(!lblUserNameValidator.getText().equalsIgnoreCase("") | !lblPasswordValidator.getText().equalsIgnoreCase(""))
            {
                enableAllValidationLabels(true);
                return false;
            }
        }
        return true;
    }
    private UserAccount getSelectedUserAccountInTable()
    {
        UserAccount userAccount=(UserAccount)tblUserAccounts.getValueAt(tblUserAccounts.getSelectedRow(), 0);
        return userAccount;
    }
      
    private void createUserAccount(String userName, String password, Employee employee,Organization organization, Role role)
    {
        UserAccount userAccount=organization.getUserAccountDirectory().createUserAccount();
        userAccount.setEmployee(employee);
        userAccount.setUsername(userName);
        userAccount.setPassword(password);
        userAccount.setRole(role);
    }
    
    private void clearFormFields()
    {
        txtName.setText("");
        txtEmailId.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        
    }
    
    private Role getSelectedRole()
    {
        if(jComboBoxRole.getSelectedItem()!=null)
        {
            return ((Role)jComboBoxRole.getSelectedItem());
        }
        return null;
    } 
    
    private void populateUserAccountTable(Organization organization, Role role)
    {
         DefaultTableModel model = (DefaultTableModel) tblUserAccounts.getModel();
        model.setRowCount(0);
        for(UserAccount uA:organization.getUserAccountDirectory().getUserAccountList())
        {
            if(role.getRoleType().equalsIgnoreCase(uA.getRole().getRoleType()))
            {
            Object[] row = new Object[4];
            row[0]=uA;
            row[1] = uA.getUsername();
            row[2] = uA.getEmployee().getPerson().getFirstName();
            row[3]=uA.getEmployee().getContact().getEmailId();
            model.addRow(row); 
        }
    }
    }
     private void populateRolesComboBox(Organization organization)
    {
        jComboBoxRole.removeAllItems();;
        for(Role role:organization.getSupportedRoles())
        {
            jComboBoxRole.addItem(role);
        }
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
        jLabel4 = new javax.swing.JLabel();
        jComboBoxRole = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserAccounts = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnCreateNewUserAccount = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblEmployee = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblEmailId = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        btnUpdateOrCreate = new javax.swing.JButton();
        jComboBoxEmployee = new javax.swing.JComboBox();
        lblUserNameValidator = new javax.swing.JLabel();
        lblPasswordValidator = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        btnBack.setBackground(new java.awt.Color(102, 102, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Manage Users !");

        jComboBoxRole.setBackground(new java.awt.Color(102, 102, 255));
        jComboBoxRole.setPreferredSize(new java.awt.Dimension(200, 25));
        jComboBoxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRoleActionPerformed(evt);
            }
        });

        jLabel3.setText("Role:");

        tblUserAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Acc. Id", "UserName", "First Name", "Email Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUserAccounts);

        btnView.setBackground(new java.awt.Color(102, 102, 255));
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnCreateNewUserAccount.setBackground(new java.awt.Color(102, 102, 255));
        btnCreateNewUserAccount.setText("Create New UserAccount");
        btnCreateNewUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewUserAccountActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserName.setText("*User Name:");
        lblUserName.setEnabled(false);
        jPanel1.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        lblPassword.setText("*Password:");
        lblPassword.setEnabled(false);
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        txtUserName.setEnabled(false);
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 150, -1));

        txtPassword.setEnabled(false);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 150, -1));

        lblName.setText("Name:");
        lblName.setEnabled(false);
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        lblEmployee.setText("Employee:");
        lblEmployee.setEnabled(false);
        jPanel1.add(lblEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        txtName.setEnabled(false);
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 150, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 330, -1));

        lblEmailId.setText("Email Id:");
        lblEmailId.setEnabled(false);
        jPanel1.add(lblEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        txtEmailId.setEnabled(false);
        jPanel1.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 150, -1));

        btnUpdateOrCreate.setBackground(new java.awt.Color(102, 102, 255));
        btnUpdateOrCreate.setText("Update or Create");
        btnUpdateOrCreate.setEnabled(false);
        btnUpdateOrCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdateOrCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 140, 30));

        jComboBoxEmployee.setEnabled(false);
        jComboBoxEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 150, -1));

        lblUserNameValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblUserNameValidator.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel1.add(lblUserNameValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 300, -1));

        lblPasswordValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblPasswordValidator.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel1.add(lblPasswordValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addGap(235, 235, 235)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel3)
                            .addGap(85, 85, 85)
                            .addComponent(jComboBoxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnView)
                            .addGap(15, 15, 15)
                            .addComponent(btnCreateNewUserAccount))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addComponent(jLabel4))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnView)
                        .addComponent(btnCreateNewUserAccount))
                    .addGap(17, 17, 17)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBoxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRoleActionPerformed
        if(jComboBoxRole.getSelectedItem()!=null)
        {
            populateUserAccountTable(organization,getSelectedRole() );
            viewForm(false);

        }
    }//GEN-LAST:event_jComboBoxRoleActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed

        if(Validation.validateTableSelection(tblUserAccounts, 1))
        {
            btnUpdateOrCreate.setText("Update");
            viewForm(true);
            userAccountForView=getSelectedUserAccountInTable();
            txtUserName.setText(userAccountForView.getUsername());
            txtPassword.setText(userAccountForView.getPassword());
            jComboBoxEmployee.setSelectedItem(userAccountForView.getEmployee());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select one row","SELECT",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateNewUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewUserAccountActionPerformed
        // populateUserAccountTable(getSelectedOrganization(), getSelectedRole());
        btnUpdateOrCreate.setText("Create");
        clearFormFields();
        viewForm(true);
    }//GEN-LAST:event_btnCreateNewUserAccountActionPerformed

    private void btnUpdateOrCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrCreateActionPerformed

        if(validateFormFieldsForUserAccountData())
        {
            if(btnUpdateOrCreate.getText().equalsIgnoreCase("Create"))
            {
                if(validateForUniqueUserName(txtUserName.getText().trim()))
                {
                    if(getSelectedEmployee(jComboBoxEmployee)!=null)
                    {
                        createUserAccount(txtUserName.getText().trim(),txtPassword.getText().trim(), getSelectedEmployee(jComboBoxEmployee),organization,getSelectedRole());
                        clearFormFields();
                        JOptionPane.showMessageDialog(null,"User Account Configured Successfully","SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        populateUserAccountTable(organization, getSelectedRole());
                        viewForm(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Employee present in the organization","SORRY",JOptionPane.ERROR_MESSAGE);
                    }
                }
              else
              {
                   JOptionPane.showMessageDialog(null,"User Name already present in the system","", JOptionPane.ERROR_MESSAGE);
              }
            }
            else if(btnUpdateOrCreate.getText().equalsIgnoreCase("Update"))
            {
                //Validation of username required if usernamechanged
                if(!txtUserName.getText().trim().equalsIgnoreCase(userAccountForView.getUsername()))
                {
                    if( validateForUniqueUserName(txtUserName.getText().trim()))
                    {

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "UserName already Present","",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }

                //Update Operation
                userAccountForView.setUsername(txtUserName.getText().trim());
                userAccountForView.setPassword(txtPassword.getText().trim());
                userAccountForView.setEmployee(getSelectedEmployee(jComboBoxEmployee));
                JOptionPane.showMessageDialog(null,"Updated Suceessfully","SUCCESSFULL", JOptionPane.INFORMATION_MESSAGE);
                populateUserAccountTable(organization,getSelectedRole());
                viewForm(false);
            }
        }

       
    }//GEN-LAST:event_btnUpdateOrCreateActionPerformed

    private void jComboBoxEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmployeeActionPerformed
        Employee employee=getSelectedEmployee(jComboBoxEmployee);

        if(employee!=null)
        {
            txtName.setText(employee.getPerson().getFirstName()+" "+employee.getPerson().getLastName());
        }
    }//GEN-LAST:event_jComboBoxEmployeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNewUserAccount;
    private javax.swing.JButton btnUpdateOrCreate;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox jComboBoxEmployee;
    private javax.swing.JComboBox jComboBoxRole;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblEmployee;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordValidator;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNameValidator;
    private javax.swing.JTable tblUserAccounts;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
