import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ModeloTablaAlf {
    private DefaultTableModel modelo;
    private List<Tarea> tareas;
    public ModeloTablaAlf(List<Tarea> tareas) {
        this.tareas = tareas;
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] fila;
        modelo.addColumn("Titulo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Prioridad");
        modelo.addColumn("Fecha");

        for (Tarea tarea : tareas) {
            fila = new Object[4];
            fila[0] = tarea.getTitulo();
            fila[1] = tarea.getDescripcion();
            fila[2] = tarea.getPrioridad();
            fila[3] = tarea.getFecha();
            modelo.addRow(fila);
        }
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }


}
