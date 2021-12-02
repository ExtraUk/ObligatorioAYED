import java.util.List;

public class Empresa {
    private int id;
    private String nombre;
    private List<Empleado> listaEmpleados;
    private List<Seguro> listaSeguros;

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

    public Empresa(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}