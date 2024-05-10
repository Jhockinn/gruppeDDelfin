import java.util.Scanner;

public class Cashier {
    // Declare Payments and MembershipFee as fields of the Cashier class
    private Payments payments = new Payments();
    private MembershipFee membershipfee = new MembershipFee();

    public static void main(String[] args) {
        // Create a Cashier instance to access the managePayments method
        Cashier cashier = new Cashier();
        cashier.managePayments();
    }

    public void managePayments() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCashier UI Options:");
            System.out.println("1: See memberlist");
            System.out.println("2: Late payments lists");
            System.out.println("3: See membership fees and print to a file");
            System.out.println("4: Modify membership fees");
            System.out.println("5: Go back to the main menu");
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
                    // TO-DO: Modify membership fees
                    break;

                case 5:
                    // Go back to the main menu
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}



