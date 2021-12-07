import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona{
    private Empresa empresa;
    private List<Familiar> listaFamiliares = new ArrayList<Familiar>();
    private Seguro seguro;

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
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

    public boolean existeUsuario(Usuario pUsuario){
        return this.existeUsuario(pUsuario, 0);
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

    public Usuario buscarUsuario(Usuario pUsuario){
        return this.buscarUsuario(pUsuario, 0);
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

    public int buscarIndiceUsuario(Usuario pUsuario){
        return this.buscarIndiceUsuario(pUsuario, 0);
    }

    public int buscarIndiceUsuario(Usuario usuario, int pos){ //buscar indice Usuario recursivo
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

    public boolean esFamiliar(Familiar pFamiliar){
        return this.esFamiliar(pFamiliar, 0);
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

    public int buscarIndiceFamiliar(Familiar pFamiliar){
        return this.buscarIndiceFamiliar(pFamiliar, 0);
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
            pUsuario.getEmpresa().agregarEmpleado(pUsuario);
            pUsuario.getEmpresa().asignarSeguro();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean bajaUsuario(Usuario pUsuario){
        if(existeUsuario(pUsuario, 0)){
            Usuario usu = buscarUsuario(pUsuario);
            listaUsuarios.remove(usu);
            usu.getEmpresa().eliminarEmpleado(pUsuario);
            return true;
        }
        return false;
    }


    public boolean modificarUsuario(Usuario pUsuario){
        int emp = buscarIndiceUsuario(pUsuario, 0);
        if(emp >= 0){
            pUsuario.setEmpresa(listaUsuarios.get(emp).getEmpresa());
            listaUsuarios.get(emp).getEmpresa().actualizarEmpleado(pUsuario);
            listaUsuarios.set(emp, pUsuario);
            return true;
        }
        return false;
    }

    public boolean altaFamiliar(Familiar familiar){
        if(familiar.isMayorDeEdad()){
            if(mayoresDeEdad(0) <= 2){
                listaFamiliares.add(familiar);
                this.empresa.actualizarEmpleado(this);
                return true;
            }
        }
        else{
            if(menoresDeEdad(0) <= 4){
                listaFamiliares.add(familiar);
                this.empresa.actualizarEmpleado(this);
                return true;
            }
        }
        return false;
    }

    public boolean bajaFamiliar(Familiar pFamiliar){
        if(esFamiliar(pFamiliar, 0)){
               Familiar fam = this.buscarFamiliar(pFamiliar, 0);
               this.listaFamiliares.remove(fam);
                this.empresa.actualizarEmpleado(this);
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
        if(pos >= listaFamiliares.size()){
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
        if(pos >= listaFamiliares.size()){
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

    public void asignarSeguro(Seguro seguro){
        this.seguro = seguro;
        asignarSeguroAFamiliares(seguro, 0);
        this.empresa.actualizarEmpleado(this);
        int pos = buscarIndiceUsuario(this);
        listaUsuarios.set(pos, this);
    }

    public void asignarSeguroAFamiliares(Seguro seguro, int pos){
        if(pos >= listaFamiliares.size()){
            return;
        }
        else{
            Familiar familiar = listaFamiliares.get(pos);
            familiar.setSeguro(seguro);
            listaFamiliares.set(pos, familiar);
            asignarSeguroAFamiliares(seguro, pos+1);
        }
    }

    public void listarFamiliares(int pos){
        if(pos >= listaFamiliares.size()){
            return;
        }
        else{
            System.out.println(listaFamiliares.get(pos).toString());
            listarFamiliares(pos+1);
        }
    }

    public void agregarConsulta(Consulta consulta, String s){
        this.agregarConsulta(consulta);
        this.empresa.actualizarEmpleado(this);
    }

    public Usuario(int id, String nombre, String apellido, int edad, Empresa empresa) {
        super(id, nombre, apellido, edad);
        this.empresa = empresa;
    }
    
    public Usuario(int id, String nombre, String apellido, int edad, int idEmpresa) {
        super(id, nombre, apellido, edad);
        Empresa eEmpresa = new Empresa();
        this.empresa = eEmpresa.buscarEmpresa(new Empresa(idEmpresa));
    }

    public Usuario(int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido, edad);
    }

    public Usuario() {
        super();
    }

    public Usuario(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "EMPLEADO Id: " + this.getId() + ", Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido();
    }
}