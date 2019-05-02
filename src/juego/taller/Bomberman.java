package juego.taller;

public class Bomberman  {
	
	protected int posicionX;
	protected int posicionY;
	protected int numJugador;
	
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
	
	public boolean moverHaciaArriba(Escenario esc) {
		if(esc.mat[this.posicionX -1][this.posicionY] == esc.ESPACIO_EN_BLANCO) {
			this.posicionX --;
			esc.mat[this.posicionX + 1][this.posicionY] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
			return true;
		}	
		return false;
	}
	
	public boolean moverHaciaAbajo(Escenario esc) {
		if(esc.mat[this.posicionX +1][this.posicionY] == esc.ESPACIO_EN_BLANCO) {
			this.posicionX++ ;
			esc.mat[this.posicionX-1][this.posicionY] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
			return true;
		}	
		return false;
	}
	
	public boolean moverHaciaIzq(Escenario esc) {
		if(esc.mat[this.posicionX][this.posicionY -1] == esc.ESPACIO_EN_BLANCO) {
			this.posicionY--;
			esc.mat[this.posicionX][this.posicionY+1] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
			return true;
		}	
		return false;
	}
	
	public boolean moverHaciaDer(Escenario esc) {
		if(esc.mat[this.posicionX][this.posicionY +1] == esc.ESPACIO_EN_BLANCO) {
			this.posicionY++;
			esc.mat[this.posicionX][this.posicionY-1] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
			return true;
			
		}	
		return false;
	}

}
