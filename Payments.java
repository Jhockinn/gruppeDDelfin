import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Payments {

    public static Memberlists memberlists = new Memberlists();
    private Cashier cashier;
    private static ArrayList<Members> latePayments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Payments(Cashier cashier) {
        this.cashier = cashier;
    }
    public Payments(){}

    public void payments() {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1: Read the whole list of people with missing payments");
            System.out.println("2: Add people to the list of missing payments manually");
            System.out.println("3: Remove people from the list of missing payments manually");
            System.out.println("4: Read the member list");
            System.out.println("5: Copy member data by ID and add to late payment list");
            System.out.println("6: Go back to the main cashier menu");
            System.out.println("\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    readLatePaymentPeopleFromNotepad();
                    break;
                case 2:
                    addPeopleToLatePaymentList();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Enter name of person to remove from late payment list:");
                    String personToRemove = scanner.nextLine();
                    removePeopleFromLatePaymentList(personToRemove);
                    removePeopleFromNotepad(personToRemove);
                    break;
                case 4:
                    readMemberList("MemberList.txt");
                    break;
                case 5:
                    copyAndAddMemberData();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    // loop through memberlist.txt with memberlist integers and strings
      public static void addAllLatePaymentMembers(ArrayList<Members> list) {
           for (Members member : list) {
               if (member.getRestance()==true) {
                   latePayments.add(member);
               }
           }
           updateLatePaymentFile();
       }
       
       // manual adding to late payment list
       public static void addPeopleToLatePaymentList() {
        scanner.nextLine();
        System.out.println("Enter name of person to add to late payment list:");
        String person = scanner.nextLine();
        System.out.println("Enter age of the person:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter membership ID of the person:");
        int ID = Integer.parseInt(scanner.nextLine());
        Members person1 = new Members(age, person);
        person1.setID(ID);
        latePayments.add(person1);

        System.out.println(person + " (ID: " + ID + ") added to late payment list.");

        try (FileWriter writer = new FileWriter("late_payment_people.txt", true)) { //true means user can directly add people
            writer.write(person + "\n");
            System.out.println("Late payment person added to the list in the notepad.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing late payment person to the notepad: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removePeopleFromLatePaymentList(String personToRemove) {
        System.out.println("List before removal: " + latePayments);

        boolean found = false;
        for (Members person : latePayments) { //Members is from memberlist file
            if (person.getName().equalsIgnoreCase(personToRemove)) {
                latePayments.remove(person); //removes the name from the list
                System.out.println(personToRemove + " removed from late payment list.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(personToRemove + " is not in the late payment list.");
        }

        System.out.println("List after removal: " + latePayments);

        updateLatePaymentFile();
    }

    public static void removePeopleFromNotepad(String personToRemove) {
        String filePath = "late_payment_people.txt";

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            ArrayList<String> updatedLatePayments = new ArrayList<>(); //the notepad document has a feedback from the ArrayList line 9

            while (fileScanner.hasNextLine()) {
                String person = fileScanner.nextLine();
                if (!person.equals(personToRemove)) {
                    updatedLatePayments.add(person);
                }
            }

            fileScanner.close();

            try (FileWriter writer = new FileWriter(filePath)) {
                for (String person : updatedLatePayments) {
                    writer.write(person + "\n");
                }
                System.out.println(personToRemove + " removed from the late payment list in the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while updating the late payment list in the file: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }

    public static void updateLatePaymentFile() {
        try (FileWriter writer = new FileWriter("late_payment_people.txt")) {
            for (Members person : latePayments) {
                writer.write("ID: " + person.getID() +" Name: " +person.getName() + "\n"); //each new entry is a different line
            }
            System.out.println("Late payment people list updated in the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the late payment list in the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printLatePaymentPeopleToFile(String latePaymentFile) {
        try (FileWriter writer = new FileWriter(latePaymentFile)) {
            writer.write("Late payment people list:\n");
            for (Members person : latePayments) {
                writer.write(person.getName() + "\n");
            }
            System.out.println("Late payment people list written to file: " + latePaymentFile);
        } catch (IOException e) {
            System.out.println("An error occurred while writing late payment people to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void readLatePaymentPeopleFromNotepad() {
        String filePath = "late_payment_people.txt";

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            System.out.println("Late payment list:"); // loops through every line of the document
            while (fileScanner.hasNextLine()) {
                String person = fileScanner.nextLine();
                System.out.println(person);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }

    public static void readMemberList(String filePath) {
        try {
            File file = new File(filePath); // each new use is a new instance
            Scanner fileScanner = new Scanner(file);

            System.out.println("Member List:");
            while (fileScanner.hasNextLine()) {
                String member = fileScanner.nextLine();
                System.out.println(member); //member is the same string used in memberlist file
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }

    public static void copyAndAddMemberData() {
        String filePath = "MemberList.txt";
        scanner.nextLine(); // consume the remaining newline

        System.out.println("What member ID do you want to copy data from?");
        String memberId = scanner.nextLine(); //each ID is a seperate line

        String memberData = getMemberDataById(filePath, memberId); //see method line 228

        if (memberData != null) {
            System.out.println("Copied Data: " + memberData);
            addMemberDataToLatePaymentList(memberData); // re-using an existing method
        } else {
            System.out.println("Member ID not found.");
        }
    }

    public static String getMemberDataById(String filePath, String memberId) {
        BufferedReader reader = null;
        String line;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) { // line is the central part in making the list
                String[] parts = line.split("\\|"); //this makes it so that the | parts gets removed from the lines
                if (parts.length > 0 && parts[0].trim().equals(memberId)) { // only returns if the ID is present
                    return line; // line is updated if there is relevant data
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // the last part of the method returns nothing 
            if (reader != null) { // if not equal to null
                try {
                    reader.close(); // closes the normal null
                } catch (IOException e) { // prints close errors
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void addMemberDataToLatePaymentList(String memberData) {
        String[] parts = memberData.split("\\|"); // gets rid of the straight lines
        if (parts.length >= 3) {                         //trim removes spaces from the targeted line
            int id = Integer.parseInt(parts[0].trim()); // index[0] is the ID, parseInt converts to an integer
            String name = parts[1].trim(); // index[1] is the name part on the memberlist
            int age = Integer.parseInt(parts[2].trim()); // index [2] is the age

            Members member = new Members(age, name);
            member.setID(id);
            latePayments.add(member);

            try (FileWriter writer = new FileWriter("late_payment_people.txt", true)) { // writes the data onto a new notepad
                writer.write(name + "\n");
                System.out.println(name + " (ID: " + id + ") added to late payment list and file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing late payment person to the file: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid member data format.");
        }
    }
}

