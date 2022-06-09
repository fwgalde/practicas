package icc.funciones;

/**
 * Imprime en la consola los argumentos que le fueron pasados a este programa.
 * Todo programa de Java se encuentra de una construcción llamada <code>class</code>.
 */
public class DetectorDePrimos {

    /**
	 * Método principal, tú código comienza a ejecutarse aquí.
	 * @param n Esta variable permite acceder a cada argumento.
	 * @return false or true, Nos regresa un valor de tipo booleano.  
	 *             Los argumentos son cadenas de caracteres <code>String</code>.
	 */
	 public static boolean esPrimo(int n) {
		 
		 // Declaramos y definimos la varible base tipo int,
	         // nos servirá para comprobar que n puede ser primo pues todos los números iguales menores que 2 no son primos.	     
	 	 int base = 2;

		 /* Comprobamos que cumpla el caso base */
		 if(n < base) {

		 	 // Regresamos valor de falso en caso de que sea divisible por un número dentro del intervalo.
		 	 return false;
		 }

		 /* Dividimos a n entre los números dentro del intervalo [base,n-1] */
		 for(int i = base; i < n; i++) {

			  /* Comprobamos que n no sea divisible por ningún número en el intervalo [base,n-1] */
		     	 if(n%i == 0) {

				 // Regresamos valor de falso en caso de que sea divisible por un número dentro del intervalo.
			 	 return false;
			 }
		 }
		 // Regresamos valor de verdadero en caso de que haya cumplido todos los requisitos anteriores:
		 // ser mayor que base y no ser divisible dentro del intervalo [base, n-1].
		 return true;      
	 }
    
	/**
	 * Método principal, tú código comienza a ejecutarse aquí.
	 * @param args Esta variable permite acceder a cada argumento.
	 *             Los argumentos son cadenas de caracteres <code>String</code>.
	 */
	public static void main(String[] args) {
		if(args.length == 0) {
			/* Para usar colores en una consola de Linux se usan
			 * códigos como '\033[35m' ('\003' ó '\e' son códigos para 'escape').
			 * Si quieres jugar con ellos consulta las opciones en:
			 * https://misc.flogisoft.com/bash/tip_colors_and_formatting */

			System.out.println("\033[31mNo se recibieron indicaciones.\033[0m");
		}

		//Declaramos y definimos la variable n tipo int, convierte el primer parametro introducido en args a entero.	    
		int n = Integer.parseInt(args[0]);

		/* Imprime el contenido de args. */
		for(int i = 0; i < args.length; i++) {
			 // Solicitamos al sistema que envíe un mensaje a la salida estándar.
			 System.out.println("\033[35mArgumento " + (i+1) + ": \033[0m" + args[i] );
		}

		//Declaramos y definimos una variable tipo boolean, primo se encarga de almacenar el resultado al método esPar con la variable n.
		boolean primo = esPrimo(n);

		/* Imprime si la variable primo es veredad o falsa */
		if(primo){
			 // Mandamos a imprimir n cuando es primo.		    
			 System.out.println("El número " + n + " es primo.");
			 
		} else {
			 // Mandamos a imprimir n cuando es primo.
		    	 System.out.println("El número " + n + " no es primo.");
		    
		}
	}
}