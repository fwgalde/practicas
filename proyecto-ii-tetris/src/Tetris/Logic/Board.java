package Tetris.Logic;

import java.util.Arrays;

public class Board {
    public static final int WIDTH = 10;
    public static final int HEIGTH = 20;
    private int[][] matrix;

    public Board() {
        this.matrix = new int[Board.HEIGTH][Board.WIDTH];
    }

    /*
     * The coordinate System is from left to right and from top to bottom.
     */
    public int get(int x, int y) {
        return this.matrix[y][x];
    }

    public void set(int x, int y, int value) {
        this.matrix[y][x] = value;
    }

    public int computeFilledRows() {
        return this.deleteFilledRows(0);
    }

    /*
     * Elimina todos los renglones que estan llenos en el
     * tablero y regresa cuantos de ellos se eliminaron
     */
    private int deleteFilledRows(int numRowsDeleted) {
	boolean lineFilled;
	int row = HEIGTH-1;
	if(isLastRowFilled() == false) return 0;
        if(isLastRowFilled() == true){

	    /* Ciclo para recorrer la altura */
	    for(int i = HEIGTH-1; i >= 0; i--) {
		lineFilled = true;

		/* Ciclo para recorrer el ancho */
		for(int j = 0; j < WIDTH; j++) {

		    // Condicinal para ver si no está completa
		    if(matrix[i][j] == 0) {
			lineFilled = false;
			break;
		    }
		}
		if(lineFilled == true) {
		    numRowsDeleted++;
		    row = i; // Decimos que linea está completa

		    /* Ciclo para poner valores vacios en la linea mas alta*/
		    for(int k = 0; k < WIDTH; k++) {
			matrix[k][0] = 0;
		    }

		    /* Ciclo para recorrer el alto desde la linea que se elimina
		     * hasta 1 
		     */
		    for(int l = row; l > 0; l--) {

			/* Ciclo para recorrer el ancho */
			for(int m = 0; m < WIDTH; m++) {
			    matrix[l][m] = matrix[l-1][m];
			}
		    }
		}
	    }
	}
	deleteFilledRows(numRowsDeleted);
        return numRowsDeleted;
    }

    /*
     * Verifica si el ultimo renglon esta completamente lleno.
     * Un renglon esta lleno si todos sus valores son distintos de 0.
     * @return True si el ultimo renglon del tablero esta lleno.
     *     False en otro caso.
     */
    private boolean isLastRowFilled() {
	boolean lineFilled;
	
	/* Ciclo para recorrer la altura */
	for(int i = HEIGTH-1; i >= 0; i--) {
	    lineFilled = true;

	    /* Ciclo para recorrer el ancho*/
	    for(int j = 0; j < WIDTH; j++) {

		// Condicional para ver si no se completa
		if(matrix[i][j] == 0) {
		    lineFilled = false; // La linea no está completa
		    break; // Salimos del ciclo.
		}
	    }
	    if(lineFilled == true) return true;
	}
        return false;
    }
}
