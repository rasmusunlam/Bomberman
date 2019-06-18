package bomber;

import javax.swing.ImageIcon;

public class Explosion extends Objeto{
	
	
	private ImageIcon image;
	private String tiploExplo;
	
	public Explosion(Punto coordenada) {
		super(coordenada);
		//image = new ImageIcon("./src/bomber/Imagenes/bomba.png");
	}

	
	public void setImagenIzquierda() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionIzquierda.png");
		tiploExplo = "Izquierda";
	}
	
	public void setImagenDerecha() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionDerecha.png");
		tiploExplo = "Derecha";
	}
	
	public void setImagenAbajo() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionAbajo.png");
		tiploExplo = "Abajo";
	}
	
	public void setImagenArriba() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionArriba.png");
		tiploExplo = "Arriba";
	}
	
	public void setImagenCentro() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionMedio.png");
		tiploExplo = "Centro";
	}

	public String tipoExplo() {
		return tiploExplo;
	}
	@Override
	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return this.image;
	}

}
