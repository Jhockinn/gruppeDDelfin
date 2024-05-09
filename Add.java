import java.util.*;
import java.io.*;

public class Add{
    ArrayList<String> boyNameList = new ArrayList<String>();
    ArrayList<String> girlNameList = new ArrayList<String>();
    ArrayList<Members> memberList = new ArrayList<Members>();
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int RandomName = 0;
    int count = -1; 
    boolean gender;
    boolean competitive;
    boolean acti;
    String choice;
    String compe;
    String active;
    // add member to list. 
    /*public void addMember(){
       String choice;
       String compe;
       String active;
       System.out.println("Write first name");
       String name = scan.nextLine();
       do{
       System.out.println("Write gender male or female");
       choice = scan.nextLine();
         if(choice.equals("male") || choice.equals("female")){
            if(choice.equals("male")){
               gender = true;
            }
            else{
               gender = false; 
            }
         }else{
            System.out.println("Please try to write it again");
         }
       }while(!choice.equals("male") && !choice.equals("female"));
       System.out.println("Write birthyear");
       int age = scan.nextInt();
       System.out.println("Write money added to account");
       int price = scan.nextInt();
       do{
       System.out.println("are you regular or competitive");
       scan.nextLine();
       compe = scan.nextLine();
          if(compe.equals("regular") || compe.equals("competitive")){
            if(compe.equals("competitive")){
               competitive = true;
            }
            else{
               competitive = false; 
            }
         }else{
         System.out.println("Sorry, wrong input try again!");
         }
       }while(!compe.equals("regular") && !compe.equals("competitive"));
       
       do{
       System.out.println("are you active or passive");
       active = scan.nextLine();
        if(active.equals("active") || active.equals("passive")){
            if(active.equals("active")){
               acti = true;
            }
            else{
               acti = false; 
            }
         }else{
         System.out.println("Sorry, wrong input try again!");
         }
       }while(!active.equals("active") && !active.equals("passive"));

       memberList.add(new Members(age, name, price));
       memberList.get(memberList.size()-1).setAge(age);
       memberList.get(memberList.size()-1).setBoy(gender);
       memberList.get(memberList.size()-1).setCompetitor(competitive);
       memberList.get(memberList.size()-1).setActive(acti);
    
    }*/
    public void addNewMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the new member:");
        String memberName = scanner.nextLine();

        do{
          System.out.println("Write gender male or female");
          choice = scan.nextLine();
             if(choice.equals("male") || choice.equals("female")){
                if(choice.equals("male")){
                  gender = true;
             }
            else{
               gender = false; 
            }
         }else{
            System.out.println("Please try to write it again");
         }
       }while(!choice.equals("male") && !choice.equals("female"));
       do{
       System.out.println("are you regular or competitive");
       compe = scan.nextLine();
          if(compe.equals("regular") || compe.equals("competitive")){
            if(compe.equals("competitive")){
               competitive = true;
            }
            else{
               competitive = false; 
            }
         }else{
         System.out.println("Sorry, wrong input try again!");
         }
       }while(!compe.equals("regular") && !compe.equals("competitive"));


        System.out.println("Enter the age of the member:");
        int memberAge = Integer.parseInt(scanner.nextLine());

        // Check if the member already exists
        boolean memberExists = false;
        int ID = memberList.size()+1;
        for (Members member : memberList) {
            if (member.getName().equalsIgnoreCase(memberName) &&
                member.getAge() == memberAge &&
                member.getGender() == gender &&
                member.getCompetitor() == competitive) {
                memberExists = true;
                System.out.println("This member already exists.");
                break;
            }
        } 
        int price = 1000;
        if(!memberExists){
           memberList.add(new Members(memberAge, memberName));
        }
      }
    
    //Adds the diffrent classes to the memberList (arraylist) 
    public void add() {
        for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(100); //Har lavet 2 arrays med pige og drenge navne, det her giver et random nummber til at vælge i dem
            int age = rand.nextInt(2006,2018); // setAge i Members, tage nuværende år og minuser med fødselsår, og giver en alder. 
            String name = boyNameList.get(RandomName); // random navn 
            memberList.add(new Youth(age, name)); // intialisere objekter 
            memberList.get(x).setPrice(rand.nextInt(400,10000)); // ved ikke helt hvad den skal bruges til endnu xD 
            memberList.get(memberList.size()-1).setAge(age); // ændre alder ud fra setAge metoden. 
            memberList.get(x).setGender(true);  //siger om det er en dreng eller ej. 
            memberList.get(x).setID(memberList.size()+1);
            //memberList.add(new Youth());
        }
          for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(87);
            int age = rand.nextInt(2006,2018);
            String name = girlNameList.get(RandomName);
            memberList.add(new Youth(age, name));
            memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setGender(false);
            memberList.get(memberList.size()-1).setID(memberList.size()+1);
            //memberList.add(new Youth());
        }
        for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(100);
            int age = rand.nextInt(1965,2005); 
            String name = boyNameList.get(RandomName);
            memberList.add(new Senior(age,name));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
            memberList.get(memberList.size()-1).setGender(true);
            memberList.get(memberList.size()-1).setID(memberList.size()+1);
            //memberList.add(new Senior());
        }
        for (int x = 0; x <= 50; x++) {
            count++;
            RandomName = rand.nextInt(87);
            int age = rand.nextInt(1965,2005); 
            String name = girlNameList.get(RandomName);
            memberList.add(new Senior(age,name));
            memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setGender(false);
            memberList.get(memberList.size()-1).setID(memberList.size()+1);
            //memberList.add(new Senior());
        }
        for (int x = 0; x <= 25; x++) {
            count++;
            RandomName = rand.nextInt(100);
            int age = rand.nextInt(1940,1964); 
            String name = boyNameList.get(RandomName);
            memberList.add(new Elder(age,name));
            memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setGender(true);
            memberList.get(memberList.size()-1).setID(memberList.size()+1);
            //memberList.add(new Elder());
        }
         for (int x = 0; x <= 25; x++) {
            count++;
            RandomName = rand.nextInt(87);
            int age = rand.nextInt(1940,1964); 
            String name = girlNameList.get(RandomName);
            memberList.add(new Elder(age,name));
            memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setGender(false);
            memberList.get(memberList.size()-1).setID(memberList.size()+1);
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
         if(member.getGender() == true){
            return "Male  ";
         }else{
            return "Female";
         }
    }
    
    public void addNames(){
    // boys names add to arraylist
    Collections.addAll(boyNameList, 
      "Michael ", "Ethan   ", "William ", "James   ", "David   ", 
      "Anthony ", "Joshua  ", "Samuel  ", "John    ", "Ryan    ", 
      "Nathan  ", "Liam    ", "Dylan   ", "Brandon ", "Tyler   ", 
      "Gavin   ", "Evan    ", "Luke    ", "Isaac   ", "Owen    ", 
      "Caleb   ", "Wyatt   ", "Henry   ", "Jack    ", "Julian  ", 
      "Levi    ", "Austin  ", "Connor  ", "Hunter  ", "Thomas  ", 
      "Jordan  ", "Aaron   ", "Oliver  ", "Aiden   ", "Mason   ", 
      "Charles ", "Eli     ", "Adam    ", "Colton  ", "Adrian  ", 
      "Justin  ", "Bryan   ", "Carson  ", "Nolan   ", "Brian   ", 
      "Kevin   ", "Blake   ", "Jeremy  ", "Marcus  ", "Jaden   ", 
      "Xavier  ", "Parker  ", "Chase   ", "Collin  ", "Jesse   ", 
      "Kaden   ", "Kyle    ", "Steven  ", "Riley   ", "Edward  ", 
      "Joel    ", "Alan    ", "Joey    ", "Eric    ", "Trevor  ", 
      "Finn    ", "Leo     ", "Max     ", "Kai     ", "Alex    ", 
      "Luke    ", "Jake    ", "Derek   ", "Brett   ", "Cody    ", 
      "Grant   ", "Jared   ", "Oscar   ", "Rocco   ", "Shane   ", 
      "Travis  ", "Wesley  ", "Zander  ", "Anton   ", "Archie  ", 
      "Barry   ", "Billy   ", "Bruce   ", "Curtis  ", "Damian  ", 
      "Donald  ", "Dorian  ", "Eugene  ", "Felix   ", "Hector  ", 
      "Issac   ", "Jasper  ", "Jeremy  ", "Jonah   ", "Julius  ", 
      "Keegan  ", "Kieran  ", "Landon  ", "Martin  ", "Murray  ");
    //girl names added to arraylist
    Collections.addAll(girlNameList,
      "Emma    ", "Olivia  ", "Ava     ", "Sophia  ", "Mia     ", 
      "Emily   ", "Ella    ", "Grace   ", "Chloe   ", "Nora    ", 
      "Lily    ", "Hannah  ", "Lillian ", "Aubrey  ", "Leah    ", 
      "Hazel   ", "Violet  ", "Anna    ", "Zoe     ", "Natalie ", 
      "Zoey    ", "Lila    ", "Sarah   ", "Audrey  ", "Maya    ", 
      "Lucy    ", "Amelia  ", "Alice   ", "Ruby    ", "Sadie   ", 
      "Stella  ", "Ivy     ", "Clara   ", "Nova    ", "Brielle ", 
      "Piper   ", "Lydia   ", "Emery   ", "Delilah ", "Aurora  ", 
      "Valerie ", "Eva     ", "Skyler  ", "Serenity", "Autumn  ", 
      "Adeline ", "Reagan  ", "Elise   ", "Michelle", "Angelina", 
      "Amber   ", "Ellie   ", "Miriam  ", "Arielle ", "Lena    ", 
      "Gracie  ", "Brynn   ", "Eliza   ", "Molly   ", "Annie   ", 
      "Rowan   ", "Harmony ", "Summer  ", "Rylee   ", "Sasha   ", 
      "Raegan  ", "Diana   ", "Tessa   ", "Camille ", "Hayden  ", 
      "Laura   ", "Kylee   ", "Lacey   ", "Aimee   ", "Aspen   ", 
      "Iris    ", "Elaina  ", "Leona   ", "Maeve   ", "Noelle  ", 
      "Rory    ", "Marie   ", "Pearl   ", "Juniper ", "Bianca  ", 
      "Sylvie  ", "Ginny   "
    );
         }
}