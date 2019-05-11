package juego.taller;

import org.junit.Assert;
import org.junit.Test;

public class TestEscenario {

	@Test
	public void moverBombermanAbajo() {

		Escenario escenario = new Escenario();
		Bomberman bomber = new Bomberman();
		escenario.crearJugador(bomber);
		Assert.assertEquals(true, bomber.moverHaciaAbajo(escenario));
		escenario.dibujar();

	}

	@Test
	public void moverBombermanArriba() {

		Escenario escenario = new Escenario();
		Bomberman bomber = new Bomberman();
		escenario.crearJugador(bomber);
		Assert.assertEquals(false, bomber.moverHaciaArriba(escenario));
		escenario.dibujar();
	}

	@Test
	public void moverBombermanIzquierda() {

		Escenario escenario = new Escenario();
		Bomberman bomber = new Bomberman();
		escenario.crearJugador(bomber);
		Assert.assertEquals(false, bomber.moverHaciaIzq(escenario));
		escenario.dibujar();
	}

	@Test
	public void moverBombermanDerecha() {

		Escenario escenario = new Escenario();
		Bomberman bomber = new Bomberman();
		escenario.crearJugador(bomber);
		Assert.assertEquals(true, bomber.moverHaciaDer(escenario));
		escenario.dibujar();

	}

	@Test
	public void explotarBomba() {
		Escenario escenario = new Escenario();
		Bomberman bomber = new Bomberman();
		Bomba bomba = new Bomba();
		escenario.crearJugador(bomber);
		escenario.crearBomba(bomba);
		escenario.dibujar();
		bomba.explotar(escenario);
		escenario.dibujar();
		Assert.assertEquals(2, escenario.getObjeto(bomba.getPosicionX(), bomba.getPosicionY()));
		Assert.assertEquals(2, escenario.getObjeto(bomber.getPosicionX(), bomba.getPosicionY()));

	};

}
