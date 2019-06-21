package bomber;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelMarcador extends JPanel {
	
	private JLabel marcador1;
	private JLabel jugador;
	private JLabel marcador2;
	private JLabel marcador3;
	private JLabel marcador4;
	private JLabel cro;
	
	public JPanelMarcador(int cantJugadores) {
		
		setBackground(Color.BLUE);
		GridLayout cp = new GridLayout(1, cantJugadores);
		cp.setHgap(1);
		cp.setHgap(1);
		setLayout(cp);
	
		for (int i = 0; i < cantJugadores; i++) {
			jugador = new JLabel();
			jugador.setIcon(new ImageIcon("./resources/bomberman/mabajo"+i+"1.gif"));
			add(jugador);
			
			if(i==0) {
				marcador1 = new JLabel("1");
				add(marcador1);
			}
			else if(i==1) {
				marcador2 = new JLabel("1");
				add(marcador2);
			}else if(i==2) {
				marcador3 = new JLabel("1");
				add(marcador3);
			}else if(i==3) {
				marcador4 = new JLabel("1");
				add(marcador4);
			}
			
		}
		
		cro = new JLabel("02:00");
		cro.setFont(new Font("Consolas", Font.BOLD, 16));
		Cronometro crono = new Cronometro(cro);
		crono.start();
		
		add(cro);
	}
	

}

