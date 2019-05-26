package inicio.bomberman;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JInicioJogo extends JFrame {

	private JPanelInicioJuego contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInicioJogo frame = new JInicioJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JInicioJogo() {
		setTitle("Inicio del Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image ima = new ImageIcon("./src/bomber/Imagenes/bombermanIcono.png").getImage();
		setIconImage(ima);
		setResizable(false);
		setSize(500, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanelInicioJuego(this);
		setContentPane(contentPane);
	}

}
