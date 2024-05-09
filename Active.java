import java.util.*;
import java.io.*;
public class Active{
   Random rand = new Random();
   // Change boolean value at random 
   public void active(ArrayList<Members> list){
      for(Members members : list){
         int random = rand.nextInt(1,10);
            if(random>8){
               members.setActive(false);
            }
            else{
               members.setActive(true);
            }
      }
   }
}