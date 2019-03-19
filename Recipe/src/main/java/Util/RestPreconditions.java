package Util;
/*
 * Util class to perform basic verification on input values. 
 */
public class RestPreconditions {
	public static <T> T checkNotNull(T value, String valueName) { 
		if (value == null) { 
			throw new IllegalArgumentException("The given value for " + valueName + " cannot be null");
		}
		return value; 
	}
}