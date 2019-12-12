/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import domen.Korisnik;
import domen.Racun;
import gui.view.components.TableModelUgovor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import kontroler.Kontroler;

/**
 *
 * @author Nemanja
 */
public class FrmRaskiniUgovor extends javax.swing.JDialog {

    /**
     * Creates new form FrmRaskiniUgovor
     */
    Korisnik korisnik;

    public FrmRaskiniUgovor(java.awt.Frame parent, boolean modal, Korisnik korisnik) throws Exception {
        super(parent, modal);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.korisnik = korisnik;
        prepareView();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRaskini = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ugovori za korisnika "));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnRaskini.setText("Raskini ugovor");
        btnRaskini.setEnabled(false);
        btnRaskini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaskiniActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRaskini)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnNazad)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnRaskini, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNazad)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnRaskini.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnRaskiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaskiniActionPerformed
        try {
            TableModelUgovor tmu = (TableModelUgovor) jTable1.getModel();
            List<Racun> lista = Kontroler.getKontroler().dajSveNeplaceneZaKorisnika(korisnik.getKorisnikId(), tmu.dajUgovor(jTable1.getSelectedRow()).getUgovorId());
            if (tmu.dajUgovor(jTable1.getSelectedRow()).getDatumDo().before(new Date()) || tmu.dajUgovor(jTable1.getSelectedRow()).getDatumDo().equals(new Date())) {
                JOptionPane.showMessageDialog(this, "Ovaj ugovor je vec raskinut!", "Don't beat a dead horse!", JOptionPane.ERROR_MESSAGE);
                return;

            }
            if (lista.size() > 0) {
                int dialogResult = JOptionPane.showConfirmDialog(this, "Korisnik ima neplacene racune vezane za ovaj ugovor. Da li zelite da ih uplatite sada?", "Neplaceni racuni!", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(this, "Ne mozete raskinuti ugovor ukoliko korisnik nije platio sve racune!", "Greska!", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {

                    this.dispose();

                    FrmUplataRacuna frm = new FrmUplataRacuna(lista);
                    frm.setVisible(true);
                    return;
                }

            }

            int dialogResult1 = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da raskinete ovaj ugovor?", "Raskid ugovora", JOptionPane.YES_NO_OPTION);
            if (dialogResult1 == JOptionPane.YES_OPTION) {
                Kontroler.getKontroler().raskini(tmu.dajUgovor(jTable1.getSelectedRow()));
                JOptionPane.showMessageDialog(this, "Sistem je raskinuo ugovor!", "Uspeh!", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

            }
        } catch (Exception ex) {
            Logger.getLogger(FrmRaskiniUgovor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "", "Greska pri unosu!", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnRaskiniActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRaskiniUgovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRaskiniUgovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRaskiniUgovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRaskiniUgovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRaskiniUgovor dialog = null;
                try {
                    dialog = new FrmRaskiniUgovor(new javax.swing.JFrame(), true, new Korisnik());
                } catch (Exception ex) {
                    Logger.getLogger(FrmNovUgovor.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnRaskini;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void prepareView() throws Exception {
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Ugovori za korisnika " + korisnik.getIme() + " " + korisnik.getPrezime());
        jPanel1.setBorder(titledBorder);
        jTable1.setModel(new TableModelUgovor(Kontroler.getKontroler().dajSveZaJednogKorisnika(korisnik.getKorisnikId())));

    }
}
