import java.util.List;

public class Empleado extends Persona{
    private Empresa empresa;
    private List<Familiar> listaFamiliares;

    private static List<Empleado> listaEmpleados;

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


    public boolean buscarEmpleado(Empleado empleado, int pos){ //Buscar empleado recursivo
        if(pos == -1){
            return false;
        }
        else if(listaEmpleados.get(pos-1).equals(empleado)){
            return true;
        }
        else{
            return buscarEmpleado(empleado, pos-1);
        }
    }

    public boolean altaEmpleado(Empleado pEmpleado){
        if(!buscarEmpleado(pEmpleado, listaEmpleados.size())){
            listaEmpleados.add(pEmpleado);
            return true;
        }
        else{
            return false;
        }
    }



    public Empleado(int id, String nombre, String apellido, int edad, Empresa empresa) {
        super(id, nombre, apellido, edad);
        this.empresa = empresa;
    }
}