import java.util.*;
import java.io.*;
public class MainTest{
  public static void main(String[]args){
      Competitive competi = new Competitive();
      Chairman AddMemb = new Chairman();
      Active acti = new Active();
      Login login = new Login();
      AddMemb.addNames();
      //AddMemb.add();
      AddMemb.add();
      acti.active(AddMemb.memberList);
      //competi.compe(AddMemb.memberList);
      //AddMemb.sort();
      //System.out.println(AddMemb.memberList);
      //AddMemb.addNewMember();
      //System.out.println(AddMemb.memberList);
      //login.login();
      competi.fileOrder(AddMemb.memberList);
      
  }
}