package uiMain.opcionesConsola;

import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Empleado;
import gestorAplicacion.master.Funcion;
import gestorAplicacion.usuario.Cliente;
import uiMain.Inicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class DiaFuncion implements OpcionConsola{
    static Cine salaActiva;
    int opcion;
    Empleado empleado = new Empleado();
    Cliente clienteActual = new Cliente();
    Funcion funcion = new Funcion();
    int asientosAElegir;
    int opcionpago;
    int recarga;
    String din;

    @Override
    public void ejecutar() {
        LocalDate fechaHoy = LocalDate.now();
        int contador = 0;
        StringBuilder s = new StringBuilder();
        clienteActual = Cliente.getClienteActual();
        for(int i = 0; i <7;i++){
            s.append(contador+". ").append(fechaHoy.format(DateTimeFormatter.ofPattern("d/M/yyyy")) + "\n");
            contador++;
            fechaHoy = fechaHoy.plusDays(1);
        }
        s.delete(s.length()-1,s.length());
        System.out.println(s);
        System.out.println(separador);
        System.out.print("Elija el dia que desea reservar: ");
        opcion = dato.nextInt();
        boolean estado = false;
        if(opcion==0){
            for(Funcion funcion:salaActiva.getFunciones().get(0)){
                if(funcion.isEstado()==false){
                    estado = true;
                }
            }
            if(estado){
                System.out.println(separador);
                System.out.println("     No hay funciones disponibles para el dia");
                System.out.println("                   Seleccionado");
                System.out.println(separador);
                System.out.println(mensajeVolver);
                int volver = dato.nextInt();
                volver(volver);
                System.exit(0);
            }
        }
        System.out.println(separador);//System.out.println("               Funciones del dia");
        //System.out.println("              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("       Funciones del día y sus precios en:");
        System.out.println("            [dinero($) || puntos(P)]\n");
        Vector<Funcion> funcionesDia = clienteActual.consultarFunciones(opcion,salaActiva);
        System.out.println(clienteActual.consultarFunciones(funcionesDia));
        System.out.println(separador);
        System.out.print("Elegir una funcion: ");
        opcion = dato.nextInt();
        funcion = funcionesDia.get(opcion-1);
        System.out.println(separador);



        //System.out.println(funcion.mostrarPuestos());
        //System.out.println(separador);
        //System.out.print("Cuantos asientos desea reservar? ");
        System.out.print("Puedes reservar de 1 a "+ funcion.getPuestosVacios() + " asientos. Cuantos asientos desea reservar? ");
        asientosAElegir = dato.nextInt();
        System.out.println(separador);

        //Debe elegir solo una cantidad de asientos permitida
        while ((asientosAElegir>funcion.getPuestosVacios()) || (asientosAElegir<1)){
            System.out.println(" El numero de asientos que intenta elegir no esta disponible");
            System.out.println(" Elige entre 1 a "+ funcion.getPuestosVacios() +" asientos vacios:");
            asientosAElegir = dato.nextInt();
            System.out.println(separador);
        }

        //clienteActual.getCuentaBancaria().setSaldo(1000);
        //clienteActual.getCuentaPuntos().setPuntos(1000);

        //Selección del tipo de pago
        System.out.println("       Saldo en los metodos de pagos disponibles:");
        System.out.println("     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
        System.out.println("1. Cuenta bancaria - Saldo: $" + clienteActual.getCuentaBancaria().getSaldo());
        System.out.println("2. Cuenta Puntos - Saldo: " + clienteActual.getCuentaPuntos().getPuntos()+ "P");
        System.out.println(separador);
        System.out.print("Selecciona el tipo de pago que emplearas: ");
        opcionpago = dato.nextInt();
        System.out.println(separador);

        //Verificamos que el metodo de pago elegido tenga saldo disponible

        int valorreserva = funcion.getPrecio()*asientosAElegir;
        int valorreservap = funcion.getPrecioP()*asientosAElegir;
        int saldoactual = clienteActual.getCuentaBancaria().getSaldo();
        int saldoactualp = clienteActual.getCuentaPuntos().getPuntos();
        int minimo = valorreserva - saldoactual;

        //Validación de saldo en cuenta bancaria
        if (opcionpago == 1){
            if( saldoactual >= valorreserva ){
                opcionpago = 1;
                System.out.println("Bien. Tu saldo es de: $"+ saldoactual+" y las boletas cuestan $"+valorreserva);
                System.out.println(separador);
            }
            else {
                if (saldoactualp >= valorreservap) {
                    System.out.println("       No cuentas con saldo disponible en tu ceunta bancaria:");
                    System.out.println("     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.println("       Pero puedes:\n");
                    System.out.println("       1. Utilizar tus puntos, te alcanza!");
                    System.out.println("       2. Recargar tu cuenta bancaria, minimo: $" + minimo);
                    System.out.println("       3. Cancelar compra, y volver al menu de usuario");
                    System.out.println(separador);
                    System.out.print("¿Que deseas hacer? ");
                    opcionpago = dato.nextInt();
                    System.out.println(separador);

                    if (opcionpago == 1) {
                        opcionpago = 2;
                    }

                    if (opcionpago == 2) {
                        System.out.print("¿Cuanto deseas recargarle? ");
                        recarga = dato.nextInt();
                        while ((recarga + saldoactual) < valorreserva) {
                            System.out.println("Con la recarga no alcaza para comprar las boletas");
                            System.out.println("Por favor aumenta la recarga, minimo $" + minimo);
                            System.out.println(separador);
                            recarga = dato.nextInt();
                        }
                        String saldof = empleado.recargarCuentaBancaria(clienteActual, recarga);
                        System.out.println(separador);
                        System.out.println(saldof);
                        System.out.println(separador);
                        opcionpago = 1;
                    } else {
                        volver(1);
                    }
                }
                if (saldoactualp <= valorreservap) {
                    System.out.println("       No cuentas con saldo disponible en tu cuenta bancaria ni en puntos:");
                    System.out.println("     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.println("       Pero puedes:\n");
                    System.out.println("       1. Recargar tu cuenta bancaria, minimo: $" + minimo);
                    System.out.println("       2. Cancelar compra, y volver al menu de usuario");
                    System.out.println(separador);
                    System.out.print("¿Que deseas hacer? ");
                    opcionpago = dato.nextInt();
                    System.out.println(separador);

                    if (opcionpago == 1) {
                        System.out.print("¿Cuanto deseas recargarle? ");
                        recarga = dato.nextInt();
                        while ((recarga + saldoactual) < valorreserva) {
                            System.out.println("Con la recarga no alcaza para comprar las boletas");
                            System.out.println("Por favor aumenta la recarga, minimo $" + minimo);
                            System.out.println(separador);
                            recarga = dato.nextInt();
                        }
                        String saldof = empleado.recargarCuentaBancaria(clienteActual, recarga);
                        System.out.println(separador);
                        System.out.println(saldof);
                        System.out.println(separador);
                        opcionpago = 1;
                    }

                    else{
                        volver(1);
                    }
                }
            }
        }
        //Validación de saldo en cuenta puntos
        if (opcionpago == 2) {
            if( saldoactualp >= valorreservap ){
                System.out.println("Bien. Tu saldo es de: "+ saldoactualp+"P y las boletas cuestan "+valorreservap+"P");
                System.out.println(separador);
                opcionpago = 2;
            }
            else{
                if( saldoactual >= valorreserva ){

                    System.out.println("       No cuentas con saldo disponible en tu cuenta de puntos:");
                    System.out.println("     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.println("       Pero puedes:\n");
                    System.out.println("       1. Utilizar tu cuenta bancaria");
                    System.out.println("       2. Cancelar compra, y volver al menu de usuario");
                    System.out.println(separador);
                    System.out.print("¿Que deseas hacer? ");
                    opcionpago = dato.nextInt();
                    System.out.println(separador);

                    if (opcionpago==1){
                        System.out.println("Bien. Tu saldo es de: $"+ saldoactual+" y las boletas cuestan $"+valorreserva);
                        System.out.println(separador);
                        opcionpago = 1;
                    }
                    else {
                        volver(1);
                    }

                }
                if( saldoactual <= valorreserva ){
                    System.out.println("       No cuentas con saldo disponible en tu cuenta bancaria ni en puntos:");
                    System.out.println("     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    System.out.println("       Pero puedes:\n");
                    System.out.println("       1. Recargar tu cuenta bancaria, minimo: $" + minimo);
                    System.out.println("       2. Cancelar compra, y volver al menu de usuario");
                    System.out.println(separador);
                    System.out.print("¿Que deseas hacer? ");
                    opcionpago = dato.nextInt();
                    System.out.println(separador);

                    if (opcionpago == 1) {
                        System.out.print("¿Cuanto deseas recargarle? ");
                        recarga = dato.nextInt();
                        while ((recarga + saldoactual) < valorreserva) {
                            System.out.println("Con la recarga no alcaza para comprar las boletas");
                            System.out.println("Por favor aumenta la recarga, minimo $" + minimo);
                            System.out.println(separador);
                            recarga = dato.nextInt();
                        }
                        String saldof = empleado.recargarCuentaBancaria(clienteActual, recarga);
                        System.out.println(separador);
                        System.out.println(saldof);
                        System.out.println(separador);
                        opcionpago = 1;
                    }

                    else{
                        volver(1);
                    }
                }
            }
        }


        //Mostrar los puestos a escoger, sabiendo que ya se puede pagar:

        System.out.println(funcion.mostrarPuestos());
        System.out.println(separador);
        Vector<Integer> puestos = new Vector<Integer>();
        for(int i=0; i<asientosAElegir; i++){
            System.out.print("Ingrese el # de asiento: ");
            int numeroPuesto = dato.nextInt();
            puestos.add(numeroPuesto);
        }


        if(opcionpago==1){
            clienteActual.reservarPuestos(puestos,funcion);
            din = empleado.transaccionDinero(clienteActual, valorreserva);
            din = din + "\n        Tu nuevo saldo es: $"+clienteActual.getCuentaBancaria().getSaldo();
            din = din + "\n        Tus nuevos puntos son: "+clienteActual.getCuentaPuntos().getPuntos()+"P";
        }
        if(opcionpago==2){
            clienteActual.reservarPuestos(puestos,funcion,1);
            din = empleado.transaccionPuntos(clienteActual, valorreservap);
            din = din + "\n       Tu saldo es: $"+clienteActual.getCuentaBancaria().getSaldo();
            din = din + "\n       Tus nuevos puntos son: "+clienteActual.getCuentaPuntos().getPuntos()+"P";
        }

        System.out.println(separador);
        System.out.println(din);
        System.out.println("       \n\n¡¡¡Reserva hecha satisfactoriamente!!!");
        System.out.println(separador);
        System.out.println(mensajeVolver);
        opcion = dato.nextInt();
        volver(opcion);




    }

    @Override
    public void volver(int opcion) {
        if(opcion == 1){
            //Aca------------
            System.out.println(separador);
            ingresoUsuario.ejecutar();
            System.exit(0);
        }else{
            salir.ejecutar();
        }
    }
}
