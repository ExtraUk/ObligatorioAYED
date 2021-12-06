import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        mostrarMenuPrincipal();

        //Datos precargados
        Empresa empresa = new Empresa(1, "SsISRL");
        empresa.altaEmpresa(empresa);

        Usuario usuario = new Usuario(1,"Juanita","Perez", 22,1 );
        usuario.altaUsuario(usuario);

        Especialidad especialidad = new Especialidad(1, "Dentista");
        especialidad.altaEspecialidad(especialidad);

        Especialista especialista = new Especialista(1,"Juanita","Perez", 22,1 );
        especialista.altaEspecialista(especialista);

        Familiar familiar = new Familiar(2,"Juanita","Perez", 22,1, true);
        usuario.altaFamiliar(familiar);

        Seguro seguro = new Seguro(1, "Medico Parcial", 10);
        seguro.altaSeguro(seguro);

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
            System.out.println("7- Gestión de las Consultas");
            System.out.println("8- Salir");

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
                    menuGestionEmpresas();
                    break;
                case 5:
                    menuGestionEmpleadosEmpresa();
                    break;
                case 6:
                    menuGestionFamiliaresEmpleados();
                    break;
                case 7:
                    menuGestionConsultas();
                    break;
                case 8:
                    menuGestionListados();
                    break;
                case 9:
                    opcion = -1;
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
                    listarEspecialidades(0);
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
                    listarEspecialidades(0);
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
                    listarEspecialidades(0);
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
                    listarEspecialidades(0);
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
                    listarEspecialistas(0);
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
                    listarEspecialistas(0);
                    System.out.println("Ingrese la id del especialista a modificar:");
                    int mIdM = input.nextInt();
                    Especialista espeM = new Especialista();
                    System.out.println("Ingrese el nuevo nombre");
                    String mNombreM = input.next();
                    System.out.println("Ingrese el nuevo apellido");
                    String mApellidoM = input.next();
                    System.out.println("Ingrese la nueva edad");
                    int mEdadM = input.nextInt();
                    listarEspecialidades(0);
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
                    listarEspecialistas(0);
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
                    listarSeguros(0);
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
                    listarSeguros(0);
                    System.out.println("Ingrese la id del seguro a modificar:");
                    int mIdM = input.nextInt();
                    Seguro segM = new Seguro();
                    System.out.println("Ingrese el nuevo tipo");
                    String mTipoM = input.next();
                    System.out.println("Ingrese el nuevo tope de visitas mensual");
                    int mTopeVM = input.nextInt();
                    listarSeguros(0);

                    if (segM.modificarSeguro(new Seguro(mIdM, mTipoM,mTopeVM ))) {
                        System.out.println("Seguro modificada con éxito!");
                        break;
                    }

                    System.out.println("¡El seguro no existe!");
                    break;


                case 4:
                    System.out.println("Lista seguros:");
                    listarSeguros(0);
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

    public static void menuGestionEmpresas(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Empresas ꕥ");
            System.out.println("1- Agregar empresa");
            System.out.println("2- Eliminar empresa");
            System.out.println("3- Modificar empresa");
            System.out.println("4- Listar empresas");
            System.out.println("5- Volver");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la id:");
                    int mId = input.nextInt();
                    System.out.println("Ingrese el nombre:");
                    String mNombre = input.next();
                    Empresa empr = new Empresa();
                    if(empr.altaEmpresa(new Empresa(mId, mNombre ))){
                        System.out.println("Empresa agregada con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido agregar la empresa! Compruebe que no existe e intente otra vez");
                    break;
                case 2:
                    System.out.println("Lista empresas:");
                    listarEmpresas(0);
                    System.out.println("Ingrese la id de la empresa a eliminar:");
                    int mIdB = input.nextInt();
                    Empresa emprB = new Empresa();

                    if(emprB.bajaEmpresa(new Empresa(mIdB))){
                        System.out.println("Empresa eliminada con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido eliminar la empresa! Compruebe que existe e intente otra vez");
                    break;
                case 3:
                    System.out.println("Lista empresas:");
                    listarEmpresas(0);
                    System.out.println("Ingrese la id de la empresa a modificar:");
                    int mIdM = input.nextInt();
                    System.out.println("Ingrese el nuevo nombre");
                    String mNombreM = input.next();
                    Empresa emprM = new Empresa();

                    if (emprM.modificarEmpresa(new Empresa(mIdM, mNombreM))) {
                        System.out.println("Empresa modificada con éxito!");
                        break;
                    }

                    System.out.println("¡La Empresa no existe!");
                    break;

                case 4:
                    System.out.println("Lista empresas:");
                    listarEmpresas(0);
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

    public static void menuGestionEmpleadosEmpresa(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Empleados de las Empresas ꕥ");
            System.out.println("1- Agregar empleados a una empresa");
            System.out.println("2- Eliminar empleados de una empresa");
            System.out.println("3- Modificar empleados de una empresa");
            System.out.println("4- Listar empleados de una empresa");
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
                    listarEmpresas(0);
                    System.out.println("Ingrese la id de la empresa: ");
                    int mEmpresaId = input.nextInt();
                    Usuario usu = new Usuario();
                    if(usu.altaUsuario(new Usuario(mId, mNombre, mApellido, mEdad, mEmpresaId))) {
                        System.out.println("Empleado agregado con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido agregar el empleado! Compruebe que no existe e intente otra vez");
                    break;
                case 2:
                    System.out.println("Lista empleados:");
                    listarEmpleadosEmpresa(0);
                    System.out.println("Ingrese la id del empleado a eliminar:");
                    int mIdB = input.nextInt();
                    Usuario usuB = new Usuario();

                    if(usuB.bajaUsuario( new Usuario(mIdB))){
                        System.out.println("Empleado eliminado con éxito!");
                        break;
                    }
                    else{
                        System.out.println("No se pudo eliminar el empleado");
                        break;
                    }
                case 3:
                    System.out.println("Lista empleados:");
                    listarEmpleadosEmpresa(0);
                    System.out.println("Ingrese la id del empleado a modificar:");
                    int mIdM = input.nextInt();
                    Usuario usuM = new Usuario();
                    System.out.println("Ingrese el nuevo nombre");
                    String mNombreM = input.next();
                    System.out.println("Ingrese el nuevo apellido");
                    String mApellidoM = input.next();
                    System.out.println("Ingrese la nueva edad");
                    int mEdadM = input.nextInt();
                    listarEmpresas(0);
                    System.out.println("Ingrese la id de la nueva empresa");
                    int idEmpresaM = input.nextInt();
                    if (usuM.modificarUsuario(new Usuario(mIdM, mNombreM, mApellidoM, mEdadM, idEmpresaM))) {
                        System.out.println("Empleado modificado con éxito!");
                        break;
                    }

                    System.out.println("¡El empleado no existe!");
                    break;

                case 4:
                    System.out.println("Lista empleados:");
                    listarEmpleadosEmpresa(0);
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

    public static void menuGestionFamiliaresEmpleados(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Familiares de las Empleados ꕥ");
            System.out.println("1- Agregar familiares a un empleado");
            System.out.println("2- Eliminar familiares a un empleado");
            System.out.println("3- Modificar familiares a un empleado");
            System.out.println("4- Listar familiares de un empleado");
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
                    boolean esMayor;
                    if (mEdad >= 18) {
                        esMayor = true;

                    } else {
                        esMayor = false;
                    }
                    System.out.println("Ingrese la id del usuario a Cargo: ");
                    int mUsuarioId = input.nextInt();
                    Usuario usu = new Usuario();

                    if(usu.altaFamiliar(new Familiar(mId, mNombre, mApellido, mEdad, mUsuarioId, esMayor ))) {
                        System.out.println("Familiar agregado con éxito!");
                        break;
                    }
                    System.out.println("¡No se ha podido agregar el familiar! Compruebe que no existe e intente otra vez");
                    break;
                case 2:
                    System.out.println("Lista empleados:");
                    listarEmpleadosEmpresa(0);
                    System.out.println("Ingrese la id del empleado a eliminar:");
                    int mIdB = input.nextInt();
                    Usuario usuB = new Usuario();

                    if(usuB.bajaUsuario( new Usuario(mIdB))){
                        System.out.println("Empleado eliminado con éxito!");
                        break;
                    }
                    else{
                        System.out.println("No se pudo eliminar el empleado");
                        break;
                    }
                case 3:
                    System.out.println("Lista empleados:");
                    listarEmpleadosEmpresa(0);
                    System.out.println("Ingrese la id del empleado a modificar:");
                    int mIdM = input.nextInt();
                    Usuario usuM = new Usuario();
                    System.out.println("Ingrese el nuevo nombre");
                    String mNombreM = input.next();
                    System.out.println("Ingrese el nuevo apellido");
                    String mApellidoM = input.next();
                    System.out.println("Ingrese la nueva edad");
                    int mEdadM = input.nextInt();
                    listarEmpresas(0);
                    System.out.println("Ingrese la id de la nueva empresa");
                    int idEmpresaM = input.nextInt();
                    if (usuM.modificarUsuario(new Usuario(mIdM, mNombreM, mApellidoM, mEdadM, idEmpresaM))) {
                        System.out.println("Empleado modificado con éxito!");
                        break;
                    }

                    System.out.println("¡El empleado no existe!");
                    break;

                case 4:
                    System.out.println("Lista empleados:");
                    listarEmpleadosEmpresa(0);
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

    public static void menuGestionConsultas(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Consultas ꕥ");
            System.out.println("1- Agregar consulta");
            System.out.println("2- Eliminar consulta");
            System.out.println("3- Modificar consulta");
            System.out.println("4- Listar consultas");
            System.out.println("5- Volver");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la id de la consulta:");
                    int mId = input.nextInt();
                    System.out.println("Ingrese la id de la persona: ");
                    int mIdPersona = input.nextInt();
                    System.out.println("Ingrese la id de la empresa:");
                    int mIdEmpresa = input.nextInt();
                    System.out.println("Ingrese la id del especialista:");
                    int mIdEspecialista = input.nextInt();
                    System.out.println("Ingrese la fecha y hora [dd. MM. yyyy]:");
                    LocalDate fecha = LocalDate.parse(input.next());
                    System.out.println(fecha);
                    Consulta con = new Consulta();
                    if(con.altaConsulta(new Consulta(mId, mIdPersona, mIdEspecialista, fecha, mIdEmpresa))){
                        System.out.println("Consulta agregada con éxito!");
                        break;
                    }

                    System.out.println("¡No se ha podido agregar la consulta! Compruebe que no existe e intente otra vez");
                    break;

                case 2:
                    System.out.println("Lista seguros:");
                    listarSeguros(0);
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
                    listarSeguros(0);
                    System.out.println("Ingrese la id del seguro a modificar:");
                    int mIdM = input.nextInt();
                    Seguro segM = new Seguro();
                    System.out.println("Ingrese el nuevo tipo");
                    String mTipoM = input.next();
                    System.out.println("Ingrese el nuevo tope de visitas mensual");
                    int mTopeVM = input.nextInt();
                    listarSeguros(0);

                    if (segM.modificarSeguro(new Seguro(mIdM, mTipoM,mTopeVM ))) {
                        System.out.println("Seguro modificada con éxito!");
                        break;
                    }

                    System.out.println("¡El seguro no existe!");
                    break;


                case 4:
                    System.out.println("Lista seguros:");
                    listarSeguros(0);
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

    public static void menuGestionListados(){
        Scanner input = new Scanner(System.in);
        int opcion = 1;
        do {
            System.out.println("ꕥ Gestión Listados ꕥ");
            System.out.println("1- Listar los empleados y sus familiares de una empresa");
            System.out.println("2- Listar las consultas médicas de un asegurado en un rango de fechas.");
            System.out.println("3- A partir de un asegurado listar toda la familia.");
            System.out.println("4- Listar los diferentes tipos de seguros para una empresa y la cantidad de empleados en cada uno");
            System.out.println("5- Volver");

            opcion = input.nextInt();

            switch(opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;

                case 4:
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
    public static void listarEspecialidades(int pos){
        Especialidad esp = new Especialidad();
        List<Especialidad> listaEspecialidades = esp.getListaEspecialidades();
        if(pos >= listaEspecialidades.size()){
            return;
        }
        else {
            System.out.println("Id: " + listaEspecialidades.get(pos).getId() + ". Nombre: " + listaEspecialidades.get(pos).getNombre());
            listarEspecialidades(pos+1);
        }
    }

    public static void listarEspecialistas(int pos){
        Especialista espe = new Especialista();
        List<Especialista> listaEspecialistas = espe.getListaEspecialistas();
        if(pos >= listaEspecialistas.size()){
            return;
        }
        else {
            System.out.println("Id: " + listaEspecialistas.get(pos).getId() + ". Nombre: " + listaEspecialistas.get(pos).getNombre() + ". Apellido: " + listaEspecialistas.get(pos).getApellido() + ". Especialidad: " + listaEspecialistas.get(pos).getEspecialidad().getNombre());
            listarEspecialistas(pos+1);
        }
    }

    public static void listarSeguros(int pos){
        Seguro seg = new Seguro();
        List<Seguro> listaSeguros = seg.getListaSeguros();
        if(pos >= listaSeguros.size()){
            return;
        }
        else{
            System.out.println("Id: " + listaSeguros.get(pos).getId() + ". Tipo: " + listaSeguros.get(pos).getTipo() + ". Tope de visitas mensuales: "+ listaSeguros.get(pos).getTopeVisitasMensuales());
            listarSeguros(pos+1);
        }
 }

    public static void listarEmpresas(int pos){
        Empresa empr = new Empresa();
        List<Empresa> listaEmpresas = empr.getListaEmpresas();
        if(pos >= listaEmpresas.size()){
            return;
        }
        else{
            System.out.println("Id: " + listaEmpresas.get(pos).getId() + ". Nombre: " + listaEmpresas.get(pos).getNombre());
            listarEmpresas(pos+1);
        }
    }

    public static void listarEmpleadosEmpresa(int pos){
        Usuario usu = new Usuario();
        List<Usuario> listaUsuarios = usu.getListaUsuarios();
        if(pos >= listaUsuarios.size()){
            return;
        }
        else{
            System.out.println("Id: " + listaUsuarios.get(pos).getId() + ". Nombre: " + listaUsuarios.get(pos).getNombre() + ". Apellido: " + listaUsuarios.get(pos).getApellido() + ". Empresa: " + listaUsuarios.get(pos).getEmpresa().getNombre());
            listarEmpleadosEmpresa(pos+1);
        }
    }
}
