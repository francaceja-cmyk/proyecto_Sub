import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Objects;

public class ModeloTablaPrio {
    private DefaultTableModel modelo;
    private List<Tarea> tareas;
    public ModeloTablaPrio(List<Tarea> tareas) {
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


        for (Tarea tarea : this.tareas) {


            if (Objects.equals(tarea.getPrioridad(), "Alta")){
                fila = new Object[4];
                fila[0] = tarea.getTitulo();
                fila[1] = tarea.getDescripcion();
                fila[2] = tarea.getPrioridad();
                fila[3] = tarea.getFecha();
                modelo.addRow(fila);
            }

        }
        for (Tarea tarea : tareas) {


            if (Objects.equals(tarea.getPrioridad(), "Media")){
                fila = new Object[4];
                fila[0] = tarea.getTitulo();
                fila[1] = tarea.getDescripcion();
                fila[2] = tarea.getPrioridad();
                fila[3] = tarea.getFecha();
                modelo.addRow(fila);
            }

        }
        for (Tarea tarea : tareas) {


            if (Objects.equals(tarea.getPrioridad(), "Baja")){
                fila = new Object[4];
                fila[0] = tarea.getTitulo();
                fila[1] = tarea.getDescripcion();
                fila[2] = tarea.getPrioridad();
                fila[3] = tarea.getFecha();
                modelo.addRow(fila);
            }

        }
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

}
