package pt.ulht.es.cookbook.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Recipe extends Recipe_Base {

	public Recipe(String titulo, String problema, String solucao, String autor,
			String classificacao) {
		RecipeVersion firstVersion = new RecipeVersion(titulo, problema,
				solucao, autor, classificacao);
		addVersion(firstVersion);
		setCookbookManager(CookbookManager.getInstance());
	}

	public static class TituloComparator implements Comparator<Recipe> {

		public int compare(Recipe o1, Recipe o2) {
			// return o1.titulo.compareTo(o2.titulo);
			return o1.getLastVersion().getTitulo()
					.compareTo(o2.getLastVersion().getTitulo());
		}

	}

	public RecipeVersion getLastVersion() {
		List<RecipeVersion> versions = new ArrayList<RecipeVersion>(
				getVersionSet());
		Collections.sort(versions);
		return versions.get(0);
	}

	public void delete() {
		for (RecipeVersion recipe : getVersionSet()) {
			recipe.delete();
		}
		setCookbookManager(null);
		super.deleteDomainObject();
	}

	public void edit(String titulo, String problema, String solucao,
			String autor, String classificacao) {
		RecipeVersion newVersion = new RecipeVersion(titulo, problema, solucao,
				autor, classificacao);
		addVersion(newVersion);

	}

}
