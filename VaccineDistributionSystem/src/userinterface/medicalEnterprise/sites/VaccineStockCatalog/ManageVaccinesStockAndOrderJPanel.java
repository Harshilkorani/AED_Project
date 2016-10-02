/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.medicalEnterprise.sites.VaccineStockCatalog;

import business.Business;
import business.enterprise.CDCEnterprise;
import business.enterprise.DistributorEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.enterprise.MedicalEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.medicalenterpriseOrganizations.ProviderManagementOrganization;
import business.organization.useraccount.UserAccount;
import business.organization.work.VaccineWorkRequest;
import business.organization.work.WorkQueue;
import business.organization.work.WorkRequest;
import business.site.Site;
import business.site.siteVaccineOrder.VaccineMasterOrderCatalog;
import business.site.siteVaccineOrder.VaccineOrder;
import business.site.siteVaccineOrder.VaccineOrderItem;
import business.vaccine.Vaccine;
import business.vaccineStock.VaccineStock;
import business.vaccineStock.VaccineStockCatalog;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshil
 */
public class ManageVaccinesStockAndOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageVaccinesStockAndOrderJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Network network;
    private Enterprise enterprise;
    private MedicalEnterprise medicalEnterprise;
    private Site site;
    private Business business;
    private VaccineStockCatalog vaccineStockCatalog;
    private VaccineMasterOrderCatalog vaccineMasterOrderCatalog;
    private VaccineOrder vaccineOrder;
    private boolean isCheckedOut = false;
    
    
    private Network tempNetwork;
    private String tempName;
    private EnterpriseDirectory distributorEnterpriseDirectory;
    private DistributorEnterprise distributorEnterprise;
    
    
    public ManageVaccinesStockAndOrderJPanel(JPanel userProcessContainer,UserAccount userAccount,Network network,Enterprise enterprise,Site site,Business business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.network = network;
        this.medicalEnterprise = (MedicalEnterprise)enterprise;
        this.site = site;
        this.business = business;
        this.vaccineMasterOrderCatalog = medicalEnterprise.getVaccineMasterOrderCatalog();
        
        preConfigurations();
       
        if(isCheckedOut == false)
        {
            vaccineOrder = new VaccineOrder();
        } 
        refreshVaccineTable();
        
    }
    
    
    private void preConfigurations()
    {
        
        Network network1 = network;
        Network network2;
        Network network3;
        
        network2 = network.getParentNetwork(network1);
        network3 = network2.getParentNetwork(network2);
        tempName = network3.getNetworkName();
        System.out.println(tempName);
        /////////tempNetwork = network.getParentNetwork().findCountryNetwork(tempName);
        /////////////System.out.println(tempNetwork);
        
        //cdcEnterpriseDirectory = tempNetwork.getAllCDCEnterprise();
       
        distributorEnterpriseDirectory = network3.getAllDistributorEnterprise(); 
        /*
        for(Enterprise cdcEnterprise: cdcEnterpriseDirectory.getEnterpriseList())
        {
            if(cdcEnterprise instanceof CDCEnterprise)
            {
                tempEnterprise = (CDCEnterprise)cdcEnterprise;
            }
        }
        */
        
        for(Enterprise de:distributorEnterpriseDirectory.getEnterpriseList())
        {
            if(de instanceof DistributorEnterprise)
            {
                distributorEnterprise = (DistributorEnterprise)de;
            }
        }
        
        this.vaccineStockCatalog = distributorEnterprise.getVaccineStockCatalog();
       // this.vaccineMasterOrderCatalog = distributorEnterprise.getVaccineMasterOrderCatalog();
    }
    
    
    public void refreshVaccineTable()
    {
        int rowCount = tblVaccine.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)tblVaccine.getModel();
        dtm.setRowCount(0);
       
        
        for(VaccineStock vaccine:vaccineStockCatalog.getVaccineStockList())
        {
            Object row[] = new Object[4];
            row[0] = vaccine;
            row[1] = vaccine.getVaccine().getVaccineID();
            row[2] = vaccine.getVaccineStockQuantity();
            row[3] = vaccine.getVaccine().getVaccinePrice();
            dtm.addRow(row);   
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
        tblVaccine = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineOrderRequest = new javax.swing.JTable();
        btnAddVaccineRequestToCart = new javax.swing.JButton();
        spinnerQuantity = new javax.swing.JSpinner();
        lblQuantity = new javax.swing.JLabel();
        btnSubmitOrderAndCheckout = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Manage Vaccine Order Requests");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 11, -1, -1));

        tblVaccine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Available Stock", "Vaccine Price"
            }
        ));
        jScrollPane1.setViewportView(tblVaccine);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 69, 527, 93));

        tblVaccineOrderRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Vaccine Quantity", "Total Vaccine Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVaccineOrderRequest);
        if (tblVaccineOrderRequest.getColumnModel().getColumnCount() > 0) {
            tblVaccineOrderRequest.getColumnModel().getColumn(0).setResizable(false);
            tblVaccineOrderRequest.getColumnModel().getColumn(1).setResizable(false);
            tblVaccineOrderRequest.getColumnModel().getColumn(2).setResizable(false);
            tblVaccineOrderRequest.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 267, 527, 92));

        btnAddVaccineRequestToCart.setBackground(new java.awt.Color(102, 102, 255));
        btnAddVaccineRequestToCart.setText("Add Vaccine Request to Cart");
        btnAddVaccineRequestToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVaccineRequestToCartActionPerformed(evt);
            }
        });
        add(btnAddVaccineRequestToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 168, -1, -1));
        add(spinnerQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 169, 50, -1));

        lblQuantity.setText("Quantity");
        add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 172, -1, -1));

        btnSubmitOrderAndCheckout.setBackground(new java.awt.Color(102, 102, 255));
        btnSubmitOrderAndCheckout.setText("Submit Vaccine Request");
        btnSubmitOrderAndCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitOrderAndCheckoutActionPerformed(evt);
            }
        });
        add(btnSubmitOrderAndCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 377, 167, -1));

        btnBack.setBackground(new java.awt.Color(102, 102, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 377, -1, -1));

        btnRemove.setBackground(new java.awt.Color(102, 102, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 377, -1, -1));

        jLabel2.setText("Vaccine Requests In Cart");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 247, -1, -1));

        jLabel3.setText("Vaccine Catalog with Stock");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 49, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddVaccineRequestToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVaccineRequestToCartActionPerformed
        // TODO add your handling code here:
        
        isCheckedOut = false;
        
        //check if Vaccine is selected
        VaccineStock selectVaccine;
        int selectedRow = tblVaccine.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null,"Please select a vaccine","PLEASE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else
        {
            selectVaccine = (VaccineStock)tblVaccine.getValueAt(selectedRow,0);
        }

        //fetching the quantity
        int fetchQuantity = (Integer)spinnerQuantity.getValue();
        if(fetchQuantity < 0 || fetchQuantity > (selectVaccine.getVaccineStockQuantity())/10)
        {
            JOptionPane.showMessageDialog(null, "Please note you cannot enter negative quantity or more than 10 percent of the available vaccine stock");
            return;
        }
        //All data valid, add the order item     
        boolean flag = true;
        ArrayList<VaccineOrderItem> vaccineOrderItemList = vaccineOrder.getVaccineOrderItemList();
        for(VaccineOrderItem vaccineOrderItem : vaccineOrderItemList) {
            if(vaccineOrderItem.getVaccine().equals(selectVaccine)) {
                int oldQuantity = vaccineOrderItem.getQuantity();
                int newQuantity = oldQuantity + fetchQuantity;
                vaccineOrderItem.setQuantity(newQuantity);
                flag = false;
            }
        }
        
        if(flag)
        {
            VaccineOrderItem vaccineOrderItem = vaccineOrder.createVaccineOrderItem(selectVaccine.getVaccine(), fetchQuantity); 
        }

        String notice = Integer.toString(fetchQuantity) + " " + selectVaccine.getVaccine().getVaccineName() + " was added to the Vaccine Request Cart.";
        JOptionPane.showMessageDialog(null, notice);
        
        selectVaccine.setVaccineStockQuantity(selectVaccine.getVaccineStockQuantity()- fetchQuantity);
        
        //populate Order Item Table
        refreshOrderTable();
        refreshVaccineTable();
        btnBack.setEnabled(false);
        
    }//GEN-LAST:event_btnAddVaccineRequestToCartActionPerformed

    
    public void refreshOrderTable()
    {
        int rowCount = tblVaccineOrderRequest.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)tblVaccineOrderRequest.getModel();
        for(int i =rowCount-1;i>=0;i--)
        {
            dtm.removeRow(i);
        }
        
        for(VaccineOrderItem vaccineOrderItem: vaccineOrder.getVaccineOrderItemList())
        {
            Object row[] = new Object[4];
            row[0] = vaccineOrderItem;
            row[1] = vaccineOrderItem.getVaccine().getVaccineID();
            row[2] = vaccineOrderItem.getQuantity();
            row[3] = vaccineOrderItem.getVaccine().getVaccinePrice() * vaccineOrderItem.getQuantity();
            dtm.addRow(row);
        }
        
    }
    
    
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        /*
        if(isCheckedOut == false) {
            for(VaccineOrderItem oi : vaccineOrder.getVaccineOrderItemList()) {
                VaccineStock vaccineStock = oi.getVaccine();
                int oldAvail = vaccine.get;
                int orderedQuantity = oi.getQuantity();
                int newAvail = oldAvail + orderedQuantity;
                product.setAvail(newAvail);
            }
            JOptionPane.showMessageDialog(null, "Your order has not checked out, so all your previous order will be canceled.");
        } else {
            JOptionPane.showMessageDialog(null, "Your order has already checked out.");
        }
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
        */
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitOrderAndCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitOrderAndCheckoutActionPerformed
        // TODO add your handling code here:
  
        
        System.out.println(vaccineOrder.getVaccineOrderID());
        
        //vaccineOrder.set;
        vaccineOrder.setVaccineOrderDate(new Date());
        vaccineOrder.setUserAccount(userAccount);
        //System.out.println(order.getCustomer());
        
        vaccineMasterOrderCatalog.createVaccineOrder(vaccineOrder);
       
        VaccineWorkRequest requestProvider = new VaccineWorkRequest();
        requestProvider.setVaccineOrder(vaccineOrder);
        requestProvider.setSenderUserAccount(userAccount);
        requestProvider.setOriginalSender(userAccount);
        
        requestProvider.setStatus("Vaccine Order Requested");
        
        Organization org = null;
        for (Organization organization :medicalEnterprise.getOrganizationDirectory().getOrganizationList() ){
            if (organization instanceof ProviderManagementOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(requestProvider);
            userAccount.getWorkQueue().getWorkRequestList().add(requestProvider);
            requestProvider.getVaccineOrder().setVaccineOrderStatus(WorkRequest.StatusType.VaccineRequested.getValue());
        }
        
        isCheckedOut= true;
        JOptionPane.showMessageDialog(null,"Order added successfully");
        vaccineOrder = new VaccineOrder();
        
        refreshOrderTable();

        btnBack.setEnabled(true);
    }//GEN-LAST:event_btnSubmitOrderAndCheckoutActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        
        
        int selectedRowCount = tblVaccineOrderRequest.getSelectedRowCount();
        if(selectedRowCount<=0) {
            JOptionPane.showMessageDialog(null, "You didn't select any rows from the Vaccine orderItem table!");
            return;
        }
        
        int row =tblVaccineOrderRequest.getSelectedRow();
        if(row < 0) {
            JOptionPane.showMessageDialog(null, "Failed to retrive selected row");
            return;
        }
        
        VaccineOrderItem oi = (VaccineOrderItem)tblVaccineOrderRequest.getValueAt(row, 0);
        for(VaccineStock vaccineStock:vaccineStockCatalog.getVaccineStockList())
        {
            if(vaccineStock.getVaccine().equals(oi.getVaccine()))
            {
                int oldQuantity = vaccineStock.getVaccineStockQuantity();
                int orderQuantity = oi.getQuantity();
                int newQuantity = oldQuantity + orderQuantity;
                vaccineStock.setVaccineStockQuantity(newQuantity);
                
            }
        }
        
        
        vaccineOrder.removeVaccineOrderItem(oi);
       // JOptionPane.showMessageDialog(null, "The order item of " + orderQuantity + "of " + oi + " has been removed.");
        refreshOrderTable();
        refreshVaccineTable();
        
        int a = tblVaccineOrderRequest.getRowCount();
        if(a==0)
        {
            btnBack.setEnabled(true);
        }
                
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVaccineRequestToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSubmitOrderAndCheckout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JSpinner spinnerQuantity;
    private javax.swing.JTable tblVaccine;
    private javax.swing.JTable tblVaccineOrderRequest;
    // End of variables declaration//GEN-END:variables
}
