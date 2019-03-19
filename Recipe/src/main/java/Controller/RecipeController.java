package Controller;

import java.util.List;
import java.util.Optional;

import Entities.RecipeEntity;
import Exception.RecipeNotFoundException;
import Services.RecipeService;
import Services.RecipeServiceImpl;
import Util.RestPreconditions;

/*
 * REST API for all requests relating to creating, updating, and deleting recipe data. 
 * 
 * Functionality to be implemented in the future include: updating certain fields of a recipe, 
 * filtering by different attributes, 
 */
@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired 
	private RecipeService recipeService; 
	
	@ExceptionHandler(RecipeConflictException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse conflictError (RecipeConflictException conflictException) {
		conflictException.printStackTrace(); 	
		return new ErrorResponse(conflictException.getMessage(), HttpStatus.CONFLICT.value());
	}
	
	@ExceptionHandler(RecipeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorReponse notFoundError (RecipeNotFoundException notFoundEx) {
		notFoundEx.printStackTrace();
		return new ErrorResponse(notFoundEx.getMessage(), HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Builds a ResponseEntity that contains the added RecipeEntity
	 * 
	 * @param newRecipe the RecipeEndtity to be added 
	 * @return a ResponseEntity representing the state of RecipeEntity retrieval
	 */
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RecipeEntity> addRecipe (@RequestBody RecipeEntity newRecipe){ 
		RestPreconditions.checkNotNull(newRecipe, "new recipe");
		RecipeEntity createdRecipe = this.recipeService.createRecipe(newRecipe);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe); 
	}
	
	/**
	 * Updates the RecipeEntity with the given id based on the given RecipeEntity
	 * 
	 * @param id the Id of the RecipeEntity to be updated
	 * @param updatedRecipe the RecipeEntity containing updated information
	 * @return a ResponseEntity representing the state of the update
	 */
	@PutMapping(value = "/{recipeId}") 
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<RecipeEntity> updateRecipe (@PathVariable("recipeId") String id, @RequestBody RecipeEntity updatedRecipe) { //what if the ids dont match
		RestPreconditions.checkNotNull(updatedRecipe, "updated recipe"); 
		this.recipeService.getRecipeById(id).orElseThrow(() -> new RecipeNotFoundException(String.format("Cannot update recipe with id %s since it does not exist", id)); 
		if(!id.equals(updatedRecipe.getObjectId())) { 
			throw new RecipeConflictException("The updated recipe has id %s and this does not match that of the given recipe: %s", id, updatedRecipe.getObjectId());
		}
		return ResponseEntity.ok().body(this.recipeService.updateRecipe(updatedRecipe)); 
	}

	/**
	 * Deletes the RecipeEntity with the given id. 
	 * 
	 * @param id the ID of the RecipeEntity to remove
	 * @return a ResponseEntity representinig the state of the deletion
	 */
	@DeleteMapping(value = "/{recipeId}") 
	public ResponseEntity deleteRecipeById (@PathVariable("recipeId") String id) { 
		this.recipeService.getRecipeById(id).orElseThrow(() -> new RecipeNotFoundException(String.format("Cannot delete recipe with id %s since it does not exist", id))); 
		this.recipeService.deleteRecipeById(id);
		return ResponseEntity.noContent(); 
	}
	
	/**
	 * Retrieves all of the RecipeEntities stored. 
	 * @return a ResponseEntity containing the status of the retrieval and all RecipeEntities
	 */
	@GetMapping 
	public ResponseEntity<List<RecipeEntity>> getAllRecipes() { 
		return ResponseEntity.ok().body(this.recipeService.getAllRecipes()); 
	}
	
	/**
	 * Retrieves the RecipeEntity with the given ID. 
	 * 
	 * @param id the ID of the RecipeEntity to retrieve
	 * @return a ResponseEntity containing the status of the retrieval and the resulting RecipeEntity
	 */
	@GetMapping(value="/{recipeId}") 
	public ResponseEntity<RecipeEntity> getById(@PathVariable ("recipeId") String id) { 
		RecipeEntity recipe = this.recipeService.getRecipeById(id).orElseThrowd(() -> new RecipeNotFoundException(String.format("Recipe with the id: %s does not exist", id))); 
		return ResponseEntity.ok().body(recipe); 
	}
	
	/**
	 * Retrieves all RecipeEntity whose category matches the given category. 
	 * @param category the category which the desired RecipeEntities must belong to
	 * @return a ResponseEntity containing the status of the retrieval and a list of RecipeEntities who fall in the given category 
	 */
	@GetMapping(value="/filter")
	public ResponseEntity<List<RecipeEntity>> getRecipesInCategory (@RequestParam String category) { 
		RestPreconditions.checkNotNull(category, "category"); 
		List<RecipeEntity> filteredResults = this.recipeService.getRecipeByCategory(category); 
		return ResponseEntity.ok().body(filteredResults); 
	}
}
