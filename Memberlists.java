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
        File late_payment_peopleFile = new File("late_payment_people.txt");

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

        if (late_payment_peopleFile.createNewFile()) {
            System.out.println("File Created: " + late_payment_peopleFile.getName());
        } else {
            System.out.println("File already exists: " + late_payment_peopleFile.getName());
        }
    } catch (IOException e) {
        System.out.println("An error occurred while creating the file.");
        e.printStackTrace();
    }
}    
      //adds a single person to the memberlist file
      public void AddtoList(ArrayList<Members> list){
         try{
            FileWriter myWriter = new FileWriter("MemberList.txt", true);
            Members member = list.get(list.size()-1);
            myWriter.write(member.getID()+ " | " + member.getName() + "   | " + member.getAge() + " | " + 
                           chair.chooseGender(member) + " | " + member.getRestance() +" | " + 
                           member.getActive() + " | " + member.getCompetitor() + " | " + member.getDiscipline()+"\n");            
            myWriter.close();
            System.out.println("Member added to the club");
         
         } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
         } catch(IndexOutOfBoundsException e){
            e.printStackTrace();
         }
      }//addtolist
      
      //you can see what is inside memberlist.txt file
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
      
      //its the method that allows us to call on the added member and load them down to the arraylist
      public void loadList() {
        if(memberList.isEmpty()){
        try {
            File file = new File("MemberList.txt");
            Scanner scanner = new Scanner(file);
            
            if(scanner.hasNextLine()){
               scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("\\|");
                if(tokens.length>=8){
                
                   // Trim and parse data from file
                   String name = tokens[1].trim();
                   int age = Integer.parseInt(tokens[2].trim());
                   String gender = tokens[3].trim();
                   boolean restance = Boolean.parseBoolean(tokens[4].trim());
                   boolean active = Boolean.parseBoolean(tokens[5].trim());
                   boolean competitive = Boolean.parseBoolean(tokens[6].trim());
                   String discipline = tokens[7].trim();
                   // Create a new Members object with parsed data and add it to memberList
                   Members newMember = new Members(age, name);
                   if(!"null".equals(discipline)){
                     newMember.setDiscipline(discipline);
                   }
                   newMember.setID(memberList.size()+1);
                   newMember.setDiscipline(discipline);
                   newMember.setGender("Male".equals(gender)); // Compare strings with equals()
                   newMember.setCompetitor(competitive);
                   newMember.setActive(active);
                   newMember.setRestance(restance);
                   memberList.add(newMember);

                } else {
                  System.out.println("incomplete data in line" + line);
                }
            }

            scanner.close();
            System.out.println("Member list loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing age.");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error reading data from file.");
            e.printStackTrace();
        }
        }else {
            System.out.println("The list ain't empty ya doofus");
        }
    }
    
    // Writes member list to the txt file 
    public void writeToList(ArrayList<Members> list) {
        try (FileWriter writer = new FileWriter("MemberList.txt")) {
            writer.write("ID | Name   | Age | Gender | Restance | Active | Competitor |  Discipline  \n");
            for (Members member : list) {
                writer.write(
                       member.getID()+ " | " + member.getName() + "    | " +   
                       member.getAge() + " | " + chair.chooseGender(member) +  " | " + member.getRestance() + " | " +
                       member.getActive() + " | " + member.getCompetitor() + " | " + member.getDiscipline() + "\n");
            }
            System.out.println("Member list has been successfully updated.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    
    public void upStart(){
    createFiles();
    loadList();
    }     
}