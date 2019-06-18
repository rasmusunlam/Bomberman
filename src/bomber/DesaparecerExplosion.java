package bomber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.Timer;

public class DesaparecerExplosion extends Thread {
	
	private ArrayList<Explosion> sector;
	private int tiempo;
	private Objeto[][] esc;
	private ArrayList<Bomberman> bomber;
	
	public DesaparecerExplosion(ArrayList<Explosion> lista,Objeto[][] escenario) {
		sector = lista;
		tiempo = 4000;
		esc = escenario;
		
	}
	public DesaparecerExplosion(ArrayList<Explosion> lista, int tiempo,Objeto[][] escenario) {
		sector=lista;
		this.tiempo = tiempo;
		esc=escenario;

	}
	
	@Override
	public void run() {
		
		Timer time = new Timer(tiempo, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Explosion punto : sector) {
					if(!bomber.isEmpty()) {
						for (Bomberman bomberman : bomber) {
						Punto p = new Punto((int)bomberman.getCoordenada().getX()/40,(int)bomberman.getCoordenada().getY()/40);
						if(p.equals(punto.getCoordenada()))
							bomberman.morir();
					}}
					esc[(int)punto.getCoordenada().getX()][(int)punto.getCoordenada().getY()] = null;

				}
				
			}
		});
		time.setRepeats(false);
		time.start();
	
	}
	
	public Objeto[][] actualizar(){
		return esc;
	}
	public ArrayList<Bomberman> getBomber() {
		return bomber;
	}
	public void setBomber(ArrayList<Bomberman> bomber) {
		this.bomber = bomber;
	}
	

}
