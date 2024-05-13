  import java.util.*;
  import java.io.*;
  public class Chairman{
    ArrayList<String> boyNameList = new ArrayList<String>();
    ArrayList<String> girlNameList = new ArrayList<String>();
    ArrayList<Members> memberList = new ArrayList<Members>();
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int RandomName = 0;
    boolean gender;
    boolean competitive;
    boolean acti;
    String choice;
    String compe;
    String active;
    String disci;
    String discipline;
    String name1;
    // Add member to list
    public void addNewMember() {
        Scanner scanner = new Scanner(System.in);
        // Name
        System.out.println("Enter the name of the new member:");
        String name = scanner.nextLine();
        // Age
        System.out.println("Enter the year of birth:");
        int memberAge = Integer.parseInt(scanner.nextLine());
        // Gender
        do {
            System.out.println("Write gender (male or female):");
            choice = scan.nextLine();
            if (choice.equals("male") || choice.equals("female")) {
                gender = choice.equals("male");
            } else {
                System.out.println("Please try to write it again.");
            }
        } while (!choice.equals("male") && !choice.equals("female"));
        
            // Active
        do {
            System.out.println("Are you active or passive?");
            active = scan.nextLine();
            if (active.equals("active") || active.equals("passive")) {
                acti = active.equals("active");
            } else {
                System.out.println("Sorry, wrong input. Try again!");
            }
        } while (!active.equals("active") && !active.equals("passive"));

        // Competitor
        if(acti == true){
        do {
            System.out.println("Are you regular or competitive?");
            compe = scan.nextLine();
            if (compe.equals("regular") || compe.equals("competitive")) {
                competitive = compe.equals("competitive");
            } else {
                System.out.println("Sorry, wrong input. Try again!");
            }
         } while (!compe.equals("regular") && !compe.equals("competitive"));


        if (competitive) {
            do {
                System.out.println("Choose Discipline");
                System.out.println("Butterfly, Freestyle, Backstroke, Breaststroke");
                disci = scan.nextLine();
                if (disci.equals("Butterfly") || disci.equals("Freestyle") || disci.equals("Backstroke") || disci.equals("Breaststroke")) {
                    discipline = disci;
                } else {
                    System.out.println("Sorry, wrong input. Try again!");
                }
            } while (!disci.equals("Butterfly") && !disci.equals("Freestyle") && !disci.equals("Backstroke") && !disci.equals("Breaststroke"));
        }
        }

        // Check if the member already exists
        boolean memberExists = false;
        for (Members member : memberList) {
            if (member.getName().equalsIgnoreCase(name) &&
                member.getAge() == member.year - memberAge &&
                member.getGender() == gender &&
                member.getCompetitor() == competitive) {
                memberExists = true;
                System.out.println("This member already exists.");
                break;
            }
        }

        // Creates member if member doesn't exist.
        if (!memberExists) {
            memberList.add(new Members(memberAge, name));
            memberList.get(memberList.size() - 1).setID(memberList.size() - 1);
            memberList.get(memberList.size() - 1).setDiscipline(discipline);
            memberList.get(memberList.size() - 1).setAge(memberAge);
            memberList.get(memberList.size() - 1).setGender(gender);
            memberList.get(memberList.size() - 1).setCompetitor(competitive);
            memberList.get(memberList.size() - 1).setActive(acti);
            memberList.get(memberList.size() - 1).setPrice(rand.nextInt(400, 10000));
            //writer(memberList.get(memberList.size()-1));
        }
    }

    // Adds different classes to the memberList (ArrayList)
    public void add() {
        for (int x = 0; x <= 100; x++) {
            int rando = rand.nextInt(2) + 1;
            if (rando == 1) {
                name1 = boyNameList.get(rand.nextInt(100));
            } else {
                name1 = girlNameList.get(rand.nextInt(87));
            }
            int age = rand.nextInt(2006, 2018);
            memberList.add(new Youth(age, name1));
            //memberList.get(memberList.size()-1).setPrice(rand.nextInt(400, 10000));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setID(memberList.size() - 1);
            memberList.get(memberList.size()-1).setGender(boyNameList.contains(name1));
            //writer(memberList.get(memberList.size()-1));
        }

        for (int x = 0; x <= 100; x++) {
            int rando = rand.nextInt(2) + 1;
            if (rando == 1) {
                name1 = boyNameList.get(rand.nextInt(100));
            } else {
                name1 = girlNameList.get(rand.nextInt(87));
            }
            int age = rand.nextInt(1964, 2005);
            memberList.add(new Senior(age, name1));
            //memberList.get(memberList.size()-1).setPrice(rand.nextInt(400, 10000));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setID(memberList.size() - 1);
            memberList.get(memberList.size()-1).setGender(boyNameList.contains(name1));
            //writer(memberList.get(memberList.size()-1));
        }
        for (int x = 0; x <= 48; x++) {
            int rando = rand.nextInt(2) + 1;
            if (rando == 1) {
                name1 = boyNameList.get(rand.nextInt(100));
            } else {
                name1 = girlNameList.get(rand.nextInt(87));
            }
            int age = rand.nextInt(1940, 1964);
            memberList.add(new Elder(age, name1));
            //memberList.get(memberList.size()-1).setPrice(rand.nextInt(400, 10000));
            memberList.get(memberList.size()-1).setAge(age);
            memberList.get(memberList.size()-1).setID(memberList.size() - 1);
            memberList.get(memberList.size()-1).setGender(boyNameList.contains(name1));
            //writer(memberList.get(memberList.size()-1));
        }

    }

    // Comparator for sorting by age
    public void sort() {
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
  } //chairman class