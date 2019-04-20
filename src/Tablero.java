/**
 * 
 * @author andres
 *
 * Clase Tablero inicia el tablero y pregunta a la pieza sus movimientos , ademas de permite mover la pieza dentro
 * del tablero.
 */

public class Tablero {
	
	//Tablero que guarda la posicion de las piezas
	private String[][] tablero;
	
	//Constructor Basico que inicia las piezas en su posicion
	Tablero(){
		tablero = new String[8][8];
		for(int y = 0 ; y < 8 ; y++) {
			for(int x = 0 ; x < 8 ; x++) {
				if(y == 1 || y == 6) { //Este if coloca los peones
					if(y == 1) {
						tablero[x][y] = "PN"; // temporalmente son String cambiar por la pieza que toque una vez esten.
					}else {
						tablero[x][y] = "PB";
					}
				}else if(y == 0 || y == 7) {
					if(x == 0 || x == 7) { // coloca las torres
						if(y == 0) {
							tablero[x][y] = "TN";
						}else {
							tablero[x][y] = "TB";
						}
					}else if(x == 1 || x == 6) { // coloca los caballos
						if(y == 0) {
							tablero[x][y] = "CN";
						}else {
							tablero[x][y] = "CB";
						}
					}else if(x == 2 || x == 5) { // coloca los alfiles
						if(y == 0) {
							tablero[x][y] = "AN";
						}else {
							tablero[x][y] = "AB";
						}
					}else if(x == 3) { // coloca la dama (o Reina)
						if(y == 0) {
							tablero[x][y] = "DN";
						}else {
							tablero[x][y] = "DB";
						}
					}else {
						if(y == 0) {
							tablero[x][y] = "RN";
						}else {
							tablero[x][y] = "RB";
						}
					}
				}else {
					tablero[x][y] = "  ";
				}
			}
		}
	}
	
	//Funcion para pintar el tablero con las piezas en la posicion que se encuentren.
	public void printTablero() {
		System.out.println("---------------------------------------------");
		System.out.println("|   || 0 || 1 || 2 || 3 || 4 || 5 || 6 || 7 |");
		System.out.println("---------------------------------------------");
		for(int y = 0 ; y < 8 ; y++) {
			System.out.print("| "+(7-y)+" |");
			for(int x = 0 ; x < 8 ; x++) {
				System.out.print("|"+tablero[x][y]+" |");
			}
			System.out.println("\n---------------------------------------------");
		}
	}
}
