package bomber;

import javax.swing.ImageIcon;

public class Bomberman {
	
	private static final int CANT_BOMBAS = 2;
	private static int numBomberman = 0;
	private int id_bomberman;
	private Punto coordenada;
	private boolean vivo = true;
	private int cantBombas;
	private ImageIcon bomberD;
	private ImageIcon bomberI;
	private ImageIcon ima;
	private ImageIcon[] imagenArriba;
	private ImageIcon[] imagenAbajo;
	private ImageIcon[] imagenIzquierda;
	private ImageIcon[] imagenDerecha;
	private int contador = 0;
	private int bombasPuestas = 0;
	
	
	public Bomberman(Punto coordenada) {
		this.coordenada = coordenada;
		/*this.bomberD = new ImageIcon("./src/bomber/Imagenes/bomberman"+numBomberman.toString()+"Der.png");
		this.bomberI = new ImageIcon("./src/bomber/Imagenes/bomberman"+numBomberman.toString()+"Izq.png");
		if(numBomberman%2 == 0) {
			ima = bomberI; 
		}else {
			ima = bomberD;
		}*/
		this.cantBombas = CANT_BOMBAS;
		id_bomberman = numBomberman;
		numBomberman++;
		cargarAnimacion();
	}
	
	public void moverHaciaArriba(double delta) {
		
		contador = contador >= 4 ? 0 : contador + 1;
		ima = this.imagenArriba[contador];
		
		this.coordenada.desplazar(delta, 0);
	}
	
	public void moverHaciaAbajo(double delta) {
		
		contador = contador >= 4 ? 0 : contador + 1;
		ima = this.imagenAbajo[contador];
		
		this.coordenada.desplazar(delta, 0);
	}
	public void moverHaciaDerecha(double delta) {
		
		contador = contador >= 4 ? 0 : contador + 1;
		ima = this.imagenDerecha[contador];
		
		this.coordenada.desplazar(0, delta);
	}
	public void moverHaciaIzquieda(double delta) {
		
		contador = contador >= 4 ? 0 : contador + 1;
		ima = this.imagenIzquierda[contador];
		
		this.coordenada.desplazar(0, delta);
	}
	
	
	private void cargarAnimacion(){
		this.imagenArriba = new ImageIcon[5];
		this.imagenAbajo = new ImageIcon[5];
		this.imagenIzquierda = new ImageIcon[5];
		this.imagenDerecha = new ImageIcon[5];
		
		for(int i = 1; i <= 5; i++){
			this.imagenArriba[i - 1] = new ImageIcon("./resources/bomberman/arriba"+id_bomberman+i+".gif");
			this.imagenAbajo[i - 1] = new ImageIcon("./resources/bomberman/abajo"+id_bomberman+i+".gif");
			this.imagenIzquierda[i - 1] = new ImageIcon("./resources/bomberman/izquierda"+id_bomberman+i+".gif");
			this.imagenDerecha[i - 1] = new ImageIcon("./resources/bomberman/derecha"+id_bomberman+i+".gif");
		}
		
		if(id_bomberman%2==0) {
			ima = this.imagenDerecha[0];
		}else
			ima = this.imagenIzquierda[0];
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
	
	public void aumentarBomba() {
		bombasPuestas++;
	}
	public void descontarBomba() {
		bombasPuestas--;
	}
	public int getBombasPuestas() {
		return bombasPuestas;
	}
	public int getIdBomberman() {
		return id_bomberman;
	}
}
