import java.util.ArrayList;
import java.util.List;

public class Especialista extends Persona{
    private Especialidad especialidad;

    private static List<Especialista> listaEspecialistas = new ArrayList<Especialista>();

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Especialista(int id, String nombre, String apellido, int edad, Especialidad especialidad) {
        super(id, nombre, apellido, edad);
        this.especialidad = especialidad;
    }

    public Especialista(int id, String nombre, String apellido, int edad, int idEspecialidad) {
        super(id, nombre, apellido, edad);
        Especialidad especialidad = new Especialidad();
        this.especialidad = especialidad.buscarEspecialidadId(idEspecialidad);
    }

    public Especialista(){

    }

    public static List<Especialista> getListaEspecialistas() {
        return listaEspecialistas;
    }

    public static void setListaEspecialistas(List<Especialista> listaEspecialistas) {
        Especialista.listaEspecialistas = listaEspecialistas;
    }


    public boolean existeEspecialista(Especialista especialista, int pos){
        if(pos >= listaEspecialistas.size()){
            return false;
        }
        else if(listaEspecialistas.get(pos).getId() == especialista.getId()){
            return true;
        }
        else{
            return existeEspecialista(especialista, pos+1);
        }
    }

    public Especialista buscarEspecialista(Especialista especialista, int pos){
        if(pos >= listaEspecialistas.size()){
            return null;
        }
        else if(listaEspecialistas.get(pos).getId() == especialista.getId()){
            return listaEspecialistas.get(pos);
        }
        else{
            return buscarEspecialista(especialista, pos+1);
        }
    }

    public int buscarIndiceEspecialista(Especialista especialista, int pos){
        if(pos >= listaEspecialistas.size()){
            return -1;
        }
        else if(listaEspecialistas.get(pos).getId() == especialista.getId()){
            return pos;
        }
        else{
            return buscarIndiceEspecialista(especialista, pos+1);
        }
    }

    public boolean altaEspecialista(Especialista especialista){
        if(!existeEspecialista(especialista, 0)){
            listaEspecialistas.add(especialista);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean bajaEspecialista(Especialista especialista){
        if(existeEspecialista(especialista, 0)){
            listaEspecialistas.remove(especialista);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean modificarEspecialista(Especialista especialista){
        if(existeEspecialista(especialista, 0)){
            int pos = buscarIndiceEspecialista(especialista, 0);
            listaEspecialistas.set(pos, especialista);
            return true;
        }
        else{
            return false;
        }
    }

}