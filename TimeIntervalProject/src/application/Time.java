package application;

/* 
Amber Rodriguez 
05.04.25

Time Class to check input format is correct and whether times are the same of diffrent */

public class Time implements Comparable<Time> {
     private final int hours;
     private final int minutes;
     private final String meridian;


    // A constructor that accepts the hours and minutes as integers 
     //and the meridian as a string and constructs a Time object
     
    public Time(int hours, int minutes, String meridian) {
    	
    	 this.hours = hours;
         this.minutes = minutes;
         this.meridian = meridian;
        
    }

    // A constructor that accepts a string representation of a time 
    //in the format HH:MM AM and constructs a Time object
  //Should any check fail, an exception InvalidTime should be thrown that is provided the reason.
    public Time(String time) throws InvalidTime {
    	
    	//separating string inputs convert to integers then into parts so they can be put into objects 
        String[] parts = time.split("[: ]");
        
        int hr = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        String mer = parts[2];

        this.hours = hr;
        this.minutes = min;
        this.meridian = mer;
        
    	//For the constructor that accepts the string representation, 
    	//additional checks are needed to ensure that the hours and minutes are numeric values. 
      
        if (!time.matches("\\d{1,2}:\\d{2} (AM|PM)")) {
            throw new InvalidTime("Invalid Format HH:MM AM/PM ");
        }
        if (hours < 1 || hours > 12) {
    		throw new InvalidTime("Check that time is is 12 hr format");
    	}
    	if (minutes < 0 || minutes >= 60 ) {
        	throw new InvalidTime("Check that time is is 12 hr format");
    	}	
    }
    

    /*A method compareTo that compares two times and returns what is 
    required of all such methods needed to implement the Comparable interface*/
    
    public int compareTo(Time secondTime) {
    	
    	
    	 //Check that second input is the same (AM or PM) as the first 
	        if (!this.meridian.equals(secondTime.meridian)) {
	        	
	          // If input is AM then subtract 1 else add 1 becuase its PM
	            return this.meridian.equals("AM") ? -1 : 1;
	        }
	        //converts time to minutes in order to check they are the same 
	      	int firstTimeTotalMinutes = (this.hours %12) * 60 + this.minutes;
	        int secondTimeTotalMinutes = (secondTime.hours % 12) * 60 + secondTime.minutes;
	        
	        return Integer.compare(firstTimeTotalMinutes, secondTimeTotalMinutes);
	        
    }
/*A method toString that returns the string 
 * representation of the time in the format time in the format HH:MM AM*/

    
    public String toString() {
        return String.format("%02d:%02d %s", hours, minutes, meridian);
    }
}
