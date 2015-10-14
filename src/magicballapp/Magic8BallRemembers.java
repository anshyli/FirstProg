package magicballapp;

//import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import ReadWriteService.FileReadWriteService;

public class Magic8BallRemembers extends Magic8Ball {
//		ArrayList<String> questions = new ArrayList<String>();
//		ArrayList<String> answers = new ArrayList<String>();
		HashMap<String, String> history = new HashMap<String, String>();
		protected static int historyCount = 0;
		final static boolean historyRead = true;
		final static boolean historyWrite = false;
		private HashMap<String, String> grandHistory = new HashMap<String, String>();
		private FileReadWriteService historyIO = new FileReadWriteService();
		
		public Magic8BallRemembers() {
			
		}		
		
		public HashMap<String, String> getGrandHistory() {
			return grandHistory;
		}

		public void setGrandHistory(HashMap<String, String> grandHistory) {
			this.grandHistory = grandHistory;
		}

		public FileReadWriteService getHistoryIO() {
			return historyIO;
		}

		public void setHistoryIO(FileReadWriteService historyIO) {
			this.historyIO = historyIO;
		}		

		public HashMap<String, String> getHistory() {
			return history;
		}

		public void setHistory(HashMap<String, String> history) {
			this.history = history;
		} //
		
		public void addHistoryEntry(String question, String answer) {
			history.put(question,  answer);
			historyCount++;
		}
		public String getHistoryFileName() {
			return historyIO.getFileName();
		}
		public void setHistoryFileName(String historyFileName) {
			historyIO.setFileName(historyFileName);
		}
		public boolean checkQuestionExist(String question) {
			boolean flag = true;
			String answer = readGrandHistory().get(question);
			if (answer == null) flag = false;
			return flag;
		}
		private HashMap <String, String> readGrandHistory() {
			historyIO.setRwFlag(historyRead);
			try {
				grandHistory = historyIO.readFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return grandHistory;
		}
		public void addGrandHistory(HashMap<String, String> grandHistory)
						throws FileNotFoundException, IOException {
			historyIO.setRwFlag(historyWrite);
			historyIO.writeFile(grandHistory);
		}
		public void showGrandHistory() throws FileNotFoundException, IOException {
			showMap(readGrandHistory());
		}
		private void showMap(HashMap<String, String> aMap){
			int i = 1;
			for (Map.Entry<String, String> entry : aMap.entrySet()) {

				System.out.println("The " + i + "th Question is:  " + entry.getKey() + "\n" +
										   "The " + i + "th Answer is:    " + entry.getValue());
				i++;
			}			
		}
		public void displayHistory() {
//			Set<E> set history.entrySet();
//			Iterator iterator = set.iterator();
//			while (iterator.hasNext()){
//				Map<String, String>.Entry<String, String> histryEntry = (Map.Entry<String, String>) iterator.next();
			showMap(history);
		}
}
