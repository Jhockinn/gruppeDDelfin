import java.util.Scanner;

public class Cashier{

    Payment payment = new Payment(); // file contains methods to modify latepayment people list

/*
to-do: 
        import memberlist
        
        import kontigent
        see memberlist
        see kontigent

*/

    while (true) {
        System.out.println("\n");
        System.out.println("Cashier UI Options:");
        System.out.println("1: See memberlist");
        System.out.println("2: Late payments acess");
        System.out.println("3: Go back to the main menu");
        System.out.println("\n")
    }
    int choice = scanner.nextInt();

    switch(choice) {
        case 1: //access memberlist (Niko G + Tobias)

        break;

        case 2: //restance (Kristoffer -- WORK IN PROGRESS
                Payments.Payments();
        break;

        case 3: //go back to main menu

        default: 
        System.out.println("Invalid input");
        break;
    }

    }

