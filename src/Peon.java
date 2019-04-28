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
	
	public Peon (int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}
	
	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		boolean[][] movimiento = new boolean[8][8];

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if (j == x || i == y) {
					movimiento[i][j] = true;
				}else {
					movimiento[i][j] = false;
				}		
			}	
		}
			
		for (int j = 0; j < 8; j--) {
			int contX = x+j;
			int contY = y+j;
			if ((contX > 7 || contX < 0) && (contY > 7 || contY < 0 )) {
				movimiento[contX][contY] = false;
			}
		}
		
		for (int j = 0; j < 8; j++) {
			int contX = x+j;
			int contY = y+j;
			if ((contX < 7 || contX > 0) && (contY > 7 || contY < 0 )) {
				movimiento[contX][contY] = false;
			}
		}
		
		for (int j = 0; j < 8; j--) {
			int contX = x+j;
			int contY = y+j;
			if ((contX > 7 || contX < 0) && (contY > 7 || contY < 0 )) {
				movimiento[contX][contY] = true;
			}
		}
		
		for (int j = 0; j < 8; j++) {
			int contX = x+j;
			int contY = y+j;
			if ((contX > 7 || contX < 0) && (contY > 7 || contY < 0 )) {
				movimiento[contX][contY] = false;
			}
		}
		
		for (int j = 0; j < 8; j++) {
			int contX = x+j;
			int contY = y+j;
			if ((contX > 7 || contX < 0) && (contY > 7 || contY < 0 )) {
				movimiento[contX][contY] = true;
			}
		}
		
		for (int j = 0; j < 8; j--) {
			int contX = x+j;
			int contY = y+j;
			if ((contX > 7 || contX < 0) && (contY > 7 || contY < 0 )) {
				movimiento[contX][contY] = false;
			}
		}
		return movimiento;
	}
}
