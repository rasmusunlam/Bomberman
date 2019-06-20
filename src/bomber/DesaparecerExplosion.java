package bomber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

public class DesaparecerExplosion extends Thread {
	
	private ArrayList<Explosion> sector;
	private int tiempo;
	private Objeto[][] esc;
	private Map<Integer,Bomberman> bomber = new HashMap<Integer,Bomberman>();
	
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
						for (Map.Entry<Integer, Bomberman> bomberman : bomber.entrySet()) {
						Punto p = new Punto((int)bomberman.getValue().getCoordenada().getX()/40,(int)bomberman.getValue().getCoordenada().getY()/40);
						if(p.equals(punto.getCoordenada()))
							bomberman.getValue().morir();
					}}
					esc[(int)punto.getCoordenada().getX()][(int)punto.getCoordenada().getY()] = null;

				}
				bomber.get(0).descontarBomba();
				
			}
		});
		time.setRepeats(false);
		time.start();
	
	}
	
	public Objeto[][] actualizar(){
		return esc;
	}
	public Map<Integer,Bomberman> getBomber() {
		return bomber;
	}
	public void setBomber(Map<Integer,Bomberman> bomber) {
		this.bomber = bomber;
	}
	

}
