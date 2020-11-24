package ar.edu.unlam.pb220202c.eva03;

public class Automovil extends Vehiculo{

	public Automovil(String patente, Integer velocidadActual) {
		super(patente, velocidadActual);
	}

	@Override
	public void setLimiteVelocidad(Integer limiteVelocidad) {
		super.setLimiteVelocidad(130);
	}	
}
