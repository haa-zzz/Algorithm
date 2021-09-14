package com.haa.前缀树;

public class 实现Trie_208 {
    /*
    Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，
        例如自动补完和拼写检查。

    请你实现 Trie 类：

    Trie() 初始化前缀树对象。
    void insert(String word) 向前缀树中插入字符串 word 。
    boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
    boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     */
    /*
    分析：
    Trie 前缀树，就是一个树，第一个枝干上有 26 个分支，代表 26个字母，每个字母的分支上同样有 26 个分支，顺着枝干往下就能够拼成一个单词。

     插入：每遍历字符串中的一个字母，若该字母没有出现过，则就在对应的空位置往下生成一个 Trie；若该字母出现过，则直接继续遍历下一个字母，
     直到字符串遍历结束（注意：结束时要标记为 end，表示这个单词已经结束了）。

     查找：遍历要参数中要查找的字符串 word，若还未遍历到 end，在某字符处出现了 null，则直接返回 false，因为该字符是第一次出现，
        则一定不会存在这个要查找的单词 word。否则，一直遍历到查找字符串 word 的末尾，若当前这个位置的 isEnd == true，
        表示在前缀树中找到了该单词 word；否则，没有这个单词。

     前缀匹配：遍历需要前缀匹配的字符串 prefix，只要有在某字母的位置出现了 null，则直接返回 false（因为，该字母是第一次出现在前缀树中）；
     否则，直到 prefix 全部遍历完成后都没有返回 false 的话，则表示当前字典树中有该前缀字符串，返回 true 即可。

    时间复杂度： 初始化为O(1),其余操作的时间复杂度为o(s),s为每次插入或查询的字符串的长度
    空间复杂度： O(T * Σ),其中T为所有插入字符串的长度之和，Σ 为字符集的大小，本题 Σ=26。
     */
    class Trie {

        private Trie[] children;
        private boolean isEnd;

        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;

            for(int i  = 0;  i < word.length(); i++){
                char ch = word.charAt(i);
                int index = ch-'a';
                if( node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }

            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }
        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }


}
