package Preguntas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;




public class pregunta1 {
	
	private List<String> lista;
	private List<String> listaOriginal;
	private Predicate<String> Regex;
	
	private pregunta1(List<String> lista){
		this.lista = lista; 
		this.listaOriginal = lista;
	}
	
    /**
    * Este m�todo se usa para agregar par�metros a la lista, O(N)
    * @param cadena es una cadena de caracteres que es agregada a la lista 
    */
	private void agregar(String cadena) {
		List<String> newList = new ArrayList<>(Arrays.asList(cadena));
		this.listaOriginal.parallelStream()
	       .collect(Collectors.toCollection(() -> newList));
		this.lista.parallelStream()
	       .collect(Collectors.toCollection(() -> newList));
	}
	
    /**
    * Este m�todo se usa para ordenar la lista, O(Nlog(N))
    */
	private void ordenar( ) {
		this.lista = this.lista.stream().sorted().collect(Collectors.<String>toList());
	}

    /**
    * Este m�todo se usa para Filtrar, O(N)
    * @param cadena es una cadena de caracteres la cual corresponde con una expresi�n regular para filtrar
    */
	private void filtrar(String regex) {
		this.Regex = Pattern.compile(regex).asPredicate();
		this.lista = (List<String>) lista.stream().filter(this.Regex).collect(Collectors.<String>toList());
	}
	
    /**
    * Este m�todo se usa para mostrar la lista, O(N)
    */
	private void mostrar() {
		//System.out.println(this.lista);
		this.lista.forEach(System.out::println);
	}
	
    /**
    * Este m�todo se usa para volver a la lista original, O(1)
    */
	private void volverOriginal() {
		this.lista = this.listaOriginal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1", "hola@hotmail.com", "hector@gmail.com" , "fabio@dominio.com");

		
		pregunta1 pregunta = new pregunta1(myList);
		pregunta.ordenar();
		pregunta.filtrar("^a");
		System.out.println("Muestra los que empiezan por a");
		pregunta.mostrar();
		
		pregunta.volverOriginal();
		System.out.println("Muestra los que tienen un @ en la mitad");
		pregunta.filtrar("^(.+)@(.+)$");
		pregunta.mostrar();
		
	}

}
