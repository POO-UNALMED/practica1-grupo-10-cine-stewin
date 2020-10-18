package gestorAplicacion.master;

import java.util.Calendar;

public class Funcion {
    //Atributos de clase
    private String nombre;
    private int cantidadFunciones;
    private int numeroFuncion;
    private Calendar fecha;
    private Sala sala;
    private boolean estado;
    private int puerta;
    private Reserva [] puestos = new Reserva[20];
    //private int capacidad;

    //Constructores de clase****
    protected Funcion(String nombre, int cantidadFunciones,int puestos,int numeroFuncion,Sala sala, boolean estado,int puerta){
        this.nombre=nombre;
        this.cantidadFunciones=cantidadFunciones;
        this.numeroFuncion=numeroFuncion;
        this.sala=sala;
        this.estado=estado;
        this.puerta=puerta;
        //Cine.agregarFuncion(this);

    }
    //Metodos GET and SET****
    public String getNombre(){
        return nombre;
    }
    public int getCantidadFunciones(){
        return cantidadFunciones;
    }
    //public int getPuestos(){
      //  return puestos;
    //}
    public int getNumeroFuncion(){
        return numeroFuncion;
    }
    public Calendar getFecha(){
        return fecha;
    }
    /*public Cine getSala(){
        return sala;
    }*/
    public boolean isEstado(){
        return estado;
    }
    public int getPuerta(){
        return puerta;
    }

    protected void setNombre(String nombre){
        this.nombre=nombre;
    }
    protected void setCantidadFunciones(int cantidadFunciones){
        this.cantidadFunciones=cantidadFunciones;
    }
    /*protected void setPuestos(int puestos){
        this.puestos=puestos;
    }*/
    protected void setNumeroFuncion(int numeroFuncion){
        this.numeroFuncion=numeroFuncion;
    }
    protected void setFecha(Calendar fecha){
        this.fecha=fecha;
    }
    /*protected void setSala(Cine sala){
        this.sala=sala;
    }*/
    protected void setEstado(boolean estado){
        this.estado=estado;
    }
    protected void setPuerta(int puerta){
        this.puerta=puerta;
    }

    //Metodos de clase****
    protected String estadoFuncion(){
        if(!estado){
            return "Sin iniciar";
        }
        else{
            return "Ya iniciada";
        }
    }
    public String toString(){
        return "Funcion #"+numeroFuncion+", Puerta: "+puerta+" Estado: "+estadoFuncion();
    }
    protected void finalize(){
        System.out.println("la funcion: "+nombre+", ha sido retirada de cartelera.");
    }
}