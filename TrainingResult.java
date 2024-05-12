import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
import java.util.Random; 

public class TrainingResult{

private String discipline; 
private int length; 
private double time; 
private String location; 
private int placement; 

public TrainingResult(String discipline, int length, double time){ // + dato 
this.discipline = discipline; 
this.length = length; 
this.time = time; 
}

public TrainingResult(){

}

public void getRandomDate(){
LocalDateTime randomTime = LocalDateTime.now(); 
DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 

   String formattedDate = randomTime.format(formatTime); 
   System.out.println("After formatting: " + formattedDate); 
   System.out.println(formattedDate);
 } 

public String getDiscipline(){
return discipline; 
}

public int getLength(){
return length; 
}

public double getTime(){
return time; 
}

}