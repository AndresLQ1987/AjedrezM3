import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase: Main
 * 
 * @author andres,christian,jose,catriel
 * 
 * Programa principal
 */
public class Main {
	
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		
		//crea el tablero y lo muestra por pantalla
		Tablero tablero = new Tablero();
		tablero.dibujaTablero();
		
		boolean wellPos = false;
		int posx = 0;
		int posy = 0;
		while(!wellPos) {
			boolean wellX = false;
			boolean wellY = false;
			System.out.println("Introduce la posicion de la pieza(ej: 0 0): ");
			try {
				String pos = reader.readLine();
				try {
					String[] coordenadas = pos.split(" ");
					try {
						posx = Integer.parseInt(coordenadas[0]);
						if(posx >= 0 && posx <= 7) {
							wellX = true;
						}else {
							System.out.println("Primer numero debe ser entre 0 y 7.");
						}
						int invertedY = Integer.parseInt(coordenadas[1]);
						posy = 7 - invertedY;
						if(posy >= 0 && posy <= 7) {
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
		System.out.println();
		boolean[][] piezaMovs = tablero.pregMovimientos(posx, posy);
		tablero.dibujaTablero(piezaMovs);
	}
}
