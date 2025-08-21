package application;

/* 
Amber Rodriguez 
05.04.25
Exception class InvalidTime that implements a checked exception */
 
public class InvalidTime extends Exception {

   private final String message;
    // A constructor that accepts the message as a string and constructs an InvalidTime object
    public InvalidTime(String message) {
        super(message);
    	this.message = message;
    }

    //A method getMessage that returns the message
    @Override
    public String getMessage() {
        return message;
    }
}

