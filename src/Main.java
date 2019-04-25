/**
 * 
 * @author andres,christian,jose,catriel
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		
		//crea el tablero y lo muestra por pantalla
		Tablero tablero = new Tablero();
		tablero.dibujaTablero();
		
		System.out.println("Introduce la posicion de la pieza a mover(ej: 1 2): ");
		String pos = "";
		int posx = 0;
		int posy = 0;
		boolean correctpos = false;
		while(!correctpos) {
			try {
				pos = reader.readLine();
				try {
					String[] coordenadas = pos.split(" ");
					try {
						posx = Integer.parseInt(coordenadas[0]);
						posy = Integer.parseInt(coordenadas[1]);
					}catch (Exception e) {
						System.out.println("");
					}
				}catch (Exception e){
					System.out.println("Por favor intrduzca la posicion como el ejemplo.");
				}
			}catch (Exception e) {
				System.out.println("Por favor no lo deje en blanco.");
			}
		}
	}
}
