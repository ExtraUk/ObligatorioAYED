public class Familiar {
    private Empleado empleadoACargo;

    public Empleado getEmpleadoACargo() {
        return empleadoACargo;
    }

    public void setEmpleadoACargo(Empleado empleadoACargo) {
        this.empleadoACargo = empleadoACargo;
    }

    public Familiar(Empleado empleadoACargo) {
        this.empleadoACargo = empleadoACargo;
    }
}