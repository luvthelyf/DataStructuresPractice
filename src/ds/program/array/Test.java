package ds.program.array;

import java.util.ArrayList;

class Animal {
	Animal() {
		System.out.println("Animal");
	}
}
class Wild extends Animal{
	Wild() {
		super();
		System.out.println("Wild");
	}
}
public class Test {
//	public static void main(String[] args) {
//		int number = getNumber();
//		System.out.print(number);
//
//	}
//public static void main(String args[]) {
//	Wild wild = new Wild();
//}
public static void main(String [] args) {
	int a = 30;
	System.out.println( a<<1 ) ;
}
	public static int getNumber(){
		try{
			System.out.print("5");
			return 5;
		} catch(Exception e){
			System.out.print("10");
			return 10;
		}finally {
			System.out.print("15");
			return 15;
		}
	}
}