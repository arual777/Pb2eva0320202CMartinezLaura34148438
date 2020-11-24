package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase = new HashMap<>();
	private HashSet <Vehiculo> vehiculosEnCirculacion = new HashSet<>();
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		Integer cantidadActual = telepase.size();
		
		telepase.put(numeroTelpase, vehiculo);
		Integer nuevaCantidad = telepase.size();
		
		if(cantidadActual == nuevaCantidad) {
			return false;
		}
		
		return true;
	
	}
	
	//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	// y no permite ingresar al autopista			
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		
		Vehiculo vehiculoEnTelepase = telepase.get(numeroTelepase);
		
		if(vehiculoEnTelepase == null) {
			throw new VehiculoNotFounException("Vehiculo no encontrado");
		}
		
		return vehiculosEnCirculacion.add(vehiculoEnTelepase);
	
	}
	
	//lanza Una exception VehiculoNotFounException si no esta en circulacion
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		
		String patente = vehiculo.getPatente();
		Boolean encontrado = false;
		
		for(Vehiculo vehiculoEnCirculacion:vehiculosEnCirculacion) 
		{
			if(vehiculoEnCirculacion.getPatente() == patente) {
				vehiculosEnCirculacion.remove(vehiculoEnCirculacion);
				encontrado = true;
			}
		}
		
		if(!encontrado) {
			throw new VehiculoNotFounException("Vehiculo no encontrado");	
		}
		
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
	
		TreeSet <Vehiculo> vehiculos= new TreeSet<>();
		vehiculos.addAll(vehiculosEnCirculacion);
		return vehiculos;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return vehiculosEnCirculacion.size();
}
	}
