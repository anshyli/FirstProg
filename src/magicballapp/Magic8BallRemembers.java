package magicballapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
//import java.util.Iterator;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class Magic8BallRemembers extends Magic8Ball {
//		ArrayList<String> questions = new ArrayList<String>();
//		ArrayList<String> answers = new ArrayList<String>();
		HashMap<String, String> history = new HashMap<String, String>();
		protected static int historyCount = 0;
		
		public Magic8BallRemembers() {
			
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
		
		public void displayHistory() {
//			Set<E> set history.entrySet();
//			Iterator iterator = set.iterator();
//			while (iterator.hasNext()){
//				Map<String, String>.Entry<String, String> histryEntry = (Map.Entry<String, String>) iterator.next();
			int i = 1;
			for (Map.Entry<String, String> entry : history.entrySet()) {

				System.out.println("The " + i + "th Question is:  " + entry.getKey() + "\n" +
										   "The " + i + "th Answer is:    " + entry.getValue());
				i++;
			}
		}
}
