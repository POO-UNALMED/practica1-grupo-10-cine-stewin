package gestorAplicacion.master;

import java.util.Vector;

public class Cine {
    //Atributos de clase
    private String nombre;
    private String ciudad;
    private String direccion;
    private int cantidasSalas = 5;
    private Vector<Funcion> funciones = new Vector<Funcion>();

    //Constructores de clase
    private Cine(String nombre, String ciudad, String direccion){
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

    private void setNombre(String nombre){
        this.nombre=nombre;
    }
    private void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    private void setDireccion(String direccion){
        this.direccion=direccion;
    }
    private void setCantidasSalas(int cantidadSalas){
        this.cantidasSalas=cantidadSalas;
    }

    //Metodos de clase****
    public Vector<Funcion> getFunciones(){
        return funciones;
    }
    private void agregarFuncion(Funcion funcion){
        funciones.add(funcion);
    }
    private void retirarFuncion(Funcion funcion){
        funciones.remove(funciones.indexOf(funcion));
    }
}