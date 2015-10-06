/*
  IS Community School wants a new tool that its teachers will use to gather statistics for their classes.
  
  The data that the teachers will gather is as follows:
  
  Name    Grade  Gender  Major  State of Origin  
  Bob Jones  A    M    Finance  Maryland  
  
  
  Write an application that will accept the user input (as long as it continues) and at the end will compute the following:
  
  Overall Average      
  Average for Gender    
  Average for Major    
  Average by State    
*/
import java.util.ArrayList;
import java.util.Scanner;

public class AveGPA {

	static int studentCount = 0;
	
	class StudentBean {
		String Name;
		char   Grade;
		char   Gender;
		String Major;
		String State;

		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public double getGrade() {
			return Grade;
		}
		public void setGrade(char grade) {
			Grade = grade;
		}
		public char getGender() {
			return Gender;
		}
		public void setGender(char gender) {
			Gender = gender;
		}
		public String getMajor() {
			return Major;
		}
		public void setMajor(String major) {
			Major = major;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
	}
    
    // Convert letter grade to GPA and return it
     static double letterToGPA(String grade) {
	        grade.toUpperCase();
	        char letter = grade.charAt(0);
	        if (letter == 'A') {
	           return 4.0;
	        } else if (letter == 'B') {
	           return 3.0;
	        } else if (letter == 'C') {
	           return 2.0;
	        } else if (letter == 'D') {
	           return 1.0;
	        } else if (letter == 'E' || letter == 'F') {
	           return 0.0;
	        } else {
	           return -1.0;
	        }
      }
     
	public static void main(String[] args) {
		//create the data store
		ArrayList<AveGPA.StudentBean> students = new ArrayList<AveGPA.StudentBean>();
		AveGPA aveGPA = new AveGPA();
		//define local variables
		Scanner sc = new Scanner(System.in);
		String aName, aGrade, aGender;
		double totalGPA = 0.0, maleTotal = 0.0, femaleTotal = 0.0, aGPA = 0.0;
		int maleCount = 0, femaleCount = 0;
		
	    System.out.println("IS Community School Classes Program");
	    System.out.println(" Type \"exit\" to exit this program.");
	    System.out.println("----------------------------------- \n");
	    
	    System.out.print("Enter Student Name: ");
	    aName = sc.next();
	    
	    while (!aName.equals("exit") && !aName.equals("done")) {
		      studentCount++; 
		      AveGPA.StudentBean aStudent = aveGPA.new StudentBean();
		      aStudent.Name = aName;
		      
		      // Prompt for Grade.
		      System.out.print("Enter Letter Grade: ");
		      aGrade = sc.next();
		      aStudent.Grade = aGrade.charAt(0);
		      aGPA = letterToGPA(aGrade);
		      System.out.println("A student gpa: " + aGPA);
		      totalGPA = aGPA + totalGPA;
		      // Prompt for Gender.
		      System.out.print("Enter Gender: ");
		      aGender = sc.next();
		      aStudent.Gender = aGender.charAt(0);
		      if (aStudent.Gender == 'm' ||  aStudent.Gender == 'M') {
		    	  maleTotal = aGPA + maleTotal;
		    	  maleCount++;
		      } else {
		    	  femaleTotal = aGPA + femaleTotal;
		    	  femaleCount++;
		      }
		      //not handling for different state and state validation for now
		      // Prompt for State.
		      System.out.print("Enter State: ");
		      aStudent.State = sc.next();
		      //not handling for different major and major validation for now
		      // Prompt for Major
		      System.out.print("Enter Major: ");
		      aStudent.Major = sc.next();
		      
		      students.add(aStudent);
		      
			  System.out.print("Enter Student Name: ");
			  aName = sc.next();
		 }	
	    System.out.println("Name \t Grade \t Gender \t Major \t State of Origin");
	    for (AveGPA.StudentBean aStudent : students) {
	    	System.out.print(aStudent.Name);
	    	System.out.print("\t" + aStudent.Grade);
	    	System.out.print("\t" + aStudent.Gender);
	    	System.out.print("\t" + aStudent.Major);
	    	System.out.print("\t" + aStudent.State);	  
	    	System.out.println();
	    }
	    if (studentCount != 0)  System.out.println("Overall Average: " + totalGPA/studentCount);
	    if (maleCount != 0)   System.out.println("Male Average: " + maleTotal/maleCount);
	    if (femaleCount != 0)   System.out.println("Male Average: " + femaleTotal/femaleCount);	
	}

}
