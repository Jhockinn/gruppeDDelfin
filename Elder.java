import java.util.*;

public class Elder extends Senior{
   /*int age = rand.nextInt(60,100); 
   String name = "Pain";
   double price = rand.nextInt(400,10000);
   
      public Elder(){
         setAge(age);
         setName(name);
         setPrice(price); 
      }*/
   int memberPrice = 1200; 
   
   public Elder(int age,String name){
      super(age,name);
      setPrice(rand.nextInt(400, 10000));
      super.restan(memberPrice);
   }  
}