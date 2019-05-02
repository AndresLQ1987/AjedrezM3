/*
*Este class se encarga de determinar el movimiento del caballito, el cual es una extención
* de Piezas.
* Se utilizan diferentes IF's que determinan y especifican mejor el movimiento correcto.
*
* by Catriel
 */
public class Caballo extends Piezas {
	/*
	 * Aqui tenemos el constructor del caballito.
	 */
	public Caballo(int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}

	/*
	 * Aqui comenzamos la matriz el cual delimitara los bordes de los movimientos.
	 */
	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		boolean[][] movimiento = new boolean[8][8];

		/*
		 * Se inicia un bucle, para especificar mejor las 8 posibles direcciones del
		 * caballo.
		 *
		 * Dentro hay un if que se acticara con cada comprobación, devolviendo al final
		 * tan solo los movimientos que no se salgan de los limites.
		 */

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i != x) || (j != y)) {
					movimiento[i][j] = false; // Verificación para determinar si el movimiento es correcto.
				}
			}
		}

		// movimiento: arriba derecha

		if ((x + 1 >= 0) && (x + 1 <= 7) && (y + 2 >= 0) && (y + 2 <= 7)) {
			movimiento[x + 1][y + 2] = true;
		}
		if ((x - 1 >= 0) && (x - 1 <= 7) && (y + 2 >= 0) && (y + 2 <= 7)) {
			movimiento[x - 1][y + 2] = true;
		}
		if ((x + 2 >= 0) && (x + 2 <= 7) && (y + 1 >= 0) && (y + 1 <= 7)) {
			movimiento[x + 2][y + 1] = true;
		}
		if ((x + 2 >= 0) && (x + 2 <= 7) && (y - 1 >= 0) && (y - 1 <= 7)) {
			movimiento[x + 2][y - 1] = true;
		}
		if ((x + 1 >= 0) && (x + 1 <= 7) && (y - 2 >= 0) && (y - 2 <= 7)) {
			movimiento[x + 1][y - 2] = true;
		}
		if ((x - 1 >= 0) && (x - 1 <= 7) && (y - 2 >= 0) && (y - 2 <= 7)) {
			movimiento[x - 1][y - 2] = true;
		}
		if ((x - 2 >= 0) && (x - 2 <= 7) && (y + 1 >= 0) && (y + 1 <= 7)) {
			movimiento[x - 2][y + 1] = true;
		}
		if ((x - 2 >= 0) && (x - 2 <= 7) && (y - 1 >= 0) && (y - 1 <= 7)) {
			movimiento[x - 2][y - 1] = true;
		}

		// Aqui es donde devolvemos la matriz de posiciones posibles.
		return movimiento;
	}
}


