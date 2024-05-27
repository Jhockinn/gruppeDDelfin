import java.util.*;
import java.io.*;
public class Active{
   Competitive compet = new Competitive();
   Random rand = new Random();
      // Change boolean value at random to make active and passive.
      public void active(ArrayList<Members> list){
         for(Members members : list){
            int random = rand.nextInt(1,10);
               if(random>8){
                  members.setActive(false);
               }
               else{
                  members.setActive(true);
   
               }
               //Random competitive if they are active,
               int random1 = rand.nextInt(1,10);
               if(random1>5 || members.getActive() == false){
                        members.setCompetitor(false);
               }
               else{
                   int random2 = rand.nextInt(0,4);
                   members.setCompetitor(true);
                   members.setDiscipline(compet.disci.get(random2));
               }
               
               if(members.getActive() == false){
                  if(members.getPrice() > 500){
                     members.setRestance(false);
                  }
                  else{
                     members.setRestance(true);
                  }
               }
         }
      }
}