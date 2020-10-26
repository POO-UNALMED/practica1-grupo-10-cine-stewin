package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

public class ConsultarReservas implements OpcionConsola{
    Cliente clienteActual = new Cliente();


    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        System.out.println(separador);
        System.out.println("Revervas del usuario");
        System.out.println(separador);
        System.out.println(clienteActual.consultarReservas());

    }

    @Override
    public void volver(int opcion) {

    }
}
