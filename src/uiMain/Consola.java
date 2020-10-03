package uiMain;


import gestorAplicacion.master.Admin;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Persona;

import java.util.Scanner;

/*En esta clase se van a trabajar todos los metodos que se
encarguen de mostrar interacciones en la consola*/

public class Consola {
    private static Cliente user = new Cliente();
    public static Admin admin;
    public static Scanner scanner = new Scanner(System.in);

    //Constructor de consola
    public Consola() {
        Admin.setConsola(this);
    }

    //Separador para la pantalla
    public static void Separador(){
        System.out.println("================================================");
    }

    //Metodo que imprime la pantalla de inicio del programa
    public void PantallaInicio() {
        Separador();
        System.out.println("1* Ingresar como cliente");
        System.out.println("2* Ingresar como empleado");
        System.out.println("3* Registrarse");
        System.out.println("4* Salir");
        Separador();
        DatosInicio();
    }

    //Metodo para mostrar la pantalla de inicio del programa
    public void DatosInicio() {
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                //Llamar funcion para ingresar como usuario;
                PantallaIngresoCliente();
                //Consola.PantallaIngresoCliente();
                break;
            case 2:
                //Llamar funcion para ingresar como empleado;
                break;
            case 3:
                //Llamar funcion para registrarse
                PantallaRegistrar();
                break;
            case 4:
                //Lamar funcion para salir
                Separador();
                System.out.println("Se ha finalizado sesion");
                Separador();
                System.exit(1);
        }
    }
    //Metodo que imprime la pantalla cuando se ingresa como cliente
    public void PantallaIngresoCliente(){
        Separador();
        System.out.print("Por favor ingrese su numero de identificacion: ");
        int identificacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Por favor ingrese su contraseña: ");
        String contrasenia = scanner.nextLine();
        Separador();
        //Comprobamos si el usuario y contraseña existen en la base de datos
        try{
            if(user.ComprobarRegistro(identificacion, contrasenia)) {
                /*Llamar funcion que me lleva a todas las funciones que puede tener el cliente*/
                PantallaCliente();
            }else{
                /*Llamar funcion que me da error y pide datos de nuevo o devolverse*/
                System.out.println("Usuario y contraseña incorrectas");
            }
        }catch(Exception e){
            //En caso de que no hayan usuarios registrados toca llamar esta funcion
            System.out.println("No hay usuarios registrados");
        }

    }
    //Metodo que imprime la pantalla cuando se ingresa como cliente
    public void PantallaCliente(){
        System.out.println("1* ");
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
    //Metodo que imprime la pantalla de registro
    public void PantallaRegistrar() {
        try{
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
            user.RegistarCliente(identificacion, nombre, correo, direccion, contrasenia);
            Separador();
            System.out.println("Usuario " + nombre + " registrado satisfactoriamente");
            Separador();
        }catch(Exception e){
            //En caso de que ingrese un valor que no es valido
            System.out.println("Ha ingresado un dato que no es valido, por favor intentelo de nuevo");
        }
    }
}
