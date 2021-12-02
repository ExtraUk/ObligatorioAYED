import java.util.List;

public class Empleado extends Persona{
    private Empresa empresa;
    private List<Familiar> listaFamiliares;

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

    public Empleado(int id, String nombre, String apellido, int edad, Empresa empresa) {
        super(id, nombre, apellido, edad);
        this.empresa = empresa;
    }
}