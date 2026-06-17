import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloTablaFecha {
    private DefaultTableModel modelo;
    private List<Tarea> tareas;

    public ModeloTablaFecha(List<Tarea> tareas) {
        this.tareas = tareas;

        this.modelo = new DefaultTableModel();

        modelo.addColumn("Titulo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Prioridad");
        modelo.addColumn("Fecha");

        Date hoy = new Date();
        List<Tarea> futuras = new ArrayList<>();
        List<Tarea> pasadas = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (!tarea.getFecha().before(hoy)) {
                futuras.add(tarea);
            } else {
                pasadas.add(tarea);
            }
        }

        ordenarFuturas(futuras);
        ordenarPasadas(pasadas);

        List<Tarea> listaOrdenada = new ArrayList<>();
        listaOrdenada.addAll(futuras);
        listaOrdenada.addAll(pasadas);

        for (int i = 0; i < listaOrdenada.size(); i++) {
            Tarea tarea = listaOrdenada.get(i);
            Object[] fila = new Object[4];
            fila[0] = tarea.getTitulo();
            fila[1] = tarea.getDescripcion();
            fila[2] = tarea.getPrioridad();
            fila[3] = tarea.getFecha();
            modelo.addRow(fila);
        }
    }

    private void ordenarFuturas(List<Tarea> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j).getFecha().after(lista.get(j + 1).getFecha())) {
                    Tarea temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    private void ordenarPasadas(List<Tarea> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j).getFecha().before(lista.get(j + 1).getFecha())) {
                    Tarea temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
}