package dateactivity;

import java.util.HashMap;

public abstract class DateActivityRemembers{
	protected final static String[] weatherConditions =
		{							  "It was a sunny day and the temperature averaged 98 degrees.", 
									  "It was a cloudy day and the temperature averaged 88 degrees.", 
									  "It was a gloomy day and the temperature averaged 78 degrees.", 
									  "It was a rainny day and the temperature averaged 68 degrees."
	};
	//The map key is  date in "dd/mm/yy" format and the value is the weather report string
	
	HashMap<String, String> weatherHistory = new HashMap<String, String>();
	protected static int historyCount = 0;

	public HashMap<String, String> getHistory() {
		return weatherHistory;
	}

	public void setHistory(HashMap<String, String> history) {
		this.weatherHistory = history;
	} //
	
	public void addHistoryEntry(String inquireDate, String report) {
		weatherHistory.put(inquireDate,  report);
		historyCount++;
	}
	
	public String checkWeatherHistory(String inquireDate) {
		String report = weatherHistory.get(inquireDate);
		if (report == null) report = ""; 
		return report; 
	}

}