package ds.program.trie;

public class TriePractice {
    private class Trie {
        Trie[] node;
        boolean isEndOfWord;

        public Trie() {
            node = new Trie[26];
            isEndOfWord = false;
        }
    }

    Trie rootNode = new Trie();

    public void insert(String str) {
        Trie temp = rootNode;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(temp.node[ch - 'a'] == null) {
                temp.node[ch - 'a'] = new Trie();
            }
            temp = temp.node[ch - 'a'];
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String str) {
        Trie temp = rootNode;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (temp.node[ch - 'a'] != null){
                temp = temp.node[ch - 'a'];
            } else {
                return false;
            }
        }
        return temp.isEndOfWord;
    }
    public static void main(String[] args) {
        TriePractice practice = new TriePractice();
        practice.insert("sandeep");
        practice.insert("deepti");
        practice.insert("sheetal");
        practice.insert("abc");
        practice.insert("def");
//        System.out.println(practice.search("sandeep"));
//        System.out.println(practice.search("sheetal"));

        practice.findSubstringsOfWord("asdfasheetalrwsandeeptiefdgaewfcs");

    }
//kmp
    private void findSubstringsOfWord(String str) {
        char[] arr = str.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            String word = searchWord(arr, i);
            if(word != null) System.out.println(word);
        }
    }
// asdfasheetalrwsandeeptiefdgaewfcs
    private String searchWord(char[] arr, int start) {
        Trie temp = rootNode;
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < arr.length && temp != null && !temp.isEndOfWord; i++) {
            if(temp.node[arr[i] - 'a'] != null) {
                sb.append(arr[i]);
            } else return null;
            temp = temp.node[arr[i] - 'a'];
        }
        return temp != null && temp.isEndOfWord ? sb.toString() : null;
    }
}
