package bomber;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Juego extends JFrame{
	
	private Escenario esc;
	
	public Juego() {
		super("Bomberman");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 548);
		setLocationRelativeTo(null);
		esc = new Escenario();
		esc.agregarBomberman();
		esc.agregarBomberman();
		esc.agregarBomberman();
		esc.agregarBomberman();
		setContentPane(esc);
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				setMovimiento(arg0);
			}
		});
	}
	
	
	public void setMovimiento(KeyEvent evento){
		Bomberman nuevo;
		double movimiento = 5;
		
		if(evento.getKeyCode() == KeyEvent.VK_LEFT) {
			nuevo = esc.getBomberman(0);
			if(esc.moverIzq(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaIzquieda(-movimiento);
				esc.setBomberman(nuevo,0);
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_RIGHT) {
			nuevo = esc.getBomberman(0);
			if(esc.moverDer(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaDerecha(movimiento);
				esc.setBomberman(nuevo,0);
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_UP) {
			nuevo = esc.getBomberman(0);
			if(esc.moverArr(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaArriba(-movimiento);
				esc.setBomberman(nuevo,0);
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_DOWN) {
			nuevo = esc.getBomberman(0);
			if(esc.moverAba(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaAbajo(movimiento);
				esc.setBomberman(nuevo,0);
			}
		}
		
		///  MOVIMIENTO SEGUNDO BOMBERMAN 
		if(evento.getKeyCode() == KeyEvent.VK_A) {
			nuevo = esc.getBomberman(1);
			if(esc.moverIzq(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaIzquieda(-movimiento);
				esc.setBomberman(nuevo,1);
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_D) {
			nuevo = esc.getBomberman(1);
			if(esc.moverDer(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaDerecha(movimiento);
				esc.setBomberman(nuevo,1);
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_W) {
			nuevo = esc.getBomberman(1);
			if(esc.moverArr(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaArriba(-movimiento);
				esc.setBomberman(nuevo,1);
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_S) {
			nuevo = esc.getBomberman(1);
			if(esc.moverAba(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaAbajo(movimiento);
				esc.setBomberman(nuevo,1);
			}
		}
		repaint();
	}
	
	public static void main(String[] args) {
		new Juego().setVisible(true);
	}

}
