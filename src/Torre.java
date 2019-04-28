/*
Class que cae de piezas.
Incluye bucle de verificación de posiciones para poder enseñar posibles movimientos.

 Mensión honorifica al bucle de la pieza "reina", la cual cogi, por ser mas eficiente
 dado que en un principio quería hacer una cadena de comprobación basada en IF's.
 */
public class Torre extends Piezas {
    /*
    Se crea una matriz, la cual recibira 2 enteros y un string especificando el color.
    Finalmente este retornara la comprobación en forma de true/false de la posición
    que se haya metido al comenzamiento.
     */
    public boolean[][] movimiento(int x, int y) {
        boolean[][] movimiento = new boolean[8][8]; //Se crea una matriz para la posición.

        for(int i=0; i=8; i=i+1) {
            for(int j=0; j=8; j=j+1) {
                if ((j == x) || (i == y)) {
                    movimiento[i][j] = true; //Verificación para determinar si el movimiento es correcto.

                }else {
                    movimiento[i][j] = false; //Verificación para determinar si el movimiento es correcto.

                }

            }
        }
        return movimiento;
    }
}

