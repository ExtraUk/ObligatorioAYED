import java.util.List;

public class Seguro {
    private int id;
    private String tipo;
    private int topeVisitasMensuales;
    private List<Especialista> listaEspecialistas;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getTopeVisitasMensuales() {
        return topeVisitasMensuales;
    }
    public void setTopeVisitasMensuales(int topeVisitasMensuales) {
        this.topeVisitasMensuales = topeVisitasMensuales;
    }
    public List<Especialista> getListaEspecialistas() {
        return listaEspecialistas;
    }
    public void setListaEspecialistas(List<Especialista> listaEspecialistas) {
        this.listaEspecialistas = listaEspecialistas;
    }

    public Seguro(int id, String tipo, int topeVisitasMensuales) {
        this.id = id;
        this.tipo = tipo;
        this.topeVisitasMensuales = topeVisitasMensuales;
    }


}