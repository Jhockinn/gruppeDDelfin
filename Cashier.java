import java.util.Scanner;

public class Cashier {

    private Payments payments = new Payments();
    private MembershipFee membershipfee = new MembershipFee();

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

            switch(choice) {
                case 1:
                    // access memberlist (Niko G + Tobias)
                    // Add code to access memberlist
                    break;

                case 2:
                    // late payments is a list of people with missing payments
                    payments.getLatePaymentList();
                    break;

                case 3:
                    // membership fees
                    membershipfee.ShowMembershipFee(); //see fees inside UI
                    membershipfee.printMembershipFeetoFile("membership_fees.txt"); //print fees to a notepad file
                    break;

                case 4:
                    // TO-DO: modify membership fees
                    break;

                case 5:
                    // go back to the main menu
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}


