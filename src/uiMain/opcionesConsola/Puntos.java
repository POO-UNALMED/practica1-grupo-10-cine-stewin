package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

import java.sql.SQLOutput;

public class Puntos implements OpcionConsola{
    Cliente clienteActual = new Cliente();
    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        System.out.println(separador);
        System.out.println("Cliente: "+clienteActual.getNombre());
        System.out.println("Su saldo actual es de: "+clienteActual.getCuentaBancaria().getSaldo());
        System.out.println("Su cantidad de puntos son: "+clienteActual.getCuentaPuntos().getPuntos());
        System.out.println("");
        System.out.println("Ingrese la opcion deseada: ");
        System.out.println("1. Canjear comida");
        System.out.println("2. Canjear reservas");
        System.out.println("3. Volver");
        System.out.println(separador);
        int opcion1 = dato.nextInt();
        if(opcion1 == 1){
            System.out.println(separador);
            System.out.println("Opciones de comida disponibles y sus precios en [dinero($) || puntos(P)]: ");
            System.out.println("1. Palomitas de Maiz  - $6000 || 2000P");
            System.out.println("2. Cocaina            - $5000 || 1700P");
            System.out.println("3. Recarga de Gaseosa - $2000 || 700P ");
            System.out.println("4. Perro Caliente     - $7000 || 2300P");
            System.out.println("5. Atrás");
            System.out.println("Ingrese la opcion deseada: ");
            System.out.println(separador);
            int opcionComida = dato.nextInt();
            System.out.println(separador);
            System.out.println("1. dinero");
            System.out.println("2. puntos");
            System.out.println("Eliga el método de pago deseado: ");
            System.out.println(separador);
            int metodoPago = dato.nextInt();

            switch (opcionComida){
                case 1:
                    if(metodoPago == 1){
                        empleado.transaccionDinero(clienteActual, 6000);
                        break;
                    }
                    if(metodoPago == 2){
                        empleado.transaccionPuntos(clienteActual, 2000);
                        break;
                    }
                case 2:
                    if(metodoPago == 1){
                        empleado.transaccionDinero(clienteActual, 5000);
                        break;
                    }
                    if(metodoPago == 2){
                        empleado.transaccionPuntos(clienteActual, 1700);
                        break;
                    }
                case 3:
                    if(metodoPago == 1){
                        empleado.transaccionDinero(clienteActual, 2000);
                        break;
                    }
                    if(metodoPago == 2){
                        empleado.transaccionPuntos(clienteActual, 700);
                        break;
                    }
                case 4:
                    if(metodoPago == 1){
                        empleado.transaccionDinero(clienteActual, 7000);
                        break;
                    }
                    if(metodoPago == 2){
                        empleado.transaccionPuntos(clienteActual, 2300);
                        break;
                    }
                case 5:
                    ejecutar();
                    break;
            }
            ejecutar();
        }
        if(opcion1 == 2){
            System.out.println(separador);
            System.out.println("todavia falta esto xd");
        }
        if(opcion1 == 3){
            volver(1);
        }
        //System.out.println("Aun no se que mas se puede agregar aca (Por el momento)");
        //Aca--------------

    }

    @Override
    public void volver(int opcion) {
        //Aca-----------
        if(opcion == 1){
            System.out.println(separador);
            ingresoUsuario.ejecutar();
            System.exit(0);
        }
        else{
            salir.ejecutar();
        }
    }
}
