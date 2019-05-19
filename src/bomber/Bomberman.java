package bomber;

public class Bomberman {
	
	private Punto coordenada;
	
	public Bomberman() {
	}
	
	public Bomberman(Punto coordenada) {
		this.coordenada = coordenada;
	}
	
	public void moverHaciaArriba(double delta) {
		this.coordenada.desplazar(delta, 0);
	}
	
	public void moverHaciaAbajo(double delta) {
		this.coordenada.desplazar(delta, 0);
	}
	public void moverHaciaDerecha(double delta) {
		this.coordenada.desplazar(0, delta);
	}
	public void moverHaciaIzquieda(double delta) {
		this.coordenada.desplazar(0, delta);
	}
	
	
}
