package Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import Entities.RecipeEntity;
import Repositories.RecipeRepository;

public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeRepository recipeRepository; 
	
	public RecipeEntity createRecipe(RecipeEntity recipe) { 
		recipe.setDateAdded(LocalDateTime.now());  
		recipe.setDateModified(LocalDateTime.now()); 
		recipe.setObjectId(UUID.randomUUID().toString());
		return this.recipeRepository.save(recipe); 
	}
	
	public RecipeEntity updateRecipe(RecipeEntity recipe) { 
		recipe.setDateModified(LocalDateTime.now());
		return this.recipeRepository.save(recipe); 
	}
	
	public Optional<RecipeEntity> getRecipeById(String recipeId) { 
		Optional<RecipeEntity> optRecipe = this.recipeRepository.findById(recipeId); 
	}
	
	public boolean existsById(String recipeId) { 
		return this.recipeRepository.existsById(recipeId);
	}
	
	
	public void deleteRecipeById(String id) { 
		this.recipeRepository.deleteById(id); 
	}
	
	public List<RecipeEntity> getRecipeByCategory(String category) { 
		return this.recipeRepository.findByCategoryIgnoringCase; 
	}
	
	public List<RecipeEntity> getAllRecipes() { 
		return this.recipeRepository.findAll(); 
	}
}
