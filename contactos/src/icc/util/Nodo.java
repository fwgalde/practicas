package icc.util;

/**
 * Clase que almacena los nodos de la lista.
 * @author fwgalde - Ugalde Ubaldo Fernando
 *
 */
public class Nodo {
	// Atributos de Nodo
    private IComparable datos;
    private Nodo siguiente;

    /**
     * Método constructor de Nodo, cuando no hay un nodo siguiente.
     * @param datos, los datos del nodo.
     *
     */
    Nodo(IComparable datos) {
    	this.datos = datos;
    	siguiente = null;
    }

    /**
     * Método contrusctor de Nodo, cuando hay un nodo siguiente.
     * @param datos, los datos del nodo.
     * @param siguiente, el nodo que le sigue.
     */
    Nodo(IComparable datos, Nodo siguiente) {
    	this.datos = datos;
    	this.siguiente = siguiente;
    }

    /**
     * Método getter de datos, es decir que devuelve los datos del objeto de tipo Registro.
     * @return datos, los datos almacenados en Nodo.
     */
    IComparable getDatos() {
    	return this.datos;
    }
    
    /**
     * Método setter de datos, es decir que establece los datos del objeto de tipo Nodo.
     * @param datos, El valor que datos recibirá.
     */
    void setDatos(IComparable datos) {
    	this.datos = datos;
    }
    
    /**
     * Método getter de siguiente, es decir que devuelve el siguiente Nodo del objeto de tipo Nodo.
     * @return siguiente, el siguiente nodo en Nodo.
     */
    Nodo getSiguiente() {
    	return this.siguiente;
    }

    /**
     * Método setter de siguiente, es decir que establece el siguiente nodo del objeto de tipo Nodo.
     * @param siguiente, El valor que siguiente recibirá.
     */
    void setSiguiente(Nodo siguiente) {
    	this.siguiente = siguiente;
    }
}
