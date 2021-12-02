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



    public Empleado(int id, String nombre, String apellido, int edad, Empresa empresa) {
        super(id, nombre, apellido, edad);
        this.empresa = empresa;
    }
}