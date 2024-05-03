public class Elder extends Senior{
   Random rand = new Random();
   public Elder(int age,String name,double price){
   super(age,name,price);
   }
   public void change(){
   super.setAge(rand.nextInt(60,100)); 
   super.setName("Jeff");
   super.setPrice(rand.nextInt(400,10000));
   }
   
   
}

}