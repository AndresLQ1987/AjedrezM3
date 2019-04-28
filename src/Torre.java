/*
*Class que cae de piezas.
*Incluye bucle de verificación de posiciones para poder enseñar posibles movimientos.
*
 *Mensión honorifica al bucle de la pieza "reina", la cual cogi, por ser mas eficiente
 *dado que en un principio quería hacer una cadena de comprobación basada en IF's.
 *
 * By Catriel, prestandose codigo de @author cf18christian.villegas de su pieza Reina.
 */
public class Torre extends Piezas {

    /*
     *Aqui tenemos el constructor de la torre.
     */
    public Torre (int x, int y, String color, String nombre) {
        super(x, y, color, nombre);
    }

    /*
    Se crea una matriz, la cual recibira 2 enteros y un string especificando el color.
    Finalmente este retornara la comprobación en forma de true/false de la posición
    que se haya metido al comenzamiento.
     */
    @Override
    public boolean[][] movimiento(int x, int y,String color) {
        boolean[][] movimiento = new boolean[8][8]; //Se crea una matriz para la posición.

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if ((i == x) || (j == y)) {
                    movimiento[i][j] = true; //Verificación para determinar si el movimiento es correcto.
                }else {
                    movimiento[i][j] = false; //Verificación para determinar si el movimiento es correcto.
                }
            }
        }
        return movimiento;
    }
}

