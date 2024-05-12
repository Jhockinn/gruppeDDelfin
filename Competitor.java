import java.util.*;

public class Competitor{

private String name; 
private int age; 
private List<TrainingResult> trainingResults; // list to save training results
private List<CompetitionResult> competitionResults; // list to save competition results
private List<String> disciplines;
private ArrayList<String> discipline = new ArrayList<String>(); // list to add new disciplines in Competition

   // being used in the competition class
   public Competitor(int age,String name, ArrayList<String> discipline){
      this.age = age; 
      this.name = name;  
      this.discipline = discipline; 
      this.trainingResults = new ArrayList<>(); 
   }
   
   // being used in the competitionStatistics class 
   public Competitor(int age, String name, List <String> disciplines){
      this.age = age; 
      this.name = name;  
      this.disciplines = disciplines; 
      this.trainingResults = new ArrayList<>(); 
      this.competitionResults = new ArrayList<>(); 
   }
   
   public Competitor(int age,String name){
      this.age=age; 
      this.name=name; 
     
   }
   
   // method for adding training results to a list 
   public void addTrainingResult(TrainingResult trainingResult){
   if(trainingResults != null){
   trainingResults.add(trainingResult); 
      }
   }
   
   // method for adding competition results to a list 
   public void addCompetitionResult(CompetitionResult competitionResult){
   if(competitionResults != null){
   competitionResults.add(competitionResult); 
      }
   }
  
   // getters & setters
   public List<String> getDisciplines(){
   return disciplines; 
   }    
   
   public List<TrainingResult> getTrainingResults(){
   return trainingResults;
   }

   public List<CompetitionResult> getCompetitionResults(){
   return competitionResults;
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
   
   public void setDiscipline(ArrayList<String> discipline){
      this.discipline = discipline;  
   }

   public ArrayList<String> getDiscipline() {
      return discipline; 
   }
   
}