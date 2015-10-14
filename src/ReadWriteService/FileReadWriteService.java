package ReadWriteService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class FileReadWriteService {
	String fileName = "";
	boolean rwFlag = true; // read = true; write = false
	protected static String myDir = "C:\\MC\\iofiles\\";

	public FileReadWriteService() {
	}

	public FileReadWriteService(String fileName, boolean rw) {
		this.fileName =myDir+ fileName;
		this.rwFlag = rw;
	}
	public HashMap<String, String> readFile() throws FileNotFoundException,
			IOException {
		HashMap<String, String> theMap = new HashMap<String, String>();
		String line;

		BufferedReader reader = new BufferedReader(new FileReader(this.getFileName()));
		try {
			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
				// parse the key and value out assume the delimiter is "|"
				String[] tokens = line.split("\\|");
//				System.out.println(tokens[0] + "  " + tokens[1]);
				
				theMap.put(tokens[0], tokens[1]);
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return theMap;
	}

	public void writeFile(HashMap<String, String> theMap) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(this.getFileName(), true)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Entry<String, String> entry : theMap.entrySet()) {
			writer.print(entry.getKey());
			writer.print("|");
			writer.println(entry.getValue());
		}
		writer.close();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = myDir + fileName;
	}

	public boolean isRwFlag() {
		return rwFlag;
	}

	public void setRwFlag(boolean rwFlag) {
		this.rwFlag = rwFlag;
	}
}