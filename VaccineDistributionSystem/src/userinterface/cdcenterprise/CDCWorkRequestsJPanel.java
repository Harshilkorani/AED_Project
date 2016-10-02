/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.cdcenterprise;

import business.Business;
import business.enterprise.CDCEnterprise;
import business.enterprise.DPHEnterprise;
import business.enterprise.DistributorEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.network.Network;
import business.organization.Organization;
import business.organization.useraccount.UserAccount;
import business.organization.work.VaccineWorkRequest;
import business.organization.work.WorkRequest;
import business.site.siteVaccineOrder.VaccineOrder;
import business.site.siteVaccineOrder.VaccineOrderItem;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshil
 */
public class CDCWorkRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CDCWorkRequestJPanel
     */
    
    private JPanel userProcessContainer;
    private Network network;
    private Enterprise enterprise;
    private Organization enterpriseOrganization;
    private UserAccount userAccount;
    private Business business;
    
    
    private CDCEnterprise cdcEnterprise;
    private EnterpriseDirectory distributorEnterpriseDirectory;
    private DistributorEnterprise distributorEnterprise;
    
    public CDCWorkRequestsJPanel(JPanel userProcessContainer,UserAccount userAccount,Network network,Enterprise enterprise,Organization enterpriseOrganization,Business business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.network = network;
        this.enterprise = enterprise;
        this.cdcEnterprise = (CDCEnterprise)enterprise;
        this.enterpriseOrganization = enterpriseOrganization;
        this.business = business;
        
        populateWorkRequestTable();
        
    }

    
    public void populateWorkRequestTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)workRequestJTable.getModel();
        dtm.setRowCount(0);
        Organization organization = cdcEnterprise;
        {
            if (organization instanceof CDCEnterprise)
            {
                for(WorkRequest wr:organization.getWorkQueue().getWorkRequestList())
                {
                    if(wr instanceof VaccineWorkRequest)
                    {
                        VaccineWorkRequest vwtp = (VaccineWorkRequest)wr;
                        Object row[] = new Object[7];
                        row[0] = wr;
                        row[1] = wr.getOriginalSender();
                        row[2] = wr.getRequestDate();
                        row[3] = wr.getSenderUserAccount();
                        row[4] = wr.getReceivingUserAccount();
                        row[5] = wr.getStatus();
                        row[6] = vwtp.getVaccineOrder();
                        dtm.addRow(row);
                    }
                }
            }
            
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
        workRequestJTable = new javax.swing.JTable();
        btnAssignToMe = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnViewOrder = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineRequest = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("CDC Work Requests");

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Request ID", "Original Sender", "TimeStamp", "Sender", "Receiver", "Status", "Vaccine Order ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        btnAssignToMe.setBackground(new java.awt.Color(102, 102, 255));
        btnAssignToMe.setText("Assign To Me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(102, 102, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnViewOrder.setBackground(new java.awt.Color(102, 102, 255));
        btnViewOrder.setText("View Order");
        btnViewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderActionPerformed(evt);
            }
        });

        btnProcess.setBackground(new java.awt.Color(102, 102, 255));
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        tblVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine Quantity Request", "Total Vaccine Price"
            }
        ));
        jScrollPane2.setViewportView(tblVaccineRequest);

        jLabel2.setText("CDC Organizations Work Queue");

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
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAssignToMe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnViewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(417, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(455, 455, 455))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnRefresh))
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignToMe)
                    .addComponent(btnViewOrder)
                    .addComponent(btnProcess))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(353, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:

        int selectedRow = workRequestJTable.getSelectedRow();

        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null,"Please select a Row:");
            return;
        }
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);

        if(request.getStatus().equalsIgnoreCase(WorkRequest.StatusType.Forwarded.getValue()))
        {
            Organization org = null;
            for (Organization organization : cdcEnterprise.getOrganizationDirectory().getOrganizationList()){
                if (organization instanceof CDCEnterprise){
                    org = organization;
                    break;
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(request);

            }
        }
        request.setReceivingUserAccount(userAccount);
        request.setStatus(WorkRequest.StatusType.Pending.getValue());
        populateWorkRequestTable();
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateWorkRequestTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnViewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderActionPerformed
        // TODO add your handling code here:

        DefaultTableModel dtm = (DefaultTableModel)tblVaccineRequest.getModel();
        dtm.setRowCount(0);
        int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null,"Please select a Row:");
            return;
        }
        VaccineOrder vaccineOrder = (VaccineOrder)workRequestJTable.getValueAt(selectedRow,6);

        for(VaccineOrderItem vaccineOrderItem:vaccineOrder.getVaccineOrderItemList())
        {
            Object row[] = new Object[3];
            row[0] = vaccineOrderItem.getVaccine();
            row[1] = vaccineOrderItem.getQuantity();
            row[2] = vaccineOrderItem.getVaccinePrice() * vaccineOrderItem.getQuantity();
            dtm.addRow(row);
        }
    }//GEN-LAST:event_btnViewOrderActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a Row:");
            return;
        }

        VaccineWorkRequest request = (VaccineWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        if(request.getReceivingUserAccount().equals(userAccount))
        {
            request.setStatus(WorkRequest.StatusType.InProcess.getValue());

            sendRequestToDistributor();

            Organization org = distributorEnterprise;

        //Organization org = null;
        // for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList() ){
            //   if (organization instanceof DPHEnterprise){
                //     org = organization;
                //   break;
                //  }
            //  }

            if (org!=null){

            org.getWorkQueue().getWorkRequestList().add(request);
            // userAccount.getWorkQueue().getWorkRequestList().add(request);
            request.getVaccineOrder().setVaccineOrderStatus(WorkRequest.StatusType.Forwarded.getValue());
            request.setSenderUserAccount(userAccount);
            request.setStatus(WorkRequest.StatusType.Forwarded.getValue());
            populateWorkRequestTable();
            JOptionPane.showMessageDialog(null,"Vaccine Work Request is Forwarded to National Distributor:");
            populateWorkRequestTable();
            
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please assign the request to yourself and then process");
        }
       

    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    
     private void sendRequestToDistributor()
    {
        String tempName = network.getNetworkName();
        System.out.println(tempName);
        
        distributorEnterpriseDirectory = network.getAllDistributorEnterprise();
        
        for(Enterprise de:distributorEnterpriseDirectory.getEnterpriseList())
        {
            if(de instanceof DistributorEnterprise)
            {
                distributorEnterprise = (DistributorEnterprise)de;
            }
        }
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnViewOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVaccineRequest;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
