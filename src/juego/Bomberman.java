package juego;

public class Bomberman {
	
	enum Movimientos{ARRIBA,ABAJO,IZQUIERDA,DERECHA,ULTIMA};
	int x,y,dx,dy;
	
	public Bomberman(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void dibujar() {
		this.x+=dx;
		this.y+=dy;
	}
	
	public void mover() {
		
	}
	
	
}
