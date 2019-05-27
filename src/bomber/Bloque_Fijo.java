package bomber;

import javax.swing.ImageIcon;

public class Bloque_Fijo extends Objeto {
	
	private ImageIcon imagen;
	
	public Bloque_Fijo() {
	}
	public Bloque_Fijo(Punto coordenada) {
		super(coordenada);
		imagen = new ImageIcon("./src/bomber/Imagenes/bloqueDD.jpeg");
	}
	
	@Override
	public ImageIcon getImagen() {
		return imagen;
	}
	
}
