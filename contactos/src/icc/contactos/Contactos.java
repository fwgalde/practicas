package icc.contactos;

import icc.util.*;

/**
 * Metodos para una estructura que almacene y permita buscar datos de contactos
 * en objetos tipo <code>Registro</code>.
 * @author blackzafiro
 */
public class Contactos implements IContactos {		
	
	/***
	 * Inserta el registro a la estructura de datos.
	 * @param reg registro con los datos del contacto.
	 */
	public void insertaContacto(Registro reg) {		
		IComparable contacto = reg;
		
		CONTACTOS.inserta(contacto);
	}
	
	/**
	 * Permite buscar los datos de un contacto.
	 * @param nombre el nombre del contacto que se busca o alguna parte de el.
	 * @return referencia al registro con los datos del primer contacto cuyo
	 *         nombre contenga la cadena especificada en el parámetro
	 *         <code>nombre</code>.
	 */
	public Registro consultar(String nombre) {
		return CONTACTOS.encuentra(nombre);
	}
	/**
	 * Imprime los contactos dentro de la lista contactos.
	 */
	public void imprimeContactos() {
		System.out.println(CONTACTOS.toString());
	}
}
