package com.buses.Buses.Preguntas;

import java.util.ArrayList;

public class pregunta2 {
	
	private String Cadena;
	private ArrayList<String> Caracter;
	private ArrayList<Integer> Cantidad;
	
	/**
	 * contructor de la calse, el cual recibe como parametro de entrada, la cadena a la cual se le va a hacer el conteo
	 * 
	 * @param String de la cadena a la cual se le va a realizar el conteo de los caracteres
	 * */
	private pregunta2(String cadena) {
		this.Cadena = cadena.toLowerCase();
		this.Caracter = new ArrayList<String>();
		this.Cantidad = new ArrayList<Integer>();
	}
	
	
	/**
	 * Funcion encargada de realizar el conteo y la creaci�n de los arreglos para la informaci�n del conteo
	 * */
	private void contar() {
		for (int i = 0; i < this.Cadena.length(); i++) {
			if(this.Caracter.contains(""+this.Cadena.charAt(i))){
				int posicion =  this.Caracter.indexOf(""+this.Cadena.charAt(i));
				int cantidad = this.Cantidad.get(this.Caracter.indexOf(""+this.Cadena.charAt(i))) + 1 ;
				this.Cantidad.set(posicion, cantidad);
			}else {
				this.Caracter.add(""+this.Cadena.charAt(i));
				this.Cantidad.add(1);
			}

		}
	}
	
	/**
	 * funci�n que realiza la transformaci�n de los arreglos al formato de salida que se requiere
	 * */
	private void mostrarResultados() {
		System.out.print("{");
		for (int i = 0; i < this.Caracter.size(); i++) {
			if(this.Cantidad.get(i) >= 2 ) {
				System.out.print ("'"+this.Caracter.get(i) + "': " + this.Cantidad.get(i)+" " );
			}
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		
		//Prueba con los ejemplo en el documento
		String[] cadena = {"abcde", 	"aabbcde" , "aabBcde" , "indivisibility" , "Indivisibilities" , "aA11" , "ABBA" };
		pregunta2 pregunta ;
		for (int i = 0; i < cadena.length; i++) {
			pregunta =  new pregunta2(cadena[i]);
			pregunta.contar();
			pregunta.mostrarResultados();
		}


	}

}
