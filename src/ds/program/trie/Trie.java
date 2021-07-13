package ds.program.trie;

public class Trie {
    private static class TrieNode {
        TrieNode[] node = new TrieNode[26];
        boolean end;
    }

    TrieNode root = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
        TrieNode temp = root;

        for (char c : word.toCharArray()) {
            if (temp.node[c - 'a'] == null) {
                temp.node[c - 'a'] = new TrieNode();
            }
            temp = temp.node[c - 'a'];
        }
        temp.end = true;
    }


    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.node[c - 'a'] == null) return false;

            temp = temp.node[c - 'a'];
        }
        return temp.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.node[c - 'a'] == null) return false;
            temp = temp.node[c - 'a'];
        }
        return true;
    }
    // My first attempt pass submission
//    Trie[] childChar;
//    boolean isEnd;
//    /** Initialize your data structure here. */
//    public Trie() {
//        childChar = new Trie[26];
//        for(int i = 0; i < 26; i++) {
//            childChar[i] = null;
//        }
//        isEnd = false;
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        Trie temp = this;
//        for(Character c : word.toCharArray()) {
//            if (temp.childChar[c - 'a'] == null) {
//                temp.childChar[c - 'a'] = new Trie();
//            }
//            temp = temp.childChar[c - 'a'];
//        }
//        temp.isEnd = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        Trie temp = this;
//        for(Character c : word.toCharArray()) {
//            if(temp.childChar[c - 'a'] == null) return false;
//            else {
//                temp = temp.childChar[c - 'a'];
//            }
//        }
//        return temp.isEnd;
//
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        Trie temp = this;
//        for(Character c : prefix.toCharArray()) {
//            if(temp.childChar[c - 'a'] != null) {
//                temp = temp.childChar[c - 'a'];
//            } else return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
//["Trie","insert","search","search","startsWith","insert","search"]
//[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
        // Your Trie object will be instantiated and called as such:
//         Trie obj = new Trie();
//         obj.insert(word);
//         boolean param_2 = obj.search(word);
//         boolean param_3 = obj.startsWith(prefix);

    }
}
