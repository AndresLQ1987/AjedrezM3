/**
 * Clase Tablero. Inicia el tablero y pregunta a la pieza sus movimientos ,
 * ademas de permite mover la pieza dentro del tablero.
 * 
 * @version 1.0
 * @author andres
 * @date 16/04/2019
 */

public class Tablero {

	/*
	 * La clase tablero contiene las piezas del juego, ademas de moverlas y saber
	 * las normas del juego.
	 */

	/** numCasillas es el numero maximo de casillas del tablero */
	private int numCasillas;
	/** tablero es una variable que guarda la posicion de las piezas */
	private Piezas[][] tablero;

	/**
	 * Constructor Basico del Tablero que inicia automaticamente las piezas en su
	 * posicion
	 */
	public Tablero() {
		numCasillas = 8;
		tablero = new Piezas[numCasillas][numCasillas];
		for (int y = 0; y < numCasillas; y++) {
			for (int x = 0; x < numCasillas; x++) {
				if ((y == 1) || (y == 6)) {
					// coloca los peones
					if (y == 1) {
						tablero[x][y] = new Peon(x, y, "N", "P");
					} else {
						tablero[x][y] = new Peon(x, y, "B", "P");
					}
				} else if ((y == 0) || (y == 7)) {
					if (x == 0 || x == 7) {
						// coloca las torres
						if (y == 0) {
							tablero[x][y] = new Torre(x, y, "N", "T");
						} else {
							tablero[x][y] = new Torre(x, y, "B", "T");
						}
					} else if ((x == 1) || (x == 6)) {
						// coloca los caballos
						if (y == 0) {
							tablero[x][y] = new Caballo(x, y, "N", "C");
						} else {
							tablero[x][y] = new Caballo(x, y, "B", "C");
						}
					} else if ((x == 2) || (x == 5)) {
						// coloca los alfiles
						if (y == 0) {
							tablero[x][y] = new Alfil(x, y, "N", "A");
						} else {
							tablero[x][y] = new Alfil(x, y, "B", "A");
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
	 * Metodo dibujaTablero dibuja el tablero i los indicadores de las casillas
	 * ademas de tener en cuenta la disposicion de las piezas dentro del tablero.
	 */
	public void dibujaTablero() {
		System.out.println("    0    1    2    3    4    5    6    7  ");
		System.out.println("  ----------------------------------------");
		for (int y = 0; y < numCasillas; y++) {
			System.out.print((7 - y) + " ");
			for (int x = 0; x < numCasillas; x++) {
				System.out.print("|" + tablero[x][y].getNombre() + tablero[x][y].getColor() + " |");
			}
			System.out.println("\n  ----------------------------------------");
		}
	}

	/**
	 * Metodo dibujaTablero sobrecargado Añade sobre la funcion dibujarTablero pinta
	 * los lugares a donde se puede mover una ficha
	 * 
	 * @param movs matriz de movimientos de una ficha
	 */
	public void dibujaTablero(boolean[][] movs) {
		System.out.println("    0    1    2    3    4    5    6    7  ");
		System.out.println("  ----------------------------------------");
		for (int y = 0; y < numCasillas; y++) {
			System.out.print((7 - y) + " ");
			for (int x = 0; x < numCasillas; x++) {
				if (movs[x][y]) {
					System.out.print("|" + tablero[x][y].getNombre() + tablero[x][y].getColor() + "o|");
				} else {
					System.out.print("|" + tablero[x][y].getNombre() + tablero[x][y].getColor() + " |");
				}
			}
			System.out.println("\n  ----------------------------------------");
		}
	}

	/**
	 * Metodo pregMovimientos pregunta a la ficha pasada por x e y cuales son sus
	 * posibles movimientos
	 * 
	 * @param x valor x de la pieza a preguntar
	 * @param y valor y de la pieza a preguntar
	 * @return boolean[][] matriz devuelta de sus posibles movimientos
	 */
	public boolean[][] pregMovimientos(int x, int y) {
		boolean[][] result = tablero[x][y].movimiento(x, y, tablero[x][y].getColor());
		result = corregirMovimientos(x, y, result);
		return result;
	}

	/**
	 * Metodo moverPieza mueve la pieza en las posiciones x e y hasta la nueva
	 * posicion en newX y newY
	 * 
	 * @param x    posicion x de la pieza a mover
	 * @param y    posicion y de la pieza a mover
	 * @param newX posicion x de destino de la pieza a mover
	 * @param newY posicion y de destino de la pieza a mover
	 */
	public void moverPieza(int x, int y, int newX, int newY) {
		// TODO añadir despues no permitir movimientos ilegales.
		if (tablero[x][y].getNombre().equals("P")) {
			((Peon) tablero[x][y]).setPrimerMovimiento(false);
		}
		tablero[newX][newY] = tablero[x][y];
		tablero[x][y] = new Piezas(x, y, " ", " ");
	}

	/**
	 * Metodo getColor devuelve el color de la casilla pasa por X e Y
	 * 
	 * @param x posicion x de la casilla a preguntar
	 * @param y posicion y de la casilla a preguntar
	 * @return String el color de la casilla seleccionada
	 */
	public String getColor(int x, int y) {
		return tablero[x][y].getColor();
	}

	/**
	 * Metodo getNombre devuelve el nombre de la pieza de la que esta en la casilla
	 * pasada por X e Y
	 * 
	 * @param x posicion x de la casilla
	 * @param y posicion y de la casilla
	 * @return String el nombre de la pieza en la casilla
	 */
	public String getNombre(int x, int y) {
		return tablero[x][y].getNombre();
	}

	/**
	 * Metodo corregirMovimientos pasado los movimientos de la pieza revisa
	 * colisiones con piezas aliadas y/o enemigas para quitar los movimientos que no
	 * son posibles dentro de los que puede realizar la pieza
	 * 
	 * @param x    parametro x de la pieza a revisar
	 * @param y    parametro y de la pieza a revisar
	 * @param movs los movimientos que puede realizar dicha ficha
	 */
	public boolean[][] corregirMovimientos(int x, int y, boolean[][] movs) {
		boolean[][] correctMovs = movs;
		switch (tablero[x][y].getNombre()) {
		case "P":
			correctMovs = corregirPeon(x, y, correctMovs);
			break;
		case "T":
			correctMovs = corregirArriba(x, y, correctMovs);
			correctMovs = corregirAbajo(x, y, correctMovs);
			correctMovs = corregirDerecha(x, y, correctMovs);
			correctMovs = corregirIzquierda(x, y, correctMovs);
			correctMovs[x][y] = false;
			break;
		case "C":
			correctMovs = quitarMovimientosDondeCompanyeros(x, y, correctMovs);
			correctMovs[x][y] = false;
			break;
		case "A":
			correctMovs = corregirArribaDerecha(x, y, correctMovs);
			correctMovs = corregirArribaIzquierda(x, y, correctMovs);
			correctMovs = corregirAbajoDerecha(x, y, correctMovs);
			correctMovs = corregirAbajoIzquierda(x, y, correctMovs);
			correctMovs[x][y] = false;
			break;
		case "D":
			correctMovs = corregirArriba(x, y, correctMovs);
			correctMovs = corregirAbajo(x, y, correctMovs);
			correctMovs = corregirDerecha(x, y, correctMovs);
			correctMovs = corregirIzquierda(x, y, correctMovs);
			correctMovs = corregirArribaDerecha(x, y, correctMovs);
			correctMovs = corregirArribaIzquierda(x, y, correctMovs);
			correctMovs = corregirAbajoDerecha(x, y, correctMovs);
			correctMovs = corregirAbajoIzquierda(x, y, correctMovs);
			correctMovs[x][y] = false;
			break;
		case "R":
			correctMovs = quitarMovimientosDondeCompanyeros(x, y, correctMovs);
			correctMovs[x][y] = false;
			break;
		default:
			break;
		}

		return correctMovs;
	}

	/**
	 * Metodo corregirArriba comprueva las colisiones en vertical hacia arriba
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirArriba(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (y - i >= 0) {
				if (tablero[x][y - i].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x][y - i] = false;
				} else if (tablero[x][y - i].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x][y - i].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x][y - i] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirAbajo comprueva las colisiones en vertical hacia abajo
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirAbajo(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (y + i < 8) {
				if (tablero[x][y + i].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x][y + i] = false;
				} else if (tablero[x][y + i].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x][y + i].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x][y + i] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirDerecha comprueva las colisiones en horizontal hacia la
	 * derecha
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirDerecha(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (x + i < 8) {
				if (tablero[x + i][y].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x + i][y] = false;
				} else if (tablero[x + i][y].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x + i][y].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x + i][y] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirIzquierda comprueva las colisiones en horizontal hacia la
	 * izquierda
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirIzquierda(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (x - i >= 0) {
				if (tablero[x - i][y].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x - i][y] = false;
				} else if (tablero[x - i][y].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x - i][y].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x - i][y] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirArribaDerecha comprueva las colisiones en diagonal hacia la
	 * arriba derecha
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirArribaDerecha(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (x + i <= 7 && y - i >= 0) {
				if (tablero[x + i][y - i].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x + i][y - i] = false;
				} else if (tablero[x + i][y - i].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x + i][y - i].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x + i][y - i] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirArribaIzquirda comprueva las colisiones en diagonal hacia la
	 * arriba izquierda
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirArribaIzquierda(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (x - i >= 0 && y - i >= 0) {
				if (tablero[x - i][y - i].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x - i][y - i] = false;
				} else if (tablero[x - i][y - i].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x - i][y - i].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x - i][y - i] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirAbajoDerecha comprueva las colisiones en diagonal hacia la
	 * abajo derecha
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirAbajoDerecha(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (x + i <= 7 && y + i <= 7) {
				if (tablero[x + i][y + i].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x + i][y + i] = false;
				} else if (tablero[x + i][y + i].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x + i][y + i].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x + i][y + i] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirAbajoIzquirda comprueva las colisiones en diagonal hacia la
	 * abajo izquierda
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirAbajoIzquierda(int x, int y, boolean[][] movs) {
		boolean colisionMismoColor = false;
		boolean colisionOtroColor = false;
		int contador = 0;
		for (int i = 1; i < 8; i++) {
			if (x - i >= 0 && y + i <= 7) {
				if (tablero[x - i][y + i].getColor().equals(tablero[x][y].getColor())) {
					colisionMismoColor = true;
					movs[x - i][y + i] = false;
				} else if (tablero[x - i][y + i].getColor().equals("B") && tablero[x][y].getColor().equals("N")) {
					if (contador == 0) {
						contador++;
					}
				} else if (tablero[x - i][y + i].getColor().equals("N") && tablero[x][y].getColor().equals("B")) {
					if (contador == 0) {
						contador++;
					}
				}
				if (colisionMismoColor || colisionOtroColor) {
					movs[x - i][y + i] = false;
				}
				if (contador == 1) {
					colisionOtroColor = true;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo quitarMovimientosDondeCompanyeros todos los movimientos donde hay un
	 * compañero de la pieza introducida son quitados de los posibles movimientos.
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] quitarMovimientosDondeCompanyeros(int x, int y, boolean[][] movs) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j].getColor().equals(tablero[x][y].getColor())) {
					movs[i][j] = false;
				}
			}
		}
		return movs;
	}

	/**
	 * Metodo corregirPeon metodo que corrige los movmientos del peon, no dejando
	 * avanzar si hay enemigo en frente o solo permitir moverse en diagonal para
	 * comer un enemigo.
	 * 
	 * @param x    valor x de la pieza a revisar
	 * @param y    valor x de la pieza a revisar
	 * @param movs la lista de movimientos posibles
	 */
	private boolean[][] corregirPeon(int x, int y, boolean[][] movs) {
		if (tablero[x][y].getColor().equals("N")) {
			if (((Peon) tablero[x][y]).isPrimerMovimiento()) {
				boolean colisionPieza = false;
				for (int i = 1; i <= 2; i++) {
					if (tablero[x][y + i].getColor().equals("N") || tablero[x][y + i].getColor().equals("B")) {
						colisionPieza = true;
						movs[x][y + i] = false;
					}
					if (colisionPieza) {
						movs[x][y + i] = false;
					}
				}
				if (x + 1 < 8) {
					if (!tablero[x + 1][y + 1].getColor().equals("B")) {
						movs[x + 1][y + 1] = false;
					}
				}
				if (x - 1 >= 0) {
					if (!tablero[x - 1][y + 1].getColor().equals("B")) {
						movs[x - 1][y + 1] = false;
					}
				}
			} else {
				if (tablero[x][y + 1].getColor().equals("N") || tablero[x][y + 1].getColor().equals("B")) {
					movs[x][y + 1] = false;
				}
				if (x + 1 < 8) {
					if (!tablero[x + 1][y + 1].getColor().equals("B")) {
						movs[x + 1][y + 1] = false;
					}
				}
				if (x - 1 >= 0) {
					if (!tablero[x - 1][y + 1].getColor().equals("B")) {
						movs[x - 1][y + 1] = false;
					}
				}
			}
		} else {
			if (((Peon) tablero[x][y]).isPrimerMovimiento()) {
				boolean colisionPieza = false;
				for (int i = 1; i <= 2; i++) {
					if (tablero[x][y - i].getColor().equals("N") || tablero[x][y - i].getColor().equals("B")) {
						colisionPieza = true;
						movs[x][y - i] = false;
					}
					if (colisionPieza) {
						movs[x][y - i] = false;
					}
				}
				if (x + 1 < 8) {
					if (!tablero[x + 1][y - 1].getColor().equals("N")) {
						movs[x + 1][y - 1] = false;
					}
				}
				if (x - 1 >= 0) {
					if (!tablero[x - 1][y - 1].getColor().equals("N")) {
						movs[x - 1][y - 1] = false;
					}
				}
			} else {
				if (tablero[x][y - 1].getColor().equals("N") || tablero[x][y - 1].getColor().equals("B")) {
					movs[x][y - 1] = false;
				}
				if (x + 1 < 8) {
					if (!tablero[x + 1][y - 1].getColor().equals("N")) {
						movs[x + 1][y - 1] = false;
					}
				}
				if (x - 1 >= 0) {
					if (!tablero[x - 1][y - 1].getColor().equals("N")) {
						movs[x - 1][y - 1] = false;
					}
				}
			}
		}
		return movs;
	}
}
