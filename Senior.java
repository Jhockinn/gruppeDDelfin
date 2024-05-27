import java.util.*;
public class Senior extends Members{

    int memberPrice = 1600;
    
    public Senior(int age,String name){
       super(age,name);
       setPrice(rand.nextInt(400, 10000));
       super.restan(memberPrice);
       
    }
}