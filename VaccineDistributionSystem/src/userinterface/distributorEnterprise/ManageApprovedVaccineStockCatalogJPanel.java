/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.distributorEnterprise;

import business.Business;
import business.enterprise.CDCEnterprise;
import business.enterprise.DistributorEnterprise;
import business.enterprise.Enterprise;
import static business.enterprise.Enterprise.EnterpriseType.DistributorEnterprise;
import business.enterprise.EnterpriseDirectory;
import business.network.Network;
import business.organization.Organization;
import business.organization.useraccount.UserAccount;
import business.site.Site;
import business.utility.Validation;
import business.vaccine.Vaccine;
import business.vaccine.VaccineCatalog;
import business.vaccineStock.VaccineStock;
import business.vaccineStock.VaccineStockCatalog;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshil
 */
public class ManageApprovedVaccineStockCatalogJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageApprovedVaccineStockCatalogJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Network network;
    private Enterprise enterprise;
    private Organization organization;
    private Business business;
    
    private VaccineStockCatalog vaccineStockCatalog;
    
    
    private DistributorEnterprise distributorEnterprise;
    private CDCEnterprise cdcEnterprise;
    EnterpriseDirectory cdcEnterpriseDirectory;
    EnterpriseDirectory distributorEnterpriseDirectory;
    
    private Network tempNetwork;
    private String tempName;
    private CDCEnterprise tempEnterprise; 
      
    
    public ManageApprovedVaccineStockCatalogJPanel(JPanel userProcessContainer,UserAccount userAccount,Network network,Enterprise enterprise,Organization organization,Business business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        this.business = business;
       // this.distributorEnterprise = (DistributorEnterprise)enterprise;
        
        
        preConfigurations();
        
        //VaccineCatalog vc3 = tempEnterprise.getApprovedVaccineCatalog();
        
        populateFormData();
        
    }
    
    private void preConfigurations()
    {
        
        tempName = network.getNetworkName();
        tempNetwork = network.getParentNetwork().findCountryNetwork(tempName);
        System.out.println(tempNetwork);
        
        cdcEnterpriseDirectory = tempNetwork.getAllCDCEnterprise();
        
        distributorEnterpriseDirectory = tempNetwork.getAllDistributorEnterprise();
        
        for(Enterprise cdcEnterprise: cdcEnterpriseDirectory.getEnterpriseList())
        {
            if(cdcEnterprise instanceof CDCEnterprise)
            {
                tempEnterprise = (CDCEnterprise)cdcEnterprise;
            }
        }
        
        
        
        for(Enterprise de:distributorEnterpriseDirectory.getEnterpriseList())
        {
            if(de instanceof DistributorEnterprise)
            {
                distributorEnterprise = (DistributorEnterprise)de;
            }
        }
        
        this.vaccineStockCatalog = distributorEnterprise.getVaccineStockCatalog();
        
        
    }
    
    
    private void populateFormData()
    {
        lblDistributor.setText("Welcome "+userAccount.getEmployee().getPerson().getFirstName());
        lblCDCCountryName.setText("CDC Approved Vaccine Catalog with Stock of Country "+tempName);
    
        populateVaccineTable();
       populateVaccineStockTable();
    }
    
    
    private void populateVaccines()
    {
        cmbVaccine.removeAllItems();
        for(Vaccine vaccine: tempEnterprise.getApprovedVaccineCatalog().getVaccineList())
        {
                 cmbVaccine.addItem(vaccine); 
        }
    }
    
    /*
    private void setValidatorsToDefault()
    {
        lblVaccineAvailability.setText("");
    }
    */
    
    private boolean validateFormFields()
    {
        //For Empty check
        if(Validation.validateTextFieldsForNonEmpty(txtVaccineAvailableQuantity))
        {
               if(Validation.validateTextFieldsForInteger(txtVaccineAvailableQuantity))
                {
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please enter an Integer value");
                    return false;
                }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please enter an Integer value. This field cannot be empty:");
            return false;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCDCApprovedVaccineCatalog = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        lblVaccineAvailability = new javax.swing.JLabel();
        txtVaccineName = new javax.swing.JTextField();
        txtVaccineAvailableQuantity = new javax.swing.JTextField();
        btnUpdateVaccineDetails = new javax.swing.JButton();
        btnGetVaccines = new javax.swing.JButton();
        lblQuantityValidator = new javax.swing.JLabel();
        cmbVaccine = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        lblCDCCountryName = new javax.swing.JLabel();
        lblDistributor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDistributorVaccineCatalog = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Distributor Work Area");

        tblCDCApprovedVaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Vaccine Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCDCApprovedVaccineCatalog);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Vaccine Name:");

        lblVaccineAvailability.setText("Vaccine Available Quantity:");

        txtVaccineName.setEnabled(false);

        txtVaccineAvailableQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaccineAvailableQuantityActionPerformed(evt);
            }
        });

        btnUpdateVaccineDetails.setBackground(new java.awt.Color(102, 102, 255));
        btnUpdateVaccineDetails.setText("Update Vaccine Details");
        btnUpdateVaccineDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateVaccineDetailsActionPerformed(evt);
            }
        });

        btnGetVaccines.setBackground(new java.awt.Color(102, 102, 255));
        btnGetVaccines.setText("Get Vaccines");
        btnGetVaccines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetVaccinesActionPerformed(evt);
            }
        });

        lblQuantityValidator.setText("Vaccine:");

        cmbVaccine.setBackground(new java.awt.Color(102, 102, 255));
        cmbVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVaccineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(404, 404, 404))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblQuantityValidator)
                                    .addComponent(lblVaccineAvailability))
                                .addGap(81, 81, 81)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVaccineAvailableQuantity)
                                    .addComponent(txtVaccineName)
                                    .addComponent(cmbVaccine, 0, 146, Short.MAX_VALUE)))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnGetVaccines))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btnUpdateVaccineDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, lblVaccineAvailability});

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGetVaccines, btnUpdateVaccineDetails});

        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnGetVaccines)
                .addGap(28, 28, 28)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantityValidator)
                    .addComponent(cmbVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaccineAvailability)
                    .addComponent(txtVaccineAvailableQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateVaccineDetails)
                .addGap(81, 81, 81))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, lblVaccineAvailability});

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGetVaccines, btnUpdateVaccineDetails});

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblVaccineAvailability, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtVaccineName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtVaccineAvailableQuantity, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnUpdateVaccineDetails, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnGetVaccines, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblQuantityValidator, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cmbVaccine, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblCDCCountryName.setText("CDC - Approved Vaccine Catalog");

        lblDistributor.setText("Distributor");

        tblDistributorVaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Vaccine Price", "Vaccine Available Quantity"
            }
        ));
        jScrollPane2.setViewportView(tblDistributorVaccineCatalog);

        btnBack.setBackground(new java.awt.Color(102, 102, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel1)
                .addGap(410, 793, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCDCCountryName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDistributor))
                            .addComponent(jLayeredPane1)
                            .addComponent(jScrollPane1))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCDCCountryName)
                    .addComponent(lblDistributor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(484, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetVaccinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetVaccinesActionPerformed
        // TODO add your handling code here:
        populateVaccines();
    }//GEN-LAST:event_btnGetVaccinesActionPerformed

    private Vaccine getSelectedVaccine()
    {
        return (Vaccine)cmbVaccine.getSelectedItem();
    }
    
    
    private void cmbVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVaccineActionPerformed
        // TODO add your handling code here:
        
        Vaccine vaccine = getSelectedVaccine();
        if(vaccine!=null)
        {
            //txtVaccineID.setText(String.valueOf(vaccine.getVaccineID()));
            txtVaccineName.setText(vaccine.getVaccineName());
            //txtVaccinePrice.setText(String.valueOf(vaccine.getVaccinePrice()));   
        }
        
    }//GEN-LAST:event_cmbVaccineActionPerformed

    
    private boolean validateForUniqueProductConfiguration(Vaccine vaccine)
    {
        
        for(VaccineStock vaccineStock:vaccineStockCatalog.getVaccineStockList())
        {
            if(vaccineStock.getVaccine()== vaccine)
            {
                return false;
            }
        }
        return true;
    }
    
    
    /*
    private void clearFormFields()
    {
        txtVaccineAvailableQuantity.setText("");
        txtVaccineID.setText("");
        txtVaccineName.setText("");
        txtVaccinePrice.setText("");
       
    }
    */
    
    
    private int getVaccineStockIdCorrespondingToTheVaccine(Vaccine vaccine)
    {
        for(VaccineStock vaccineStock:vaccineStockCatalog.getVaccineStockList())
        {
            if(vaccineStock.getVaccine() == vaccine)
            {
                return vaccineStock.getVaccine().getVaccineID();
            }
        }
        return -1;
    }
    
    
    
    private void btnUpdateVaccineDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateVaccineDetailsActionPerformed
        // TODO add your handling code here:
       
       
        if(getSelectedVaccine()!=null)
        {
            if(validateFormFields())           
            {    
                if(validateForUniqueProductConfiguration(getSelectedVaccine()))
                {
                        VaccineStock vaccineStock = vaccineStockCatalog.createVaccineStock(getSelectedVaccine(),Integer.parseInt(txtVaccineAvailableQuantity.getText().trim()));
                        //clearFormFields();
                        JOptionPane.showMessageDialog(null,"Vaccine Stock created successfully","SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        populateVaccineStockTable();
                        
                }
                else
                {
                    int a = Integer.parseInt(txtVaccineAvailableQuantity.getText());
                    populateVaccineStockTable(a,getSelectedVaccine());
                        int id=getVaccineStockIdCorrespondingToTheVaccine(getSelectedVaccine());
                        JOptionPane.showMessageDialog(null,"Vaccine is already configured: New Stock with quantity "+a+" has been added to: "+getSelectedVaccine()+" ", "Information",JOptionPane.INFORMATION_MESSAGE);
                }
            
                
            }
       
        }    
    }//GEN-LAST:event_btnUpdateVaccineDetailsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtVaccineAvailableQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaccineAvailableQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVaccineAvailableQuantityActionPerformed

   
    
    
    private void populateVaccineTable()
    {
        DefaultTableModel model=(DefaultTableModel)tblCDCApprovedVaccineCatalog.getModel();
        model.setNumRows(0);
        
        for(Vaccine vc1: tempEnterprise.getApprovedVaccineCatalog().getVaccineList())
        {
                Object row[]=new Object[4];
                row[0] = vc1; 
                row[1] = vc1.getVaccineID();
                row[2] = vc1.getVaccinePrice();      
                model.addRow(row);
        }
    }
    
    
    private void populateVaccineStockTable()
    {
        DefaultTableModel model=(DefaultTableModel)tblDistributorVaccineCatalog.getModel();
        model.setNumRows(0);
        
        for(VaccineStock vaccineStock: distributorEnterprise.getVaccineStockCatalog().getVaccineStockList() )
        {
                Object row[]=new Object[4];
                row[0] = vaccineStock; 
                row[1] = vaccineStock.getVaccine().getVaccineID();
                row[2] = vaccineStock.getVaccine().getVaccinePrice();
                row[3] = vaccineStock.getVaccineStockQuantity();
                model.addRow(row);
        }
    }
    
    
    private void populateVaccineStockTable(int a, Vaccine vaccine)
    {
        DefaultTableModel model=(DefaultTableModel)tblDistributorVaccineCatalog.getModel();
        model.setNumRows(0);
        Vaccine vaccine1;
        int x;
        vaccine1 = vaccine;
        x = a;
        
        for(VaccineStock vaccineStock: distributorEnterprise.getVaccineStockCatalog().getVaccineStockList() )
        {
            if(vaccineStock.getVaccine()==vaccine1)
            {
                int newQuantity = vaccineStock.getVaccineStockQuantity() + x;
                vaccineStock.setVaccineStockQuantity(newQuantity);
                
            }
        }
        populateVaccineStockTable();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGetVaccines;
    private javax.swing.JButton btnUpdateVaccineDetails;
    private javax.swing.JComboBox cmbVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCDCCountryName;
    private javax.swing.JLabel lblDistributor;
    private javax.swing.JLabel lblQuantityValidator;
    private javax.swing.JLabel lblVaccineAvailability;
    private javax.swing.JTable tblCDCApprovedVaccineCatalog;
    private javax.swing.JTable tblDistributorVaccineCatalog;
    private javax.swing.JTextField txtVaccineAvailableQuantity;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
