package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;
import uiMain.Inicio;

public class UsuarioRegistrado implements OpcionConsola{
    int opcion;
    Cliente cliente = new Cliente();
    Salir salir = new Salir();
    IngresoUsuario ingresoUsuario = new IngresoUsuario();
    StringBuilder mensaje = new StringBuilder();
    int identificacion;
    {
        mensaje.append(separador+ "\n")
                .append("Por favor ingrese su identificacion: ");
    }
    @Override
    public void ejecutar() {
        System.out.print(mensaje.toString());
        identificacion = dato.nextInt();
        dato.nextLine();
        System.out.println(separador);
        if(cliente.ComprobarRegistro(identificacion)){
            System.out.println("          Ingreso satisfactorio");
            System.out.println("                Bienvenido");
            System.out.println(separador);
            ingresoUsuario.ejecutar();
        }else{
            System.out.println("Usuario no identificado en la base de datos");
            System.out.println(separador);
            System.out.println(mensajeVolver);
            opcion = dato.nextInt();
            volver(opcion);
        }

    }

    @Override
    public void volver(int opcion) {
        if(opcion == 1){
            Inicio.main(null);
        }else{
            salir.ejecutar();
        }
    }
}
