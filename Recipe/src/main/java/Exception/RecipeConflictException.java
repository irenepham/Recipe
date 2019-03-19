package Exception;

/*
 * An exception that occurs when operations that invalidate recipe data are attempted. 
 */
public class RecipeConflictException extends RuntimeException {

	private static final long serialVersionUID = -1633451137139658056L;
	
	public RecipeConflictException(String message, Throwable cause) { 
		super(message, cause); 
	}
	
	public RecipeConflictException(String message) { 
		super(message); 
	}
}
