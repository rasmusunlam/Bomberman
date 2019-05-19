package bomber;

import java.awt.Color;

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
		setContentPane(esc);
		
	}
	
	public static void main(String[] args) {
		new Juego().setVisible(true);
	}

}
