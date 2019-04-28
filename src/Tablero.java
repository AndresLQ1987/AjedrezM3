/**
 * Clase Tablero. Inicia el tablero y pregunta a la pieza sus movimientos , ademas de permite mover la pieza dentro
 * del tablero.
 * 
 * @version 1.0
 * @author andres
 * @date 16/04/2019
 */

public class Tablero {
	
	/* La clase tablero contiene las piezas del juego, ademas de moverlas y saber las normas del juego.*/
	
	/** numCasillas es el numero maximo de casillas del tablero*/
	private int numCasillas;
	/** tablero es una variable que guarda la posicion de las piezas*/
	private Piezas[][] tablero;
	
	/**
	 * Constructor Basico del Tablero que inicia automaticamente las piezas en su posicion
	 */
	public Tablero(){
		numCasillas = 8;
		tablero = new Piezas[numCasillas][numCasillas];
		for (int y = 0 ; y < numCasillas ; y++) {
			for (int x = 0 ; x < numCasillas ; x++) {
				if (y == 1 || y == 6) { 				
						// coloca los peones
					if (y == 1) {
						tablero[x][y] = new Piezas(x, y, "N", "P");
					} else {
						tablero[x][y] = new Piezas(x, y, "B", "P");
					}
				} else if (y == 0 || y == 7) {
					if(x == 0 || x == 7) {			 
						// coloca las torres
						if (y == 0) {
							tablero[x][y] = new Torre(x, y, "N", "T");
						} else {
							tablero[x][y] = new Torre(x, y, "B", "T");
						}
					} else if (x == 1 || x == 6) { 	
						// coloca los caballos
						if (y == 0) {
							tablero[x][y] = new Piezas(x, y, "N", "C");
						} else {
							tablero[x][y] = new Piezas(x, y, "B", "C");
						}
					} else if (x == 2 || x == 5) { 	
						// coloca los alfiles
						if (y == 0) {
							tablero[x][y] = new Piezas(x, y, "N", "A");
						} else {
							tablero[x][y] = new Piezas(x, y, "B", "A");
						}
					} else if (x == 3) { 				
						// coloca la dama (o Reina)
						if (y == 0) {
							tablero[x][y] = new Reina(x, y, "N", "D");
						} else {
							tablero[x][y] = new Reina(x, y, "B", "D");
						}
					} else { 						
						// coloca el rey
						if (y == 0) {
							tablero[x][y] = new Rey(x, y, "N", "R");
						} else {
							tablero[x][y] = new Rey(x, y, "B", "R");
						}
					}
				} else {
						// coloca los espacios libres
					tablero[x][y] = new Piezas(x, y, " ", " ");
				}
			}
		}
	}
	
	/**
	 * Metodo dibujaTablero
	 * dibuja el tablero i los indicadores de las casillas ademas de tener en cuenta
	 * la disposicion de las piezas dentro del tablero.
	 */
	public void dibujaTablero() {
		System.out.println("    0    1    2    3    4    5    6    7  ");
		System.out.println("  ----------------------------------------");
		for (int y = 0 ; y < numCasillas ; y++) {
			System.out.print((7-y)+" ");
			for (int x = 0 ; x < numCasillas ; x++) {
				System.out.print("|" + tablero[x][y].getNombre() + tablero[x][y].getColor() + " |");
			}
			System.out.println("\n  ----------------------------------------");
		}
	}
	
	//funcion de dibujar sobrecargada para pintar los posibles movimientos
	/**
	 * Metodo dibujaTablero sobrecargado
	 * Añade sobre la funcion dibujarTablero pinta los lugares a donde se puede mover una ficha
	 * 
	 * @param movs matriz de movimientos de una ficha
	 */
	public void dibujaTablero(boolean[][] movs) {
		System.out.println("    0    1    2    3    4    5    6    7  ");
		System.out.println("  ----------------------------------------");
		for (int y = 0 ; y < numCasillas ; y++) {
			System.out.print((7-y)+" ");
			for (int x = 0 ; x < numCasillas ; x++) {
				if (movs[x][y]) {
					System.out.print("|" + tablero[x][y].getNombre() + tablero[x][y].getColor() + "o|");
				} else {
					System.out.print("|" + tablero[x][y].getNombre() + tablero[x][y].getColor() +" |");
				}
			}
			System.out.println("\n  ----------------------------------------");
		}
	}
	
	/**
	 * Metodo pregMovimientos
	 * pregunta a la ficha pasada por x e y cuales son sus posibles movimientos
	 * 
	 * @param x valor x de la pieza a preguntar
	 * @param y valor y de la pieza a preguntar
	 * @return boolean[][] matriz devuelta de sus posibles movimientos
	 */
	public boolean[][] pregMovimientos(int x, int y) {
		boolean [][] result = tablero[x][y].movimiento(x, y, tablero[x][y].getColor());
		return result;
	}
	
	/**
	 * Metodo moverPieza
	 * mueve la pieza en las posiciones x e y hasta la nueva posicion en newX y newY
	 * 
	 * @param x posicion x de la pieza a mover
	 * @param y posicion y de la pieza a mover
	 * @param newX posicion x de destino de la pieza a mover
	 * @param newY posicion y de destino de la pieza a mover
	 */
	public void moverPieza(int x, int y, int newX, int newY) {
		//TODO añadir despues no permitir movimientos ilegales.
		
		tablero[newX][newY] = tablero[x][y];
		tablero[x][y] = new Piezas(x, y, " ", " ");
	}
}
