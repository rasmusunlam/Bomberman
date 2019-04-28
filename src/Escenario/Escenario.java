package Escenario;

import java.util.Random;

public class Escenario {
	
	private static int TAM;
	private static int mat[][];
	private static int cantJugadores;
	
	public Escenario(int tam, int cantJugadores) {	//EL TAMAÑO DEL ESCENARIO DEBE SER IMPAR Y >= 3
		
		this.TAM=tam;
		this.mat = new int[tam][tam];
		this.cantJugadores=cantJugadores;
		
		Random aleatorio = new Random(System.currentTimeMillis());
		
		// 0 => BLOQUE FIJO, 1 => BLOQUE DESTRUIBLE , 2 => ESPACIO EN BLANCO,  3 O MAS JUGADOR
		
		for(int i=0; i<tam; i++) {
			for(int j=0; j<tam; j++) {
				if(i==0 || i==tam-1 || j==0 || j==tam-1 || (i%2==0 && j%2==0)) { //SI ES UN BORDE O UNA DIAGONAL PAR => BLOQUE FIJO
					mat[i][j]=0;
				}else {
					mat[i][j]=aleatorio.nextInt(2)+1; //EN DONDE NO HAY FIJOS PONGO ALEATORIAMENTE (BLOQUE FIJO / ESPACIO EN BLANCO) IGUALMENTE VOY A PISAR LOS BLOQUES QUE ESTAN CERCA DE LOS JUGADORES
				}
			}
		}
		
		if(cantJugadores>=1) {
			mat[1][1]=3; mat[1][2]=2; mat[2][1]=2; // PISO CON ESPACIOS (2) Y PONGO EL PRIMER JUGADOR(3)
			if(cantJugadores>=2) {
				mat[tam-2][tam-2]=4; mat[tam-2][tam-3]=2; mat[tam-3][tam-2]=2; // PISO CON ESPACIOS (2) Y PONGO EL SEGUNDO JUGADOR(4)
				if(cantJugadores>=3) {
					mat[1][tam-2]=5; mat[1][tam-3]=2; mat[2][tam-2]=2; // PISO CON ESPACIOS (2) Y PONGO EL TERCER JUGADOR(5)
					if(cantJugadores>3) {
						mat[tam-2][1]=6; mat[tam-2][2]=2; mat[tam-3][1]=2; // PISO CON ESPACIOS (2) Y PONGO EL CUARTO JUGADOR(6)
					}
				}
			}
		}
			
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
		Escenario escenario = new Escenario(9, 4);
		escenario.dibujar();
	}
	
	
}
