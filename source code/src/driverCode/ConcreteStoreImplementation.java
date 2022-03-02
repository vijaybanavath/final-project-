package driverCode;

import java.util.Scanner;

import adapterPattern.CementItemSale;
import adapterPattern.CementItemSaleAdapterImpl;
import adapterPattern.ConcreteItemSale;
import adapterPattern.ConcreteItemSaleAdapterImpl;
import adapterPattern.ConcreteStoreSale;
import adapterPattern.ConcreteStoreSaleAdapter;
import commandPattern.CementItemWriteFileCommand;
import commandPattern.ConcreteInvoker;
import commandPattern.ConcreteItemReadFileCommand;
import commandPattern.ConcreteItemWriteFileCommand;
import commandPattern.ConcreteReceiver;
import commandPattern.ConcreteReceiverData;
import facadePattern.CementItemIngredient;
import facadePattern.ConcreteItemIngredient;
import facadePattern.ConcreteStoreIngredient;
import facadePattern.IngredientsSelector;
import iteratorPattern.CementItemCatelog;
import iteratorPattern.ConcreteItemCatelog;
import iteratorPattern.ConcreteStoreIterator;
import model.CementItem;
import model.ConcreteItem;

public class ConcreteStoreImplementation {
	static Scanner readInput = new Scanner(System.in);
	public static ConcreteItem[] concreteList = new ConcreteItem[10];
	public static int concreteCount = 0;
	public static CementItem[] cementList = new CementItem[10];
	public static int cementCount = 0;

	public static void main(String[] args) {
		while (true) {
			System.out.println("\nConcrete Store Implementation");
			System.out.println("=============================\n");
			System.out.println("1. Read Concrete data from file");
			System.out.println("2. Read Cement data from file");
			System.out.println("3. Write Concrete data to file");
			System.out.println("4. Write Cement data to file");
			System.out.println("5. View Concrete sale percentage");
			System.out.println("6. View Cement sale percentage");
			System.out.println("7. View Mixing ingredients");
			System.out.println("9. Exit");
			System.out.print("Enter your option: ");
			String option = readInput.nextLine();
			switch (option) {
			case "1":
				System.out.println("\nConcrete Item details");
				System.out.println("=====================");
				ConcreteReceiver concreteReceiver = new ConcreteReceiverData().getConcreteReceiver("concrete");
				ConcreteItemReadFileCommand conReadFileCommand = new ConcreteItemReadFileCommand(concreteReceiver);
				ConcreteInvoker conInvoker = new ConcreteInvoker(conReadFileCommand);
				conInvoker.startCommand();
				ConcreteItemCatelog concItemCatalog = new ConcreteItemCatelog();
				ConcreteStoreIterator iterator = concItemCatalog.getItemIterator();
				while (iterator.hasNextItem()) {
					ConcreteItem concItem = (ConcreteItem) iterator.nextItem();

					System.out.println("Name: " + concItem.getName());
					System.out.println("Packing Type: " + concItem.getPackingType());
					System.out.println("Cost: " + concItem.getCost());
					System.out.println();
				}
				break;
			case "2":
				System.out.println("\nCement Item details");
				System.out.println("===================");
				concreteReceiver = new ConcreteReceiverData().getConcreteReceiver("cement");
				conReadFileCommand = new ConcreteItemReadFileCommand(concreteReceiver);
				conInvoker = new ConcreteInvoker(conReadFileCommand);
				conInvoker.startCommand();
				CementItemCatelog cementItemCatalog = new CementItemCatelog();
				ConcreteStoreIterator iterator2 = cementItemCatalog.getItemIterator();
				while (iterator2.hasNextItem()) {
					CementItem cementItem = (CementItem) iterator2.nextItem();

					System.out.println("Name: " + cementItem.getName());
					System.out.println("Packing Type: " + cementItem.getPackingType());
					System.out.println("Cost: " + cementItem.getCost());
					System.out.println();
				}
				break;
			case "3":
				concreteReceiver = new ConcreteReceiverData().getConcreteReceiver("concrete");
				ConcreteItemWriteFileCommand conWriteFileCommand = new ConcreteItemWriteFileCommand(concreteReceiver);
				conInvoker = new ConcreteInvoker(conWriteFileCommand);
				conInvoker.startCommand();
				break;
			case "4":
				concreteReceiver = new ConcreteReceiverData().getConcreteReceiver("cement");
				CementItemWriteFileCommand cementWriteFileCommand = new CementItemWriteFileCommand(concreteReceiver);
				conInvoker = new ConcreteInvoker(cementWriteFileCommand);
				conInvoker.startCommand();
				break;
			case "5":
				ConcreteStoreSale concreteItemSale = new ConcreteItemSale();
				ConcreteStoreSaleAdapter concreteItemAdapter = new ConcreteItemSaleAdapterImpl(concreteItemSale);
				System.out.println(
						"The Concrete Item Sale Percentage is: " + concreteItemAdapter.getSalePercentage() + "%");
				break;
			case "6":
				ConcreteStoreSale cementItemSale = new CementItemSale();
				ConcreteStoreSaleAdapter cementItemAdapter = new CementItemSaleAdapterImpl(cementItemSale);
				System.out
						.println("The Cement Item Sale Percentage is: " + cementItemAdapter.getSalePercentage() + "%");
				break;
			case "7":
				process_ingredients();
				break;
			case "9":
				System.out.println("Program ends");
				System.exit(0);
			default:
				System.out.println("Enter valid option");
			}
		}

	}

	public static void process_ingredients() {
		while (true) {
			System.out.println("\nIngredients Menu");
			System.out.println("================");
			System.out.println("1. View Concrete ingredients");
			System.out.println("2. View Cement ingredients");
			System.out.println("3. View Main menu");
			System.out.print("Enter your option: ");
			String option = readInput.nextLine();

			if (option.equals("3")) {
				break;
			}

			switch (option) {
			case "1":
				IngredientsSelector ingredientsSelector = new IngredientsSelector();
				ConcreteItemIngredient concObj = ingredientsSelector.getConcreteItemIngredient();
				System.out.println(concObj.getIngredients());
				break;
			case "2":
				ingredientsSelector = new IngredientsSelector();
				CementItemIngredient cementObj = ingredientsSelector.getCementItemIngredient();
				System.out.println(cementObj.getIngredients());
				break;
			default:
				System.out.println("Enter valid option");
			}
		}
	}

}
