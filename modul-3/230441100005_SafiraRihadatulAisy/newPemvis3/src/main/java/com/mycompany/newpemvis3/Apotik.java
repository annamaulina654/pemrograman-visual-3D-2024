/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.newpemvis3;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Apotik extends javax.swing.JFrame {

    public Apotik() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pAtas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pTengah = new javax.swing.JPanel();
        cbTolakangin = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cbDiapet = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cbSanmol = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        cbCombi = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        cbPromag = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cbBodrex = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        cbMylanta = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        cbBetadine = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        cbHotincream = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        cbAntimo = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        pBawah = new javax.swing.JPanel();
        btnCEK = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pAtas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\logoApotek.png")); // NOI18N
        pAtas.add(jLabel1);

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("Elephant", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("APOTEK PHARMA");
        pAtas.add(jLabel2);

        getContentPane().add(pAtas, java.awt.BorderLayout.PAGE_START);

        pTengah.setBackground(new java.awt.Color(153, 204, 255));
        pTengah.setLayout(new java.awt.GridBagLayout());

        cbTolakangin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbTolakangin.setForeground(new java.awt.Color(242, 242, 242));
        cbTolakangin.setText("Tolak Angin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pTengah.add(cbTolakangin, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\TOLAKANGIN.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel3, gridBagConstraints);

        cbDiapet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbDiapet.setForeground(new java.awt.Color(255, 255, 255));
        cbDiapet.setText("Diapet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        pTengah.add(cbDiapet, gridBagConstraints);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\Diapet.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel4, gridBagConstraints);

        cbSanmol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbSanmol.setForeground(new java.awt.Color(242, 242, 242));
        cbSanmol.setText("Sanmol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pTengah.add(cbSanmol, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\SANMOL.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel5, gridBagConstraints);

        cbCombi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbCombi.setForeground(new java.awt.Color(242, 242, 242));
        cbCombi.setText("Combi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        pTengah.add(cbCombi, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\COMBI.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel6, gridBagConstraints);

        cbPromag.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbPromag.setForeground(new java.awt.Color(242, 242, 242));
        cbPromag.setText("Promag");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pTengah.add(cbPromag, gridBagConstraints);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\PROMAG.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel7, gridBagConstraints);

        cbBodrex.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbBodrex.setForeground(new java.awt.Color(242, 242, 242));
        cbBodrex.setText("Bodrex");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        pTengah.add(cbBodrex, gridBagConstraints);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\bodrex.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel8, gridBagConstraints);

        cbMylanta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbMylanta.setForeground(new java.awt.Color(255, 255, 255));
        cbMylanta.setText("Mylanta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        pTengah.add(cbMylanta, gridBagConstraints);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\MYLANTA.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel9, gridBagConstraints);

        cbBetadine.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbBetadine.setForeground(new java.awt.Color(242, 242, 242));
        cbBetadine.setText("Betadine");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        pTengah.add(cbBetadine, gridBagConstraints);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\BETADINE.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel10, gridBagConstraints);

        cbHotincream.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbHotincream.setForeground(new java.awt.Color(242, 242, 242));
        cbHotincream.setText("Hotin Cream");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        pTengah.add(cbHotincream, gridBagConstraints);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\hotin.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel11, gridBagConstraints);

        cbAntimo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbAntimo.setForeground(new java.awt.Color(242, 242, 242));
        cbAntimo.setText("Antimo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        pTengah.add(cbAntimo, gridBagConstraints);

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\ANTIMO.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pTengah.add(jLabel12, gridBagConstraints);

        getContentPane().add(pTengah, java.awt.BorderLayout.CENTER);

        pBawah.setLayout(new java.awt.GridLayout(1, 0));

        btnCEK.setText("Cek Fungsi Obat");
        btnCEK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCEKActionPerformed(evt);
            }
        });
        pBawah.add(btnCEK);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        pBawah.add(btnHapus);

        getContentPane().add(pBawah, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCEKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEKActionPerformed
        StringBuilder message = new StringBuilder("Fungsi obat yang dipilih:\n");

        if (cbAntimo.isSelected()) {
            message.append("- Antimo: Obat untuk mual dan mabuk perjalanan.\n");
        }
        if (cbBetadine.isSelected()) {
            message.append("- Betadine: Obat untuk menyembuhkan infeksi pada luka.\n");
        }
        if (cbBodrex.isSelected()) {
            message.append("- Bodrex: Obat untuk menyembuhkan sakit kepala.\n");
        }
        if (cbCombi.isSelected()) {
            message.append("- Combi: Obat untuk batuk.\n");
        }
        if (cbDiapet.isSelected()) {
            message.append("- Diapet: Obat untuk meredakan diare.\n");
        }
        if (cbHotincream.isSelected()) {
            message.append("- Hotin Cream: Obat untuk meredakan nyeri otot.\n");
        }
        if (cbMylanta.isSelected()) {
            message.append("- Mylanta: Obat untuk asam lambung.\n");
        }
        if (cbPromag.isSelected()) {
            message.append("- Promag: Obat untuk sakit maag.\n");
        }
        if (cbSanmol.isSelected()) {
            message.append("- Sanmol: Obat untuk menurunkan demam.\n");
        }
        if (cbTolakangin.isSelected()) {
            message.append("- Tolak Angin: Obat untuk mengatasi masuk angin.\n");
        }

        // Menampilkan pesan hasil pilihan checkbox
        if (message.toString().equals("Fungsi obat yang dipilih:\n")) {
            JOptionPane.showMessageDialog(null, "Tidak ada obat yang dipilih.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, message.toString(), "Informasi Obat", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCEKActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        cbAntimo.setSelected(false);
        cbBetadine.setSelected(false);
        cbBodrex.setSelected(false);
        cbCombi.setSelected(false);
        cbDiapet.setSelected(false);
        cbHotincream.setSelected(false);
        cbMylanta.setSelected(false);
        cbPromag.setSelected(false);
        cbSanmol.setSelected(false);
        cbTolakangin.setSelected(false);
    }//GEN-LAST:event_btnHapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apotik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCEK;
    private javax.swing.JButton btnHapus;
    private javax.swing.JCheckBox cbAntimo;
    private javax.swing.JCheckBox cbBetadine;
    private javax.swing.JCheckBox cbBodrex;
    private javax.swing.JCheckBox cbCombi;
    private javax.swing.JCheckBox cbDiapet;
    private javax.swing.JCheckBox cbHotincream;
    private javax.swing.JCheckBox cbMylanta;
    private javax.swing.JCheckBox cbPromag;
    private javax.swing.JCheckBox cbSanmol;
    private javax.swing.JCheckBox cbTolakangin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pAtas;
    private javax.swing.JPanel pBawah;
    private javax.swing.JPanel pTengah;
    // End of variables declaration//GEN-END:variables
}