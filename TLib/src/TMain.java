import java.io.FileNotFoundException;
import java.io.PrintWriter;

import txtFileManager.TFileManeger;

public class TMain {

	
	public static void main(String[] args) {
	
		//work eith files
		TFileManeger fManager = new TFileManeger("dsds.txt");
		fManager.AppendRow("Row1: salam");
		fManager.AppendRow("Row2:salam");
		fManager.Clear();
		fManager.AppendRow("Row3:salam");
		fManager.AppendRow("Row4:sal56156am");
		fManager.AppendRow(fManager.getRowCount() + "");
		
		String[] fileDate = fManager.getArrayFromFile();
		fManager.deleteRow(1);
		 fileDate = fManager.getArrayFromFile();
		 
		 fManager.insertRow(1, "new line in index 1");
		 fileDate = fManager.getArrayFromFile();
		for (String string : fileDate) {
			System.out.println(string);
		}
	
	}
}
