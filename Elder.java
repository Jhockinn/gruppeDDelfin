import java.util.*;

public class Elder extends Senior{
  
   int memberPrice = 1200; 
   
   public Elder(int age,String name){
      super(age,name);
      setPrice(rand.nextInt(400, 10000));
      super.restan(memberPrice);
   }  
}