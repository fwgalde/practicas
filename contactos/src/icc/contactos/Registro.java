package icc.contactos;

import icc.util.IComparable;

/**
 * Guarda los datos de los contactos e implementa métodos de la interfaz IComparable.
 * @author fwgalde - Ugalde Ubaldo Fernando
 * 
 */
public class Registro implements IComparable {
    private String nombre;
    private String direccion;
    private String telefono;
    
    // Esta información fue recopilada de https://www.regular-expressions.info/unicode.html
    public static final String ALFABETO = "^[\\p{L} .'-]+$"; //Alfabeto para revisar las listas
    public static final String NUMEROS = "^[\\p{N} +]+$"; //Numeros para revisar las listas
    public static final String ALFANUMERICOS = "^[\\p{LD} .'-]+$"; //Alfanumericos para revisar las listas
    
    /**
     * Método contrusctor vacío de registro, establecemos a todos los datos como Unknown,
     * es decir desconocido.
     */
    public Registro(){
	this.nombre = "Unknown";
	this.direccion = "Unknown";
	this.telefono = "Unknown";
    }
    
    /**
     * Método constructor de registro.
     * @param nombre, recibimos el nombre del contacto.
     * @param direccion, recibimos la dirección del contacto.
     * @param telefono, recibimos el teléfono del contacto.
     */
    public Registro(String nombre, String direccion, String telefono) {
    	
    	// Si nos ingresan un valor null pondremos por defecto Unknown
    	if(nombre != null) {
    		this.nombre = nombre; //Cuando ingresan una cadena.	
    	} else {
    		this.nombre = "Unknown"; //Cuando nos ingresan null
    	}
    	
    	if(direccion != null) {
    		this.direccion = direccion; //Cuando ingresan una cadena.	
    	} else {
    		this.direccion = "Unknown"; //Cuando nos ingresan null
    	}
    	
    	if(telefono != null) {
    		this.telefono = telefono; //Cuando ingresan una cadena.	
    	} else {
    		this.telefono = "Unknown"; //Cuando nos ingresan null
    	}
    }
    
    /**
     * Método getter de nombre, es decir que devuelve el nombre del objeto de tipo Registro.
     * @return nombre, el nombre almacenado en Registro.
     */
    public String getNombre() {
    	return this.nombre;
    }
    
    /**
     * Método setter de nombre, es decir que establece el nombre del objeto de tipo Registro.
     * @param nombre, El valor que nombre recibirá.
     */
    public void setNombre(String nombre) {
    	if(nombre != null) {
    		this.nombre = nombre; //Cuando nos ingresan una cadena.
    	} else {
    		throw new NullPointerException("No ha introducido un valor."); //Regresamos un error por setear como null.
    	}
    }
    
    /**
     * Método getter de dirección, es decir que devuelve la dirección del objeto de tipo Registro.
     * @return direccion, la dirección almacenado en Registro.
     */
    public String getDireccion() {
    	return this.direccion;
    }

    public void setDireccion(String direccion) {
    	if(direccion != null) {
    		this.direccion = direccion; //Cuando nos ingresan una cadena.
    	} else {
    		throw new NullPointerException("No ha introducido un valor."); //Regresamos un error por setear como null.
    	}
    }
    
    /**
     * Método getter de dirección, es decir que devuelve el teléfono del objeto de tipo Registro.
     * @return telefono, el teléfono almacenado en Registro.
     */
    public String getTelefono() {
    	return this.telefono;
    }

    public void setTelefono(String telefono) {
    	if(telefono != null) {
    		this.telefono = telefono; //Cuando ingresan una cadena.	
    	} else {
    		throw new NullPointerException("No ha introducido un valor."); //Regresamos un error por setear como null.
    	}	
    }

    
    @Override
    /**
     * Método toString, regresa los atributos del objeto Registro.
     */
    public String toString() {
    	return "\nNombre: " + getNombre() + "\nDirección: " + getDireccion() + "\nNúmero: " + getTelefono();
    }


     /**
      * Método de la interfaz IComparable
      * @param Object, un objeto al cual compararemos con otro del mismo tipo.
      * @return 1, -1 o 0, regresa esos valores dependiendo cual sea mayor al otro.
      */
    public int comparaCon(Object o) {
    	Registro aux = (Registro) o; // Realizamos un casting del objeto a uno de tipo Registro.
    	
    	String nom = aux.getNombre();
    	int comparar = nombre.compareToIgnoreCase(nom);
    	
    	// Condicional para comparar el nombre.
    	if (comparar < 0) {
    		return -1;
    	} else if(comparar > 0) {
    		return 1;
    	}
    	
    	String dir = aux.getDireccion();
    	comparar = direccion.compareToIgnoreCase(dir);
    	
    	//Condicional para comparar la dirección.
    	if (comparar < 0) {
    		return -1;
    	} else if(comparar > 0) {
    		return 1;
    	}
    	    	
    	String tel = aux.getTelefono();
    	comparar = telefono.compareTo(tel);
    	
    	//Condicional para comparar el número.
    	if (comparar < 0) {
    		return -1;
    	} else if(comparar > 0) {
    		return 1;
    	}    	
    	return 0;
    }

    /**
     * Método main para ejecutar pruebas sobre si funcionan los contactos.
     * @param args
     */
    public static void main(String [] args) {
    	Registro contacto1 = new Registro("Pablo", "Venezuela", "55112510313");
    	Registro contacto2 = new Registro("Luis", "Colombia", "5511236031");	
    	Registro contacto3 = new Registro("Hoseog", "Seúl", "551236063");

    	System.out.println(contacto1.toString() + contacto2.toString() + contacto3.toString());
    }
} 
