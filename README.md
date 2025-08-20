<h2>Project Requirment:</h2>  
<ul>
<li> Writing a program to test the relationships between time intervals. </li>
<li> The program should contain four classes. </li>
<li> The first class should a generic class Interval defined for any type that implements the Comparable interface. </li>
<li> Objects of this type have a start and end of the generic type parameter that defines the start and end of the interval.</li>
<li> The class should be immutable, so it should have no setter methods. </li>
</ul>

<h2>Explain Scripts & Steps Taken:</h2>

<h3>Interval Script</h3>

<ol>
  <li>Create a constructor that accepts the start and end of an interval</li>
Interval(T start, T end)<br/>
constructs an Interval object{this.start = start; this.end = end;<br/>
  <br/>
<li>Create a method within that is supplied an object of the generic type parameter</li>
within(T object)<br/>
returns whether that object is inside the interval including the endpoints:<br/>
(object.compareTo(start) >= 0) && (object.compareTo(end) <= 0);<br/>
<br/>
<li>Create a method subinterval that is passed an interval as a parameter</li>
subinterval(Interval<T> interval)

<li>Returns whether the interval parameter is a subinterval and completely within the interval on which the method is invoked</li>
interval.start.compareTo(this.start) >= 0 && interval.end.compareTo(this.end) <= 0;
method overlaps that is passed an interval as a parameter 
overlaps(Interval<T> interval)

<li>Returns whether the interval parameter overlaps the interval on which the method is invoked</li>
interval.start.compareTo(this.end) < 0&&
this.start.compareTo(interval.end) < 0;

</ol>

<h3>Time Script</h3>
 



A constructor that accepts the hours and minutes as integers and the meridian as a string 
Time(int hours, int minutes, String meridian) 
constructs a Time object:
this.hours = hours;
this.minutes = minutes;
this.meridian = meridian;

A constructor that accepts a string representation of a time in the format HH:MM AM 
Time(String time)
constructs a Time object 
this.hours = h;
  this.minutes = m;
  this.meridian = mer;




A method compareTo that compares two times 
	compareTo(Time secondTime)
  if (this.meridian.equals(secondTime.meridian)) {
Returns what is required of all such methods needed to implement the Comparable interface
           return (this.hours %12 * 60 + this.minutes) - (secondTime.hours %12 * 60 + secondTime.minutes);


A method toString that returns the string representation of the time in the format time the format HH:MM AM
String.format("%02d:%02d %s", hours, minutes, meridian);


<h3>InvalidTime Script</h3> 






A constructor that accepts the message as a string and constructs an InvalidTime object 
InvalidTime(String message){
constructs an InvalidTime object 
this.message = message;

A method getMessage that returns the message
String getMessage() { 
 return message;




<h3>Project4 Script</h3> 


Implement a GUI interface that contains two buttons. 
The first button CompareIntervals should compare the two intervals and

compareIntervals()
Interval<Time> interval1 = new Interval<>(start1, end1);
Interval<Time> interval2 = new Interval<>(start2, end2);
output one of the following messages depending upon how the intervals compare:
• Interval 1 is a sub-interval of interval 2
• Interval 2 is a sub-interval of interval 1
• The intervals overlap
• The intervals are disjoint

The second button CheckTime should check whether the time is within the intervals and output
checkTime()  
Interval<Time> interval1 = new Interval<>(start1, end1);
Interval<Time> interval2 = new Interval<>(start2, end2);

one of the following messages depending upon which intervals it is within:
• Both intervals contain the time HH:MM AM
• Only interval 1 contains the time HH:MM AM
• Only interval 2 contains the time HH:MM AM
• Neither interval contains the time HH:MM AM


<img src="Screen Shot 2025-08-20 at 3.32.15 PM.png" height="500" align="center"/>
<img src="Screen Shot 2025-08-20 at 3.32.40 PM.png" height="500" align="center"/> 
