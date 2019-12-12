/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view.components;

import domen.Korisnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nemanja
 */
public class TableModelKorisnik extends AbstractTableModel{

    public List<Korisnik> korisnici;
    String[] columnNames=new String[]{"ID", "Ime", "Prezime", "Adresa"};

    public TableModelKorisnik(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
    
    
    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik kor = korisnici.get(rowIndex);
        switch(columnIndex){
            case 0: return kor.getKorisnikId();
            case 1: return kor.getIme();
            case 2: return kor.getPrezime();
            case 3: return kor.getAdresa();
            default:return "nikad cula";
        }
    }
    public Korisnik dajKorisnika(int row){
        return korisnici.get(row);
    }
     
}