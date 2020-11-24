package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista a = new Autopista();
		Automovil auto1 = new Automovil("ABC123",20);
		
		Boolean resultado = a.registrarTelepase(1, auto1);
		assertTrue(resultado);
	}
	
	@Test(expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		
		Autopista a = new Autopista();
		
		Automovil auto1 = new Automovil("ABC123",20);
		
		a.salirAutpista(auto1);
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista a = new Autopista();
		
		Automovil auto1 = new Automovil("ABC124",200);	
		
		Automovil auto2 = new Automovil("ABC123",340);
	
		 a.registrarTelepase(1, auto1);
		 a.registrarTelepase(2, auto2);
		 a.ingresarAutopista(1);
			a.ingresarAutopista(2);
			
		 TreeSet<Vehiculo> ordenados = a.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		 
		 assertTrue(ordenados.first().getPatente() == "ABC123");
		 assertTrue(ordenados.last().getPatente() == "ABC124");
	}

	@Test
	public void queSeObtengaLaCantidadDeAutosEnCirculacion() throws VehiculoNotFounException{
		Autopista a = new Autopista();
		
		Automovil auto1 = new Automovil("ABC124",200);	
		
		Automovil auto2 = new Automovil("ABC123",340);
		
		Automovil auto3 = new Automovil("ABC123",140);
		 
			a.registrarTelepase(1, auto1);
		 a.registrarTelepase(2, auto2);
		 a.registrarTelepase(3, auto3);
			
		 a.ingresarAutopista(1);
			a.ingresarAutopista(2);
			a.ingresarAutopista(3);
		 
			Integer resultado = a.cantidadDeVehiculosENCirculacion();
		 
		 assertTrue(resultado == 3);
		 
	}
	
	@Test
	public void queSePuedaSalirDeLaAutopista() throws VehiculoNotFounException {
		Autopista a = new Autopista();
		
		Automovil auto1 = new Automovil("ABC124",200);	
		
		a.registrarTelepase(1, auto1);
		a.ingresarAutopista(1);
		a.salirAutpista(auto1);
	
		Integer resultado = a.cantidadDeVehiculosENCirculacion();
		 
		 assertTrue(resultado == 0);
		
	}
	
}
