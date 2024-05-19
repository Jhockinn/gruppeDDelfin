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