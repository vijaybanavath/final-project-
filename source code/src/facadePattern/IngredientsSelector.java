package facadePattern;

public class IngredientsSelector {

	public ConcreteItemIngredient getConcreteItemIngredient() {
		return new ConcreteItemIngredient();
	}
	
	public CementItemIngredient getCementItemIngredient() {
		return new CementItemIngredient();
	}
}
