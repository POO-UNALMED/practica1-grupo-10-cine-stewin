package gestorAplicacion.master;

import java.util.Calendar;

public class Funcion {
    //Atributos de clase
    private String nombre;
    private int numeroFuncion;
    private Calendar fecha;
    private int sala;
    private boolean estado;
    private int puestos[] = new int[20];
    //private int capacidad;

    //Constructores de clase****
    protected Funcion(String nombre,int numeroFuncion,int sala, boolean estado){
        this.nombre=nombre;
        this.numeroFuncion=numeroFuncion;
        this.sala=sala;
        this.estado=estado;
        //Cine.agregarFuncion(this);

    }
    //Metodos GET and SET****
    public String getNombre(){
        return nombre;
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

    protected void setNombre(String nombre){
        this.nombre=nombre;
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

    //Metodos de clase****
    protected String estadoFuncion(){
        if(!estado){
            return "Sin iniciar";
        }
        else{
            return "Ya iniciada";
        }
    }
}