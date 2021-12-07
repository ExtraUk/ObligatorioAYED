import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private int id;
    private String nombre;
    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private Seguro seguroEmpresa;

    private static List<Empresa> listaEmpresas = new ArrayList<Empresa>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Usuario> getListaEmpleados() {
        return listaUsuarios;
    }
    public void setListaEmpleados(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Seguro getSeguroEmpresa() {
        return seguroEmpresa;
    }

    public void setSeguroEmpresa(Seguro seguroEmpresa) {
        this.seguroEmpresa = seguroEmpresa;
    }

    public static List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public boolean existeEmpresa(Empresa empresa, int pos){ //Buscar Recursivo
        if(pos >= listaEmpresas.size()){
            return false;
        }
        else if(listaEmpresas.get(pos).getId() == empresa.getId()){
            return true;
        }
        else{
            return existeEmpresa(empresa, pos+1);
        }
    }

    public Empresa buscarEmpresa(Empresa pEmpresa){
        return this.buscarEmpresa(pEmpresa, 0);
    }

    public Empresa buscarEmpresa(Empresa empresa, int pos){ //Buscar Recursivo
        if(pos >= listaEmpresas.size()){
            return null;
        }
        else if(listaEmpresas.get(pos).getId() == empresa.getId()){
            return listaEmpresas.get(pos);
        }
        else{
            return buscarEmpresa(empresa, pos+1);
        }
    }

    public int buscarIndiceEmpresa(Empresa empresa, int pos){
        if(pos >= listaEmpresas.size()){
            return -1;
        }
        else if(listaEmpresas.get(pos).getId() == empresa.getId()){
            return pos;
        }
        else{
            return buscarIndiceEmpresa(empresa, pos+1);
        }
    }

    public boolean altaEmpresa(Empresa pEmpresa){
        if(!existeEmpresa(pEmpresa, 0)){
            listaEmpresas.add(pEmpresa);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean bajaEmpresa(Empresa pEmpresa){
        Empresa empresa = this.buscarEmpresa(pEmpresa, 0);
        if(empresa != null){
            listaEmpresas.remove(empresa);
            return true;
        }
        return false;
    }

    public boolean modificarEmpresa(Empresa pEmpresa){
        int empresa = buscarIndiceEmpresa(pEmpresa, 0);
        if(empresa >= 0){
            listaEmpresas.set(empresa, pEmpresa);
            return true;
        }
        return false;
    }

    public boolean agregarEmpleado(Usuario pUsuario){
        listaUsuarios.add(pUsuario);
        return true;
    }

    public boolean eliminarEmpleado(Usuario pUsuario){
        if(listaUsuarios.remove(pUsuario)) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean actualizarEmpleado(Usuario usuario){
        int pos = buscarIndiceUsuario(usuario, 0);
        listaUsuarios.set(pos, usuario);
        return true;
    }

    public boolean asignarSeguro(int idSeguro){
        Seguro seg = new Seguro(idSeguro);
        Seguro seguro = seg.buscarSeguro(seg);
        if(seguro != null){
            this.seguroEmpresa = seguro;
            asignarSeguroAEmpleados(seguro, 0);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean asignarSeguro(){
        if(this.seguroEmpresa != null){
            asignarSeguroAEmpleados(seguroEmpresa, 0);
            return true;
        }
        else{
            return false;
        }
    }

    public void asignarSeguroAEmpleados(Seguro seguro, int pos){
        if(pos >= listaUsuarios.size()){
            return;
        }
        else{
            Usuario usuario = listaUsuarios.get(pos);
            usuario.asignarSeguro(seguro);
            listaUsuarios.set(pos, usuario);
            asignarSeguroAEmpleados(seguro, pos+1);
        }
    }

    public void listarEmpleados(int pos){
        if(pos >= listaUsuarios.size()){
            return;
        }
        else{
            System.out.println(listaUsuarios.get(pos).toString());
            listaUsuarios.get(pos).listarFamiliares(0);
            listarEmpleados(pos+1);
        }
    }

    public void listarSeguroYEmpleados(){
        System.out.println(seguroEmpresa.toString());
        listarEmpleados(0);
    }



    public int buscarIndiceUsuario(Usuario pUsuario, int pos){
        if(pos >= listaUsuarios.size()){
            return -1;
        }
        else if(listaUsuarios.get(pos).getId() == pUsuario.getId()){
            return pos;
        }
        else{
            return buscarIndiceUsuario(pUsuario, pos+1);
        }
    }

    public Empresa(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Empresa(int id) {
        this.id = id;
    }

    public Empresa() {

    }
}