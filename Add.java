import java.util.*;
import java.io.*;

public class Add{
    ArrayList<Members> MemberList = new ArrayList<Members>();
    Random rand = new Random();
    public void add() {
        for (int x = 0; x <= 100; x++) {
            int age = rand.nextInt(6,18); 
            String name = "Jeff";
            double price = rand.nextInt(400,10000);
            MemberList.add( new Youth(age, name, price));
        }
        for (int x = 0; x <= 100; x++) {
            int age = rand.nextInt(18,60); 
            String name = "Hey";
            double price = rand.nextInt(400,10000);
            MemberList.add(x, new Senior(age,name,price));
        }
        for (int x = 0; x <= 50; x++) {
            int age = rand.nextInt(60,100); 
            String name = "Pain";
            double price = rand.nextInt(400,10000);
            MemberList.add(x, new Elder(age,name,price));
        }
    }

}