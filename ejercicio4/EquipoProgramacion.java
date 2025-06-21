package ejercicio4;

public class EquipoProgramacion {
    String nombreEquipo;
    String universidad;
    String lenguajeProgramacion;
    Programador[] programadores;
    int tamañoEquipo = 0;

    public EquipoProgramacion() {
        this.programadores = new Programador[3];
    }

    public boolean estaLleno(){
        if (programadores == null) {
            return false;
        }
        return tamañoEquipo == programadores.length;
    }
    public void agregarProgramador(Programador programador) throws Exception {
        if (estaLleno()) {
            throw new Exception("El equipo ya está lleno.");
        }
        programadores[tamañoEquipo] = programador;
        tamañoEquipo+=1;
    }
    public static void validarCampo(String campo) throws Exception {
        if (campo == null || campo.isEmpty()) {
            throw new Exception("El campo no puede estar vacío.");
        } else {
            for (int j = 0; j < campo.length(); j++){
                char c = campo.charAt(j);
                if (Character.isDigit(c)){
                    throw new Exception("El campo no puede contener digitos.");
                }
                if (campo.length() > 20) {
                    throw new Exception("La longitud no debe ser superior a 20 caracteres.");
                }

            }
        }

    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public Programador[] getProgramadores() {
        return programadores;
    }

    public void setProgramadores(Programador[] programadores) {
        this.programadores = programadores;
    }

    public int getTamañoEquipo() {
        return tamañoEquipo;
    }

    public void setTamañoEquipo(int tamañoEquipo) {
        this.tamañoEquipo = tamañoEquipo;
    }
}
