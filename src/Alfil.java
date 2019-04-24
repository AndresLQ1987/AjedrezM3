public class Alfil extends Piezas {

	public Alfil(int x, int y, String color, String nombre) {
		super(x, y, color, nombre);
	}
	
	public int[][] getmovimientos() {
		int[][] movimiento = new int[8][2];
		
		for(int i = 1; i < 8; i++) {
			movimiento[i-1][0] = getX()+(1*i);
			movimiento[i-1][1] = getY()+(1*i);
		}
		
		for(int i = 1; i < 8; i++) {
			movimiento[i+6][0] = getX()-(1*i);
			movimiento[i+6][1] = getY()+(1*i);
		}
		
		for(int i = 1; i < 8; i++) {
			movimiento[i+13][0] = getX()+(1*i);
			movimiento[i+13][1] = getY()-(1*i);
		}
		
		for(int i = 1; i < 8; i++) {
			movimiento[i+20][0] = getX()-(1*i);
			movimiento[i+20][1] = getY()-(1*i);
		}
		
		return movimiento;
	}
}
