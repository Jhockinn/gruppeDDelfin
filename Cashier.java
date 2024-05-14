import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Cashier {
    // Declare MembershipFee as a field of the Cashier class
    private MembershipFee membershipfee = new MembershipFee();

    public static void main(String[] args) {
        // Create a Cashier instance to access the managePayments method
        Cashier cashier = new Cashier();
        cashier.managePayments();
    }

    public void managePayments() {
        Scanner scanner = new Scanner(System.in);
        Payments payments = new Payments(this); // Pass this instance of Cashier to Payments

        while (true) {
            System.out.println("\nCashier UI Options:");
            System.out.println("1: Payment page");
            System.out.println("2: See membership fees and print to a file");
            System.out.println("3: Cashier logout");
            System.out.println("\n");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // Late payments is a list of people with missing payments
                    Payments paymentUI = new Payments();
                    break;

                case 2:
                  MembershipFee membershipFees = new MembershipFee();
                  membershipFees.showMembershipFee(); // See fees inside UI
                  membershipFees.printMembershipFeetoFile("membership_fees.txt");
                break;

                case 3:
                    System.exit(0);
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}







