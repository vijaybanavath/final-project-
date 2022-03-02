package facadePattern;

public class CementItemIngredient implements ConcreteStoreIngredient {

	@Override
	public String getIngredients() {
		String ingredients="";
		ingredients+="\nIngredients in Cement\n";
		ingredients+="---------------------\n";
		ingredients+="Lime\n";
		ingredients+="Silica\n";
		ingredients+="Alumina\n";
		ingredients+="Iron\n";
		ingredients+="Magnesia\n";
		ingredients+="Calcium sulfate\n";
		ingredients+="Sulfur";
		return ingredients;
	}

}
