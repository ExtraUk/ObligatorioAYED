import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private int id;
    private String nombre;
    private List<Usuario> listaUsuarios;
    private List<Seguro> listaSeguros;

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
    public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }
    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
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