package bomber;

public class Punto {
	
	private Double x;
	private Double y;
	
	public Punto() {
	}
	
	public Punto(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public Double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void desplazar(double deltaX, double deltaY) {
		this.x += deltaX;
		this.y += deltaY;
	}
}
