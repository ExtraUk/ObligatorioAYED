import java.util.List;
import java.util.ArrayList;

public class Especialidad {
    private int id;
    private String nombre;

    private static List<Especialidad> listaEspecialidades = new ArrayList<Especialidad>();

    public Especialidad() {

    }

    public Especialidad(int pId) {
        this.id = pId;
    }

    public List<Especialidad> getListaEspecialidades(){
        return listaEspecialidades;
    }
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

    public Especialidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public boolean existeEspecialidad(Especialidad especialidad){
        return this.existeEspecialidad(especialidad, 0);
    }

    public boolean existeEspecialidad(Especialidad especialidad, int pos){
       if(pos >= listaEspecialidades.size()){
           return false;
       }
       else if(listaEspecialidades.get(pos).getId() == especialidad.getId()){
           return true;
       }
       else{
           return existeEspecialidad(especialidad, pos+1);
       }
    }

    public Especialidad buscarEspecialidad(Especialidad pEspecialidad){
        return this.buscarEspecialidad(pEspecialidad, 0);
    }

    public Especialidad buscarEspecialidad(Especialidad pEspecialidad, int pos){
        if(pos > listaEspecialidades.size()) {
            return null;
        }
        else if(listaEspecialidades.get(pos).getId() == pEspecialidad.getId()){
            return listaEspecialidades.get(pos);
        }
        else{
            return buscarEspecialidad(pEspecialidad, pos + 1);
        }
    }

    public int buscarIndiceEspecialidad(Especialidad pEspecialidad, int pos){
        if(pos >= listaEspecialidades.size()) {
            return -1;
        }
        else if(listaEspecialidades.get(pos).getId() == pEspecialidad.getId()){
            return pos;
        }
        else{
            return buscarIndiceEspecialidad(pEspecialidad, pos + 1);
        }
    }

    public boolean altaEspecialidad(Especialidad pEspecialidad){
        if(!existeEspecialidad(pEspecialidad, 0)){
            listaEspecialidades.add(pEspecialidad);
            return true;
        }
        return false;
    }

    public boolean bajaEspecialidad(Especialidad pEspecialidad){
        if(existeEspecialidad(pEspecialidad, 0)){
            Especialidad esp = this.buscarEspecialidad(pEspecialidad, 0);
            listaEspecialidades.remove(esp);
            return true;
        }
        return false;
    }

    public boolean modificarEspecialidad(Especialidad pEspecialidad){
        int esp = buscarIndiceEspecialidad(pEspecialidad, 0);
        if(esp >= 0){
            listaEspecialidades.set(esp, pEspecialidad);
            return true;
        }
        return false;
    }
}
