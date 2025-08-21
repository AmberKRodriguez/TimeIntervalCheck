package application;

/* 
Amber Rodriguez 
05.04.25
generic class Interval defined for any type that implements the Comparable interface */

public class Interval<T extends Comparable<T>> {
	final private T start;
	final private T end;

    /* A constructor that accepts the start and end of an interval 
    * and constructs an Interval object*/
    public Interval(T start, T end) {
        this.start = start;
        this.end = end;
    }

    //A method within that is supplied an object of the generic type parameter 
    public boolean within(T object) {
    	// returns whether that object is inside the interval including the endpoints.
       return (object.compareTo(start) >= 0) 
    		   && (object.compareTo(end) <= 0);
       
    }

    //A method subinterval that is passed an interval as a parameter  
     
    public boolean subinterval(Interval<T> interval) {
    	//returns whether the interval parameter is a subinterval, completely within the interval on which is invoked 
        return interval.start.compareTo(this.start) >= 0 
        		&& interval.end.compareTo(this.end) <= 0;
    }

    // A method overlaps that is passed an interval as a parameter 
    public boolean overlaps(Interval<T> interval) {
    	//returns whether the interval parameter overlaps the interval on which the method is invoked 
        return this.start.compareTo(interval.end) <= 0 
        		&& interval.start.compareTo(this.end) < 0;
    }
}

