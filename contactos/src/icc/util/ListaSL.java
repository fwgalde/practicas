package icc.util;

import icc.contactos.Registro;

 /**
  * Crea una lista simple enlazada
  * @author fwgalde - Ugalde Ubaldo Fernando
  *
  */
public class ListaSL {
    //Atributos de ListaSL
    private Nodo cabeza;
     
    /**
     * Método constructor vacío de ListaSL, en donde cabeza será igual a vacío.
     */
    public ListaSL() {
	cabeza = null;
    }

    /**
     * Método getter de cabeza, es decir que devuelve la cabeza de la lista.
     * @return cabeza, la cabeza de la lista.
     */
    public ListaSL(Nodo cabeza) {
	this.cabeza = cabeza;
    }

    /**
     * Método setter de siguiente, es decir que establece el siguiente nodo de la lista.
     * @param siguiente, El valor del siguiente nodo la lista.
     */
    public Nodo getCabeza() {
	return this.cabeza;
    }

    @Override
    /**
     * Método toString, regresa los atributos de la Lista y sus datos de los nodos.
     */
    public String toString() {

	String datos = "";
	int contador=1;
	Nodo temp = cabeza;

	if(cabeza != null) {
	    while(temp != null) {
		if(temp.getSiguiente() != null) {
		    Registro nombre = (Registro) temp.getSiguiente().getDatos();
		    datos += "\nInformación del contacto " + contador + ":\n" + temp.getDatos() + "\nEl siguiente contacto es: " + nombre.getNombre() + "\n";
		    contador++;
		    temp = temp.getSiguiente();
		} else {
		    datos += "\nInformación del contacto " + contador + ":\n" + temp.getDatos() + "\nNo hay más contactos";
		    contador++;
		    temp = temp.getSiguiente();
		}
	    }
	    return datos;
	}
	 
	return "\n";
    }

    /**
     * Método para insertar un nuevo nodo en la lista.
     * @param n, el objeto que ingresaremos.
     */
    public void inserta(IComparable n) {
	 
	// Condicional por si nos pasan un objeto nulo.
	if(n == null) throw new NullPointerException("No ingreso ningún valor.");
	 
	//Condicional por si la cabeza es nulo.
	if(cabeza == null) {
	    cabeza = new Nodo(n);
	} else {
	     
	    //Condicional si el nodo es menor que la cabeza
	    if(n.comparaCon(cabeza.getDatos()) < 0) {
		Nodo nuevo = cabeza;
		cabeza = new Nodo(n);
		cabeza.setSiguiente(nuevo); //Intercambiamos las posiciones.
		if(nuevo.getSiguiente() != null) {
		    nuevo.setSiguiente(nuevo.getSiguiente());
		}
		 
	    } else if(n.comparaCon(cabeza.getDatos()) == 0) { // Condicional si es igual a la cabeza
		Nodo nuevo = new Nodo(n);
		cabeza.setSiguiente(nuevo); //Lo agregamos enseguida a la cabeza.
	    } else { //Si es mayor a la cabeza.
		Nodo temp = cabeza; //Temporal de la cabeza
		Nodo aux = cabeza; //Temporal de la cabeza
		 
		/* Ciclo para recorrer la lista si es mayor el objeto a la cabeza */
		while(n.comparaCon(temp.getDatos()) > 0) {
		    // Si el siguiente objeto no es null, aumentamos temp para recorrer la lista.
		    if(temp.getSiguiente() != null) {
			aux = temp;
			temp = temp.getSiguiente();
			continue;
		    }
		    break;
		}
		 
		// Condicional se recorrió toda la lista.
		if(temp.getSiguiente() == null) {
		     
		    if(n.comparaCon(temp.getDatos()) > 0) { //Condicional cuando es null y es mayor que el último elemento.
			Nodo nuevo = new Nodo(n);
			temp.setSiguiente(nuevo); // Enlazamos nuestro último indice con el nuevo nodo.
		    } else { // Cuando no es mayor que el último elemento
			Nodo nuevo = new Nodo(n);
			aux.setSiguiente(nuevo); // El anterior a el último le enlazamos con el nuevo
			nuevo.setSiguiente(temp); // El nuevo lo enlazamos con el último
		    }
		} else { //Cuando todavía no se termina la lista.
		    Nodo nuevo = new Nodo(n);
		    aux.setSiguiente(nuevo); //Uno antes del que es mayor que el nuevo lo enlazamos con el nuevo.
		    nuevo.setSiguiente(temp); // El nuevo lo enlazamos con el que es mayor a él.
		}
	    }
	}
    }
     
    /**
     * Obtenemos el elemento de una lista.
     * @return Los datos del nodo.
     */
    public String obtenElemento() {
	Nodo aux = cabeza;
	if(aux != null) {
	    return aux.getDatos().toString();
	}
	return null;
    }
     
    /**
     * Encuentra el elemento dentro de la lista.
     * @param nombre, Busca el nombre del contacto de la lista.
     * @return La informacion del contacto.
     */
    public Registro encuentra(String nombre) {
	 
	//Condicional por si no hay nodo
	if(cabeza == null) {
	    return null;
	}
	Nodo aux = cabeza;
	Registro contacto = new Registro();
	String nomContacto = aux.getDatos().toString().toUpperCase();
	String nom = nombre.toUpperCase(); //Lo ponemos todo mayusculas para ignorar si es mayus o minus
	boolean find = false;
		 
	//Ciclo para recorrer los nodos de la lista
	while(!find) {
	    //Condicional para ver si contiene el nombre
	    if(nomContacto.contains(nom)) {
		contacto = (Registro) aux.getDatos();
		return contacto;
	    }
	    // Condicional que para por si ya no hay otro contacto asi.
	    if(aux.getSiguiente()== null) {
		break;
	    }
	    aux = aux.getSiguiente(); //Siguiente nodo
	    nomContacto = aux.getDatos().toString().toUpperCase(); //Se actualiza la variable
	}
	return null;
    }
}
