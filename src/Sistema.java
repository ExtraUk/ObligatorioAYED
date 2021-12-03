import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        mostrarMenuPrincipal();
    }

    public static void mostrarMenuPrincipal(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ\t Mutualista Juanpi Torrico (provisional)\t ꕥ");
            System.out.println("Opciones:");
            System.out.println("1- Gestión Especialidades");
            System.out.println("2- Gestión Especialistas");
            System.out.println("3- Gestión Seguros");
            System.out.println("4- Gestión Empresas");
            System.out.println("5- Gestión Empleados de las Empresas");
            System.out.println("6- Gestión Familiares de los Empleados");
            System.out.println("7- Salir");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    menuGestionEspecialidades();
                    break;
                case 2:
                    menuGestionEspecialistas();
                    break;
                case 3:
                    menuGestionSeguros();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Valor incorrecto!");
                    opcion = -1;
                    break;
            }
        } while(opcion > 0);
    }

    /* Menus */
    public static void menuGestionEspecialidades(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Especialidades ꕥ");
            System.out.println("1- Agregar especialidad");
            System.out.println("2- Eliminar especialidad");
            System.out.println("3- Modificar especialidad");
            System.out.println("4- Listar especialidades");
            System.out.println("5- Volver");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la id:");
                    int mId = input.nextInt();
                    System.out.println("Ingrese el nombre (de la especialidad):");
                    String mNombre = input.next();
                    Especialidad esp = new Especialidad();
                    if(esp.altaEspecialidad(new Especialidad(mId, mNombre))) {
                        System.out.println("Especialidad agregada con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido agregar la especialidad! Compruebe que no existe e intente otra vez");
                    break;
                case 2:
                    System.out.println("Lista especialidades:");
                    listarEspecialidades();
                    System.out.println("Ingrese la id de la especialidad a eliminar:");
                    int mIdB = input.nextInt();
                    Especialidad espB = new Especialidad();
                    if(espB.bajaEspecialidad(new Especialidad(mIdB))){
                        System.out.println("Especialidad eliminada con éxito!");
                        break;
                    }
                    System.out.println("No se ha podido eliminar la especialidad! Compruebe que existe y pruebe de nuevo");
                    break;
                case 3:
                    System.out.println("Lista especialidades:");
                    listarEspecialidades();
                    System.out.println("Ingrese la id de la especialidad a modificar:");
                    int mIdM = input.nextInt();
                    Especialidad espM = new Especialidad();
                    if(espM.existeEspecialidad(new Especialidad(mIdM))) {
                        String mNombreM = input.next();
                        if (espM.modificarEspecialidad(new Especialidad(mIdM, mNombreM))) {
                            System.out.println("Especialidad modificada con éxito!");
                            break;
                        }
                    }

                    System.out.println("Esa especialidad no existe!");
                    break;

                case 4:
                    System.out.println("Lista especialidades:");
                    listarEspecialidades();
                    break;
                case 5:
                    opcion = -1;
                    break;
                default:
                    System.out.println("Valor incorrecto");
                    opcion = 1;
                    break;
            }
        }while(opcion > 0);
    }

    public static void menuGestionEspecialistas(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Especialistas ꕥ");
            System.out.println("1- Agregar especialista");
            System.out.println("2- Eliminar especialista");
            System.out.println("3- Modificar especialista");
            System.out.println("4- Listar especialistas");
            System.out.println("5- Volver");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la id:");
                    int mId = input.nextInt();
                    System.out.println("Ingrese el nombre:");
                    String mNombre = input.next();
                    System.out.println("Ingrese el apellido:");
                    String mApellido = input.next();
                    System.out.println("Ingrese la edad: ");
                    int mEdad = input.nextInt();
                    listarEspecialidades();
                    System.out.println("Ingrese la especialidad: ");
                    int mEspecialidadId = input.nextInt();
                    Especialista esp = new Especialista();
                    if(esp.altaEspecialista(new Especialista(mId, mNombre, mApellido, mEdad, mEspecialidadId))) {
                        System.out.println("Especialista agregado con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido agregar el especialista! Compruebe que no existe e intente otra vez");
                    break;
                case 2:
                    System.out.println("Lista especialistas:");
                    listarEspecialistas();
                    System.out.println("Ingrese la id el especialista a eliminar:");
                    int mIdB = input.nextInt();
                    Especialista espeB = new Especialista();
                    if(espeB.bajaEspecialista( new Especialista(mIdB))){
                        System.out.println("Especialista eliminado con éxito!");
                        break;
                    }
                    else{
                        System.out.println("No se pudo eliminar el especialista");
                        break;
                    }
                case 3:
                    System.out.println("Lista especialistas:");
                    listarEspecialistas();
                    System.out.println("Ingrese la id del especialista a modificar:");
                    int mIdM = input.nextInt();
                    Especialista espeM = new Especialista();
                    System.out.println("Ingrese el nuevo nombre");
                    String mNombreM = input.next();
                    System.out.println("Ingrese el nuevo apellido");
                    String mApellidoM = input.next();
                    System.out.println("Ingrese la nueva edad");
                    int mEdadM = input.nextInt();
                    listarEspecialidades();
                    System.out.println("Ingrese la id de la nueva especialidad");
                    int idEspecialidadM = input.nextInt();
                    if (espeM.modificarEspecialista(new Especialista(mIdM, mNombreM, mApellidoM, mEdadM, idEspecialidadM))) {
                        System.out.println("Especialidad modificada con éxito!");
                        break;
                    }

                    System.out.println("¡El especialista no existe!");
                    break;

                case 4:
                    System.out.println("Lista especialistas:");
                    listarEspecialistas();
                    break;
                case 5:
                    opcion = -1;
                    break;
                default:
                    System.out.println("Valor incorrecto");
                    opcion = 1;
                    break;
            }
        }while(opcion > 0);
    }

    public static void menuGestionSeguros(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Seguros ꕥ");
            System.out.println("1- Agregar seguro");
            System.out.println("2- Eliminar seguro");
            System.out.println("3- Modificar seguro");
            System.out.println("4- Listar seguros");
            System.out.println("5- Volver");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la id:");
                    int mId = input.nextInt();
                    System.out.println("Ingrese el tipo:");
                    String mTipo = input.next();
                    System.out.println("Ingrese el tope visitas mensuales:");
                    int mtopeVisitasM = input.nextInt();

                    Seguro seg = new Seguro();
                    if(seg.altaSeguro(new Seguro(mId, mTipo, mtopeVisitasM))) {
                        System.out.println("Seguro agregado con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido agregar el seguro! Compruebe que no existe e intente otra vez");
                    break;
                case 2:
                    System.out.println("Lista seguros:");
                    listarSeguros();
                    System.out.println("Ingrese la id del seguro a eliminar:");
                    int mIdB = input.nextInt();
                    Seguro segB = new Seguro();
                    if(segB.bajaSeguro(new Seguro(mIdB))){
                        System.out.println("Seguro eliminado con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido eliminar el seguro! Compruebe que existe e intente otra vez");
                    break;
                case 3:
                    System.out.println("Lista seguros:");
                    listarSeguros();
                    System.out.println("Ingrese la id del seguro a modificar:");
                    int mIdM = input.nextInt();
                    Seguro segM = new Seguro();

                    System.out.println("Ingrese el nuevo tipo");
                    String mTipoM = input.next();
                    System.out.println("Ingrese el nuevo tope de visitas mensual");
                    int mTopeVM = input.nextInt();
                    listarEspecialidades();
                    System.out.println("Ingrese la id del nuevo seguro");
                    int idEspecialidadM = input.nextInt();
                    if (segM.modificarSeguro(new Seguro(mIdM, mTipoM,mTopeVM ))) {
                        System.out.println("Especialidad modificada con éxito!");
                        break;
                    }

                    System.out.println("¡El seguro no existe!");
                    break;

                case 4:
                    System.out.println("Lista seguros:");
                    listarSeguros();
                    break;
                case 5:
                    opcion = -1;
                    break;
                default:
                    System.out.println("Valor incorrecto");
                    opcion = 1;
                    break;
            }
        }while(opcion > 0);
    }

    /*Listas */
    public static void listarEspecialidades(){
        Especialidad esp = new Especialidad();
        for(Especialidad especialidad : esp.getListaEspecialidades()){
            System.out.println("Id: " + especialidad.getId() + ". Nombre: " + especialidad.getNombre());
        }
    }

    public static void listarEspecialistas(){
        Especialista espe = new Especialista();
        for (Especialista especialista: espe.getListaEspecialistas()) {
            System.out.println("Id: " + especialista.getId() + ". Nombre: " + especialista.getNombre() + ". Apellido: " + especialista.getApellido() + ". Especialidad: " + especialista.getEspecialidad().getNombre());
        }
    }

    public static void listarSeguros(){
        Seguro seg = new Seguro();
        for (Seguro seguro : seg.getListaSeguros()) {
            System.out.println("Id: " + seguro.getId() + ". Tipo: " + seguro.getTipo() + ". Tope de visitas mensuales: "+ seguro.getTopeVisitasMensuales());
        }
 }
}
