/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.newpemvis3;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Spp extends javax.swing.JFrame {
    DefaultTableModel model;
    final int nominalPerBulan = 20000;
    public Spp() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) jTable1.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pAtas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pInput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNISN = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        Kelas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbApril = new javax.swing.JCheckBox();
        cbJanuari = new javax.swing.JCheckBox();
        cbFebruari = new javax.swing.JCheckBox();
        cbMaret = new javax.swing.JCheckBox();
        cbAgustus = new javax.swing.JCheckBox();
        cbMei = new javax.swing.JCheckBox();
        cbJuni = new javax.swing.JCheckBox();
        cbJuli = new javax.swing.JCheckBox();
        cbDesember = new javax.swing.JCheckBox();
        cbSeptember = new javax.swing.JCheckBox();
        cbOktober = new javax.swing.JCheckBox();
        tfTotal = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbNovember = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnBayar = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pAtas.setBackground(new java.awt.Color(102, 153, 255));
        pAtas.setLayout(new java.awt.GridBagLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\safira rihadatul a\\OneDrive\\文件\\LogoSPP.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pAtas.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Selamat datang di pembayaran SPP digital SD NEGERI 22 BANGKALAN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        pAtas.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Elephant", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PEMBAYAYARAN SPP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pAtas.add(jLabel6, gridBagConstraints);

        jPanel1.add(pAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, -1));

        pInput.setBackground(new java.awt.Color(102, 153, 255));
        pInput.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("NISN :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 20);
        pInput.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 20);
        pInput.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Kelas :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 20);
        pInput.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(tfNISN, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(tfNama, gridBagConstraints);

        Kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas 1", "Kelas 2", "Kelas 3", "Kelas 4", "Kelas 5", "Kelas 6" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(Kelas, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Bulan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 20);
        pInput.add(jLabel7, gridBagConstraints);

        cbApril.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbApril.setText("April");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 10);
        pInput.add(cbApril, gridBagConstraints);

        cbJanuari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbJanuari.setText("Januari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 10);
        pInput.add(cbJanuari, gridBagConstraints);

        cbFebruari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbFebruari.setText("Februari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 10);
        pInput.add(cbFebruari, gridBagConstraints);

        cbMaret.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMaret.setText("Maret");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 10);
        pInput.add(cbMaret, gridBagConstraints);

        cbAgustus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbAgustus.setText("Agustus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbAgustus, gridBagConstraints);

        cbMei.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMei.setText("Mei");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbMei, gridBagConstraints);

        cbJuni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbJuni.setText("Juni");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbJuni, gridBagConstraints);

        cbJuli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbJuli.setText("Juli");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbJuli, gridBagConstraints);

        cbDesember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbDesember.setText("Desember");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbDesember, gridBagConstraints);

        cbSeptember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbSeptember.setText("September");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbSeptember, gridBagConstraints);

        cbOktober.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbOktober.setText("Oktober");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbOktober, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(tfTotal, gridBagConstraints);

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(btnHitung, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Total :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 20);
        pInput.add(jLabel9, gridBagConstraints);

        cbNovember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbNovember.setText("November");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        pInput.add(cbNovember, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" MASUKKAN DATA SISWA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        pInput.add(jLabel8, gridBagConstraints);

        jPanel1.add(pInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 560, 230));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NISN", "Nama", "Kelas", "Bulan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 560, -1));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBayar);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel4.add(btnHapus);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 550, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        int totalBulan = 0;
        StringBuilder bulanDibayar = new StringBuilder();

        if (cbJanuari.isSelected()) {
            totalBulan++;
            bulanDibayar.append("January, ");
        }
        if (cbFebruari.isSelected()) {
            totalBulan++;
            bulanDibayar.append("February, ");
        }
        if (cbMaret.isSelected()) {
            totalBulan++;
            bulanDibayar.append("March, ");
        }
        if (cbApril.isSelected()) {
            totalBulan++;
            bulanDibayar.append("April, ");
        }
        if (cbMei.isSelected()) {
            totalBulan++;
            bulanDibayar.append("May, ");
        }
        if (cbJuni.isSelected()) {
            totalBulan++;
            bulanDibayar.append("June, ");
        }
        if (cbJuli.isSelected()) {
            totalBulan++;
            bulanDibayar.append("July, ");
        }
        if (cbAgustus.isSelected()) {
            totalBulan++;
            bulanDibayar.append("August, ");
        }
        if (cbSeptember.isSelected()) {
            totalBulan++;
            bulanDibayar.append("September, ");
        }
        if (cbOktober.isSelected()) {
            totalBulan++;
            bulanDibayar.append("October, ");
        }
        if (cbNovember.isSelected()) {
            totalBulan++;
            bulanDibayar.append("November, ");
        }
        if (cbDesember.isSelected()) {
            totalBulan++;
            bulanDibayar.append("December, ");
        }

        // Hapus koma terakhir jika ada
        if (bulanDibayar.length() > 0) {
            bulanDibayar.setLength(bulanDibayar.length() - 2);
        }

        int total = nominalPerBulan * totalBulan;
        tfTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        String nama = tfNama.getText();
        String nisn = tfNISN.getText();
        String kelas = Kelas.getSelectedItem().toString();
        String total = tfTotal.getText();

        StringBuilder bulanDibayar = new StringBuilder();

        if (cbJanuari.isSelected()) bulanDibayar.append("January, ");
        if (cbFebruari.isSelected()) bulanDibayar.append("February, ");
        if (cbMaret.isSelected()) bulanDibayar.append("March, ");
        if (cbApril.isSelected()) bulanDibayar.append("April, ");
        if (cbMei.isSelected()) bulanDibayar.append("May, ");
        if (cbJuni.isSelected()) bulanDibayar.append("June, ");
        if (cbJuli.isSelected()) bulanDibayar.append("July, ");
        if (cbAgustus.isSelected()) bulanDibayar.append("August, ");
        if (cbSeptember.isSelected()) bulanDibayar.append("September, ");
        if (cbOktober.isSelected()) bulanDibayar.append("October, ");
        if (cbNovember.isSelected()) bulanDibayar.append("November, ");
        if (cbDesember.isSelected()) bulanDibayar.append("December, ");

        // Hapus koma terakhir
        if (bulanDibayar.length() > 0) {
            bulanDibayar.setLength(bulanDibayar.length() - 2);
        }

        if (!nisn.isEmpty() && !nama.isEmpty() && !total.isEmpty()) {
            // Tambahkan data ke tabel
            model.addRow(new Object[]{nisn, nama, kelas, bulanDibayar.toString(), total});

            // Tampilkan pesan sukses
            JOptionPane.showMessageDialog(this, "Pembayaran SUCCES!!!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Bersihkan input setelah pembayaran
            btnHapusActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this, "Harap lengkapi semua!!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        tfNISN.setText("");
        tfNama.setText("");
        tfTotal.setText("");
        Kelas.setSelectedIndex(0);
        cbJanuari.setSelected(false);
        cbFebruari.setSelected(false);
        cbMaret.setSelected(false);
        cbApril.setSelected(false);
        cbMei.setSelected(false);
        cbJuni.setSelected(false);
        cbJuli.setSelected(false);
        cbAgustus.setSelected(false);
        cbSeptember.setSelected(false);
        cbOktober.setSelected(false);
        cbNovember.setSelected(false);
        cbDesember.setSelected(false);
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(Spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Spp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Kelas;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JCheckBox cbAgustus;
    private javax.swing.JCheckBox cbApril;
    private javax.swing.JCheckBox cbDesember;
    private javax.swing.JCheckBox cbFebruari;
    private javax.swing.JCheckBox cbJanuari;
    private javax.swing.JCheckBox cbJuli;
    private javax.swing.JCheckBox cbJuni;
    private javax.swing.JCheckBox cbMaret;
    private javax.swing.JCheckBox cbMei;
    private javax.swing.JCheckBox cbNovember;
    private javax.swing.JCheckBox cbOktober;
    private javax.swing.JCheckBox cbSeptember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pAtas;
    private javax.swing.JPanel pInput;
    private javax.swing.JTextField tfNISN;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
