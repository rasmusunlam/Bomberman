package bomber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Escenario extends JPanel {
	
	private static final int TAM=13;
	private static final int TAM2=15;
	public static final int WIDTH_IMG = 40;
    public static final int HEIGHT_IMG = 40;
    
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
			bombero = new Bomberman(new Punto(HEIGHT_IMG*1,WIDTH_IMG*1),bomber1);
			escenario[1][1]=null;
			escenario[1][2]=null;
			escenario[2][1]=null;
			bombers.add(bombero);
		}else if(bombers.size()==1) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*1,WIDTH_IMG*13),bomber2);
			escenario[1][13]=null;
			escenario[1][12]=null;
			escenario[2][13]=null;
			bombers.add(bombero);
		}else if(bombers.size()==2) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*11,WIDTH_IMG*1),bomber3);
			escenario[11][1]=null;
			escenario[11][2]=null;
			escenario[10][1]=null;
			bombers.add(bombero);
		}
		else if(bombers.size()==3) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*11,WIDTH_IMG*13),bomber4);
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
	
	public boolean moverIzq(Punto punto, double mov) {
		
		int x = (int)punto.getX();
		int j = (int) punto.getY()-(int)mov;
		
		if(x%HEIGHT_IMG == 0 && escenario[x/HEIGHT_IMG][j/WIDTH_IMG] == null) {
			return true;
		}
		return false;
	}
	public boolean moverDer(Punto punto, double mov) {
		
		int x = (int)punto.getX();
		int j = (int) punto.getY();
		if(x%HEIGHT_IMG == 0 && escenario[x/HEIGHT_IMG][(j/WIDTH_IMG)+1] == null) {
			return true;
		}
		return false;
	}
	public boolean moverArr(Punto punto, double mov) {
		
		int x = (int)punto.getX()-(int)mov;
		int j = (int)punto.getY();
		
		if(j%WIDTH_IMG == 0 && escenario[x/HEIGHT_IMG][j/WIDTH_IMG] == null) {
			return true;
		}
		return false;
	}
	public boolean moverAba(Punto punto, double mov) {
		
		int x = (int)punto.getX();
		int j = (int) punto.getY();
		
		if(j%WIDTH_IMG==0 && escenario[(x/HEIGHT_IMG)+1][j/WIDTH_IMG]== null) {
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
					g.drawImage(escenario[i][j].getImagen().getImage(),j*WIDTH_IMG , i*HEIGHT_IMG , WIDTH_IMG,HEIGHT_IMG,null);
		}
		
		for (Bomberman bombero : bombers) {
			g.drawImage(bombero.getImagen().getImage(), (int)bombero.getCoordenada().getY(), (int)bombero.getCoordenada().getX(),  WIDTH_IMG,HEIGHT_IMG, null);
		} 
		
	}
	public boolean ponerBomba(Punto coordenada) {
		if((int)coordenada.getX()%HEIGHT_IMG == 0 && (int)coordenada.getY()%WIDTH_IMG == 0)
			return true;
		return false;
	}
	
	public void agregarObjeto(Bomba bomba) {
		escenario[(int)bomba.getCoordenada().getX()/HEIGHT_IMG][(int)bomba.getCoordenada().getY()/WIDTH_IMG] = bomba;
		Timer tiempo = new Timer(5000, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Punto> puntosExplotan = ((Bomba)escenario[(int)bomba.getCoordenada().getX()/HEIGHT_IMG][(int)bomba.getCoordenada().getY()/WIDTH_IMG]).explotar();
				
				
				if(	escenario[(int)puntosExplotan.get(0).getX()][(int)puntosExplotan.get(0).getY()] != null &&
					(escenario[(int)puntosExplotan.get(0).getX()][(int)puntosExplotan.get(0).getY()].getClass().getName().contains("Bomberman")||
					escenario[(int)puntosExplotan.get(0).getX()][(int)puntosExplotan.get(0).getY()].getClass().getName().contains("Bloque_Destruible")||
					escenario[(int)puntosExplotan.get(0).getX()][(int)puntosExplotan.get(0).getY()].getClass().getName().contains("Bomba")					)) {
						Explosion expo = new Explosion(puntosExplotan.get(0));
						expo.setImagenCentro();
						escenario[(int)puntosExplotan.get(0).getX()][(int)puntosExplotan.get(0).getY()] = expo ;
				
				
				
				if(	escenario[(int)puntosExplotan.get(1).getX()][(int)puntosExplotan.get(1).getY()] != null &&
					(escenario[(int)puntosExplotan.get(1).getX()][(int)puntosExplotan.get(1).getY()].getClass().getName().contains("Bomberman") ||
					escenario[(int)puntosExplotan.get(1).getX()][(int)puntosExplotan.get(1).getY()].getClass().getName().contains("Bloque_Destruible"))){
						Explosion expo1 = new Explosion(puntosExplotan.get(1));
						expo.setImagenDerecha();
						escenario[(int)puntosExplotan.get(1).getX()][(int)puntosExplotan.get(1).getY()] = expo1;	
					}
				

				
				
				if(	escenario[(int)puntosExplotan.get(2).getX()][(int)puntosExplotan.get(2).getY()] != null &&
					(escenario[(int)puntosExplotan.get(2).getX()][(int)puntosExplotan.get(2).getY()].getClass().getName().contains("Bomberman") ||
					escenario[(int)puntosExplotan.get(2).getX()][(int)puntosExplotan.get(2).getY()].getClass().getName().contains("Bloque_Destruible"))) {
					Explosion expo2 = new Explosion(puntosExplotan.get(2));
						expo.setImagenIzquierda();
						escenario[(int)puntosExplotan.get(2).getX()][(int)puntosExplotan.get(2).getY()] = expo2;
					}

				
				
				if(	escenario[(int)puntosExplotan.get(3).getX()][(int)puntosExplotan.get(3).getY()] != null &&
					(escenario[(int)puntosExplotan.get(3).getX()][(int)puntosExplotan.get(3).getY()].getClass().getName().contains("Bomberman") ||
					escenario[(int)puntosExplotan.get(3).getX()][(int)puntosExplotan.get(3).getY()].getClass().getName().contains("Bloque_Destruible"))) {
					Explosion expo3 = new Explosion(puntosExplotan.get(3));
						expo.setImagenAbajo();
						escenario[(int)puntosExplotan.get(3).getX()][(int)puntosExplotan.get(3).getY()] = expo3;
					}

						
				if(	escenario[(int)puntosExplotan.get(4).getX()][(int)puntosExplotan.get(4).getY()] != null &&
					(escenario[(int)puntosExplotan.get(4).getX()][(int)puntosExplotan.get(4).getY()].getClass().getName().contains("Bomberman") ||
					escenario[(int)puntosExplotan.get(4).getX()][(int)puntosExplotan.get(4).getY()].getClass().getName().contains("Bloque_Destruible"))) {
					Explosion expo4 = new Explosion(puntosExplotan.get(4));
					 	expo.setImagenArriba();
						escenario[(int)puntosExplotan.get(4).getX()][(int)puntosExplotan.get(4).getY()] = expo4;
					}
					
				
			}}		});
		tiempo.setRepeats(false);
		tiempo.start();

		
	}
	
//	
//	public  int getWidthImg() {
//		return WIDTH_IMG;
//	}
//	public  int getHeightImg() {
//		return HEIGHT_IMG;
//	}
//	
//	
	
}
