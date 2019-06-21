package bomber;

import javax.swing.JLabel;

public class Cronometro extends Thread{

	JLabel crono;
	
	public Cronometro(JLabel cronomentro) {
		this.crono = cronomentro;
	}
	
	@Override
	public void run() {
		try {
			int min, sec = 60;
			min = 1;
			while(min>-1) {
				Thread.sleep(1000);
				sec--;
				if(sec<10)
					crono.setText("0"+min+":0"+sec);
				else
					crono.setText("0"+min+":"+sec);
				
				if(sec == 0) {
					sec =60;
					min--;
				}
			}
		} catch (Exception e) {
			System.out.println("Error en el hilo: "+ e.getMessage());
		}
	}
	
	public JLabel getCrono() {
		return crono;
	}

}
