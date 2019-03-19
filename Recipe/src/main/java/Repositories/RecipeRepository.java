package Repositories;

import java.util.List;

import Entities.RecipeEntity;
import Services.CrudRepository;
import Services.RecipeModel;

public class RecipeRepository extends CrudRepository<RecipeModel, String>  {
	
	public List<RecipeEntity> findByCategoryIgnoringCase(String category); 
	
	public List<RecipeEntity> findByUserId(String userId); 
}
