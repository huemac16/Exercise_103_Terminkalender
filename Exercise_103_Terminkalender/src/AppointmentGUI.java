
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppointmentGUI extends javax.swing.JFrame {

    private AppointmentModell bl = new AppointmentModell();
    private File f = new File("./save.ser");
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - hh:mm");

    public static DateTimeFormatter getDtf() {
        return dtf;
    }

    public AppointmentGUI() throws Exception {
        initComponents();
        list.setModel(bl);

        if (!(f.exists())) {
            f.createNewFile();
        }

        bl.load(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jAdd = new javax.swing.JMenuItem();
        jDelete = new javax.swing.JMenuItem();
        jChange = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();

        jMenu1.setText("Termin");

        jAdd.setText("hinzufügen");
        jAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddActionPerformed(evt);
            }
        });
        jMenu1.add(jAdd);

        jDelete.setText("löschen");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });
        jMenu1.add(jDelete);

        jChange.setText("ändern");
        jChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeActionPerformed(evt);
            }
        });
        jMenu1.add(jChange);

        jPopupMenu1.add(jMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        list.setBorder(javax.swing.BorderFactory.createTitledBorder("Termine"));
        list.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddActionPerformed
        AppointmentDlg dialog = new AppointmentDlg(this, true);
        dialog.setVisible(true);

        if (dialog.isStatus()) {
            bl.add(dialog.getA());

        }
    }//GEN-LAST:event_jAddActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        try {
            bl.delete(list.getSelectedIndex());
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jDeleteActionPerformed

    private void jChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeActionPerformed
        try {
            AppointmentDlg dialog = new AppointmentDlg(this, true);
            dialog.showCurrent((Appointment) bl.getElementAt(list.getSelectedIndex()));
            dialog.setVisible(true);

            if (dialog.isStatus()) {
                bl.change(dialog.getA(), list.getSelectedIndex());
            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_jChangeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            bl.save(f);
        } catch (Exception ex) {
            Logger.getLogger(AppointmentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AppointmentGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AppointmentGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAdd;
    private javax.swing.JMenuItem jChange;
    private javax.swing.JMenuItem jDelete;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    // End of variables declaration//GEN-END:variables
}
