package bomber;

import javax.swing.ImageIcon;

public class Bloque_Destruible extends Objeto{
	
	private ImageIcon imagen;
	
	public Bloque_Destruible() {
	}
	
	public Bloque_Destruible(Punto coordenada) {
		super(coordenada);
		imagen = new ImageIcon("./src/bomber/Imagenes/BloqueCC.jpeg");
	}
	
	@Override
	public ImageIcon getImagen() {
		return imagen;
	}
	
}
