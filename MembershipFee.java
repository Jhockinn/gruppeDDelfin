import java.io.FileWriter;
import java.io.IOException;

public class MembershipFee {
    // Starting fees
    private double PassiveMembershipFee = 500;
    private double YouthMembershipFee = 1000;
    private double SeniorMembershipFee = 1600;
    private double ElderMembershipFee;

    public MembershipFee() {
        double discount = 0.25; // 25% discount for elderly
        ElderMembershipFee = SeniorMembershipFee * (1 - discount);
    }

    // Display fees inside the UI.
    public void showMembershipFee() {
        System.out.println("Annual price for passive membership: " + PassiveMembershipFee);
        System.out.println("Annual price for youth membership: " + YouthMembershipFee);
        System.out.println("Annual price for senior membership fee: " + SeniorMembershipFee);
        System.out.println("Annual price for elderly membership fee: " + ElderMembershipFee);
    }
    
    // Write fees to a file
    public void printMembershipFeetoFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("\n");
            writer.write("Annual price for passive membership: " + PassiveMembershipFee + "\n");
            writer.write("Annual price for youth membership: " + YouthMembershipFee + "\n");
            writer.write("Annual price for senior membership: " + SeniorMembershipFee + "\n");
            writer.write("Annual price for elderly membership: " + ElderMembershipFee + "\n");
            writer.write("\n");
            System.out.println("Membership fees written to file: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing membership fees to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}






/*
    TO-DO:
          sætte kontigent til de forskellige grupper (youth (17 eller yngre), senior (18+), elder (60+)
          definere kontigenterne  som en metode                       
                                            -> konstruktor
                                            -> metode til at fremkalde dem så de vises
                                            -> metode til at modificere beløbene 
*/
    


