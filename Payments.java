import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

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
            System.out.println("1: See list of people with missing payments");
            System.out.println("2: Add people to the list of missing payments");
            System.out.println("3: Remove people from the list of missing payments");
            System.out.println("4: Go back to the main cashier menu");
            System.out.println("\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getLatePaymentList();
                    break;
                case 2:
                    addPeopleToLatePaymentList();
                    break;
                case 3:
                    removePeopleFromLatePaymentList();
                    break;
                case 4:
                     return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

public static void getLatePaymentList() {
    System.out.println("List of people with missing payments:");
    for (int i = 0; i < latePayments.size(); i += 2) {
        String person = latePayments.get(i);
        String ID = latePayments.get(i + 1);
        System.out.println(person + " (ID: " + ID + ")");
    }
}

    public static void addPeopleToLatePaymentList() {
        scanner.nextLine();
        System.out.println("Enter name of person to add to late payment list:");
        String person = scanner.nextLine();
        System.out.println("Enter membeship ID of the person");
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
    
    // Debugging: Print the list before removal
    System.out.println("List before removal: " + latePayments);
    
    if (latePayments.remove(person)) {
        System.out.println(person + " removed from late payment list.");
        
        // Remove the associated ID
        if (latePayments.remove(person)) {
            System.out.println("ID removed.");
        } else {
            System.out.println("Associated ID not found.");
        }
        
        // Debugging: Print the list after removal
        System.out.println("List after removal: " + latePayments);
        
        // Update the file after successful removal
        updateLatePaymentFile();
    } else {
        System.out.println(person + " is not in the late payment list.");
    }
}

// Update the late payment file after removing a person
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
       
    //see late payment people list inside UI
public void showLatePaymentPeople() {
    System.out.println("List of people with missing payments:");
    for (String person : latePayments) {
        System.out.println(person);
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
}




