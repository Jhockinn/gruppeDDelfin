import java.util.*;

public class Competitor{

private String name; 
private int age; 
public int ID; 
private String gender;
private List<TrainingResult> trainingResults; // list to save training results
private List<CompetitionResult> competitionResults; // list to save competition results
private ArrayList<String> discipline = new ArrayList<String>(); // list to add new disciplines in Competition
private Competitor competitor; 

  // being used in the competition class
   public Competitor(int ID, int age,String name, String gender){
      this.ID = ID; 
      this.age = age; 
      this.name = name;  
      this.gender = gender; 
      this.discipline = discipline; 
      this.trainingResults = new ArrayList<>(); 
      this.competitionResults = new ArrayList<>(); 
     
   }
  
   public Competitor(int age,String name, ArrayList<String> discipline){
      this.age = age; 
      this.name = name;  
      this.discipline = discipline; 
      this.trainingResults = new ArrayList<>(); 
      this.competitionResults = new ArrayList<>(); 
     
   }
   
   
   public Competitor(int age,String name){
      this.age=age; 
      this.name=name; 
     
   }
   
   public Competitor(){
   
   }
   
   // getters & setters
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
   
   public String getGender(){
      return gender;
   }
   
   public void setGender(String gender){
      this.gender = gender;
   }
   
   public int getID(){
      return ID;
   }
   
   public void setID(int ID){
      this.ID = ID;
   
   }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public Competitor getCompetitor() {
        return competitor;
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
   competitionResult.setCompetitor(this); // vær opmærksom
      }
   }
  


}

