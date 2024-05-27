import java.util.*;
import java.io.*;
import java.time.format.*;
import java.time.*;
   
   public class Competitive{
      Random rand = new Random();
      Scanner scan = new Scanner(System.in);
      ArrayList<String> disci = new ArrayList<String>(); 
         
         // Constructor Initializes dicipline list.
         public Competitive(){
            disci.add("Butterfly");
            disci.add("Freestyle");
            disci.add("Backstroke");
            disci.add("Breaststroke");
         }
         // Change boolean value at random 
         public void compe(ArrayList<Members> list){
            for(Members members : list){
               int random1 = rand.nextInt(1,10);
                  if(random1>5){
                     members.setCompetitor(false);
                  }
                  else{
                     int random2 = rand.nextInt(0,4);
                     members.setCompetitor(true);
                     members.setDiscipline(disci.get(random2));
                  }
         }
         }
   }
