package algorithm.leetcode;

import java.util.HashMap;

public class Problem208 {

    class TrieNode {
        public String val;
        public HashMap<String, TrieNode> nextMap;

        public TrieNode(String val) {
            this.val = val;
            nextMap = new HashMap<>();
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Problem208() {
        root = new TrieNode("@");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.append("&");
        String tmpWord = sb.toString();
        TrieNode cur = root;
        for (int i = 0; i < tmpWord.length(); i++) {
            String charac = tmpWord.substring(i, i + 1);
            if (cur.nextMap.get(charac) == null) {
                TrieNode newNode = new TrieNode(charac);
                cur.nextMap.put(charac, newNode);
            }
            cur = cur.nextMap.get(charac);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.append("&");
        String tmpWord = sb.toString();
        TrieNode cur = root;
        for (int i = 0; i < tmpWord.length(); i++) {
            String charac = tmpWord.substring(i, i + 1);
            if (cur.nextMap.get(charac) == null)
                return false;
            cur = cur.nextMap.get(charac);
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            String charac = prefix.substring(i, i + 1);
            if (cur.nextMap.get(charac) == null)
                return false;
            cur = cur.nextMap.get(charac);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem208 trie = new Problem208();
        trie.insert("apple");
        trie.insert("beer");
        System.out.println(trie.search("app"));
    }
}
