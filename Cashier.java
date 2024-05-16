import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Cashier {
    private MembershipFee membershipfee = new MembershipFee();

    public void managePayments() {
        Scanner scanner = new Scanner(System.in);
        Payments payments = new Payments(this);

        while (true) {
            System.out.println("\nCashier UI Options:");
            System.out.println("1: Payment page");
            System.out.println("2: See membership fees and print to a file");
            System.out.println("3: Cashier logout");
            System.out.println("\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Payments paymentUI = new Payments();
                    break;

                case 2:
                    MembershipFee membershipFees = new MembershipFee();
                    membershipFees.showMembershipFee();
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
