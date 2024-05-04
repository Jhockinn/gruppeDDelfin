import java.util.ArrayList; 
import java.util.Scanner; 

public class Competition{

// ArrayLists for youth and senior competitors 
ArrayList<Members> youthCompetitors = new ArrayList<Members>(); 
ArrayList<Members> seniorCompetitors = new ArrayList<Members>(); 
Scanner scan = new Scanner(System.in); 

// Method for adding new competitors 
public void addCompetitor(){
   System.out.println("What is the members name?"); 
   String name = scan.next(); 
   System.out.println("What is the members age?"); 
   int age = scan.nextInt(); 
   System.out.println("How many swimming disciplines does the member participate in?"); 
   int choice = scan.nextInt(); 
   
   for(int i=0; i<choice; i++){
   System.out.println("Enter the swimming disciplines one at a time: ");
   String discipline = scan.next();  
   
   Competitor competitor = new Competitor(age, name);
   competitor.setDiscipline(discipline); 
   
   if(competitor.getAge()<18){
      youthCompetitors.add(competitor);
      System.out.println("These are the youth competitors: "); 
      showYouthCompetitors();
   }else if(competitor.getAge()>=18){
      seniorCompetitors.add(competitor);
        System.out.println("These are the senior competitors: ");
      showSeniorCompetitors();
   }else{
      System.out.println("Could not add member to the competitive list due to not active"); 
      }
   }
} 

// method for showing youth competitors 
public void showYouthCompetitors(){
   
   for(Members competitor : youthCompetitors){
      System.out.print(" Name: " + competitor.getName()); 
      System.out.print(" Age: " + competitor.getAge()); 
      System.out.print(" Disciplines " + competitor.getDiscipline());     
   }
}

// method for showing senior competitors 
public void showSeniorCompetitors(){
  
   for(Members competitor : seniorCompetitors){
      System.out.print(" Name: " + competitor.getName()); 
      System.out.print(" Age: " + competitor.getAge()); 
      System.out.print(" Disciplines " + competitor.getDiscipline()); 
   }
}

// method for sorting members from memberList to a competitorList
public void sortCompetitors(){

for(int i=0; i<MemberList.size(); i++){
   Member member = MemberList.get(i); 
   if(member.isCompetitor() && member.getAge()<18){
      Competitor youthCompetitor = new Competitor(member.getAge(), member.getName(), member.getPrice());
       youthCompetitors.add(member);
   }else if(member.isCompetitor() && member.getAge()>=18){
      Competitor seniorCompetitor = new Competitor(member.getAge(), member.getName(), member.getPrice()); 
       seniorCompetitors.add(member);
   }else{
   System.out.println("Could not sort competitors");
   } 
  }
 }
}

/*public void registerSwimmingResults(){
   System.out.println("Should the swimmer be registred as a youth or senior competitor? (1 for youth, 2 for senior");
      int type = scan.nextInt(); 
      
         if(type == 1){
         System.out.println("Please enter the number of the swimmer"); 
            int number = scan.nextInt(); 
         
         System.out.println("Please enter the discipline"); 
         //String dicipline = scan
         
         
         } */
    




}