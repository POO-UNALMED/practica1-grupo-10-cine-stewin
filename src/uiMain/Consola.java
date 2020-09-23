package uiMain;

import gestorAplicacion.master.Admin;

import java.util.Scanner;

/*En esta clase se van a trabajar todos los metodos que se
encarguen de mostrar interacciones en la consola*/
public class Consola {
    public static Scanner scanner = new Scanner(System.in);

    /*Me aburri de estar pegando esos espacios en todos lados,
    asi que cree un metodo para estandarizarlos*/
    public static void Separador(){
        System.out.println("================================================");
    }

    //Metodo que imprime la pantalla de inicio del programa
    public static void PantallaInicio() {
        Separador();
        System.out.println("1* Ingresar como cliente");
        System.out.println("2* Ingresar como empleado");
        System.out.println("3* Registrarse");
        System.out.println("4* Salir");
        Separador();
        Admin.DatosInicio();
    }

    //Metodo que imprime la pantalla de registro
    public static void PantallaRegistrar() {
        Separador();
        System.out.print("Por favor ingrese su numero de identificacion: ");
        int identificacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Por favor ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Por favor ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Por favor ingrese su direccion: ");
        String direccion = scanner.nextLine();
        System.out.print("Por favor ingrese su contraseña: ");
        String contrasenia = scanner.nextLine();
        Admin.RegistarCliente(identificacion, nombre, correo, direccion, contrasenia);
        Separador();
        System.out.println("Usuario " + nombre + " registrado satisfactoriamente");
        Separador();
    }

    //Metodo que imprime la pantalla para ingresar como cliente
    public static void PantallaIngresoCliente(){
        Separador();
        System.out.print("Por favor ingrese su numero de identificacion: ");
        int identificacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Por favor ingrese su contraseña: ");
        String contrasenia = scanner.nextLine();
        Separador();
        //Comprobamos si el usuario y contraseña existen en la base de datos
        if(Admin.ComprobarRegistro(identificacion, contrasenia)){
            /*Llamar funcion que me lleva a todas las funciones que puede tener el cliente*/
            PantallaCliente();
        }else{
            /*Llamar funcion que me da error y pide datos de nuevo o devolverse*/
        }
    }

    //Metodo que imprime la pantalla cuando se ingresa como cliente
    public static void PantallaCliente(){
        System.out.println("1* Consultar salas de cine");
        System.out.println("2* ");
        System.out.println("3* ");
        System.out.println("4* ");
        System.out.println("5* ");
        System.out.println("6* Volver");
        Separador();
        int i = scanner.nextInt();
        switch(i){
            case 1:
                //Metodo que se ejecuta al llamar la opcion 1
                ConsultarSalasCine();
                break;
            case 2:
                //Metodo que se ejecuta al llamar la opcion 2
                break;
            case 3:
                //Metodo que se ejecuta al llamar la opcion 3
                break;
            case 4:
                //Metodo que se ejecuta al llamar la opcion 4
                break;
            case 5:
                //Metodo que se ejecuta al llamar la opcion 5
                break;
            case 6:
                //Metodo que se ejecuta al llamar la opcion 6
                PantallaInicio();
                break;
        }

    }


    //Metodo que muestra las salas de cine en el pais
    public static void ConsultarSalasCine(){
        Separador();
        System.out.println("Aun no he puesto nada aca :v ");
        Separador();
    }
}
