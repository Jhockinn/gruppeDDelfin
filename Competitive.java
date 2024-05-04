import java.util.*;
import java.io.*;
public class Competitive{
   Random rand = new Random();
   MainTest main = new MainTest();
   // Change boolean value at random 
   public void compe(){
      for(Members members : main.memberList){
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