import java.util.Scanner; 

public class Trainer{

public void TrainerUi(){
Competition competition = new Competition(); 
Discipline discipline = new Discipline(); 
CompetitionStatistics statistics = new CompetitionStatistics(competition); 

Competitive competi = new Competitive();
Add AddMemb = new Add();
Active acti = new Active();
AddMemb.addNames();
AddMemb.add();
competi.compe(AddMemb.memberList);
acti.active(AddMemb.memberList);
System.out.println(AddMemb.memberList);

competition.sortCompetitors(); 

Scanner scan = new Scanner(System.in);

while(true){
   System.out.println("Welcome to the Trainer UI"); 
   System.out.println("1: Look at the youth competitor list"); 
   System.out.println("2: Look at the senior competitor list"); 
   System.out.println("3: Add a new competitor"); 
   System.out.println("4: Register competition results"); 
   System.out.println("5: Register training results"); 
   System.out.println("6: Show training results for competitors"); 
   System.out.println("7: Show competition results for competitors"); 
   System.out.println("8: Show a top five ranking of the best swimmers for each discipline"); 
   
   int choice = scan.nextInt(); 
   
   switch(choice){
   case 1: 
      competition.showYouthCompetitors(); 
      break; 
   case 2: 
      competition.showSeniorCompetitors(); 
      break; 
   case 3: 
      competition.addCompetitor(); 
      break; 
   case 4: 
      statistics.registerCompetitionResults(); 
      break; 
   case 5: 
      statistics.registerTrainingResults(); 
      break; 
   case 6: 
      System.out.println("Do you want to see training results for youth [1] or senior [2]?");  
      int trainingChoice = scan.nextInt(); 
         if(trainingChoice == 1){
         statistics.showYouthTrainingResults(); 
         }else{
         statistics.showSeniorTrainingResults(); 
         }
      break; 
    case 7:      
      System.out.println("Do you want to see competition results for youth [1] or senior [2]?");  
      int competitionChoice = scan.nextInt(); 
         if(competitionChoice == 1){
         statistics.showYouthCompetitionResults(); 
         }else{
         statistics.showSeniorCompetitionResults(); 
         }
       break; 
     case 8: 
     break;
     default: 
      System.out.println("Invalid input");  
     
      }
    }
  }
}