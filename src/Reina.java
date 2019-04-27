/**
 * 
 * @author cf18christian.villegas
 *
 */

public class Reina extends Piezas {
	
	public Reina (int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}
	
	@Override
	public boolean[][] movimiento(int x, int y, String color) {
		boolean[][] movimiento = new boolean[8][8];
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if (j == x || i == y) {
					movimiento[i][j] = true;
				}else {
					movimiento[i][j] = false;
				}		
			}	
		}

		for(int j= 0; j<8; j++) {
			int contX = x+j;
			int contY = y+j;
			if((contX <= 7 && contX >= 0) || (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
		for(int j= 0; j<8; j++) {
			int contX = x-j;
			int contY = y-j;
			if((contX <= 7 && contX >= 0) || (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
		for(int j = 0; j<8; j++) {
			int contX = x-j;
			int contY = y+j;
			if((contX <= 7 && contX >= 0) || (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
		for(int j = 0; j<8; j++) {
			int contX = x+j;
			int contY = y-j;
			if((contX <= 7 && contX >= 0) || (contY <= 7 && contY >= 0)) {
				movimiento[contX][contY] = true;
			}
		}
			
		return movimiento;
	   }
	 
}
