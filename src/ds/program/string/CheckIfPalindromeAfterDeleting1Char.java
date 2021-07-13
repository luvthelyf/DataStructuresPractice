package ds.program.string;

public class CheckIfPalindromeAfterDeleting1Char {
    public static void main(String[] args) {
        System.out.println(new CheckIfPalindromeAfterDeleting1Char().checkAndDeleteCharIfRequired("abcdba"));
    }

    private boolean checkAndDeleteCharIfRequired(String string) {
        char[] str = string.toCharArray();
        int start = 0;
        int end = str.length - 1;
        while(start < end) {
            if(str[start] == str[end]) {
                start++;
                end--;
            } else {
                if(isPalindrome(str, start + 1, end)) {
                    return true;
                }
                if(isPalindrome(str, start, end - 1)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] str, int start, int end) {
        while(start < end) {
            if(str[start] != str[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
