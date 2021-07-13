package ds.program.string;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * */

public class RansomNote {
    public static void main(String[] args) {
        RansomNote note = new RansomNote();
        System.out.println(note.canConstruct("a", "b"));
        System.out.println(note.canConstruct("aa", "ab"));
        System.out.println(note.canConstruct("aa", "aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0 && magazine.length() == 0) return true;
        else if(ransomNote.length() == 0) return true;
        else if( magazine.length() == 0) return false;
        int[] arr = new int[26];
        for(Character c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }

        for(Character c : ransomNote.toCharArray()) {
            int pos = c - 'a';
            if(arr[pos] > 0) {
                arr[pos]--;
            } else return false;
        }
        return true;
    }
}
