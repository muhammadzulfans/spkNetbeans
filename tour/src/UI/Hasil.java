/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bass26
 */
public class Hasil extends javax.swing.JPanel {


    /**
     * Creates new form Normalisasi
     */
     private Connection con;
    public Hasil() {
        initComponents();
        con = koneksi.getConnection();
        getDataAlternative();
    }
    
    private void getDataAlternative(){
        DefaultTableModel model = (DefaultTableModel) tbl_alternative.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM Alternative";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                String Nama_Supplier  = rs.getString("Nama_Supplier");
                String C1 = rs.getString("C1");
                String C2 = rs.getString("C2");
                String C3 = rs.getString("C3");
                String C4 = rs.getString("C4");
                String C5 = rs.getString("C5");          
                Object[] rowData = {Nama_Supplier,C1,C2,C3,C4,C5};
                model.addRow(rowData);
                
            }
            rs.close();
            st.close();
            
        } catch (Exception e) {
            Logger.getLogger(Alternatif.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    private void hitungNilaiAkhir() {
    DefaultTableModel modelNormalisasi = (DefaultTableModel) tbl_normalisasi.getModel();
    DefaultTableModel modelNilaiAkhir = (DefaultTableModel) tbl_nilaiv.getModel();
    
    // Bersihkan tabel nilai akhir sebelum mengisi data baru
    modelNilaiAkhir.setRowCount(0);
    
    // Bobot untuk setiap kriteria
    double[] bobot = {0.25, 0.15, 0.30, 0.25, 0.05};
//    double[] bobot = {0.2, 0.1, 0.2, 0.2, 0.3}; // Sesuaikan dengan kebutuhan
    
    try {
        int rowCount = modelNormalisasi.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String Nama_Supplier = (String) modelNormalisasi.getValueAt(i, 0);
            double normC1 = (double) modelNormalisasi.getValueAt(i, 1);
            double normC2 = (double) modelNormalisasi.getValueAt(i, 2);
            double normC3 = (double) modelNormalisasi.getValueAt(i, 3);
            double normC4 = (double) modelNormalisasi.getValueAt(i, 4);
            double normC5 = (double) modelNormalisasi.getValueAt(i, 5);
            
            // Hitung nilai akhir dengan metode SAW
            double nilaiAkhir = (normC1 * bobot[0]) + (normC2 * bobot[1]) + (normC3 * bobot[2]) + (normC4 * bobot[3]) + (normC5 * bobot[4]);
            
            // Tambahkan baris baru ke tabel nilai akhir
            Object[] rowData = {i + 1, Nama_Supplier, nilaiAkhir};
            modelNilaiAkhir.addRow(rowData);
            
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: Invalid number format.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


   private void normalisasiData() { 
    DefaultTableModel modelNormalisasi = (DefaultTableModel) tbl_normalisasi.getModel();
    DefaultTableModel modelAlternative = (DefaultTableModel) tbl_alternative.getModel();
    
    // Bersihkan tabel normalisasi sebelum mengisi data baru
    modelNormalisasi.setRowCount(0);
    
    try {
        int rowCount = modelAlternative.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String Nama_Supplier = (String) modelAlternative.getValueAt(i, 0);
            double C1 = Double.parseDouble((String) modelAlternative.getValueAt(i, 1));
            double C2 = Double.parseDouble((String) modelAlternative.getValueAt(i, 2));
            double C3 = Double.parseDouble((String) modelAlternative.getValueAt(i, 3));
            double C4 = Double.parseDouble((String) modelAlternative.getValueAt(i, 4));
            double C5 = Double.parseDouble((String) modelAlternative.getValueAt(i, 5));
            
            // Misalnya, lakukan normalisasi untuk setiap nilai
            double maxC1 = getMaxValue("C1");
            double maxC2 = getMaxValue("C2");
            double maxC3 = getMaxValue("C3");
            double minC4 = getMinValue("C4");
            double minC5 = getMinValue("C5");
            
            double normC1 = C1 / maxC1;
            double normC2 = C2 / maxC2;
            double normC3 = C3 / maxC3;
            double normC4 = C4 / minC4;
            double normC5 = C5 / minC5;
            
            // Tambahkan baris baru ke tabel normalisasi
            Object[] rowData = {Nama_Supplier, normC1, normC2, normC3, normC4, normC5};
            modelNormalisasi.addRow(rowData);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: Invalid number format.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private double getMaxValue(String columnName) {
    double maxValue = Double.MIN_VALUE;
    int rowCount = tbl_alternative.getRowCount();
    
    for (int i = 0; i < rowCount; i++) {
        double value = Double.parseDouble((String) tbl_alternative.getValueAt(i, getColumnIndex(columnName)));
        if (value > maxValue) {
            maxValue = value;
        }
    }
    
    return maxValue;
}
private double getMinValue(String columnName) {
    double minValue = Double.MAX_VALUE; // Set nilai awal sangat besar
    
    // Ambil jumlah baris dari tabel alternatif
    int rowCount = tbl_alternative.getRowCount();
    
    // Iterasi untuk mencari nilai minimum dari kolom yang diberikan
    for (int i = 0; i < rowCount; i++) {
        double value = Double.parseDouble((String) tbl_alternative.getValueAt(i, getColumnIndex(columnName)));
        if (value < minValue) {
            minValue = value; // Update nilai minimum jika nilai saat ini lebih kecil
        }
    }
    
    return minValue; // Kembalikan nilai minimum yang ditemukan
}


private int getColumnIndex(String columnName) {
    for (int i = 0; i < tbl_alternative.getColumnCount(); i++) {
        if (tbl_alternative.getColumnName(i).equals(columnName)) {
            return i;
        }
    }
    return -1;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_normalisasi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_alternative = new javax.swing.JTable();
        btn_normalisasi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_nilaiv = new javax.swing.JTable();
        btn_peringkat = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Tabel Alternative");

        tbl_normalisasi.setBackground(new java.awt.Color(249, 226, 175));
        tbl_normalisasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "C1", "C2", "C3", "C4", "C5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_normalisasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_normalisasiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_normalisasi);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Tabel Normalisasi");

        tbl_alternative.setBackground(new java.awt.Color(249, 226, 175));
        tbl_alternative.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "C1", "C2", "C3", "C4", "C5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_alternative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_alternativeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_alternative);

        btn_normalisasi.setText("Normalisasi");
        btn_normalisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_normalisasiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("Tabel Peringkat");

        tbl_nilaiv.setBackground(new java.awt.Color(249, 226, 175));
        tbl_nilaiv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama", "Nilai Akhir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_nilaiv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nilaivMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_nilaiv);

        btn_peringkat.setText("Tentukan");
        btn_peringkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_peringkatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_normalisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_peringkat, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(btn_peringkat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btn_normalisasi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_normalisasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_normalisasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_normalisasiMouseClicked

    private void tbl_alternativeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_alternativeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_alternativeMouseClicked

    private void btn_normalisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_normalisasiActionPerformed
        normalisasiData();
    }//GEN-LAST:event_btn_normalisasiActionPerformed

    private void tbl_nilaivMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nilaivMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_nilaivMouseClicked

    private void btn_peringkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_peringkatActionPerformed
            hitungNilaiAkhir();
    }//GEN-LAST:event_btn_peringkatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_normalisasi;
    private javax.swing.JButton btn_peringkat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_alternative;
    private javax.swing.JTable tbl_nilaiv;
    private javax.swing.JTable tbl_normalisasi;
    // End of variables declaration//GEN-END:variables
}
