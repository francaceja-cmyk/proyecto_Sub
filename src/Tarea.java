import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Date;

public class Tarea {
    private String prioridad;
    private Date fecha;
    private String titulo;
    private String descripcion;
    private File archivo;


    public Tarea(String prioridad, Date fecha, String titulo, String descripcion, File archivo) {
        this.prioridad = prioridad;
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void crearArchivo(File archivo) {
        if (!archivo.exists()) {
            archivo.mkdirs();
            File archivo2 = new File(archivo.getAbsolutePath()+"/"+titulo+".txt");
            try{
                archivo2.createNewFile();
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al crear el archivo");
            }
            File archivo3 = new File(archivo.getAbsolutePath()+"/datos_de_"+titulo+".txt");
            try {
                archivo3.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo");
            }
            try (FileWriter fw = new FileWriter(archivo3, true);) {
                fw.write(titulo);
                fw.write("\n");
                fw.write(prioridad);
                fw.write("\n");
                fw.write(getFecha().toString());
                fw.write("\n");
                fw.write(descripcion);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JOptionPane.showMessageDialog(null, "Archivo creado exitosamente");

        }else JOptionPane.showMessageDialog(null, "Archivo ya existe");
        }
    public void editarTarea(Tarea tarea) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("./Tareas/"+titulo + "/"+titulo+".txt"));
    }
    public boolean eliminarDirectorio(File directorio) {
        if (directorio.exists()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        eliminarDirectorio(archivo);
                    } else {
                        archivo.delete();
                    }
                }
            }
        }
        return directorio.delete();
    }

}
