/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.cdcenterprise;

import business.Business;
import business.enterprise.CDCEnterprise;
import static business.enterprise.Enterprise.EnterpriseType.CDCEnterprise;
import business.organization.useraccount.UserAccount;
import business.utility.Validation;
import business.vaccine.Vaccine;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Harshil
 */
public class CreateNewVaccineJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateNewVaccineJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private CDCEnterprise cdcEnterprise;
    private Business business;
    
    public CreateNewVaccineJPanel(JPanel userProcessContainer,UserAccount userAccount,CDCEnterprise cdcEnterprise,Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.cdcEnterprise = cdcEnterprise;
        this.business = business;
        this.userAccount = userAccount;
                
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
        txtVaccineName = new javax.swing.JTextField();
        txtVaccinePrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Create New Vaccine");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        txtVaccineName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtVaccineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 210, -1));

        txtVaccinePrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtVaccinePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 160, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Vaccine Price :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 120, 30));

        createButton.setBackground(new java.awt.Color(102, 102, 255));
        createButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createButton.setText("Add Vaccine");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        add(createButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        backButton1.setBackground(new java.awt.Color(102, 102, 255));
        backButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Vaccine Name:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:

        if(Validation.validateTextFieldsForNonEmpty(txtVaccineName))
        {
            if(Validation.validateTextFieldsForInteger(txtVaccinePrice))
            {
                    String vName = txtVaccineName.getText();
                    boolean flag =false;
                    for(Vaccine v1:cdcEnterprise.getApprovedVaccineCatalog().getVaccineList())
                    {
                        if(v1.getVaccineName().equalsIgnoreCase(vName))
                        {
                            JOptionPane.showMessageDialog(null,"Vaccine with this Name already present int the Catalog:");
                            flag=true;
                        }
                    }
                    if(!flag)
                    {
                
                    Vaccine vaccine = cdcEnterprise.getApprovedVaccineCatalog().createVaccine(txtVaccineName.getText().trim());
                    String vaccinePrice = txtVaccinePrice.getText();
                        if(vaccinePrice.isEmpty()==false)
                        {
                            int price = Integer.parseInt(vaccinePrice);
                            vaccine.setVaccinePrice(price);
                            JOptionPane.showMessageDialog(null,"Vaccine Created Sucessfully");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please enter proper values");
                        }
                    }
            }
            else
            {
                    JOptionPane.showMessageDialog(null,"Please enter valid price");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please enter all information correctly");
        }

    }//GEN-LAST:event_createButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton1;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtVaccineName;
    private javax.swing.JTextField txtVaccinePrice;
    // End of variables declaration//GEN-END:variables
}