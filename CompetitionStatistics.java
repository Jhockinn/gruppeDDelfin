import java.util.Scanner; 
import java.util.Random; 
import java.util.ArrayList; 

public class CompetitionStatistics{

Scanner scan = new Scanner(System.in); 
Random ran = new Random(); 

Competition competition; 

 public CompetitionStatistics(Competition competition){
 this.competition = competition; 
 }

 // method for registering training results for youth and senior competitors 
 public void registerTrainingResults(){
   System.out.println("Here is the list of competitors: "); 
      competition.showYouthCompetitors(); 
      competition.showSeniorCompetitors();  
        
      System.out.println("For which competitor do you want to sumbit training results [ID]? ");
         //String competitorName = scan.next(); 
         int competitorID = scan.nextInt(); 
      
   boolean found = false; 
   for(Competitor competitor : competition.youthCompetitors){
       if(competitor.getID() == competitorID){
       found = true; 
       submitTrainingResults(competitor);   
       break; 
      }
   }
   
   if(!found){
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getID() == competitorID){
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
      System.out.println("For which competitor do you want to sumbit competition results [ID]? ");
         int competitorID = scan.nextInt(); 
      
   boolean found = false; 
      for(Competitor competitor : competition.youthCompetitors){
         if(competitor.getID() == competitorID){
         found = true; 
         submitCompetitionResults(competitor); 
         break; 
      }
   }
   
   if(!found){
      for(Competitor competitor : competition.seniorCompetitors){
         if(competitor.getID() == competitorID){
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
   System.out.println("You can choose between [50], [100], [200] meter");  
   int length = scan.nextInt(); 
   if(length == 50 || length == 100 || length == 200){
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
   System.out.println("You can choose between [50], [100], [200] meter");  
   int length = scan.nextInt(); 
   if(length == 50 || length == 100 || length == 200){
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
  
  // method for adding random competition results for competitors
  public void addRandomCompetitionResults(){
  ArrayList<Competitor> allCompetitors = new ArrayList<>(); // creates a new arraylist with both senior and youth competitors 
   allCompetitors.addAll(competition.youthCompetitors); 
   allCompetitors.addAll(competition.seniorCompetitors);
   
   String[] disciplines = {"FREESTYLE", "BUTTERFLY", "BACKSTROKE", "BREASTSTROKE"};
   int[] lengths = {50, 100, 200};
   
   for(Competitor competitor : allCompetitors){
      for(String discipline : competitor.getDiscipline()){
        for(int length : lengths){
        double time;
      if(length == 50){
      double min = 0.30; 
      double max = 0.59; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      } else if(length == 100) {
      double min = 1.00; 
      double max = 1.30; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      }else{
      double min = 1.30; 
      double max = 1.59; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      }
      
      int placement = ran.nextInt(1,10); 
      
      int random2 = ran.nextInt(4)+1; 
      String location;
      if(random2 == 1){
      location = "København"; 
      }else if(random2 == 2){
      location = "Aalborg"; 
      }else if(random2 == 3){
      location = "Køge"; 
      }else{
      location = "Odense"; 
      }
      
      CompetitionResult competitionResult = new CompetitionResult(discipline, length, time, placement, location); 
      competitor.addCompetitionResult(competitionResult);  
     }
    }
   }
  }
   
   // method for adding random training results for competitors
   public void addRandomTrainingResults(){
   ArrayList<Competitor> allCompetitors = new ArrayList<>(); // creates a new arraylist with both senior and youth competitors 
   allCompetitors.addAll(competition.youthCompetitors); 
   allCompetitors.addAll(competition.seniorCompetitors);
   
   String[] disciplines = {"FREESTYLE", "BUTTERFLY", "BACKSTROKE", "BREASTSTROKE"};
   int[] lengths = {50, 100, 200};
   
   for(Competitor competitor : allCompetitors){
      for(String discipline : competitor.getDiscipline()){
        for(int length : lengths){
        double time;
      if(length == 50){
      double min = 0.30; 
      double max = 0.59; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      } else if(length == 100) {
      double min = 1.00; 
      double max = 1.30; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      }else{
      double min = 1.30; 
      double max = 1.59; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      }
      
      TrainingResult trainingResult = new TrainingResult(discipline, length, time); 
      competitor.addTrainingResult(trainingResult);     
     }
    }
   }
  }

 
 // method for printing out youth competitor training results
 public void showYouthTrainingResults(){ 
 System.out.println("For which competitor do you want to see training results?"); 
 
 int competitorID = scan.nextInt();
 
 boolean found = false; 
 
   for(Competitor competitor : competition.youthCompetitors){
      if(competitor.getID() == competitorID){
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
  
  int competitorID = scan.nextInt();
 
  boolean found = false; 
  
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getID() == competitorID){
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
 
  int competitorID = scan.nextInt();
 
  boolean found = false; 
   for(Competitor competitor : competition.youthCompetitors){
      if(competitor.getID() == competitorID){
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
 
  int competitorID = scan.nextInt();
 
  boolean found = false; 
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getID() == competitorID){
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
  
  


