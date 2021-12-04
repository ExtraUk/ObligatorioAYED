import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consulta {
    private int id;
    private Persona persona;
    private Especialista especialista;
    private LocalDateTime fechaHora;
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

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

    private int topeVisitasUser(Consulta pConsulta){
        int maximoUser = 0;
        for(Seguro seguro : empresa.getListaSeguros()){
            for(Usuario user : empresa.getListaEmpleados()){
                if(user.getId() == persona.getId()) {
                    maximoUser = seguro.getTopeVisitasMensuales();
                    return maximoUser;
                }
            }
        }
        return -1;
    }

    private int consultasDeUnUsuario(Persona pPersona){
        int nroConsultas = 0;
        for(Consulta cons : listaConsultas){
            Usuario user = new Usuario();
            if(pPersona.getClass().equals(Usuario.class.getClass())) {
                user = user.buscarUsuario((Usuario) pPersona);
                if(cons.persona.getId() == user.getId())
                    nroConsultas++;
            }
            if(pPersona.getClass().equals(Familiar.class.getClass())){
                // me perdi
            }
        }
        return nroConsultas;
    }

    public boolean altaConsulta(Consulta pConsulta){
        if(!existeConsulta(pConsulta)){
            int maximoUser = topeVisitasUser(pConsulta);
            if(maximoUser < 1) return false;
            else {
                Usuario user = new Usuario();
                Persona persona = new Persona();
                if(pConsulta.persona.getClass().equals(Usuario.class.getClass()))
                    persona = user.buscarUsuario((Usuario)pConsulta.persona);
                else if(pConsulta.persona.getClass().equals(Familiar.class.getClass()))
                    persona = user.buscarFamiliar((Familiar) pConsulta.persona);
                else
                    return false;

                int qtyConsultas = 0;
                for (Consulta consulta : listaConsultas){

                }


                listaConsultas.add(pConsulta);
                return true;
            }
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
