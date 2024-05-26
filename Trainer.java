import java.util.Scanner; 

public class Trainer{

boolean log = true;

public void TrainerUi(){ // so that we can call the TrainerUi in main
Competition competition = new Competition(); 
Discipline discipline = new Discipline(); 
CompetitionStatistics statistics = new CompetitionStatistics(competition); 
Memberlists lists = new Memberlists();
Chairman AddMemb = new Chairman();

// add random training and competition result to each competitor so that we can see a top five for each disciplone & length
statistics.addRandomCompetitionResults();
statistics.addRandomTrainingResults();     

// scanner 
Scanner scan = new Scanner(System.in);

// a while loop for the Trainer UI
while(log){
   System.out.println(); 
   System.out.println("Welcome to the Trainer UI");
   System.out.println("1: Look at the youth competitor list"); 
   System.out.println("2: Look at the senior competitor list"); 
   System.out.println("3: Register competition results"); 
   System.out.println("4: Register training results"); 
   System.out.println("5: Show competition results for competitors"); 
   System.out.println("6: Show training results for competitors"); 
   System.out.println("7: Show a top five ranking of the best swimmers for each discipline"); 
   System.out.println("8: Logout");
   
   int choice = scan.nextInt(); 
   
   switch(choice){
   case 1: 
      competition.showYouthCompetitors(); // shows youth competitors 
      break; 
   case 2: 
      competition.showSeniorCompetitors(); // shows senior competitors
      break; 
   case 3: 
      statistics.registerCompetitionResults(); // register competition results 
      break; 
   case 4: 
      statistics.registerTrainingResults(); // register training results 
      break; 
   case 5:
      System.out.println("Do you want to see competition results for youth [1] or senior [2]?");  // show competiton results
      int competitionChoice = scan.nextInt(); 
         if(competitionChoice == 1){
         competition.showYouthCompetitors();
         statistics.showYouthCompetitionResults(); 
         }else{
         competition.showSeniorCompetitors(); 
         statistics.showSeniorCompetitionResults(); 
         }
      break; 
    case 6:
      System.out.println("Do you want to see training results for youth [1] or senior [2]?");  // show training results 
      int trainingChoice = scan.nextInt(); 
         if(trainingChoice == 1){
         competition.showYouthCompetitors();
         statistics.showYouthTrainingResults(); 
         }else{
         competition.showSeniorCompetitors(); 
         statistics.showSeniorTrainingResults(); 
         }    
       break; 
     case 7: 
       System.out.println("Do you want to see a top five for for Freestyle [1], Butterfly [2], Backstroke [3] or Breaststroke [4]"); // show the top five 
       int topFive = scan.nextInt(); 
         if(topFive == 1){
         competition.showTopFiveSwimmersForFreestyle(); 
         }
         if(topFive == 2){
         competition.showTopFiveSwimmersForButterfly();
         }
         if(topFive == 3){
         competition.showTopFiveSwimmersForBackstroke(); 
         }
         if(topFive == 4){
         competition.showTopFiveSwimmersForBreaststroke(); 
         }
     break;
     case 8: 
     log = false; // log out option 
     break;
     default: 
      System.out.println("Invalid input");  
     
      }
    }
  }
}
