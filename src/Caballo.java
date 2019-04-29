/*
*Este class se encarga de determinar el movimiento del caballito, el cual es una extención
* de Piezas.
* Se utilizan diferentes IF's que determinan y especifican mejor el movimiento correcto.
*
* by Catriel
 */
public class Caballo extends Piezas {
    /*
    *Aqui tenemos el constructor del caballito.
     */
    public Caballo(int x, int y, String color, String nombre) {
        super(x, y, color, nombre);
    }
    /*
    *Aqui comenzamos la matriz el cual delimitara los bordes de los movimientos.
    */
    @Override
    public boolean[][] movimiento(int x, int y, String color) {
        boolean[][] movimiento = new boolean[8][8];

        /*
        *Se inicia un bucle, para especificar mejor las 8 posibles direcciones del caballo.
        *
        * Dentro hay un if que se acticara con cada comprobación, devolviendo al final
        * tan solo los movimientos que no se salgan de los limites.
         */

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if ((i != x) || (j != y)) {
                    movimiento[i][j] = false; //Verificación para determinar si el movimiento es correcto.
                }
            }
        }

        for (int i=0; i < 8; i=i+1) {
            if (i == 0) { // movimiento: arriba derecha
                int y2 = y + 2;
                int x2 = x + 1;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }
            if (i == 1) { //movimiento: arriba a la izquierda
                int y2 = y + 2;
                int x2 = x - 1;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }
            if (i == 2) { //movimiento: derecha arriba
                int y2 = y + 1;
                int x2 = x + 2;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }
            if (i == 3) { //movimiento: derecha abajo
                int y2 = y - 1;
                int x2 = x + 2;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }
            if (i == 4) { //movimiento: abajo derecha
                int y2 = y - 2;
                int x2 = x + 1;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }
            if (i == 5) { //movimiento abajo izquierda
                int y2 = y - 2;
                int x2 = x - 1;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }
            if (i == 6) { //izquierda arriba
                int y2 = y + 1;
                int x2 = x - 2;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }
            if (i == 7) { //izquierda abajo
                int y2 = y - 1;
                int x2 = x - 2;
                if ((x2 >= 0) && (x2 <= 7) && (y2 >= 0) && (y2 <= 7)) {
                    movimiento[y][x] = true;
                }
            }      
        }
      //Aqui es donde devolvemos la matriz de posiciones posibles.
        return movimiento;
    }
}


