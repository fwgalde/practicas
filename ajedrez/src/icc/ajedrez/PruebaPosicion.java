package icc.ajedrez;

/**
 * Clase que para probar el objeto Posición 
 * @author fwgalde - Fernando Ugalde Ubaldo
 * 
 **/
public class PruebaPosicion {
    public static void main (String [] args) {
    	Posicion base = new Posicion(); // Caso base
    	System.out.println("La pieza está en la posición: " + base.getColumna() + base.getRenglon());
	
    	/* 
	   Posicion regIncorrect = new Posicion(9,'a');
	   System.out.println("La pieza estÃ¡ en la posiciÃ³n: " + regIncorrect.getColumna() + regIncorrect.getRenglon());
	   
	   Posicion colIncorrect = new Posicion(1,'z');
	   System.out.println("La pieza estÃ¡ en la posiciÃ³n: " + colIncorrect.getColumna() + colIncorrect.getRenglon());
	*/
	
    	/* Ciclo para recorrer las columnas del tablero */
    	for(char c : base.cols) {
	    
	    /* Ciclo para recorrer las filas del tablero */
	    for(int i : base.regs) {
		Posicion allPositions = new Posicion(i,c);
		System.out.println("La pieza está en la posición: " + allPositions.getColumna() + allPositions.getRenglon());
	    }
    	}
    }
}
