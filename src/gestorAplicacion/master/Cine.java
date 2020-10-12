package gestorAplicacion.master;

import java.util.Vector;

public class Cine {
    //Atributos de clase****
    private String nombre;
    private String ciudad;
    private String direccion;
    private int cantidasSalas = 5;
    private static Vector<Funcion> funciones = new Vector<Funcion>();

    //Constructores de clase****
    protected Cine(String nombre, String ciudad, String direccion){
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

    protected void setNombre(String nombre){
        this.nombre=nombre;
    }
    protected void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    protected void setDireccion(String direccion){
        this.direccion=direccion;
    }
    protected void setCantidasSalas(int cantidadSalas){
        this.cantidasSalas=cantidadSalas;
    }

    //Metodos de clase****
    public Vector<Funcion> getFunciones(){
        return funciones;
    }
    protected void agregarFuncion(Funcion funcion){
        funciones.add(funcion);
    }
    protected void retirarFuncion(Funcion funcion){
        funciones.remove(funciones.indexOf(funcion));
    }
    protected static boolean estadoFuncion(String nombre){
        boolean estado=false;
        for(int i=0; i<=funciones.size(); i++){
            if(funciones.get(i).getNombre()==nombre){
                estado=funciones.get(i).isEstado();
            }
        }
        return estado;
    }
}