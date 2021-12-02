public class Especialista extends Persona{
    private Especialidad especialidad;

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Especialista(int id, String nombre, String apellido, int edad, Especialidad especialidad) {
        super(id, nombre, apellido, edad);
        this.especialidad = especialidad;
    }

}