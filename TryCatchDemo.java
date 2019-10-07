import java.util.StringTokenizer;
public class TryCatchDemo{
    
    public static void main(String[]args){
        test1();   
    }
    
    public static void test1(){
      try{
        int x = 10;
        int y = 0;
        int z = x/y;
        System.out.println(z);
      }
      catch(ArithmeticException e){
        System.out.println("Error");
        e.printStackTrace();
      }
      finally{
        System.out.println("one last thing....");    
      } 
    }
}
