import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;

public class Consulta {
    private int id;
    private Persona persona;
    private Especialista especialista;
    private LocalDate fechaHora;
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

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
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

    private int esUserOFamiliar(Consulta pConsulta){ // retorna 1 si es usuario, 0 si es familiar o -1 si no es ninguno
        if(pConsulta.persona.getClass().equals(Usuario.class.getClass()))
            return 1;
        else if(pConsulta.persona.getClass().equals(Familiar.class.getClass()))
            return 0;

        return -1;
    }

    public boolean altaConsulta(Consulta pConsulta){
        if(!existeConsulta(pConsulta)){
            int maximoUser = topeVisitasUser(pConsulta);
            if(maximoUser < 1) return false;
            else {

                int qtyConsultas = 0;
                for (Consulta consulta : listaConsultas){
                    if(consulta.getFechaHora().getMonth().equals(pConsulta.getFechaHora().getMonth()) && consulta.getFechaHora().getYear() == pConsulta.getFechaHora().getYear()){
                        switch (esUserOFamiliar(pConsulta)){
                            case 1:
                                Usuario user = new Usuario().buscarUsuario((Usuario) pConsulta.persona);
                                for(Consulta consUsr : user.getListaConsultas()) {
                                    if (consUsr.persona.getId() == user.getId()) {
                                        if (consUsr.getFechaHora().getMonth().equals(pConsulta.getFechaHora().getMonth()) && consUsr.getFechaHora().getYear() == pConsulta.getFechaHora().getYear()) {
                                            qtyConsultas++;
                                            continue;
                                        }
                                    }
                                    for (Familiar fFam : user.getListaFamiliares()) {
                                        if (fFam.getId() == pConsulta.persona.getId()) {
                                            if (consUsr.getFechaHora().getMonth().equals(pConsulta.getFechaHora().getMonth()) && consUsr.getFechaHora().getYear() == pConsulta.getFechaHora().getYear()) {
                                                qtyConsultas++;
                                                continue;
                                            }
                                        }
                                    }
                                }
                                Usuario userF = new Usuario().buscarUsuario(((Usuario) pConsulta.persona));
                                if(qtyConsultas > userF.getSeguro().getTopeVisitasMensuales())
                                    return false;
                                return true;
                            case 0:
                                Familiar fam = new Familiar().buscarFamiliar((Familiar) pConsulta.persona);
                                Usuario userM = fam.getUsuarioACargo();
                                for(Consulta consUsrB : userM.getListaConsultas()){
                                    if(consUsrB.persona.getId() == userM.getId()){
                                        if(consUsrB.getFechaHora().getMonth().equals(pConsulta.getFechaHora().getMonth()) && consUsrB.getFechaHora().getYear() == pConsulta.getFechaHora().getYear()){
                                            qtyConsultas++;
                                            continue;
                                        }
                                    }
                                    for(Familiar fFamB : userM.getListaFamiliares()){
                                        if(fFamB.getId() == pConsulta.persona.getId()){
                                            if(consUsrB.getFechaHora().getMonth().equals(pConsulta.getFechaHora().getMonth()) && consUsrB.getFechaHora().getYear() == pConsulta.getFechaHora().getYear()){
                                                qtyConsultas++;
                                                continue;
                                            }
                                        }
                                    }
                                }
                                if(qtyConsultas > userM.getSeguro().getTopeVisitasMensuales())
                                    return false;
                                return true;
                            case -1:
                                return false;
                        }
                    }
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
