package pt.ulht.es.cookbook.domain;

import java.util.Comparator;

import org.joda.time.DateTime;

public class RecipeVersion extends RecipeVersion_Base implements
		Comparable<RecipeVersion> {

	public RecipeVersion(String titulo, String problema, String solucao,
			String autor, String classificacao) {
		setTitulo(titulo);
		setProblema(problema);
		setSolucao(solucao);
		setAutor(autor);
		setClassificacao(classificacao);
		setData(new DateTime());
	}

	public int compareTo(RecipeVersion o) {
		return -getData().compareTo(o.getData());
	}

	public void delete() {
		setRecipe(null);
		super.deleteDomainObject();
	}

}
