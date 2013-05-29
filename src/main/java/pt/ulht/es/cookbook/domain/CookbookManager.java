package pt.ulht.es.cookbook.domain;

import pt.ist.fenixframework.FenixFramework;

public class CookbookManager extends CookbookManager_Base {

	public static CookbookManager getInstance() {
		return FenixFramework.getRoot();
	}
    
	public void delete() {
		for (Recipe recipe : getRecipeSet()) {
			recipe.delete();
		}
	}
}
