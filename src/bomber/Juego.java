package bomber;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.management.openmbean.KeyAlreadyExistsException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Juego extends JFrame{
	
	private Escenario contentPane;
	private Image ima;
	private Timer reDibujo = new Timer(40, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	});
	
	public Juego() {
		super("Bomberman");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 606, 548);
		
		ima = new ImageIcon("./src/bomber/Imagenes/bombermanIcono.png").getImage();
		setIconImage(ima);
		
		contentPane = new Escenario();
		contentPane.agregarBomberman();
		contentPane.agregarBomberman();
		contentPane.agregarBomberman();
		contentPane.agregarBomberman();
		
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				setMovimiento(arg0);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				confirmarCierreVentana();
			}
		});
		reDibujo.start();
	}
	
	private void confirmarCierreVentana() {
		
		int respuesta = JOptionPane.showConfirmDialog(this, "Desea cerrar esta ventana", "Confirmar para salir", JOptionPane.YES_NO_CANCEL_OPTION);
		if(respuesta == JOptionPane.YES_OPTION ) {
			System.exit(0);
		}	
	}


	public void setMovimiento(KeyEvent evento){
		Bomberman nuevo;
		double movimiento = 5;
		
		if(evento.getKeyCode() == KeyEvent.VK_LEFT) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverIzq(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaIzquieda(-movimiento);
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_RIGHT) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverDer(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaDerecha(movimiento);
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_UP) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverArr(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaArriba(-movimiento);
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_DOWN) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverAba(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaAbajo(movimiento);
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_B) {
			nuevo = contentPane.getBomberman(0);
			Punto coordenada = new Punto(nuevo.getCoordenada().getX(), nuevo.getCoordenada().getY());
			if(contentPane.ponerBomba(coordenada)) {
				contentPane.agregarObjeto(new Bomba(coordenada));
				return;
			}
		}
		
		///  MOVIMIENTO SEGUNDO BOMBERMAN 
		if(evento.getKeyCode() == KeyEvent.VK_A) {
			nuevo = contentPane.getBomberman(1);
			if(contentPane.moverIzq(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaIzquieda(-movimiento);
				contentPane.setBomberman(nuevo,1);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_D) {
			nuevo = contentPane.getBomberman(1);
			if(contentPane.moverDer(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaDerecha(movimiento);
				contentPane.setBomberman(nuevo,1);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_W) {
			nuevo = contentPane.getBomberman(1);
			if(contentPane.moverArr(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaArriba(-movimiento);
				contentPane.setBomberman(nuevo,1);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_S) {
			nuevo = contentPane.getBomberman(1);
			if(contentPane.moverAba(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaAbajo(movimiento);
				contentPane.setBomberman(nuevo,1);
				return;
			}
		}
		//repaint();
	}
	
	


	public static void main(String[] args) {
		new Juego().setVisible(true);
	}

}
