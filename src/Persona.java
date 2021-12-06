import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Consulta> listaConsultas = new ArrayList<Consulta>();

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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public List<Consulta> getListaConsultas(){
        return listaConsultas;
    }

    private List<Consulta> todasLasConsultasEnRangoDeFechas(LocalDate fecha1, LocalDate fecha2, int pos, List<Consulta> retorno){
        if(pos >= listaConsultas.size()){
            return null;
        }
        else{

            if(listaConsultas.get(pos).getFechaHora().isAfter(fecha1) && listaConsultas.get(pos).getFechaHora().isBefore(fecha2)){
                retorno.add(listaConsultas.get(pos));
            }
            todasLasConsultasEnRangoDeFechas(fecha1, fecha2, pos+1, retorno);
        }
        return retorno;
    }

    private List<Persona> todaLaFamilia(Persona persona){
        if(persona.getClass() == Usuario.class){
            return ((Usuario) persona).getListaFamiliares();
        }
    }

    public Persona(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona(int id) {
        this.id = id;
    }

    public Persona(){

    }
}