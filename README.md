<a href="https://amberkrodriguez.github.io/Portfolio-/">Main Page</a>

<h2>Project Requirment:</h2>  
<ul>
<li> Writing a program to test the relationships between time intervals. </li>
<li> The program should contain four classes. </li>
<li> The first class should a generic class Interval defined for any type that implements the Comparable interface. </li>
<li> Objects of this type have a start and end of the generic type parameter that defines the start and end of the interval.</li>
<li> The class should be immutable, so it should have no setter methods. </li>
</ul>

<h2>Explain Scripts & Steps Taken:</h2>

<h3><a href="https://github.com/AmberKRodriguez/TimeIntervalCheck/blob/main/TimeIntervalCode/Interval.java">Interval Script</a></h3>

<ol>
<li>Created a constructor that accepts the start and end of an interval</li>
		<ul>
			<li>Interval(T start, T end)</li>
			<li>constructs an Interval object{this.start = start; this.end = end;</li>
		</ul>
<br>	
<li>Created a method within that is supplied an object of the generic type parameter</li>
		<ul>
			<li>within(T object)</li>
			<li>returns whether that object is inside the interval including the endpoints:</li>
			<li>(object.compareTo(start) >= 0) && (object.compareTo(end) <= 0);</li>
		</ul>
<br>	
<li>Created a method subinterval that is passed an interval as a parameter</li>
	<ul>
		<li>subinterval(Interval<T> interval)</li>
	</ul>
<br>
<li>Return whether the interval parameter is a subinterval and completely within the interval on which the method is invoked</li>
	<ul>
		<li>interval.start.compareTo(this.start) >= 0 && interval.end.compareTo(this.end) <= 0;</li>
	</ul>
<br>
<li>Created a method overlaps that is passed an interval as a parameter</li>
	<ul>
		<li>overlaps(Interval<T> interval)</li>
	</ul>
<br>
<li>Return whether the interval parameter overlaps the interval on which the method is invoked</li>
	<ul>
		<li>interval.start.compareTo(this.end) < 0&&</li>
		<li>this.start.compareTo(interval.end) < 0;</li>
	</ul>
</ol>
		
<br>
<h3><a href="TimeIntervalCode/Time.java">Time Script</a></h3>
<ol>
<li>Created a constructor that accepts the hours and minutes as integers and the meridian as a string </li>
	<ul>
		<li>Time(int hours, int minutes, String meridian) </li>
	</ul>
<br>	 
<li>constructed a Time object:</li>
	<ul>
		<li>this.hours = hours;</li>
		<li>this.minutes = minutes;</li>
		<li>this.meridian = meridian;</li>
	</ul>
<br>
<li>Created a constructor that accepts a string representation of a time in the format HH:MM AM </li>
	<ul>
		<li>Time(String time)</li>
	</ul>
<br>
<li>constructed a Time object </li>
	<ul>
		<li>this.hours = h;</li>
		<li>this.minutes = m;</li>
		<li>this.meridian = mer;</li>
	</ul>
<br>
<li>Created a method compareTo that compares two times</li>
	<ul>
		<li>compareTo(Time secondTime)</li>
		<li>if (this.meridian.equals(secondTime.meridian)){ </li>
	</ul>
<br>
<li>Return what is required of all such methods needed to implement the Comparable interface</li>
	<ul>
		<li>return (this.hours %12 * 60 + this.minutes) - (secondTime.hours %12 * 60 + secondTime.minutes);</li>
	</ul>
<br>

<li>Created a method toString that returns the string representation of the time in the format time the format HH:MM AM</li>
	<ul>
		<li>String.format("%02d:%02d %s", hours, minutes, meridian);</li>
	</ul>

</ol>

<br>
<h3><a href="TimeIntervalCode/InvalidTime.java">InvalidTime Script</a></h3> 
<ol>
<li>Created a constructor that accepts the message as a string and constructs an InvalidTime object </li>
	<ul>
		<li>InvalidTime(String message){</li>
		<li>constructs an InvalidTime object </li>
		<li>this.message = message;</li>
	</ul>
<br>
<li>Created a method getMessage that returns the message</li>
	<ul>
		<li>String getMessage() { </li>
		<li>return message;</li>
	</ul>
</ol>
<br>

<h3><a href="https://github.com/AmberKRodriguez/TimeIntervalCheck/blob/main/TimeIntervalCode/Main.java">Main Script</a></h3> 


<li>Implement a GUI interface that contains two buttons.</li>
<br>
<ol>
	<li>The first button CompareIntervals should compare the two intervals and output one of the following messages depending upon how the intervals compare</li>
		<ul>
			<li>Interval 1 is a sub-interval of interval 2</li>
			<li>Interval 2 is a sub-interval of interval 1</li>
			<li>The intervals overlap</li>
			<li>The intervals are disjoint</li>
 		</ul>
	<br>
  <li>The second button CheckTime should check whether the time is within the intervals and output one of the following messages depending upon which intervals it is within:</li>
  		<ul>
			<li>Both intervals contain the time HH:MM AM</li>
			<li>Only interval 1 contains the time HH:MM AM</li>
			<li>Only interval 2 contains the time HH:MM AM</li>
			<li>Neither interval contains the time HH:MM AM</li>
		</ul>
</ol>

<img class="image" src="Screen Shot 2025-08-20 at 3.32.15 PM.png" height="500" />
<img class="image" src="Screen Shot 2025-08-20 at 3.32.40 PM.png" height="500" /> 
<img class="image" src="Screen Shot 2025-08-20 at 3.32.29 PM.png" height="500" /> 
