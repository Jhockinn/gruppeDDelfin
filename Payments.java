import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Payments {

    public Memberlists memberlists = new Memberlists(); 
    private Cashier cashier; 
    private static ArrayList<Members> latePayments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public Payments(Cashier cashier) {
        this.cashier = cashier;
    }

    public void memberlistToLatePayments() {
        for (Members member : memberlists.memberList) {
            if (member.getRestance()) {
                latePayments.add(member);
            }    
        }  
    }

    public Payments() {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1: Read the whole list of people with missing payments");
            System.out.println("2: Add people to the list of missing payments");
            System.out.println("3: Remove people from the list of missing payments");
            System.out.println("4: Read the member list");
            System.out.println("5: Go back to the main cashier menu");
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
                    String filePath = "MemberList.txt";

                    try {
                        File file = new File(filePath);
                        Scanner fileScanner = new Scanner(file);

                        System.out.println("Member List:");
                        while (fileScanner.hasNextLine()) {
                            String member = fileScanner.nextLine();
                            System.out.println(member);
                        }

                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found: " + filePath);
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

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

        try (FileWriter writer = new FileWriter("late_payment_people.txt", true)) {
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
        for (Members person : latePayments) {
            if (person.getName().equalsIgnoreCase(personToRemove)) {
                latePayments.remove(person);
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
            ArrayList<String> updatedLatePayments = new ArrayList<>();

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
                writer.write(person.getName() + "\n");
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

            System.out.println("Late payment list:");
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
}




