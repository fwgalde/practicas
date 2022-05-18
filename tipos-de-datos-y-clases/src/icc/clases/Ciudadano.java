package icc.clases;

/**
 * Clase constructura del objeto Ciudadano.
 * @author fwgalde
 */

public class Ciudadano {
    // Variables
    private String nombre, apellidoPaterno, apellidoMaterno, fecha;

    /**
     * Método constructor de Ciudadano.
     * Cada ciudadano cuenta con nombre, apellidos y fecha de nacimimento.
     */
    public Ciudadano(String nombre, String apellidoPaterno, String apellidoMaterno, String fecha) {
	this.nombre = nombre;
	this.apellidoPaterno = apellidoPaterno;
	this.apellidoMaterno = apellidoMaterno;
	this.fecha = fecha;	
    }
    /**
     * Método para calcular el RFC del ciudadano.
     * @return rfc Debe devolver el RFC del ciudadano.
     * 
     */
    public String calculaRFC() {
	// Letras del RFC 
	String letra1 = String.valueOf(apellidoPaterno.charAt(0));
	String letra2 = "X";
	String letra3 = String.valueOf(apellidoMaterno.charAt(0));
	String letra4 = String.valueOf(nombre.charAt(0));

	// Fecha del RFC 
	String dia = fecha.substring(0,2);
	String mes = fecha.substring(3,5);
	String año = fecha.substring(8,10);

	// RFC
	String rfc;

	/* Ciclo para encontar la primer vocal del apellido paterno
	 * sin contar la primer letra. 
	 * El método length() se obtuvo de la documentación oficial de
	 * Java 11. https://bit.ly/3Dsf3tT
	 */
	for( int i = 1; i < apellidoPaterno.length(); i++) {
	    // El valor de la letra en la posición i
	    String aux = String.valueOf(apellidoPaterno.charAt(i));

	    // Condicional para encontrar la vocal
	    if(aux.equalsIgnoreCase("a") ||
	       aux.equalsIgnoreCase("e") ||
	       aux.equalsIgnoreCase("i") ||
	       aux.equalsIgnoreCase("o") ||
	       aux.equalsIgnoreCase("u")
	       ) {
		letra2 = String.valueOf(apellidoPaterno.charAt(i));
		i = apellidoPaterno.length(); // Paramos el ciclo
	    }
	}

	// Todas las letras en una misma cadena.
	String letras = letra1 + letra2 + letra3 + letra4;
	letras = letras.toUpperCase(); // Transformamos las letras a mayúsculas.
	/* El método toUpperCase() se obtuve de la documentación oficial de 
	 * Java 11. https://bit.ly/3DseIaB 
	 */
	
	/* Ciclo para cambiar todos las letras que estén acentuadas */
	for(int i = 0; i < letras.length(); i++) {
	    String aux = String.valueOf(letras.charAt(i));
	    if(aux.equalsIgnoreCase("á")){
		letras = letras.replaceAll("Á", "A");
	    }
	    if(aux.equalsIgnoreCase("é")){
		letras = letras.replaceAll("É", "E");
	    }
	    if(aux.equalsIgnoreCase("í")){
		letras = letras.replaceAll("Í", "I");
	    }
	    if(aux.equalsIgnoreCase("ó")){
		letras = letras.replaceAll("Ó", "O");
	    }
	    if(aux.equalsIgnoreCase("ú")){
		letras = letras.replaceAll("Ú", "U");
	    }
	}       	
	return rfc = letras + año + mes + dia;
    }

    /**
     * Método para devolver todos los datos del ciudadano.
     * @return toString El nombre completo (nombre(s), apellido(s) paterno(s), apellido(s) materno(s),
     * cumpleaños (dia-mes) y su RFC. 
     */
    public String toString() {
	String nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
	String dia = fecha.substring(0,2);
	String mes = fecha.substring(3,5);

	// Juntamos todos los datos.
	String toString = "Nombre: " + nombreCompleto
	    + ", Cumpleaños: " + dia + "-" + mes
	    + ", RFC: " + calculaRFC();
	return toString;
    }
}
