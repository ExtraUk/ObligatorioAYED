import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private int id;
    private String nombre;
    private List<Empleado> listaEmpleados;
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
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }
    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }


    public boolean existeEmpresa(Empresa empresa, int pos){ //Buscar Recursivo
        if(pos >= listaEmpresas.size()){
            return false;
        }
        else if(listaEmpresas.get(pos).equals(empresa)){
            return true;
        }
        else{
            return existeEmpresa(empresa, pos+1);
        }
    }

    public Empresa buscarEmpresa(Empresa empresa, int pos){ //Buscar Recursivo
        if(pos >= listaEmpresas.size()){
            return null;
        }
        else if(listaEmpresas.get(pos).equals(empresa)){
            return listaEmpresas.get(pos);
        }
        else{
            return buscarEmpresa(empresa, pos+1);
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



    public Empresa(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}