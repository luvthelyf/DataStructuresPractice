package ds.program.kickstart;


import java.util.Scanner;
import java.util.Stack;

public class RobotPathDecoding {
    private static final int MAX = 1000000000;
    //private static final int dpSize =
    public static void main(String[] arg) {

//6
//SSSEEE
//        N
//N3(S)N2(E)N
//2(3(NW)2(W2(EE)W))
//9(9(9(9(9(9(9(9(9(9(NW))))))))))
//9(9(9(9(9(9(9(9(9(9(EW))))))))))




//        String[] str = {
////                "SSSEEE",
////                "N",
////                "N3(S)N2(E)N",
////                "2(3(NW)2(W2(EE)W))",
//                "2(2(2(NW)))"
//        };


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String st = "1("+sc.next()+")"; //"1(" + str[t] + ")";//
            robotPath((t + 1), st.toCharArray(), st.length());
        }
    }

    public static void robotPath(int t, char[] str, int n) {
        // Every str element is enclosed in 1(str[i])
        long N = 0, S = 0, E = 0, W = 0;
        long MIN = -1;                      // -1 corresponds to ')'
        int MAX_NUM = 1000000001;        // used because 1+(-1) = MAX_NUM - 1 = 1000000000
        int x = 1, y = 1;
        Stack<Long> stack = new Stack<>();

        stack.push(MIN);
        for (int i = n - 2; i > 0; i--) {
            char ch = str[i];
            // if N W S E found simply increment corresponding counts
            if (ch == 'N') {
                N = (N + 1) % MAX_NUM;
            } else if (ch == 'S') {
                S = (S + 1) % MAX_NUM;
            } else if (ch == 'W') {
                W = (W + 1) % MAX_NUM;
            } else if (ch == 'E') {
                E = (E + 1) % MAX_NUM;
            } else if (ch == ')') { // if current = ')' found
                if (E != 0 || N != 0 || W != 0 || S != 0) {
                    // If any previous N W E S were present between pair of ')' & ')' then push their counts to stack.
                    stack.push(N);
                    stack.push(W);
                    stack.push(E);
                    stack.push(S);
                    // Since values are stored in stack so we reset it for current ')'
                    N = 0;
                    W = 0;
                    E = 0;
                    S = 0;
                }
                // push current ')' value -1.
                stack.push(MIN);
            } else if (ch == '(') { // opening bracket '(' found.
                // top of stack would be ')' so remove it first.
                stack.pop();

                // find the integer value before '(' and store in variable 'multiple'
                int multiple = Integer.parseInt(str[i - 1] + "");

                // till now whatever N W E S are calculated, multiply with 'multiple'
                N *= multiple;
                W *= multiple;
                E *= multiple;
                S *= multiple;

                // we calculated N W E S for current pair of '(' and ')' and had multiplied with multiple.
                // so remove all stack entries till next ')' is found.
                // example : 1(N2(N)SN)
                // first ')' is already in stack.
                // second ')'  stack entries [N=1 -> W=0 --> E=0 --> S=1 --> stackTop]

                // '(' found: N = 1 till that moment. So 2* 1N = 2N
                // So string is 1(N NN SN)
                //                   || ||
                //                   ||  =====> in stack
                //                   =====> above code produced this.
                //                   Add all right side direction value while
                //                   popping from stack till ')'
                while (!stack.isEmpty() && stack.peek() != -1) {
                    S += stack.pop();
                    E += stack.pop();
                    W += stack.pop();
                    N += stack.pop();
                }

                // after this loop 1(N NN SN)
                //                     -----
                //                     |
                //                     ===> combined makes N = 3 S=1
                //                     till this point.
                i--; // skip the multiple number
            }
        }

        S %= MAX_NUM;
        E %= MAX_NUM;
        W %= MAX_NUM;
        N %= MAX_NUM;

        if (stack.isEmpty()) {
            if (S - N < 0) x = MAX_NUM;
            x += (S - N);
            if (E - W < 0) y = MAX_NUM;
            y += (E - W);
        }
        System.out.println("Case #" + t + ": " + y + " " + x);

    }
}
