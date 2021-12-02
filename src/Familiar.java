public class Familiar {
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

    public Familiar(Empleado empleadoACargo, boolean mayor) {
        this.empleadoACargo = empleadoACargo;
        this.mayorDeEdad = mayor;
    }
}