package dateactivity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public  class DateActivity  extends DateActivityRemembers {	
	String theDate;
	String theWeather;
	
	public DateActivity() 
	{
	}
	
	public DateActivity(String inquireDate) {
		super();
		this.theDate = inquireDate;
		String weatherReport = "";
		
		 //was the date in history? if yes, get the weather report in history
		 weatherReport = super.checkWeatherHistory(inquireDate);
		if (weatherReport.equals("")) {
			Random ran = new Random();		
			int choice = ran.nextInt(DateActivityRemembers.weatherConditions.length);
			this.theWeather = DateActivityRemembers.weatherConditions[choice];	
		}
		else {
			this.theWeather = weatherReport;
		}
		this.addHistoryEntry(this.theDate, this.theWeather);
	}	

	public String getDate() {
		return theDate;
	}
	
	public String getWeather() {
		return theWeather;
	}

	public void setWeather(String dateWeather) {
		this.theWeather = dateWeather;
	}

	public void setDate(String inquireDate) {
		this.theDate = inquireDate;
	}
	
	private Calendar string2Calendar(String aDate) {
		String[] tokens = aDate.split("/");
		System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2]);
		Calendar cal = new GregorianCalendar((int)Integer.parseInt(tokens[2]), (int)Integer.parseInt(tokens[0])-1, (int)Integer.parseInt(tokens[1]));
		return cal;
	}
	public long datesSince(String inquireDate) {
		long diff = 0L;
		Calendar cal = string2Calendar(inquireDate);
		diff = System.currentTimeMillis() - cal.getTimeInMillis();
		long millisecondsPerDay = (24*60*60*1000);
//		long days = TimeUnit.MILLISECONDS.toDays(diff);
	    long days = diff / millisecondsPerDay;
		return days;
	}
	
	public String getWhatDay(String inquireDate) {
		String day = "";
		Calendar cal = string2Calendar(inquireDate);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		  switch(dayOfWeek){
		    case 1:
		        day="Sunday";
		        break;
		    case 2:
		        day="Monday";
		        break;
		    case 3:
		        day="Tuesday";
		        break;
		    case 4:
		        day="Wednesday";
		        break;
		    case 5:
		        day="Thursday";
		        break;
		    case 6:
		        day="Friday";
		        break;
		    case 7:
		        day="Saturday";
		        break;
		    }
		    return day;
	}
}
