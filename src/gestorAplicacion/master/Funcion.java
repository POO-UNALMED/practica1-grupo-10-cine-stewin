package gestorAplicacion.master;

import baseDatos.BaseDeDatos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;

public class Funcion implements Serializable {
    //Atributos de clase
    private String nombre;
    private int numeroFuncion;
    private LocalDateTime fecha;
    private int sala;
    private boolean estado;
    private int puestos[] = new int[20];
    static int numeroFuncionn = 0;
    private int precio = 20000;
    //private int capacidad;

    //Constructores de clase****
    public Funcion() {
        this.numeroFuncion = numeroFuncionn;
        numeroFuncionn += 1;
        llenarPuestos();
    }

    public Funcion(int hora) {
        this();
        LocalDate hoy = LocalDate.now();
        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int año = hoy.getYear();
        this.fecha = LocalDateTime.of(año, mes, dia, hora, 0);
    }

    public Funcion(String nombre, int sala, int hora) {
        this(hora);
        this.nombre = nombre;
        this.sala = sala;
    }
    //Metodos GET and SET****

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroFuncion() {
        return numeroFuncion;
    }

    public void setNumeroFuncion(int numeroFuncion) {
        this.numeroFuncion = numeroFuncion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPuestos(int[] puestos) {
        this.puestos = puestos;
    }

    public static int getNumeroFuncionn() {
        return numeroFuncionn;
    }

    public static void setNumeroFuncionn(int numeroFuncionn) {
        Funcion.numeroFuncionn = numeroFuncionn;
    }

    public int[] getPuestos() {
        return puestos;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //Metodos de clase****
    /*Metodo que se encarga de sumar una cantidad de dias recibidos por parametro a la funcion*/
    public void sumarFecha(int dia) {
        this.fecha = this.fecha.plusDays(dia);
    }

    @Override
    public String toString() {
        return "Funcion: " + this.nombre + ", a las " + this.fecha.format(DateTimeFormatter.ofPattern("H:mm, ")) + "valor de: " + this.precio;
    }

    /*Metodo que se ejecuta cuando una funcion se crea, el cual se encarga de llenar sus puestos aleatoriamente*/
    public void llenarPuestos() {
        for (int i = 0; i < 20; i++) {
            puestos[i] = i;
        }
        Vector<Integer> puestosLlenos = new Vector<Integer>();
        int puestosALlenar;
        puestosALlenar = (int) Math.floor(Math.random() * 30);
        for (int i = 0; i < puestosALlenar; i++) {
            int azar = (int) Math.floor(Math.random() * 20);
            if (!(puestosLlenos.contains(azar))) {
                puestosLlenos.add(azar);
            }
        }
        for (Integer i : puestosLlenos) {
            puestos[i] = 0;
        }
    }

    /*Metodo que se encarga de mostrar los puestos disponibles al usuario*/
    public String mostrarPuestos() {
        StringBuilder s = new StringBuilder();
        for (int w = 0; w < 10; w++) {
            if (puestos[w] != 0) {
                s.append("| 0").append(puestos[w]).append(" ");
            } else {
                s.append("| 0").append(puestos[w]).append(" ");
            }
        }
        for (int e = 10; e < 20; e++) {
            if (puestos[e] != 0) {
                s.append("| ").append(puestos[e]).append(" ");
            } else {
                s.append("| 0").append(puestos[e]).append(" ");
            }
        }
        s.append("|");
        String a;
        String b;
        a = s.substring(0, (s.length() / 2) + 1);
        b = s.substring((s.length() / 2), s.length());
        return "       Asientos disponibles en la funcion: \n" +
                "      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n" +
                "             ʭLa pantalla esta acaʭ \n"
                + a + "\n"
                + "---------------------------------------------------\n"
                + "---------------------------------------------------\n"
                + b;
    }

    /*Metodo que se muestra el estado de la funcion respecto al dia actual es decir, False si una funcion ya paso
    o True si una funcion no ha ocurrido*/
    public void estado() {
        LocalDateTime hoy = LocalDateTime.now();
        if (this.getFecha().compareTo(hoy) == -1) {
            this.setEstado(false);
        } else {
            this.setEstado(true);
        }
    }

}