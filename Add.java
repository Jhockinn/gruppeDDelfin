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
    String disci;
    String discipline;
    String name1;
    // add member to list. 
    public void addNewMember() {
        Scanner scanner = new Scanner(System.in);
        //name
        System.out.println("Enter the name of the new member:");
        String name = scanner.nextLine();
        //age 
        System.out.println("Enter the year of birth");
        int memberAge = Integer.parseInt(scanner.nextLine());
        //gender
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
       
       //Competitor
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
        
        //active
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
       
       if(competitive == true){
       do{
           System.out.println("Choose Discipline");
           System.out.println("Butterfly, Freestyle, Backstroke, Breaststroke");
           disci = scan.nextLine();
        if(disci.equals("Butterfly") || disci.equals("Freestyle")|| disci.equals("Backstroke")|| disci.equals("Breaststroke")){
            if(disci.equals("Freestyle")){
               discipline = "Freestyle";
            }
            if(disci.equals("Backstroke")){
               discipline = "Backstroke";
            }
            if(disci.equals("Breaststroke")){
               discipline = "Breaststroke";
            }
            else{
               discipline = "Butterfly"; 
            }
         }else{
         System.out.println("Sorry, wrong input try again!");
         }
       }while(!disci.equals("Butterfly") && !disci.equals("Freestyle") && !disci.equals("Backstroke")&& !disci.equals("Breaststroke"));
       
       }


        // Check if the member already exists
        boolean memberExists = false;
        for (Members member : memberList) {
            if (member.getName().equalsIgnoreCase(name) &&
                member.getAge() == member.year-memberAge &&
                member.getGender() == gender &&
                member.getCompetitor() == competitive) {
                memberExists = true;
                System.out.println("This member already exists.");
                break;
            }
        } 
        //Creates member if member doesnt exist.
        if(!memberExists){
           memberList.add(new Members(memberAge, name));
           memberList.get(memberList.size()-1).setID(memberList.size());
           memberList.get(memberList.size()-1).setDiscipline(discipline);
           memberList.get(memberList.size()-1).setAge(memberAge);
           memberList.get(memberList.size()-1).setGender(gender);
           memberList.get(memberList.size()-1).setCompetitor(competitive);
           memberList.get(memberList.size()-1).setActive(acti);
           memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
        }
      }
    
    //Adds the diffrent classes to the memberList (arraylist) 
    
    public void add(){
        
        for(int x = 0; x <=100;x++){
            int rando = rand.nextInt(2)+1;
               if(rando == 1){
                  name1 = boyNameList.get(rand.nextInt(100));
               }
               else{
                  name1= girlNameList.get(rand.nextInt(87));
               }
         int age = rand.nextInt(2006,2018); 
         memberList.add(new Elder(age,name1));
         memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
         memberList.get(memberList.size()-1).setAge(age);
         memberList.get(memberList.size()-1).setID(memberList.size());
            if(boyNameList.contains(name1)){
               memberList.get(memberList.size()-1).setGender(true);
            }
            else{
               memberList.get(memberList.size()-1).setGender(false);   
            }
     
       }

       for(int x = 0; x <=148;x++){
            int rando = rand.nextInt(2)+1;
               if(rando == 1){
                  name1 = boyNameList.get(rand.nextInt(100));
               }
               else{
                  name1= girlNameList.get(rand.nextInt(87));
               }
         int age = rand.nextInt(1940,2005); 
         memberList.add(new Elder(age,name1));
         memberList.get(memberList.size()-1).setPrice(rand.nextInt(400,10000));
         memberList.get(memberList.size()-1).setAge(age);
         memberList.get(memberList.size()-1).setID(memberList.size());
            if(boyNameList.contains(name1)){
               memberList.get(memberList.size()-1).setGender(true);
            }
            else{
               memberList.get(memberList.size()-1).setGender(false);   
            }
     
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