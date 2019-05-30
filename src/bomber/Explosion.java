package bomber;

import javax.swing.ImageIcon;

public class Explosion extends Objeto{
	
	
	private ImageIcon image;
	
	public Explosion(Punto coordenada) {
		super(coordenada);
		//image = new ImageIcon("./src/bomber/Imagenes/bomba.png");
	}

	
	public void setImagenIzquierda() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionIzquierda.png");
	}
	
	public void setImagenDerecha() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionDerecha.png");
	}
	
	public void setImagenAbajo() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionAbajo.png");
	}
	
	public void setImagenArriba() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionArriba.png");
	}
	
	public void setImagenCentro() {
		this.image = new ImageIcon("./src/bomber/Imagenes/ExplosionMedio.png");
	}


	@Override
	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return this.image;
	}

}
