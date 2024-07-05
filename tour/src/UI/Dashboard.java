package UI;

public class Dashboard extends javax.swing.JFrame {
    
    Alternatif A = new Alternatif();
    Hasil N = new Hasil();
    Kriterias C = new Kriterias();
    
    public Dashboard() {
        initComponents();
        contents.add(A);
        contents.add(N);
        contents.add(C);
        A.setVisible(false);
        C.setVisible(false);
        N.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Btn_Alternative = new javax.swing.JButton();
        Btn_Hitung = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_kriteria = new javax.swing.JButton();
        contents = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(198, 66, 0));

        Btn_Alternative.setBackground(new java.awt.Color(204, 102, 0));
        Btn_Alternative.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Btn_Alternative.setForeground(new java.awt.Color(246, 245, 245));
        Btn_Alternative.setText("Alternatif");
        Btn_Alternative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AlternativeActionPerformed(evt);
            }
        });

        Btn_Hitung.setBackground(new java.awt.Color(204, 102, 0));
        Btn_Hitung.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Btn_Hitung.setForeground(new java.awt.Color(246, 245, 245));
        Btn_Hitung.setText("Perhitungan Normalisasi");
        Btn_Hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HitungActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tour & Travel");

        btn_kriteria.setBackground(new java.awt.Color(204, 102, 0));
        btn_kriteria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btn_kriteria.setForeground(new java.awt.Color(246, 245, 245));
        btn_kriteria.setText("Kriteria");
        btn_kriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kriteriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_Hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Alternative, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_kriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(Btn_Alternative, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btn_kriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Btn_Hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        contents.setBackground(new java.awt.Color(249, 226, 175));
        contents.setLayout(new javax.swing.OverlayLayout(contents));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contents, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contents)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_AlternativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AlternativeActionPerformed
        A.setVisible(true);
        N.setVisible(false);
        C.setVisible(false);
        
    }//GEN-LAST:event_Btn_AlternativeActionPerformed

    private void Btn_HitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HitungActionPerformed
        N.setVisible(true);
        A.setVisible(false);
        C.setVisible(false);
    }//GEN-LAST:event_Btn_HitungActionPerformed

    private void btn_kriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kriteriaActionPerformed
        N.setVisible(false);
        A.setVisible(false);
        C.setVisible(true);
    }//GEN-LAST:event_btn_kriteriaActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Alternative;
    private javax.swing.JButton Btn_Hitung;
    private javax.swing.JButton btn_kriteria;
    private javax.swing.JLayeredPane contents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
