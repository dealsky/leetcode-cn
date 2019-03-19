package com.dealsky.leetcode.solution._208实现Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node head;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new Node('#');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (search(word)) {
            return;
        }

        Node temp = head;
        for (int i = 0; i < word.length(); i++) {
            List<Node> nexts = temp.nexts;
            if (nexts == null) {
                nexts = new ArrayList<>();
                temp.nexts = nexts;
            }

            boolean flag = true;
            for (Node next : nexts) {
                if (next.val == word.charAt(i)) {
                    temp = next;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                Node node = new Node(word.charAt(i));
                if (i == word.length() - 1) {
                    node.end = true;
                }
                nexts.add(node);
                temp = node;
            } else {
                if (i == word.length() - 1) {
                    temp.end = true;
                }
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int index = 0;
        Node temp = head;
        while (temp.nexts != null) {
            boolean flag = true;
            List<Node> list = temp.nexts;
            for (Node node : list) {
                if (node.val == word.charAt(index)) {
                    index++;
                    flag = false;
                    if (index == word.length()) {
                        return node.end;
                    }
                    temp = node;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int index = 0;
        Node temp = head;
        while (temp.nexts != null) {
            boolean flag = true;
            List<Node> list = temp.nexts;
            for (Node node : list) {
                if (node.val == prefix.charAt(index)) {
                    index++;
                    flag = false;
                    if (index == prefix.length()) {
                        return true;
                    }
                    temp = node;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        return false;
    }

    class Node {
        private char val;

        private List<Node> nexts;

        private boolean end;

        public Node(char val) {
            this.val = val;
            end = false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
