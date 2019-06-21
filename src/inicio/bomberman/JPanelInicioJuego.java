package inicio.bomberman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomber.Juego;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelInicioJuego extends JPanel {

	/**
	 * Create the panel.
	 */
	private ImageIcon imagen;
	private JFrame inicio;
	public JPanelInicioJuego(JFrame in) {
		inicio = in;
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego juego = new Juego();
				juego.setVisible(true);
				in.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(313, Short.MAX_VALUE)
					.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		imagen = new ImageIcon("./src/bomber/Imagenes/FondoBomberman.jpeg");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), null);
	}


}
