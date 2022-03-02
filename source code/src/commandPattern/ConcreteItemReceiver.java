package commandPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import driverCode.ConcreteStoreImplementation;
import model.ConcreteItem;
import model.ConcreteStoreModel;
import model.ConcreteItem;

public class ConcreteItemReceiver implements ConcreteReceiver {
	Scanner readCement = new Scanner(System.in);
	private String fileName = "concrete_item.txt";

	@Override
	public void readFile() {
		File concreteFile = new File(fileName);
		try {
			BufferedReader concreteReader = new BufferedReader(new FileReader(concreteFile));
			String concreteContent;
			while ((concreteContent = concreteReader.readLine()) != null) {
				String[] concrete = concreteContent.split("\t");
				ConcreteStoreImplementation.concreteList[ConcreteStoreImplementation.concreteCount++] = new ConcreteItem(concrete[0], concrete[1],
						Double.parseDouble(concrete[2]));
			}
			concreteReader.close();
		} catch (IOException e) {
			System.out.println("File cannot be read");
		}
	}

	@Override
	public void writeFile() {
		String concreteData = "";
		System.out.print("Enter the Name of the Concrete: ");
		concreteData += readCement.nextLine() + "\t";
		System.out.print("Enter the Packing Type: ");
		concreteData += readCement.nextLine() + "\t";
		System.out.print("Enter the Cost: ");
		concreteData += readCement.nextLine() + "\n";
		File concreteFile = new File(this.fileName);
		FileWriter concreteWriter;
		try {
			concreteWriter = new FileWriter(concreteFile, true);
			concreteWriter.write(concreteData);
			concreteWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
