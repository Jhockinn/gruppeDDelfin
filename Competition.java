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
   discipline.equalsIgnoreCase("Backstroke") || discipline.equalsIgnoreCase("Breastroke")){
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
ArrayList<Competitor> allCompetitors = new ArrayList<>(); // creates a new arraylist with both senior and youth competitors 
   allCompetitors.addAll(youthCompetitors); 
   allCompetitors.addAll(seniorCompetitors); 
   
   ArrayList<Competitor> topFive = new ArrayList<>(); // arraylist for top five 
   
   for(Competitor competitor : allCompetitors){
   for(String discipline : disciplines){ // takes a top five from each discipline
      if(competitor.getCompetitionResults() != null){
      for(CompetitionResult result : competitor.getCompetitionResults()){ // looks at the competition result from the competitionResult class 
         if(result.getDiscipline().equals(discipline)){ 
         topFive.add(competitor); 
         break; 
         }
       }
      }
     }
   }
   
   ArrayList<Integer> lengths = new ArrayList<>(); 
   lengths.add(50);
   lengths.add(100);
   lengths.add(200); 
   lengths.add(400); 
   
   for(String discipline : disciplines){
      for(int length : lengths){
   
   Collections.sort(topFive, (c1, c2) -> {
      double time1 = getBestTime(c1, discipline, length); 
      double time2 = getBestTime(c2, discipline, length); 
      return Double.compare(time1, time2); 
   }); 
   
    }
   }
   
   ArrayList<Competitor> topFiveArrayList = new ArrayList<>(topFive.subList(0, Math.min(5, topFive.size())));
   return topFiveArrayList;
  
   }
   
   // method for finding a competitors best time for a discipline
   private double getBestTime(Competitor competitor, String discipline, int length){
   double bestTime = Double.MAX_VALUE; 
      for(CompetitionResult result : competitor.getCompetitionResults()){
      if(result.getDiscipline().equals(discipline) && result.getLength() == length && result.getTime() < bestTime){
         bestTime = result.getTime(); 
      }
   }
   return bestTime; 
   
   }
   
   // showing top five swimmers for the freestyle discipline 
   public void showTopFiveSwimmersForFreestyle(){
   
   // ArrayLists for disciplines
   ArrayList<String> Freestyle = new ArrayList<>(); 
   Freestyle.add("Freestyle"); 

   // ArrayLists for lengths 
   ArrayList<Integer> halvtreds = new ArrayList<>(); 
   halvtreds.add(50); 
   ArrayList<Integer> hundrede = new ArrayList<>(); 
   hundrede.add(100); 
   ArrayList<Integer> tohundrede = new ArrayList<>(); 
   tohundrede.add(200); 
   
   ArrayList<Competitor> topFiveSwimmersFreestyle = findTopFiveSwimmers(Freestyle); 
    
   System.out.println("The five best swimmers for Freestyle are ");
   
   Collections.sort(topFiveSwimmersFreestyle, (swimmer1, swimmer2) -> {
      double time50_1 = getBestTime(swimmer1, "Freestyle", 50);
      double time50_2 = getBestTime(swimmer2, "Freestyle", 50);
      return Double.compare(time50_1, time50_2);
   });
   
   int placement = 1;  
   for(Competitor swimmer : topFiveSwimmersFreestyle) {
      for(int length : halvtreds){
         double bestTime50 = getBestTime(swimmer, "Freestyle", length);
         if(bestTime50 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Freestyle with length: " + length + " is "  + bestTime50); 
         System.out.println(); 
        }
      }
     }
     
    Collections.sort(topFiveSwimmersFreestyle, (swimmer1, swimmer2) -> {
      double time100_1 = getBestTime(swimmer1, "Freestyle", 100);
      double time100_2 = getBestTime(swimmer2, "Freestyle", 100);
      return Double.compare(time100_1, time100_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersFreestyle) {
      for(int length : hundrede){
         double bestTime100 = getBestTime(swimmer, "Freestyle", length);
         if(bestTime100 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Freestyle with length: " + length + " is "  + bestTime100); 
         System.out.println();
        } 
      }
     }
     
     Collections.sort(topFiveSwimmersFreestyle, (swimmer1, swimmer2) -> {
      double time200_1 = getBestTime(swimmer1, "Freestyle", 200);
      double time200_2 = getBestTime(swimmer2, "Freestyle", 200);
      return Double.compare(time200_1, time200_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersFreestyle) {
      for(int length : tohundrede){
         double bestTime200 = getBestTime(swimmer, "Freestyle", length);
         if(bestTime200 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Freestyle with length: " + length + " is "  + bestTime200); 
         System.out.println();
        } 
      }
     }
   }
   
   // showing top five swimmers for the butterfly discipline 
   public void showTopFiveSwimmersForButterfly(){
   // ArrayLists for disciplines
   ArrayList<String> Butterfly = new ArrayList<>(); 
   Butterfly.add("Butterfly"); 

   // ArrayLists for lengths 
   ArrayList<Integer> halvtreds = new ArrayList<>(); 
   halvtreds.add(50); 
   ArrayList<Integer> hundrede = new ArrayList<>(); 
   hundrede.add(100); 
   ArrayList<Integer> tohundrede = new ArrayList<>(); 
   tohundrede.add(200); 
   
   ArrayList<Competitor> topFiveSwimmersButterfly = findTopFiveSwimmers(Butterfly); 
    
   System.out.println("The five best swimmers for Butterfly are ");
   
   Collections.sort(topFiveSwimmersButterfly, (swimmer1, swimmer2) -> {
      double time50_1 = getBestTime(swimmer1, "Butterfly", 50);
      double time50_2 = getBestTime(swimmer2, "Butterfly", 50);
      return Double.compare(time50_1, time50_2);
   });
   
   int placement = 1;  
   for(Competitor swimmer : topFiveSwimmersButterfly) {
      for(int length : halvtreds){
         double bestTime50 = getBestTime(swimmer, "Butterfly", length);
         if(bestTime50 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Butterfly with length: " + length + " is "  + bestTime50); 
         System.out.println(); 
        }
      }
     }
     
    Collections.sort(topFiveSwimmersButterfly, (swimmer1, swimmer2) -> {
      double time100_1 = getBestTime(swimmer1, "Butterfly", 100);
      double time100_2 = getBestTime(swimmer2, "Butterfly", 100);
      return Double.compare(time100_1, time100_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersButterfly) {
      for(int length : hundrede){
         double bestTime100 = getBestTime(swimmer, "Butterfly", length);
         if(bestTime100 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Butterfly with length: " + length + " is "  + bestTime100); 
         System.out.println();
        } 
      }
     }
     
     Collections.sort(topFiveSwimmersButterfly, (swimmer1, swimmer2) -> {
      double time200_1 = getBestTime(swimmer1, "Butterfly", 200);
      double time200_2 = getBestTime(swimmer2, "Butterfly", 200);
      return Double.compare(time200_1, time200_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersButterfly) {
      for(int length : tohundrede){
         double bestTime200 = getBestTime(swimmer, "Butterfly", length);
         if(bestTime200 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Butterfly with length: " + length + " is "  + bestTime200); 
         System.out.println();
        } 
      }
     }
   }
   
   // showing top five swimmers for the Backstroke discipline 
   public void showTopFiveSwimmersForBackstroke(){
   // ArrayLists for disciplines
   ArrayList<String> Backstroke = new ArrayList<>(); 
   Backstroke.add("Backstroke"); 
 
   // ArrayLists for lengths 
   ArrayList<Integer> halvtreds = new ArrayList<>(); 
   halvtreds.add(50); 
   ArrayList<Integer> hundrede = new ArrayList<>(); 
   hundrede.add(100); 
   ArrayList<Integer> tohundrede = new ArrayList<>(); 
   tohundrede.add(200); 
   
   ArrayList<Competitor> topFiveSwimmersBackstroke = findTopFiveSwimmers(Backstroke);
    
   System.out.println("The five best swimmers for Backstroke are ");
   
   Collections.sort(topFiveSwimmersBackstroke, (swimmer1, swimmer2) -> {
      double time50_1 = getBestTime(swimmer1, "Backstroke", 50);
      double time50_2 = getBestTime(swimmer2, "Backstroke", 50);
      return Double.compare(time50_1, time50_2);
   });
   
   int placement = 1;  
   for(Competitor swimmer : topFiveSwimmersBackstroke) {
      for(int length : halvtreds){
         double bestTime50 = getBestTime(swimmer, "Backstroke", length);
         if(bestTime50 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Backstroke with length: " + length + " is "  + bestTime50); 
         System.out.println(); 
        }
      }
     }
     
    Collections.sort(topFiveSwimmersBackstroke, (swimmer1, swimmer2) -> {
      double time100_1 = getBestTime(swimmer1, "Backstroke", 100);
      double time100_2 = getBestTime(swimmer2, "Backstroke", 100);
      return Double.compare(time100_1, time100_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersBackstroke) {
      for(int length : hundrede){
         double bestTime100 = getBestTime(swimmer, "Backstroke", length);
         if(bestTime100 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Backstroke with length: " + length + " is "  + bestTime100); 
         System.out.println();
        } 
      }
     }
     
     Collections.sort(topFiveSwimmersBackstroke, (swimmer1, swimmer2) -> {
      double time200_1 = getBestTime(swimmer1, "Backstroke", 200);
      double time200_2 = getBestTime(swimmer2, "Backstroke", 200);
      return Double.compare(time200_1, time200_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersBackstroke) {
      for(int length : tohundrede){
         double bestTime200 = getBestTime(swimmer, "Backstroke", length);
         if(bestTime200 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Backstroke with length: " + length + " is "  + bestTime200); 
         System.out.println();
        } 
      }
     }
   }
   
   // showing top five swimmers for the Breaststroke discipline 
   public void showTopFiveSwimmersForBreaststroke(){
   // ArrayLists for disciplines
   ArrayList<String> Breaststroke = new ArrayList<>(); 
   Breaststroke.add("Breaststroke"); 
   
   // ArrayLists for lengths 
   ArrayList<Integer> halvtreds = new ArrayList<>(); 
   halvtreds.add(50); 
   ArrayList<Integer> hundrede = new ArrayList<>(); 
   hundrede.add(100); 
   ArrayList<Integer> tohundrede = new ArrayList<>(); 
   tohundrede.add(200); 
   
   ArrayList<Competitor> topFiveSwimmersBreaststroke = findTopFiveSwimmers(Breaststroke); 
    
   System.out.println("The five best swimmers for Breaststroke are ");
   
   Collections.sort(topFiveSwimmersBreaststroke, (swimmer1, swimmer2) -> {
      double time50_1 = getBestTime(swimmer1, "Breaststroke", 50);
      double time50_2 = getBestTime(swimmer2, "Breaststroke", 50);
      return Double.compare(time50_1, time50_2);
   });
   
   int placement = 1;  
   for(Competitor swimmer : topFiveSwimmersBreaststroke) {
      for(int length : halvtreds){
         double bestTime50 = getBestTime(swimmer, "Breaststroke", length);
         if(bestTime50 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Breaststroke with length: " + length + " is "  + bestTime50); 
         System.out.println(); 
        }
      }
     }
     
    Collections.sort(topFiveSwimmersBreaststroke, (swimmer1, swimmer2) -> {
      double time100_1 = getBestTime(swimmer1, "Breaststroke", 100);
      double time100_2 = getBestTime(swimmer2, "Breaststroke", 100);
      return Double.compare(time100_1, time100_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersBreaststroke) {
      for(int length : hundrede){
         double bestTime100 = getBestTime(swimmer, "Breaststroke", length);
         if(bestTime100 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Breaststroke with length: " + length + " is "  + bestTime100); 
         System.out.println();
        } 
      }
     }
     
     Collections.sort(topFiveSwimmersBreaststroke, (swimmer1, swimmer2) -> {
      double time200_1 = getBestTime(swimmer1, "Breaststroke", 200);
      double time200_2 = getBestTime(swimmer2, "Breaststroke", 200);
      return Double.compare(time200_1, time200_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersBreaststroke) {
      for(int length : tohundrede){
         double bestTime200 = getBestTime(swimmer, "Breaststroke", length);
         if(bestTime200 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Breaststroke with length: " + length + " is "  + bestTime200); 
         System.out.println();
        } 
      }
     }
   }
  }
   
/* // showing top five swimmers for the freestyle discipline 
   public void showTopFiveSwimmersForAllDisciplines(){
   
   // ArrayLists for disciplines
   ArrayList<String> Freestyle = new ArrayList<>(); 
   Freestyle.add("Freestyle"); 
   ArrayList<String> Butterfly = new ArrayList<>(); 
   Butterfly.add("Butterfly"); 
   ArrayList<String> Backstroke = new ArrayList<>(); 
   Backstroke.add("Backstroke"); 
   ArrayList<String> Breaststroke = new ArrayList<>(); 
   Breaststroke.add("Breaststroke"); 
   
   // ArrayLists for lengths 
   ArrayList<Integer> halvtreds = new ArrayList<>(); 
   halvtreds.add(50); 
   ArrayList<Integer> hundrede = new ArrayList<>(); 
   hundrede.add(100); 
   ArrayList<Integer> tohundrede = new ArrayList<>(); 
   tohundrede.add(200); 
   
   ArrayList<Competitor> topFiveSwimmersFreestyle = findTopFiveSwimmers(Freestyle); 
   ArrayList<Competitor> topFiveSwimmersButterfly = findTopFiveSwimmers(Butterfly); 
   ArrayList<Competitor> topFiveSwimmersBackstroke = findTopFiveSwimmers(Backstroke); 
   ArrayList<Competitor> topFiveSwimmersBreaststroke = findTopFiveSwimmers(Breaststroke); 
    
   System.out.println("The five best swimmers for Freestyle are ");
   
   Collections.sort(topFiveSwimmersFreestyle, (swimmer1, swimmer2) -> {
      double time50_1 = getBestTime(swimmer1, "Freestyle", 50);
      double time50_2 = getBestTime(swimmer2, "Freestyle", 50);
      return Double.compare(time50_1, time50_2);
   });
   
   int placement = 1;  
   for(Competitor swimmer : topFiveSwimmersFreestyle) {
      for(int length : halvtreds){
         double bestTime50 = getBestTime(swimmer, "Freestyle", length);
         if(bestTime50 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Freestyle with length: " + length + " is "  + bestTime50); 
         System.out.println(); 
        }
      }
     }
     
    Collections.sort(topFiveSwimmersFreestyle, (swimmer1, swimmer2) -> {
      double time100_1 = getBestTime(swimmer1, "Freestyle", 100);
      double time100_2 = getBestTime(swimmer2, "Freestyle", 100);
      return Double.compare(time100_1, time100_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersFreestyle) {
      for(int length : hundrede){
         double bestTime100 = getBestTime(swimmer, "Freestyle", length);
         if(bestTime100 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Freestyle with length: " + length + " is "  + bestTime100); 
         System.out.println();
        } 
      }
     }
     
     Collections.sort(topFiveSwimmersFreestyle, (swimmer1, swimmer2) -> {
      double time200_1 = getBestTime(swimmer1, "Freestyle", 200);
      double time200_2 = getBestTime(swimmer2, "Freestyle", 200);
      return Double.compare(time200_1, time200_2);
   });
   
      placement = 1;  
      for(Competitor swimmer : topFiveSwimmersFreestyle) {
      for(int length : tohundrede){
         double bestTime200 = getBestTime(swimmer, "Freestyle", length);
         if(bestTime200 != Double.MAX_VALUE) {
          System.out.print("Placement " + placement++);
          System.out.print("|| Name: " + swimmer.getName());
          System.out.print("|| Age: " + swimmer.getAge());
          System.out.println(); 
         System.out.println("Best time for the discipline Freestyle with length: " + length + " is "  + bestTime200); 
         System.out.println();
        } 
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
      for(int length : CompetitionResult.ALLOWED_LENGTHS){
      System.out.println("Best time for the discipline " + discipline + " with length: " + length + " is "  + getBestTime(swimmer, discipline, length)); 
      System.out.println(); 
    }
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
      for(int length : CompetitionResult.ALLOWED_LENGTHS){
      System.out.println("Best time for the discipline " + discipline + " with length: " + length + " is "  + getBestTime(swimmer, discipline, length)); 
      System.out.println(); 
    }
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
      for(int length : CompetitionResult.ALLOWED_LENGTHS){
      System.out.println("Best time for the discipline " + discipline + " with length: " + length + " is "  + getBestTime(swimmer, discipline, length)); 
      System.out.println(); 
    }
   } 
  }  
 }
} */









