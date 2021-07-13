package ds.program.array;

class A {
    final int age;


    A(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return 5;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj == this) return true;
//        A a = (A)obj;
//        return a.age == age;
//    }

    public static void main(String[] args) {
        A a = new A(25);
        A b = new A(25);
        System.out.println(a == b);
        System.out.println(a.equals(b));
//        Integer aa = 128, bb = 128;
//        System.out.println(aa == bb);
//
//        Integer c = 100, d = 100;
//        System.out.println(c == d);
    }
}