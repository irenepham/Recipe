package Controller;

import java.util.List;

import Entities.RecipeEntity;

public class RecipeResponse {
	private String message; 
	private Boolean success; 
	private RecipeEntity recipe; 
	private List<RecipeEntity> recipes; 
	
	public String getMessage() {
		return message;
	}
	public RecipeResponse withMessage(String message) {
		this.message = message;
		return this;  
	}
	public Boolean getSuccess() {
		return success;
	}
	public RecipeResponse withSuccess(Boolean success) {
		this.success = success;
		return this; 
	}
	public RecipeEntity getRecipe() {
		return recipe;
	}
	public RecipeResponse withRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
		return this; 
	}
	public List<RecipeEntity> getRecipes() {
		return recipes;
	}
	public RecipeResponse withRecipes(List<RecipeEntity> recipes) {
		this.recipes = recipes;
		return this;
	}
}
