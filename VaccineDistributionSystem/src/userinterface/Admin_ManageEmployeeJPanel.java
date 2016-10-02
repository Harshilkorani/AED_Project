/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import business.Business;
import business.enterprise.Enterprise;
import business.enterprise.MedicalEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.employee.Employee;
import business.organization.useraccount.UserAccount;
import business.site.Site;
import business.utility.Validation;
import business.vaccineEcoSystem.VaccineEcoSystem;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshil
 */
public class Admin_ManageEmployeeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Admin_ManageOrganizationEmployeeJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Employee employeeForView=new Employee("","");
    private VaccineEcoSystem vaccineEcoSystem;
    
    
    public Admin_ManageEmployeeJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organiation, Business business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organiation;
        this.vaccineEcoSystem = business.getVaccineEcoSystem();
        populateFormFields();
       
    }

    
    private void populateFormFields()
    {
        //When Form loads
        enableAllValidationLabels(false);
        
        //Organizations in the organization Combo Box
        populateOrganizationType();
    }

    private void populateOrganizationType()
    {
         jComboBoxOrganzationType.removeAllItems();
        if(organization.getOrganizationType().equalsIgnoreCase(Organization.OrganizationType.Enterprise.getValue()))
        {
            if(organization instanceof MedicalEnterprise)
            {
              for(Organization.MedicalEnterpriseOrganizationType type:Organization.MedicalEnterpriseOrganizationType.values())
              {
                  jComboBoxOrganzationType.addItem(type.getValue());
              }
            }
            
        }
        else if(organization.getOrganizationType().equalsIgnoreCase(Organization.OrganizationType.Site.getValue()))
        {
            for(Organization.SiteOrganizations type:Organization.SiteOrganizations.values())
              {
                  jComboBoxOrganzationType.addItem(type.getValue());
              }
        }
    }
    private void populateOrganizationName(String organizationType)
    {
        jComboBoxOrganizationName.removeAllItems();
        jComboBoxOrganizationName.setModel(new DefaultComboBoxModel());
        if(organization.getOrganizationType().equalsIgnoreCase(Organization.OrganizationType.Enterprise.getValue()))
        {
            Enterprise enterprise=(Enterprise)organization;
            for(Organization subOrganization: enterprise.getOrganizationDirectory().getOrganizationList() )
            {
                if(subOrganization.getOrganizationType().equalsIgnoreCase(organizationType))
                {
                jComboBoxOrganizationName.addItem(subOrganization.getOrganizationName());
                }
            }
            
        }
        else if(organization.getOrganizationType().equalsIgnoreCase(Organization.OrganizationType.Site.getValue()))
        {
            Site site=(Site)organization;
            for(Organization subOrganization: site.getSiteOrganizationDirectory().getOrganizationList() )
            {
                if(subOrganization.getOrganizationType().equalsIgnoreCase(organizationType))
                {
                jComboBoxOrganizationName.addItem(subOrganization.getOrganizationName());
                }
            }
        }
        
        
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
        jComboBoxOrganzationType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxOrganizationName = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
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
        lblSecondaryPhoneValidator = new javax.swing.JLabel();

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

        jComboBoxOrganzationType.setBackground(new java.awt.Color(102, 102, 255));
        jComboBoxOrganzationType.setPreferredSize(new java.awt.Dimension(200, 25));
        jComboBoxOrganzationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrganzationTypeActionPerformed(evt);
            }
        });

        jLabel1.setText("Organization Type:");

        jLabel2.setText("Organziation Name:");

        jComboBoxOrganizationName.setBackground(new java.awt.Color(102, 102, 255));
        jComboBoxOrganizationName.setPreferredSize(new java.awt.Dimension(200, 25));
        jComboBoxOrganizationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrganizationNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Employee List of Organization-Organization Name");

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
        btnViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProfileActionPerformed(evt);
            }
        });

        btnCreateEmployee.setBackground(new java.awt.Color(102, 102, 255));
        btnCreateEmployee.setText("Create New Employee");
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
        jPanel1.add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        lblLastName.setText("*Last Name:");
        lblLastName.setEnabled(false);
        jPanel1.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        txtFirstName.setEnabled(false);
        jPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 150, -1));

        txtLastName.setEnabled(false);
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 150, -1));

        lblSecondaryPhoneNo.setText("Secondary Phone No:");
        lblSecondaryPhoneNo.setEnabled(false);
        jPanel1.add(lblSecondaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        txtPrimaryPhoneNo.setEnabled(false);
        jPanel1.add(txtPrimaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, -1));

        lblPrimaryPhoneNo.setText("*Primary Phone No:");
        lblPrimaryPhoneNo.setEnabled(false);
        jPanel1.add(lblPrimaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        txtSecondaryPhoneNo.setEnabled(false);
        jPanel1.add(txtSecondaryPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 150, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 330, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 330, -1));

        lblEmailId.setText("*Email Id:");
        lblEmailId.setEnabled(false);
        jPanel1.add(lblEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        txtEmailId.setEnabled(false);
        jPanel1.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 150, -1));

        btnUpdateOrCreate.setBackground(new java.awt.Color(102, 102, 255));
        btnUpdateOrCreate.setText("Update or Create");
        btnUpdateOrCreate.setEnabled(false);
        btnUpdateOrCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdateOrCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 140, 30));

        lblFirstNameValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblFirstNameValidator.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel1.add(lblFirstNameValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 340, -1));

        lblLastNameValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblLastNameValidator.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel1.add(lblLastNameValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 340, -1));

        lblPrimaryPhoneNoValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblPrimaryPhoneNoValidator.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel1.add(lblPrimaryPhoneNoValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 340, -1));

        lblEmailIdValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailIdValidator.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel1.add(lblEmailIdValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 340, -1));

        lblSecondaryPhoneValidator.setForeground(new java.awt.Color(255, 0, 0));
        lblSecondaryPhoneValidator.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel1.add(lblSecondaryPhoneValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 340, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addGap(235, 235, 235)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel1)
                            .addGap(30, 30, 30)
                            .addComponent(jComboBoxOrganzationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel2)
                            .addGap(27, 27, 27)
                            .addComponent(jComboBoxOrganizationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnCreateEmployee))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addComponent(jLabel4))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel1))
                        .addComponent(jComboBoxOrganzationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel2))
                        .addComponent(jComboBoxOrganizationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addComponent(jLabel3)
                    .addGap(6, 6, 6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnViewProfile)
                        .addComponent(btnCreateEmployee))
                    .addGap(7, 7, 7)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBoxOrganzationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrganzationTypeActionPerformed
        if(Validation.validateComboBoxForSelection(jComboBoxOrganzationType))
        {
            populateOrganizationName(jComboBoxOrganzationType.getSelectedItem().toString());
            viewEmployeeDataForm(false);
            clearFormFields();
        }
    }//GEN-LAST:event_jComboBoxOrganzationTypeActionPerformed

    private void jComboBoxOrganizationNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrganizationNameActionPerformed
        //Calling function to populate Employee table
        if(jComboBoxOrganizationName.getSelectedItem()!=null)
        {
            populateEmployeeTable(getSelectedOrganization());
            viewEmployeeDataForm(false);
            clearFormFields();
        }
    }//GEN-LAST:event_jComboBoxOrganizationNameActionPerformed

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
                    Employee employee=getSelectedOrganization().getEmployeeDirectory().createEmployee(txtFirstName.getText(), txtLastName.getText());
                    employee.getContact().setContactData(txtPrimaryPhoneNo.getText().trim(), txtSecondaryPhoneNo.getText().trim(), txtEmailId.getText().trim());

                    clearFormFields();
                    JOptionPane.showMessageDialog(null, "Employee created successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    viewEmployeeDataForm(false);
                    populateEmployeeTable(getSelectedOrganization());
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
                            JOptionPane.showMessageDialog(null,"Employee updated successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                            populateEmployeeTable(getSelectedOrganization());
                            viewEmployeeDataForm(false);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnUpdateOrCreateActionPerformed


     public boolean updateTheEmployeeDataFor(Employee employee)
    {
        employee.getContact().setContactData(txtPrimaryPhoneNo.getText().trim(), txtSecondaryPhoneNo.getText().trim(), txtEmailId.getText().trim());
        employee.getPerson().setFirstName(txtFirstName.getText().trim());
        employee.getPerson().setLastName(txtLastName.getText().trim());
        return true;
    }
    
    private Organization getSelectedOrganization()
    {
        if(organization.getOrganizationType().equalsIgnoreCase(Organization.OrganizationType.Enterprise.getValue()))
        {
            Enterprise enterprise=(Enterprise)organization;
            for(Organization subOrganization: enterprise.getOrganizationDirectory().getOrganizationList() )
            {
                if(subOrganization.getOrganizationName().equalsIgnoreCase(jComboBoxOrganizationName.getSelectedItem().toString()))
                {
                        return subOrganization;
                }
            }
            
        }
        else if(organization.getOrganizationType().equalsIgnoreCase(Organization.OrganizationType.Site.getValue()))
        {
            Site site=(Site)organization;
            for(Organization subOrganization: site.getSiteOrganizationDirectory().getOrganizationList() )
            {
                if(subOrganization.getOrganizationName().equalsIgnoreCase(jComboBoxOrganizationName.getSelectedItem().toString()))
                {
                    return subOrganization;
                }
            }
        }
        return null;
    }
    
    private void setValidatorsToDefault()
    {
        lblFirstNameValidator.setText("");
        lblLastNameValidator.setText("");
        lblEmailIdValidator.setText("");
        lblPrimaryPhoneNoValidator.setText("");
        lblSecondaryPhoneValidator.setText("");
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
                        lblSecondaryPhoneValidator.setText("Please enter valid secondary phone number");
                    }
            }
            if(!Validation.validateTextFieldsForEmailId(txtEmailId))
            {
                lblEmailIdValidator.setText("Please enter valid email id");
            }
            
        if(!lblEmailIdValidator.getText().equalsIgnoreCase("")|
           !lblFirstNameValidator.getText().equalsIgnoreCase("")|
           !lblLastNameValidator.getText().equalsIgnoreCase("")||
           !lblPrimaryPhoneNoValidator.getText().equalsIgnoreCase("")|
            !lblSecondaryPhoneValidator.getText().equalsIgnoreCase(""))
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
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JButton btnUpdateOrCreate;
    private javax.swing.JButton btnViewProfile;
    private javax.swing.JComboBox jComboBoxOrganizationName;
    private javax.swing.JComboBox jComboBoxOrganzationType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel lblSecondaryPhoneValidator;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPrimaryPhoneNo;
    private javax.swing.JTextField txtSecondaryPhoneNo;
    // End of variables declaration//GEN-END:variables
}
