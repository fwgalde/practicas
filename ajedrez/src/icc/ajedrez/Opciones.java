package icc.ajedrez;

import java.util.LinkedList;
import java.util.Scanner;


/**
 * Clase que despliega la interfaz de usuario para
 * poder desplegar las diferentes opciones
 * @author fwgalde - Fernando Ugalde Ubaldo
 * 
 **/
public class Opciones {
    private static int opcion;
    public static final String [] PIEZAS = {"Rey", "Caballo", "Reina"};
    public static final String PROMPT = "> ";
    
    
    /**
     * Método que emula un menu principal que se encarga de dar la 
     * bienvenida y ofrecer dos opciones al usuario.
     * **/
    public static void menuInicial() {
	System.out.println("Bienvenido al menú principal \n¿Qué desea hacer? (Ingresa el número correspondiente)");
	System.out.println("1) Agregar una pieza \n2) Salir");		
	
	Scanner sc = new Scanner(System.in);		
	
	System.out.println(PROMPT);
	opcion = sc.nextInt();
	
	switch(opcion) {
	case 1:
	    daPieza();
	    break;
	case 2:
	    System.exit(0);
	}
	
    }
    
    /**
     * Metodo que ejecuta todas las opciones que se pueden realizar con las piezas.
     * 
     * */
    private static void daPieza() {
	boolean salir = false;	//para el ciclo do while
	Scanner sc = new Scanner(System.in); //Para pasar los argumentos
	
	System.out.println("Selecciona una pieza: (Ingresa el número correspondiente)");
	int i=1;
	
	// Ciclo para imprimir las piezas.
	for(String s : PIEZAS) {			
	    System.out.println(i + ") " + s);
	    i++;
	}
	System.out.println(PROMPT);
	opcion = sc.nextInt();
	do {
	    switch(opcion) { 
	    case 1:	//	rey
		Rey rey = new Rey(); //Rey en modo base
		System.out.print("Ingresa el renglón del rey: ");
		System.out.print("\n" + PROMPT);
		rey.setRenglon(sc.nextInt());  //Establecemos renglón
		
		System.out.print("Ingresa la columna del rey: ");
		System.out.print("\n" + PROMPT);
		rey.setColumna(sc.next().charAt(0)); //Establecemos columna
		
		System.out.print("Ingresa el color: (Negro o blanco)");
		System.out.print("\n" + PROMPT);
		sc.nextLine();
		rey.setColor(defineColor(sc.nextLine())); //Establecemos el color
		
		System.out.print("\n" + rey.toString() + "\n"); //Damos información de la pieza.
		do {
		    System.out.println("¿Qué deseas hacer con el rey? (Ingresa el número correspondiente)");
		    System.out.println("1) Obtener los posibles movimientos \n2) Ver si su posición es válida \n3) Modificar su posición \n4) Escoger otra pieza \n5) Salir");		
		    System.out.print(PROMPT);
		    int opcion2 = sc.nextInt();								
		    switch(opcion2) {
		    case 1: //Muestra los posibles movimientos
			LinkedList<Pieza> prueba = rey.posiblesMovimientos();
			int contador = 1;
			System.out.println();
			for(Pieza p : prueba) {
			    System.out.println("Posibilidad " + contador + ". " + p.toString());
			    contador++;
			}
			System.out.println();
			break;
		    case 2:	// Comprueba que el movimiento es válida
			
			System.out.println("Ingresa la columna en la que se encontraría el rey: ");
			System.out.print(PROMPT);
			int newReg = sc.nextInt();
			
			System.out.println("Ingresa la columna en la que se encontraría el rey: ");
			System.out.print(PROMPT);
			char newCol = sc.next().charAt(0);	
			
			// Comprueba que la nueva posición sea válida
			if(rey.esValida(newReg, newCol)) {
			    System.out.println("\nLa cordenada es válida\n");
			} else {
			    System.out.println("\nLa cordenada no es válida\n");
			}
			break;
		    case 3: //Cambia de lugar la pieza
			System.out.println("Ingresa el nuevo renglón del rey: ");
			System.out.print(PROMPT);
			rey.setRenglon(sc.nextInt()); //Cambia de renglón el rey
			
			System.out.println("Ingresa la nueva columna del rey: ");
			System.out.print(PROMPT);
			rey.setColumna(sc.next().charAt(0)); //Cambia de columna el rey
			
			System.out.println("\nInformación actualizada: " + rey.toString() + "\n");
			break;
		    case 4: //Cambiamos de pieza
			daPieza();
			break;
		    case 5: //sale
			System.exit(0);
		    default:
			throw new IllegalArgumentException("Ingreso un comando no válido");
		    }			
				}while(!salir);
		break;
	    case 2: //caballo
		Caballo knigth = new Caballo(); //Caballo en modo base
		System.out.print("Ingresa el renglón del caballo: ");
		System.out.print("\n" + PROMPT);
		knigth.setRenglon(sc.nextInt());//Establecemos renglón
		
		System.out.print("Ingresa la columna del caballo: ");
		System.out.print("\n" + PROMPT);
		knigth.setColumna(sc.next().charAt(0));//Establecemos columna
		
		System.out.print("Ingresa el color: (Negro o blanco)");
		System.out.print("\n" + PROMPT);
		sc.nextLine();
		knigth.setColor(defineColor(sc.nextLine()));//Establecemos el color
		
		System.out.println("\n" + knigth.toString() + "\n");//Damos información de la pieza.
		do {				
		    System.out.println("¿Qué deseas hacer con el caballo? (Ingresa el número correspondiente)");
		    System.out.println("1) Obtener los posibles movimientos \n2) Ver si puede mover a otra coordenada. \n3) Modificar su posición \n4) Escoger otra pieza \n5) Salir");		
		    System.out.print(PROMPT);
		    int opcion2 = sc.nextInt();	
		    switch(opcion2) {
		    case 1: //Muestra los posibles movimientos
			LinkedList<Pieza> prueba = knigth.posiblesMovimientos();
			int contador = 1;
			System.out.println();
			for(Pieza p : prueba) {
			    System.out.println("Posibilidad " + contador + ". " + p.toString());
			    contador++;
			}
			System.out.println();
			break;
		    case 2:	// Comprueba que el movimiento es válida				
			System.out.println("Ingresa la columna en la que se encontraría el caballo: ");
			System.out.print(PROMPT);
			int newReg = sc.nextInt();
			
			System.out.println("Ingresa la columna en la que se encontraría el caballo: ");
			System.out.print(PROMPT);
			char newCol = sc.next().charAt(0);	
			
							// Comprueba que la nueva posición sea válida
			if(knigth.esValida(newReg, newCol)) {
								System.out.println("\nLa cordenada es válida\n");
			} else {
			    System.out.println("\nLa cordenada no es válida\n");
							}
			break;
		    case 3: //Cambiamos de posicion
			System.out.println("Ingresa el nuevo renglón del caballo: ");
			System.out.print(PROMPT);
			knigth.setRenglon(sc.nextInt()); //Cambia de renglón el caballo
			
			System.out.println("Ingresa la nueva columna del caballo: ");
			System.out.print(PROMPT);
			knigth.setColumna(sc.next().charAt(0));	//Cambia de columna el caballo
			
			System.out.println("\nInformación actualizada: " + knigth.toString() + "\n");
			break;
		    case 4: //Cambiamos de pieza
			daPieza();
			break;
		    case 5: //sale
			System.exit(0);
			break;
		    default:
			throw new IllegalArgumentException("Ingreso un comando no válido");
		    }	
		}while(!salir);
		break;
		
	    case 3: //reina
		Reina queen = new Reina(); //Reina en modo base
		System.out.print("Ingresa el renglón de la reina: ");
		System.out.print("\n" + PROMPT);
		queen.setRenglon(sc.nextInt());//Establecemos renglón
		
		System.out.print("Ingresa la columna de la reina: ");
		System.out.print("\n" + PROMPT);
		queen.setColumna(sc.next().charAt(0)); //Establecemos columna
		
		System.out.print("Ingresa el color de la reina: (Negro o blanco)");
		System.out.print("\n" + PROMPT);
		sc.nextLine();
		queen.setColor(defineColor(sc.nextLine()));//Establecemos el color
		
		System.out.println("\n" + queen.toString() + "\n");//Damos información de la pieza.
		do {
		    System.out.println("¿Qué deseas hacer con la reina? (Ingresa el número correspondiente)");
		    System.out.println("1) Obtener los posibles movimientos \n2) Ver si su posición es válida \n3) Modificar su posición \n4) Escoger otra pieza \n5) Salir");			
		    System.out.print(PROMPT);
		    int opcion2 = sc.nextInt();				
		    switch(opcion2) {
		    case 1: //Muestra los posibles movimientos
			LinkedList<Pieza> prueba = queen.posiblesMovimientos();
			int contador = 1;
			System.out.println();
			for(Pieza p : prueba) {
			    System.out.println("Posibilidad " + contador + ". " + p.toString());
			    contador++;
			}
			System.out.println();
			break;
		    case 2:	// Comprueba que el movimiento es válida							
			System.out.println("Ingresa el renglón en el que se encontraría la reina: ");
			System.out.print(PROMPT);
			int newReg = sc.nextInt();
			
			System.out.println("Ingresa la columna en la que se encontraría la reina: ");
			System.out.print(PROMPT);
			char newCol = sc.next().charAt(0);	
			
			// Comprueba que la nueva posición sea válida
			if(queen.esValida(newReg, newCol)) {
			    System.out.println("\nLa cordenada es válida\n");
			} else {
			    System.out.println("\nLa cordenada no es válida\n");
			}
			break;
		    case 3: //Cambiamos de posicion
			System.out.println("Ingresa el nuevo renglón de la reina: ");
			System.out.print(PROMPT);
			queen.setRenglon(sc.nextInt()); // Cambia de renglón la reina.
			
			System.out.println("Ingresa la nueva columna de la reina: ");
			System.out.print(PROMPT);
			queen.setColumna(sc.next().charAt(0));	//Cambia de columna la reina.		
			
			System.out.println("\nInformación actualizada: " + queen.toString() + "\n");
			break;
		    case 4: //Cambiamos de pieza
			daPieza();
			break;
		    case 5: //Salimos
			System.exit(0);
			break;
		    default:
			throw new IllegalArgumentException("Ingreso un comando no válido");
		    }					
		}while(!salir);
				break;
	    default :
		throw new IllegalArgumentException("Ingreso un comando no válido");
	    }
	}while(!salir);
    }
    
    /**
     * Método que revisa que color paso el usuario
     * @return false || true, depende del color que le pasen.
     * **/
    private static boolean defineColor(String color) {
	if(color.equalsIgnoreCase("Blanco")) return true;
	else if(color.equalsIgnoreCase("Negro")) return false;
	else throw new IllegalArgumentException("Ingreso un valor erroneo");				
    }
    
}
