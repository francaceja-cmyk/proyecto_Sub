import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class gestor_de_tareas {
    private ArrayList<Tarea> tareas;

    public gestor_de_tareas() {
        this.tareas = new ArrayList<>();
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
    public void setTareas() {
        try {
            this.tareas.clear();
            File archivos = new File("./Tareas/");
            File[] lista = archivos.listFiles();

            if (lista == null) return;
            SimpleDateFormat creadorFecha = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

            for (File file : lista) {
                if (file.isDirectory() && file.listFiles() != null) {
                    for (File f : file.listFiles()) {
                        if (f.getName().startsWith("datos_de_")) {

                            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                                String titulo = br.readLine();
                                String prioridad = br.readLine();
                                String fechaTexto = br.readLine();
                                Date fecha = creadorFecha.parse(fechaTexto);
                                String descripcion = br.readLine();

                                this.tareas.add(new Tarea(prioridad, fecha, titulo, descripcion, f));
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error al leer datos en el archivo: " + f.getName());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al intentar obtener el historial: " + e.getMessage());
        }
    }
}