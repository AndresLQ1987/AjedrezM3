import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Clase: Main
 * 
 * @version 1.0
 * @author andres,christian,jose,catriel
 * 
 *         Programa principal
 */
public class Main {

	/**
	 * atributo del main para poder leer por teclado desde cualquier metodo del main
	 */
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Metodo principal del programa
	 * 
	 * @param args valores recogidos al llamar al programa.
	 */
	public static void main(String[] args) {

		// bucle para volver a jugar partida
		boolean volverAJugar = true;
		while (volverAJugar) {

			// variables de control de la partida
			int turno = 1;
			String colorTurno = "B";
			Random r = new Random();
			int turnoJugadorA = 1;
			String colorJugadorA = "B";
			String colorJugadorB = "N";

			// recogemos el nombre de los jugadores
			String jugadorA = introJugador("Introduce jugador: ");
			String jugadorB = introJugador("Introduce otro jugador: ");

			// random para decidir el orden de los jugadores
			int randomTurno = r.nextInt(2) + 1;
			if (randomTurno == 1) {
				turnoJugadorA = 1;
			} else {
				turnoJugadorA = 2;
			}

			// random para decidir color de las piezas para cada jugador
			int randomColor = r.nextInt(2) + 1;
			if (randomColor == 1) {
				colorJugadorA = "B";
				colorJugadorB = "N";
			} else {
				colorJugadorA = "N";
				colorJugadorB = "B";
			}

			// crea el tablero y lo muestra por pantalla
			Tablero tablero = new Tablero();
			tablero.dibujaTablero();

			// bucle donde se desarrolla la partida
			boolean finJuego = false;
			while (!finJuego) {

				// control de turno
				if (turno == turnoJugadorA) {
					System.out.println("Turno Jugador " + jugadorA + " piezas " + colorJugadorA + ".");
					colorTurno = colorJugadorA;
				} else {
					System.out.println("Turno Jugador " + jugadorB + " piezas " + colorJugadorB + ".");
					colorTurno = colorJugadorB;
				}

				// pregunta por la pieza a mover para mostrar sus movimientos
				int[] initPos = preguntaPos("Introduce la posicion de la pieza(ej: 0 0): ", colorTurno, tablero);
				System.out.println();
				boolean[][] piezaMovs = tablero.pregMovimientos(initPos[0], initPos[1]);
				tablero.dibujaTablero(piezaMovs);

				/*
				 * pregunta por una segunda posicion y destinge si es un movimiento de la
				 * primera pieza seleccionada o una segunda pieza, si es un movimiento mueve la
				 * primera pieza en caso de que sea una pieza muestra los movimientos de la
				 * misma y vuelve a preguntar por una posicion.
				 */
				boolean movimientoHecho = false;
				while (!movimientoHecho) {
					int[] newPos = preguntaPos("Introduce la posicion de movimiento o otra pieza(ej: 1 3): ",
							colorTurno, tablero, piezaMovs);
					if (movimientoOPieza(newPos, piezaMovs)) {
						if (tablero.getNombre(newPos[0], newPos[1]) == "R") {
							finJuego = true;
						}
						tablero.moverPieza(initPos[0], initPos[1], newPos[0], newPos[1]);
						movimientoHecho = true;
						if (turno == 2) {
							turno = 1;
						} else {
							turno++;
						}
						if (colorTurno == "B") {
							colorTurno = "N";
						} else {
							colorTurno = "B";
						}
						tablero.dibujaTablero();
					} else {
						piezaMovs = tablero.pregMovimientos(newPos[0], newPos[1]);
						initPos = newPos;
						tablero.dibujaTablero(piezaMovs);
					}
				}
			}

			// bucle que comfirma si quieres volver a jugar o no
			boolean correctoRespuesta = false;
			while (!correctoRespuesta) {
				System.out.print("Quieres volver a jugar?(Y/n): ");
				try {
					String res = reader.readLine();
					if (res.equalsIgnoreCase("n")) {
						volverAJugar = false;
						correctoRespuesta = true;
					} else if (res.equalsIgnoreCase("y")) {
						correctoRespuesta = true;
					} else {
						System.out.println("Responde y/Y i N/n");
					}
				} catch (Exception e) {
					System.out.println("Error respuesta");
				}
			}
		}
	}

	/**
	 * Metodo ntroJugador para introducir jugadores sin errores o vacios
	 * 
	 * @return String el nombre del jugador
	 */
	private static String introJugador(String frase) {
		boolean correctoJugador = false;
		String jugador = "";
		while (!correctoJugador) {
			System.out.print(frase);
			try {
				jugador = reader.readLine();
				if (!jugador.isEmpty()) {
					if (!isNumeric(jugador)) {
						correctoJugador = true;
					} else {
						System.out.println("No introduzca numeros como nombre");
					}
				} else {
					System.out.println("Porfavor no introduzca un nombre vacio");
				}
			} catch (Exception e) {
				System.out.println("Error, fallo al introducir el nombre.");
			}
		}
		return jugador;
	}

	/**
	 * Metodo isNumeric que comprueva si un string es un numero
	 * 
	 * @param s es el string a comprovar
	 * @return boolean dependiendo de si es un numero o no
	 */
	private static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Metodo preguntaPos es un metodo que pregunta la posicion dentro del tablero
	 * ademas de encargarse de las comprobaciones pertinentes para su correcto
	 * funcionamiento
	 * 
	 * @param frase sirve para mostrar distintos mensajes al usuario
	 * @return int[] un array con la posicion en el 0 esta la X y en el 1 esta la Y
	 */
	public static int[] preguntaPos(String frase, String color, Tablero tab) {
		boolean wellPos = false;
		int[] posicion = new int[2];
		while (!wellPos) {
			boolean wellX = false;
			boolean wellY = false;
			System.out.print(frase);
			try {
				String pos = reader.readLine();
				String[] coordenadas = pos.split(" ");
				posicion[0] = Integer.parseInt(coordenadas[0]);
				if (posicion[0] >= 0 && posicion[0] <= 7) {
					wellX = true;
				} else {
					System.out.println("Primer numero debe ser entre 0 y 7.");
				}
				int invertedY = Integer.parseInt(coordenadas[1]);
				posicion[1] = 7 - invertedY;
				if (posicion[1] >= 0 && posicion[1] <= 7) {
					wellY = true;
				} else {
					System.out.println("Segundo numero debe ser entre 0 y 7.");
				}
				if (tab.getColor(posicion[0], posicion[1]) == color || tab.getColor(posicion[0], posicion[1]) == " ") {
					if (wellX && wellY) {
						wellPos = true;
					}
				} else {
					System.out.println("Selecciona una pieza de tu color.");
				}
			} catch (IOException e) {
				System.out.println("Por favor introduzca la posicion como en el ejemplo. Y solo numeros.");
			}
		}
		return posicion;
	}

	/**
	 * Metodo preguntaPos es un metodo que pregunta la posicion dentro del tablero
	 * ademas de encargarse de las comprobaciones pertinentes para su correcto
	 * funcionamiento
	 * 
	 * @param frase sirve para mostrar distintos mensajes al usuario
	 * @return int[] un array con la posicion en el 0 esta la X y en el 1 esta la Y
	 */
	public static int[] preguntaPos(String frase, String color, Tablero tab, boolean[][] movs) {
		boolean wellPos = false;
		int[] posicion = new int[2];
		while (!wellPos) {
			boolean wellX = false;
			boolean wellY = false;
			System.out.print(frase);
			try {
				String pos = reader.readLine();
				String[] coordenadas = pos.split(" ");
				posicion[0] = Integer.parseInt(coordenadas[0]);
				if (posicion[0] >= 0 && posicion[0] <= 7) {
					wellX = true;
				} else {
					System.out.println("Primer numero debe ser entre 0 y 7.");
				}
				int invertedY = Integer.parseInt(coordenadas[1]);
				posicion[1] = 7 - invertedY;
				if (posicion[1] >= 0 && posicion[1] <= 7) {
					wellY = true;
				} else {
					System.out.println("Segundo numero debe ser entre 0 y 7.");
				}
				if (tab.getColor(posicion[0], posicion[1]) == color || tab.getColor(posicion[0], posicion[1]) == " "
						|| movs[posicion[0]][posicion[1]]) {
					if (wellX && wellY) {
						wellPos = true;
					}
				} else {
					System.out.println("Selecciona una pieza de tu color.");
				}
			} catch (IOException e) {
				System.out.println("Por favor introduzca la posicion como en el ejemplo. Y solo numeros.");
			}
		}
		return posicion;
	}

	/**
	 * Metodo movimientoOPieza es un metodo que distinge si la posicion pasada es un
	 * movimiento o una pieza
	 * 
	 * @param pos  la posicion pasada
	 * @param movs los movimientos correctos
	 * @return posMovs true si es un movimiento false si es una pieza
	 */
	public static boolean movimientoOPieza(int[] pos, boolean[][] movs) {
		boolean posMovs = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (movs[pos[0]][pos[1]]) {
					posMovs = true;
				}
			}
		}
		return posMovs;
	}
}
