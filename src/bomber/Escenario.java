package bomber;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Escenario extends JPanel {
	
	private static final int TAM=13;
	private static final int TAM2=15;
	private Objeto[][] escenario;
	private ImageIcon bloqueF;
	private ImageIcon bloqueD;
	private ImageIcon bomber;
	
	public Escenario() {
		this.escenario = new Objeto[TAM][TAM2];
		bloqueF = new ImageIcon("./src/bomber/Imagenes/bloqueP.png");
		bloqueD = new ImageIcon("./src/bomber/Imagenes/bloqueO.png");
		Random aleatorio = new Random(System.currentTimeMillis());
		Bloque_Fijo bloque;
		Bloque_Destruible bloqueDestruible;
		for(int i=0; i<TAM; i++) {
			for(int j=0; j<TAM2; j++) {
				if(i==0 || i==TAM-1 || j==0 || j==TAM2-1 || (i%2==0 && j%2==0)) { 
					bloque = new Bloque_Fijo(new Punto(i,j));
					escenario[i][j] = bloque;
				}else {
					if(aleatorio.nextInt(2) == 1) {
						bloqueDestruible = new Bloque_Destruible(new Punto(i,j));
						escenario[i][j] = bloqueDestruible;
					}
				}
			}
		}

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(10,170,22));
		
		for(int i=0; i<TAM; i++) {
			for(int j=0; j<TAM2; j++) {
				if(i==0 || i==TAM-1 || j==0 || j==TAM2-1 || (i%2==0 && j%2==0) && escenario[i][j] != null) {
					g.drawImage(bloqueF.getImage(),j*40 , i*40 , 40,40,null);
				}else if((i%2!=0 || j%2!=0) && escenario[i][j] != null)
					g.drawImage(bloqueD.getImage(),j*40 , i*40 , 40,40,null);
			}
		}
		
		
		
	}
	
	
}
