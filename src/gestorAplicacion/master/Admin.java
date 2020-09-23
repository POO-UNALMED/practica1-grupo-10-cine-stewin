package gestorAplicacion.master;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Persona;
import uiMain.Consola;

import java.util.Scanner;
import java.util.Vector;

public class Admin {
    //Atributos de clase****
    private static Vector<Cliente> clientes = new Vector<>(); /*Aca se guardaran todos los clientes
                                                                       Para su posterior uso*/


    //Contructores de clase****
    //Solo me interesa el constructores por defecto (Por el momento)

    //Metodos GET and SET****
    public static Vector<Cliente> getClientes() {
        return clientes;
    }

    //Metodos de clase****
    //Metodo para agregar clientes en el atributo CLIENTES
    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
    }


    //Metodo para mostrar la pantalla de inicio del programa
    public static void DatosInicio() {
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                //Llamar funcion para ingresar como usuario;
                Consola.PantallaIngresoCliente();
                break;
            case 2:
                //Llamar funcion para ingresar como empleado;
                break;
            case 3:
                //Llamar funcion para registrarse
                Consola.PantallaRegistrar();
                break;
            case 4:
                Consola.Separador();
                System.out.println("Se ha finalizado sesion");
                Consola.Separador();
                System.exit(1);

        }
    }

    //Metodo para registrar clientes
    public static void RegistarCliente(int identificacion, String nombre, String correo, String direccion, String contrasenia) {
        Cliente a = new Cliente(identificacion, nombre, correo, direccion, contrasenia);
        //Agregar cliente al vector <CLIENTES>
        Admin.addCliente(a);
    }

    //Metodo que comprueba la identificacion/contraseña para entrar
    public static boolean ComprobarRegistro(int identificacion, String contrasenia) {
        boolean confirmaContrasenia = false;
        for (int i = 0; i < Admin.getClientes().size(); i++) {
            if(Admin.getClientes().get(i).getContrasenia().equals(contrasenia) &&
                    Admin.getClientes().get(i).getIdentificacion() == identificacion){
                confirmaContrasenia = true;
                Persona.setNumeroDeUsuario(i); /*De esta forma podemos obtener los datos
                en los otros vectores*/
            }
        }
        return confirmaContrasenia;
    }


}
