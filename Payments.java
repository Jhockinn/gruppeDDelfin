import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Payments {

    private Cashier cashier; 
    private static ArrayList<String> latePayments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public Payments(Cashier cashier) {
        this.cashier = cashier;
    }

    // Constructor
    public Payments() {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1: Read the whole list of people with missing payments");
            System.out.println("2: Add people to the list of missing payments");
            System.out.println("3: Remove people from the list of missing payments");
            System.out.println("4: Read the memberlist");
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
                    removePeopleFromLatePaymentList();
                    removePeopleFromNotepad(personToRemove);
                    break;
                case 4:    
                   String filePath = "MemberList.txt";

                    try {
                        File file = new File(filePath);
                        Scanner fileScanner = new Scanner(file); // Create a new scanner for file reading

                        System.out.println("Member List:");
                        while (fileScanner.hasNextLine()) {
                            String member = fileScanner.nextLine();
                            System.out.println(member);
                        }

                        fileScanner.close(); // Close the file scanner after use
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

/*       NOT WORKING AS INTENDED -- VERSION 2 OR FINE POLISH
            show late payment people inside UI
    public static void getLatePaymentList() {
        System.out.println("List of people with missing payments in currnt runetime:");
        for (int i = 0; i < latePayments.size(); i += 2) {
            String person = latePayments.get(i);
            String ID = latePayments.get(i + 1);
            System.out.println(person + " (ID: " + ID + ")");
        }
    }
*/
    public static void addPeopleToLatePaymentList() {
        scanner.nextLine();
        System.out.println("Enter name of person to add to late payment list:");
        String person = scanner.nextLine();
        System.out.println("Enter membership ID of the person");
        int ID = Integer.parseInt(scanner.nextLine());
        latePayments.add(person);
        latePayments.add(String.valueOf(ID));
      
        System.out.println(person + " (ID: " + ID + ") added to late payment list.");
        
       try (FileWriter writer = new FileWriter("late_payment_people.txt", true)) {
            writer.write(person + "\n");
            System.out.println("Late payment person added to the list in the notepad.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing late payment person to the notepad: " + e.getMessage());
            e.printStackTrace();
        }   
    }

public static void removePeopleFromLatePaymentList() {
    scanner.nextLine();
    System.out.println("Enter name of person to remove from late payment list:");
    String person = scanner.nextLine();
    
    System.out.println("List before removal: " + latePayments);
    
    int index = latePayments.indexOf(person);
    
    if (index != -1) { 
        latePayments.remove(index + 1); 
        latePayments.remove(index); 
        System.out.println(person + " removed from late payment list.");
        System.out.println("ID removed.");
        
        System.out.println("List after removal: " + latePayments);
        
        updateLatePaymentFile();
    } else {
        System.out.println(person + " is not in the late payment list.");
    }
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
            for (String person : latePayments) {
                writer.write(person + "\n");
            }
            System.out.println("Late payment people list updated in the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the late payment list in the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // write names to a notepad
    public static void printLatePaymentPeopleToFile(String latePaymentFile) {
        try (FileWriter writer = new FileWriter(latePaymentFile)) {
            writer.write("Late payment people list:\n");
            for (String person : latePayments) {
                writer.write(person + "\n");
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



