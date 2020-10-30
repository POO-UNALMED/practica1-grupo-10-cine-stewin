package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

import java.util.Vector;

public class ConsultarReservas implements OpcionConsola{
    Cliente clienteActual = new Cliente();

    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        System.out.println(separador);
        System.out.println(clienteActual.consultarReservas());
        //Aca----------------
        System.out.println(separador);

        //añadiendo codigo desde aca Alejandro
        //System.out.println(mensajeVolver);
        System.out.println("1. Cambiar Reserva\n"+"2. Volver\n" +"3. Salir");
        //Acaaaaaaa------------------------
        System.out.println(separador);
        System.out.print("Ingrese la opcion deseada: ");
        int opcion = dato.nextInt();
        System.out.println(separador);
        //volver(opcion);

        if(opcion==1){
            System.out.println(empleado.funcionesDisponibles(clienteActual));
            System.out.println(separador);
            System.out.println("Por favor ingrese el # de la reserva a cambiar:  ");
            int opcion1 = dato.nextInt();
            System.out.println(separador);
            if(empleado.probarFuncion(opcion1, clienteActual)){
                System.out.println("Funcion no encontrada.");
                ejecutar();
            }else{
                System.out.println("usted cuenta con "+empleado.numeroDeAsientos(clienteActual,opcion1)+" asiento(s) para esta funcion.");
                empleado.vaciarReserva(clienteActual.cartera.get(opcion1).getFuncion(),clienteActual.cartera.get(opcion1).getAsientosElegidos());
                System.out.println(separador);
                System.out.println(clienteActual.cartera.get(opcion1).getFuncion().mostrarPuestos());
                System.out.println(separador);
                Vector<Integer> puestosNuevos = new Vector<>();
                for(int i=0; i<empleado.numeroDeAsientos(clienteActual,opcion1); i++){
                    System.out.print("Ingrese el # de asiento que desea: ");
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
