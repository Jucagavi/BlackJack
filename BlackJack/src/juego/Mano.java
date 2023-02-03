package juego;

import java.util.ArrayList;

public class Mano extends Mazo {
	public Mano() {
		cartas = new ArrayList<Carta>();
	}
	
	public int valorMano () {
		int puntos=0;
		for (Carta c: cartas) {
			puntos=puntos+c.getValor();
		}
		return puntos;
	}

	public boolean finDeJuego() {
		if (valorMano()>=21) {
			return true;
		} else {
			return false;
		}
	}

	public void pedirCarta(Mazo m) throws NoHayCartasException {
		Carta c = m.solicitarCarta();
		this.cartas.add(c);
	}

	public String toString() {
		return ""+valorMano()+"\n"+ super.toString();
	}
}
