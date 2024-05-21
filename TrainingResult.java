import java.util.Random; 

public class TrainingResult{

private String discipline; 
private int length; 
private double time; 
private String location; 
private int placement; 
private String date; 

public TrainingResult(String discipline, int length, double time, String date){ // + dato 
this.discipline = discipline; 
this.length = length; 
this.time = time; 
this.date = date; 
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

public String getDate(){
return date; 
}

}