import java.util.*;
import java.io.*;

public class Add{
    ArrayList<String> boyNameList = new ArrayList<String>();
    ArrayList<String> girlNameList = new ArrayList<String>();
    ArrayList<Members> memberList = new ArrayList<Members>();
    Random rand = new Random();
    int RandomName = 0;
    int count = -1; 
    //Adds the diffrent classes to the memberList (arraylist) 
    public void add() {
        for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(100); //Har lavet 2 arrays med pige og drenge navne, det her giver et random nummber til at vælge i dem
            int age = rand.nextInt(2006,2018); // setAge i Members, tage nuværende år og minuser med fødselsår, og giver en alder. 
            String name = boyNameList.get(RandomName); // random navn 
            double price = rand.nextInt(400,10000); // ved ikke helt hvad den skal bruges til endnu xD 
            memberList.add(new Youth(age, name, price)); // intialisere objekter 
            memberList.get(count).setAge(age); // ændre alder ud fra setAge metoden. 
            memberList.get(x).setBoy(true);  //siger om det er en dreng eller ej. 
           
            //memberList.add(new Youth());
        }
          for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(100);
            int age = rand.nextInt(2006,2018);
            String name = girlNameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            memberList.add(new Youth(age, name, price));
            memberList.get(count).setAge(age);
            memberList.get(count).setBoy(false);
           
            //memberList.add(new Youth());
        }
        for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(100);
            int age = rand.nextInt(1965,2005); 
            String name = boyNameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            memberList.add(new Senior(age,name,price));
            memberList.get(count).setAge(age);
            memberList.get(count).setBoy(true);
            
            //memberList.add(new Senior());
        }
        for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(100);
            int age = rand.nextInt(1965,2005); 
            String name = girlNameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            memberList.add(new Senior(age,name,price));
            memberList.get(count).setAge(age);
            memberList.get(count).setBoy(false);
            
            //memberList.add(new Senior());
        }
        for (int x = 0; x <= 25; x++) {
            count++;
            RandomName = rand.nextInt(100);
            int age = rand.nextInt(1940,1964); 
            String name = boyNameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            memberList.add(new Elder(age,name,price));
            memberList.get(count).setAge(age);
            memberList.get(count).setBoy(true);
            //memberList.add(new Elder());
        }
         for (int x = 0; x <= 25; x++) {
            count++;
            RandomName = rand.nextInt(100);
            int age = rand.nextInt(1940,1964); 
            String name = girlNameList.get(RandomName);
            double price = rand.nextInt(400,10000);
            memberList.add(new Elder(age,name,price));
            memberList.get(count).setAge(age);
            memberList.get(count).setBoy(false);
            //memberList.add(new Elder());
        }
    }
    //the comparator gives you negative, equal(0) or positive int values 
    //which indicates to the collection.sort where to arrange the given type in the list 
    public void sort(){
    Collections.sort(memberList, new Comparator<Members>() {
                @Override
                public int compare(Members p1, Members p2) {
                    return p1.getAge() - p2.getAge();
                }
            });
    }
    
    public String chooseGender(Members member){
         if(member.getBoy() == true){
            return "Male";
         }else{
            return "Female";
         }
    }
    
    public void addNames(){
    // boys names add to arraylist
    Collections.addAll(boyNameList, "Jacob", "Michael", "Ethan", "Alexander", "William", 
    "James", "Daniel", "Benjamin", "Christopher", "Matthew", 
    "Andrew", "Joseph", "Logan", "David", "Anthony", 
    "Joshua", "Samuel", "John", "Ryan", "Nathan", 
    "Jonathan", "Christian", "Liam", "Dylan", "Nicholas", 
    "Gabriel", "Brandon", "Tyler", "Gavin", "Evan", 
    "Luke", "Isaac", "Isaiah", "Owen", "Carter", 
    "Caleb", "Wyatt", "Henry", "Jack", "Sebastian", 
    "Jaxon", "Julian", "Levi", "Zachary", "Austin", 
    "Connor", "Elijah", "Hunter", "Cameron", "Thomas", 
    "Jordan", "Aaron", "Oliver", "Aiden", "Mason", 
    "Charles", "Eli", "Adam", "Colton", "Landon", 
    "Adrian", "Sean", "Justin", "Bryan", "Carson", 
    "Nolan", "Brian", "Kevin", "Blake", "Jeremy", 
    "Timothy", "Marcus", "Jaden", "Brayden", "Dominic", 
    "Xavier", "Parker", "Chase", "Collin", "Jesse", 
    "Tristan", "Kaden", "Kyle", "Antonio", "Miguel", 
    "Gage", "Alejandro", "Steven", "Hudson", "Riley", 
    "Edward", "Joel", "Alan", "Joey", "Maxwell", 
    "Ryder", "Cooper", "Eric", "Ashton", "Trevor");
    //girl names added to arraylist
    Collections.addAll(girlNameList,"Emma", "Olivia", "Ava", "Isabella", "Sophia", 
    "Mia", "Charlotte", "Amelia", "Harper", "Evelyn", 
    "Abigail", "Emily", "Elizabeth", "Mila", "Ella", 
    "Avery", "Sofia", "Camila", "Aria", "Scarlett", 
    "Victoria", "Madison", "Luna", "Grace", "Chloe", 
    "Penelope", "Layla", "Riley", "Zoey", "Nora", 
    "Lily", "Eleanor", "Hannah", "Lillian", "Addison", 
    "Aubrey", "Ellie", "Stella", "Natalie", "Zoe", 
    "Leah", "Hazel", "Violet", "Aurora", "Savannah", 
    "Audrey", "Brooklyn", "Bella", "Claire", "Skylar", 
    "Lucy", "Paisley", "Everly", "Anna", "Caroline", 
    "Nova", "Genesis", "Emilia", "Kennedy", "Samantha", 
    "Maya", "Willow", "Kinsley", "Naomi", "Aaliyah", 
    "Elena", "Sarah", "Ariana", "Allison", "Gabriella", 
    "Alice", "Madelyn", "Cora", "Ruby", "Eva", 
    "Serenity", "Autumn", "Adeline", "Hailey", "Gianna", 
    "Valentina", "Isla", "Eliana", "Quinn", "Neveah", 
    "Ivy", "Sadie", "Piper", "Lydia", "Alexa", 
    "Josephine", "Emery", "Julia", "Delilah", "Arianna", 
    "Vivian", "Kaylee", "Sophie", "Brielle", "Madeline"
    );
         }
}