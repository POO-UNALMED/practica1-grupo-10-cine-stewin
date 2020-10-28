package uiMain.opcionesConsola;
import gestorAplicacion.master.Empleado;
import uiMain.Inicio;

/*Esta clase es la encargada de mostrar la pantalla para registrar usuarios*/
public class UsuarioNoRegistrado implements OpcionConsola{
    int opcion;

    @Override
    public void ejecutar() {
        System.out.println(separador);
        System.out.print("Por favor ingrese su numero de identificacion: ");
        int identificacion = dato.nextInt();
        dato.nextLine();
        System.out.print("Por favor ingrese su nombre: ");
        String nombre = dato.nextLine();
        System.out.print("Por favor ingrese su correo: ");
        String correo = dato.nextLine();
        System.out.print("Por favor ingrese su direccion: ");
        String direccion = dato.nextLine();
        System.out.println(separador);
        if((empleado.comprobarIdentificacion(identificacion))){
            System.out.println("               El usuario ya existe");
            System.out.println(separador);
            System.out.println(mensajeVolver);
            System.out.println("Hola?");
        }
        //Aca debo registrar al usuario en la base de datos
        Empleado.registarCliente(identificacion, nombre, correo, direccion);
        System.out.println("       Usuario registrado satisfactoriamente");
        System.out.println(separador);
        System.out.println(mensajeVolver);
        opcion = dato.nextInt();
        volver(opcion);
    }
    @Override
    public void volver(int opcion) {
        if(opcion == 1){
            Inicio.main(null);
            System.exit(0);
        }else{
            salir.ejecutar();
        }
    }
}
