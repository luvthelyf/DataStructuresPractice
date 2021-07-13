package ds.program.miscompanies;

public class Apna {
    public static void main(String[] args) {
        System.out.println(Apna.getTime("AZGB"));
    }
    public static long getTime(String s) {
        char[] arr = s.toCharArray();


        long ans = 0;
        char currChar = 'A';
        for(char c : arr) {
            if(c >= currChar) {
                ans += Math.min(c - currChar, (currChar + 26 - c));
            } else {
                ans += Math.min(currChar - c, (c + 26 - currChar));
            }
            currChar = c;
        }
        return ans;

    }
}
