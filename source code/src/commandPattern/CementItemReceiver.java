package commandPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import driverCode.ConcreteStoreImplementation;
import model.CementItem;
import model.ConcreteItem;
import model.ConcreteStoreModel;

public class CementItemReceiver implements ConcreteReceiver {
	Scanner readCement = new Scanner(System.in);
	private String fileName = "cement_item.txt";

	@Override
	public void readFile() {
		File cementFile = new File(fileName);
		try {
			BufferedReader cementReader = new BufferedReader(new FileReader(cementFile));
			String cementContent;
			while ((cementContent = cementReader.readLine()) != null) {
				String[] cement = cementContent.split("\t");
				ConcreteStoreImplementation.cementList[ConcreteStoreImplementation.cementCount++] = new CementItem(cement[0], cement[1],
						Double.parseDouble(cement[2]));
			}
			cementReader.close();
		} catch (IOException e) {
			System.out.println("File cannot be read");
		}
	}

	@Override
	public void writeFile() {
		String cementData = "";
		System.out.print("Enter the Name of the Cement: ");
		cementData += readCement.nextLine() + "\t";
		System.out.print("Enter the Packing Type: ");
		cementData += readCement.nextLine() + "\t";
		System.out.print("Enter the Cost: ");
		cementData += readCement.nextLine() + "\n";

		File cementFile = new File(this.fileName);
		FileWriter cementWriter;
		try {
			cementWriter = new FileWriter(cementFile, true);
			cementWriter.write(cementData);
			cementWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
