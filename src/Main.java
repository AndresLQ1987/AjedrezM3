import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author andres,christian,jose,catriel
 *
 */

public class Main {
	
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		
		//crea el tablero y lo muestra por pantalla
		Tablero tablero = new Tablero();
		tablero.dibujaTablero();
		
		boolean wellPos = false;
		while(!wellPos) {
			System.out.println("Introduce la posicion de la pieza(ej: 0 0): ");
			try {
				String pos = reader.readLine();
				String[] splitpos = pos.split(" ");
				try {
					int piezaPosX = Integer.parseInt(splitpos[0]);
				}catch (Exception e) {
					// TODO: handle exception
				}
			}catch (Exception e) {
				System.out.println("Error posicion en Blanco.");
			}
		}
	}
}
