package txtFileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TFileManeger {
	private String fileName;

	public TFileManeger(String fileName) {
		super();
		// this.fileName = "K:\\Java WorkSpace\\" + fileName;
		this.fileName = "C:\\Users\\f.zarepour\\git\\TLib\\TLib\\MyFiles\\" + fileName;
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

	///////////////////////////////////////////////////////////////////////// *******RowBaseOperations*********

	////////////////////////////////////////////////////////////////////////// AppendRow
	public void AppendRow(String newRow) {
		String s = getFromFile();
		if (s == "")
			s = newRow;
		else
			s += "\r\n" + newRow;
		setStringToFile(s);
	}

	///////////////////////////////////////////////////////////////////////////// DeleteRow
	public void deleteRow(int index) {
		if (index < 0) {
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
		if (cIndex < (index + 1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		this.setStringToFile(output);

	}

	//////////////////////////////////////////////////////////////////////// insertRow
	public void insertRow(int index, String text) {
		if (index < 0) {
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
		if (cIndex < (index + 1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		this.setStringToFile(output);
	}

	/////////////////////////////////////////////////////////////////////// GetRow
	public String getRow(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("index cannot be negative.");
		}
		String output = "";
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			if (cIndex++ == index) {
				output = sc.nextLine();
				break;
			}
			sc.nextLine();
		}
		if (cIndex < (index + 1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		return output;
	}

	/////////////////////////////////////////////////////////////////////// GetRowStartWith
	public String getRowStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		String output = null;
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output = temp;
				break;
			}

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// GetRowsStartWith
	public List<String> getRowsStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		List<String> output = new ArrayList<>();
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output.add(temp);
				break;
			}

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// getRowIndexStartWith
	public int getRowIndexStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		int output = -1;
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output = cIndex;
				break;
			}
			cIndex++;

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// getRowsIndexStartWith
	public List<Integer> getRowsIndexStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		List<Integer> output = new ArrayList<Integer>();
		Scanner sc;
		try {
			sc = new Scanner(new File(this.fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output.add(cIndex);
			}
			cIndex++;

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// *******FileBaseOperations**********
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

	////////////////////////////////////////////////////////////////////////// clearFile
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

}
