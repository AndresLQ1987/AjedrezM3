import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase: Main
 * 
 * @version 1.0
 * @author andres,christian,jose,catriel
 * 
 * Programa principal
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
		
		//crea el tablero y lo muestra por pantalla
		Tablero tablero = new Tablero();
		tablero.dibujaTablero();
		
		int[] initPos = preguntaPos("Introduce la posicion de la pieza(ej: 0 0): ");
		System.out.println();
		boolean[][] piezaMovs = tablero.pregMovimientos(initPos[0], initPos[1]);
		tablero.dibujaTablero(piezaMovs);
		
		boolean movimientoHecho = false;
		while (!movimientoHecho) {
			int[] newPos = preguntaPos("Introduce la posicion de movimiento o otra pieza(ej: 1 3): ");
			if (movimientoOPieza(newPos, piezaMovs)) {
				tablero.moverPieza(initPos[0], initPos[1], newPos[0], newPos[1]);
				tablero.dibujaTablero();
			}else {
				piezaMovs = tablero.pregMovimientos(newPos[0], newPos[1]);
				initPos = newPos;
				tablero.dibujaTablero(piezaMovs);
			}
		}
	}
	
	/**
	 * Metodo preguntaPos
	 * es un metodo que pregunta la posicion dentro del tablero ademas de encargarse de las comprobaciones
	 * pertinentes para su correcto funcionamiento
	 * 
	 * @param frase sirve para mostrar distintos mensajes al usuario
	 * @return int[] un array con la posicion en el 0 esta la X y en el 1 esta la Y
	 */
	public static int[] preguntaPos(String frase) {
		boolean wellPos = false;
		int[] posicion = new int[2];
		while (!wellPos) {
			boolean wellX = false;
			boolean wellY = false;
			System.out.print(frase);
			try {
				String pos = reader.readLine();
				try {
					String[] coordenadas = pos.split(" ");
					try {
						posicion[0] = Integer.parseInt(coordenadas[0]);
						if(posicion[0] >= 0 && posicion[0] <= 7) {
							wellX = true;
						}else {
							System.out.println("Primer numero debe ser entre 0 y 7.");
						}
						int invertedY = Integer.parseInt(coordenadas[1]);
						posicion[1] = 7 - invertedY;
						if(posicion[1] >= 0 && posicion[1] <= 7) {
							wellY = true;
						}else {
							System.out.println("Segundo numero debe ser entre 0 y 7.");
						}
						if(wellX && wellY) {
							wellPos = true;
						}
					}catch (Exception e) {
						System.out.println("Introduce solo numeros.");
					}
				}catch (Exception e){
					System.out.println("Por favor introduzca la posicion como en el ejemplo.");
				}
			}catch (Exception e) {
				System.out.println("Error, posicion en Blanco.");
			}
		}
		return posicion;
	}
	
	/**
	 * Metodo movimientoOPieza
	 * es un metodo que distinge si la posicion pasada es un movimiento o una pieza
	 * 
	 * @param pos la posicion pasada
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
