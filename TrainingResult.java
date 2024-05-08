public class TrainingResult{

private String discipline; 
private int length; 
private double time; 

public TrainingResult(String discipline, int length, double time){
this.discipline = discipline; 
this.length = length; 
this.time = time; 
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