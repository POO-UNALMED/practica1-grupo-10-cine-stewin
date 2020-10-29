package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

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
                "1. Cabiar Reserva\n"+"2. Volver\n" +"3. Salir\n"+ "==================================================");
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
                int opcion2 = dato.nextInt();
                if(empleado.confirmar(clienteActual,opcion2)){
                    System.out.println("numero invalido.");
                    ejecutar();
                }else{


                }

            }
        }
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
