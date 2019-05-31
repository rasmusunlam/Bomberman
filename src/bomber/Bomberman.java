package bomber;

import javax.swing.ImageIcon;

public class Bomberman {
	
	private static final int CANT_BOMBAS = 5;
	private static Integer numBomberman = 1;
	private Punto coordenada;
	private boolean vivo = true;
	private int cantBombas;
	private ImageIcon bomberD;
	private ImageIcon bomberI;
	private ImageIcon ima;
	
	
	public Bomberman(Punto coordenada) {
		this.coordenada = coordenada;
		this.bomberD = new ImageIcon("./src/bomber/Imagenes/bomberman"+numBomberman.toString()+"Der.png");
		this.bomberI = new ImageIcon("./src/bomber/Imagenes/bomberman"+numBomberman.toString()+"Izq.png");
		if(numBomberman%2 == 0) {
			ima = bomberI; 
		}else {
			ima = bomberD;
		}
		this.cantBombas = CANT_BOMBAS;
		numBomberman++;
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
		return ima;
	}
	public void setImagen(ImageIcon imagen) {
		this.ima = imagen;
	}
	public Punto getCoordenada() {
		return coordenada;
	}
	
	public Bomba ponerBomba() {
		Bomba bomba = new Bomba(this.coordenada);
		cantBombas--;
		return bomba;
	}

	public void setPunto(Punto punto) {
		this.coordenada = punto;
	}

	public boolean getVivo() {
		return this.vivo;
	}
	public void setImagIzq() {
		this.ima = this.bomberI;
	}
	public void setImagDer() {
		this.ima = this.bomberD;
	}
	
	public void morir() {
		this.vivo=false;
	}
}
