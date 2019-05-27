package bomber;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Escenario extends JPanel {
	
	private static final int TAM=13;
	private static final int TAM2=15;
	private Objeto[][] escenario;
	private ArrayList<Bomberman> bombers = new ArrayList<>();
	private ImageIcon bomber1 = new ImageIcon("./src/bomber/Imagenes/Bomberman1.png");
	private ImageIcon bomber2 = new ImageIcon("./src/bomber/Imagenes/Bomberman2.png");
	private ImageIcon bomber3 = new ImageIcon("./src/bomber/Imagenes/Bomberman3.png");
	private ImageIcon bomber4 = new ImageIcon("./src/bomber/Imagenes/Bomberman4.png");
	
	public Escenario() {
		this.escenario = new Objeto[TAM][TAM2];
		Random aleatorio = new Random(System.currentTimeMillis());
		Bloque_Fijo bloque;
		Bloque_Destruible bloqueDestruible;
		for(int i=0; i<TAM; i++) {
			for(int j=0; j<TAM2; j++) {
				if(i==0 || i==TAM-1 || j==0 || j==TAM2-1 || (i%2==0 && j%2==0)) { 
					bloque = new Bloque_Fijo(new Punto(i,j));
					escenario[i][j] = bloque;
				}else {
					if(aleatorio.nextInt(2) == 1) {
						bloqueDestruible = new Bloque_Destruible(new Punto(i,j));
						escenario[i][j] = bloqueDestruible;
					}
				}
			}
		}

	}
	public void agregarBomberman() {
		
		Bomberman bombero;
		
		if(bombers.size()==0) {
			bombero = new Bomberman(new Punto(40,40),bomber1);
			escenario[1][1]=null;
			escenario[1][2]=null;
			escenario[2][1]=null;
			bombers.add(bombero);
		}else if(bombers.size()==1) {
			bombero = new Bomberman(new Punto(40,520),bomber2);
			escenario[1][13]=null;
			escenario[1][12]=null;
			escenario[2][13]=null;
			bombers.add(bombero);
		}else if(bombers.size()==2) {
			bombero = new Bomberman(new Punto(440,40),bomber3);
			escenario[11][1]=null;
			escenario[11][2]=null;
			escenario[10][1]=null;
			bombers.add(bombero);
		}
		else if(bombers.size()==3) {
			bombero = new Bomberman(new Punto(440,520),bomber4);
			escenario[11][13]=null;
			escenario[11][12]=null;
			escenario[10][13]=null;
			bombers.add(bombero);
		}
		
	}
	
	public void setBomberman(Bomberman b , int num) {
		this.bombers.set(num, b);
	}
	public Bomberman getBomberman(int num) {
		return bombers.get(num);
	}
	
	public boolean moverIzq(Punto punto, Double mov) {
		
		int x = punto.getX().intValue();
		int j = punto.getY().intValue()-mov.intValue();
		
		if(x%40 == 0 && escenario[x/40][j/40] == null) {
			return true;
		}
		return false;
	}
	public boolean moverDer(Punto punto, Double mov) {
		
		int x = punto.getX().intValue();
		int j = punto.getY().intValue();
		if(x%40 == 0 && escenario[x/40][(j/40)+1] == null) {
			return true;
		}
		return false;
	}
	public boolean moverArr(Punto punto, Double mov) {
		
		int x = punto.getX().intValue()-mov.intValue();
		int j = punto.getY().intValue();
		
		if(j%40 == 0 && escenario[x/40][j/40] == null) {
			return true;
		}
		return false;
	}
	public boolean moverAba(Punto punto, Double mov) {
		
		int x = punto.getX().intValue();
		int j = punto.getY().intValue();
		
		if(j%40==0 && escenario[(x/40)+1][j/40]== null) {
			return true;
		}
		return false;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(10,170,22));
		for(int i=0; i<TAM; i++) {
			for(int j=0; j<TAM2; j++) 
				if(escenario[i][j] != null) 
					g.drawImage(escenario[i][j].getImagen().getImage(),j*40 , i*40 , 40,40,null);
		}
		
		for (Bomberman bombero : bombers) {
			Double i = bombero.getCoordenada().getX();
			Double j = bombero.getCoordenada().getY();
			g.drawImage(bombero.getImagen().getImage(),j.intValue(),i.intValue(), 40, 40, null);	
		}
		
	}
	
}
