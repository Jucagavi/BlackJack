package juego;

import java.util.Scanner;
import juego.Mano;
import juego.Mazo;

public class Juego {
	
	private static Mazo baraja;
	private static Mano jugador;
	private static Mano banca;
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		iniciaJuego();
		String respuesta="";
		do {
			try {
				iniciaJuego();
				
				
				do {
					System.out.println("¿Quiéres carta (S/N):");
					respuesta = teclado.nextLine();
					
					if (respuesta.equalsIgnoreCase("S")) {
						jugador.pedirCarta(baraja);
						System.out.println("Tus cartas son: "+jugador);
					} else if (respuesta.equalsIgnoreCase("n")){
						// El usuario se planta
						System.out.println("Te has plantado con "+jugador);
					} else {
						System.out.println("Debe introducir S o N");
					}
					
				} while (!respuesta.equalsIgnoreCase("n")
						&& !jugador.finDeJuego());
				
				juegaBanca();
				
				if (jugador.valorMano()>21) {
					System.out.println("Te has pasado. ");
					if (banca.valorMano()>21) {
						System.out.println("Nadie gana");
					} else {
						System.out.println("¡Gana la banca! ¡Sigue"
								+ " intentándolo!");
					}
				} else {
					if (banca.valorMano()>21) {
						System.out.println("¡Enhorabuena! ¡Has ganado!");
					} else {
						if (banca.valorMano()>=jugador.valorMano()) {
							System.out.println("¡Gana la banca! ¡Sigue"
									+ " intentándolo!");
						} else {
							System.out.println("¡Enhorabuena! ¡Has ganado!");
						}
					}
				}				
				
			}catch(NoHayCartasException e) {
				System.out.println("No hay mas cartas en la baraja.\n"
						+ "Fin de juego");
				System.out.println("Tus cartas son:"+jugador);
				System.out.println("Cartas de la banca: "+banca);
			}
			
			System.out.println("¿Quiéres echar otra partida (S/N)?:");
			respuesta = teclado.nextLine();
			for(int i=0;i<80;i++) System.out.println();
		}while(respuesta.equalsIgnoreCase("s"));
		
		
	}
	
	public static void iniciaJuego() {
		baraja=new Mazo();
		jugador=new Mano();
		banca=new Mano();
		
		baraja.barajar();
	}

	private static void juegaBanca() throws NoHayCartasException {
		// Debe saber la puntuación del jugador e intentar superarla
		// sin pasarse.
		do {
			banca.pedirCarta(baraja);
		}while (!banca.finDeJuego() 
				&& banca.valorMano()<jugador.valorMano()
				&& jugador.valorMano()<=21);
		System.out.println("La banca ha sacado: "+banca);
	}
}
