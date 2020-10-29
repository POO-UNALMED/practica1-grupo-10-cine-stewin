package uiMain.opcionesConsola;

import gestorAplicacion.usuario.Cliente;

import java.sql.SQLOutput;

public class Puntos implements OpcionConsola {
    Cliente clienteActual = new Cliente();

    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        System.out.println("Cliente: " + clienteActual.getNombre());
        System.out.println("Su saldo actual es de: " + clienteActual.getCuentaBancaria().getSaldo());
        System.out.println("Su cantidad de puntos son: " + clienteActual.getCuentaPuntos().getPuntos());
        System.out.println(separador);
        System.out.println("1. Canjear comida");
        System.out.println("2. Canjear reservas");
        System.out.println("3. Volver");
        System.out.println(separador);
        System.out.print("Ingrese la opcion deseada: ");
        int opcion1 = dato.nextInt();
        /*Si la opcion del usuario es la 1, entramos a este menu a canjear la comida*/
        if (opcion1 == 1) {
            System.out.println(separador);
            System.out.println(" Opciones de comida disponibles y sus precios en");
            System.out.println("            [dinero($) || puntos(P)]\n");
            System.out.println("1. Palomitas de Maiz  - $6000 || 2000P");
            System.out.println("2. Chocolatina        - $5000 || 1700P");
            System.out.println("3. Recarga de Gaseosa - $2000 || 700P ");
            System.out.println("4. Perro Caliente     - $7000 || 2300P");
            System.out.println("5. Atrás");
            System.out.println(separador);
            System.out.print("Ingrese la opcion deseada: ");
            int opcionComida = dato.nextInt();
            System.out.println(separador);
            /*Si el usuario ingresa a la opcion numero 5 se devolvera y se le mostraran de nuevo
              nuevo las opciones de este menu*/
            if(opcionComida == 5){
                ejecutar();
                System.exit(0);
            }
            /*En caso contrario(De que haya elegido alguna otra opcion, continuara a ejecutar
              este menu)*/
            System.out.println("1. Dinero");
            System.out.println("2. Puntos");
            System.out.println(separador);
            System.out.println("Eliga el método de pago deseado: ");
            int metodoPago = dato.nextInt();
            System.out.println(separador);

            switch (opcionComida) {
                case 1:
                    if (metodoPago == 1) {
                        empleado.transaccionDinero(clienteActual, 6000);
                        break;
                    }
                    if (metodoPago == 2) {
                        empleado.transaccionPuntos(clienteActual, 2000);
                        break;
                    }
                case 2:
                    if (metodoPago == 1) {
                        empleado.transaccionDinero(clienteActual, 5000);
                        break;
                    }
                    if (metodoPago == 2) {
                        empleado.transaccionPuntos(clienteActual, 1700);
                        break;
                    }
                case 3:
                    if (metodoPago == 1) {
                        empleado.transaccionDinero(clienteActual, 2000);
                        break;
                    }
                    if (metodoPago == 2) {
                        empleado.transaccionPuntos(clienteActual, 700);
                        break;
                    }
                case 4:
                    if (metodoPago == 1) {
                        empleado.transaccionDinero(clienteActual, 7000);
                        break;
                    }
                    if (metodoPago == 2) {
                        empleado.transaccionPuntos(clienteActual, 2300);
                        break;
                    }
            }
            ejecutar();
        }
        if (opcion1 == 2) {
            System.out.println(separador);
            System.out.println("todavia falta esto xd");
        }
        if (opcion1 == 3) {
            volver(1);
        }
        //System.out.println("Aun no se que mas se puede agregar aca (Por el momento)");
        //Aca--------------

    }

    @Override
    public void volver(int opcion) {
        //Aca-----------
        if (opcion == 1) {
            System.out.println(separador);
            ingresoUsuario.ejecutar();
            System.exit(0);
        } else {
            salir.ejecutar();
        }
    }
}
