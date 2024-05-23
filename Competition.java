import java.util.ArrayList;
import java.util.Random;  
import java.util.Scanner; 
import java.util.Collections;  
import java.util.Arrays; 

public class Competition{

// ArrayLists for youth and senior competitors 
public static ArrayList<Competitor> youthCompetitors = new ArrayList<Competitor>(); 
public static ArrayList<Competitor> seniorCompetitors = new ArrayList<Competitor>(); 

// Scanner & random
Scanner scan = new Scanner(System.in); 
Random ran = new Random(); 

//Memberlists lists = new Memberlists();
Chairman chair = new Chairman();

// method for showing youth competitors 
public void showYouthCompetitors(){
   System.out.println("Junior competitors: "); 
   
   for(Competitor competitor : youthCompetitors){
      System.out.print(" ID: " + competitor.getID()); 
      System.out.print(" Name: " + competitor.getName()); 
      System.out.print(" Age: " + competitor.getAge()); 
      System.out.print(" Gender: " + competitor.getGender()); 
      System.out.print(" Disciplines " + competitor.getDiscipline());
      System.out.println(); 
      
   }
}

// method for showing senior competitors 
public void showSeniorCompetitors(){
   System.out.println("Senior competitors: ");
   
   for(Competitor competitor : seniorCompetitors){
      System.out.print(" ID: " + competitor.getID()); 
      System.out.print(" Name: " + competitor.getName()); 
      System.out.print(" Age: " + competitor.getAge()); 
      System.out.print(" Gender: " + competitor.getGender());
      System.out.print(" Disciplines " + competitor.getDiscipline());  
       System.out.println(); 
   }
}

int lastID = 0; 

// method for sorting members from memberList to a competitorList
public void sortCompetitors(ArrayList<Members> list){ 

for(Members member : list){   
   if(member.getCompetitor() && member.getAge()<=18){
      Competitor youthCompetitor = new Competitor(member.getID(), member.getAge(), member.getName(), chair.chooseGender(member)); // creates a competitor with age and name
      Discipline discipline = new Discipline();
         youthCompetitor.setDiscipline(discipline.getRandomDiscipline());  // gives the competitor a random discipline 
         youthCompetitors.add(youthCompetitor); // adds the competitor to the arrayList 
         youthCompetitors.get(youthCompetitors.size()-1).setID(youthCompetitors.size()); 
 
   }else if(member.getCompetitor() && member.getAge()>18){
      Competitor seniorCompetitor = new Competitor(member.getID(),member.getAge(), member.getName(), chair.chooseGender(member)); 
      Discipline discipline = new Discipline();
         seniorCompetitor.setDiscipline(discipline.getRandomDiscipline());
         seniorCompetitors.add(seniorCompetitor); 
         int totalCompetitors = youthCompetitors.size() + seniorCompetitors.size(); 
         seniorCompetitors.get(seniorCompetitors.size()-1).setID(totalCompetitors);
   }else{  
   } 
  }
 } 
        // methods for showing top five swimmers for length and discipline in both senior and youth
        public void showTopFiveSwimmersForFreestyle() {
        String discipline = "FREESTYLE";
        ArrayList<Integer> lengths = new ArrayList<>(Arrays.asList(50, 100, 200));
        
        // Find top five swimmers for each length (youth)
        System.out.println("TOP 5 YOUTH COMPETITORS"); 
        System.out.println(); 
        for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersYouth(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Freestyle.");
            } else {
                System.out.println("Top five for " + length + " meters Freestyle:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);       
                }
            }
        }
        
        // Find top five swimmers for each length (senior)
        System.out.println(); 
        System.out.println("TOP 5 SENIOR COMPETITORS"); 
        System.out.println(); 
        for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersSenior(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Freestyle.");
            } else {
                System.out.println("Top five for " + length + " meters Freestyle:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);
                  }
               }
            }
         }
    
        public void showTopFiveSwimmersForButterfly() {
        String discipline = "BUTTERFLY";
        ArrayList<Integer> lengths = new ArrayList<>(Arrays.asList(50, 100, 200));
        
        // Find top five swimmers for each length (youth)
        System.out.println("TOP 5 YOUTH COMPETITORS"); 
        System.out.println(); 
        for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersYouth(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Butterfly.");
            } else {
                System.out.println("Top five for " + length + " meters Butterfly:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);
                }
            }
        }
        
        // Find top five swimmers for each length (senior)
        System.out.println(); 
        System.out.println("TOP 5 SENIOR COMPETITORS"); 
        System.out.println(); 
        for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersSenior(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Butterfly.");
            } else {
                System.out.println("Top five for " + length + " meters Butterfly:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);
                  }
               }
             }
           }
    
        public void showTopFiveSwimmersForBackstroke() {
        
        String discipline = "BACKSTROKE";
        ArrayList<Integer> lengths = new ArrayList<>(Arrays.asList(50, 100, 200));
        
        // Find top five swimmers for each length (youth)
        System.out.println("TOP 5 YOUTH COMPETITORS"); 
        System.out.println(); 
        for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersYouth(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Backstroke.");
            } else {
                System.out.println("Top five for " + length + " meters Backstroke:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);
                }
            }
         }
         
         // Find top five swimmers for each length (senior)
         System.out.println(); 
         System.out.println("TOP 5 SENIOR COMPETITORS"); 
         System.out.println(); 
         for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersSenior(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Backstroke.");
            } else {
                System.out.println("Top five for " + length + " meters Backstroke:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);
               } 
            }
          }
        }
    
        public void showTopFiveSwimmersForBreaststroke() {
        
        String discipline = "BREASTSTROKE";
        ArrayList<Integer> lengths = new ArrayList<>(Arrays.asList(50, 100, 200));
      
        // Find top five swimmers for each length (youth)
        System.out.println("TOP 5 YOUTH COMPETITORS"); 
        System.out.println(); 
        for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersYouth(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Breaststroke.");
            } else {
                System.out.println("Top five for " + length + " meters Breaststroke:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);
                }
              }
            }
            
         // Find top five swimmers for each length (senior)
         System.out.println(); 
         System.out.println("TOP 5 SENIOR COMPETITORS"); 
         System.out.println(); 
         for (int length : lengths) {
            ArrayList<Competitor> topFiveSwimmers = findTopFiveSwimmersSenior(discipline, length);
            if (topFiveSwimmers.isEmpty()) {
                System.out.println("No swimmers found for " + length + " meters Breaststroke.");
            } else {
                System.out.println("Top five for " + length + " meters Breaststroke:");
                int placement = 1;
                for (Competitor swimmer : topFiveSwimmers) {
                    double bestTime = getBestTime(swimmer, discipline, length);
                    System.out.println("Placement " + placement++ + " || Name: " + swimmer.getName() +
                            " || Age: " + swimmer.getAge() + " || Best time: " + bestTime);
            
               }
             }
           } 
         }
    
    // method for finding top 5 swimmers for youth competitors
    public ArrayList<Competitor> findTopFiveSwimmersYouth(String discipline, int length) {
    ArrayList<Competitor> topFiveSwimmers = new ArrayList<>();
       
        for (Competitor youths : youthCompetitors) { 
           if (youths.getDiscipline().contains(discipline)) {
           topFiveSwimmers.add(youths);
          }
        }
        
        // Sort the topFiveSwimmers by their best time for the specified length
        Collections.sort(topFiveSwimmers, (swimmer1, swimmer2) ->
                Double.compare(getBestTime(swimmer1, discipline, length), getBestTime(swimmer2, discipline, length)));
                
        // Take only the top five swimmers
        if (topFiveSwimmers.size() > 5) { 
            return new ArrayList<>(topFiveSwimmers.subList(0, 5)); // If it is greater than 5, it returns the trimmed sublist containing only the top five swimmers.
        } else {
            return topFiveSwimmers;
       }
     }
    
    // method for finding top 5 swimmers for senior competitors
    public ArrayList<Competitor> findTopFiveSwimmersSenior(String discipline, int length) {
    ArrayList<Competitor> topFiveSwimmers = new ArrayList<>();
       
        for (Competitor senior : seniorCompetitors) { // Assuming allCompetitors is a list containing all competitors
            if (senior.getDiscipline().contains(discipline)) {
            topFiveSwimmers.add(senior);
           }
        }
        
        // Sort the topFiveSwimmers by their best time for the specified length
        Collections.sort(topFiveSwimmers, (swimmer1, swimmer2) ->
                Double.compare(getBestTime(swimmer1, discipline, length), getBestTime(swimmer2, discipline, length)));
                
        // Take only the top five swimmers
        if (topFiveSwimmers.size() > 5) { 
            return new ArrayList<>(topFiveSwimmers.subList(0, 5)); // If it is greater than 5, it returns the trimmed sublist containing only the top five swimmers.
        } else {
            return topFiveSwimmers;
       }
    }
    
   // method for finding a competitors best time for a discipline
   private double getBestTime(Competitor competitor, String discipline, int length){
   double bestTime = Double.MAX_VALUE; 
      
      for(CompetitionResult result : competitor.getCompetitionResults()){
         if(result.getDiscipline().equals(discipline) && result.getLength() == length && result.getTime() < bestTime){
         bestTime = result.getTime(); 
       }
     }
      
      for(TrainingResult result : competitor.getTrainingResults()){
         if(result.getDiscipline().equals(discipline) && result.getLength() == length && result.getTime() < bestTime){
         bestTime = result.getTime(); 
       }
     }
     
   return bestTime; 
  }
}
