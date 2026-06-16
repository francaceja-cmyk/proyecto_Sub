import java.io.File;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        gestor_de_tareas g = new gestor_de_tareas();
        g.setTareas();
        ArrayList<Tarea> tareas = g.getTareas();
        String titu=tareas.getFirst().getTitulo();
        for(Tarea t:tareas){
            if(t.getTitulo().equals(titu)){
                t.eliminarDirectorio(new File(t.getArchivo().getParent() + "/"));
            }
        }
    }
}
