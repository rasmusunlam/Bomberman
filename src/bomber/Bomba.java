package bomber;

import java.util.ArrayList;

import javax.swing.ImageIcon;

//import org.junit.rules.Timeout;

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
	
	public ArrayList<Punto> explotar(){
		ArrayList<Punto> puntos = new ArrayList<Punto>();
		int x = (int)this.getCoordenada().getX()/Escenario.WIDTH_IMG;
		int y = (int)this.getCoordenada().getY()/Escenario.HEIGHT_IMG;
		
		puntos.add(new Punto(x, y));
		puntos.add(new Punto(x+1, y));
		puntos.add(new Punto(x-1, y));
		puntos.add(new Punto(x, y-1));
		puntos.add(new Punto(x, y+1));
		
		return puntos;
	}

	
	
	
	
}
