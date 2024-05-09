import java.util.*;
import java.io.*;
public class Competitive{
   Random rand = new Random();
   ArrayList<String> disci = new ArrayList<String>(); 
   public Competitive(){
   disci.add("Butterfly");
   disci.add("Freestyle");
   disci.add("Backstroke");
   disci.add("Breaststroke");
   }
   // Change boolean value at random 
   public void compe(ArrayList<Members> list){
      for(Members members : list){
         int random = rand.nextInt(1,10);
            if(random>5){
               members.setCompetitor(false);
            }
            else{
               int random1 = rand.nextInt(0,4);
               members.setCompetitor(true);
               members.setDiscipline(disci.get(random1));
            }
      }
   }
}