package bomber;

import javax.swing.ImageIcon;

public abstract class Objeto {
	
	private Punto coordenada;
	
	public Objeto(Punto coordenada) {
		this.coordenada = coordenada;
	}
	public Objeto() {
		
	}
	public Punto getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Punto coordenada) {
		this.coordenada = coordenada;
	}
	
	public abstract ImageIcon getImagen();
		
	
}
