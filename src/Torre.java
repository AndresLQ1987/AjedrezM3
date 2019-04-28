public class Torre extends Piezas {

    public torre(int x, int y, String color, String nombre) {
        super(x, y, color, nombre);
    }

    public void Movimiento(int movimiento_desdeX, int movimiento_desdeY) {

        int desdeX = movimiento_desdeX;
        int desdeY = movimiento_desdeY;
    }

    for(int i=0; i<8; i++) {
        for(int j=0; j<8; j++) {
            if (j == x && i == y) {
                movimiento[i][j] = true;
            }else {
                movimiento[i][j] = false;
            }
        }
    }
    String ruta;



    //continuar desde aqui.
    }
}

