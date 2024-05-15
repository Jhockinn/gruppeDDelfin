import java.util.*;

public class Competitor{
String discipline;
String name; 
int age; 
//ArrayList<String> discipline = new ArrayList<String>(); 
private ArrayList<TrainingResult> trainingResult = new ArrayList<TrainingResult>(); 

   public Competitor(int age,String name,String discipline){
      this.age = age; 
      this.name = name;  
      this.discipline = discipline; 
   }

   public Competitor(int age,String name){
      this.age=age; 
      this.name=name; 
     
   }
   
   public void addTrainingResult(String discipline, int length, double time){
   TrainingResult result = new TrainingResult(discipline, length, time);
   trainingResult.add(result); 
   
   
   }
   

// getters & setters
   public ArrayList<TrainingResult> getTrainingResult(){
   return trainingResult;
   }
    
   public void setAge(int age){
      this.age = age;
   }
   
   public int getAge(){
      return age;
   }
 
   
   public void setName(String name){
      this.name = name;
   }
   
   public String getName(){
      return name;
   }

 
   public void setDiscipline(String discipline){
      this.discipline = discipline;  
   }

   public String getDiscipline() {
      return discipline; 
   }
   public String toString(){
      return "[" + " ID: " + age + ", Name: " + name + " Age: " + discipline + ", Gender: \n";
   }
}