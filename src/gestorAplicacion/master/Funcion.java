package gestorAplicacion.master;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        this.numeroFuncion=numeroFuncionn;
        numeroFuncionn += 1;
    }

    public Funcion(int hora) {
        this();
        LocalDate hoy = LocalDate.now();
        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int año = hoy.getYear();
        this.fecha = LocalDateTime.of(año, mes,dia,hora,0);
    }

    public Funcion(String nombre,int sala,int hora){
        this(hora);
        this.nombre=nombre;
        this.sala=sala;
    }
    //Metodos GET and SET****

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
    public void sumarFecha(int dia){
        this.fecha = this.fecha.plusDays(dia);
    }

    @Override
    public String toString() {
        return "Funcion: " + this.nombre + ", a las " + this.fecha.format(DateTimeFormatter.ofPattern("H:mm, ")) + "valor de: " + this.precio;
    }
}