package gui.view.components;

import domen.Ugovor;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelUgovor extends AbstractTableModel{

    
    List<Ugovor> lista;
    String[] columnNames=new String[]{"ID", "Potpisan dana", "Vazi do", "Broj telefona", "Paket"};

    public TableModelUgovor(List<Ugovor> lista) {
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
    public String getColumnName(int i) {
        return columnNames[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ugovor pom = lista.get(rowIndex);
        SimpleDateFormat sdf  = new SimpleDateFormat("dd-MM-YYYY");
        switch (columnIndex){
            case 0: return pom.getUgovorId();
            case 1: return sdf.format(pom.getDatumOd());
            case 2: return sdf.format(pom.getDatumDo());
            case 3: return pom.getBrojTelefona();
            case 4: return pom.getPaket().getNaziv();
            default: return "da fuq";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
public Ugovor dajUgovor(int row){
    return lista.get(row);
}
    
}
