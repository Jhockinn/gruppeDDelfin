public class CompetitionResult{

private String discipline; 
private int length; 
private double time; 
private String location; 
private int placement; 
public static final int[] ALLOWED_LENGTHS = {50, 100, 200, 400};

 public CompetitionResult(String discipline, int length, double time, int placement, String location){
   this.discipline = discipline; 
   this.length = length; 
   this.time = time; 
   this.placement = placement; 
   this.location = location;
 }
 
 public CompetitionResult(){
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
 
 public String getLocation(){
   return location; 
 }
 
 public int getPlacement(){
   return placement; 
 }

}
 
