import java.util.Scanner;

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
            System.out.println("1: See memberlist");
            System.out.println("2: Late payments lists");
            System.out.println("3: See membership fees and print to a file");
            System.out.println("4: Go back to the main menu");
            System.out.println("\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Access memberlist (Niko G + Tobias)
                    // Add code to access memberlist
                    break;

                case 2:
                    // Late payments is a list of people with missing payments
                    payments.getLatePaymentList(); // See late payment list inside UI
                    break;

                case 3:
                    // Membership fees
                    membershipfee.showMembershipFee(); // See fees inside UI
                    membershipfee.printMembershipFeetoFile("membership_fees.txt"); // Print fees to a notepad file
                    break;

                case 4:
                    // Go back to the main menu
                    // call main method
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}





