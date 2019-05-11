package juego.taller;

public class Bomberman  {
	
	private int posicionX;
	private int posicionY;
	private int numJugador;
	
	public Bomberman() {
	}
	public Bomberman(int x,int y) {
		this.posicionX = x;
		this.posicionY = y;
		
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	public int getNumJugador() {
		return this.numJugador;
	}
	public void setNumJugador(int num) {
		this.numJugador = num;
	}
	
	public boolean moverHaciaArriba(Escenario esc) {
		if(esc.getObjeto(this.posicionY -1 , this.posicionX) == Escenario.ESPACIO_EN_BLANCO) {
			this.posicionY --;
			esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, posicionY +1, posicionX);
			esc.setObjeto(Escenario.JUGADOR_1, posicionY, posicionX);
			return true;
		}	
		return false;
	}
	
	public boolean moverHaciaAbajo(Escenario esc) {
		if(esc.getObjeto(posicionY+1, posicionX) == Escenario.ESPACIO_EN_BLANCO) {
			this.posicionY++ ;
			esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, posicionY-1, posicionX);
			esc.setObjeto(Escenario.JUGADOR_1, posicionY, posicionX);
			return true;
		}	
		return false;
	}
	
	public boolean moverHaciaIzq(Escenario esc) {
		if(esc.getObjeto(posicionY, posicionX-1) == Escenario.ESPACIO_EN_BLANCO) {
			this.posicionX--;
			esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, posicionY, posicionX+1);
			esc.setObjeto(Escenario.JUGADOR_1, posicionY, posicionX);
			return true;
		}	
		return false;
	}
	
	public boolean moverHaciaDer(Escenario esc) {
		if(esc.getObjeto(posicionY, posicionX+1) == Escenario.ESPACIO_EN_BLANCO) {
			this.posicionX++;
			esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, posicionY, posicionX-1);
			esc.setObjeto(Escenario.JUGADOR_1, posicionY, posicionX);
			return true;
		}	
		return false;
	}

}
