/**
 * 
 * @author andres
 *
 * Clase Tablero inicia el tablero y pregunta a la pieza sus movimientos , ademas de permite mover la pieza dentro
 * del tablero.
 */

public class Tablero {
	
	private int numCasillas;
	//Tablero que guarda la posicion de las piezas
	private String[][] tablero; //temporalmente tablero de strings cambiar por figura mas adelante.
	
	//Constructor Basico que inicia las piezas en su posicion
	Tablero(){
		numCasillas = 8;
		tablero = new String[numCasillas][numCasillas];
		for(int y = 0 ; y < numCasillas ; y++) {
			for(int x = 0 ; x < numCasillas ; x++) {
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
					}else { // coloca el rey
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
	
	//Funcion para dibujar el tablero con las piezas en la posicion que se encuentren.
	public void dibujaTablero() {
		System.out.println("    0    1    2    3    4    5    6    7  ");
		System.out.println("  ----------------------------------------");
		for(int y = 0 ; y < numCasillas ; y++) {
			System.out.print((7-y)+" ");
			for(int x = 0 ; x < numCasillas ; x++) {
				System.out.print("|"+tablero[x][y]+" |");
			}
			System.out.println("\n  ----------------------------------------");
		}
	}
	
	//funcion de dibujar sobrecargada para pintar los posibles movimientos
	public void dibujaTablero(boolean[][] movs) {
		System.out.println("    0    1    2    3    4    5    6    7  ");
		System.out.println("  ----------------------------------------");
		for(int y = 0 ; y < numCasillas ; y++) {
			System.out.print((7-y)+" ");
			for(int x = 0 ; x < numCasillas ; x++) {
				if(movs[x][y]) {
					System.out.print("|"+tablero[x][y]+"o|");
				}else {
					System.out.print("|"+tablero[x][y]+" |");
				}
			}
			System.out.println("\n  ----------------------------------------");
		}
	}
	
	//funcion que pregunta los movimientos de la pieza en las posiciones X y Y
	public boolean[][] pregMovimientos(int x, int y){ //modificar cuando esten las piezas
		boolean [][] result = new boolean[numCasillas][numCasillas];
		if(tablero[x][y] == "PB") {
			result = movPB(x,y);
			return result;
		}
		return result;
	}
	
	//funcion de prueba pregMovimiento
	private boolean[][] movPB(int x, int y){
		boolean[][] movimientos = new boolean[numCasillas][numCasillas];
		for(int a = 0 ; a < numCasillas ; a++) {
			for(int b = 0 ; b < numCasillas ; b++) {
				if(b == x && a == y-1) {
					if(y-1 >= 0) {
						movimientos[a][b] = true; 
					}
				}else {
					movimientos[a][b] = false;
				}
			}
		}
		return movimientos;
	}
}
