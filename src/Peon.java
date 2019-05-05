/*
El peó: 
Quan es pinta per pantalla mostra una P i segons el seu color serà PB (peó blanc) 
o PN (peó negre). 
Els possibles moviments d'un peó: 
▪ Són augmentar (cas blanques) o disminuir (cas negres) la seva fila en una. 
▪ Si està en la casella inicial pot moure's també a dues files superiors (banques)
o inferiors (negres). 
▪ I matar: 
• Per les blanques: augmentar columna i fila en una, disminuir columna en una
i augmentar fila en una. 
• Per les negres: disminuir columna i fila en una, augmentar columna en una 
i disminuir fila en una. 
*/

public class Peon extends Piezas {
    //Atributo de la clase
	private boolean primerMovimiento;

	public Peon(int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
		primerMovimiento = true;
	}

	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		//Declaramos y creamos el objeto en una línea
		boolean[][] movimiento = new boolean[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				movimiento[i][j] = false;
			}
		}

		if (color == "B") {
			if (primerMovimiento) {
				for (int i = 1; i <= 2; i++) {
					movimiento[x][y - i] = true;
					if ((x + 1 <= 7 && x + 1 >= 0) && (y - 1 <= 7 && y - 1 >= 0)) {
						movimiento[x + 1][y - 1] = true;
					}
					if ((x - 1 <= 7 && x - 1 >= 0) && (y - 1 <= 7 && y - 1 >= 0)) {
						movimiento[x - 1][y - 1] = true;
					}
				}
			} else {
				movimiento[x][y - 1] = true;
				if ((x + 1 <= 7 && x + 1 >= 0) && (y - 1 <= 7 && y - 1 >= 0)) {
					movimiento[x + 1][y - 1] = true;
				}
				if ((x - 1 <= 7 && x - 1 >= 0) && (y - 1 <= 7 && y - 1 >= 0)) {
					movimiento[x - 1][y - 1] = true;
				}
			}
		} else {
			if (primerMovimiento) {
				for (int i = 1; i <= 2; i++) {
					movimiento[x][y + i] = true;
					if ((x + 1 <= 7 && x + 1 >= 0) && (y + 1 <= 7 && y + 1 >= 0)) {
						movimiento[x + 1][y + 1] = true;
					}
					if ((x - 1 <= 7 && x - 1 >= 0) && (y + 1 <= 7 && y + 1 >= 0)) {
						movimiento[x - 1][y + 1] = true;
					}
				}
			} else {
				movimiento[x][y + 1] = true;
				if ((x + 1 <= 7 && x + 1 >= 0) && (y + 1 <= 7 && y + 1 >= 0)) {
					movimiento[x + 1][y + 1] = true;
				}
				if ((x - 1 <= 7 && x - 1 >= 0) && (y + 1 <= 7 && y + 1 >= 0)) {
					movimiento[x - 1][y + 1] = true;
				}
			}
		}
		return movimiento;
	}

    //Método para establecer el Primer Movimiento
	public void setPrimerMovimiento(boolean primerMovimiento) {
		this.primerMovimiento = primerMovimiento;
	}

	public boolean isPrimerMovimiento() {
		return primerMovimiento;
	}

}
