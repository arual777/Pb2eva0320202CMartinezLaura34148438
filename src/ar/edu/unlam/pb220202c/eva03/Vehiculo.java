package ar.edu.unlam.pb220202c.eva03;

public class Vehiculo implements Imultable, Comparable<Vehiculo> {

	public Vehiculo(String patente, Integer velocidadActual) {
		super();
		Patente = patente;
		VelocidadActual = velocidadActual;
	}

	//Se debe crear contructeres getters y Setters y loos que crean convenientes
	private String Patente;
	private Integer VelocidadActual;
	private Integer limiteVelocidad;

	
	public void incrmentarVelocidad(Integer Velocidad) {
		Integer nuevaVelocidad = this.getVelocidadActual() + Velocidad;
		this.setVelocidadActual(nuevaVelocidad);
	}
	
	public String getPatente() {
		return Patente;
	}


	public void setPatente(String patente) {
		Patente = patente;
	}


	public Integer getVelocidadActual() {
		return VelocidadActual;
	}


	public void setVelocidadActual(Integer velocidadActual) {
		VelocidadActual = velocidadActual;
	}


	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}


	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}

	@Override
	public Boolean enInfraccion() {
		if(this.getVelocidadActual() > this.getLimiteVelocidad()) 
		{
			return true;
		}
		
		return false;
	}

	@Override
	public int compareTo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return this.getPatente().compareTo(vehiculo.getPatente());
	}

}