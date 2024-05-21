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
    private int id; 
    private int memberAge;
    private String competitor;
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
        do{
        System.out.println("Enter the year of birth:");
        memberAge = Integer.parseInt(scanner.nextLine());
          if(memberAge>2018 || memberAge<1940){
             System.out.println("Your age is not accepted here, try again");
          }
        }while(memberAge>2018 || memberAge<1940);
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
             newMember.setID(list.get(list.size()-1).getID()+1);
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
        }
    }
    public void removeMember(ArrayList<Members> list){
         System.out.println("Write id of person you want to remove"); 
         int id1 = scan.nextInt();
         scan.nextLine();
         list.remove(id-1);
        }
      public void modifyMember(ArrayList<Members> list){
         do{
         System.out.println("Write id of person you want to change"); 
         id = scan.nextInt();
         scan.nextLine();
          }while(id >list.get(list.size()-1).getID());
         System.out.println("What setting do you want to change?");
         System.out.println("Active or Competitor"); 
         String choice = scan.nextLine();
         switch(choice){
         case "Active" : 
            System.out.println("Change to active or passive ?"); 
            String active = scan.nextLine(); 
            if(active.equals("active")){
               list.get(id-1).setActive(true);
            }
            else{
               list.get(id-1).setActive(false);
            }
            break;
          case "Competitor" : 
            do{
            System.out.println("Change to regular or competitor ?"); 
            competitor = scan.nextLine(); 
            }while(!competitor.equals("regular") && !competitor.equals("competitor"));
            if(competitor.equals("competitor")){
               list.get(id-1).setCompetitor(true);
               do{
                   System.out.println("Choose Discipline");
                   System.out.println("Butterfly, Freestyle, Backstroke, Breaststroke");
                   discipline = scan.nextLine();
               switch(discipline){
                  case "Butterfly" :
                        list.get(id-1).setDiscipline("Butterfly");
                        break; 
                  case "Freestyle" :
                        list.get(id-1).setDiscipline("Freestyle");
                        break; 
                  case "Backstroke" :
                        list.get(id-1).setDiscipline("Backstroke");
                        break; 
                  case "Breaststroke" :
                        list.get(id-1).setDiscipline("Breaststroke");
                        break; 
                  default:
                        System.out.println("Wrong input");  
                  break; 
                    }
                }while(!disci.equals("Butterfly") && !disci.equals("Freestyle") && !disci.equals("Backstroke") && !disci.equals("Breaststroke"));
            }
            else{
               list.get(id-1).setCompetitor(false);
            }
            break;
 
           default:
           break;
         }
         
   }
    // Adds different classes to the memberList (ArrayList)
        public void add(ArrayList<Members> memberList) {
        //lists.loadList();
        if (memberList.isEmpty()) {
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