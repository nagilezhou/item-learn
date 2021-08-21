//A trie (pronounced as "try") or prefix tree is a tree data structure used to e
//fficiently store and retrieve keys in a dataset of strings. There are various ap
//plications of this data structure, such as autocomplete and spellchecker.
//
// Implement the Trie class:
//
//
// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i
//.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inser
//ted string word that has the prefix prefix, and false otherwise.
//
//
//
// Example 1:
//
//
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
//
//
//
// Constraints:
//
//
// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 104 calls in total will be made to insert, search, and startsWith
//.
//
// Related Topics 设计 字典树
// 👍 772 👎 0

package leetcode.editor.cn;

//Java：Implement Trie (Prefix Tree) 前缀树 字典树
// 2021-08-12 review 1
public class P208ImplementTriePrefixTree {
    public static void main(String[] args) {
        //Solution solution = new P208ImplementTriePrefixTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        class TrieNode {
            TrieNode[] childNode = new TrieNode[26];
            boolean end;
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode p = root;
            for (char s : word.toCharArray()) {
                int index = s - 'a';
                if (p.childNode[index] == null) {
                    p.childNode[index] = new TrieNode();
                }
                p = p.childNode[index];
            }
            p.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode p = root;
            for (char s : word.toCharArray()) {
                int index = s - 'a';
                if (p.childNode[index] == null) {
                    return false;
                }
                p = p.childNode[index];
            }
            return p.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char s : prefix.toCharArray()) {
                int index = s - 'a';
                if (p.childNode[index] == null) {
                    return false;
                }
                p = p.childNode[index];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}



