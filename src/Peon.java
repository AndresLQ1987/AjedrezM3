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

	public void movimiento () {
		int x = getX();
		int y = getY();

		if (y == 0) {
			System.out.println("NO HAY MOVIMIENTOS");
		} else {
			if (y > 5) {
				System.out.println("EL PEÓN NO PUEDE POSICIONARSE TAN ATRÁS");
			} 
		}

		if (y == 2) {
			y[1] = y+2;
			x[1] = x;
			
			if (movimiento(x[1],y[1]) == "  ") {
				System.out.println("Movimientos Posibles: " +x[1]+" "+y[1]);
			}
		}
		
		y[2] = y+1;
		x[2] = x;
		
		if (movimiento(x[2],y[2]) == "  ") {
			System.out.println("Movimientos Posibles: " +x[2]+" "+y[2]);	
		}

	}	
}
