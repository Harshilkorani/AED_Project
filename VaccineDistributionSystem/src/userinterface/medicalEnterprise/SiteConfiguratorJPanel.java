/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.medicalEnterprise;

import business.Business;
import business.communication.Contact;
import business.communication.Location;
import business.enterprise.CDCEnterprise;
import business.enterprise.MedicalEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.useraccount.UserAccount;
import business.site.Site;
import business.site.SiteDirectory;
import business.utility.Validation;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshil
 */
public class SiteConfiguratorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SiteConfiguratorJPanel
     */
    
    private JPanel userProcessContainer;
    private Network network;
    private MedicalEnterprise medicalEnterprise;
    private Organization enterpriseOrganization;
    private UserAccount userAccount;
    private SiteDirectory siteDirectory;
    private Site siteForView = null;
    private Business business;
    
    
    
    
    
    public SiteConfiguratorJPanel(JPanel userProcessContainer, UserAccount userAccount, Network network, MedicalEnterprise medicalEnterprise,Organization enterpriseOrganization, Business business) {
        initComponents();
        
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.network = network;
        this.medicalEnterprise = medicalEnterprise;
        this.enterpriseOrganization = enterpriseOrganization;
        this.siteDirectory = medicalEnterprise.getSiteDirectory();
        populateFormFields();
        
    }
    
    private void populateFormFields()
    {
        lblSitesConfigurator.setText(medicalEnterprise.getOrganizationName());
        lblPersonName.setText(userAccount.getEmployee().getPerson().getFirstName());
        populateSiteTable();
        populateSiteType();
    }
    
    private void populateSiteType()
    {
        for(Site.SiteTypes type:Site.SiteTypes.values())
        {
            if(type.getValue().equalsIgnoreCase(Site.SiteTypes.Clinic.getValue()))
            {
                jComboBoxSiteType.addItem(type);
            }
            else if(type.getValue().equalsIgnoreCase(Site.SiteTypes.Hospital.getValue()))
            {
                jComboBoxSiteType.addItem(type);
            }
            else if(type.getValue().equalsIgnoreCase(Site.SiteTypes.Pharmacy.getValue()))
            {
                jComboBoxSiteType.addItem(type);
            }
        }
    }
    
                           

    private void clearFormFields()
    {
        txtSiteName.setText("");
        txtAddressLine1.setText("");
        txtAddressLine2.setText("");
        txtCity.setText("");
        txtState.setText("");
        txtCountry.setText("");
        
        txtPrimaryPhoneNumber.setText("");
        txtSecondaryPhoneNumber.setText("");
        txtEmailId.setText("");
    }
    
    
    private void viewForm(boolean flag)
    {
        
        lblSiteName.setEnabled(flag);
        lblSiteType.setEnabled(flag);
        txtSiteName.setEnabled(flag);
        jComboBoxSiteType.setEnabled(flag);
        
        lblLocation.setEnabled(flag);
        
        txtSiteName.setEnabled(flag);
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
        preConfiguration();
        
    }
    
    private void preConfiguration()
    {
        if(network.getNetworkType().equalsIgnoreCase(Network.NetworkType.COUNTRY.getValue()))
        {
            txtCountry.setText(network.getNetworkName());
            txtCountry.setEditable(false);
        }
        else if(network.getNetworkType().equalsIgnoreCase(Network.NetworkType.STATE.getValue()))
        {
            txtState.setText(network.getNetworkName());
            txtState.setEditable(false);
            
            txtCountry.setText(network.getParentNetwork().getNetworkName());
            txtCountry.setEditable(false);
        }
        else if(network.getNetworkType().equalsIgnoreCase(Network.NetworkType.City.getValue()))
        {
            txtCity.setText(network.getNetworkName());
            txtCity.setEditable(false);
            
            txtState.setText(network.getParentNetwork().getNetworkName());
            txtState.setEditable(false);
            
            txtCountry.setText(network.getParentNetwork().getParentNetwork().getNetworkName());
            txtCountry.setEditable(false);
        }
            
    }
                     
    private void enableValidators(boolean flag)
    {
        lblSiteNameValidator.setEnabled(flag);
        lblAddressLine1Validator.setEnabled(flag);
        lblAddressLine2Validator.setEnabled(flag);
        lblCityValidator.setEnabled(flag);
        lblStateValidator.setEnabled(flag);
        lblCountryValidator.setEnabled(flag);
        lblPrimaryPhoneNumberValidator.setEnabled(flag);
        lblEmailIdValidator.setEnabled(flag);
        
    }
    
    private void setValidatorsToDefault()
    {
        lblSiteNameValidator.setText("");
        lblAddressLine1Validator.setText("");
        lblAddressLine2Validator.setText("");
        lblCityValidator.setText("");
        lblStateValidator.setText("");
        lblCountryValidator.setText("");
        lblPrimaryPhoneNumberValidator.setText("");
        lblEmailIdValidator.setText("");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblPersonName = new javax.swing.JLabel();
        lblSitesConfigurator = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSites = new javax.swing.JTable();
        btnCreateNew = new javax.swing.JButton();
        btnManageSiteAdministrators = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jPanelDataForm = new javax.swing.JPanel();
        lblSiteType = new javax.swing.JLabel();
        btnUpdateOrCreate = new javax.swing.JButton();
        jComboBoxSiteType = new javax.swing.JComboBox();
        lblSiteName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLocation = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        lblAddressLine2 = new javax.swing.JLabel();
        txtAddressLine2 = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtSiteName = new javax.swing.JTextField();
        lblAddressLine1 = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        txtAddressLine1 = new javax.swing.JTextField();
        lblSiteNameValidator = new javax.swing.JLabel();
        lblAddressLine1Validator = new javax.swing.JLabel();
        lblAddressLine2Validator = new javax.swing.JLabel();
        lblCityValidator = new javax.swing.JLabel();
        lblStateValidator = new javax.swing.JLabel();
        lblCountryValidator = new javax.swing.JLabel();
        txtPrimaryPhoneNumber = new javax.swing.JTextField();
        lblPrimaryPhoneNumber = new javax.swing.JLabel();
        lblSecondaryPhoneNumber = new javax.swing.JLabel();
        txtSecondaryPhoneNumber = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        lblEmailId = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblPrimaryPhoneNumberValidator = new javax.swing.JLabel();
        lblEmailIdValidator = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("SiteConfigurator");

        lblPersonName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPersonName.setText("Site Config.");

        lblSitesConfigurator.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSitesConfigurator.setText("Sites Configurator");

        tblSites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSites);

        btnCreateNew.setBackground(new java.awt.Color(102, 102, 255));
        btnCreateNew.setText("Create New");
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });

        btnManageSiteAdministrators.setBackground(new java.awt.Color(102, 102, 255));
        btnManageSiteAdministrators.setText("Manage Site Administrators");
        btnManageSiteAdministrators.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSiteAdministratorsActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(102, 102, 255));
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(102, 102, 255));
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jPanelDataForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDataForm.setEnabled(false);
        jPanelDataForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSiteType.setText("Type:");
        lblSiteType.setEnabled(false);
        jPanelDataForm.add(lblSiteType, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        btnUpdateOrCreate.setBackground(new java.awt.Color(102, 102, 255));
        btnUpdateOrCreate.setText("Update or Create");
        btnUpdateOrCreate.setEnabled(false);
        btnUpdateOrCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrCreateActionPerformed(evt);
            }
        });
        jPanelDataForm.add(btnUpdateOrCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 140, 30));

        jComboBoxSiteType.setBackground(new java.awt.Color(102, 102, 255));
        jComboBoxSiteType.setEnabled(false);
        jPanelDataForm.add(jComboBoxSiteType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 180, -1));

        lblSiteName.setText("*Name:");
        lblSiteName.setEnabled(false);
        jPanelDataForm.add(lblSiteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));
        jPanelDataForm.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 620, 10));

        lblLocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLocation.setText("LOCATION");
        lblLocation.setEnabled(false);
        jPanelDataForm.add(lblLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        lblCity.setText("*City:");
        lblCity.setEnabled(false);
        jPanelDataForm.add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtCountry.setEnabled(false);
        txtCountry.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        lblAddressLine2.setText("*Address Line 2:");
        lblAddressLine2.setEnabled(false);
        jPanelDataForm.add(lblAddressLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtAddressLine2.setEnabled(false);
        txtAddressLine2.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtAddressLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        txtState.setEnabled(false);
        txtState.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        lblState.setText("*State:");
        lblState.setEnabled(false);
        jPanelDataForm.add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtCity.setEnabled(false);
        txtCity.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        txtSiteName.setEnabled(false);
        txtSiteName.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtSiteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 180, -1));

        lblAddressLine1.setText("*Address Line 1:");
        lblAddressLine1.setEnabled(false);
        jPanelDataForm.add(lblAddressLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lblCountry.setText("*Country:");
        lblCountry.setEnabled(false);
        jPanelDataForm.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtAddressLine1.setEnabled(false);
        txtAddressLine1.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtAddressLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        lblSiteNameValidator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblSiteNameValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lblAddressLine1Validator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblAddressLine1Validator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        lblAddressLine2Validator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblAddressLine2Validator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        lblCityValidator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblCityValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        lblStateValidator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblStateValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        lblCountryValidator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblCountryValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        txtPrimaryPhoneNumber.setEnabled(false);
        txtPrimaryPhoneNumber.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanelDataForm.add(txtPrimaryPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 200, -1));

        lblPrimaryPhoneNumber.setText("*Primary Phone No:");
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

        lblEmailId.setText("*Email Id:");
        lblEmailId.setEnabled(false);
        jPanelDataForm.add(lblEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        lblContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblContact.setText("CONTACT");
        lblContact.setEnabled(false);
        jPanelDataForm.add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        lblPrimaryPhoneNumberValidator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblPrimaryPhoneNumberValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        lblEmailIdValidator.setForeground(new java.awt.Color(255, 0, 0));
        jPanelDataForm.add(lblEmailIdValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel1)
                .addContainerGap(342, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(301, 301, 301)
                            .addComponent(lblSitesConfigurator)
                            .addGap(110, 110, 110)
                            .addComponent(lblPersonName))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btnCreateNew)
                            .addGap(172, 172, 172)
                            .addComponent(btnManageSiteAdministrators, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addComponent(btnDelete)
                            .addGap(7, 7, 7)
                            .addComponent(btnView))
                        .addComponent(jPanelDataForm, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(665, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(lblSitesConfigurator))
                        .addComponent(lblPersonName))
                    .addGap(3, 3, 3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCreateNew)
                        .addComponent(btnManageSiteAdministrators)
                        .addComponent(btnDelete)
                        .addComponent(btnView))
                    .addGap(27, 27, 27)
                    .addComponent(jPanelDataForm, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void populateSiteTable()
    {
        DefaultTableModel model=(DefaultTableModel)tblSites.getModel();
        model.setNumRows(0);
        
        
        /*
        
        String tempName = network.getParentNetwork().getParentNetwork().getNetworkName();
        System.out.println(tempName);
        
        Network tempNetwork = network.findCountryNetwork(tempName);
        //tempEnterprise = enterprise;
       
        String tempName2 = tempNetwork.getNetworkName();
        
        System.out.println(tempName2);
        
               */ 
                
        
        for(Site site:siteDirectory.getSiteList())
        {
                Object row[] = new Object[3];
                row[0] = site;
                row[1] = site.getSitetype();
                row[2] = site.getOrganizationName();
                model.addRow(row);
        }
    }
    
    private void populateFormDataWith(Site site)
    {
        jComboBoxSiteType.setSelectedItem(siteForView.getSitetype());
        txtSiteName.setText(site.getOrganizationName());
        txtAddressLine1.setText(site.getLocation().getAddressLine1());
        txtAddressLine2.setText(site.getLocation().getAddressLine2());
        txtCity.setText(site.getLocation().getCity());
        txtState.setText(site.getLocation().getState());
        txtCountry.setText(site.getLocation().getCountry());
        txtPrimaryPhoneNumber.setText(site.getContact().getPrimaryPhoneNumber());
        txtSecondaryPhoneNumber.setText(site.getContact().getSecondaryPhoneNumber());
        txtEmailId.setText(site.getContact().getEmailId());
    }
    
    
    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed

        btnUpdateOrCreate.setText("Create");
        clearFormFields();
        viewForm(true);

    }//GEN-LAST:event_btnCreateNewActionPerformed

    
       public boolean validateFormFields()
    {
        enableValidators(false);
        setValidatorsToDefault();
        //For Empty check
        if(!Validation.validateTextFieldsForNonEmpty(txtSiteName))
        {
            lblSiteNameValidator.setText("Please Enter Site Name");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtAddressLine1))
        {
            lblAddressLine1Validator.setText("Please Enter Address Line 1");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtAddressLine2))
        {
            lblAddressLine2Validator.setText("Please Enter Address Line 2");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtCity))
        {
            lblCityValidator.setText("Please Enter City Name");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtState))
        {
            lblStateValidator.setText("Please Enter State Name"); 
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtCountry))
        {
            lblCountryValidator.setText("Please Enter Country Name");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtPrimaryPhoneNumber))
        {
            lblPrimaryPhoneNumberValidator.setText("Please enter primary phone number");
        }
        if(!Validation.validateTextFieldsForNonEmpty(txtEmailId))
        {
            lblEmailIdValidator.setText("Please enter Email Id");
        }
        
        

        if( !lblSiteNameValidator.getText().equalsIgnoreCase("")|
        !lblAddressLine1Validator.getText().equalsIgnoreCase("")|
        !lblAddressLine2Validator.getText().equalsIgnoreCase("")|
        !lblCityValidator.getText().equalsIgnoreCase("")|
        !lblStateValidator.getText().equalsIgnoreCase("")|
        !lblCountryValidator.getText().equalsIgnoreCase("")|
             !lblPrimaryPhoneNumberValidator.getText().equalsIgnoreCase("")|
                !lblEmailIdValidator.getText().equalsIgnoreCase(""))
        {
            enableValidators(true);
            return false;
        }
        else
        {
            //Check for Data Specific to particular entity
            return true;
        }
        
    }
    
    
        private boolean validateForUniqueSiteName(String siteName)
        {
            if(siteDirectory.isPresent(siteName))
            {
                return false;
            }
            return true;
        }
        
        private String getSelectedSiteType()
        {
             String sitetype=String.valueOf((Site.SiteTypes)jComboBoxSiteType.getSelectedItem());
             return sitetype;
        }
     
    
    
    private void btnManageSiteAdministratorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSiteAdministratorsActionPerformed
        if(Validation.validateTableSelection(tblSites, 1))
        {
            
            ManageEmployeeUserOfSiteAdministrationJPanel panel = new ManageEmployeeUserOfSiteAdministrationJPanel(userProcessContainer,userAccount,(Site)tblSites.getValueAt(tblSites.getSelectedRow(), 0),business);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("Configure Employee/User for Node Admnistration", panel);
            layout.next(userProcessContainer);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select one row in the table above","SELECT",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnManageSiteAdministratorsActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(Validation.validateTableSelection(tblSites, 1))
        {
            Site site =(Site) tblSites.getValueAt(tblSites.getSelectedRow(), 0);
            siteDirectory.removeSite(site);
            populateSiteTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select one row", "SELECTION ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        if(Validation.validateTableSelection(tblSites , 1))
        {
            btnUpdateOrCreate.setText("Update");
            viewForm(true);
            siteForView=(Site)tblSites.getValueAt(tblSites.getSelectedRow(), 0);
            populateFormDataWith(siteForView);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select one row in the table above","SELECT",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnUpdateOrCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrCreateActionPerformed

        if(validateFormFields())
        {
            if(btnUpdateOrCreate.getText().equalsIgnoreCase("Create"))
            {
                if(validateForUniqueSiteName(txtSiteName.getText().trim()))
                {
                    //Location
                    Location tempLocation=new Location();
                    tempLocation.setAddressLine1(txtAddressLine1.getText().trim());
                    tempLocation.setAddressLine2(txtAddressLine2.getText().trim());
                    tempLocation.setCity(txtCity.getText().trim());
                    tempLocation.setState(txtState.getText().trim());
                    tempLocation.setCountry(txtCountry.getText().trim());

                    //Contact
                    Contact tempContact = new Contact();
                    tempContact.setContactData(txtPrimaryPhoneNumber.getText().trim(), txtSecondaryPhoneNumber.getText().trim(), txtEmailId.getText().trim());

                    Site site = siteDirectory.createSite(txtSiteName.getText().trim(), getSelectedSiteType(), tempLocation, tempContact);

                    clearFormFields();
                    JOptionPane.showMessageDialog(null,"Site created successfully","SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    populateSiteTable();
                    viewForm(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Site is already present in the database","", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(btnUpdateOrCreate.getText().equalsIgnoreCase("Update"))
            {
                //Validation of Brand Name if it gets changed
                if(!txtSiteName.getText().trim().equalsIgnoreCase(siteForView.getOrganizationName()))
                {
                    if(! validateForUniqueSiteName(txtSiteName.getText().trim()))
                    {
                        JOptionPane.showMessageDialog(null, "Site is already present in the database","",JOptionPane.INFORMATION_MESSAGE);
                        txtSiteName.setEnabled(true);
                        return;
                    }
                }

                //Update Operation
                fillSiteWithFormData(siteForView);
                JOptionPane.showMessageDialog(null,"Product updated successfully","SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                populateSiteTable();
                clearFormFields();
                viewForm(false);
            }
        }
    }//GEN-LAST:event_btnUpdateOrCreateActionPerformed

    
    private void fillSiteWithFormData(Site site)
    {
        site.setOrganizationName(txtSiteName.getText().trim());
        
        Location location = site.getLocation();
        Contact contact = site.getContact();
        
        location.setAddressLine1(txtAddressLine1.getText().trim());
        location.setAddressLine2(txtAddressLine2.getText().trim());
        location.setCity(txtCity.getText().trim());
        location.setState(txtState.getText().trim());
        location.setCountry(txtCountry.getText().trim());
        
        contact.setPrimaryPhoneNumber(txtPrimaryPhoneNumber.getText().trim());
        contact.setSecondaryPhoneNumber(txtSecondaryPhoneNumber.getText().trim());
        contact.setEmailId(txtEmailId.getText().trim());
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnManageSiteAdministrators;
    private javax.swing.JButton btnUpdateOrCreate;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox jComboBoxSiteType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelDataForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddressLine1;
    private javax.swing.JLabel lblAddressLine1Validator;
    private javax.swing.JLabel lblAddressLine2;
    private javax.swing.JLabel lblAddressLine2Validator;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCityValidator;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblCountryValidator;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblEmailIdValidator;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblPersonName;
    private javax.swing.JLabel lblPrimaryPhoneNumber;
    private javax.swing.JLabel lblPrimaryPhoneNumberValidator;
    private javax.swing.JLabel lblSecondaryPhoneNumber;
    private javax.swing.JLabel lblSiteName;
    private javax.swing.JLabel lblSiteNameValidator;
    private javax.swing.JLabel lblSiteType;
    private javax.swing.JLabel lblSitesConfigurator;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStateValidator;
    private javax.swing.JTable tblSites;
    private javax.swing.JTextField txtAddressLine1;
    private javax.swing.JTextField txtAddressLine2;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtPrimaryPhoneNumber;
    private javax.swing.JTextField txtSecondaryPhoneNumber;
    private javax.swing.JTextField txtSiteName;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}
