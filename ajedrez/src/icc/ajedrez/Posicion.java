package icc.ajedrez;

/**
 * Clase que representa la posición de una pieza en
 * el tablero de ajedrez.
 * @author fwgalde - Fernando Ugalde Ubaldo
 * 
 **/
public class Posicion {
    private int renglon; //renglón en el tablero
    private char columna; //columna en el tablero
    
    public final char [] cols = {'a','b','c','d','e','f','g','h'}; //columnas disponibles
    public final int [] regs = {1,2,3,4,5,6,7,8}; // renglones disponibles
    
    /**
     * Método constructor base de la clase.
     * En caso de no pasarle ningún paramétro, recibirá estos valores.
     * **/
    public Posicion() {
    	renglon = 1;
    	columna = 'a';
    }
    
    /**
     * Método constructor de la clase
     * @param renglon, Representa en que renglón del tablero está la pieza.
     * @param columna, Representa en que columna del tablero está la pieza.
     * 
     * **/
    public Posicion(int renglon, char columna) {
	
    	// Comprueba que el renglón está dentro del tablero
    	if(renglon < 1 || renglon > 8) {
	    throw new IllegalArgumentException("El valor del renglÃ³n no se encuentra dentro del tablero.");
    	} else{	
	    this.renglon = renglon;
    	}
	
    	// Comprueba que la columna está dentro del tablero
    	if(contiene(columna, cols) == false) {
	    throw new IllegalArgumentException("El valor de la columna no se encuentra dentro del tablero."); 
    	} else {
	    this.columna = columna;
    	}	
    }
    
    /**
     * Getter de renglon
     * Método para obtener el valor de renglón.
     * @return renglon, El renglón dentro del tablero.
     * 
     * **/    
    public int getRenglon() {
    	return this.renglon;
    }
    
    /**
     * Setter de renglon
     * Método para asignar un valor a renglón.
     * @param renglon, el renglon dentro del tablero.
     * 
     * **/    
    public void setRenglon(int renglon) {
	
    	// Comprueba que el renglón está dentro del tablero
    	if(renglon < 1 || renglon > 8) {
    		throw new IllegalArgumentException("El valor del renglÃ³n no se encuentra dentro del tablero.");
    	} else{	
	    this.renglon = renglon;
    	}
    }
    
    /**
     * Getter de columna
     * Método para obtener el valor de columna.
     * @return columna, La columna dentro del tablero.
     * 
     * **/ 
    public char getColumna() {
    	return this.columna;
    }
    
    /**
     * Setter de columna
     * Método para asignar un valor a columna.
     * @param columna, la columna dentro del tablero.
     * 
     * **/
    public void setColumna(char columna) {
	
    	// Comprueba que la columna está dentro del tablero
    	if(contiene(columna, cols) == false) {
	    throw new IllegalArgumentException("El valor de la columna no se encuentra dentro del tablero."); 
    	} else {
	    this.columna = columna;
    	}
    }
    
    
    /**
     * Método auxiliar para ver si un arreglo de caracteres contiene un carácter.
     * @param col, El valor que se quiere buscar dentro del arreglo.
     * @param cols, El arreglo donde se quiere buscar.
     * 
     * **/
    protected static boolean contiene(char col, char [] cols) {
	
    	/* Ciclo para recorrer el arreglo*/
    	for(char c : cols){
	    
	    // Comprueba que esté dentro del arreglo
	    if(c == col) {
		return true;
	    }
    	}
    	return false;
    }
    
    /**
     * Método auxiliar para ver si un arreglo de enteros contiene un entero.
     * @param reg, El valor que se quiere buscar dentro del arreglo.
     * @param regs, El arreglo donde se quiere buscar.
     * 
     * **/
    protected static boolean contiene(int reg, int [] regs) {
	
    	/* Ciclo para recorrer el arreglo*/
    	for(int r : regs) {
	    
	    // Comprueba que esté dentro del arreglo
	    if(r == reg) {
		return true;
	    }
    	}
    	return false;
    }
}
