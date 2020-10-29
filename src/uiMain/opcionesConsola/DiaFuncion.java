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
                if(funcion.isEstado()==true){
                    estado = true;
                }
            }
            if(estado==false){
                System.out.println(separador);
                System.out.println("No hay funciones disponibles para el dia seleccionado");
                System.out.println(separador);
                System.out.println(mensajeVolver);
                int volver = dato.nextInt();
                volver(volver);
                System.exit(0);
            }
        }
        System.out.println(separador);
        System.out.println("               Funciones del dia");
        System.out.println("              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        Vector<Funcion> funcionesDia = clienteActual.consultarFunciones(opcion,salaActiva);
        System.out.println(clienteActual.consultarFunciones(funcionesDia));
        System.out.println(separador);
        System.out.print("Elegir una funcion: ");
        opcion = dato.nextInt();
        funcion = funcionesDia.get(opcion-1);
        System.out.println(separador);
        System.out.println(funcion.mostrarPuestos());
        System.out.println(separador);
        System.out.print("Cuantos asientos desea reservar? ");
        int asientosAElegir = dato.nextInt();
        System.out.println(separador);
        /*En caso de que el usuario intente ingresar un numero de asiento mucho
          mayor del que hay disponibles trabajaremos con este if*/
        if(!(funcion.getPuestosVacios() >= asientosAElegir)){
            System.out.println(" El numero de asientos que intenta elegir no esta");
            System.out.println("                    disponible");
            System.out.println(separador);
            System.out.println(mensajeVolver);
            int vol = dato.nextInt();
            volver(vol);
        }
        /*En caso de que el cliente ingrese que sea reservar 0 puestos, lo capturamos aca
          y lo manejamos haciendolo volver al menu anterior o saliendo de la aplicacion*/
        if(asientosAElegir == 0){
            System.out.println("        No se pueden reservar 0 sientos");
            System.out.println(separador);
            System.out.println(mensajeVolver);
            int vol = dato.nextInt();
            volver(vol);
        }
        /*Antes de reservar los puestos preguntamos si el usuario tiene el suficiente dinero
          para reservar esa cantidad de asientos en caso contrario se ejecutara el else*/
        if(clienteActual.getCuentaBancaria().getSaldo()>= (funcion.getPrecio()*asientosAElegir)){
            Vector<Integer> puestos = new Vector<Integer>();
            for(int i=0; i<asientosAElegir; i++){
                System.out.print("Ingrese el # de asiento: ");
                int numeroPuesto = dato.nextInt();
                puestos.add(numeroPuesto);
            }
            clienteActual.reservarPuestos(puestos,funcion);
            System.out.println(separador);
            System.out.println("       Reserva hecha satisfactoriamente!!!");
            System.out.println(separador);
            System.out.println(mensajeVolver);
            opcion = dato.nextInt();
            volver(opcion);
        /*Esto se ejecutara en caso de que el cliente, no tenga el dinero suficiente para reservar
          la cantidad de puestos elegidos*/
        }else{
            System.out.println(separador);
            System.out.println("            No tienes saldo suficiente");
            System.out.println("Saldo actual: " +clienteActual.getCuentaBancaria().getSaldo());
            System.out.println("Intentando hacer una compra por: " + (funcion.getPrecio()*asientosAElegir));
            System.out.println(separador);
            System.out.println(mensajeVolver);
            opcion = dato.nextInt();
            volver(opcion);
        }
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
