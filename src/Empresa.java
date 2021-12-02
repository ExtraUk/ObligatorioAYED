import java.util.List;

public class Empresa {
    private int id;
    private String nombre;
    private List<Empleado> listaEmpleados;
    private List<Seguro> listaSeguros;

    private static List<Empresa> listaEmpresas;

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


    public boolean buscarEmpresa(Empresa empresa, int pos){ //Buscar Recursivo
        if(pos == -1){
            return false;
        }
        else if(listaEmpresas.get(pos-1).equals(empresa)){
            return true;
        }
        else{
            return buscarEmpresa(empresa, pos-1);
        }
    }

    public boolean altaEmpresa(Empresa pEmpresa){
        if(!buscarEmpresa(pEmpresa, listaEmpresas.size())){
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