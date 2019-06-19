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
	private boolean arriba, abajo, izquierda, derecha;
	private boolean ponerBomb;
	
	
	private Timer reDibujo = new Timer(10, new ActionListener() {
		
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

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent arg0) { //CUANDO SE PRESIONA UNA TECLA
				//setMovimiento(arg0);
				movimientoTrue(arg0);
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) { //CUANDO SE DEJA DE PRESIONAR.
				movimientoFalse(arg0);
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
	
	
	private void movimientoTrue(KeyEvent e){
		
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				arriba = true;
				break;
			case KeyEvent.VK_DOWN:
				abajo = true;
				break;
			case KeyEvent.VK_LEFT:
				izquierda = true;
				break;	
			case KeyEvent.VK_RIGHT:
				derecha = true;
				break;
			case KeyEvent.VK_B:
				ponerBomb = true;

		}
		
	}
	
	private void movimientoFalse(KeyEvent e){
		
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				arriba = false;
				break;
			case KeyEvent.VK_DOWN:
				abajo = false;
				break;
			case KeyEvent.VK_LEFT:
				izquierda = false;
				break;
			case KeyEvent.VK_RIGHT:
				derecha = false;
				break;
			case KeyEvent.VK_B:
				ponerBomb = false;

		}
	}
	
	public void mover(){
		
		Bomberman nuevo;
		double movimiento = 10;
		
		if(arriba) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverArr(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaArriba(-movimiento);
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		
		if(abajo) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverAba(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaAbajo(movimiento);
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		
		if(izquierda) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverIzq(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaIzquieda(-movimiento);
				//nuevo.setImagIzq();
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		
		if(derecha) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverDer(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaDerecha(movimiento);
				//nuevo.setImagDer();
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		
		if(ponerBomb) {
			nuevo = contentPane.getBomberman(0);
			Punto coordenada = new Punto(nuevo.getCoordenada().getX(), nuevo.getCoordenada().getY());
			contentPane.agregarObjeto(coordenada);
			return;
		
		}
		
		//repaint();
		
	}


	/*public void setMovimiento(KeyEvent evento){
		Bomberman nuevo;
		double movimiento = 10;
		
		
		if(evento.getKeyCode() == KeyEvent.VK_LEFT) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverIzq(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaIzquieda(-movimiento);
				nuevo.setImagIzq();
				contentPane.setBomberman(nuevo,0);
				return;
			}
		}
		if(evento.getKeyCode() == KeyEvent.VK_RIGHT) {
			nuevo = contentPane.getBomberman(0);
			if(contentPane.moverDer(nuevo.getCoordenada(),movimiento)) {
				nuevo.moverHaciaDerecha(movimiento);
				nuevo.setImagDer();
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
			contentPane.agregarObjeto(coordenada);
			return;
		
		}*/
		
		///  MOVIMIENTO SEGUNDO BOMBERMAN 
//		if(evento.getKeyCode() == KeyEvent.VK_A) {
//			nuevo = contentPane.getBomberman(1);
//			if(contentPane.moverIzq(nuevo.getCoordenada(),movimiento)) {
//				nuevo.moverHaciaIzquieda(-movimiento);
//				nuevo.setImagIzq();
//				contentPane.setBomberman(nuevo,1);
//				return;
//			}
//		}
//		if(evento.getKeyCode() == KeyEvent.VK_D) {
//			nuevo = contentPane.getBomberman(1);
//			if(contentPane.moverDer(nuevo.getCoordenada(),movimiento)) {
//				nuevo.moverHaciaDerecha(movimiento);
//				nuevo.setImagDer();
//				contentPane.setBomberman(nuevo,1);
//				return;
//			}
//		}
//		if(evento.getKeyCode() == KeyEvent.VK_W) {
//			nuevo = contentPane.getBomberman(1);
//			if(contentPane.moverArr(nuevo.getCoordenada(),movimiento)) {
//				nuevo.moverHaciaArriba(-movimiento);
//				contentPane.setBomberman(nuevo,1);
//				return;
//			}
//		}
//		if(evento.getKeyCode() == KeyEvent.VK_S) {
//			nuevo = contentPane.getBomberman(1);
//			if(contentPane.moverAba(nuevo.getCoordenada(),movimiento)) {
//				nuevo.moverHaciaAbajo(movimiento);
//				contentPane.setBomberman(nuevo,1);
//				return;
//			}
//		}
//		if(evento.getKeyCode() == KeyEvent.VK_E) {
//			nuevo = contentPane.getBomberman(1);
//			Punto coordenada = new Punto(nuevo.getCoordenada().getX(), nuevo.getCoordenada().getY());
//			if(contentPane.ponerBomba(coordenada)) {
//				contentPane.agregarObjeto(new Bomba(coordenada));
//				return;
//			}
//		}
		//repaint();
	//}
	
	


	public static void main(String[] args) {
		
		Juego juego = new Juego();
		juego.setVisible(true);
		
			while (true) {
				try {
					Thread.sleep(60); //Le doy cierto tiempo por ciclo. Si esto el bomber tendria Hipervelocidad(?
					juego.mover();
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
	}

}
