package juego.taller;

import java.util.Random;

public  class Escenario {
	
	public static final int BLOQUE_FIJO=0;
	public static final int BLOQUE_DESTRUIBLE=1;
	public static final int ESPACIO_EN_BLANCO=2;
	public static final int JUGADOR_1 = 3;
	public static final int BOMBA = 4;
	
	private static final int TAM=9;
	private int mat[][];
	private int cantJugadores=0;
	
	public Escenario() {	//EL TAMAÑO DEL ESCENARIO DEBE SER IMPAR Y >= 3
		
		this.mat = new int[TAM][TAM];
		
		Random aleatorio = new Random(System.currentTimeMillis());
		
		// 0 => BLOQUE FIJO, 1 => BLOQUE DESTRUIBLE , 2 => ESPACIO EN BLANCO,  3 O MAS JUGADOR
		
		for(int i=0; i<TAM; i++) {
			for(int j=0; j<TAM; j++) {
				if(i==0 || i==TAM-1 || j==0 || j==TAM-1 || (i%2==0 && j%2==0)) { //SI ES UN BORDE O UNA DIAGONAL PAR => BLOQUE FIJO
					mat[i][j]=0;
				}else {
					mat[i][j]=aleatorio.nextInt(2)+1; //EN DONDE NO HAY FIJOS PONGO ALEATORIAMENTE (BLOQUE FIJO / ESPACIO EN BLANCO) IGUALMENTE VOY A PISAR LOS BLOQUES QUE ESTAN CERCA DE LOS JUGADORES
				}
			}
		}
	
	}
	public boolean crearJugador(Bomberman bomber) {
		if(this.cantJugadores>=4)
			return false;
		this.cantJugadores++;
		if(this.cantJugadores == 1) {
			bomber.setPosicionX(1);
			bomber.setPosicionY(1);
			bomber.setNumJugador(3);
			this.mat[bomber.getPosicionX()][bomber.getPosicionY()] = bomber.getNumJugador();
			this.mat[1][2] = ESPACIO_EN_BLANCO;
			this.mat[2][1] = ESPACIO_EN_BLANCO;
		}else if(this.cantJugadores==2) {
			bomber.setPosicionX(7);
			bomber.setPosicionY(7);
			bomber.setNumJugador(4);
			this.mat[bomber.getPosicionX()][bomber.getPosicionY()] = bomber.getNumJugador();
			this.mat[7][6] = ESPACIO_EN_BLANCO;
			this.mat[6][7] = ESPACIO_EN_BLANCO;
		}else if(this.cantJugadores==3) {
			bomber.setPosicionX(1);
			bomber.setPosicionY(7);
			bomber.setNumJugador(5);
			this.mat[bomber.getPosicionY()][bomber.getPosicionX()] = bomber.getNumJugador();
			this.mat[7][2] = ESPACIO_EN_BLANCO;
			this.mat[6][1] = ESPACIO_EN_BLANCO;
		}else {
			bomber.setPosicionX(7);
			bomber.setPosicionY(1);
			bomber.setNumJugador(6);
			this.mat[bomber.getPosicionY()][bomber.getPosicionX()] = bomber.getNumJugador();
			this.mat[1][6] = ESPACIO_EN_BLANCO;
			this.mat[2][7] = ESPACIO_EN_BLANCO;
		}
		return true;
	}
	
	public void dibujar() {	//PARA VER EN LA CONSOLA
		for(int i=0; i<TAM; i++){
			for(int j=0; j<TAM; j++) {
				if(mat[i][j]==0) {
					System.out.print("X "); // => BLOQUE FIJO
				}else {
					if(mat[i][j]==1) {
						System.out.print("D "); // => BLOQUE DESTRUIBLE
					}else {
						if(mat[i][j]==2) {
							System.out.print("- "); // => ESPACIO EN BLANCO
						}else if(mat[i][j]==3){
							System.out.print("J "); // => JUGADOR
						}
						else{
							System.out.print("B "); // => BOMBA
						}
					}
				}
			}
			System.out.println();
		}
	}
	
	public int getObjeto(int x, int y){
		return this.mat[x][y];
	}
	
	public void setObjeto(int valor, int x, int y){
		this.mat[x][y] = valor;
	}
	public void crearBomba(Bomba bomba) {
		bomba.setPosicionX(2);
		bomba.setPosicionY(1);
		this.mat[2][1] = BOMBA;
		
	}
	
	
}
