package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import juego.Carta.Palo;

public class Mazo {
	protected List<Carta> cartas;

	public Mazo() {
		this.cartas = new ArrayList<Carta>();
		for (Palo p: Palo.values()) {
			for (int i=1; i<14; i++) {
				Carta nueva = new Carta(i,p);
				cartas.add(nueva);	
			}
		}
	}
	
	public void barajar() {
		Collections.shuffle(cartas);
	}

	public Carta solicitarCarta() throws NoHayCartasException {
		if (cartas.size()==0) {
			throw new NoHayCartasException();
		}
		Carta solicitada = cartas.get(0);
		cartas.remove(0);
		return solicitada;
	}

	public String toString() {
		String res="";
		for (Carta c: cartas) {
			res=res+c+"\n";
		}
		return res;
	}
}