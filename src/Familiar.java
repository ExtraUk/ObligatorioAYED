public class Familiar extends Persona{
    private Empleado empleadoACargo;
    private boolean mayorDeEdad;

    public Empleado getEmpleadoACargo() {
        return empleadoACargo;
    }
    public void setEmpleadoACargo(Empleado empleadoACargo) {
        this.empleadoACargo = empleadoACargo;
    }
    public boolean isMayorDeEdad() {
        return mayorDeEdad;
    }
    public void setMayorDeEdad(boolean mayorDeEdad) {
        this.mayorDeEdad = mayorDeEdad;
    }

    public Familiar(int id, String nombre, String apellido, int edad, Empleado empleadoACargo, boolean mayor) {
        super(id, nombre, apellido, edad);
        this.empleadoACargo = empleadoACargo;
        this.mayorDeEdad = mayor;
    }

}