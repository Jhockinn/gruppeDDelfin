import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Cashier {
    private static Memberlists lists = new Memberlists();
    private MembershipFee membershipfee = new MembershipFee();

    public void managePayments() {
        Scanner scanner = new Scanner(System.in);
        Payments payments = new Payments(this);
        boolean isRunning = true; // UI boolean

        while (isRunning) {
            System.out.println("\nCashier UI Options:");
            System.out.println("1: Payment page");
            System.out.println("2: See membership fees and print to a file");
            System.out.println("3: Cashier logout");
            System.out.println("\n");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    payments.payments();
                    break;

                case 2:
                    membershipfee.showMembershipFee();
                    membershipfee.printMembershipFeetoFile("membership_fees.txt");
                    break;

                case 3: //return to login page
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        System.out.println("Cashier logged out.");
    }
}