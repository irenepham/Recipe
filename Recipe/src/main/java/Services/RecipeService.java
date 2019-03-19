package Services;

import java.util.List;
import java.util.Optional;

import Entities.RecipeEntity;

public interface RecipeService {
	public RecipeEntity createRecipe(RecipeEntity recipe); 
	
	public RecipeEntity updateRecipe(RecipeEntity recipe);
	
	public Optional<RecipeEntity> getRecipeById(String recipeId); 
	
	public boolean existsById(String recipeId);
	
	public void deleteRecipeById(String id);
	
	public List<RecipeEntity> getRecipeByCategory(String category); 
	
	public List<RecipeEntity> getAllRecipes();
	
}
