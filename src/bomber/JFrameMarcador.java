
package bomber;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JFrameMarcador  extends JFrame{
	
	private JPanelMarcador marcador;
	
	public JFrameMarcador() {
		
		super("Titulo de ventana");
		 setSize(500, 100);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 marcador = new JPanelMarcador(4);
		 setContentPane(marcador);
	}
	
	public static void main(String[] args) {
		new JFrameMarcador().setVisible(true);;
	}

}
