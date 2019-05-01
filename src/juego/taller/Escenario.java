package juego;

import java.util.Random;

import Escenario.Bomberman;
import Escenario.Escenario;


public  class Escenario {
	
	protected static final int BLOQUE_FIJO=0;
	protected static final int BLOQUE_DESTRUIBLE=1;
	protected static final int ESPACIO_EN_BLANCO=2;
	protected static final int JUGADOR_1 = 3;
	
	private static final int TAM=9;
	public int mat[][];
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
			bomber.posicionX = 1;
			bomber.posicionY = 1;
			bomber.numJugador = 3;
			this.mat[bomber.posicionX][bomber.posicionY] = bomber.numJugador;
			this.mat[1][2] = ESPACIO_EN_BLANCO;
			this.mat[2][1] = ESPACIO_EN_BLANCO;
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
						}else {
							System.out.print("J "); // => JUGADOR
						}
					}
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Escenario escenario = new Escenario();
		Bomberman bomber = new Bomberman();
		escenario.crearJugador(bomber);
		bomber.moverHaciaAbajo(escenario);
		
		
		escenario.dibujar();
	}
	
	
}
