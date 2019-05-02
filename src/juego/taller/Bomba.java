package juego.taller;

public class Bomba {
	protected int posicionX;
	protected int posicionY;
	public Bomba(){		
	}
	
	public Bomba(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
		
	public boolean explotar(Escenario esc){
		
		esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX, this.posicionY);
		boolean obstaculo = false;
		int i=1;
		while(!obstaculo && i<=2){
			if((esc.getObjeto(this.posicionX + i, this.posicionY) == Escenario.BLOQUE_DESTRUIBLE)||
			   (esc.getObjeto(this.posicionX + i, this.posicionY) == Escenario.JUGADOR_1)){
					esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX + i, this.posicionY);
					obstaculo = true;
				}else if(esc.getObjeto(this.posicionX + i, this.posicionY) == Escenario.JUGADOR_1){
					System.out.println("Eploto la otra bomba");
				}
			i++;
		}	
		obstaculo = false;
		i=1;
		while(!obstaculo && i<=2){
			if(this.posicionX - i >= 0){
				if((esc.getObjeto(this.posicionX - i, this.posicionY) == Escenario.BLOQUE_DESTRUIBLE)||
				   (esc.getObjeto(this.posicionX - i, this.posicionY) == Escenario.JUGADOR_1)){
						esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX - i, this.posicionY);
						obstaculo = true;
					}else if(esc.getObjeto(this.posicionX - i, this.posicionY) == Escenario.JUGADOR_1){
						System.out.println("Exploto la otra bomba");
					}
			}
			i++;
		}
		obstaculo = false;
		i=1;
		while(!obstaculo && i<=2){
			if((esc.getObjeto(this.posicionX , this.posicionY + i) == Escenario.BLOQUE_DESTRUIBLE)||
			   (esc.getObjeto(this.posicionX , this.posicionY + i) == Escenario.JUGADOR_1)){
					esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX, this.posicionY + i);
					obstaculo = true;
				}else if(esc.getObjeto(this.posicionX, this.posicionY + i) == Escenario.JUGADOR_1){
					System.out.println("Exploto la otra bomba");
				}
			i++;
		}
		obstaculo = false;
		i=1;
		while(!obstaculo && i<=2){
			if(this.posicionY - i >= 0 ){
				if((esc.getObjeto(this.posicionX , this.posicionY - i) == Escenario.BLOQUE_DESTRUIBLE)||
				   (esc.getObjeto(this.posicionX , this.posicionY - i) == Escenario.JUGADOR_1)){
						esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX, this.posicionY - i);
						obstaculo = true;
					}else if(esc.getObjeto(this.posicionX, this.posicionY - i) == Escenario.JUGADOR_1){
						System.out.println("Exploto la otra bomba");
					}
		
			}
			i++;
		}
		obstaculo = false;
		i=1;
		while(!obstaculo && i<=2){
			if(this.posicionX - i>=0 && this.posicionY - i>=0){
				if((esc.getObjeto(this.posicionX - i , this.posicionY - i) == Escenario.BLOQUE_DESTRUIBLE)||
				   (esc.getObjeto(this.posicionX - i , this.posicionY - i) == Escenario.JUGADOR_1)){
						esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX - i, this.posicionY - i);
						obstaculo = true;
					}else if(esc.getObjeto(this.posicionX - i, this.posicionY - i) == Escenario.JUGADOR_1){
						System.out.println("Exploto la otra bomba");
					}				
			}
			i++;
		}
		obstaculo = false;
		i=1;
		while(!obstaculo && i<=2){
			if((esc.getObjeto(this.posicionX + i, this.posicionY + i) == Escenario.BLOQUE_DESTRUIBLE)||
			   (esc.getObjeto(this.posicionX + i, this.posicionY + i) == Escenario.JUGADOR_1)){
					esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX + i, this.posicionY + i);
					obstaculo = true;
				}else if(esc.getObjeto(this.posicionX + i, this.posicionY + i) == Escenario.JUGADOR_1){
					System.out.println("Exploto la otra bomba");
				}
			i++;
		}
		obstaculo = false;
		i=1;
		while(!obstaculo && i<=2){
			if(this.posicionX - i >= 0){
				if((esc.getObjeto(this.posicionX - i, this.posicionY + i) == Escenario.BLOQUE_DESTRUIBLE)||
				   (esc.getObjeto(this.posicionX - i, this.posicionY + i) == Escenario.JUGADOR_1)){
						esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX - i, this.posicionY + i);
						obstaculo = true;
					}else if(esc.getObjeto(this.posicionX - i, this.posicionY + i) == Escenario.JUGADOR_1){
						System.out.println("Exploto la otra bomba");
					}
				
			}
			i++;
		}
		obstaculo = false;
		i=1;
		while(!obstaculo && i<=2){
			if(this.posicionY - i >= 0){
				if((esc.getObjeto(this.posicionX + i, this.posicionY - i) == Escenario.BLOQUE_DESTRUIBLE)||
				   (esc.getObjeto(this.posicionX + i, this.posicionY - i) == Escenario.JUGADOR_1)){
						esc.setObjeto(Escenario.ESPACIO_EN_BLANCO, this.posicionX + i, this.posicionY - i);
						obstaculo = true;
					}else if(esc.getObjeto(this.posicionX + i, this.posicionY - i) == Escenario.JUGADOR_1){
						System.out.println("Exploto la otra bomba");
					}
				
			}
			i++;
		}
		

		
		return false; 
	}
	
}
