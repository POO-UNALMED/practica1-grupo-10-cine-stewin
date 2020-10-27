package uiMain.opcionesConsola;
import gestorAplicacion.master.Empleado;
import gestorAplicacion.usuario.Cliente;
import uiMain.Inicio;

public class UsuarioNoRegistrado implements OpcionConsola{
    int opcion;
    StringBuilder mensaje = new StringBuilder();
    {
        mensaje.append("       Usuario registrado satisfactoriamente\n");
    }
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
        mensaje.append(separador);
        //Aca debo registrar al usuario en la base de datos
        Empleado.registarCliente(identificacion, nombre, correo, direccion);
        System.out.println(mensaje.toString());
        //mensaje.setLength(0); --------------- De esta forma puedo borrar lo que esta inscrito en el string
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
