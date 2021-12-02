import java.util.*;

public class Especialidad {
    private int id;
    private String nombre;

    private static List<Especialidad> listaEspecialidades = new ArrayList<Especialidad>();

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

    public boolean existeEspecialidad(Especialidad especialidad, int pos){
        if(pos < 0) return false;

        if(listaEspecialidades.get(pos-1).equals(especialidad)) return true;

        return existeEspecialidad(especialidad, pos - 1);
    }

    public Especialidad buscarEspecialidad(Especialidad pEspecialidad, int pos){
        if(pos < 0 || listaEspecialidades.size() < pos) return null;

        if(listaEspecialidades.get(pos).getId() == pEspecialidad.getId()) return listaEspecialidades.get(pos);

        return buscarEspecialidad(pEspecialidad, pos - 1);
    }

    public int buscarIndiceEspecialidad(Especialidad pEspecialidad){
        for(Especialidad especialidad : this.listaEspecialidades){
            if(especialidad.getId() == pEspecialidad.getId())
                return this.listaEspecialidades.indexOf(pEspecialidad);
        }
        return -1;
    }

    public boolean altaEspecialidad(Especialidad pEspecialidad){
        if(!existeEspecialidad(pEspecialidad, listaEspecialidades.size())){
            listaEspecialidades.add(pEspecialidad);
            return true;
        }
        return false;
    }

    public boolean bajaEspecialidad(Especialidad pEspecialidad){
        if(!existeEspecialidad(pEspecialidad, listaEspecialidades.size())){
            listaEspecialidades.remove(pEspecialidad);
            return true;
        }
        return false;
    }

    public boolean modificarEspecialidad(Especialidad pEspecialidad){
        int esp = buscarIndiceEspecialidad(pEspecialidad);
        if(esp > 0){
            listaEspecialidades.set(esp, pEspecialidad);
            return true;
        }
        return false;
    }
}
