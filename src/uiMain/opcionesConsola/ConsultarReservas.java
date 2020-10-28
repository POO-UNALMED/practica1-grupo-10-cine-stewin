package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

public class ConsultarReservas implements OpcionConsola{
    Cliente clienteActual = new Cliente();
    int opcion;


    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        System.out.println(separador);
        System.out.println("Consultar reservas");
        System.out.println(separador);
        System.out.println(clienteActual.consultarReservas());
        //Aca----------------
        System.out.println(separador);
        System.out.println(mensajeVolver);
        //Acaaaaaaa------------------------
        int opcion = dato.nextInt();
        volver(opcion);

    }

    @Override
    public void volver(int opcion) {
        //Aca-----------------------
        if(opcion == 1){
            System.out.println(separador);
            ingresoUsuario.ejecutar();
            System.exit(0);
        }else{
            salir.ejecutar();
        }
    }
}
