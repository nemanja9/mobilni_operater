/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import domen.Korisnik;
import domen.Paket;
import domen.Ugovor;
import domen.Usluga;
import domen.UslugaTip;
import domen.Zaposleni;
import gui.view.components.TableModelPaket;
import gui.view.components.TableModelUsluga;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;
import kontroler.Kontroler;
import validator.Validator;
import validator.impl.ValidatorPaket;

/**
 *
 * @author Nemanja
 */
public class FrmNovUgovor extends javax.swing.JDialog {

    public int id;
    String m;
    boolean napravljenNovUg = false;
    Korisnik trenutniKorisnik;
    Zaposleni trenutniZaposleni;

    public FrmNovUgovor(java.awt.Frame parent, boolean modal, int korisnik_id) throws Exception {
        super(parent, modal);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        System.out.println(FrmMain.ulogovan.getZaposleniId());
        id = korisnik_id;
        prepareView();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKorisnik = new javax.swing.JTextField();
        cmbTrajanje = new javax.swing.JComboBox();
        txtBr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtZaposleni = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPaketi = new javax.swing.JTable();
        panelUsluge = new javax.swing.JPanel();
        panelScroll = new javax.swing.JScrollPane();
        tabelaUsluge = new javax.swing.JTable();
        btnZapamtiUgovor = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        btnNovPaket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Korisnik:");

        jLabel2.setText("Trajanje:");

        jLabel3.setText("Broj telefona:");

        jLabel4.setText("Podnosi zaposleni: ");

        txtKorisnik.setEditable(false);

        cmbTrajanje.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtBr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBrFocusLost(evt);
            }
        });

        jLabel5.setText("Naziv ugovora: ");

        txtZaposleni.setEditable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Izaberite paket:"));

        tabelaPaketi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPaketi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaPaketiFocusGained(evt);
            }
        });
        tabelaPaketi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPaketiMouseClicked(evt);
            }
        });
        tabelaPaketi.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabelaPaketiPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPaketi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelUsluge.setBorder(javax.swing.BorderFactory.createTitledBorder("Usluge izabranog paketa:"));

        tabelaUsluge.setModel(new javax.swing.table.DefaultTableModel(
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
        panelScroll.setViewportView(tabelaUsluge);

        javax.swing.GroupLayout panelUslugeLayout = new javax.swing.GroupLayout(panelUsluge);
        panelUsluge.setLayout(panelUslugeLayout);
        panelUslugeLayout.setHorizontalGroup(
            panelUslugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUslugeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelUslugeLayout.setVerticalGroup(
            panelUslugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUslugeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnZapamtiUgovor.setText("Zapamti ugovor");
        btnZapamtiUgovor.setEnabled(false);
        btnZapamtiUgovor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapamtiUgovorActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnNovPaket.setText("Nov paket");
        btnNovPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovPaketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtBr))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKorisnik)
                            .addComponent(cmbTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtZaposleni)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnZapamtiUgovor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnNovPaket)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtZaposleni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtBr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovPaket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZapamtiUgovor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPaketiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaPaketiFocusGained
    }//GEN-LAST:event_tabelaPaketiFocusGained

    private void tabelaPaketiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPaketiMouseClicked
        btnZapamtiUgovor.setEnabled(true);
        try {
            List<Usluga> lista = Kontroler.getKontroler().dajJedanPaket((int) tabelaPaketi.getModel().getValueAt(tabelaPaketi.getSelectedRow(), 0)).getUsluge();
            System.out.println(Kontroler.getKontroler().dajJedanPaket((int) tabelaPaketi.getModel().getValueAt(tabelaPaketi.getSelectedRow(), 0)).getUsluge().get(0).toString());
            tabelaUsluge.setModel(new TableModelUsluga((ArrayList<Usluga>) lista));

        } catch (Exception ex) {  // ovde kada kreiramo nov paket on u bazi ne postoji pa posalje null table modelu i dobije izuzetak
            Usluga ug1 = new Usluga(123, UslugaTip.GB, 0, 0, 0, ""); // kada dobije izuzetak on prosledi praznu listu za nov paket jer tako treba da bude
            Usluga ug2 = new Usluga(123, UslugaTip.MIN, 0, 0, 0, "");
            Usluga ug3 = new Usluga(123, UslugaTip.SMS, 0, 0, 0, "");
            ArrayList<Usluga> lista = new ArrayList<>();
            lista.add(ug1);
            lista.add(ug2);
            lista.add(ug3);
            try {
                TableModelUsluga tmu = new TableModelUsluga(lista);
                tabelaUsluge.setModel(tmu);
            } catch (Exception ex1) {
                System.out.println("BACEN DUPLO");
            }
        }
    }//GEN-LAST:event_tabelaPaketiMouseClicked

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnNovPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovPaketActionPerformed
        btnZapamtiUgovor.setEnabled(true);
        napravljenNovUg = true;
        tabelaUsluge.setEnabled(true);
        Paket pom = new Paket();
        m = JOptionPane.showInputDialog("Unesite ime paketa:");
        if (m == null) {
            return;
        }
        btnNovPaket.setEnabled(false);
        pom.setNaziv(m);

        TableModelPaket tm = (TableModelPaket) tabelaPaketi.getModel();
        tm.lista.add(pom);
        tabelaPaketi.setModel(tm);
        tm.fireTableDataChanged();
        Usluga ug1 = new Usluga(123, UslugaTip.GB, 0, 0, 0, "");
        Usluga ug2 = new Usluga(123, UslugaTip.MIN, 0, 0, 0, "");
        Usluga ug3 = new Usluga(123, UslugaTip.SMS, 0, 0, 0, "");
        ArrayList<Usluga> lista = new ArrayList<>();
        lista.add(ug1);
        lista.add(ug2);
        lista.add(ug3);
        try {
            TableModelUsluga tmu = new TableModelUsluga(lista);
            tabelaUsluge.setModel(tmu);
        } catch (Exception ex) {
            Logger.getLogger(FrmNovUgovor.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabelaPaketi.setRowSelectionInterval(tm.lista.size() - 1, tm.lista.size() - 1);
        //tabelaPaketi.setEnabled(false);
        // tabelaUsluge.setEnabled(true);

    }//GEN-LAST:event_btnNovPaketActionPerformed

    private void btnZapamtiUgovorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapamtiUgovorActionPerformed
        try {

            String brtel = txtBr.getText().trim();
            String naziv = txtNaziv.getText().trim();
            Date DatumOd = new Date();
            Calendar cal = Calendar.getInstance();
            if (cmbTrajanje.getSelectedItem().toString().startsWith("12")) {
                cal.add(Calendar.MONTH, 12);
            } else {
                cal.add(Calendar.MONTH, 24);
            }
            Date datumDo = cal.getTime();
            TableModelUsluga tm = (TableModelUsluga) tabelaUsluge.getModel();
            List<Usluga> listaUsluga = tm.lista;
            Paket pak = null;
            if (napravljenNovUg) {
                pak = new Paket();
                pak.setNaziv(m);
            } else {
                pak = Kontroler.getKontroler().dajJedanPaket((int) tabelaPaketi.getModel().getValueAt(tabelaPaketi.getSelectedRow(), 0));
            }

            pak.setUsluge((ArrayList<Usluga>) listaUsluga);

            Ugovor novi = new Ugovor();
            novi.setBrojTelefona(brtel);
            novi.setDatumDo(datumDo);
            novi.setDatumOd(DatumOd);
            novi.setKorisnik(trenutniKorisnik);
            novi.setZaposleni(trenutniZaposleni);
            novi.setNaziv(naziv);
            novi.setPaket(pak);

            if (napravljenNovUg) {
                Kontroler.getKontroler().dodajPaket(pak);
            }
            Kontroler.getKontroler().dodajUgovor(novi);
            jLabel3.setForeground(Color.BLACK);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio ugovor!", "Uspeh!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {

            if (e.getMessage().endsWith("ugovor!")) {
                jLabel3.setForeground(Color.red);
            } else if (e.getMessage().endsWith("paket!")) {
                TitledBorder tb = javax.swing.BorderFactory.createTitledBorder("Usluge izabranog paketa:");
                tb.setTitleColor(Color.RED);
                panelUsluge.setBorder(tb);
            }
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti ugovor! " + e.getMessage(), "Greska!", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnZapamtiUgovorActionPerformed

    private void tabelaPaketiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabelaPaketiPropertyChange

    }//GEN-LAST:event_tabelaPaketiPropertyChange

    private void txtBrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrFocusLost
        //txtBr.setBackground(new Color(252,132,124));

    }//GEN-LAST:event_txtBrFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovPaket;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnZapamtiUgovor;
    private javax.swing.JComboBox cmbTrajanje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane panelScroll;
    private javax.swing.JPanel panelUsluge;
    private javax.swing.JTable tabelaPaketi;
    private javax.swing.JTable tabelaUsluge;
    private javax.swing.JTextField txtBr;
    private javax.swing.JTextField txtKorisnik;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtZaposleni;
    // End of variables declaration//GEN-END:variables

    private void prepareView() throws Exception {
        cmbTrajanje.removeAllItems();
        cmbTrajanje.addItem("12 meseci");
        cmbTrajanje.addItem("24 meseca");
        tabelaPaketi.setModel(new TableModelPaket(Kontroler.getKontroler().dajSvePakete()));
        System.out.println(FrmMain.ulogovan.getZaposleniId());
        List<Korisnik> listaKor = Kontroler.getKontroler().dajSveKorisnike();
        for (Korisnik korisnik : listaKor) {
            if (korisnik.getKorisnikId() == id) {
                txtKorisnik.setText(korisnik.toString());
                trenutniKorisnik = korisnik;
                trenutniZaposleni = FrmMain.ulogovan;
            }
        }
        tabelaUsluge.setModel(new TableModelUsluga());
        tabelaUsluge.setEnabled(false);

        //comboCell(tabelaUsluge, tabelaUsluge.getColumn("Tip"));
    }
}
