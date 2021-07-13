package practice.program.java;

class Poly {
    static int length;
    int width;

    public Poly(int l, int w) {
        length = l;
        width = w;
    }

    int area() {
        return 2 * length * width;
    }
}

class Rect extends Poly {
    public Rect(int l, int w) {
        super(l, w);
    }

    int area() {
        return length * width;
    }
}

class Solution {
    public static void main(String args[]) {
        Poly rect1 = new Poly(5, 5);
        Poly rect2 = new Rect(6, 4);
        int area1 = rect1.area();
        int area2 = rect2.area();
        System.out.println(area1 + " " + area2);
    }
}