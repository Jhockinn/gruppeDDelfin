public class Senior extends Members{
   Random rand = new Random();
   public Senior(int age,String name,double price){
   super(age,name,price);
   }
   public void change(){
   super.setAge(rand.nextInt(18,60)); 
   super.setName("Jeff");
   super.setPrice(rand.nextInt(400,10000));
   }
   
   
}
}