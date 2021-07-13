package ds.program.miscompanies;

class HackerEarth{
    public void m1(double num) {
        System.out.println("Inside he class " + num);
    }
}

class Hacker extends HackerEarth {
    public void m1(int num) {
        System.out.println("inside hacker " + num);
    }
}
public class HackerEarthMain {
    public static void main(String[] args) {
        HackerEarth obj = new Hacker();
        obj.m1(10);
    }
}
