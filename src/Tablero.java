/**
 * 
 * @author andres
 *
 * Clase Tablero inicia el tablero y pregunta a la pieza sus movimientos , ademas de permite mover la pieza dentro
 * del tablero.
 */

public class Tablero {
	
	//Tablero que guarda la posicion de las piezas
	String[][] tablero;
	
	//Constructor Basico que inicia las piezas en su posicion
	Tablero(){
		for(int y = 0 ; y<8 ; y++) {
			for(int x = 0 ; x<8 ; x++ ) {
				if(y == 1 || y == 6) {
					if(y == 1) {
						tablero[x][y] = "PN";
					}else {
						tablero[x][y] = "PB";
					}
				}else if(y == 0 || y == 7) {
					if(x == 0 || x == 7) {
						if(y == 0) {
							tablero[x][y] = "TN";
						}else {
							tablero[x][y] = "TB";
						}
					}
				}else {
					tablero[x][y] = "";
				}
			}
		}
	}
}
