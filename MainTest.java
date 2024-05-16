import java.util.*;
import java.io.*;
public class MainTest{
  public static void main(String[]args){
      Chairman AddMemb = new Chairman();
      Active acti = new Active();
      Login login = new Login();
      Memberlists lists = new Memberlists();
      lists.createFiles();
      AddMemb.addNames();
      
      AddMemb.add(lists.memberList);
      //acti.active(lists.memberList);
      //System.out.println(AddMemb.memberList);
      //AddMemb.add2();
      //acti.active(AddMemb.memberList);
      //lists.writeToList(lists.memberList);
      
      //competi.fileOrder(AddMemb.memberList);
      
      
      
      
      //lists.writeToList(AddMemb.memberList);
      //competi.compe(AddMemb.memberList);
      //AddMemb.sort();
      
      //System.out.println(lists.memberList);
      //AddMemb.add2();
      //System.out.println(compet.youthCompetitors);
      //compet1.showYouthCompetitors();
      
      AddMemb.addNewMember(lists.memberList);
      lists.viewList();
      //System.out.println(lists.memberList);
      //System.out.println(AddMemb.memberList);
      //login.login();
      //competi.fileOrder(AddMemb.memberList);
      
  }
}