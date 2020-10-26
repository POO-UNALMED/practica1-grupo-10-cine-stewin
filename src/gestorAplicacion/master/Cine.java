package gestorAplicacion.master;

import baseDatos.BaseDeDatos;

import java.io.Serializable;
import java.util.Vector;

public class Cine implements Serializable {
    //Atributos de clase****
    private String nombre;
    private static Vector<String> ciudades = new Vector<String>();
    private String ciudad;
    private String direccion;
    private int cantidasSalas = 4;
    public transient Vector<Vector<Funcion>> funciones = new Vector<Vector<Funcion>>();

    //Constructores de clase****
    public Cine() {

    }
    public Cine(String nombre, String ciudad, String direccion){
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.direccion=direccion;
    }
    //Metodos GET and SET****
    public String getNombre(){
        return nombre;
    }
    public String getCiudad(){
        return ciudad;
    }
    public String getDireccion(){
        return direccion;
    }
    public int getCantidasSalas(){
        return cantidasSalas;
    }
    public Vector<Vector<Funcion>> getFunciones(){
        return funciones;
    }
    public static Vector<String> getCiudades() {
        return ciudades;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public void setCantidasSalas(int cantidadSalas){
        this.cantidasSalas=cantidadSalas;
    }

    //Metodos de clase****
    //Metodo que agrega funciones
    public void addFunciones(Vector<Funcion> funciones){
        this.funciones.add(funciones);
    }

    @Override
    //ToString para ver que si se esten guardando los cines de la forma correcta --
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cantidasSalas=" + cantidasSalas +
                '}';
    }
}