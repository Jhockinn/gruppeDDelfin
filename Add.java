import java.util.*;
import java.io.*;

public class Add{
    MainTest main = new MainTest();
    Random rand = new Random();
    //Adds the diffrent classes to the memberList (arraylist) 
    public void add() {
        for (int x = 0; x <= 100; x++) {
            /*int age = rand.nextInt(6,18); 
            String name = "Jeff";
            double price = rand.nextInt(400,10000);
            main.memberList.add(new Youth(age, name, price));*/
            main.memberList.add(new Youth());
        }
        for (int x = 0; x <= 100; x++) {
            /*int age = rand.nextInt(18,60); 
            String name = "Hey";
            double price = rand.nextInt(400,10000);
            main.memberList.add(new Senior(age,name,price));
            */
            main.memberList.add(new Senior());
        }
        for (int x = 0; x <= 50; x++) {
            //int age = rand.nextInt(60,100); 
            //String name = "Pain";
            //double price = rand.nextInt(400,10000);
            //main.memberList.add(new Elder(age,name,price));
            main.memberList.add(new Elder());
        }
    }
    //the comparator gives you negative, equal(0) or positive int values 
    //which indicates to the collection.sort where to arrange the given type in the list 
    public void sort(){
    Collections.sort(main.memberList, new Comparator<Members>() {
                @Override
                public int compare(Members p1, Members p2) {
                    return p1.getAge() - p2.getAge();
                }
            });
    }

}