import java.util.Scanner; 

public class CompetitionStatistics{

Scanner scan = new Scanner(System.in); 

Competition competition; 

public CompetitionStatistics(Competition competition){
this.competition = competition; 
}

 // method for registering training results for youth and senior competitors 
 public void registerTrainingResults(){
   System.out.println(); 
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
   System.out.println(); 
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
      System.out.println("Could not find the competitor");
   }  
 }
 
 // method for submitting training results 
 public void submitTrainingResults(Competitor competitor){
 System.out.println("Enter the training results for " + competitor.getName() + " for each discipline"); 
 
 for(String discipline : competitor.getDiscipline()){
   System.out.println(discipline + " - Please add the length of the disciplinec (meters): "); 
   int length = scan.nextInt(); 
   System.out.println(discipline + " - Please add the time of the discipline (minutes , seconds): "); 
   double time = scan.nextDouble(); 
   // dato 
   competitor.addTrainingResult(discipline, length, time);
   System.out.println("The competitor : " + competitor.getName()); 
   System.out.println("The discipline: " + competitor.getDiscipline()); 
   System.out.println("Length: " + length); 
   System.out.println("Time: " + time);
   }
 } 
 
 // method for submitting competition results 
 public void submitCompetitionResults(Competitor competitor){
 System.out.println("Enter the competition results for " + competitor.getName() + " for each discipline"); 

 for(String discipline : competitor.getDiscipline()){
   System.out.println(discipline + " - Please add the length of the disciplinec [meters]: "); 
   int length = scan.nextInt(); 
   System.out.println(discipline + " - Please add the time of the discipline [minutes,seconds]: "); 
   double time = scan.nextDouble(); 
   System.out.println("Please add placement for the competitor: "); 
   int placement = scan.nextInt(); 
   System.out.println("Please add the location of the competition: "); 
   String location = scan.next(); 
   // dato 
   competitor.addCompetitionResult(discipline, length, time, placement, location);
   System.out.println("The competitor : " + competitor.getName()); 
   System.out.println("The discipline: " + competitor.getDiscipline()); 
   System.out.println("Length: " + length); 
   System.out.println("Time: " + time);
   System.out.println("Placement: " + placement); 
   System.out.println("Location: " + location); 
   
   }
  }
}