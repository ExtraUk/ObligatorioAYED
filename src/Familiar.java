import java.util.ArrayList;
import java.util.List;

public class Familiar extends Persona{
    private Usuario usuarioACargo;
    private boolean mayorDeEdad;
    private Seguro seguro;
    private static List<Familiar> listaFamiliares = new ArrayList<Familiar>();

    public Familiar() {

    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public List<Familiar> getListaFamiliares(){
        return listaFamiliares;
    }
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

    public Familiar buscarFamiliar(Familiar pFamiliar){
        return this.buscarFamiliar(pFamiliar, 0);
    }

    public Familiar buscarFamiliar(Familiar pFamiliar, int pos){
        if(pos >= listaFamiliares.size()){
            return null;
        }
        else if(listaFamiliares.get(pos).getId() == pFamiliar.getId()){
            return listaFamiliares.get(pos);
        }
        else{
            return buscarFamiliar(pFamiliar, pos+1);
        }
    }

    public void agregarConsulta(Consulta consulta, String s){
        this.agregarConsulta(consulta);
        this.usuarioACargo.modificarFamiliar(this);
    }

    public Familiar(int id, String nombre, String apellido, int edad, Usuario usuarioACargo, boolean mayor) {
        super(id, nombre, apellido, edad);
        this.usuarioACargo = usuarioACargo;
        this.mayorDeEdad = mayor;
    }
    public Familiar(int id, String nombre, String apellido, int edad, int idUsuario, boolean mayor) {
        super(id, nombre, apellido, edad);
        Usuario usuario = new Usuario();
        this.usuarioACargo = usuario.buscarUsuario(new Usuario(idUsuario));
        this.mayorDeEdad = mayor;

    }

    public Familiar(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "FAMILIAR Id: " + this.getId() + ", Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido();
    }
}