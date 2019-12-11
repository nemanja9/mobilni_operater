package gui.view.components;

import domen.Paket;
import domen.Usluga;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;


public class TableModelUsluga extends AbstractTableModel {

    private List<Paket> listaPaketa;
    public Paket toJeTaj = null;
    String[] columnNames=new String[]{"Tip", "Kolicina","Cena"};
    
    public TableModelUsluga(int paket_id) throws Exception {
        listaPaketa = Kontroler.getKontroler().dajSvePakete();
        for (Paket paket : listaPaketa) {
            if(paket.getPaketId()== paket_id)
                toJeTaj = paket;
        }
        
    }

    
    @Override
    public int getRowCount() {
        if(toJeTaj== null) return 0;
        return toJeTaj.getUsluge().size();
    }

    @Override
    public int getColumnCount() {
    return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usluga pom = toJeTaj.getUsluge().get(rowIndex);
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
     public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
}
