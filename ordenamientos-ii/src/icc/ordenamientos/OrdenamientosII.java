package icc.ordenamientos;

/**
 * Clase donde se encuentran los algoritmos para
 * ordenar arreglos. 
 */
public class OrdenamientosII {
    
    /**
     * Método auxiliar. Dado un arreglo y dos índices 
     * (se asumen no negativos y menores a la longitud del arreglo) 
     * intercambia los elementos en esos índices.
     * @param a el arreglo en el que se haran los intercambios.
     * @param i el primer índice.
     * @param j el segundo índice.
     */
    public static void intercambia(int[] a, int i, int j) {
        int k = a[i];
	int m = a[j];
	a[i] = m;
	a[j] = k;
    }
    
    /**
     * Ordena el arreglo recibido usando QuickSort.
     * @param arreglo el arreglo a ordenar.
     */
    public static void quickSort(int[] arreglo) {
        // Ordenamos el arreglo completo (de 0 a length-1)
        quickSort(arreglo, 0, arreglo.length-1);
    }
    
    
    /**
     * Método auxiliar para implementar quicksort de forma recursiva, 
     * usando parámetros extra para indicar el inicio y fin del subarreglo.
     * @param arreglo el arreglo de donde se obtiene el subarreglo a ordenar.
     * @param inicio el índice de inicio del subarreglo a ordenar.
     * @param fin el índice del final del subarreglo a ordenar.
     */
    private static void quickSort(int[] arreglo, int inicio, int fin){
        // Implemente la función
        int pivote = arreglo[inicio];
	int i = inicio + 1;
	int j = fin;

	while(i < j) {	    
	    if (arreglo[i] <= pivote) {
		i++;
	    } else if(arreglo[j] > pivote && arreglo[i] > pivote) {
		j--;
	    } else if(arreglo[i] > pivote && arreglo[j] <= pivote)
		intercambia(arreglo, i, j);	    
	}
	if (arreglo[i] > pivote) 
	    i--;
	intercambia(arreglo, inicio, i);
	if(inicio < i-1)
	    quickSort(arreglo, inicio, i-1);
	if(i+1 < fin)
	    quickSort(arreglo, i+1, fin);
    }
    
    /**
     * Busca un elemento en un arreglo mediante búsqueda binaria.
     * @param arreglo el arreglo donde se hará la búsqueda
     * @param elemento el número que se buscará.
     * @return El índice de n en el arreglo o -1 si no se encuentra.
     */
    public static int busquedaBinaria(int[] arreglo, int elemento){
        // Implementa la función. 
        /* No te debe tomar más de tres líneas. Toma como ejemplo 
           El método quickSort que ya se te entregó implementado.*/
	return busquedaBinaria(arreglo, elemento, 0, arreglo.length-1);
    }

    /**
     * Método auxiliar para implementar busquedaBinaria de forma recursiva, 
     * usando parámetros extra para indicar el inicio y fin del subarreglo.
     * @param a el arreglo de donde se obtiene el subarreglo.
     * @param elemento el número que se buscará.
     * @param inicio el índice de inicio del subarreglo.
     * @param fin el índice del final del subarreglo.
     * @return El índice de n en el subarreglo o -1 si no se encuentra.
     */
    public static int busquedaBinaria(int [] a, int elemento, int inicio, int fin) {
	if(a.length == 0) return -1;
	if(inicio<= fin){
	    int pMedio = (inicio+fin)/2;
	    if(a[pMedio] == elemento){
		return pMedio;
	    }else if(a[pMedio] > elemento){
		return busquedaBinaria(a, elemento, inicio, pMedio-1);
	    }else{
		return busquedaBinaria(a, elemento, pMedio+1, fin);
	    }
	}
	return -1;
    } 
}
