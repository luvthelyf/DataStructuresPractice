package ds.program;

public class FOO {
   public void funcCall()  
  {  
  System.out.println("M");  
  }  
    
  {  
  System.out.println("IB");  
  }  
      
  public void FOO()  
  {  
  System.out.println("C");  
  }  
  static {  
    System.out.println("S");  
  }  
  public static void main(String[] args) {  
  FOO x = new FOO();  
  x.FOO();  
  x.funcCall();  
 }  
} 