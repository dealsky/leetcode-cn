package com.dealsky.leetcode.solution._208实现Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    public char val;

    public List<Trie> children;

    public boolean end;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        val = '#';
        end = false;
    }

    public Trie(char val) {
        this.val = val;
        end = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            if (trie.children == null) {
                trie.children = new ArrayList<>();
            }
            List<Trie> children = trie.children;

            boolean flag = true;
            for (Trie temp : children) {
                if (temp.val == word.charAt(i)) {
                    trie = temp;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                Trie temp = new Trie(word.charAt(i));
                children.add(temp);
                trie = temp;
            }
        }

        trie.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return find(word, true);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return find(prefix, false);
    }

    private boolean find(String word, boolean match) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            List<Trie> children = trie.children;
            if (children == null) {
                return false;
            }

            boolean flag = true;
            for (Trie temp : children) {
                if (temp.val == c) {
                    trie = temp;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return false;
            }
        }

        if (match) {
            return trie.end;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
