package icc.ordenamientos;

/**
 * Clase donde se encuentran los algoritmos para
 * ordenar arreglos. 
 */
public class Ordenamientos {

    /**
     * Ordena el arreglo recibido usando CountingSort.
     * @param arreglo el arreglo a ordenar.
     * @param m minimo valor en el arreglo.
     * @param M maximo valor en el arreglo.
     */
    public static void countingSort(int[] arreglo, int m, int M) {
	if(arreglo.length < 0) throw new IllegalArgumentException("Indefinido");
	int aux [] = new int [(M-m+1)]; //Arrelgo auxiliar.
	int indice = 0; // Indice del arreglo principal

	/* Ciclo para inicializar los índices del arreglo auxiliar */
	for(int i = 0; i < aux.length; i++) {
	    aux[i] = 0;
	}
	
	/* Ciclo para agregar las repeticiones de los valores del arreglo principal 
	   en el arreglo auxiliar */
	for(int i = 0; i < arreglo.length; i++) {
	    int valor = arreglo[i];
	    aux[valor - m]++;
	}

	/* Ciclo para recorrer el arreglo auxiliar */
	for(int j = 0; j < aux.length; j++) {
	    if(aux[j] != 0){
		int n = aux[j];

		/* Ciclo para el ordenamiento del arreglo principal */
		for(int i = indice; i < (indice + n); i++) {
		    arreglo[i] = (j+m);
		}
		indice+=n;
	    }
	}	
    }
    
    
    /**
     * Método auxiliar. Dado un arreglo y dos índices 
     * (se asumen no negativos y menores a la longitud del arreglo) 
     * intercambia los elementos en esos índices.
     * @param a el arreglo en el que se haran los intercambios.
     * @param i el primer índice.
     * @param j el segundo índice.
     */
    public static void intercambia(int[] a, int i, int j) {
	// Variables que guardan el valor del arreglo en determinado índice. 
	int k = a[i];
	int m = a[j];
	// Intercambio de los valores dentro del arreglo.
	a[i] = m;
	a[j] = k;
    }
    
    /**
     * Ordena el arreglo recibido usando SelectionSort.
     * @param arreglo el arreglo a ordenar.
     */
    public static void selectionSort(int[] arreglo) {
	if(arreglo.length < 0) throw new IllegalArgumentException("Indefinido");

	/* Ciclo para recorrer el arreglo */
	for(int i = 0; i < arreglo.length; i++) {

	    /* Ciclo para comparar los elementos del arreglo */
	    for(int j = i; j < arreglo.length; j++) {
		if(arreglo[j] < arreglo[i]) {
		    intercambia(arreglo, i, j);
		}
	    }
	}
    }
}
