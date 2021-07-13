package practice.program.java;

public class InfiniteLoopClassObjInitAsClassVariable {
    private static class Sample {
        private static Sample var = new Sample();
        private static int x = 0;

        private Sample() {
            x +=1;
            System.out.println(this+ " "+x);//throw new RuntimeException("");
        }
        public static void get() {
            Sample variable = new Sample();
            System.out.println(x);
            System.out.println(var + " "+variable);
        }
    }
    InfiniteLoopClassObjInitAsClassVariable var = new InfiniteLoopClassObjInitAsClassVariable();

    public static void main(String[] args) {
            Sample.get();
//            Sample sample = new  Sample();
            //InfiniteLoopClassObjInitAsClassVariable infiniteLoopClassObjInitAsClassVariable = new InfiniteLoopClassObjInitAsClassVariable();
    }
}


