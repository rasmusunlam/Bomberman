package bomber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
	private Map<Integer,Bomberman> bombers = new HashMap<Integer,Bomberman>();

	
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
	public Map<Integer,Bomberman> getMapaBombers(){
		return bombers;
	}
	public void agregarBomberman() {
		
		Bomberman bombero;
		
		if(bombers.size()==0) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*1,WIDTH_IMG*1));
			escenario[1][1]=null;
			escenario[1][2]=null;
			escenario[2][1]=null;
			bombers.put(bombero.getIdBomberman(), bombero);
		}else if(bombers.size()==1) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*1,WIDTH_IMG*13));
			escenario[1][13]=null;
			escenario[1][12]=null;
			escenario[2][13]=null;
			bombers.put(bombero.getIdBomberman(), bombero);
		}else if(bombers.size()==2) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*11,WIDTH_IMG*1));
			escenario[11][1]=null;
			escenario[11][2]=null;
			escenario[10][1]=null;
			bombers.put(bombero.getIdBomberman(), bombero);
			
		}
		else if(bombers.size()==3) {
			bombero = new Bomberman(new Punto(HEIGHT_IMG*11,WIDTH_IMG*13));
			escenario[11][13]=null;
			escenario[11][12]=null;
			escenario[10][13]=null;
			bombers.put(bombero.getIdBomberman(), bombero);
			
		}
		
	}
	
	public void setBomberman(Bomberman b , int num) {
		this.bombers.put(b.getIdBomberman(), b);
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
		
		for (Map.Entry<Integer, Bomberman> bombero : bombers.entrySet()) {
			if(bombero.getValue().getVivo()) {
				g.drawImage(bombero.getValue().getImagen().getImage(), (int)bombero.getValue().getCoordenada().getY(), (int)bombero.getValue().getCoordenada().getX(),  WIDTH_IMG,HEIGHT_IMG, null);
			}
		} 
		
	}
	public boolean ponerBomba(Punto coordenada) {
		if((int)coordenada.getX()%HEIGHT_IMG == 0 && (int)coordenada.getY()%WIDTH_IMG == 0)
			return true;
		return false;
	}
	
	public void agregarObjeto(Punto coordenada) {
		                         
			Bomba bomba = new Bomba(coordenada);
			escenario[(int)bomba.getCoordenada().getX()/HEIGHT_IMG][(int)bomba.getCoordenada().getY()/WIDTH_IMG] = bomba;
			ArrayList<Punto> sectorDeExplosion = ((Bomba)escenario[(int)bomba.getCoordenada().getX()/HEIGHT_IMG][(int)bomba.getCoordenada().getY()/WIDTH_IMG]).explotar(); 
			BombaExplosion bom = new BombaExplosion(dibujarExplo(sectorDeExplosion), this.escenario);
			bom.setBomber(bombers);
			bom.start();
			bombers = bom.getBomber();
			this.escenario = bom.actualizar();
			DesaparecerExplosion explo = new DesaparecerExplosion(dibujarExplo(sectorDeExplosion), escenario);
			explo.setBomber(bombers);
			explo.start();
			bombers = explo.getBomber();
			this.escenario = explo.actualizar();
//			bombers.get(0).descontarBomba();
	}

	
	
	public ArrayList<Explosion> dibujarExplo(ArrayList<Punto> puntosExplotan){
		
		ArrayList<Explosion> explosion = new ArrayList<Explosion>();
		Explosion expo;
		
		if (condicionExplosion(puntosExplotan, 0)) {

			expo = new Explosion(puntosExplotan.get(0));
			expo.setImagenCentro();
			explosion.add(expo);

		}
		if (condicionExplosion(puntosExplotan, 1)) {
			
			expo = new Explosion(puntosExplotan.get(1));
			expo.setImagenAbajo();
			explosion.add(expo);

		}
		if (condicionExplosion(puntosExplotan, 2)) {
			expo = new Explosion(puntosExplotan.get(2));
			expo.setImagenArriba();
			explosion.add(expo);
		}
		if (condicionExplosion(puntosExplotan, 3)) {
			expo = new Explosion(puntosExplotan.get(3));
			expo.setImagenIzquierda();
			explosion.add(expo);
		}
		if (condicionExplosion(puntosExplotan, 4)) {
			expo = new Explosion(puntosExplotan.get(4));
			expo.setImagenDerecha();
			explosion.add(expo);
		}

		return explosion;
	
	}
	
	
//	public void dibujarExplosion(ArrayList<Explosion> puntosExplotan, int time) {
//		
//		
//		Timer tiempo = new Timer(time, new  ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				 for (Explosion explo : puntosExplotan) {
//					 if( escenario[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()]!=null&&
//							 escenario[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()].getClass().getName().contains("Bomba")
//							 && !explo.tipoExplo().equals("Centro")){
//						 
//						 escenario[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()] = new Bomba(explo.getCoordenada());
//						 ArrayList<Punto> sectorDeExplosion =  ((Bomba)escenario[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()]).explotar();
//						 dibujarExplosion(dibujarExplo(sectorDeExplosion),4000);	
//						 modificar(dibujarExplo(sectorDeExplosion),0);
//					 }
//					 else{
//					 escenario[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()] = explo;
//					 }
//				 }
//			}
//
//		});
//		tiempo.setRepeats(false);
//		tiempo.start();
//		
//	}
	
	
	
	private boolean condicionExplosion(ArrayList<Punto> puntosExplotan,int n) {
		return escenario[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()] == null||
			escenario[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()].getClass().getName().contains("Bloque_Destruible")||
			escenario[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()].getClass().getName().contains("Bomba");
	}	
	
//	public void modificar (ArrayList<Explosion> sector,int time) {
//		
//		Timer tiempo2 = new Timer(time, new  ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				for (Explosion punto : sector) {
//
//					for (Bomberman bomber : bombers) {
//						Punto p = new Punto(bomber.getCoordenada().getX()/40,bomber.getCoordenada().getY()/40);
//						
//						if(p.equals(punto.getCoordenada())) {
//							bomber.morir();
//						}
//					}
//					escenario[(int)punto.getCoordenada().getX()][(int)punto.getCoordenada().getY()]=null;
//					
//				}
//			}
//			
//	
//		});
//		
//		tiempo2.setRepeats(false);
//		tiempo2.start();
//	}
//	
	
	
	
	

}
