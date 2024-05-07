import java.util.Scanner;

public class Cashier {

    private Payment payment = new Payment();

    public void managePayments() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCashier UI Options:");
            System.out.println("1: See memberlist");
            System.out.println("2: Late payments lists");
            System.out.println("3: Go back to the main menu\n");;

            int choice = scanner.nextInt();

            switch(choice) {
                case 1: // access memberlist (Niko G + Tobias)
                    // Add code to access memberlist
                    break;

                case 2: // late payments is a list of people with missing payments
                    payment.getLatePaymentList();
                    break;

                case 3: // go back to the main menu
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}

