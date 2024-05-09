  import java.util.*;
   import java.io.*;
   public class Chairman{
      static ArrayList<Members>memberList=new ArrayList<Members>();
           
      //creates a file and if the file already exists do nothing
      public void CreateMemberFile() {
         try {
           File file = new File("MemberList.txt");
           if (file.createNewFile()) {
             System.out.println("File Created: " + file.getName());
           } else {
               System.out.println("File already exists.");
         }//else
         } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
         }
      }
      //funktion til at adde en nyt medlem til klubben
      public void writeToList() {
         try {
           FileWriter writer = new FileWriter("MemberList.txt", false); // false to overwrite existing content
           writer.write("ID|  Member's name   |  Age   |  Gender  |  MemberType\n");
         for (Members member : memberList) {
            writer.write(member.getName() + " | " + member.getAge() + " | " + member.getGender() + " | " + member.getCompetitor() + "\n");
           }
           writer.close();
           System.out.println("Member list has been successfully updated.");
       } catch (IOException e) {
           System.out.println("An error occurred while writing to the file.");
           e.printStackTrace();
       }
   }      
      public static void AddtoList(){
         try{
            FileWriter myWriter = new FileWriter("MemberList.txt", true);
            Members member = memberList.get(memberList.size()-1);
            myWriter.write(member.getID()+" | "+member.getName()+" | "+member.getPrice()+" |  "+member.getCompetitor()+"\n");
            myWriter.close();
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
                String name = tokens[1].trim();
                int age = Integer.parseInt(tokens[2].trim());
                String gender = tokens[3].trim();
                String memberType = tokens[4].trim();

                // Create a new Members object with parsed data and add it to memberList
                double price= 1000;
                memberList.add(new Members(age, name, price));
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
      
   } //chairman class