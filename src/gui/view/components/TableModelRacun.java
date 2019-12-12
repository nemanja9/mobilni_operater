package gui.view.components;


import domen.Racun;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelRacun extends AbstractTableModel{
    List<Racun> lista;
    String[] columnNames=new String[]{"ID", "Iznos", "Za period", "Placen"};

    public TableModelRacun(List<Racun> lista) {
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
        Racun pom = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-YYYY");
        switch(columnIndex){
            case 0: return pom.getRacunId();
            case 1: return pom.getIznos();
            case 2: return sdf.format(pom.getMesecGodina());
            case 3: return (pom.isPlacen()) ? "jeste" : "NIJE";
            default:return "leave me alone";
        }
    }
    
public void placen(int row){
    lista.remove(row);
}
}
