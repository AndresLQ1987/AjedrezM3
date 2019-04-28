/**
 * 
 * @author cf18christian.villegas
 *
 */

//El primer paso es heredar los atributos y el m�todo creado en la clase 'Piezas'.
public class Reina extends Piezas {
	
	public Reina (int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}

//Utilizo el m�todo 'movimiento' para desarrollar los movimientos de la clase 'Reina' y devolverlos al main
	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		boolean[][] movimiento = new boolean[8][8]; //Creo un array que figura el tablero para guardar las posiciones de los movimientos.
		
//Desarrollo los movimientos horizontales y verticales de la 'reina'.		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if (i == x || j == y) {
					movimiento[i][j] = true;
				}else {
					movimiento[i][j] = false;
				}		
			}	
		}

//Desarrollo los movimientos diagonales de la 'reina'.		
		for(int j= 0; j<8; j++) {
			int contX = x+j;
			int contY = y+j;
			if((contX <= 7 && contX >= 0) && (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
		for(int j= 0; j<8; j++) {
			int contX = x-j;
			int contY = y-j;
			if((contX <= 7 && contX >= 0) && (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
		for(int j = 0; j<8; j++) {
			int contX = x-j;
			int contY = y+j;
			if((contX <= 7 && contX >= 0) && (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
		for(int j = 0; j<8; j++) {
			int contX = x+j;
			int contY = y-j;
			if((contX <= 7 && contX >= 0) && (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
			
		return movimiento; //Devuelvo el tipo de movimiento realizado.
	   }
	 
}
