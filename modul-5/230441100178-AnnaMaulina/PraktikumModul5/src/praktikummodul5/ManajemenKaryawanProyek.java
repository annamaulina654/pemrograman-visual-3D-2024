/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package praktikummodul5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author annam
 */
public class ManajemenKaryawanProyek extends javax.swing.JFrame {

    Connection conn;
    private DefaultTableModel modelTabel;
    private DefaultTableModel modelTabelProyek;
    private DefaultTableModel modelTabelTransaksi;
    private int oldIdKaryawan;
    private int oldIdProyek;
    /**
     * Creates new form ManajemenKaryawanProyek
     */
    public ManajemenKaryawanProyek() {
        initComponents();
        conn = KoneksiDatabase.getConnection();
        modelTabel = new DefaultTableModel();
        modelTabelProyek = new DefaultTableModel();
        modelTabelTransaksi = new DefaultTableModel();
        
        tabelKaryawan.setModel(modelTabel);
        tabelProyek.setModel(modelTabelProyek);
        tabelTransaksi.setModel(modelTabelTransaksi);
        
        modelTabel.addColumn("ID");
        modelTabel.addColumn("Nama");
        modelTabel.addColumn("Jabatan");
        modelTabel.addColumn("Departemen");
        
        modelTabelProyek.addColumn("ID");
        modelTabelProyek.addColumn("Nama Proyek");
        modelTabelProyek.addColumn("Durasi Pengerjaan");
        
        modelTabelTransaksi.addColumn("ID Karyawan");
        modelTabelTransaksi.addColumn("ID Proyek");
        modelTabelTransaksi.addColumn("Peran");
        
        btnUpdateKaryawan.setEnabled(false);
        btnDeleteKaryawan.setEnabled(false);
        btnUpdateProyek.setEnabled(false);
        btnDeleteProyek.setEnabled(false);
        btnUpdateTransaksi.setEnabled(false);
        btnDeleteTransaksi.setEnabled(false);
        
        tfId.setEditable(false);
        tfIdProyek.setEditable(false);
        
        loadData();
    }
    
    private void loadData() {
        modelTabel.setRowCount(0);

        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
               // Menambahkan baris ke dalam model tabel
                modelTabel.addRow(new Object[]{
                    hasil.getString("id"),
                    hasil.getString("nama"),
                    hasil.getString("jabatan"),
                    hasil.getString("departemen")
                });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
        
        modelTabelProyek.setRowCount(0);

        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
               // Menambahkan baris ke dalam model tabel
                modelTabelProyek.addRow(new Object[]{
                    hasil.getString("id"),
                    hasil.getString("nama_proyek"),
                    hasil.getString("durasi_pengerjaan"),
                });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
        
        comboKaryawan.removeAllItems();
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                String id = hasil.getString("id");
                String nama = hasil.getString("nama");
                String jabatan = hasil.getString("jabatan");
                String departemen = hasil.getString("departemen");
                String gabung = id + " , " + nama + " , " + jabatan + " , " 
                        + departemen;
                comboKaryawan.addItem(gabung);
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
        
        comboProyek.removeAllItems();
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                String id = hasil.getString("id");
                String namaProyek = hasil.getString("nama_proyek");
                String durasi = hasil.getString("durasi_pengerjaan");
                String gabung = id + " , " + namaProyek + " , " + durasi;
                comboProyek.addItem(gabung);
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
        
        modelTabelTransaksi.setRowCount(0);

        try {
            String sql = "SELECT * FROM transaksi_proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
               // Menambahkan baris ke dalam model tabel
                modelTabelTransaksi.addRow(new Object[]{
                    hasil.getString("id_karyawan"),
                    hasil.getString("id_proyek"),
                    hasil.getString("peran"),
                });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
    }

    private void saveData() {
        if (tfNama.getText().trim().isEmpty() || 
                tfJabatan.getText().trim().isEmpty() || 
                tfDepartemen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            String sql = "INSERT INTO karyawan (nama, jabatan, departemen) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNama.getText());
            ps.setString(2, tfJabatan.getText());
            ps.setString(3, tfDepartemen.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadData();
            reset();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error saving data. Please try "
                    + "again.", "Database Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    private void saveDataProyek() {
        if (tfNamaProyek.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Project name must be filled "
                    + "out", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int durasi;
        try {
            durasi = Integer.parseInt(tfDurasi.getText().trim());
            if (durasi <= 0) {
                JOptionPane.showMessageDialog(this, "Duration must be a positive"
                        + " number", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Duration must be a valid "
                    + "integer", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) "
                    + "VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNamaProyek.getText().trim());
            ps.setInt(2, durasi);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");

            loadData();  
            resetProyek(); 
        } catch (SQLException e) {
            System.out.println("Error Saving Data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error saving data. Please try"
                    + " again.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

        
    private void saveTransaksiData() {
        if (comboKaryawan.getSelectedItem() == null || 
                comboProyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select both Karyawan "
                    + "and Proyek", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tfPeran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Role must be filled out", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO transaksi_proyek (id_karyawan, id_proyek, "
                    + "peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            String selectedKaryawan = (String) comboKaryawan.getSelectedItem();
            String selectedProyek = (String) comboProyek.getSelectedItem();

            int idKaryawan = Integer.parseInt(selectedKaryawan.split(", ")[0].trim());
            int idProyek = Integer.parseInt(selectedProyek.split(", ")[0].trim());

            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, tfPeran.getText().trim());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadData();  
            resetTransaksi();  

        } catch (SQLException e) {
            System.out.println("Error Saving Data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error saving data. Please try "
                    + "again.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

        
    private void updateData() {
        int response = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to save changes?", 
            "Confirm Update", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            try {
                String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, "
                        + "departemen = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfNama.getText());
                ps.setString(2, tfJabatan.getText());
                ps.setString(3, tfDepartemen.getText());
                ps.setInt(4, Integer.parseInt(tfId.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data updated successfully");
                loadData();
                reset();
                btnSaveKaryawan.setEnabled(true);
                btnUpdateKaryawan.setEnabled(false);
                btnDeleteKaryawan.setEnabled(false);
            } catch (SQLException e) {
                System.out.println("Error updating data: " + e.getMessage());
            }
        }
    }

    private void updateDataProyek() {
        int response = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to save changes?", 
        "Confirm Update", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            try {
                String sql = "UPDATE proyek SET nama_proyek = ?, "
                        + "durasi_pengerjaan = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfNamaProyek.getText());
                ps.setString(2, tfDurasi.getText());
                ps.setInt(3, Integer.parseInt(tfIdProyek.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data updated successfully");
                loadData();
                resetProyek();
                btnSaveProyek.setEnabled(true);
                btnUpdateProyek.setEnabled(false);
                btnDeleteProyek.setEnabled(false);
            }  catch (SQLException e) {
                System.out.println("Error Save Data" + e.getMessage());
            }
        }
    }
        
    private void updateTransaksiData() {
        int response = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to save changes?", 
        "Confirm Update", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            try {
                String sql = "UPDATE transaksi_proyek SET id_karyawan = ?, "
                        + "id_proyek = ?, peran = ? WHERE id_karyawan = ? AND "
                        + "id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);

                String selectedKaryawan = (String) comboKaryawan.getSelectedItem();
                String selectedProyek = (String) comboProyek.getSelectedItem();

                int newIdKaryawan = Integer.parseInt(selectedKaryawan.split(", ")[0].trim());
                int newIdProyek = Integer.parseInt(selectedProyek.split(", ")[0].trim());

                // Mengisi parameter untuk update
                ps.setInt(1, newIdKaryawan); 
                ps.setInt(2, newIdProyek);   
                ps.setString(3, tfPeran.getText()); 

                // Kondisi WHERE menggunakan ID lama
                ps.setInt(4, oldIdKaryawan); 
                ps.setInt(5, oldIdProyek);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data updated successfully");
                loadData(); 
                resetTransaksi();
                    btnSaveTransaksi.setEnabled(true);
                    btnUpdateTransaksi.setEnabled(false);
                    btnDeleteTransaksi.setEnabled(false);

            } catch (SQLException e) {
                System.out.println("Error Update Data: " + e.getMessage());
            }
        }
    }

    private void deleteData() {
        int response = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete this data?", 
        "Confirm Deletion", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.WARNING_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM karyawan WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(tfId.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data deleted successfully");
                loadData();
                reset();
                btnSaveKaryawan.setEnabled(true);
                btnUpdateKaryawan.setEnabled(false);
                btnDeleteKaryawan.setEnabled(false);
            } catch (SQLException e) {
                System.out.println("Error Save Data" + e.getMessage());
            }
        }
    }
        
    private void deleteDataProyek() {
        int response = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete this data?", 
        "Confirm Deletion", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.WARNING_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM proyek WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(tfIdProyek.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data deleted successfully");
                loadData();
                resetProyek();
                    btnSaveProyek.setEnabled(true);
                btnUpdateProyek.setEnabled(false);
                btnDeleteProyek.setEnabled(false);
            } catch (SQLException e) {
                System.out.println("Error Save Data" + e.getMessage());
            }
        }
    }
    
    private void deleteTransaksiData() {
        int response = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete this data?", 
        "Confirm Deletion", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.WARNING_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM transaksi_proyek WHERE id_karyawan = ? "
                        + "AND id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);

                String selectedKaryawan = (String) comboKaryawan.getSelectedItem();
                String selectedProyek = (String) comboProyek.getSelectedItem();

                int idKaryawan = Integer.parseInt(selectedKaryawan.split(", ")[0].trim());
                int idProyek = Integer.parseInt(selectedProyek.split(", ")[0].trim());

                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);

                int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data deleted successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Data not found or failed "
                            + "to delete");
                }

                loadData(); 
                resetTransaksi();
                btnSaveTransaksi.setEnabled(true);
                btnUpdateTransaksi.setEnabled(false);
                btnDeleteTransaksi.setEnabled(false);

            } catch (SQLException e) {
                System.out.println("Error Delete Data: " + e.getMessage());
            }
        }
    }
        
    private void reset() {
        tfId.setText("");
        tfNama.setText("");
        tfJabatan.setText("");
        tfDepartemen.setText("");
    }

    private void resetProyek() {
        tfIdProyek.setText("");
        tfNamaProyek.setText("");
        tfDurasi.setText("");
    }
    
    private void resetTransaksi() {
        tfPeran.setText("");
        comboKaryawan.setSelectedIndex(0);
        comboProyek.setSelectedIndex(0);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKaryawan = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnSaveKaryawan = new javax.swing.JButton();
        btnUpdateKaryawan = new javax.swing.JButton();
        btnDeleteKaryawan = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfDepartemen = new javax.swing.JTextField();
        tfJabatan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelProyek = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        btnSaveProyek = new javax.swing.JButton();
        btnUpdateProyek = new javax.swing.JButton();
        btnDeleteProyek = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDurasi = new javax.swing.JTextField();
        tfNamaProyek = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfIdProyek = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btnSaveTransaksi = new javax.swing.JButton();
        btnUpdateTransaksi = new javax.swing.JButton();
        btnDeleteTransaksi = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboProyek = new javax.swing.JComboBox<>();
        comboKaryawan = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        tfPeran = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(150, 126, 118));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(215, 192, 174));

        jTabbedPane1.setBackground(new java.awt.Color(238, 227, 203));

        jPanel5.setBackground(new java.awt.Color(238, 227, 203));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(238, 227, 203));

        tabelKaryawan.setBackground(new java.awt.Color(183, 196, 207));
        tabelKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKaryawan);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel5.add(jPanel8, java.awt.BorderLayout.LINE_END);

        jPanel9.setBackground(new java.awt.Color(238, 227, 203));

        jPanel12.setBackground(new java.awt.Color(183, 196, 207));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSaveKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Save.gif"))); // NOI18N
        btnSaveKaryawan.setText("Save");
        btnSaveKaryawan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveKaryawan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveKaryawanActionPerformed(evt);
            }
        });
        jPanel12.add(btnSaveKaryawan);

        btnUpdateKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Modify.gif"))); // NOI18N
        btnUpdateKaryawan.setText("Update");
        btnUpdateKaryawan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdateKaryawan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdateKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKaryawanActionPerformed(evt);
            }
        });
        jPanel12.add(btnUpdateKaryawan);

        btnDeleteKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Delete.gif"))); // NOI18N
        btnDeleteKaryawan.setText("Delete");
        btnDeleteKaryawan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteKaryawan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKaryawanActionPerformed(evt);
            }
        });
        jPanel12.add(btnDeleteKaryawan);

        jPanel20.setBackground(new java.awt.Color(183, 196, 207));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        java.awt.GridBagLayout jPanel20Layout = new java.awt.GridBagLayout();
        jPanel20Layout.columnWidths = new int[] {0, 19, 0, 19, 0, 19, 0};
        jPanel20Layout.rowHeights = new int[] {0, 13, 0, 13, 0, 13, 0, 13, 0, 13, 0};
        jPanel20.setLayout(jPanel20Layout);

        jLabel11.setText("Jabatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel20.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Departemen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel20.add(jLabel12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel20.add(tfDepartemen, gridBagConstraints);

        tfJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJabatanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel20.add(tfJabatan, gridBagConstraints);

        jLabel13.setText("Nama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel20.add(jLabel13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel20.add(tfNama, gridBagConstraints);

        jLabel5.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel20.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel20.add(tfId, gridBagConstraints);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/karyawan.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(42, 42, 42))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Karyawan", jPanel5);

        jPanel6.setBackground(new java.awt.Color(238, 227, 203));

        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(238, 227, 203));

        tabelProyek.setBackground(new java.awt.Color(183, 196, 207));
        tabelProyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabelProyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelProyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelProyek);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel14, java.awt.BorderLayout.LINE_START);

        jPanel15.setBackground(new java.awt.Color(238, 227, 203));

        jPanel17.setBackground(new java.awt.Color(183, 196, 207));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSaveProyek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Save.gif"))); // NOI18N
        btnSaveProyek.setText("Save");
        btnSaveProyek.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveProyek.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProyekActionPerformed(evt);
            }
        });
        jPanel17.add(btnSaveProyek);

        btnUpdateProyek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Modify.gif"))); // NOI18N
        btnUpdateProyek.setText("Update");
        btnUpdateProyek.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdateProyek.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdateProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProyekActionPerformed(evt);
            }
        });
        jPanel17.add(btnUpdateProyek);

        btnDeleteProyek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Delete.gif"))); // NOI18N
        btnDeleteProyek.setText("Delete");
        btnDeleteProyek.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteProyek.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProyekActionPerformed(evt);
            }
        });
        jPanel17.add(btnDeleteProyek);

        jPanel16.setBackground(new java.awt.Color(183, 196, 207));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        java.awt.GridBagLayout jPanel16Layout = new java.awt.GridBagLayout();
        jPanel16Layout.columnWidths = new int[] {0, 19, 0, 19, 0, 19, 0};
        jPanel16Layout.rowHeights = new int[] {0, 13, 0, 13, 0, 13, 0, 13, 0};
        jPanel16.setLayout(jPanel16Layout);

        jLabel2.setText("Nama Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel16.add(jLabel2, gridBagConstraints);

        jLabel4.setText("Durasi Pengerjaan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel16.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel16.add(tfDurasi, gridBagConstraints);

        tfNamaProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaProyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel16.add(tfNamaProyek, gridBagConstraints);

        jLabel6.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel16.add(jLabel6, gridBagConstraints);

        tfIdProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdProyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel16.add(tfIdProyek, gridBagConstraints);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/proyek.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel14)))
        );

        jPanel13.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Proyek", jPanel6);

        jPanel7.setBackground(new java.awt.Color(238, 227, 203));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(238, 227, 203));

        jPanel19.setBackground(new java.awt.Color(183, 196, 207));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSaveTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Save.gif"))); // NOI18N
        btnSaveTransaksi.setText("Save");
        btnSaveTransaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveTransaksi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTransaksiActionPerformed(evt);
            }
        });
        jPanel19.add(btnSaveTransaksi);

        btnUpdateTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Modify.gif"))); // NOI18N
        btnUpdateTransaksi.setText("Update");
        btnUpdateTransaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdateTransaksi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdateTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTransaksiActionPerformed(evt);
            }
        });
        jPanel19.add(btnUpdateTransaksi);

        btnDeleteTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Delete.gif"))); // NOI18N
        btnDeleteTransaksi.setText("Delete");
        btnDeleteTransaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteTransaksi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTransaksiActionPerformed(evt);
            }
        });
        jPanel19.add(btnDeleteTransaksi);

        jPanel21.setBackground(new java.awt.Color(183, 196, 207));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        java.awt.GridBagLayout jPanel21Layout = new java.awt.GridBagLayout();
        jPanel21Layout.columnWidths = new int[] {0, 19, 0, 19, 0, 19, 0, 19, 0, 19, 0};
        jPanel21Layout.rowHeights = new int[] {0, 13, 0, 13, 0, 13, 0, 13, 0};
        jPanel21.setLayout(jPanel21Layout);

        jLabel7.setText("Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(jLabel7, gridBagConstraints);

        jLabel9.setText("Karyawan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(comboProyek, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(comboKaryawan, gridBagConstraints);

        jLabel15.setText("Peran");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(jLabel15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel21.add(tfPeran, gridBagConstraints);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/transaksi.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(34, 34, 34))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel18, java.awt.BorderLayout.PAGE_START);

        jPanel22.setBackground(new java.awt.Color(238, 227, 203));

        tabelTransaksi.setBackground(new java.awt.Color(183, 196, 207));
        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelTransaksi);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel7.add(jPanel22, java.awt.BorderLayout.LINE_START);

        jTabbedPane1.addTab("Transaksi Proyek", jPanel7);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/Exit.gif"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(55, 55, 55))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(150, 126, 118));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/praktikummodul5/brand.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel3.setText("== Aplikasi Manajemen Karyawan dan Proyek ==");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNamaProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaProyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaProyekActionPerformed

    private void tfJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJabatanActionPerformed

    private void btnSaveKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveKaryawanActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btnSaveKaryawanActionPerformed

    private void tabelKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKaryawanMouseClicked
        // TODO add your handling code here:
        btnSaveKaryawan.setEnabled(false);
        btnUpdateKaryawan.setEnabled(true);
        btnDeleteKaryawan.setEnabled(true);
        int i = tabelKaryawan.getSelectedRow();
        
        if(i > -1) {
            tfId.setText(modelTabel.getValueAt(i, 0).toString());
            tfNama.setText(modelTabel.getValueAt(i, 1).toString());
            tfJabatan.setText(modelTabel.getValueAt(i, 2).toString());
            tfDepartemen.setText(modelTabel.getValueAt(i, 3).toString());
        }
    }//GEN-LAST:event_tabelKaryawanMouseClicked

    private void btnDeleteKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKaryawanActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_btnDeleteKaryawanActionPerformed

    private void btnUpdateKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKaryawanActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_btnUpdateKaryawanActionPerformed

    private void tfIdProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdProyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdProyekActionPerformed

    private void btnSaveProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProyekActionPerformed
        // TODO add your handling code here:
        saveDataProyek();
    }//GEN-LAST:event_btnSaveProyekActionPerformed

    private void btnUpdateProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProyekActionPerformed
        // TODO add your handling code here:
        updateDataProyek();
    }//GEN-LAST:event_btnUpdateProyekActionPerformed

    private void btnDeleteProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProyekActionPerformed
        // TODO add your handling code here:
        deleteDataProyek();
    }//GEN-LAST:event_btnDeleteProyekActionPerformed

    private void tabelProyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelProyekMouseClicked
        // TODO add your handling code here:
        btnSaveProyek.setEnabled(false);
        btnUpdateProyek.setEnabled(true);
        btnDeleteProyek.setEnabled(true);
        int i = tabelProyek.getSelectedRow();
        
        if(i > -1) {
            tfIdProyek.setText(modelTabelProyek.getValueAt(i, 0).toString());
            tfNamaProyek.setText(modelTabelProyek.getValueAt(i, 1).toString());
            tfDurasi.setText(modelTabelProyek.getValueAt(i, 2).toString());
        }
    }//GEN-LAST:event_tabelProyekMouseClicked

    private void btnSaveTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTransaksiActionPerformed
        // TODO add your handling code here:
        saveTransaksiData();
    }//GEN-LAST:event_btnSaveTransaksiActionPerformed

    private void btnUpdateTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTransaksiActionPerformed
        // TODO add your handling code here:
        updateTransaksiData();
    }//GEN-LAST:event_btnUpdateTransaksiActionPerformed

    private void btnDeleteTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTransaksiActionPerformed
        // TODO add your handling code here:
        deleteTransaksiData();
    }//GEN-LAST:event_btnDeleteTransaksiActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
        btnSaveTransaksi.setEnabled(false);
        btnUpdateTransaksi.setEnabled(true);
        btnDeleteTransaksi.setEnabled(true);
        int i = tabelTransaksi.getSelectedRow();

        if (i > -1) {
            // Mengambil nilai dari tabel dan menyimpan ID lama
            oldIdKaryawan = Integer.parseInt(modelTabelTransaksi.getValueAt(i, 0).toString());
            oldIdProyek = Integer.parseInt(modelTabelTransaksi.getValueAt(i, 1).toString());
            String peran = modelTabelTransaksi.getValueAt(i, 2).toString();

            // Set ComboBox berdasarkan ID dari tabel
            for (int j = 0; j < comboKaryawan.getItemCount(); j++) {
                String item = (String) comboKaryawan.getItemAt(j);
                if (item.startsWith(oldIdKaryawan + " , ")) {
                    comboKaryawan.setSelectedItem(item);
                    break;
                }
            }

            for (int j = 0; j < comboProyek.getItemCount(); j++) {
                String item = (String) comboProyek.getItemAt(j);
                if (item.startsWith(oldIdProyek + " , ")) {
                    comboProyek.setSelectedItem(item);
                    break;
                }
            }

            tfPeran.setText(peran); 
        }
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want "
                + "to exit?", 
            "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManajemenKaryawanProyek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteKaryawan;
    private javax.swing.JButton btnDeleteProyek;
    private javax.swing.JButton btnDeleteTransaksi;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSaveKaryawan;
    private javax.swing.JButton btnSaveProyek;
    private javax.swing.JButton btnSaveTransaksi;
    private javax.swing.JButton btnUpdateKaryawan;
    private javax.swing.JButton btnUpdateProyek;
    private javax.swing.JButton btnUpdateTransaksi;
    private javax.swing.JComboBox<String> comboKaryawan;
    private javax.swing.JComboBox<String> comboProyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelKaryawan;
    private javax.swing.JTable tabelProyek;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField tfDepartemen;
    private javax.swing.JTextField tfDurasi;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdProyek;
    private javax.swing.JTextField tfJabatan;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNamaProyek;
    private javax.swing.JTextField tfPeran;
    // End of variables declaration//GEN-END:variables
}
