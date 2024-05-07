import java.util.*;
import java.io.*;
public class Competitive{
   Random rand = new Random();
   // Change boolean value at random 
   public void compe(ArrayList<Members> list){
      for(Members members : list){
         int random = rand.nextInt(1,10);
            if(random>5){
               members.setCompetitor(false);
            }
            else{
               members.setCompetitor(true);
            }
      }
   }
}