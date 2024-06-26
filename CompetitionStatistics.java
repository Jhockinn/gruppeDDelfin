import java.util.Scanner; 
import java.util.Random; 
import java.util.ArrayList; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class CompetitionStatistics{

static ArrayList<Competitor> allCompetitors = new ArrayList<>(); // creates a new arraylist with both senior and youth competitors 

// scanner & random
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
      if(scan.hasNextInt()){
      int competitorID = scan.nextInt();     
      
   boolean found = false; 
   for(Competitor competitor : competition.youthCompetitors){
       if(competitor.getID() == competitorID){
       found = true; 
       submitTrainingResults(competitor); // adding training result to a youth competitor 
       break; 
      }
   }
   
   if(!found){
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getID() == competitorID){
      found = true; 
      submitTrainingResults(competitor); // adding training result to a senior competitor
      break;    
      }
     }
    } 
   
    if(!found){
    System.out.println("Could not find the competitor");
    } 
    }else {
    System.out.println("Invalid input. Please enter a valid ID.");
    scan.next(); 
    }
  }

 
 // method for registering competition results for youth and senior competitors 
 public void registerCompetitionResults(){
   System.out.println("Here is the list of competitors: "); 
      competition.showYouthCompetitors(); 
      competition.showSeniorCompetitors(); 
       
      System.out.println("For which competitor do you want to sumbit competition results [ID]? ");
      if(scan.hasNextInt()){
      int competitorID = scan.nextInt(); 
      
   boolean found = false; 
      for(Competitor competitor : competition.youthCompetitors){
         if(competitor.getID() == competitorID){
         found = true; 
         submitCompetitionResults(competitor); // adding competition result to a youth competitor 
         break; 
      }
   }
   
   if(!found){
      for(Competitor competitor : competition.seniorCompetitors){
         if(competitor.getID() == competitorID){
         found = true; 
         submitCompetitionResults(competitor); // adding competition result to a senior competitor 
         break;    
      }
     }
   } 
   
   if(!found){
      System.out.println("Could not find the competitor");
   }  
   }else{
   System.out.println("Invalid input. Please enter a valid ID.");
   scan.next();
   }
 }
 
 // method for submitting training results 
 public void submitTrainingResults(Competitor competitor){
 System.out.println("Enter the training results for " + competitor.getName() + " for each discipline"); 
 
 // for every discipline.. 
 for(String discipline : competitor.getDiscipline()){
   System.out.println(discipline + " - Please add the length of the disciplinec [meters]: ");
   System.out.println("You can choose between [50], [100], [200] meter");  
   int length = scan.nextInt(); 
   
   if(length == 50 || length == 100 || length == 200){
   System.out.println(discipline + " - Please add the time of the discipline [minutes,seconds]: "); 
   double time = 0.0; 
   boolean validTime = false; 
   
   while(!validTime){
   try{
   time = scan.nextDouble();
   validTime = true; 
   }catch(InputMismatchException e){
   System.out.println("Please enter a number with a comma as the decimal"); 
   scan.next(); 
      }
   }
 
   System.out.println("Please add the date of the training result [dd-MM-yyyy]");
   String date = scan.next(); 
   
   TrainingResult trainingResult = new TrainingResult(discipline, length, time, date); // creates a new trainingResult object 
   competitor.addTrainingResult(trainingResult); // adds the training result to a list in competitor 
   
  
   // print out the training result for the competitor 
   System.out.println("Training Results: "); 
   System.out.println(); 
   System.out.println("The competitor : " + competitor.getName()); 
   System.out.println("The discipline: " + discipline); 
   System.out.println("Length: " + length + " meters"); 
   System.out.println("Time: " + time + " minutes");
   System.out.println("Date: " + date); 
   System.out.println(); 
   }else{
   System.out.println("Invalid input - try to enter training results again"); 
   }
  }
 } 
 
 // method for submitting competition results 
 public void submitCompetitionResults(Competitor competitor){
 System.out.println("Enter the competition results for " + competitor.getName() + " for each discipline"); 
 
 // for every discipline.. 
 for(String discipline : competitor.getDiscipline()){
   System.out.println(discipline + " - Please add the length of the disciplinec [meters]: "); 
   System.out.println("You can choose between [50], [100], [200] meter");  
   int length = scan.nextInt(); 
   
   if(length == 50 || length == 100 || length == 200){
   System.out.println(discipline + " - Please add the time of the discipline [minutes,seconds]: "); 
   double time = 0.0; 
   boolean validTime = false; 
   
   while(!validTime){
   try{
   time = scan.nextDouble(); 
   validTime = true; 
   }catch(InputMismatchException e){
   System.out.println("Please enter a number with a comma as the decimal");
   scan.next();  
    }
   }
   
   System.out.println("Please add placement for the competitor: "); 
   int placement = scan.nextInt(); 
   System.out.println("Please add the location of the competition: "); 
   String location = scan.next(); 
   
   CompetitionResult competitionResult = new CompetitionResult(discipline, length, time, placement, location); // creates a new competition object 
   competitor.addCompetitionResult(competitionResult); // adds the competition result to a list in competitor 
  
   // print out the competition result for the competitor
   System.out.println("Competition Results: "); 
   System.out.println(); 
   System.out.println("The competitor : " + competitor.getName()); 
   System.out.println("The discipline: " + discipline); 
   System.out.println("Length: " + length + " meters"); 
   System.out.println("Time: " + time + " minutes");
   System.out.println("Placement: " + placement + " place"); 
   System.out.println("Location: " + location); 
   System.out.println(); 
   }else{
   System.out.println("Invalid input - try to enter training results again"); 
   }
  }
 }
  
  // method for adding random competition results for competitors
  public void addRandomCompetitionResults(){
   allCompetitors.addAll(competition.youthCompetitors); 
   allCompetitors.addAll(competition.seniorCompetitors);
   
   
   String[] disciplines = {"FREESTYLE", "BUTTERFLY", "BACKSTROKE", "BREASTSTROKE"}; // new Array of disciplines
   int[] lengths = {50, 100, 200}; // new Array of lengths for each discipline
   
   // for every competitor and their discipline + length
   for(Competitor competitor : allCompetitors){
      for(String discipline : competitor.getDiscipline()){
        for(int length : lengths){
      
      // assigns each length with a random time   
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
      double max = 1.45; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      }else{
      double min = 2.00; 
      double max = 2.40; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      }
      
      int placement = ran.nextInt(1,10); // assigns a random placement for the competition
      
      int random2 = ran.nextInt(4)+1;  // assigns a random location for the competition
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
      
      CompetitionResult competitionResult = new CompetitionResult(discipline, length, time, placement, location); // creates a new competitonResult object
      competitor.addCompetitionResult(competitionResult); // adds the competition result to a list in competitor 
     }
    }
   }
  }
   
   // method for adding random training results for competitors
   public void addRandomTrainingResults(){
   allCompetitors.addAll(competition.youthCompetitors); 
   allCompetitors.addAll(competition.seniorCompetitors);
   
   String[] disciplines = {"FREESTYLE", "BUTTERFLY", "BACKSTROKE", "BREASTSTROKE"}; // new array of disciplines
   int[] lengths = {50, 100, 200}; // new array of lengths 
   
   for(Competitor competitor : allCompetitors){
      for(String discipline : competitor.getDiscipline()){
        for(int length : lengths){
      
      // assigns each length with a random time  
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
      double max = 1.45; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
         
      }else{
      double min = 2.00; 
      double max = 2.40; 
      double randomNumber = min + (max - min) * ran.nextDouble();
      String formattedTime = String.format("%.2f", randomNumber);
        formattedTime = formattedTime.replace(",", ".");
         time = Double.parseDouble(formattedTime);
      }
      
      // Generates a random date for the training result
      Random rand = new Random(); 
      LocalDate randomDate = LocalDate.of(rand.nextInt(2018, 2024), rand.nextInt(1, 13), rand.nextInt(1, 29));
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

      String date = randomDate.format(formatter);
      
      TrainingResult trainingResult = new TrainingResult(discipline, length, time, date); // creates a training result object
      competitor.addTrainingResult(trainingResult); // adds the training result to a list in competitor 
     }
    }
   }
  }

 
 // method for printing out youth competitor training results
 public void showYouthTrainingResults(){ 
 System.out.println("For which competitor do you want to see training results [ID]?"); 
 
 int competitorID = scan.nextInt();
 
 boolean found = false; 
 
   for(Competitor competitor : competition.youthCompetitors){
      if(competitor.getID() == competitorID){
      found = true; 
      System.out.println("Training Results: "); 
      System.out.println("The competitor : " + competitor.getName()); 
      System.out.println(); 
      
      if(competitor.getTrainingResults() != null){
      for(TrainingResult trainingResult : competitor.getTrainingResults()){
      System.out.println("The discipline: " + trainingResult.getDiscipline()); 
      System.out.println("Length: " + trainingResult.getLength() + " meters"); 
      System.out.println("Time: " + trainingResult.getTime() + " minutes"); 
      System.out.println("Date: " + trainingResult.getDate()); 
      System.out.println(); 
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
  System.out.println("For which competitor do you want to see training results [ID]?"); 
  
  int competitorID = scan.nextInt();
 
  boolean found = false; 
  
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getID() == competitorID){
      found = true; 
      System.out.println("Training Results: "); 
      System.out.println("The competitor : " + competitor.getName()); 
      System.out.println(); 
      
      if(competitor.getTrainingResults()!= null){
      for(TrainingResult trainingResult : competitor.getTrainingResults()){
      System.out.println("The discipline: " + trainingResult.getDiscipline()); 
      System.out.println("Length: " + trainingResult.getLength() + " meters"); 
      System.out.println("Time: " + trainingResult.getTime() + " minutes"); 
      System.out.println("Date: " + trainingResult.getDate()); 
      System.out.println(); 
      }

      }else{
      System.out.println("No training result"); 
      }  
     
      break;     
      }
    }
  }
  
  // method for printing out youth competitor competition results
  public void showYouthCompetitionResults(){ 
  System.out.println("For which competitor do you want to see competition results [ID]?"); 
 
  int competitorID = scan.nextInt();
 
  boolean found = false; 
   for(Competitor competitor : competition.youthCompetitors){
      if(competitor.getID() == competitorID){
      found = true; 
      System.out.println("Competition Results: "); 
      System.out.println("The competitor : " + competitor.getName()); 
      System.out.println(); 
      
      if(competitor.getCompetitionResults() != null){
      for(CompetitionResult competitionResult : competitor.getCompetitionResults()){
      System.out.println("The discipline: " + competitionResult.getDiscipline()); 
      System.out.println("Length: " + competitionResult.getLength() + " meters"); 
      System.out.println("Time: " + competitionResult.getTime() + " minutes");
      System.out.println("Placement: " + competitionResult.getPlacement() + " place"); 
      System.out.println("Location: " + competitionResult.getLocation());  
      System.out.println(); 
      }

      }else{
      System.out.println("No result"); 
      }  
     
      break;     
      }
    }
  } 
  
  // method for printing out senior competitor competition results
  public void showSeniorCompetitionResults(){ 
  System.out.println("For which competitor do you want to see competition results [ID]?"); 
 
  int competitorID = scan.nextInt();
 
  boolean found = false; 
   for(Competitor competitor : competition.seniorCompetitors){
      if(competitor.getID() == competitorID){
      found = true; 
      System.out.println("Competition Results: "); 
      System.out.println("The competitor : " + competitor.getName()); 
      System.out.println(); 
      
      if(competitor.getCompetitionResults() != null){
      for(CompetitionResult competitionResult : competitor.getCompetitionResults()){
      System.out.println("The discipline: " + competitionResult.getDiscipline()); 
      System.out.println("Length: " + competitionResult.getLength() + " meters"); 
      System.out.println("Time: " + competitionResult.getTime() + " minutes");
      System.out.println("Placement: " + competitionResult.getPlacement() + " place"); 
      System.out.println("Location: " + competitionResult.getLocation());  
      System.out.println(); 
      }

      }else{
      System.out.println("No result"); 
      }  
     
      break;     
      }
    }
  }  
}
  
  


