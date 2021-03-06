/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import business.Business;
import business.organization.Organization;
import business.organization.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Harshil
 */
public class ManageOrganizationsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageSiteJPanel
     */
    
    private JPanel userProcessContainer;
    private Organization organization;
    private UserAccount userAccount;
    private Business business;
    
    public ManageOrganizationsJPanel(JPanel userProcessContainer, UserAccount userAccount,Organization organization,Business business) {
        initComponents();
        
        this.organization=organization;
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.business=business;
        populateFormFields();
        
    }
    
    private void populateFormFields()
    {
        lblEnterpriseOrSite.setText(organization.getOrganizationName());
        lblWelcome.setText("Welcome "+userAccount.getEmployee().getPerson().getFirstName()+" !");
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        lblEnterpriseOrSite = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnManageUserRoles = new javax.swing.JButton();
        btnCreateEmployee = new javax.swing.JButton();
        btnCreateOrganization = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWelcome.setText("Welcome");

        lblEnterpriseOrSite.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEnterpriseOrSite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnterpriseOrSite.setText("EnterpriseOrSite");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManageUserRoles.setBackground(new java.awt.Color(102, 102, 255));
        btnManageUserRoles.setText("Manage User Roles");
        btnManageUserRoles.setPreferredSize(new java.awt.Dimension(200, 25));
        btnManageUserRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUserRolesActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageUserRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        btnCreateEmployee.setBackground(new java.awt.Color(102, 102, 255));
        btnCreateEmployee.setText("Manage Employee Directory");
        btnCreateEmployee.setPreferredSize(new java.awt.Dimension(200, 25));
        btnCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreateEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        btnCreateOrganization.setBackground(new java.awt.Color(102, 102, 255));
        btnCreateOrganization.setText("Manage Organizations");
        btnCreateOrganization.setPreferredSize(new java.awt.Dimension(200, 25));
        btnCreateOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateOrganizationActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreateOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblEnterpriseOrSite)
                .addGap(269, 269, 269))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWelcome))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblWelcome)
                .addGap(52, 52, 52)
                .addComponent(lblEnterpriseOrSite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageUserRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUserRolesActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Admin-Manage Organization User", new Admin_ManageOrganizationUserJPanel(userProcessContainer,userAccount,organization,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageUserRolesActionPerformed

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Admin-Manage Employee", new Admin_ManageEmployeeJPanel(userProcessContainer,userAccount,organization,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void btnCreateOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateOrganizationActionPerformed

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Admin Manage Site", new AdminManageOrganizationsJPanel(userProcessContainer,userAccount,organization,business));
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnCreateOrganizationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JButton btnCreateOrganization;
    private javax.swing.JButton btnManageUserRoles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEnterpriseOrSite;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
