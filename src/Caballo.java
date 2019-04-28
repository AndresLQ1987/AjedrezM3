public class Caballo extends Piezas {

    public caballo(int x, int y, String color, String nombre) {
        super(x, y, color, nombre);
    }


    public boolean[][] movimiento(int x, int y, String color) {
        if (movimiento = arriba_derecha) {
            y = y + 2;
            x = x + 1;
            if
            boolean a[][] = new boolean[x][y];
            return a;
        }
    }

    String ruta;

    public void movimiento(){
        if(movimiento=arriba_derecha){
            y=y+2;
            movimientoX=x+1;
            return
        }
        if(movimiento=arriba_izquierda){
            movimientoY=y+2;
            movimientoX=x-1;
        }
        if(movimiento=derecha_arriba){
            movimientoY=y+1;
            movimientoX=x+2;
        }
        if(movimiento=derecha_abajo){
            movimientoY=y-1;
            movimientoX=x+2;
        }
        if(movimiento=abajo_derecha){
            movimientoY=y-2;
            movimientoX=x+1;
        }
        if(movimiento=abajo_izquierda){
            movimientoY=y-2;
            movimientoX=x-1;
        }
        if(movimiento=izquerda_arriba){
            movimientoY=y+1;
            movimientoX=x-2;
        }
        if(movimiento=izquerda_abajo){
            movimientoY=y-1;
            movimientoX=x-2;
        }
        //continuar desde aqui.
    }
}