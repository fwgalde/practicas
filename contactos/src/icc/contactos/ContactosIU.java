package icc.contactos;

import java.util.Scanner;

/**
 * Interfaz de usuario para manejar una lista de contactos.
 * @author blackzafiro
 */
public class ContactosIU {
	private Scanner scanner;
	private Contactos contactos;
    
	/**
	* Crea la interfaz de usuario para manejar una lista de contactos.
	*/
	public ContactosIU() {
		scanner = new Scanner(System.in);
		contactos = new Contactos();
	}
	
	/**
	* Pide un número al usuario.
	* @param mensaje
	* @return 
	*/
	private int leeEntero(String mensaje) {
		System.out.println(mensaje);
		boolean error = false;
		int num = -1;
		try {
			num = Integer.parseInt(scanner.nextLine());
			if (num <= 0) {
				error = true;
				System.out.println("El valor más chico posible es uno.");
			}
		} catch (NumberFormatException nfe) {
			error = true;
			System.out.println("Por favor ingresa un número válido.");
		}
		if (error) {
			num = leeEntero(mensaje);
		}
		return num;
	}
    
	/**
	 * Pide al usuario los datos del contacto nuevo y devuelve un registro con
	 * ellos.
	 * @return 
	 */
	private Registro solicitaDatosDeContacto() {	
		String nombre = null;
		String direccion = null;
		String telefono = null;
		
		System.out.println("Dame los datos del nuevo contacto...");
		boolean f = false;
		
		//Ciclo para impedir que el usuario ponga carácteres ajenos a lo que pedimos.
		while(!f) {
			System.out.println("Nombre: ");
			nombre = scanner.nextLine();
			
			// Si nos ingresan enter regresamos null.
			if(nombre == "") {
				nombre = null; //rompemos el ciclo
				break;
			} else if (!nombre.matches(Registro.ALFABETO)) { // Si el usuario pone carácteres raros
				System.out.println("El nombre no acepta ese tipo de carácteres.");
				continue;
			}
			break;
		}
		
		//Ciclo para impedir que el usuario ponga carácteres ajenos a lo que pedimos.
		while(!f) {
			System.out.println("Dirección: ");
			direccion = scanner.nextLine();
			
			// Si nos ingresan enter regresamos null.
			if(direccion == "") {
				direccion = null; //rompemos el ciclo
				break;
			} else if (!direccion.matches(Registro.ALFANUMERICOS)) { // Si el usuario pone carácteres raros
				System.out.println("La dirección no acepta ese tipo de carácteres.");
				continue;
			}
			break;
		}
		
		//Ciclo para impedir que el usuario ponga carácteres ajenos a lo que pedimos.
		while(!f) {
			System.out.println("Teléfono: ");
			telefono = scanner.nextLine(); 
			
			// Si nos ingresan enter regresamos null.
			if(telefono == "") {
				telefono = null;
				break; //rompemos el ciclo
				
			} else if (!telefono.matches(Registro.NUMEROS)) { // Si el usuario pone carácteres raros
				System.out.println("El teléfono no acepta ese tipo de carácteres.");
				continue;
			}
			break;
		}
		// Utiliza el scanner para leer los datos que faltan y, si es necesario,
		// conviértelos a los tipos que requiere tu clase Registro.
		// ??? direccion = ..
		// ??? telefono = ...
		
		Registro nuevo = new Registro(nombre, direccion, telefono);
		return nuevo;
	}
    
	/**
	* Método auxiliar para imprimir el menú para el usuario.
	*/
	private void imprimeMenu() {
		System.out.println("Opciones:");
		System.out.println("1) Agregar contacto");
		System.out.println("2) Buscar contacto");
		System.out.println("3) Imprimir lista de contactos");
		System.out.println("4) Salir");
	}
    
	/**
	 * Ejecuta la interfaz hasta que el usuario elija salir.
	 */
	public void corre() {
		System.out.println(" *** Lista de contactos *** ");
		boolean continuar = true;
		while(continuar) {
			imprimeMenu();
			int opcion = leeEntero("Selecciona una opción:");
			switch(opcion) {
			case 1:
				Registro regi = solicitaDatosDeContacto();
				contactos.insertaContacto(regi);
				break;
			case 2:
				System.out.println("Escribe el nombre del contacto que buscas:");
				String pista = scanner.nextLine();
				Registro reg = contactos.consultar(pista);
				if(reg == null) {
					System.out.println("No se encontró ningún registro con nombre " + pista);
				} else {
					System.out.println("Se encontró a:");
					System.out.println(reg.toString());
				}
				break;
			case 3:
				contactos.imprimeContactos();
				break;
			case 4:
				continuar = false;
				break;
			default:
				System.out.println("Esa no es una opción válida del menú.");
			}
		}
	}
    

	/**
	 * Punto de entrada del programa.
	 */
	public static void main(String[] args) {
		ContactosIU interfaz = new ContactosIU();
		interfaz.corre();
	}
}
