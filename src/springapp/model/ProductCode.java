package springapp.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductCode {

	@NotNull
	@Size(min = 1, max = 1)
	@Pattern(regexp="[A-Z]", message="Le code doit débuter par une majuscule")
	String base;
	
	@Min(value=1000, message="Le numéro doit être >= à 1000")
    @Max(value=9999, message="Le numéro doit être <= à 9999")
	int number;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ProductCode() {
		super();
	}

	public ProductCode(String base, int number) {
		super();
		this.base = base;
		this.number = number;
	}

}