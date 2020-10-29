package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

import java.util.Vector;

public class ConsultarReservas implements OpcionConsola{
    Cliente clienteActual = new Cliente();

    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        System.out.println(separador);
        System.out.println("Consultar reservas");
        System.out.println(separador);
        System.out.println(clienteActual.consultarReservas());
        //Aca----------------
        System.out.println(separador);

        //añadiendo codigo desde aca Alejandro
        //System.out.println(mensajeVolver);
        System.out.println("         Opciones:\n" +
                "1. Cabiar Reserva\n"+"2. Volver\n" +"3. Salir\n");
        //Acaaaaaaa------------------------
        System.out.println(separador);
        int opcion = dato.nextInt();
        System.out.println(separador);
        //volver(opcion);

        if(opcion==1){
            System.out.println(clienteActual.getCartera());
            System.out.println("Que numero de funcion funcion desea cambiar?: ");
            int opcion1 = dato.nextInt();
            if(empleado.probarFuncion(opcion1, clienteActual)){
                System.out.println("Funcion no encontrada.");
                ejecutar();
            }else{
                System.out.println("usted cuenta con "+empleado.numeroDeAsientos(clienteActual,opcion1)+" asiento(s) para esta funcion.");
                empleado.vaciarReserva(clienteActual.cartera.get(opcion1).getFuncion(),clienteActual.cartera.get(opcion1).getAsientosElegidos());
                System.out.println(separador);
                System.out.println(clienteActual.cartera.get(opcion1).getFuncion().mostrarPuestos());
                System.out.println(separador);
                Vector<Integer> puestosNuevos = new Vector<Integer>();
                for(int i=0; i<empleado.numeroDeAsientos(clienteActual,opcion1); i++){
                    System.out.print("Ingrese el # de asiento: ");
                    int numeroPuesto = dato.nextInt();
                    puestosNuevos.add(numeroPuesto);
                }
                empleado.cambiarPuestos(clienteActual.cartera.get(opcion1).getFuncion(),puestosNuevos);
                clienteActual.cartera.get(opcion1).setAsientosElegidos(puestosNuevos);
                System.out.println(separador);
                System.out.println(clienteActual.cartera.get(opcion1).getFuncion().mostrarPuestos());
                System.out.println(separador);
                System.out.println("Cambios hechos satisfactoriamente.");
                ejecutar();

            }
        }
        volver(opcion);
    }
    //hasta aca

    @Override
    public void volver(int opcion) {
        //Aca-----------------------
        if(opcion == 2){
            System.out.println(separador);
            ingresoUsuario.ejecutar();
            System.exit(0);
        }else{
            salir.ejecutar();
        }
    }
}
