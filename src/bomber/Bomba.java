package bomber;

import javax.swing.ImageIcon;

public class Bomba extends Objeto {
	
	private ImageIcon image;
	
	public Bomba(Punto coordenada) {
		super(coordenada);
		image = new ImageIcon("./src/bomber/Imagenes/bomba.png");
	}

	@Override
	public ImageIcon getImagen() {
		return image;
	}

	
	
	
	
}
