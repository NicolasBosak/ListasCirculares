public class MiembroEquipo {
    private String nombre;
    private String cedula;
    private int edad;
    private String rol;

    public MiembroEquipo(String nombre, String cedula, int edad, String rol) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Miembro Equipo " +
                "Nombre: " + nombre + '\'' +
                ", Cedula: " + cedula + '\'' +
                ", Edad: " + edad +
                ", Rol: " + rol;
    }
}
