package testCase;

import static org.junit.Assert.*;

import org.junit.Test;

import adapterPattern.CementItemSale;
import adapterPattern.CementItemSaleAdapterImpl;
import adapterPattern.ConcreteStoreSale;
import adapterPattern.ConcreteStoreSaleAdapter;
import commandPattern.ConcreteInvoker;
import commandPattern.ConcreteItemReadFileCommand;
import commandPattern.ConcreteReceiver;
import commandPattern.ConcreteReceiverData;
import facadePattern.ConcreteItemIngredient;
import facadePattern.IngredientsSelector;
import iteratorPattern.CementItemCatelog;
import iteratorPattern.ConcreteItemCatelog;
import iteratorPattern.ConcreteStoreIterator;
import model.CementItem;

public class ConcreteStoreTest {

	@Test
	public void testHasNextItem() {
		ConcreteReceiver concreteReceiver = new ConcreteReceiverData().getConcreteReceiver("concrete");
		ConcreteItemReadFileCommand conReadFileCommand = new ConcreteItemReadFileCommand(concreteReceiver);
		ConcreteInvoker conInvoker = new ConcreteInvoker(conReadFileCommand);
		conInvoker.startCommand();
		ConcreteItemCatelog concItemCatalog = new ConcreteItemCatelog();
		ConcreteStoreIterator iterator = concItemCatalog.getItemIterator();
		boolean actualResult = iterator.hasNextItem();
		assertEquals(actualResult, true);
	}

	@Test
	public void testNextItem() {
		ConcreteReceiver concreteReceiver = new ConcreteReceiverData().getConcreteReceiver("cement");
		ConcreteItemReadFileCommand conReadFileCommand = new ConcreteItemReadFileCommand(concreteReceiver);
		ConcreteInvoker conInvoker = new ConcreteInvoker(conReadFileCommand);
		conInvoker.startCommand();
		CementItemCatelog cementItemCatalog = new CementItemCatelog();
		ConcreteStoreIterator iterator = cementItemCatalog.getItemIterator();
		boolean actualResult;
		if (iterator.nextItem() != null) {
			actualResult = true;
		} else {
			actualResult = false;
		}
		assertEquals(actualResult, true);
	}

	@Test
	public void testGetSalePercentage() {
		ConcreteStoreSale cementItemSale = new CementItemSale();
		ConcreteStoreSaleAdapter cementItemAdapter = new CementItemSaleAdapterImpl(cementItemSale);
		double actualResult = cementItemAdapter.getSalePercentage();
		assertEquals(actualResult, 79.3, 0.0001);
	}
	
	@Test
	public void testGetIngredients() {
		IngredientsSelector ingredientsSelector = new IngredientsSelector();
		ConcreteItemIngredient concObj = ingredientsSelector.getConcreteItemIngredient();
		boolean actualResult=concObj.getIngredients().contains("Concrete");
		assertEquals(actualResult, true);
	}

}
