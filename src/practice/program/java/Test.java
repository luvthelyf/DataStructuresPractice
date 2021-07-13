package practice.program.java;

import practice.program.java.threads.mockdownloader.DownloadThread;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static class SampleClass {
        String st;
        int a;
        List<SampleBClass> b;
    }
    static class SampleBClass {
        public SampleBClass(String b) {
            this.st = b;
        }
        String st;
        int a;
    }

    public static int count = 0;
    public static void main(String[] args) {
        //doStuff();

        new DownloadThread(() -> {

        }).start();
        List a = new ArrayList();
        a.add("ss");
        a.add(2);
        System.out.println(a.get(0) instanceof Object);
        System.out.println(a.get(1) instanceof Integer);
        ;
        Test t = new Test();
        //t.doObjectStuff();
        //t.tryFinallyOutput();
        SampleClass c = new SampleClass();
        c.b = new ArrayList<>();
        c.b.add(new SampleBClass(""));
        t.tryMethod(c, 15);
    }

    private static void tryFinallyOutput() {
        try {
            count++;
            tryFinallyOutput();
            System.out.println(10 / 0);
        } catch (Exception e){
            System.out.println("catch");
        } finally {
            System.out.println("finally: "+count);
        }
    }

    private void doObjectStuff() {
        try{
            doMoreObjectStuff();
        } catch (Exception e ) {
            System.out.println("caught for object also");
        }
    }

    private void doMoreObjectStuff() {
        System.out.println(10/0);
    }

    private static void doStuff() {
        try{
            doMoreStuff();
        } catch (Exception e){
            System.out.println("caught");
        }
    }

    private static void doMoreStuff() {
        System.out.println(10/0);
    }





    private void tryMethod(SampleClass sc, int a){
        for(int i = 0; i < 5; i++) {
            if(a == 5 || sc.b.get(0).st == null) continue;
            int s = 4343;
            String temp = sc.b.get(0).st;
            if(temp != null) {
                System.out.println(temp.length());
            } else {
                System.out.println("getting null");
            }
        }
    }
}
