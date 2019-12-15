package Arboles;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Programacion I 2B
 */
public class ModeloTablaPersona extends AbstractTableModel {

    @Getter
    @Setter
    private List<Empleado> lista = new ArrayList<>();

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getNombre();
            case 1:
                return p.getApellido();
            case 2:
                return p.getAñosServicio();
            case 3:
                return p.getCedula();
            case 4:
                return p.getEdad();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellidos";
            case 2:
                return "Años de servicio";
            case 3:
                return "Cedula";
            case 4:
                return "Edad";
                default:
                return null;
        }
    }
}
