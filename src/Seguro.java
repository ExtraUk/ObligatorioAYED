import java.util.ArrayList;
import java.util.List;

public class Seguro {
    private int id;
    private String tipo;
    private int topeVisitasMensuales;
    private List<Especialista> listaEspecialistas;

    private static List<Seguro> listaSeguros = new ArrayList<Seguro>();

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

    public boolean existeSeguro(Seguro seguro, int pos){ //Existe Seguro recursivo
        if(pos >= listaSeguros.size()){
            return false;
        }
        else if(listaSeguros.get(pos).equals(seguro)){
            return true;
        }
        else{
            return existeSeguro(seguro, pos+1);
        }
    }

    public Seguro buscarSeguro(Seguro seguro, int pos){ //Existe Seguro recursivo
        if(pos >= listaSeguros.size()){
            return null;
        }
        else if(listaSeguros.get(pos).equals(seguro)){
            return listaSeguros.get(pos);
        }
        else{
            return buscarSeguro(seguro, pos+1);
        }
    }


    public boolean altaSeguro(Seguro pSeguro){
        if(!existeSeguro(pSeguro, 0)){
            listaSeguros.add(pSeguro);
            return true;
        }
        else{
            return false;
        }
    }

    public Seguro(int id, String tipo, int topeVisitasMensuales) {
        this.id = id;
        this.tipo = tipo;
        this.topeVisitasMensuales = topeVisitasMensuales;
    }


}