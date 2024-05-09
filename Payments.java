import java.util.Scanner;
import java.util.ArrayList;

public class Payments {

    private static ArrayList<String> latePayments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public Payments() {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1: See list of people with missing payments");
            System.out.println("2: Add people to the list of missing payments");
            System.out.println("3: Remove people from the list of missing payments");
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
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void getLatePaymentList() {
        System.out.println("List of people with missing payments:");
        for (String person : latePayments) {
            System.out.println(person + " , ");
        }
    }

    public static void addPeopleToLatePaymentList() {
        scanner.nextLine();
        System.out.println("Enter name of person to add to late payment list:");
        String person = scanner.nextLine();
        latePayments.add(person);
        System.out.println(person + " added to late payment list.");
    }

    public static void removePeopleFromLatePaymentList() {
        scanner.nextLine();
        System.out.println("Enter name of person to remove from late payment list:");
        String person = scanner.nextLine();
        if (latePayments.remove(person)) {
            System.out.println(person + " removed from late payment list.");
        } else {
            System.out.println(person + " is not in the late payment list.");
        }
    }
}




