public class Familiar extends Persona{
    private Usuario usuarioACargo;
    private boolean mayorDeEdad;

    public Usuario getUsuarioACargo() {
        return usuarioACargo;
    }
    public void setUsuarioACargo(Usuario usuarioACargo) {
        this.usuarioACargo = usuarioACargo;
    }
    public boolean isMayorDeEdad() {
        return mayorDeEdad;
    }
    public void setMayorDeEdad(boolean mayorDeEdad) {
        this.mayorDeEdad = mayorDeEdad;
    }

    public Familiar(int id, String nombre, String apellido, int edad, Usuario usuarioACargo, boolean mayor) {
        super(id, nombre, apellido, edad);
        this.usuarioACargo = usuarioACargo;
        this.mayorDeEdad = mayor;
    }

}