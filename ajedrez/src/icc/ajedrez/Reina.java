package icc.ajedrez;

import java.util.LinkedList;

/**
 * Clase que representa a la pieza de la reina 
 * dentro del juego de ajedrez
 * @author fwgalde - Fernando Ugalde Ubaldo
 * 
 **/
public class Reina extends Pieza { // Clase hija de Pieza
    
    /**
     * Método constructor base de la clase.
     * En caso de no pasarle ningún paramétro, recibirá estos valores.
     * **/
    public Reina() {
	super();
    }
    
    /**
     * Método constructor de Reina.
     * @param renglon, Indica el renglón en donde estará la reina.
     * @param columna, Indica la columna en donde estará la reina.
     * @param color, Indica de que color es la reina.
     * 
     * **/
    public Reina(int renglon, char columna, boolean color) {
		super(renglon, columna,color); //Ocupa el método contructor de Pieza.
    }
    
    /**
     * Método para guardar los movimientos posibles de la reina
     * de acuerdo a las reglas del ajedrez.
     * @return movimientos, La lista de los movimientos posibles.
     * 
     * **/
    public LinkedList <Pieza> posiblesMovimientos(){
	Reina queen = new Reina(getRenglon(), getColumna(), this.color); //Declaramos una reina para poder acceder a sus arreglos.
	LinkedList <Pieza> movimientos = new LinkedList <Pieza>(); //Declaramos una lista donde almacenaremos a las reinas.
	
	/* Ciclo para recorrer las columnas */
	for(char c : queen.cols) {
	    
	    /* Ciclo para recorrer los renglones*/
	    for(int i : queen.regs) {
		
		//Condicional para ver si es una posición válida.
		if(esValida(i,c) == true) {
		    movimientos.add(new Reina(i,c,color)); //Agregamos a la lista si sí es válida.
		}
	    }
	}
	return movimientos;
    }
    
    /**
     * Método para verificar que una nueva posición sea posible de hacerse
     * baje las reglas del ajedrez.
     * 
     * @param renglon, El renglón donde se quiere mover a la reina.
     * @param columna, La columna donde se quiere mover a la reina.
     * @return true || false, Regresa si se puede o no realizar el movimiento.
     * 
     * **/	
    public boolean esValida(int renglon, char columna) {
	Reina aux= new Reina(getRenglon(), getColumna(), this.color); // Declaramos una reina para poder acceder a sus arreglos.
		
	// Verifica que se encuentre dentro del tablero.
	if(contiene(columna, aux.cols) && contiene(renglon, aux.regs)) {			
	    
	    if(getRenglon() == renglon && getColumna() != columna) { //Lineas horizontales
		return true;
		
	    } else if(getRenglon() != renglon && getColumna() == columna){	//Lineas verticales			
		return true;
	    }else { //Diagonales
		
		//Obtenemos el indice de la columna de la posición original. (a = 1, ..., h = 8)				
		int oldCol = getIndice(getColumna(), aux.cols);
		
		//Obtenemos el indice de la columna de la nueva posición. (a = 1, ..., h = 8)
		int newCol = getIndice(columna, aux.cols);
		
		//Usamos la clase Math.abs para obtener la diferencia de el valor original y el nuevo
		int difCol = Math.abs(oldCol - newCol);
		int difReg = Math.abs(getRenglon() - renglon);
		
		// Sacamos la diferencia entre las columnas y renglones
		int dif = difCol - difReg;
		
				//Condicional para los movimientos diagonales
		if(dif == 0 && oldCol != newCol && getRenglon() != renglon) {
		    return true;
		}
	    }			
	}
	return false;
    }
    
    /**
     * Método para regresar los datos de la pieza en String.
     * @return Los datos de la pieza.
     * 
     * **/
    public String toString() {
	return "La reina " + colorea(this.color) + "a está en la posicion " + getColumna() + getRenglon();
    }
}	
