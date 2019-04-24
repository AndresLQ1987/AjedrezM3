/**
 * 
 * @author cf18christian.villegas
 *
 *
 *La clase 'Piezas' corresponde a una superclase de la que heredarán sus atributos y el método 'movimiento' 
 *aquellas subclases que representan cada una de las figuras del ajedrez. 
 */

public class Piezas {
	private int x;
	private int y;
	private String color;
	private String nombre;

	//Constructor que inicia las coordenadas del tablero, el color de la pieza y el nombre
	public Piezas (int x, int y, String color, String nombre) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.nombre = nombre;
	}
	
	//Getters y Setters de cada atributo de la clase
    public int getX(){
        return x;
    }
    public void setX(int x){

    }
    
    public int getY() {
    	return y;
    }
    public void setY(int y) {
    	
    }
    public String getColor() {
    	return color;
    }
    public void setColor(String color) {
    	
    }
    
   public String getNombre() {
	   return nombre;
   }
   public void setNombre(String nombre) {
	   
   }
   
   //Método que heredará cada pieza para devolver los movimientos que realizan
   public boolean[][] movimiento(int x, int y, String color) {
	   boolean a[][]=new boolean[8][8];
	   return a;
   }
}
	
