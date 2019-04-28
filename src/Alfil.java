/*
L'alfil: 
Quan es pinta per pantalla mostra una A i segons el seu color serà AB o AN. 
Els possibles moviments d'un alfil: 
Pot moure's en tots els sentits de la diagonal que ocupa. 
*/
public class Alfil extends Piezas {

	public Alfil(int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}

	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		boolean[][] movimiento = new boolean[8][8];

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				movimiento[i][j] = false;			
			}	
		}

		for(int j = 0; j < 8; j++) {
			int contX = x+j;
			int contY = y+j;
			if(contY <= 7 && contX <= 7) {
				movimiento[contX][contY] = false;
			}
		}
		
		for(int j = 0; j < 8; j++) {
			int contX = x-j;
			int contY = y-j;
			if(contY <= 7 && contX >= 0) {
				movimiento[contX][contY] = true;
			}
		}
		
		for(int j = 0; j < 8; j++) {
			int contX = x-j;
			int contY = y+j;
			if(contX >= 0  && contY <= 7) {
				movimiento[contX][contY] = false;
			}
		}
		
		for(int j = 0; j < 8; j++) {
			int contX = x+j;
			int contY = y-j;
			if(contX <= 7 && contY >= 0) {
				movimiento[contX][contY] = false;
			}
		}

		return movimiento;
	}	 
}
