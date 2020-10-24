package gestorAplicacion.master;

import gestorAplicacion.usuario.*;

public class Empleado extends Persona {
    //Atributos de clase****
    private String ocupacion;

    //Contructores de clase****
    private Empleado(int identificacion, String nombre, String correo, String direccion, String contrasena, String ocupacion) {
        super(identificacion, nombre, correo, direccion);
        this.ocupacion=ocupacion;
    }

    //Metodos GET and SET****
	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

    //Metodos de clase****
	protected void contratar(int identificacion, String nombre, String correo, String direccion, String contrasena, String ocupacion){
		new Empleado(identificacion, nombre, correo, direccion, contrasena, ocupacion);
    }

    protected String estadoFunciones(String nombre){
    	if(Cine.estadoFuncion(nombre)==false){
    		return "funcion sin iniciar";
		}
    	else{
    		return "funcion ya iniciada";
		}
	}
	private void modPuntos(Cliente cliente, int puntos){
    	cliente.getCuentaPuntos().agregarpuntos(puntos);
	}
	private String consultarFuncion(Funcion funcion){
    	return funcion.toString();
	}
	/*private String consultarasistentes(Funcion funcion){
    	return "Hay "+funcion.getPuestos()+" ocupados";
	}*/
	private void actualizarFunciones(){

	}
}
