import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private int id;
    private Persona persona;
    private Especialista especialista;
    private LocalDateTime fechaHora;

    private List<Consulta> listaConsultas = new ArrayList<Consulta>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean existeConsulta(Consulta pConsulta){
        return this.existeConsulta(pConsulta, 0);
    }

    public boolean existeConsulta(Consulta pConsulta, int pos){
        if(pos >= listaConsultas.size()) return false;

        if(listaConsultas.get(pos).getId() == pConsulta.getId())
            return true;

        return existeConsulta(pConsulta, pos + 1);
    }

    public Consulta buscarConsulta(Consulta pConsulta){
        return this.buscarConsulta(pConsulta, 0);
    }

    public Consulta buscarConsulta(Consulta pConsulta, int pos){
        if(pos > listaConsultas.size()) return null;

        if(listaConsultas.get(pos).getId() == pConsulta.getId())
            return listaConsultas.get(pos);

        return buscarConsulta(pConsulta, pos + 1);
    }

    public int buscarIndiceConsulta(Consulta pConsulta){
        return this.buscarIndiceConsulta(pConsulta, 0);
    }

    public int buscarIndiceConsulta(Consulta pConsulta, int pos){
        if(pos >= listaConsultas.size()) return -1;

        if(listaConsultas.get(pos).getId() == pConsulta.getId())
            return listaConsultas.indexOf(pos);

        return buscarIndiceConsulta(pConsulta, pos + 1);
    }

    public boolean altaConsulta(Consulta pConsulta){
        if(!existeConsulta(pConsulta)){
            listaConsultas.add(pConsulta);
            return true;
        }
        return false;
    }

    public boolean bajaConsulta(Consulta pConsulta){
        if(existeConsulta(pConsulta, 0)){
            Consulta cons = this.buscarConsulta(pConsulta, 0);
            listaConsultas.remove(cons);
            return true;
        }
        return false;
    }

    public boolean modificarConsulta(Consulta pConsulta){
        int consIndice = this.buscarIndiceConsulta(pConsulta, 0);
        if(consIndice >= 0){
            listaConsultas.set(consIndice, pConsulta);
            return true;
        }
        return false;
    }

}
