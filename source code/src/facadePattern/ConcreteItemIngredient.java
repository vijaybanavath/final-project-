package facadePattern;

public class ConcreteItemIngredient implements ConcreteStoreIngredient {

	@Override
	public String getIngredients() {
		String ingredients="";
		ingredients+="\nIngredients in Concrete\n";
		ingredients+="-----------------------\n";
		ingredients+="Cement\n";
		ingredients+="Air\n";
		ingredients+="Water\n";
		ingredients+="Sand\n";
		ingredients+="Gravel\n";
		return ingredients;
	}

}
