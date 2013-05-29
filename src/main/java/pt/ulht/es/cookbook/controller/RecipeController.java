package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Recipe;

@Controller
public class RecipeController {

	@RequestMapping(method = RequestMethod.GET, value = "/recipes")
	public String listRecipes(Model model) {
		Set<Recipe> recipes = CookbookManager.getInstance().getRecipeSet();
		List<Recipe> recipesSorted = new ArrayList<Recipe>(recipes);
		Collections.sort(recipesSorted, new Recipe.TituloComparator());

		model.addAttribute("recipes", recipesSorted);

		return "listRecipes";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recipes/create")
	public String showRecipeCreationForm() {
		return "createRecipe";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/recipes")
	public String createRecipe(@RequestParam Map<String, String> params) {
		String titulo = params.get("titulo");
		String problema = params.get("problema");
		String solucao = params.get("solucao");
		String autor = params.get("autor");

		String tmp = params.get("classificacao");
		String classificacao = new String(tmp.trim());

		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateTimeInstance();
		String data = df.format(date);

		Recipe recipe = new Recipe(titulo, problema, solucao, autor,
				classificacao, data);

		return "redirect:/recipes/" + recipe.getExternalId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recipes/{id}")
	public String showRecipe(Model model, @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		String[] tmp = recipe.getClassificacao().split(",");
		if (recipe != null) {
			model.addAttribute("recipe", recipe);
			model.addAttribute("tmp", tmp);
			return "detailedRecipe";
		} else {
			return "recipeNotFound";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recipes/{id}/delete")
	public String deleteRecipe(@PathVariable("id") String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		recipe.delete();
		CookbookManager.getInstance().removeRecipe(recipe);
		return "redirect:/recipes/";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/recipes/search")
	public String searchRecipes(Model model, @RequestParam String param) {
		String procurar = new String(param);
		
		Set<Recipe> recipes = CookbookManager.getInstance().getRecipeSet();		
		List<Recipe> recipesSorted = new ArrayList<Recipe>(recipes);
		Collections.sort(recipesSorted, new Recipe.TituloComparator());
		
		List<Recipe> recipesSearched = new ArrayList<Recipe>();
		
		for(int i = 0; i < recipesSorted.size(); i++)
		{
			if(recipesSorted.get(i).getTitulo().contains(procurar))
				recipesSearched.add(recipesSorted.get(i));
			else if(recipesSorted.get(i).getProblema().contains(procurar))
				recipesSearched.add(recipesSorted.get(i));
			else if(recipesSorted.get(i).getSolucao().contains(procurar))
				recipesSearched.add(recipesSorted.get(i));
			else if(recipesSorted.get(i).getAutor().contains(procurar))
				recipesSearched.add(recipesSorted.get(i));
			else if(recipesSorted.get(i).getClassificacao().contains(procurar))
				recipesSearched.add(recipesSorted.get(i));
		}

		model.addAttribute("recipes", recipesSearched);

		return "listRecipes";
	}

	/*
	 * List<String> values = new ArrayList<String>(); values.add("Ola"+id);
	 * values.add("Mundo"+id); model.addAttribute("items", values);
	 * if(id.equals("42")) { return "detailedRecipe"; } else { return
	 * "recipeNotFound"; }
	 */
}