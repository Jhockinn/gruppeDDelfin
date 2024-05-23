import java.util.*;
public class Login{
      Payments payment = new Payments();
      Scanner scan = new Scanner(System.in);
      Trainer trainer = new Trainer();
      Competition competition = new Competition();
      Chairman chairman = new Chairman();
      Memberlists lists = new Memberlists();
      Cashier cashier = new Cashier();
      int input;
      boolean logout=true; 
      //logins for diffrent users. 
      String chairUser = "Chairman";
      String chairPass = "Test";
      
      String cashUser = "Cashier";
      String cashPass = "Test";
      
      String trainUser = "Trainer";
      String trainPass = "Test";
      
      String username;
      String password;
      String close;
     
   public void login(){
      //Methods to run to add members to diffrent list. 
      lists.upStart();
      chairman.add(lists.memberList);
      competition.sortCompetitors(lists.memberList);
      do{
      //System.out.println("Welcome to the system");
      System.out.println(" _       __     __                        ");
      System.out.println("| |     / /__  / /____ ___  ____ ___  ___ ");
      System.out.println("| | /| / / _ \\/ / ___/ __ \\/ __  __ \\/ _ \\");
      System.out.println("| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/");
      System.out.println("|__/|__/ \\___/_/\\___\\____/_/ /_/ /_/\\___/ ");
      do{
         System.out.println();
         System.out.println("Type login to login");
         System.out.println("Type close to exit");
         close = scan.nextLine();
            if(close.equals("close")){
               System.exit(0);
            }
            if(!close.equals("close") && !close.equals("login")){
               System.out.println("Wrong input please try again");
            }
      }while(!close.equals("close") && !close.equals("login"));
      System.out.println("Type in username: ");
      username = scan.nextLine();
      System.out.println("Type in password: ");
      password = scan.nextLine();
      //Chairman login
         if(username.equals(chairUser) && password.equals(chairPass)){
            do{
            
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
                  lists.viewList(); 
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
                  logout=false;
               break; 
               
               default:
                  System.out.println("Naugthy Naugthy boy");  
               break;
               }//Switch*/
            }while(logout);
         }
         //Cashier login
         if(username.equals(cashUser) && password.equals(cashPass)){
            payment.addAllLatePaymentMembers(lists.memberList);
            cashier.managePayments();  
         }
         //Trainer login
         if(username.equals(trainUser) && password.equals(trainPass)){
               trainer.TrainerUi();
         }
      }while((username!=trainUser && password != trainPass) || (username!= cashUser && password!=cashPass) && 
      (username!=chairUser && password!=chairPass));
   }

}