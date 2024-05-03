import java.util.*;
public class Youth extends Members{
   Random rand = new Random();
   public Youth(int age,String name,double price){
   super(age,name,price);
   }
   public void change(){
   super.setAge(rand.nextInt(6,18)); 
   super.setName("Jeff");
   super.setPrice(rand.nextInt(400,10000));
   }
   
   
}