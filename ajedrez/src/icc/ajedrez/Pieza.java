package icc.ajedrez;
import java.util.*;

/**
 * Clase abstracta que representa una pieza dentro
 * del tablero de ajedrez
 * @author fwgalde - Fernando Ugalde Ubaldo
 * 
 **/
public abstract class Pieza extends Posicion { // Clase hija de Posición
    
    protected boolean color;
    
    /**
     * Metodo constructor base de la clase.
     * En caso de no pasarle ningún parametro, recibirá estos valores.
     **/
    public Pieza() {
    	super();
    	this.color = true;
    }
    /**
     * Metodo constructor de la clase Pieza
     * @param renglon, En que renglon esta posicionada la pieza. 
     * @param columna, En que columna esta posicionada la pieza.
     * @param color, Le da el color a la pieza.
     * 
     * */
    public Pieza(int renglon, char columna, boolean color) {
    	super(renglon,columna); //Ocupa el metodo contrusctor de Posición
    	this.color = color;
    }
    
    /**
     * Metodo abstracto
     * Definira los posibles movimientos de las piezas.
     * **/
    public abstract List <Pieza> posiblesMovimientos();
    
    /**
     * Metodo abstracto
     * Revisará si la pieza se puede mover a otra posición, según las reglas del ajedrez.
     * @param renglon, En que renglón se posicionará la pieza.
     * @param columna, En que columna se posicionará la pieza.
     * 
     * */
    public abstract boolean esValida(int renglon, char columna);
    
    /**
     * Metodo abstracto
     * Regresará los valores de las piezas en string.
     * 
     * **/
    public abstract String toString();
    
    /**
     * Getter de color.
     * Metodo para obtener el valor de color.
     * @return color, El color de la pieza
     * 
     * **/ 
    public boolean getColor() {
    	return this.color;
    }
    
    /**
     * Setter de color.
     * Metodo para asignar un valor a color.
     * @param color
     * **/
    public void setColor(boolean color) {
    	this.color = color;
    }
        
    /** Metodo auxiliar para obtener el índice de un caracter específico dentro de un arreglo.
     * @param col, el valor del que queremos saber su índice.
     * @param cols, El arreglo el cual revisaremos.
     * **/
    public static int getIndice(char col, char [] cols) {
	for(int i = 0; i < cols.length; i++) {
			if(cols[i] == col) return ++i;
	}
	return -1;
    }
    
    /**
     * Metodo auxiliar para establecer el color
     * @param color, si es true es blanco y si es false negro
     * @return El color en String
     * **/
    public static String colorea(boolean color) {		
	if(color) {
	    return "blanc";
		}		
	return "negr";
    }
}
