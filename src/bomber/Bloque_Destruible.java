package bomber;

public class Bloque_Destruible extends Objeto{
	
	private boolean estado;
	private static final int BLOQUE = 2;
	
	public Bloque_Destruible() {
	}
	
	public Bloque_Destruible(Punto coordenada) {
		super(coordenada);
		this.estado = true;
	}

	@Override
	public int tipoBloque() {
		return BLOQUE;
	}
	
	
}
