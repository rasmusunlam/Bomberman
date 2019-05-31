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
//	private ImageIcon bomber1 = new ImageIcon("./src/bomber/Imagenes/Bomberman1.png");
//	private ImageIcon bomber2 = new ImageIcon("./src/bomber/Imagenes/Bomberman2.png");
//	private ImageIcon bomber3 = new ImageIcon("./src/bomber/Imagenes/Bomberman3.png");
//	private ImageIcon bomber4 = new ImageIcon("./src/bomber/Imagenes/Bomberman4.png");
	
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
			bombero = new Bomberman(new Punto(HEIGHT_IMG*1,WIDTH_IMG*1));
			escenario[1][1]=null;
			escenario[1][2]=null;
			escenario[2][1]=null;
			bombers.add(bombero);
		}else if(bombers.size()==1) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*1,WIDTH_IMG*13));
			escenario[1][13]=null;
			escenario[1][12]=null;
			escenario[2][13]=null;
			bombers.add(bombero);
		}else if(bombers.size()==2) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*11,WIDTH_IMG*1));
			escenario[11][1]=null;
			escenario[11][2]=null;
			escenario[10][1]=null;
			bombers.add(bombero);
		}
		else if(bombers.size()==3) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*11,WIDTH_IMG*13));
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
		
		if(x%HEIGHT_IMG == 0 && (escenario[x/HEIGHT_IMG][j/WIDTH_IMG] == null||escenario[x/HEIGHT_IMG][(j/WIDTH_IMG)].getClass().getName().contains("Explosion"))) {
			return true;
		}
		return false;
	}
	public boolean moverDer(Punto punto, double mov) {
		
		int x = (int)punto.getX();
		int j = (int) punto.getY();
		if(x%HEIGHT_IMG == 0 && (escenario[x/HEIGHT_IMG][(j/WIDTH_IMG)+1] == null||escenario[x/HEIGHT_IMG][(j/WIDTH_IMG)+1].getClass().getName().contains("Explosion"))) {
			return true;
		}
		return false;
	}
	public boolean moverArr(Punto punto, double mov) {
		
		int x = (int)punto.getX()-(int)mov;
		int j = (int)punto.getY();
		
		if(j%WIDTH_IMG == 0 && (escenario[x/HEIGHT_IMG][j/WIDTH_IMG] == null||escenario[x/HEIGHT_IMG][(j/WIDTH_IMG)].getClass().getName().contains("Explosion")) ){
			return true;
		}
		return false;
	}
	public boolean moverAba(Punto punto, double mov) {
		
		int x = (int)punto.getX();
		int j = (int) punto.getY();
		
		if(j%WIDTH_IMG==0 && (escenario[(x/HEIGHT_IMG)+1][j/WIDTH_IMG]== null||escenario[(x/HEIGHT_IMG)+1][(j/WIDTH_IMG)].getClass().getName().contains("Explosion")) ){
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
			if(bombero.getVivo()) {
				g.drawImage(bombero.getImagen().getImage(), (int)bombero.getCoordenada().getY(), (int)bombero.getCoordenada().getX(),  WIDTH_IMG,HEIGHT_IMG, null);
			}
		} 
		
	}
	public boolean ponerBomba(Punto coordenada) {
		if((int)coordenada.getX()%HEIGHT_IMG == 0 && (int)coordenada.getY()%WIDTH_IMG == 0)
			return true;
		return false;
	}
	
	public void agregarObjeto(Bomba bomba) {
		escenario[(int)bomba.getCoordenada().getX()/HEIGHT_IMG][(int)bomba.getCoordenada().getY()/WIDTH_IMG] = bomba;
		ArrayList<Punto> sectorDeExplosion = ((Bomba)escenario[(int)bomba.getCoordenada().getX()/HEIGHT_IMG][(int)bomba.getCoordenada().getY()/WIDTH_IMG]).explotar(); 
		ArrayList<Punto> explosion;
		explosion = dibujarExplosion(sectorDeExplosion);
		modificar(explosion);		
	}
	
	
	public ArrayList<Punto> dibujarExplosion(ArrayList<Punto> puntosExplotan) {
		ArrayList<Punto> explosion = new ArrayList<Punto>();
		Timer tiempo = new Timer(3000, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(	condicionExplosion(puntosExplotan,0)) {
						
						Explosion expo = new Explosion(puntosExplotan.get(0));
						expo.setImagenCentro();
						escenario[(int)puntosExplotan.get(0).getX()][(int)puntosExplotan.get(0).getY()] = expo ;
						explosion.add(puntosExplotan.get(0));
					
				}				
				if(condicionExplosion(puntosExplotan,1)){
					
						Explosion expo1 = new Explosion(puntosExplotan.get(1));
						expo1.setImagenAbajo();
						escenario[(int)puntosExplotan.get(1).getX()][(int)puntosExplotan.get(1).getY()] = expo1;	
						explosion.add(puntosExplotan.get(1));
					
				}
				if(	condicionExplosion(puntosExplotan,2)) {
					Explosion expo2 = new Explosion(puntosExplotan.get(2));
						expo2.setImagenArriba();
						escenario[(int)puntosExplotan.get(2).getX()][(int)puntosExplotan.get(2).getY()] = expo2;
						explosion.add(puntosExplotan.get(2));
				}
				if(	condicionExplosion(puntosExplotan,3)) {
					Explosion expo3 = new Explosion(puntosExplotan.get(3));
						expo3.setImagenIzquierda();
						escenario[(int)puntosExplotan.get(3).getX()][(int)puntosExplotan.get(3).getY()] = expo3;
						explosion.add(puntosExplotan.get(3));
				}		
				if(	condicionExplosion(puntosExplotan,4)) {
					Explosion expo4 = new Explosion(puntosExplotan.get(4));
					 	expo4.setImagenDerecha();
						escenario[(int)puntosExplotan.get(4).getX()][(int)puntosExplotan.get(4).getY()] = expo4;
						explosion.add(puntosExplotan.get(4));
				}	
			}

		});
		tiempo.setRepeats(false);
		tiempo.start();
		return explosion;
	}
	
	private boolean condicionExplosion(ArrayList<Punto> puntosExplotan,int n) {
		return escenario[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()] == null ||
			(escenario[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()].getClass().getName().contains("Bomberman") ||
			escenario[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()].getClass().getName().contains("Bloque_Destruible")||
			escenario[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()].getClass().getName().contains("Bomba"));
	}	
	
	public void modificar (ArrayList<Punto> sector) {
		
		Timer tiempo = new Timer(4000, new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Punto punto : sector) {
					if(escenario[(int)punto.getX()][(int)punto.getY()].getClass().getName().contains("Bomba")) {
						Bomba bomba = (Bomba)escenario[(int)punto.getX()][(int)punto.getY()];
						bomba.explotar();
					}
					escenario[(int)punto.getX()][(int)punto.getY()]=null;
					
					for (Bomberman bomber : bombers) {
						Punto p = new Punto(bomber.getCoordenada().getX()/40,bomber.getCoordenada().getY()/40);
						if(p.equals(punto)) {
							bomber.morir();
						}
					}
				}
			}
		});
		
		tiempo.setRepeats(false);
		tiempo.start();
	}
	
}
