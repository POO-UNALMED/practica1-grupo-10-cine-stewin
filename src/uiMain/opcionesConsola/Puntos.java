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
        System.out.println("Aun no se que mas se puede agregar aca (Por el momento)");
        //Aca--------------
        System.out.println(separador);
        System.out.println(mensajeVolver);
        int opcion = dato.nextInt();
        volver(opcion);
    }

    @Override
    public void volver(int opcion) {
        //Aca-----------
        if(opcion == 1){
            System.out.println(separador);
            ingresoUsuario.ejecutar();
            System.exit(0);
        }else{
            salir.ejecutar();
        }
    }
}
