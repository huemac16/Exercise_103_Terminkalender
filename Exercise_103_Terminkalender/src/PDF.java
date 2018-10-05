
import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDF extends javax.swing.JDialog {

    private PDFDocument pdfDoc;
    private PDFPage page;
    private File outFile;

    private ArrayList<Appointment> appointments;

    public PDF(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        appointments = AppointmentModell.getAppointments();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        btPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btPDF.setText("PDF Erstellen");
        btPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPDF)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPDFActionPerformed
        outFile = fileChooser.getCurrentDirectory();
        File pdf = new File(outFile.getAbsolutePath() + "\\Termine.pdf");
        pdf.getParentFile().mkdirs();
        try {
            pdf.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        pdfDoc = new PDFDocument();
        page = pdfDoc.createPage(null);
        pdfDoc.addPage(page);
        Graphics2D g2d = page.createGraphics();

        g2d.setColor(Color.BLACK);
        int temp = 0;

        for (int i = 0; i < appointments.size(); i++) {
            g2d.drawString(appointments.get(i).getText(), 20, 20 + temp);
            g2d.drawString(appointments.get(i).getDate().format(AppointmentGUI.getDtf()), 20, 35 + temp);

            temp += 50;

        }

        try {
            pdfDoc.saveDocument(pdf.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        File file = new File(pdf.getAbsolutePath());
        if (file.toString().endsWith(".pdf")) {
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
            } catch (IOException ex) {
                Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
                dispose();
            } catch (IOException ex) {
                Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btPDFActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPDF;
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
}
