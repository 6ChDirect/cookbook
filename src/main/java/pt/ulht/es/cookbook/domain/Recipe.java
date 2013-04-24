package pt.ulht.es.cookbook.domain;

import java.util.Comparator;

public class Recipe {
	
	public static class TituloComparator implements Comparator<Recipe> {

		public int compare(Recipe o1, Recipe o2) {
			return o1.titulo.compareTo(o2.titulo);
		}

	}

	private String id;
	
	private String titulo;
	private String problema;
	private String solucao;
	private String autor;
	private String data;

	public Recipe(String titulo, String problema, String solucao, String autor, String data) {
		this.titulo = titulo;
		this.problema = problema;
		this.solucao = solucao;
		this.autor = autor;
		this.data = data;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getData() {
		return data;
	}
	
	public String getProblema() {
		return problema;
	}
	
	public String getSolucao() {
		return solucao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
