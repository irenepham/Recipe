package Entities;

import java.time.LocalDateTime;

/*
 * Object representation of the table storing recipes. 
 */
@Entity
@Table(name="RECIPE")
public class RecipeEntity {
	
	private String objectId; 
	private String name; 
	private String ingredients; //comma separated value of ingredients (not the best), also what about amount? 
	private Integer servingSize; 
	private String category; 
	private String notes; 
	private LocalDateTime dateAdded;  
	private LocalDateTime dateModified; 
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name="recipe_id", unique=true, nullable=false)
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	public String getObjectId() {
		return this.objectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Integer getServingSize() {
		return servingSize;
	}

	public void setServingSize(Integer servingSize) {
		this.servingSize = servingSize;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	public LocalDateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}

	
	
	
}
