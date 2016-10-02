/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import business.Business;
import business.network.Network;
import business.organization.Organization;
import business.organization.employee.Employee;
import business.organization.useraccount.UserAccount;
import business.utility.Validation;
import business.vaccineEcoSystem.VaccineEcoSystem;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshil
 */
public class ManageOrganizationEmployeeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganizationEmployeeJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount managingUserAccount;
    private Organization organization;
    private Employee employeeForView;
    private VaccineEcoSystem vaccineEcoSystem;
    
    
    public ManageOrganizationEmployeeJPanel(JPanel userProcessContainer, UserAccount managingUserAccount, Organization organization, Business business) {
        initComponents();
        
        this.vaccineEcoSystem = business.getVaccineEcoSystem();
        this.userProcessContainer=userProcessContainer;
        this.managingUserAccount=managingUserAccount;
        this.organization=organization;
        populateFormData();
        
        
    }
    
    
    private void populateFormData()
    {
        populateEmployeeTable(organization);
    }
    
    private void populateEmployeeTable(Organization organization)
    {  
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        for(Employee employee:organization.getEmployeeDirectory().getEmployeeList())
        {
            Object[] row = new Object[3];
            row[0]=employee;
            row[1] = employee.getPerson().getFirstName();
            row[2] = employee.getPerson().getLastName();
            model.addRow(row); 
        }
    }
    

    
    private boolean validateFormForNewUniqueEmployee(String firstName, String lastName, String emailId)
    {
        for(Network network:vaccineEcoSystem.getAllNetwork())
        {
            if(network.getEnterpriseDirectory().checkIfEmployeeIsPresent(firstName, lastName, emailId))
            return false;
        }
        return true;
    }
    
    
    
      private void clearFormFields()
    {
        txtEmailId.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPrimaryPhoneNo.setText("");
        txtSecondaryPhoneNo.setText("");
    }
    
      public boolean updateTheEmployeeDataFor(Employee employee)
    {
        employee.getContact().setContactData(txtPrimaryPhoneNo.getText().trim(), txtSecondaryPhoneNo.getText().trim(), txtEmailId.getText().trim());
        employee.getPerson().setFirstName(txtFirstName.getText().trim());
        employee.getPerson().setLastName(txtLastName.getText().trim());
        return true;
    }
    
     private boolean validateFormFieldsForPersonData()
    {
        enableAllValidationLabels(false);
        setValidatorsToDefault();
        //For Non Empty 
       if(! Validation.validateTextFieldsForNonEmpty(txtFirstName))
       {
            lblFirstNameValidator.setText("Please Enter the First Name");
       }
        if(!Validation.validateTextFieldsForNonEmpty(txtLastName))
        {
            lblLastNameValidator.setText("Please Enter the Last Name");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtPrimaryPhoneNo))
        {
            lblPrimaryPhoneNoValidator.setText("Please Enter the Phone No");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtEmailId))
        {
            lblEmailIdValidator.setText("Please Enter the Email Id");
        }
        
        
        if(!lblEmailIdValidator.getText().equalsIgnoreCase("")|
           !lblFirstNameValidator.getText().equalsIgnoreCase("")|
           !lblLastNameValidator.getText().equalsIgnoreCase("")||
           !lblPrimaryPhoneNoValidator.getText().equalsIgnoreCase(""))
        {
            enableAllValidationLabels(true);
            return false;
        }
        else
        {
            //Check for expected Data
            if(!Validation.validateTextFieldsForString(txtFirstName))
            {
               lblFirstNameValidator.setText("Please enter valid first name");
            }
            if(!Validation.validateTextFieldsForString(txtLastName))
            {
               lblFirstNameValidator.setText("Please enter valid last name");
            }
            if(!Validation.validateTextFieldsForPhoneNumber(txtPrimaryPhoneNo))
            {
                lblPrimaryPhoneNoValidator.setText("Please enter valid primary phone number");
                
            }
            if(!txtSecondaryPhoneNo.getText().trim().equalsIgnoreCase(""))
            {
                if(!Validation.validateTextFieldsForPhoneNumber(txtSecondaryPhoneNo))
                {
                    lblSecondaryPhoneNoValidator.setText("Please enter valid secondary phone number");
                }
            }
            if(!Validation.validateTextFieldsForEmailId(txtEmailId))
            {
                lblEmailIdValidator.setText("Please enter valid email id");
            }
            
        if(!lblEmailIdValidator.getText().equalsIgnoreCase("")|
           !lblFirstNameValidator.getText().equalsIgnoreCase("")|
           !lblLastNameValidator.getText().equalsIgnoreCase("")||
           !lblPrimaryPhoneNoValidator.getText().equalsIgnoreCase(""))
        {
            enableAllValidationLabels(true);
            return false;
        }    
        }
        return true;
    }
    
    private void enableAllValidationLabels(boolean flag)
    {
        lblEmailIdValidator.setVisible(flag);
        lblFirstNameValidator.setVisible(flag);
        lblLastNameValidator.setVisible(flag);
        lblPrimaryPhoneNoValidator.setVisible(flag);
        lblSecondaryPhoneNoValidator.setVisible(flag);
    }
    
    private void setValidatorsToDefault()
    {
        lblFirstNameValidator.setText("");
        lblLastNameValidator.setText("");
        lblEmailIdValidator.setText("");
        lblPrimaryPhoneNoValidator.setText("");
        lblSecondaryPhoneNoValidator.setText("");
    }
    
   private void setEmployeeDataInForm(Employee employee)
    {
        txtFirstName.setText(employee.getPerson().getFirstName());
        txtLastName.setText(employee.getPerson().getLastName());
        txtPrimaryPhoneNo.setText(employee.getContact().getPrimaryPhoneNumber());
        if(!txtSecondaryPhoneNo.getText().equalsIgnoreCase(""))
        {
        txtSecondaryPhoneNo.setText(employee.getContact().getSecondaryPhoneNumber());
        }
        txtEmailId.setText(employee.getContact().getEmailId());
    }
    
    private void viewEmployeeDataForm(boolean flag)
    {
            if(flag==false)
            {
                btnUpdateOrCreate.setText("Update or Create");
            }
            lblEmailId.setEnabled(flag);
            lblFirstName.setEnabled(flag);
            lblLastName.setEnabled(flag);
            lblPrimaryPhoneNo.setEnabled(flag);
            lblSecondaryPhoneNo.setEnabled(flag);
            
            txtFirstName.setEnabled(flag);
            txtLastName.setEnabled(flag);
            txtPrimaryPhoneNo.setEnabled(flag);
            txtSecondaryPhoneNo.setEnabled(flag);
            txtEmailId.setEnabled(flag);
            
            btnUpdateOrCreate.setEnabled(flag);
          
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        btnViewProfile = new javax.swing.JButton();
        btnCreateEmployee = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        lblSecondaryPhoneNo = new javax.swing.JLabel();
        txtPrimaryPhoneNo = new javax.swing.JTextField();
        lblPrimaryPhoneNo = new javax.swing.JLabel();
        txtSecondaryPhoneNo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblEmailId = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        btnUpdateOrCreate = new javax.swing.JButton();
        lblFirstNameValidator = new javax.swing.JLabel();
        lblLastNameValidator = new javax.swing.JLabel();
        lblPrimaryPhoneNoValidator = new javax.swing.JLabel();
        lblEmailIdValidator = new javax.swing.JLabel();
        lblSecondaryPhoneNoValidator = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        btnBack.setBackground(new java.awt.Color(102, 102, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Manage Employees !");

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Id", "First Name", "Last Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        btnViewProfile.setBackground(new java.awt.Color(102, 102, 255));
        btnViewProfile.setText("View Profile");
        btnViewProfile.setPreferredSize(new java.awt.Dimension(150, 23));
        btnViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProfileActionPerformed(evt);
            }
        });

        btnCreateEmployee.setBackground(new java.awt.Color(102, 102, 255));
        btnCreateEmployee.setText("Create New Employee");
        btnCreateEmployee.setPreferredSize(new java.awt.Dimension(150, 23));
        btnCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFirstName.setText("*First Name:");
        lblFirstName.setEnabled(false);
        jPanel1.add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        lblLastName.setText("*Last Name:");
        lblLastName.setEnabled(false);
        jPanel1.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        txtFirstName.setEnabled(false);
        jPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 150, -1));

        txtLastName.setEnabled(false);
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 150, -1));

        lblSecondaryPhoneNo.setText("Secondary Phone No:");
        lblSecondaryPhoneNo.setEnabled(false);
        jPanel1.add(lblSecondaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        txtPrimaryPhoneNo.setEnabled(false);
        jPanel1.add(txtPrimaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 150, -1));

        lblPrimaryPhoneNo.setText("*Primary Phone No:");
        lblPrimaryPhoneNo.setEnabled(false);
        jPanel1.add(lblPrimaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        txtSecondaryPhoneNo.setEnabled(false);
        jPanel1.add(txtSecondaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 150, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 330, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 330, -1));

        lblEmailId.setText("*Email Id:");
        lblEmailId.setEnabled(false);
        jPanel1.add(lblEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        txtEmailId.setEnabled(false);
        jPanel1.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 150, -1));

        btnUpdateOrCreate.setBackground(new java.awt.Color(102, 102, 255));
        btnUpdateOrCreate.setText("Update or Create");
        btnUpdateOrCreate.setEnabled(false);
        btnUpdateOrCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdateOrCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 140, 30));

        lblFirstNameValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblFirstNameValidator.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel1.add(lblFirstNameValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        lblLastNameValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblLastNameValidator.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel1.add(lblLastNameValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        lblPrimaryPhoneNoValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblPrimaryPhoneNoValidator.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel1.add(lblPrimaryPhoneNoValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        lblEmailIdValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailIdValidator.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel1.add(lblEmailIdValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        lblSecondaryPhoneNoValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblSecondaryPhoneNoValidator.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel1.add(lblSecondaryPhoneNoValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btnViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnCreateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addComponent(jLabel4))
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCreateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProfileActionPerformed
        if(Validation.validateTableSelection(tblEmployee,1))
        {
            btnUpdateOrCreate.setText("Update");
            viewEmployeeDataForm(true);
            employeeForView=(Employee)tblEmployee.getValueAt(tblEmployee.getSelectedRow(), 0);
            setEmployeeDataInForm(employeeForView);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select one row","PLEASE SELECT",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewProfileActionPerformed

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed
        btnUpdateOrCreate.setText("Create");
        clearFormFields();
        viewEmployeeDataForm(true);
    }//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void btnUpdateOrCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrCreateActionPerformed
        if(validateFormFieldsForPersonData())
        {
            if(btnUpdateOrCreate.getText().equalsIgnoreCase("Create"))
            {
                if(validateFormForNewUniqueEmployee(txtFirstName.getText().trim(), txtLastName.getText().trim(), txtEmailId.getText().trim()))
                {
                    Employee employee=organization.getEmployeeDirectory().createEmployee(txtFirstName.getText(), txtLastName.getText());
                    employee.getContact().setContactData(txtPrimaryPhoneNo.getText().trim(), txtSecondaryPhoneNo.getText().trim(), txtEmailId.getText().trim());

                    clearFormFields();
                    JOptionPane.showMessageDialog(null, "Employee created successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    viewEmployeeDataForm(false);
                    populateEmployeeTable(organization);
                }
                else
                {
                   JOptionPane.showMessageDialog(null,"The Employee already exists in our database","SORRY",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(btnUpdateOrCreate.getText().equalsIgnoreCase("Update"))
            {
                if(employeeForView.getPerson().getFirstName().equalsIgnoreCase(txtFirstName.getText()) &&
                    employeeForView.getPerson().getLastName().equalsIgnoreCase(txtLastName.getText()) &&
                    employeeForView.getContact().getEmailId().equalsIgnoreCase(txtEmailId.getText()))
                {

                }
                else
                {
                    if(validateFormForNewUniqueEmployee(txtFirstName.getText().trim(), txtLastName.getText().trim(), txtEmailId.getText().trim()))
                    {
                        if(updateTheEmployeeDataFor(employeeForView))
                        {
                            clearFormFields();
                            JOptionPane.showMessageDialog(null,"","",JOptionPane.INFORMATION_MESSAGE);
                            populateEmployeeTable(organization);
                            viewEmployeeDataForm(false);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnUpdateOrCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JButton btnUpdateOrCreate;
    private javax.swing.JButton btnViewProfile;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblEmailIdValidator;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblFirstNameValidator;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLastNameValidator;
    private javax.swing.JLabel lblPrimaryPhoneNo;
    private javax.swing.JLabel lblPrimaryPhoneNoValidator;
    private javax.swing.JLabel lblSecondaryPhoneNo;
    private javax.swing.JLabel lblSecondaryPhoneNoValidator;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPrimaryPhoneNo;
    private javax.swing.JTextField txtSecondaryPhoneNo;
    // End of variables declaration//GEN-END:variables
}
