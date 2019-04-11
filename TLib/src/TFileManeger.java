import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TFileManeger {
	private String fileName;

	public TFileManeger(String fileName) {
		super();
		this.fileName = "C:\\Users\\f.zarepour\\workspace\\TLib\\MyFiles\\" + fileName;
		this.CreateFile();
	}

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
		if(s=="")
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

	public void Clear() {
		this.CreateFile();
	}

}
