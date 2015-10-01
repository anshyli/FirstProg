import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Nelson
 *
 */
public class FirstProg {

	public static void main(String[] args) {
		String username = System.getProperty("user.name");
        System.out.println( "I, " + username + ", am determined to learn how to code." );
//        System.out.println( "I, " + System.getenv("USERNAME") + ", am determined to learn how to code." );
        DateFormat df = new SimpleDateFormat("EEE, MMM d, ''yy");
        Date dateobj = new Date();
        System.out.println( "Today's date is " + df.format(dateobj));	
    }
	
}