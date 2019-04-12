package txtFileManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TFileManeger {
	private String fileName;

	public TFileManeger(String fileName) {
		super();
		this.fileName = "K:\\Java WorkSpace\\" + fileName;
		this.CreateFile();
	}

	///////////////////////////////////////////////////////////////// setter and
	///////////////////////////////////////////////////////////////// getter of
	///////////////////////////////////////////////////////////////// fileName
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	////////////////////////////////////////////////////////////////////////////// CreateFile
	private void CreateFile() {
		File f1 = new File(this.getFileName());
		if (!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	////////////////////////////////////////////////////////////////////////// AppendRow
	public void AppendRow(String newRow) {
		String s = getFromFile();
		if (s == "")
			s = newRow;
		else
			s += "\r\n" + newRow;
		setStringToFile(s);
	}

	//////////////////////////////////////////////////////////////////////// SetStringToFile

	private void setStringToFile(String s) {

		try {
			PrintWriter out = new PrintWriter(this.fileName);
			out.print(s);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////////////// GetFromFile

	private String getFromFile() {
		String output = "";
		File file = new File(this.fileName);
		try {
			// Create a new Scanner object which will read the data
			// from the file passed in. To check if there are more
			// line to read from it we check by calling the
			// scanner.hasNextLine() method. We then read line one
			// by one till all lines is read.
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				if (output == "") {
					output += input.nextLine();

				} else
					output += "\r\n" + input.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return output;
	}

	////////////////////////////////////////////////////////////////////////// clear
	////////////////////////////////////////////////////////////////////////// file
	public void Clear() {
		setStringToFile("");
	}

	//////////////////////////////////////////////////////////////////// getRowCount
	public int getRowCount() {
		int rowCount = 0;
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return rowCount;
		}
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			rowCount++;
		}
		sc.close();
		return rowCount;
	}

	////////////////////////////////////////////////////////////// Delete Row
	public void deleteRow(int index) {
		if(index<0) {
			throw new IllegalArgumentException("index cannot be negative.");
		}
		String output = "";
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			return;
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			if (cIndex++ == index) {
				sc.nextLine();
				continue;
			}
			if (output == "")
				output += sc.nextLine();
			else

				output += "\r\n" + sc.nextLine();
		}
		if(cIndex<(index +1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		this.setStringToFile(output);

	}

	//////////////////////////////////////////////////////////////////// getArrayFromFile
	public String[] getArrayFromFile() {
		int rowCount = this.getRowCount();
		String[] output = new String[rowCount];
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		int i = 0;
		while (sc.hasNextLine()) {
			output[i++] = sc.nextLine();
		}
		sc.close();
		return output;
	}
	
	////////////////////////////////////////////////////insertRow
	public void insertRow(int index,String text) {
		if(index<0) {
			throw new IllegalArgumentException("index cannot be negative.");
		}
		String output = "";
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			return;
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			if (cIndex++ == index) {
				if (output == "")
					output += text;
				else

					output += "\r\n" + text;
			}
			if (output == "")
				output += sc.nextLine();
			else

				output += "\r\n" + sc.nextLine();
		}
		if(cIndex<(index +1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		this.setStringToFile(output);

	}
	
}
