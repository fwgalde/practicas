package icc.ajedrez;

import java.util.LinkedList;

/**
 * Clase que representa a la pieza del caballo 
 * dentro del juego de ajedrez
 * @author fwgalde - Fernando Ugalde Ubaldo
 * 
 **/
public class Caballo extends Pieza{ // Clase hija de Pieza
	
    /**
     * Método constructor base de la clase.
     * En caso de no pasarle ningún paramétro, recibirá estos valores.
     * **/
    public Caballo() {
	super();
    }
    
    /**
     * Método constructor de Caballo.
     * @param renglon, Indica el renglón en donde estará el caballo.
     * @param columna, Indica la columna en donde estará el caballo.
     * @param color, Indica de que color es el caballo.
     * 
     **/
    public Caballo(int renglon, char columna, boolean color) {
	super(renglon,columna,color); //Ocupa el método contructor de Pieza.
    }
    
    /**
     * Método para guardar los movimientos posibles del caballo de acuerdo
     * a las reglas del ajedrez.
     * @return movimientos, La lista de los movimientos posibles.
     * 
     **/
    public LinkedList <Pieza> posiblesMovimientos() {
	Caballo knight = new Caballo(getRenglon(), getColumna(), this.color); //Declaramos un caballo para poder acceder a sus arreglos.
	LinkedList <Pieza> movimientos = new LinkedList <Pieza>(); //Declaramos una lista donde almacenaremos a los caballos.
	
	/* Ciclo para recorrer las columnas */
	for(char c : knight.cols) {
	    
	    /* Ciclo para recorrer los renglones*/
	    for(int i : knight.regs) {
		
		//Condicional para ver si es una posición válida.
		if(esValida(i,c) == true) {
		    movimientos.add(new Caballo(i,c,color)); //Agregamos a la lista si sí es válida.
		}
	    }
	}
	return movimientos;
    }
	
    /**
     * Método para verificar que una nueva posición sea posible de hacerse
     * baje las reglas del ajedrez.
     * 
     * @param renglon, El renglón donde se quiere mover a el caballo.
     * @param columna, La columna donde se quiere mover a el caballo.
     * @return true || false, Regresa si se puede o no realizar el movimiento.
     * 
     * **/
    public boolean esValida(int renglon, char columna) {
	Caballo aux = new Caballo(getRenglon(), getColumna(), this.color); //Declaramos un caballo para poder acceder a sus arreglos.
	
	// Verifica que se encuentre dentro del tablero.
	if(contiene(columna, aux.cols) && contiene(renglon, aux.regs)) {
	    
	    int [] intervalo = {-2,-1,1,2}; // Posibles movs de reglon y columna, se obtiene a partir de la difernecia. 
	    //Pues sabemos que el caballo se mueve 2 hacia un lado y 1 hacia otro
	    
	    //Obtenemos el indice de la columna de la posición original. (a = 1, ..., h = 8)
	    int oldCol = getIndice(getColumna(), aux.cols);
		    
	    //Obtenemos el indice de la columna de la nueva posición. (a = 1, ..., h = 8)
	    int newCol = getIndice(columna, aux.cols);
	    
	    //Diferenica de columnas
	    int difCol = oldCol - newCol;
	    
	    //Diferencia de renglones
	    int difReg = getRenglon() - renglon;
	    
	    // Verificamos que se encuentre dentro del intervalo que nos interesa.
	    if(contiene(difReg,intervalo) && contiene(difCol, intervalo)) {
		int [] intervalo2 = {-3,-1,1,3}; // Casos donde el caballo solo se puede mover 2 renglones o columnas y 1 renglon o columna.
				
		// Diferencia
		int dif = difCol - difReg;
				
		// Verificamos que esté dentro del intervalo.
		if (contiene(dif, intervalo2) == true) {
		    return true;
		}
	    }
	}
	return false;
    }
    
    /**
     * Método implementado de clase Pieza. Regresa los datos de la pieza en String.
     * @return Los datos de la pieza.
     * 
	 * */
    public String toString() {
	
	return "El caballo " + colorea(this.color) + "o está en la posicion " + getColumna() + getRenglon();
    }
}
