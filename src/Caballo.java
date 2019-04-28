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
        for (int i=0; i < 8; i=i+1) {

            if (i == 0) { // movimiento: arriba derecha
                y = y + 2;
                x = x + 1;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }
            if (i == 1) { //movimiento: arriba a la izquierda
                y = y + 2;
                x = x - 1;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }
            if (i == 2) { //movimiento: derecha arriba
                y = y + 1;
                x = x + 2;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }
            if (i == 3) { //movimiento: derecha abajo
                y = y - 1;
                x = x + 2;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }
            if (i == 4) { //movimiento: abajo derecha
                y = y - 2;
                x = x + 1;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }
            if (i == 5) { //movimiento abajo izquierda
                y = y - 2;
                x = x - 1;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }
            if (i == 6) { //izquierda arriba
                y = y + 1;
                x = x - 2;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }
            if (i == 7) { //izquierda abajo
                y = y - 1;
                x = x - 2;
                movimiento[y][x] = (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7);
            }      
        }
      //Aqui es donde devolvemos la matriz de posiciones posibles.
        return movimiento;
    }
}


