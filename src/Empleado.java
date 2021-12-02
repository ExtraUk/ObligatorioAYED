import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona{
    private Empresa empresa;
    private List<Familiar> listaFamiliares;

    private static List<Empleado> listaEmpleados = new ArrayList<Empleado>();

    public List<Empleado> getListaEmpleados(){
        return listaEmpleados;
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


    public boolean existeEmpleado(Empleado empleado, int pos){ //Existe empleado recursivo
        if(pos >= listaEmpleados.size()){
            return false;
        }
        else if(listaEmpleados.get(pos).getId() == empleado.getId()){
            return true;
        }
        else{
            return existeEmpleado(empleado, pos+1);
        }
    }

    public Empleado buscarEmpleado(Empleado empleado, int pos){ //Buscar empleado recursivo
        if(pos >= listaEmpleados.size()){
            return null;
        }
        else if(listaEmpleados.get(pos).getId() == empleado.getId()){
            return listaEmpleados.get(pos);
        }
        else{
            return buscarEmpleado(empleado, pos+1);
        }
    }

    public int buscarIndiceEmpleado(Empleado empleado, int pos){ //Existe empleado recursivo
        if(pos >= listaEmpleados.size()){
            return -1;
        }
        else if(listaEmpleados.get(pos).getId() == empleado.getId()){
            return pos;
        }
        else{
            return buscarIndiceEmpleado(empleado, pos+1);
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

    public boolean altaEmpleado(Empleado pEmpleado){
        if(!existeEmpleado(pEmpleado, 0)){
            listaEmpleados.add(pEmpleado);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean bajaEmpleado(Empleado pEmpleado){
        if(!existeEmpleado(pEmpleado, listaEmpleados.size())){
            listaEmpleados.remove(pEmpleado);
            return true;
        }
        return false;
    }

    public boolean modificarEmpleado(Empleado pEmpleado){
        int emp = buscarIndiceEmpleado(pEmpleado, 0);
        if(emp > 0){
            listaEmpleados.set(emp, pEmpleado);
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



    public Empleado(int id, String nombre, String apellido, int edad, Empresa empresa) {
        super(id, nombre, apellido, edad);
        this.empresa = empresa;
    }
}