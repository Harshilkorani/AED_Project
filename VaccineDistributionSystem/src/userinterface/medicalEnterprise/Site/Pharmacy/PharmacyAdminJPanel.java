/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.medicalEnterprise.Site.Pharmacy;

import business.Business;
import business.enterprise.Enterprise;
import business.enterprise.MedicalEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.useraccount.UserAccount;
import business.site.Site;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.medicalEnterprise.sites.VaccineStockCatalog.ManageVaccinesStockAndOrderJPanel;
import userinterface.medicalEnterprise.sites.VaccineStockCatalog.VaccineOrderHistoryJPanel;

/**
 *
 * @author Harshil
 */
public class PharmacyAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyAdminJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Network network;
    private Enterprise enterprise;
    private MedicalEnterprise medicalEnterprise;
    private Organization enterpriseOrganization;
    private Business business;
    private Site site;
    
    
    public PharmacyAdminJPanel(JPanel userProcessContainer,UserAccount userAccount,Network network,Enterprise enterprise,Organization enterpriseOrganization,Site site,Business business) {
        initComponents();
        
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        this.network = network;
        this.enterprise = enterprise;
        this.medicalEnterprise = (MedicalEnterprise)enterprise;
        this.enterpriseOrganization = enterpriseOrganization;
        this.business = business;
        this.site = site;
        
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
        jButton1 = new javax.swing.JButton();
        btnVaccineOrderHistory = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Pharmacy Work Area");

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Manage Vaccine Orders And Requests");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnVaccineOrderHistory.setBackground(new java.awt.Color(102, 102, 255));
        btnVaccineOrderHistory.setText("Vaccine Order History");
        btnVaccineOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineOrderHistoryActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/medicalEnterprise/Site/Pharmacy/VACCINATION-LOGO-ENG.JPG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1))
                            .addComponent(btnVaccineOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(42, 42, 42)
                .addComponent(btnVaccineOrderHistory)
                .addContainerGap(257, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        ManageVaccinesStockAndOrderJPanel mvsaojp = new ManageVaccinesStockAndOrderJPanel(userProcessContainer,userAccount,network,enterprise,site,business);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Configure Employee/User for Node Admnistration", mvsaojp);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVaccineOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineOrderHistoryActionPerformed
        // TODO add your handling code here:

        VaccineOrderHistoryJPanel vaccineOrderHistoryJPanel = new VaccineOrderHistoryJPanel(userProcessContainer,userAccount,network,medicalEnterprise,site,business);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Vaccine Order History", vaccineOrderHistoryJPanel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnVaccineOrderHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVaccineOrderHistory;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}