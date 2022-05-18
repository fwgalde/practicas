package icc.ajedrez;
import java.util.LinkedList;

/**
 * Clase que representa a la pieza del rey 
 * dentro del juego de ajedrez
 * @author fwgalde - Fernando Ugalde Ubaldo
 * 
 **/
public class Rey extends Pieza {
       
    /**
     * Método constructor base de la clase.
     * En caso de no pasarle ningún paramétro, recibirá estos valores.
     * **/
    public Rey() {
	super();
    }
    
    /**
     * Método constructor de Caballo.
     * @param renglon, Indica el renglón en donde estará el rey.
     * @param columna, Indica la columna en donde estará el rey.
     * @param color, Indica de que color es el rey.
     * 
     **/
	public Rey(int renglon, char columna, boolean color) {
		super(renglon, columna, color); //Ocupa el método contructor de Pieza.
	}
    
    /**
     * Método para guardar los movimientos posibles del rey de acuerdo
     * a las reglas del ajedrez.
     * @return movimientos, La lista de los movimientos posibles.
     * 
     **/
    public LinkedList <Pieza> posiblesMovimientos() {
	Rey a = new Rey(getRenglon(), getColumna(), color); //Declaramos un caballo para poder acceder a sus arreglos.
	LinkedList <Pieza> movimientos = new LinkedList <Pieza>(); //Declaramos una lista donde almacenaremos a los reyes.
	
	/* Ciclo para recorrer las columnas */
	for(char c : a.cols) {
	    
	    /* Ciclo para recorrer los renglones*/
	    for(int i : a.regs) {
		
		//Condicional para ver si es una posición válida.
		if(esValida(i, c) == true) {		    
		    movimientos.add(new Rey(i, c, color)); //Agregamos a la lista si sí es válida.
		}
	    }
	}
	return movimientos;
    }
    
    /**
     * Método para verificar que una nueva posición sea posible de hacerse
     * baje las reglas del ajedrez.
     * 
     * @param renglon, El renglón donde se quiere mover a el rey.
     * @param columna, La columna donde se quiere mover a el rey.
     * @return true || false, Regresa si se puede o no realizar el movimiento.
     * 
     * **/	
    public boolean esValida(int renglon, char columna) {
    	Rey aux = new Rey(getRenglon(), getColumna(), this.color); //Declaramos un rey para poder acceder a sus arreglos.
	
    	// Verifica que se encuentre dentro del tablero.
    	if(contiene(columna, aux.cols) && contiene(renglon, aux.regs)){
	    int [] intervalo = {-1,0,1}; // Posibles movs de reglon y columna, se obtiene a partir de la difernecia. 
	    //Pues sabemos que el rey se mueve solo hacia un lado
	    
	    //Obtenemos el indice de la columna de la posición original. (a = 1, ..., h = 8)
	    int oldCol = getIndice(getColumna(), aux.cols); 
	    
	    //Obtenemos el indice de la columna de la nueva posición. (a = 1, ..., h = 8)
	    int newCol = getIndice(columna, aux.cols);
	    
	    //Diferenica de columnas
	    int difCol = oldCol - newCol;
	    
	    //Diferenica de renglones
	    int difReg = getRenglon() - renglon;
	    
	    // Verificamos si se encuentra dentro del intervalo que nos interesa
	    if(contiene(difReg, intervalo) && contiene(difCol, intervalo)) {
		
		// Quitamos el caso donde el rey esté en su misma posición.
		if(oldCol == newCol && getRenglon() == renglon) {
		    return false;
		}
		return true;
	    }
    	}	
    	return false;
    }
        
    /**
     * Método implementado para regresar los datos de la pieza en String.
     * @return Los datos de la pieza.
     * 
     **/
    public String toString() {
	return "El rey " + colorea(this.color) + "o está en la posicion " + getColumna() + getRenglon();
    }
}
