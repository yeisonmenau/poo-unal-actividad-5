package ejercicio2;

public class Vendedor {
    private String nombre;
    private String apellidos;
    private int edad;

    public Vendedor(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public void verificarEdad(int edad)  {
        if (edad >= 0 && edad < 18  ) {
            throw new IllegalArgumentException("La edad del vendedor debe ser mayor o igual a 18");
        } else if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120");
        }
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }
}
