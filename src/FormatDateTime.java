import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.GregorianCalendar;
/*
 * Date Formatting
 * The following application is supposed to output just the date on the 
 * first line and time on the second. It kinda does it. It kinda doesn't. 
 * Change the application to use DateFormat and give just the date on the 
 * first line and just the time on the second one.

import java.util.Date;

public class DateChangeActivity {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now.toString());
		System.out.println(now.getTime());
	}

}
*/
public class FormatDateTime {
  public static void main(String[] args) {
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String datetostring = format.format(now);
    System.out.println("Today's date is " + datetostring);

    SimpleDateFormat formattime = new SimpleDateFormat("hh:mm:ss a");
    String timetostring = formattime.format(now);
    System.out.println("The time is " + timetostring);
    
  }
}