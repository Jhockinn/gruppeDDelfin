import java.util.*;
import java.io.*;

public class Add{
    ArrayList<String> nameList = new ArrayList<String>();
    MainTest main = new MainTest();
    Random rand = new Random();
    int RandomName = 0;
    //Adds the diffrent classes to the memberList (arraylist) 
    public void add() {
        for (int x = 0; x <= 100; x++) {
            RandomName = rand.nextInt(185);
            int age = rand.nextInt(6,18); 
            String name = nameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            main.memberList.add(new Youth(age, name, price));
           
            //main.memberList.add(new Youth());
        }
        for (int x = 0; x <= 100; x++) {
            RandomName = rand.nextInt(185);
            int age = rand.nextInt(18,60); 
            String name = nameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            main.memberList.add(new Senior(age,name,price));
            
            //main.memberList.add(new Senior());
        }
        for (int x = 0; x <= 50; x++) {
            RandomName = rand.nextInt(185);
            int age = rand.nextInt(60,100); 
            String name = nameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            main.memberList.add(new Elder(age,name,price));
            
            //main.memberList.add(new Elder());
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
    public void addNames(){
    Collections.addAll(nameList, "Sophia", "Liam", "Emma", "Noah", "Olivia",
            "Ava", "Isabella", "Mia", "Amelia", "Charlotte",
            "Olga", "Anna", "Maria", "Elijah", "Natalia",
            "Irina", "Ekaterina", "Sofia", "Tatiana", "Anastasia",
            "Sophie", "David", "Emma", "Lea", "Julian",
            "Mia", "Laura", "Sara", "Lina", "Emilia",
            "Ainhoa", "María", "Lucía", "William", "Marta",
            "Paula", "Julia", "Andrea", "Alba", "Laura",
            "Amélie", "Chloé", "Léa", "Manon", "Inès",
            "Camille", "Ethan", "Lucie", "Louise", "Anna",
            "Emma", "Sara", "Elin", "Ella", "Maja",
            "Olivia", "Adam", "Alma", "Ida", "Emilia",
            "Hannah", "Jack", "Mia", "Sofia", "Anna",
            "Lea", "Laura", "Ella", "Mila", "Sophie",
            "Emma", "Léa", "Manon", "Zoé", "Inès",
            "Chloé", "Luna", "Jade", "Camille", "Julia",
            "Emma", "Max", "Mia", "Anna", "Ella",
            "Alma", "Olivia", "Eva", "Ida", "Emilia",
            "Luisa", "Sophia", "Amelie", "Mia", "Emma",
            "Hanna", "Luke", "Leonie", "Emilia", "Anna",
            "Sophie", "Emma", "Lena", "Hannah", "Lea",
            "Anna", "Mia", "Sara", "Emilia", "Laura",
            "Elena", "Sophia", "Mia", "Emma", "Olivia",
            "Sara", "Eva", "Anna", "Luna", "Julia",
            "Sophie", "Elijah", "Olivia", "Mia", "Ella",
            "Eva", "Lea", "Lina", "Laura", "Sofia",
            "Mia", "Theo", "Sophie", "Ella", "Olivia",
            "Sara", "Emilia", "Anna", "Lena", "Maja",
            "Alexander", "James", "Benjamin", "Daniel", "Matthew",
            "Michael", "Ethan", "William", "Alexander", "Daniel",
            "Matthew", "David", "Joseph", "Carter", "John",
            "Christopher", "Ryan", "Thomas", "Christian", "Anthony",
            "Joshua", "Nicholas", "Elijah", "Andrew", "Isaac",
            "Jonathan", "Samuel", "Tyler", "Lucas", "Gavin",
            "Nathan", "Brandon", "Jackson", "Dylan", "Caleb",
            "Logan", "Luke", "Mason", "Evan", "Jack",
            "Justin", "Jordan", "Jason", "Aaron", "Jeremiah",
            "Henry");
         }
}