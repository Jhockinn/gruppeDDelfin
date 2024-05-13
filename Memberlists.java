import java.util.*;
import java.io.*;
public class Memberlists{
   static Chairman chair = new Chairman();
   ArrayList<Members> memberList = new ArrayList<Members>();  
   //creates a file and if the file already exists do nothing 
   public void createFiles() {
    try {
        File memberListFile = new File("MemberList.txt");
        File competitionFile = new File("Competition.txt");
        File restanceFile = new File("Restance.txt");

        if (memberListFile.createNewFile()) {
            System.out.println("File Created: " + memberListFile.getName());
        } else {
            System.out.println("File already exists: " + memberListFile.getName());
        }

        if (competitionFile.createNewFile()) {
            System.out.println("File Created: " + competitionFile.getName());
        } else {
            System.out.println("File already exists: " + competitionFile.getName());
        }

        if (restanceFile.createNewFile()) {
            System.out.println("File Created: " + restanceFile.getName());
        } else {
            System.out.println("File already exists: " + restanceFile.getName());
        }
    } catch (IOException e) {
        System.out.println("An error occurred while creating the file.");
        e.printStackTrace();
    }
}      //funktion til at adde en nyt medlem til klubben
      /*public void writeToList() {
         try {
           FileWriter writer = new FileWriter("MemberList.txt", false); // false to overwrite existing content
           writer.write("ID|  Member's name   |  Age   |  Gender  |  MemberType\n");
         for (Members member : chair.memberList) {
            writer.write(member.getID()+ " | " + member.getName() + " | " + member.getAge() + " | " + member.getGender() + " | " + member.getActive() + " | " + member.getCompetitor() + "\n");
           }
           writer.close();
           System.out.println("Member list has been successfully updated.");
       } catch (IOException e) {
           System.out.println("An error occurred while writing to the file.");
           e.printStackTrace();
       }
   }*/      
      public void AddtoList(ArrayList<Members> list){
         try{
            FileWriter myWriter = new FileWriter("MemberList.txt", true);
            Members member = list.get(list.size()-1);
            myWriter.write(member.getID()+ " | " + member.getName() + " | " + member.getAge() + " | " + chair.chooseGender(member) + " | " + member.getActive() + " | " + member.getCompetitor() + "\n");            myWriter.close();
            System.out.println("Member added to the club");
         
         } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
         }
      }//addtomenu
      public static void viewList(){
         try {
            File myObj = new File("MemberList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
               String menuData = myReader.nextLine();
               System.out.println(menuData);   
            }   
            myReader.close();
         } catch (FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
         }
      }//viewmenu
      
      //its the method that allows us to call on the added member
      public void loadList() {
        try {
            File file = new File("MemberList.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("\\|");

                // Trim and parse data from file
                int age = Integer.parseInt(tokens[1].trim());
                String gender = tokens[2].trim();
                String name = tokens[3].trim();
                String competitor = tokens[4].trim();
                String discipline = tokens[5].trim();
                String active = tokens[6].trim();

                // Create a new Members object with parsed data and add it to memberList
                double price= 1000;
                memberList.add(new Members(age, name));
            }

            scanner.close();
            System.out.println("Member list loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error reading data from file.");
            e.printStackTrace();
        }
    }
   /*public void createFiles() {
        try {
            File memberListFile = new File("MemberList.txt");
            File competitionFile = new File("Competition.txt");
            File restanceFile = new File("Restance.txt");

            createFile(memberListFile);
            createFile(competitionFile);
            createFile(restanceFile);
        } catch (IOException e) {
            System.out.println("An error occurred while creating files.");
            e.printStackTrace();
        }
    }

    private void createFile(File file) throws IOException {
        if (file.createNewFile()) {
            System.out.println("File Created: " + file.getName());
        } else {
            System.out.println("File already exists: " + file.getName());
        }
    }
    */
    // Write member list to file
    public void writeToList(ArrayList<Members> list) {
        try (FileWriter writer = new FileWriter("MemberList.txt")) {
            writer.write("ID| Name  |  Age   |  Gender   |  Active   |  Competitor  |  Discipline  \n");
            for (Members member : list) {
                writer.write(
                       member.getID()+ " | " + member.getName() + " | " +   
                       member.getAge() + " | " + chair.chooseGender(member) +  " | " + 
                       member.getActive() + " | " + member.getCompetitor() + " | " + member.getDiscipline() + "\n");
            }
            System.out.println("Member list has been successfully updated.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
      /*
    // Load member list from file
    public void loadList() {
        try (Scanner scanner = new Scanner(new File("MemberList.txt"))) {
            scanner.nextLine(); // Skip header
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("\\|");

                int age = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                String gender = tokens[2].trim();
                boolean competitor = Boolean.parseBoolean(tokens[3].trim());
                String discipline = tokens[4].trim();
                boolean active = Boolean.parseBoolean(tokens[5].trim());

                memberList.add(new Members(age, name/*, gender/*, competitor, discipline, active));
            }
            System.out.println("Member list loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error reading data from file.");
            e.printStackTrace();
        }
    }*/
    public void Combine(){
    createFiles();
    //writeToList();
    loadList();
    }     
}