package juego;

import java.util.Random;

public class Escenario {
	
	private static int filas=9;
	private static int columnas=13;
	private static int mat[][];
	
	
	public Escenario() {
		mat = new int[filas][columnas];
	}
	
	
	public static int[][] getMat() {
		return mat;
	}


	public void generarMatriz() {
		Random aleatorio = new Random(System.currentTimeMillis());
		for(int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				if(i==0 || i==filas-1 || j==0 || j==columnas-1 || (i%2==0 && j%2==0)) { //borde o diagonales
					mat[i][j]=0; //bloque fijo
				}else {
					if((i==1 && (j==1 || j==2)) || (i==2 && j==1) ||(i==filas-2 && (j==columnas-2 || j==columnas-3)) || (i==filas-3 && j==columnas-2)) { //esquina superior izquierda y esquina inferior derecha libres
						mat[i][j]=1; // espacio libre	
					}else {
						mat[i][j]=aleatorio.nextInt(2)+1; // libre o bloque fijo (1 o 2)
					}	
				}
			}
		}
	}
	
	public void dibujarMatrizNumeros() {
		for(int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void dibujarCaracteres() {
		for(int i=0; i<filas; i++){
			for(int j=0; j<columnas; j++) {
				if(mat[i][j]==0) {
					System.out.print("X "); // bloque fijo
				}else {
					if(mat[i][j]==1) {
						System.out.print("- "); // espacio libre
					}else {
						System.out.print("D "); // bloque destruible
					}
				}
			}
			System.out.println();
		}
	}
	
	
}
