package icc.vigenere;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Clase que implementa el algoritmo de Vigeniere.
 */
public class Vigenere {

	private String path;
	private String secret;
    /**
     * Constructor.
     * @param path Ruta del archivo donde se encuentra
     *        el texto a descifrar.
     * @param secret La palabra clave para descifrar el
     *        código.
     */
    public Vigenere(String path, String secret) {
    	this.path = path;
    	this.secret = secret;
    }

    /**
     * Método para leer el texto de un archivo.
     * @return text, el texto de un archivo.
     */
    private String readFile() {
        String text = "";
        try{
            BufferedReader in = new BufferedReader(new FileReader(this.path));
            String line;
            
            // Ciclo para escribir las lineas de texto mientras no sean vacías.
            while ((line = in.readLine()) != null){
             text += line;   
            }
            in.close(); //Cerramos el BufferedReader            
        } catch(FileNotFoundException e){ //Cuando no se encuentra el archivo
            System.err.println("No se encontó el archivo de texto, ¿olvidaste crearlo?");
        } catch(IOException ioe){ // Cuando hay un error al leerlo o ejecutarlo
            System.err.println("Error al leer el contenido del .txt");
        }
        return text;
    }

    /**
     * Método para escribir en un archivo,
     * @param text, texto que vamos a escribir.
     */
    private void writeFile(String text) {
    	String nombreArchivo = path;
    	
    	//Ciclos para determinar la nueva ruta del archivo 
    	if(path.contains("encoded")) { // Ciclo que decodifica 
    		nombreArchivo = path.replaceAll("encoded", "decoded");
    	} else if(path.contains("decoded")) { // Ciclo que codifica 
    		nombreArchivo = path.replaceAll("decoded", "encoded");
    	}
        try(PrintStream fout = new PrintStream(nombreArchivo)){
            fout.println(text); // Escribimos el texto
        } catch (FileNotFoundException fnfe){ //Cuando no se encuentra el archivo
            System.err.println("No se encontró el archivo "+nombreArchivo+" y no pudo ser creado");
        } catch( SecurityException se){ // Cuando hay un error al leerlo o ejecutarlo
            System.err.println("No se tiene permiso de escribir en el archivo");
        }
    }

    /**
     * Método para codificar el mensaje.
     */
    public void encode() {
        String text = (this.readFile()).toUpperCase(); //Lo pasamos a mayúsculas para mejor manejo.
        String encodedText = "";
        String secret1 = secret.toUpperCase(); //Lo pasamos a mayúsculas para mejor manejo.

        /* Ciclo para codificar el mensaje caracter x caracter */
        for(int i=0,j=0;i<text.length();i++){
            char c = text.charAt(i);
            
            //Condicional para caracteres que nos letras.
            if(c<'A'||c>'Z') {
            	encodedText += c;
            	continue;
            }
            
            //Caracteres que son letras.
            encodedText += (char)((c+secret1.charAt(j)-2*'A')%26 +'A');
            j = ++j % secret.length();            
        }        
        this.writeFile(encodedText);
    }

    /**
     * Método para decodificar el mensaje.
     */
    public void decode() {
        String text = (this.readFile()).toUpperCase();
        String decodedText = "";
        String secret1 = secret.toUpperCase(); 

        /* Ciclo para decodificar el mensaje caracter x caracter */
        for(int i=0, j=0; i<text.length();i++){
            char c = text.charAt(i);
            
            //Condicional para caracteres que nos letras.
            if(c<'A'||c>'Z') {
            	decodedText += c;
            	continue;            
            }

            //Caracteres que son letras.
            decodedText += (char)((c-secret1.charAt(j)+26)%26+'A');
            j = ++j % secret.length();        
            
        }
        this.writeFile(decodedText);
    }
}
