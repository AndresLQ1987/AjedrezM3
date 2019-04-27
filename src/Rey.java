/**
 * Clase: Rey
 * 
 * @author andres
 * @version 1.0
 * @date 
 *
 * Pieza Rey del tablero extiende de piezas y define sus movimientos.
 */

public class Rey extends Piezas {
	
	/**
	 * Constructor de clase Rey
	 * 
	 * @param x : parametro que indica la posicion x de la pieza Rey
	 * @param y : parametro que indica la posicion y de la pieza Rey
	 * @param color : paramatro que indica el color de la pieza Rey
	 * @param nombre : parametro que indica el nombre de la pieza Rey
	 */
	public Rey(int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}
	
	/**
	 * Metodo que devuelve una matriz de boleanos cuyos boleanos indican
	 * los posibles movimientos dependiendo de la posicion de la pieza.
	 * 
	 * @param x : indica la posicion x dentro del tablero donde se encuentra la pieza
	 * @param y : indica la posicion y dentro del tablero donde se encuentra la pieza
	 * @param color : indica el color de la pieza (para rey no afecta a su movimiento)
	 * @return boolean[][] devuelve una matriz de 8x8 indicando que posiciones puede
	 * moverse y cuales no.
	 */
	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		   boolean movimientos[][]=new boolean[8][8];
		   
		   // movimiento derecha
		   if(x+1 < 8) {
			   movimientos[x+1][y] = true;
		   }
		   // movimiento izquierda
		   if(x-1 > 0) {
			   movimientos[x-1][y] = true;
		   }
		   // movimiento abajo
		   if(y+1 < 8) {
			   movimientos[x][y+1] = true;
		   }
		   // movimiento arriba
		   if(y-1 > 0) {
			   movimientos[x][y-1] = true;
		   }
		   // movimiento diagonal abajo derecha
		   if(x+1 < 8 && y+1 < 8) {
			   movimientos[x+1][y+1] = true;
		   }
		   // movimiento diagonal arriba izquierda
		   if(x-1 > 0 && y-1 > 0) {
			   movimientos[x-1][y-1] = true;
		   }
		   // movimiento diagonal arriba derecha
		   if(x+1 < 8 && y-1 > 0) {
			   movimientos[x+1][y-1] = true;
		   }
		   // movimiento diagonal abajo izquierda
		   if(x-1 > 0 && y+1 < 8) {
			   movimientos[x+1][y+1] = true;
		   }
		   // bucle que rellena la matriz los espacios que no son true
		   for ( int i = 0 ;i < 8 ; i++ ) {
			   for ( int j = 0 ; j < 8 ; j++) {
				   if(movimientos[i][j] != true) {
					   movimientos[i][j] = false;
				   }
			   }
		   }
		   return movimientos;
	}
}
