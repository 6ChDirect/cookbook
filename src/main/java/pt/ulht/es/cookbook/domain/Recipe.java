package pt.ulht.es.cookbook.domain;

import java.util.Comparator;

public class Recipe extends Recipe_Base {
    
	public static class TituloComparator implements Comparator<Recipe> {

		public int compare(Recipe o1, Recipe o2) {
			//return o1.titulo.compareTo(o2.titulo);
			return o1.getTitulo().compareTo(o2.getTitulo());
		}

	}
	
	public Recipe(String titulo, String problema, String solucao, String autor, String classificacao, String data) {
        setTitulo(titulo);
        setProblema(problema);
        setSolucao(solucao);
        setAutor(autor);
        setClassificacao(classificacao);
        setData(data);
        
        setCookbookManager(CookbookManager.getInstance());
    }
	
	public void delete() {
		setCookbookManager(null);
		super.deleteDomainObject();
	}
    
}
