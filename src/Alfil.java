/**
 * Clase Alfil
 * @author cf17jose.torres
 *
 */

/*
L'alfil: 
Quan es pinta per pantalla mostra una A i segons el seu color serà AB o AN. 
Els possibles moviments d'un alfil: 
Pot moure's en tots els sentits de la diagonal que ocupa. 
*/

public class Alfil extends Piezas {
	/**
	 * Este Constructor se encarga mostrar los parametros de la pieza Alfil.
	 * @param x Es la posición que indica la pieza.
	 * @param y Es la posición que indica la pieza.
	 * @param color Es el color de que indica cada pieza.
	 * @param nombre Es una cadena de texto con el nombre a usar.
	 */
	public Alfil(int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}

	/**
	 * Es un metodo que devuelve una matriz de boleanos.
	 * Cada for hace los movimientos
	 * @return devuelve el tipo de movimiento
	 */
	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		//Declaramos y creamos el objeto en una línea
		boolean[][] movimiento = new boolean[8][8];

		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				movimiento[i][j] = false;			
			}	
		}

		for (int j = 0; j < 8; j++) {
			int contX = x + j;
			int contY = y + j;
			if(contY <= 7 && contX <= 7) {
				movimiento[contX][contY] = true;
			}
		}

		for (int j = 0; j < 8; j++) {
			int contX = x - j;
			int contY = y - j;
			if(contY >= 0 && contX >= 0) {
				movimiento[contX][contY] = true;
			}
		}

		for (int j = 0; j < 8; j++) {
			int contX = x - j;
			int contY = y + j;
			if(contX >= 0  && contY <= 7) {
				movimiento[contX][contY] = true;
			}
		}

		for (int j = 0; j < 8; j++) {
			int contX = x + j;
			int contY = y - j;
			if(contX <= 7 && contY >= 0) {
				movimiento[contX][contY] = true;
			}
		}

		return movimiento;
	}	 
}
