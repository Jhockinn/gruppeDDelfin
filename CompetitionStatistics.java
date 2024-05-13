import java.util.Scanner; 

public class CompetitionStatistics{

Scanner scan = new Scanner(System.in); 

Competition competition; 

public CompetitionStatistics(Competition competition){
this.competition = competition; 
}

 // method for registering training results for youth and senior competitors 
 public void registerTrainingResults(){
   System.out.println("Here is the list of competitors: "); 
      competition.showYouthCompetitors(); 
      competition.showSeniorCompetitors();  
        
      System.out.println("For which competitor do you want to sumbit training results? ");
         String competitorName = scan.next(); 
      
   boolean found = false; 
   for(Competitor competitor : competition.youthCompetitors){
       if(competitor.getName().equals(competitorName)){
       found = true; 
       submitTrainingResults(competitor);   
       break; 
      }
   }
   
   if(!found){
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getName().equals(competitorName)){
      found = true; 
      submitTrainingResults(competitor);    
      break;    
      }
     }
   } 
   
   if(!found){
    System.out.println("Could not find the competitor");
   } 
 }
 
 // method for registering competition results for youth and senior competitors 
 public void registerCompetitionResults(){
   System.out.println("Here is the list of competitors: "); 
      competition.showYouthCompetitors(); 
      competition.showSeniorCompetitors();  
      System.out.println("For which competitor do you want to sumbit competition results? ");
         String competitorName = scan.next(); 
      
   boolean found = false; 
      for(Competitor competitor : competition.youthCompetitors){
         if(competitor.getName().equals(competitorName)){
         found = true; 
         submitCompetitionResults(competitor); 
         break; 
      }
   }
   
   if(!found){
      for(Competitor competitor : competition.seniorCompetitors){
         if(competitor.getName().equals(competitorName)){
         found = true; 
         submitCompetitionResults(competitor); 
         break;    
      }
     }
   } 
   
   if(!found){
      System.out.println("Could not find the com40petitor");
   }  
 }
 
 // method for submitting training results 
 public void submitTrainingResults(Competitor competitor){
 System.out.println("Enter the training results for " + competitor.getName() + " for each discipline"); 
 
 for(String discipline : competitor.getDiscipline()){
   System.out.println(discipline + " - Please add the length of the disciplinec [meters]: ");
   System.out.println("You can choose between [50], [100], [200], [400]");  
   int length = scan.nextInt(); 
   if(length == 50 || length == 100 || length == 200 || length == 400){
   System.out.println(discipline + " - Please add the time of the discipline [minutes,seconds]: "); 
   double time = scan.nextDouble();
   
   TrainingResult trainingResult = new TrainingResult(discipline, length, time); 
   competitor.addTrainingResult(trainingResult);
  
   System.out.println("Training Results: "); 
   System.out.println(); 
   System.out.println("The competitor : " + competitor.getName()); 
   System.out.println("The discipline: " + discipline); 
   System.out.println("Length: " + length + " meters"); 
   System.out.println("Time: " + time + " minutes");
   }else{
   System.out.println("Invalid input - try to enter training results again"); 
   }
   }
 } 
 
 // method for submitting competition results 
 public void submitCompetitionResults(Competitor competitor){
 System.out.println("Enter the competition results for " + competitor.getName() + " for each discipline"); 

 for(String discipline : competitor.getDiscipline()){
   System.out.println(discipline + " - Please add the length of the disciplinec [meters]: "); 
   System.out.println("You can choose between [50], [100], [200], [400] meter");  
   int length = scan.nextInt(); 
   if(length == 50 || length == 100 || length == 200 || length == 400){
   System.out.println(discipline + " - Please add the time of the discipline [minutes,seconds]: "); 
   double time = scan.nextDouble(); 
   System.out.println("Please add placement for the competitor: "); 
   int placement = scan.nextInt(); 
   System.out.println("Please add the location of the competition: "); 
   String location = scan.next(); 
   
   CompetitionResult competitionResult = new CompetitionResult(discipline, length, time, placement, location); 
   competitor.addCompetitionResult(competitionResult); 
  
  
   System.out.println("Competition Results: "); 
   System.out.println(); 
   System.out.println("The competitor : " + competitor.getName()); 
   System.out.println("The discipline: " + discipline); 
   System.out.println("Length: " + length + " meters"); 
   System.out.println("Time: " + time + " minutes");
   System.out.println("Placement: " + placement + " place"); 
   System.out.println("Location: " + location); 
   }else{
   System.out.println("Invalid input - try to enter training results again"); 
   }
   }
  }
 
 // method for printing out youth competitor training results
 public void showYouthTrainingResults(){ 
 System.out.println("For which competitor do you want to see training results?"); 
 
 String competitorName = scan.next();
 
 boolean found = false; 
   for(Competitor competitor : competition.youthCompetitors){
      if(competitor.getName().equals(competitorName)){
      found = true; 
      System.out.println("Training Results: "); 
      System.out.println(); 
      System.out.println("The competitor : " + competitor.getName()); 
      
      if(competitor.getTrainingResults() != null){
      for(TrainingResult trainingResult : competitor.getTrainingResults()){
      System.out.println("The discipline: " + trainingResult.getDiscipline()); 
      System.out.println("Length: " + trainingResult.getLength() + " meters"); 
      System.out.println("Time: " + trainingResult.getTime() + " minutes"); 
      }

      }else{
      System.out.println("No training result"); 
      }  
     
      break;     
      }
   }
 }
 
  // method for printing out senior competitor training results
  public void showSeniorTrainingResults(){ 
  System.out.println("For which competitor do you want to see training results?"); 
  
  String competitorName = scan.next();
 
  boolean found = false; 
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getName().equals(competitorName)){
      found = true; 
      System.out.println("Training Results: "); 
      System.out.println(); 
      System.out.println("The competitor : " + competitor.getName()); 
      
      if(competitor.getTrainingResults()!= null){
      for(TrainingResult trainingResult : competitor.getTrainingResults()){
      System.out.println("The discipline: " + trainingResult.getDiscipline()); 
      System.out.println("Length: " + trainingResult.getLength() + " meters"); 
      System.out.println("Time: " + trainingResult.getTime() + " minutes"); 
      }

      }else{
      System.out.println("No training result"); 
      }  
     
      break;     
      }
   }
 }
  
  public void showYouthCompetitionResults(){ 
  System.out.println("For which competitor do you want to see competition results?"); 
 
  String competitorName = scan.next();
 
  boolean found = false; 
   for(Competitor competitor : competition.youthCompetitors){
      if(competitor.getName().equals(competitorName)){
      found = true; 
      System.out.println("Competition Results: "); 
      System.out.println(); 
      System.out.println("The competitor : " + competitor.getName()); 
      
      if(competitor.getCompetitionResults() != null){
      for(CompetitionResult competitionResult : competitor.getCompetitionResults()){
      System.out.println("The discipline: " + competitionResult.getDiscipline()); 
      System.out.println("Length: " + competitionResult.getLength() + " meters"); 
      System.out.println("Time: " + competitionResult.getTime() + " minutes");
      System.out.println("Placement: " + competitionResult.getPlacement() + " place"); 
      System.out.println("Location: " + competitionResult.getLocation());  
      }

      }else{
      System.out.println("No result"); 
      }  
     
      break;     
      }
   }
 } 
 
  public void showSeniorCompetitionResults(){ 
  System.out.println("For which competitor do you want to see competition results?"); 
 
  String competitorName = scan.next();
 
  boolean found = false; 
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getName().equals(competitorName)){
      found = true; 
      System.out.println("Competition Results: "); 
      System.out.println(); 
      System.out.println("The competitor : " + competitor.getName()); 
      
      if(competitor.getCompetitionResults() != null){
      for(CompetitionResult competitionResult : competitor.getCompetitionResults()){
      System.out.println("The discipline: " + competitionResult.getDiscipline()); 
      System.out.println("Length: " + competitionResult.getLength() + " meters"); 
      System.out.println("Time: " + competitionResult.getTime() + " minutes");
      System.out.println("Placement: " + competitionResult.getPlacement() + " place"); 
      System.out.println("Location: " + competitionResult.getLocation());  
      }

      }else{
      System.out.println("No result"); 
      }  
     
      break;     
      }
   }
 } 
  
}
  
  


