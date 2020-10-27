package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

public class Puntos implements OpcionConsola{
    Cliente clienteActual = new Cliente();
    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        System.out.println(separador);
        System.out.println("Cliente: "+clienteActual.getNombre());
        System.out.println("Su saldo actual es de: "+clienteActual.getCuentaBancaria().getSaldo());
        System.out.println("Su cantidad de puntos son: "+clienteActual.getCuentaPuntos().getPuntos());
    }

    @Override
    public void volver(int opcion) {

    }
}
