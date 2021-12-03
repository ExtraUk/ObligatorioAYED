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
        else if(listaSeguros.get(pos).getId() == seguro.getId()){
            return true;
        }
        else{
            return existeSeguro(seguro, pos+1);
        }
    }

    public boolean existeSeguro(Seguro pSeguro){
        return this.existeSeguro(pSeguro, 0);
    }

    public Seguro buscarSeguro(Seguro seguro, int pos){ //buscar Seguro recursivo
        if(pos >= listaSeguros.size()){
            return null;
        }
        else if(listaSeguros.get(pos).getId() == seguro.getId()){
            return listaSeguros.get(pos);
        }
        else{
            return buscarSeguro(seguro, pos+1);
        }
    }

    public Seguro buscarSeguro(Seguro pSeguro){
        return this.buscarSeguro(pSeguro, 0);
    }

    public int buscarIndiceSeguro(Seguro pSeguro, int pos){
        if(pos >= listaSeguros.size()){
            return -1;
        }
        else if(listaSeguros.get(pos).getId() == pSeguro.getId()){
            return pos;
        }
        else{
            return buscarIndiceSeguro(pSeguro, pos+1);
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

    public boolean bajaSeguro(Seguro pSeguro){
        Seguro seguro = this.buscarSeguro(pSeguro, 0);
        if(seguro != null){
            listaSeguros.remove(seguro);
            return true;
        }
        return false;
    }

    public boolean modificarSeguro(Seguro pSeguro){
        int indiceSeguro = this.buscarIndiceSeguro(pSeguro, 0);
        if(indiceSeguro >= 0){
            listaSeguros.set(indiceSeguro, pSeguro);
            return true;
        }
        return false;
    }

    public Seguro(int id, String tipo, int topeVisitasMensuales) {
        this.id = id;
        this.tipo = tipo;
        this.topeVisitasMensuales = topeVisitasMensuales;
    }

    public Seguro(int pId){
        this.id = pId;
    }

    public Seguro(){

    }


}