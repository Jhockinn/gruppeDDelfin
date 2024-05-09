import java.util.Scanner; 

public class CompetitionStatistics{

Scanner scan = new Scanner(System.in); 

Competition competition; 

public CompetitionStatistics(Competition competition){
this.competition = competition; 
}

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



}