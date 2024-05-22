import java.util.*;
public class Youth extends Members{

      int memberPrice = 1000;
      
      public Youth(int age,String name){
         super(age,name);
         setPrice(rand.nextInt(400, 10000));
         super.restan(memberPrice);
      } 
}