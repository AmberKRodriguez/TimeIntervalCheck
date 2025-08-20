/* 
Amber Rodriguez 
05.04.25
Project 4 : JavaFX application for comparing two time intervals 
and checking if a time falls within them. */

package application;
	

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;


public class Main extends Application {
   private TextField startTime1, endTime1, startTime2, endTime2, checkTimeField;
   private TextArea outputArea;
   
   @Override // Override the start method in the Application class
   public void start(Stage primaryStage) {
	   
	   //start and end time labels 
	   GridPane pane = new GridPane();
	   pane.setAlignment(Pos.CENTER);
       pane.setPadding(new Insets(11.5, 0, 0, 90));
       pane.setHgap(110);
       pane.add(new Label("Start Time"), 0, 0);
       pane.add(new Label("End Time"), 1, 0);
	   
	   //gridepane for labels and input of time intervals 
	   GridPane pane1 = new GridPane();
       pane1.setAlignment(Pos.CENTER);
       pane1.setPadding(new Insets(0, 12.5, 0, 14.5));
       pane1.setHgap(5.5);
      
      //interval 1 properties 
	   pane1.add(new Label("Time Interval 1"), 0, 0);
       startTime1 = new TextField();
       pane1.add(startTime1, 1, 0);
       startTime1.setPromptText("HH:MM AM/PM");
       endTime1 = new TextField();
       endTime1.setPromptText("HH:MM AM/PM");
       pane1.add(endTime1, 2, 0);
       
       
      
       //interval 2 properties 
       pane1.add(new Label("Time Interval 2"), 0, 2);
       startTime2 = new TextField();
       pane1.add(startTime2, 1, 2);
       startTime2.setPromptText("HH:MM AM/PM");
       endTime2 = new TextField();
       endTime2.setPromptText("HH:MM AM/PM");
       pane1.add(endTime2, 2, 2);
     
     
       //Compare Intervals button and properties 
       GridPane pane2 = new GridPane();
       pane2.setPadding(new Insets(0, 12.5, 0, 14.5));
       pane2.setAlignment(Pos.CENTER);
       Button compareIntervalsButton = new Button("Compare Intervals");
       pane2.add(compareIntervalsButton, 0,0);
       compareIntervalsButton.setOnAction(e -> compareIntervals());
       compareIntervalsButton.setPrefWidth(415);
       
     //time to check testField and properties 
       GridPane pane3 = new GridPane();
       pane3.setAlignment(Pos.CENTER);
       pane3.setPadding(new Insets(0, 12.5, 0, 14.5));
       pane3.setHgap(5.5);
       pane3.add(new Label("Time to Check"), 0,0);
       checkTimeField = new TextField();
       pane3.add(checkTimeField, 1,0); 
       checkTimeField.setPromptText("HH:MM AM/PM");
       checkTimeField.setPrefWidth(330);
       
       //Check time button 
       GridPane pane4 = new GridPane();
       pane4.setAlignment(Pos.CENTER);
       pane4.setPadding(new Insets(0, 12.5, 0, 14.5));
       Button checkTimeButton = new Button("Check Time");
       pane4.add(checkTimeButton, 0,0);
       checkTimeButton.setOnAction(e -> checkTime());
       checkTimeButton.setPrefWidth(415);
       
       
       // Output area properties 
       GridPane pane5 = new GridPane();
       pane5.setAlignment(Pos.CENTER);
       pane5.setPadding(new Insets(0, 12.5, 0, 14.5));
       outputArea = new TextArea();
       outputArea.setEditable(false);
       pane5.add(outputArea, 0,0);
       outputArea.setPrefWidth(415);
       outputArea.setPrefHeight(1);
       outputArea.setFont(new Font("Serif", 14));
       outputArea.setWrapText(true);
       

       // VBox container for overall layout
       VBox vBox = new VBox(5, pane, pane1, pane2, pane3, pane4,  pane5);
       

       //scene properties and what to display 
       Scene scene = new Scene(vBox, 450, 250);
       primaryStage.setTitle("Time Interval Comparison");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
   /*The first button CompareIntervals should compare the two intervals and output 
    one of the following messages depending upon how the intervals compare:*/
   private void compareIntervals() {
       try {
    	   
           Time str1 = new Time(startTime1.getText());
           Time end1 = new Time(endTime1.getText());
           Time str2 = new Time(startTime2.getText());
           Time end2 = new Time(endTime2.getText());
           
           Interval<Time> interval1 = new Interval<>(str1, end1);
           Interval<Time> interval2 = new Interval<>(str2, end2);
           
           String result;
           
           if (interval1.subinterval(interval2)) {
               result = "Interval 1 is a sub-interval of Interval 2";
           } else if (interval2.subinterval(interval1)) {
               result = "Interval 2 is a sub-interval of Interval 1";
           } else if (interval1.overlaps(interval2)) {
               result = "The intervals overlap";
           } else {
               result = "The intervals are disjoint";
           }
           outputArea.setText(result);
        
       } catch (Exception e ) {
           outputArea.setText(e.getMessage());
       }
   }
   // Check if entered time is within intervals
   private void checkTime() {
       try {
    	   //new objects to pull input 
           Time time = new Time(checkTimeField.getText());
           Time str1 = new Time(startTime1.getText());
           Time end1 = new Time(endTime1.getText());
           Time str2 = new Time(startTime2.getText());
           Time end2 = new Time(endTime2.getText());
           
           // new object where Interval class uses time 
           Interval<Time> firstInt = new Interval<>(str1, end1);
           Interval<Time> secondInt = new Interval<>(str2, end2);
           
           
           // input time in first interval is interval1 
           //& input in second interval is interval2
           boolean interval1 = firstInt.within(time);
           boolean interval2 = secondInt.within(time);
           
           String result;
           
           // output one of the following messages depending upon which intervals it is within it
           if (interval1 && interval2) {
               result = "Both intervals contain the time " + time;
           } else if (interval1) {
               result = "Only Interval 1 contains the time " + time;
           } else if (interval2) {
               result = "Only Interval 2 contains the time " + time;
           } else {
               result = "Neither interval contains the time " + time;
               
           }//display message in textArea
           outputArea.setText(result);
           
     } catch (Exception e ) {
           outputArea.setText(e.getMessage());
       }
       
   }
   public static void main(String[] args) {
       launch(args);
   }
}
