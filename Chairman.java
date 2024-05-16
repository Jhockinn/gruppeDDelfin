  import java.util.*;
  import java.io.*;
  public class Chairman{
    Memberlists lists = new Memberlists();
    Active setup = new Active();
    static Competition com = new Competition();
    ArrayList<String> boyNameList = new ArrayList<String>();
    ArrayList<String> girlNameList = new ArrayList<String>();
    //ArrayList<Members> memberList = new ArrayList<Members>();
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    Scanner reader = new Scanner("memberList.txt");
    int count;
    int age; 
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
    
    
    public Chairman() {
        // Initialize ArrayLists
         //memberList = new ArrayList<>();
         //lists.loadList();
         //memberList = lists.memberList;
    }
    // Add member to list
    public void addNewMember(ArrayList<Members> list) {
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
        for (Members member : list) {
            if (member.getName().equalsIgnoreCase(name) &&
                member.getAge() == member.year - memberAge &&
                member.getGender() == gender &&
                member.getCompetitor() == competitive) {
                memberExists = true;
                System.out.println("This member already exists.");
                break;
            }
        } 
      
        if (!memberExists) {
             Members newMember = new Members(memberAge, name);
             newMember.setID(list.size()+1);
             newMember.setDiscipline(discipline);
             newMember.setAge(memberAge);
             newMember.setGender(gender);
             newMember.setCompetitor(competitive);
             newMember.setActive(acti);
             newMember.setPrice(rand.nextInt(400, 10000));
             newMember.restan(res());
             unac(newMember);
             list.add(newMember); // Add new member to the member list
             lists.AddtoList(list); // Persist the updated list
            /*lists.memberList.add(new Members(memberAge, name));
            lists.memberList.get(lists.memberList.size() - 1).setID(lists.memberList.size());
            lists.memberList.get(lists.memberList.size() - 1).setDiscipline(discipline);
            lists.memberList.get(lists.memberList.size() - 1).setAge(memberAge);
            lists.memberList.get(lists.memberList.size() - 1).setGender(gender);
            lists.memberList.get(lists.memberList.size() - 1).setCompetitor(competitive);
            lists.memberList.get(lists.memberList.size() - 1).setActive(acti);
            lists.memberList.get(lists.memberList.size() - 1).setPrice(rand.nextInt(400, 10000));
            lists.memberList.get(lists.memberList.size() - 1).restan(res());
            unac(lists.memberList.get(lists.memberList.size() - 1));
            lists.AddtoList(lists.memberList);*/
            
            //writer(memberList.get(memberList.size()-1));
        }
    }

    // Adds different classes to the memberList (ArrayList)
        public void add(ArrayList<Members> memberList) {
        lists.loadList();
        if (!memberList.isEmpty()) {
            String name1;
            for (int x = 0; x <= 100; x++) {
                int rando = rand.nextInt(2) + 1;
                if (rando == 1) {
                    name1 = boyNameList.get(rand.nextInt(100));
                } else {
                    name1 = girlNameList.get(rand.nextInt(87));
                }
                int age = rand.nextInt(2006, 2018);
                memberList.add(new Youth(age, name1));
                memberList.get(memberList.size() - 1).setAge(age);
                memberList.get(memberList.size() - 1).setID(memberList.size());
                memberList.get(memberList.size() - 1).setGender(boyNameList.contains(name1));
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
                memberList.get(memberList.size() - 1).setAge(age);
                memberList.get(memberList.size() - 1).setID(memberList.size());
                memberList.get(memberList.size() - 1).setGender(boyNameList.contains(name1));
            }

            for (int x = 0; x <= 47; x++) {
                int rando = rand.nextInt(2) + 1;
                if (rando == 1) {
                    name1 = boyNameList.get(rand.nextInt(100));
                } else {
                    name1 = girlNameList.get(rand.nextInt(87));
                }
                int age = rand.nextInt(1940, 1964);
                memberList.add(new Elder(age, name1));
                memberList.get(memberList.size() - 1).setAge(age);
                memberList.get(memberList.size() - 1).setID(memberList.size());
                memberList.get(memberList.size() - 1).setGender(boyNameList.contains(name1));
            }
            
            setup.active(memberList);
            lists.writeToList(memberList);
        }
        else{
        System.out.println("Fuck you the list is not empty");
        }
      }
  

    /*public void add() {
      if(lists.memberList.size()>1){
      //lists.loadList();
      System.out.println("List already added"); 
      }
      else{
        for (int x = 0; x <= 100; x++) {
            int rando = rand.nextInt(2) + 1;
            if (rando == 1) {
                name1 = boyNameList.get(rand.nextInt(100));
            } else {
                name1 = girlNameList.get(rand.nextInt(87));
            }
            int age = rand.nextInt(2006, 2018);
            lists.memberList.add(new Youth(age, name1));
            //memberList.get(memberList.size()-1).setPrice(rand.nextInt(400, 10000));
            lists.memberList.get(lists.memberList.size()-1).setAge(age);
            lists.memberList.get(lists.memberList.size()-1).setID(lists.memberList.size());
            lists.memberList.get(lists.memberList.size()-1).setGender(boyNameList.contains(name1));
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
            lists.memberList.add(new Senior(age, name1));
            //memberList.get(memberList.size()-1).setPrice(rand.nextInt(400, 10000));
            lists.memberList.get(lists.memberList.size()-1).setAge(age);
            lists.memberList.get(lists.memberList.size()-1).setID(lists.memberList.size());
            lists.memberList.get(lists.memberList.size()-1).setGender(boyNameList.contains(name1));
            //writer(memberList.get(memberList.size()-1));
            
        }
        for (int x = 0; x <= 47; x++) {
            int rando = rand.nextInt(2) + 1;
            if (rando == 1) {
                name1 = boyNameList.get(rand.nextInt(100));
            } else {
                name1 = girlNameList.get(rand.nextInt(87));
            }
            int age = rand.nextInt(1940, 1964);
            lists.memberList.add(new Elder(age, name1));
            //memberList.get(memberList.size()-1).setPrice(rand.nextInt(400, 10000));
            lists.memberList.get(lists.memberList.size()-1).setAge(age);
            lists.memberList.get(lists.memberList.size()-1).setID(lists.memberList.size());
            lists.memberList.get(lists.memberList.size()-1).setGender(boyNameList.contains(name1));
            //writer(memberList.get(memberList.size()-1));
            
         
        }
      //activ.active(memberList);
      //lists.writeToList(memberList);
     
    }
    
   } */
   /*public void add2(){
    for(Members members : lists.memberList){
         if(members.getAge()<18 && members.getCompetitor() == true){
            com.youthCompetitors.add(new Competitor(members.getAge(), members.getName(), members.getDiscipline()));
            
         }
         if(members.getAge()>18 && members.getCompetitor() == true){
            com.seniorCompetitors.add(new Competitor(members.getAge(), members.getName(), members.getDiscipline()));
        }
         
      }
      com.showYouthCompetitors();
   }*/
    // Comparator for sorting by age
    /*public void sort() {
        Collections.sort(lists.memberList, new Comparator<Members>() {
            @Override
            public int compare(Members p1, Members p2) {
                return p1.getAge() - p2.getAge();
            }
        });
    }*/    
    public String chooseGender(Members member){
         if(member.getGender() == true){
            return "Male  ";
         }else{
            return "Female";
         }
    }
    public int res(){
         if(age<18){
         return 1000;
         }
         if(age>18 && age<60){
         return 1600;
         }
         else{
         return 1200; 
         }
    }
    public void unac(Members member){
    if(member.getActive() == false){
               if(member.getPrice() > 500){
                  member.setRestance(false);
               }
               else{
                  member.setRestance(true);
               }
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