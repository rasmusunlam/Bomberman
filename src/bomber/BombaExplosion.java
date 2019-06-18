package bomber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.Timer;

public class BombaExplosion extends Thread{

	private ArrayList<Explosion> sector;
	private int tiempo;
	private Objeto[][] esc;
	private ArrayList<Bomberman> bomber;
	
	
	public BombaExplosion(ArrayList<Explosion> lista,Objeto[][] escenario) {
		sector = lista;
		tiempo = 3000;
		esc = escenario;
		
	}
	public  BombaExplosion(ArrayList<Explosion> lista, int tiempo,Objeto[][] escenario) {
		sector=lista;
		this.tiempo = tiempo;
		esc=escenario;
	}
	
	@Override
	public void run() {
		
		Timer time = new Timer(tiempo, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Explosion explo : sector) {
					if(esc[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()]!=null &&
							esc[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()].getClass().getName().contains("Bomba")
								&& !explo.tipoExplo().equals("Centro")) {
						
						Bomba bomba = (Bomba)esc[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()];
						BombaExplosion b = new BombaExplosion(dibujarExplo(bomba.explotar()),0, esc);
						b.start();
						esc = b.actualizar();
						DesaparecerExplosion c = new DesaparecerExplosion(dibujarExplo(bomba.explotar()),1000, esc);
						c.setBomber(bomber);
						c.start();
						bomber = c.getBomber();
						esc=c.actualizar();
					}
					
					esc[(int)explo.getCoordenada().getX()][(int)explo.getCoordenada().getY()] = explo;
					
				}
				
			}
		});
		time.setRepeats(false);
		time.start();
		
		

	}
	
	public Objeto[][] actualizar(){
		return esc;
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
	private boolean condicionExplosion(ArrayList<Punto> puntosExplotan,int n) {
		return esc[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()] == null||
			esc[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()].getClass().getName().contains("Bloque_Destruible")||
			esc[(int)puntosExplotan.get(n).getX()][(int)puntosExplotan.get(n).getY()].getClass().getName().contains("Bomba");
	}
	public ArrayList<Bomberman> getBomber() {
		return bomber;
	}
	public void setBomber(ArrayList<Bomberman> bomber) {
		this.bomber = bomber;
	}	

	
}
