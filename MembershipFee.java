public class MembershipFee {
    // Assuming the other membership fees are declared as follows:
    private double PassiveMembershipFee = 500;
    private double YouthMembershipFee = 1000;
    private double SeniorMembershipFee = 1600;
    private double ElderMembershipFee;

    // Constructor to initialize the elderly membership fee
    public MembershipFee() {
        // Calculate the elderly membership fee based on the senior fee
        double discount = 0.25; // 25% discount for elderly
        ElderMembershipFee = SeniorMembershipFee * (1 - discount);
    }

    // Method to display membership fees
    public void ShowMembershipFee() {
        System.out.println("Annual price for passive membership: " + PassiveMembershipFee);
        System.out.println("Annual price for youth membership: " + YouthMembershipFee);
        System.out.println("Annual price for senior membership fee: " + SeniorMembershipFee);
        System.out.println("Annual price for elderly membership fee: " + ElderMembershipFee);
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
    


