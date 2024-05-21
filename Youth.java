import java.util.*;
public class Youth extends Members{
  /* int age = rand.nextInt(6,18); 
   String name = "Jeff";
   double price = rand.nextInt(400,10000);
   
      public Youth(){
         setAge(age);
         setName(name);
         setPrice(price); 
      }*/
      //boolean youth;
      int memberPrice = 1000;
      public Youth(int age,String name){
         super(age,name);
         setPrice(rand.nextInt(400, 10000));
         super.restan(memberPrice);
      } 
}