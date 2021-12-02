import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona{
    private Empresa empresa;
    private List<Familiar> listaFamiliares;

    private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public List<Usuario> getListaUsuarios(){
        return listaUsuarios;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public List<Familiar> getListaFamiliares() {
        return listaFamiliares;
    }
    public void setListaFamiliares(List<Familiar> listaFamiliares) {
        this.listaFamiliares = listaFamiliares;
    }


    public boolean existeUsuario(Usuario usuario, int pos){ //Existe Usuario recursivo
        if(pos >= listaUsuarios.size()){
            return false;
        }
        else if(listaUsuarios.get(pos).getId() == usuario.getId()){
            return true;
        }
        else{
            return existeUsuario(usuario, pos+1);
        }
    }

    public Usuario buscarUsuario(Usuario usuario, int pos){ //Buscar Usuario recursivo
        if(pos >= listaUsuarios.size()){
            return null;
        }
        else if(listaUsuarios.get(pos).getId() == usuario.getId()){
            return listaUsuarios.get(pos);
        }
        else{
            return buscarUsuario(usuario, pos+1);
        }
    }

    public int buscarIndiceUsuario(Usuario usuario, int pos){ //Existe Usuario recursivo
        if(pos >= listaUsuarios.size()){
            return -1;
        }
        else if(listaUsuarios.get(pos).getId() == usuario.getId()){
            return pos;
        }
        else{
            return buscarIndiceUsuario(usuario, pos+1);
        }
    }

    public boolean esFamiliar(Familiar pFamiliar, int pos) {
        if(pos >= listaFamiliares.size()){
            return false;
        }
        else if(listaFamiliares.get(pos).getId() == pFamiliar.getId()){
            return true;
        }
        else{
            return esFamiliar(pFamiliar, pos+1);
        }
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

    public int buscarIndiceFamiliar(Familiar pFamiliar, int pos){
        if(pos >= listaFamiliares.size()){
            return -1;
        }
        else if(listaFamiliares.get(pos).getId() == pFamiliar.getId()){
            return pos;
        }
        else{
            return buscarIndiceFamiliar(pFamiliar, pos+1);
        }
    }

    public boolean altaUsuario(Usuario pUsuario){
        if(!existeUsuario(pUsuario, 0)){
            listaUsuarios.add(pUsuario);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean bajaUsuario(Usuario pUsuario){
        if(!existeUsuario(pUsuario, listaUsuarios.size())){
            listaUsuarios.remove(pUsuario);
            return true;
        }
        return false;
    }

    public boolean modificarUsuario(Usuario pUsuario){
        int emp = buscarIndiceUsuario(pUsuario, 0);
        if(emp > 0){
            listaUsuarios.set(emp, pUsuario);
            return true;
        }
        return false;
    }

    public boolean altaFamiliar(Familiar familiar){
        if(familiar.isMayorDeEdad()){
            if(mayoresDeEdad(0) < 2){
                listaFamiliares.add(familiar);
                return true;
            }
        }
        else{
            if(menoresDeEdad(0) < 4){
                listaFamiliares.add(familiar);
                return true;
            }
        }
        return false;
    }

    public boolean bajaFamiliar(Familiar pFamiliar){
        if(esFamiliar(pFamiliar, 0)){
               Familiar fam = this.buscarFamiliar(pFamiliar, 0);
               this.listaFamiliares.remove(fam);
               return true;
        }
        return false;
    }

    public boolean modificarFamiliar(Familiar pFamiliar){
        if(esFamiliar(pFamiliar, 0)){
            int fam = this.buscarIndiceFamiliar(pFamiliar, 0);
            this.listaFamiliares.set(fam, pFamiliar);
            return true;
        }
        return false;
    }

    public int mayoresDeEdad(int pos){
        if(pos == listaFamiliares.size()){
            return 0;
        }
        else{
            if(listaFamiliares.get(pos).isMayorDeEdad()){
                return 1 + mayoresDeEdad(pos+1);
            }
            else{
                return mayoresDeEdad(pos+1);
            }
        }
    }

    public int menoresDeEdad(int pos){
        if(pos == listaFamiliares.size()){
            return 0;
        }
        else{
            if(!listaFamiliares.get(pos).isMayorDeEdad()){
                return 1 + menoresDeEdad(pos+1);
            }
            else{
                return menoresDeEdad(pos+1);
            }
        }
    }



    public Usuario(int id, String nombre, String apellido, int edad, Empresa empresa) {
        super(id, nombre, apellido, edad);
        this.empresa = empresa;
    }
}