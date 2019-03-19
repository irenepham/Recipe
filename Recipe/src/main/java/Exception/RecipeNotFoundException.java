package Exception;
/*
 * Exception for when the requested recipe resource is not found. 
 */
public class RecipeNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 2425186511795179438L;
	

	public RecipeNotFoundException(String message) { 
		super(message); 
	}
	
	public RecipeNotFoundException(String message, Throwable cause) { 
		super(message, cause); 
	}
	
}
