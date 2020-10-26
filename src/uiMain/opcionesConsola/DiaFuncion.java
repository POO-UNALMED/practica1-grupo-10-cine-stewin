package uiMain.opcionesConsola;

import gestorAplicacion.master.Cine;
import gestorAplicacion.master.Empleado;
import gestorAplicacion.master.Funcion;
import gestorAplicacion.usuario.Cliente;

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
    Cliente cliente = new Cliente();
    {

    }
    @Override
    public void ejecutar() {
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
        System.out.println("Funciones del dia");
        Vector<Funcion> funcionesDia = cliente.consultarFunciones(opcion,salaActiva);
        System.out.println(cliente.consultarFunciones(funcionesDia));
        System.out.println(separador);
        System.out.print("Elegir una funcion: ");
        opcion = dato.nextInt();
        if(Cliente.getClienteActual().getCuentaBancaria().getSaldo()>= funcionesDia.get(opcion-1).getPrecio()){

        }else{

        }
    }

    @Override
    public void volver(int opcion) {

    }
}
