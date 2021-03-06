/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.medicalEnterprise;

import business.Business;
import business.organization.useraccount.UserAccount;
import business.site.Site;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.ManageOrganizationEmployeeJPanel;
import userinterface.ManageOrganizationUserJPanel;

/**
 *
 * @author Harshil
 */
public class ManageEmployeeUserOfSiteAdministrationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEmployeeUserOfSiteAdministrationJPanel
     */
    
    private Site site;
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Business business;
    
    public ManageEmployeeUserOfSiteAdministrationJPanel(JPanel userProcessContainer, UserAccount userAccount, Site site,Business business) {
        initComponents();
        
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        this.site = site;
        this.business = business;
        
        lblHeading.setText(site.getOrganizationName());
        
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
        lblHeading = new javax.swing.JLabel();
        btnManageEmployee = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        btnBack.setBackground(new java.awt.Color(102, 102, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("jLabel1");

        btnManageEmployee.setBackground(new java.awt.Color(102, 102, 255));
        btnManageEmployee.setText("Manage Employee");
        btnManageEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmployeeActionPerformed(evt);
            }
        });

        btnManageUsers.setBackground(new java.awt.Color(102, 102, 255));
        btnManageUsers.setText("Manage Users/Admins");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(btnBack))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(316, 316, 316)
                            .addComponent(lblHeading))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(230, 230, 230)
                            .addComponent(btnManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(88, 88, 88)
                .addComponent(lblHeading)
                .addGap(36, 36, 36)
                .addComponent(btnManageEmployee)
                .addGap(42, 42, 42)
                .addComponent(btnManageUsers)
                .addContainerGap(290, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnManageEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeeActionPerformed
        ManageOrganizationEmployeeJPanel panel=new ManageOrganizationEmployeeJPanel(userProcessContainer,userAccount,site,business);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Configure Employee of Amazon Enterprise", panel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEmployeeActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
        ManageOrganizationUserJPanel panel=new ManageOrganizationUserJPanel(userProcessContainer,userAccount,site,business);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Configure users/admins of Amzon Enterprise", panel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageUsersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnManageEmployee;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JLabel lblHeading;
    // End of variables declaration//GEN-END:variables
}
