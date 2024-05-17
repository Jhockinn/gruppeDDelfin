import java.util.*;
public class Login{
      Scanner scan = new Scanner(System.in);
      Trainer trainer = new Trainer();
      Chairman chairman = new Chairman();
      Memberlists lists = new Memberlists();
      Cashier cashier = new Cashier();
      int input; 
      //logins for diffrent users. 
      String chairUser = "Chairman";
      String chairPass = "TheBoss";
      
      String cashUser = "Cashier";
      String cashPass = "Embezzler";
      
      String trainUser = "Trainer";
      String trainPass = "AsbjørnRiis";
      
      String username;
      String password;
      String close;
     
   public void login(){
      lists.upStart();
      chairman.add(lists.memberList);
      do{
      System.out.println("Welcome to the system");
      do{
         System.out.println("Would you like to login or close? type in login or close so select.");
         close = scan.nextLine();
            if(close.equals("close")){
               System.exit(0);
            }
            if(!close.equals("close") || !close.equals("login")){
               System.out.println("Wrong input please try again");
            }
      }while(!close.equals("close") && !close.equals("login"));
      System.out.println("Type in username: ");
      username = scan.nextLine();
      System.out.println("Type in password: ");
      password = scan.nextLine();
         if(username.equals(chairUser) && password.equals(chairPass)){
            do{
            //chairman.//set metode fra chairman her. 
            
            System.out.println("Welcome Chairman");
            System.out.println("What would you like to do?");
            System.out.println("1: Add Member");
            System.out.println("2: Modify Member");
            System.out.println("3: Remove Member");
            System.out.println("4: View Memberlist");
            System.out.println("5: Logout");
            input = scan.nextInt();
            scan.nextLine();
               switch(input){
               case 1:
                  chairman.addNewMember(lists.memberList);
               break; 
               
               case 2: 
                  chairman.modifyMember(lists.memberList);
                  lists.writeToList(lists.memberList);
               break;
  
               case 3: 
                  chairman.removeMember(lists.memberList);
                  lists.writeToList(lists.memberList);
               break;
               
               case 4:
                  lists.viewList();
               break;
               
               case 5:
                  System.out.println("Thank you Chairman");
               break; 
               
               default:
                  System.out.println("Naugthy Naugthy boy");  
               break;
               }//Switch*/
            }while(input<=4 && input >=6);
         }
         if(username.equals(cashUser) && password.equals(cashPass)){
            do{
            //cashier.//set metode fra cashier her. 
            
            /*System.out.println("Welcome Chashier");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            int input = scan.nextInt();
               
               switch(input){
               case 1:
               break; 
               
               case 2: 
               break;
               
               case 3: 
               break;
               
               case 4:
               break; 
               
               default: 
               break;
               }//Switch*/
            }while(true);
         }
        if(username.equals(trainUser) && password.equals(trainPass)){
            do{
            //trainer.TrainerUi()
            }while(true);
         }
         else{
            System.out.println("Wrong username or password, Try again!");
         }
      }while((username!=trainUser && password != trainPass) || (username!= cashUser && password!=cashPass) && 
      (username!=chairUser && password!=chairPass));
   }

}