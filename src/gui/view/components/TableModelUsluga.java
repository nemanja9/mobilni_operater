package gui.view.components;

import domen.Paket;
import domen.Usluga;
import domen.UslugaTip;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;


public class TableModelUsluga extends AbstractTableModel {

    public ArrayList<Usluga> lista = new ArrayList<>();
    
    String[] columnNames=new String[]{"Tip", "Kolicina","Cena"};
    
    
    public TableModelUsluga(ArrayList<Usluga> lista) throws Exception {
        this.lista = lista;
        
        
    }
    public TableModelUsluga(){
        
    }

    
    @Override
    public int getRowCount() {
        
        return lista.size();
    }

    @Override
    public int getColumnCount() {
    return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Usluga pom = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return pom.getTip();
            case 1: return pom.getKolicina();
            case 2: return pom.getCena();
            default: return "wat";
        }
    }
 @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
   

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usluga pom = lista.get(rowIndex);
        try{
        switch(columnIndex){
            case 0:  pom.setTip(Integer.parseInt((String) aValue)); break;
            case 1:  pom.setKolicina(Double.parseDouble((String) aValue)); break;
            case 2:  pom.setCena(Double.parseDouble((String) aValue)); break;
            
        }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Niste lepo uneli neki podatak!", "Greska pri unosu!", JOptionPane.ERROR_MESSAGE);
            System.out.println(aValue);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
    }
    

}
