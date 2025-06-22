package ejercicio5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LecturaArchivo {
    String rutaArchivo;
    FileInputStream archivo;
    InputStreamReader conversor;
    BufferedReader filtro;
    String linea;
    List<String> contenido = new java.util.ArrayList<>();

    public LecturaArchivo() {
    }

    public void leerArchivo() throws Exception {
        try {
            archivo = new FileInputStream(rutaArchivo);
            conversor = new InputStreamReader(archivo);
            filtro = new BufferedReader(conversor);
            linea = filtro.readLine();
            while (linea != null) {
                contenido.add(linea);
                linea = filtro.readLine();
            }
            filtro. close();
        }catch (IOException e){
            throw new Exception("Error al leer el archivo: " + e.getMessage());
        }
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<String> getContenido() {
        return contenido;
    }

    public void setContenido(List<String> contenido) {
        this.contenido = contenido;
    }
}
