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
    StringBuilder s = new StringBuilder();
    int contador = 0;
    LocalDate fechaHoy = LocalDate.now();
    Empleado empleado = new Empleado();
    Cliente clienteActual = new Cliente();
    Funcion funcion = new Funcion();
    {

    }
    @Override
    public void ejecutar() {
        clienteActual = Cliente.getClienteActual();
        for(int i = 0; i <7;i++){
            s.append(contador+". ").append(fechaHoy.format(DateTimeFormatter.ofPattern("d/M/yyyy")) + "\n");
            contador++;
            this.fechaHoy = fechaHoy.plusDays(1);
        }
        s.delete(s.length()-1,s.length());
        System.out.println(s);
        System.out.println(separador);
        System.out.print("Elija el dia que desea reservar: ");
        opcion = dato.nextInt();
        System.out.println(separador);
        System.out.println("               Funciones del dia");
        System.out.println("              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        Vector<Funcion> funcionesDia = clienteActual.consultarFunciones(opcion,salaActiva);
        System.out.println(clienteActual.consultarFunciones(funcionesDia));
        System.out.println(separador);
        System.out.print("Elegir una funcion: ");
        opcion = dato.nextInt();
        funcion = funcionesDia.get(opcion-1);
        if(Cliente.getClienteActual().getCuentaBancaria().getSaldo()>= funcion.getPrecio()){
            //funcion.llenarPuestos();
            System.out.println(separador);
            System.out.println(funcion.mostrarPuestos());
            System.out.println(separador);
            System.out.print("Cuantos asientos desea reservar? ");
            int asientosAElegir = dato.nextInt();
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
        }
    }

    @Override
    public void volver(int opcion) {
        if(opcion == 1){
            Inicio.main(null);
            System.exit(0);
        }else{
            salir.ejecutar();
        }
    }
}
