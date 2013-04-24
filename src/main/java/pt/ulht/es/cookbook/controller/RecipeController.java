package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Recipe;

@Controller
public class RecipeController {
  
    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {

    	List<Recipe> recipes = new ArrayList<Recipe>(CookbookManager.getRecipes());
    	Collections.sort(recipes, new Recipe.TituloComparator());
    	model.addAttribute("recipes", recipes);
    	return "listRecipes";
    	
        /*List<String> values = new ArrayList<String>();
        values.add("Ola");
        values.add("Mundo");        
        model.addAttribute("items", values);
        
        return "listRecipes";*/
    }
    
    @RequestMapping("/recipes/create")
    public String showRecipeCreationForm(){
    	return "CreateRecipe";
    }
    
     @RequestMapping(method=RequestMethod.POST, value="/recipes") 
    	public String createRecipe(@RequestParam Map<String,String> params){
    		String titulo = params.get("titulo");
    		String problema = params.get("problema");
    		String solucao = params.get("solucao");
    		
    		Recipe recipe = new Recipe(titulo, problema, solucao);
    		CookbookManager.saveRecipe(recipe);
    		
    		return "redirect:/recipes/"+recipe.getId();
    }
    
    
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {

    	Recipe recipe = CookbookManager.getRecipe(id);
    	if(recipe != null) {
    		model.addAttribute("recipe", recipe);
    		return "detailedRecipe";
    	} else {
    		return "recipeNotFound";
    	}
    	/*    	
    	List<String> values = new ArrayList<String>();
        values.add("Ola"+id);
        values.add("Mundo"+id);        
        model.addAttribute("items", values);
        if(id.equals("42")) {
        	return "detailedRecipe";
		} else {
			return "recipeNotFound";
		}*/
  
    }
    
   
    	
    
    
}