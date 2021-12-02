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

    public boolean altaEspecialista(Especialista especialista){
        if(!existeEspecialista(especialista, 0)){
            listaEspecialistas.add(especialista);
            return true;
        }
        else{
            return false;
        }
    }

}