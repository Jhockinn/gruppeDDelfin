import java.util.ArrayList;
import java.util.Random;  
import java.util.Scanner; 

public class Competition{

// ArrayLists for youth and senior competitors 
public ArrayList<Competitor> youthCompetitors = new ArrayList<Competitor>(); 
public ArrayList<Competitor> seniorCompetitors = new ArrayList<Competitor>(); 
// ArratList for memberList
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
   String discipline = scan.next();  
   disciplines.add(discipline);
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
      System.out.print(" Disciplines " + competitor.getDiscipline());  
       System.out.println(); 
   }
}

// method for sorting members from memberList to a competitorList
public void sortCompetitors(){

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
 
 
 
}

