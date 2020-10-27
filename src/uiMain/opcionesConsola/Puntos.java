package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

public class Puntos implements OpcionConsola{
    @Override
    public void ejecutar() {
        System.out.println(Cliente.getClienteActual().getCuentaBancaria().getSaldo());
    }

    @Override
    public void volver(int opcion) {

    }
}
