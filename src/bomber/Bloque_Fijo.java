package bomber;


public class Bloque_Fijo extends Objeto {
	
	private boolean estado;
	private static final int BLOQUE = 1;
	
	public Bloque_Fijo() {
		
	}
	public Bloque_Fijo(Punto coordenada) {
		super(coordenada);
		estado = true;
	}
	@Override
	public int tipoBloque() {
		return BLOQUE;
	}
	
	
}
