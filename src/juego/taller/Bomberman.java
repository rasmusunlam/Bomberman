package juego;

import Escenario.Escenario;

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
	
	public boolean moverHaciaArriba(Escenario esc) {
		if(esc.mat[this.posicionX -1][this.posicionY] == esc.ESPACIO_EN_BLANCO) {
			this.posicionX --;
			esc.mat[this.posicionX + 1][this.posicionY] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
		}	
		return false;
	}
	
	public boolean moverHaciaAbajo(Escenario esc) {
		if(esc.mat[this.posicionX +1][this.posicionY] == esc.ESPACIO_EN_BLANCO) {
			this.posicionX++ ;
			esc.mat[this.posicionX-1][this.posicionY] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
		}	
		return false;
	}
	
	public boolean moverHaciaIzq(Escenario esc) {
		if(esc.mat[this.posicionX][this.posicionY -1] == esc.ESPACIO_EN_BLANCO) {
			this.posicionY--;
			esc.mat[this.posicionX][this.posicionY+1] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
		}	
		return false;
	}
	
	public boolean moverHaciaDer(Escenario esc) {
		if(esc.mat[this.posicionX][this.posicionY +1] == esc.ESPACIO_EN_BLANCO) {
			this.posicionY++;
			esc.mat[this.posicionX][this.posicionY-1] = esc.ESPACIO_EN_BLANCO;
			esc.mat[this.posicionX][this.posicionY] = esc.JUGADOR_1;
		}	
		return false;
	}

}
