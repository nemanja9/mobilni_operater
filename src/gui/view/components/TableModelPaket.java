package gui.view.components;

import domen.Korisnik;
import domen.Paket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nemanja
 */
public class TableModelPaket extends AbstractTableModel{

    List<Paket> lista;
    String[] columnNames=new String[]{"ID", "Naziv"};
    

    public TableModelPaket(List<Paket> lista) {
        this.lista = lista;
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
        Paket pom = lista.get(rowIndex);
        switch (columnIndex){
            case 0: return pom.getPaketId();
            case 1: return pom.getNaziv();
            default:return "Nikad cula";
        }
    }
    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
}