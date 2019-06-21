package bomber;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelMarcador extends JPanel {
	private JPanel panelSuperior;
	private JPanel panelInferior;
	private JLabel marcador1;
	private JLabel jugador;
	private JLabel marcador2;
	private JLabel marcador3;
	private JLabel marcador4;
	private JLabel cro;
	private JLabel ultimoGanador;
	private String gana = "Ultimo Ganador: ";
	private String ganador = "";
//	private String puntaje = "Puntaje: \n";
	private String puntos = "0";
	private JLabel aux = new JLabel();
	private JLabel aux1 = new JLabel();
	private JLabel aux3 = new JLabel();
	private JLabel aux4 = new JLabel();
	private JLabel aux5 = new JLabel();
	private int cantPlayers;
	private Cronometro crono;
	
	public JPanelMarcador(int cantJugadores) {
		cantPlayers = cantJugadores;
		
		setBackground(Color.WHITE);
		panelSuperior = new JPanel();
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.BLACK);
		panelSuperior.setBackground(Color.BLACK);
		GridLayout cp = new GridLayout(2,2);
		GridLayout cd = new GridLayout(1,100);
		GridLayout cg = new GridLayout(1,4);
		cg.setHgap(1);
		cg.setVgap(1);
		cd.setHgap(1);
		cd.setHgap(1);
		cp.setHgap(1);
		cp.setHgap(1);
		panelSuperior.setLayout(cd);
		setLayout(cp);
		panelInferior.setLayout(cg);
		for (int i = 0; i < cantJugadores; i++) {
			jugador = new JLabel("",SwingConstants.LEFT);
			jugador.setIcon(new ImageIcon("./resources/bomberman/mabajo"+i+"1.gif"));
			//add(jugador);
			panelSuperior.add(jugador);
			if(i==0) {
				marcador1 = new JLabel("1",SwingConstants.LEFT);
				marcador1.setForeground(Color.YELLOW);
				//add(marcador1);
				panelSuperior.add(marcador1);
			}
			else if(i==1) {
				marcador2 = new JLabel("1",SwingConstants.LEFT);
				marcador2.setForeground(Color.GREEN);
				//add(marcador2);
				panelSuperior.add(marcador2);
			}else if(i==2) {
				marcador3 = new JLabel("1",SwingConstants.LEFT);
				marcador3.setForeground(Color.RED);
				//add(marcador3);
				panelSuperior.add(marcador3);
			}else if(i==3) {
				marcador4 = new JLabel("1",SwingConstants.LEFT);
				marcador4.setForeground(Color.BLUE);
				
				//add(marcador4);
				panelSuperior.add(marcador4);
			}
			
		}
		panelSuperior.add(aux);
		panelSuperior.add(aux1);
		add(panelSuperior);
		cro = new JLabel("02:00");
		cro.setFont(new Font("Consolas", Font.ROMAN_BASELINE, 20));
		cro.setForeground(Color.WHITE);
		crono = new Cronometro(cro);
		crono.start();
		//add(cro);
		
		ultimoGanador = new JLabel(gana+ganador);
		ultimoGanador.setForeground(Color.WHITE);
		//add(ultimoGanador);
		
		
		panelInferior.add(ultimoGanador);
		panelInferior.add(aux3);
		panelInferior.add(aux4);
		panelInferior.add(aux5);
		panelInferior.add(cro);
		add(panelInferior);
	}

	public void iniciarMarcador() {
		if(cantPlayers>=2) {
			marcador1.setText(puntos);
			marcador2.setText(puntos);
		}
		if(cantPlayers>=3)
			marcador3.setText(puntos);
		if(cantPlayers==4) 
			marcador4.setText(puntos);
	}
	
	
	public Cronometro getReloj() {
		return crono;
	}
	

}

