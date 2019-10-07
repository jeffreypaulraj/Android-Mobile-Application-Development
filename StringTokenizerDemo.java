import java.util.StringTokenizer;
public class StringTokenizerDemo{
    
    public static void main(String[]args){
        
        m2();
        
    }
    
    public static void m1(){
        String testString = "Use the force";
        StringTokenizer tokenizer = new StringTokenizer(testString);
        while(tokenizer.hasMoreTokens()){
            String currentWord = tokenizer.nextToken();
            System.out.println(currentWord);
        }
    }
    
     public static void m2(){
        String testString = "Use the force";
        StringTokenizer tokenizer = new StringTokenizer(testString,"e",true);
        while(tokenizer.hasMoreTokens()){
            String currentWord = tokenizer.nextToken();
            System.out.println(currentWord);
        }
    }
}
