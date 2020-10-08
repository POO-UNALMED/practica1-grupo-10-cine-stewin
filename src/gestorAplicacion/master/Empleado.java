package gestorAplicacion.master;

import gestorAplicacion.usuario.Persona;

public class Empleado extends Persona {
    //Atributos de clase****
    private String ocupacion;
    private String Funciones;

    //Contructores de clase****
    public Empleado(int identificacion, String nombre, String correo, String direccion, String contrasenia) {
        super(identificacion, nombre, correo, direccion,contrasenia);
    }

    //Metodos GET and SET****
    
	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getFunciones() {
		return Funciones;
	}

	public void setFunciones(String funciones) {
		Funciones = funciones;
	}

    
    
    

    //Metodos de clase****
}
