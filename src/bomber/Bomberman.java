package bomber;

import javax.swing.ImageIcon;

public class Bomberman {
	
	private static final int CANT_BOMBAS = 5;
	private Punto coordenada;
	private ImageIcon imagen;
	private int cantBombas;
	
	public Bomberman(ImageIcon ima) {
		this.imagen = ima;
		this.cantBombas = CANT_BOMBAS;
	}
	
	public Bomberman(Punto coordenada,ImageIcon ima) {
		this.coordenada = coordenada;
		this.imagen = ima;
		this.cantBombas = CANT_BOMBAS;
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
	
	public ImageIcon getImagen() {
		return imagen;
	}
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	public Punto getCoordenada() {
		return coordenada;
	}
	
	public Bomba ponerBomba() {
		Bomba bomba = new Bomba(this.coordenada);
		cantBombas--;
		return bomba;
	}
	
}
