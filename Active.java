import java.util.*;
import java.io.*;
public class Active{
   Random rand = new Random();
   MainTest main = new MainTest();
   // Change boolean value at random 
   public void active(){
      for(Members members : main.memberList){
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