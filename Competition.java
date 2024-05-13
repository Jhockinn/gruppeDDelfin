import java.util.ArrayList;
import java.util.Random;  
import java.util.Scanner; 
import java.util.Collections; 

public class Competition{

// ArrayLists for youth and senior competitors 
public ArrayList<Competitor> youthCompetitors = new ArrayList<Competitor>(); 
public ArrayList<Competitor> seniorCompetitors = new ArrayList<Competitor>(); 

// ArrayList for memberList
ArrayList<Members> memberList = new ArrayList<Members>();

// Scanner & random
Scanner scan = new Scanner(System.in); 
Random ran = new Random(); 

// Method for adding new competitors 
public void addCompetitor(){
   System.out.println("What is the members name?"); 
   String name = scan.next(); 
   System.out.println("What is the members age?"); 
   int age = scan.nextInt(); 
   System.out.println("How many swimming disciplines does the member participate in?"); 
   int choice = scan.nextInt(); 
   
   ArrayList<String> disciplines = new ArrayList<String>(); 
   
   for(int i=0; i<choice; i++){
   System.out.println("Enter the swimming disciplines one at a time: ");
   System.out.println("The four disciplines are [Freestyle], [Butterfly], [Backstroke], [Breaststroke]"); 
   String discipline = scan.next().toLowerCase();  
   discipline = discipline.substring(0,1).toUpperCase() + discipline.substring(1);
   if(discipline.equalsIgnoreCase("Freestyle") || discipline.equalsIgnoreCase("Butterfly") || 
   discipline.equalsIgnoreCase("Backstroke") || discipline.equalsIgnoreCase("Backstroke")){
   disciplines.add(discipline);
    }else{
   System.out.println("Invalid input - please try to enter the swimming discipline again"); 
   i--;
   }
   
   Competitor competitor = new Competitor(age,name,disciplines);
   
   if(competitor.getAge() < 18){
      youthCompetitors.add(competitor); 
      showYouthCompetitors();
   }else{
      seniorCompetitors.add(competitor);
      showSeniorCompetitors();
   } 
  }
}

// method for showing youth competitors 
public void showYouthCompetitors(){
   System.out.println("Junior competitors: "); 
   
   for(Competitor competitor : youthCompetitors){
      System.out.print(" Name: " + competitor.getName()); 
      System.out.print(" Age: " + competitor.getAge()); 
      System.out.println(" Disciplines " + competitor.getDiscipline());
      System.out.println(); 
      
   }
}

// method for showing senior competitors 
public void showSeniorCompetitors(){
   System.out.println("Senior competitors: ");
   
   for(Competitor competitor : seniorCompetitors){
      System.out.print(" Name: " + competitor.getName()); 
      System.out.print(" Age: " + competitor.getAge()); 
      System.out.print(" Disciplines " + competitor.getDiscipline());  // trainingresult.getTime(); 
       System.out.println(); 
   }
}

// method for sorting members from memberList to a competitorList
public void sortCompetitors(){ // (Members memberList)

/*Add add = new Add(); 
add.add(); 
add.sort(); */

for(int i=0; i<memberList.size(); i++){
   Members member = memberList.get(i); 
   if(member.getCompetitor() && member.getAge()<18){ // get og is competitor? 
      Competitor youthCompetitor = new Competitor(member.getAge(), member.getName()); // creates a competitor with age and name
      Discipline discipline = new Discipline();
         youthCompetitor.setDiscipline(discipline.getRandomDiscipline());  // gives the competitor a random discipline 
         youthCompetitors.add(youthCompetitor); // adds the competitor to the arrayList
 
   }else if(member.getCompetitor() && member.getAge()>=18){
      Competitor seniorCompetitor = new Competitor(member.getAge(), member.getName()); 
      Discipline discipline = new Discipline();
         seniorCompetitor.setDiscipline(discipline.getRandomDiscipline());  
         seniorCompetitors.add(seniorCompetitor);
   }else{
   System.out.println("Could not sort competitors");
  } 
 }
} 

// method for finding top five swimmers for a discipline
public ArrayList<Competitor> findTopFiveSwimmers(ArrayList<String> disciplines){
ArrayList<Competitor> allCompetitors = new ArrayList<>(); 
   allCompetitors.addAll(youthCompetitors); 
   allCompetitors.addAll(seniorCompetitors); 
   
   ArrayList<Competitor> topFive = new ArrayList<>(); 
   for(Competitor competitor : allCompetitors){
   for(String discipline : disciplines){
      if(competitor.getCompetitionResults() != null){
      for(CompetitionResult result : competitor.getCompetitionResults()){
         if(result.getDiscipline().equals(discipline)){ 
         topFive.add(competitor); 
         break; 
         }
       }
      }
     }
   }
   
   //comparing two competitors regarding to time 
   Collections.sort(topFive, (c1, c2) -> {
      double time1 = getBestTime(c1, disciplines.get(0)); 
      double time2 = getBestTime(c2, disciplines.get(0)); 
      return Double.compare(time1, time2); 
   }); 
   
   ArrayList<Competitor> topFiveArrayList = new ArrayList<>(topFive.subList(0, Math.min(5, topFive.size())));
   
   return topFiveArrayList;
}  
   
   // method for finding a competitors best time for a discipline
   private double getBestTime(Competitor competitor, String discipline){
   double bestTime = Double.MAX_VALUE; 
      for(CompetitionResult result : competitor.getCompetitionResults()){
      if(result.getDiscipline().equals(discipline) && result.getTime() < bestTime){
         bestTime = result.getTime(); 
      }
   }
   return bestTime; 
   
   }
   
 // showing top five swimmers for the freestyle discipline 
   public void showTopFiveSwimmersForAllDisciplines(){
   ArrayList<String> Freestyle = new ArrayList<>(); 
   Freestyle.add("Freestyle"); 
   ArrayList<String> Butterfly = new ArrayList<>(); 
   Butterfly.add("Butterfly"); 
   ArrayList<String> Backstroke = new ArrayList<>(); 
   Backstroke.add("Backstroke"); 
   ArrayList<String> Breaststroke = new ArrayList<>(); 
   Breaststroke.add("Breaststroke"); 
   
   ArrayList<Competitor> topFiveSwimmersFreestyle = findTopFiveSwimmers(Freestyle); 
   ArrayList<Competitor> topFiveSwimmersButterfly = findTopFiveSwimmers(Butterfly); 
   ArrayList<Competitor> topFiveSwimmersBackstroke = findTopFiveSwimmers(Backstroke); 
   ArrayList<Competitor> topFiveSwimmersBreaststroke = findTopFiveSwimmers(Breaststroke); 
   
   System.out.println("The five best swimmers for Freestyle are "); 
   for(int i = 0; i< topFiveSwimmersFreestyle.size(); i++){
      Competitor swimmer = topFiveSwimmersFreestyle.get(i);   
      System.out.print("Placement " + (i + 1));
      System.out.print("|| Name: " + swimmer.getName());
      System.out.print("|| Age: " + swimmer.getAge());
      System.out.println(); 
      for(String discipline : Freestyle){
      System.out.println("Best time for the discipline " + discipline + " is: " + getBestTime(swimmer, discipline)); 
      System.out.println(); 
   } 
  }
  
  System.out.println("The five best swimmers for Butterfly are ");
   for(int i = 0; i< topFiveSwimmersButterfly.size(); i++){
      Competitor swimmer = topFiveSwimmersButterfly.get(i);    
      System.out.print("Placement " + (i + 1));
      System.out.print("|| Name: " + swimmer.getName());
      System.out.print("|| Age: " + swimmer.getAge());
      System.out.println(); 
      for(String discipline : Butterfly){
      System.out.println("Best time for the discipline " + discipline + " is: " + getBestTime(swimmer, discipline)); 
      System.out.println(); 
   } 
  }
  
  System.out.println("The five best swimmers for Backstroke are ");
   for(int i = 0; i< topFiveSwimmersBackstroke.size(); i++){
      Competitor swimmer = topFiveSwimmersBackstroke.get(i);    
      System.out.print("Placement " + (i + 1));
      System.out.print("|| Name: " + swimmer.getName());
      System.out.print("|| Age: " + swimmer.getAge());
      System.out.println(); 
      for(String discipline : Backstroke){
      System.out.println("Best time for the discipline " + discipline + " is: " + getBestTime(swimmer, discipline)); 
      System.out.println(); 
   } 
  }
  
  System.out.println("The five best swimmers for Breaststroke are ");
   for(int i = 0; i< topFiveSwimmersBreaststroke.size(); i++){
      Competitor swimmer = topFiveSwimmersBreaststroke.get(i);    
      System.out.print("Placement " + (i + 1));
      System.out.print("|| Name: " + swimmer.getName());
      System.out.print("|| Age: " + swimmer.getAge());
      System.out.println(); 
      for(String discipline : Breaststroke){
      System.out.println("Best time for the discipline " + discipline + " is: " + getBestTime(swimmer, discipline)); 
      System.out.println(); 
   } 
  }
  
}
}



