//Given a string s and a dictionary of strings wordDict, return true if s can be
// segmented into a space-separated sequence of one or more dictionary words.
//
// Note that the same word in the dictionary may be reused multiple times in the
// segmentation.
//
//
// Example 1:
//
//
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//
// Example 2:
//
//
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pe
//n apple".
//Note that you are allowed to reuse a dictionary word.
//
//
// Example 3:
//
//
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
//
// Related Topics 动态规划
// 👍 1002 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//Java：Word Break dp bfs
// 2021-08-09 review 1
public class P139WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            Arrays.asList("a", "aa", "aaaa", "aaaaaa", "aaa")));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // bfs
        public boolean wordBreak2(String s, List<String> wordDict) {
            for (String word : wordDict) {
                addWord(word);
            }
            Deque<Integer> queue = new LinkedList<>();
            queue.add(0);

            int len = s.length();
            boolean[] visit = new boolean[len];
            visit[0] = true;

            while (!queue.isEmpty()) {
                int temp = queue.poll();
                List<Integer> endList = searchPrefixes(s.toCharArray(), temp);
                for (int end : endList) {
                    if (end == len - 1) {
                        return true;
                    }
                    if (visit[end + 1]) {
                        continue;
                    }
                    queue.offer(end + 1);
                    visit[end + 1] = true;
                }
            }
            return false;
        }

        TrieNode root = new TrieNode();

        class TrieNode {
            boolean end = false;
            HashMap<Character, TrieNode> child = new HashMap<>();

            TrieNode() {
            }
        }

        public List<Integer> searchPrefixes(char[] chars, int from) {
            List<Integer> res = new ArrayList<>();
            TrieNode curr = root;
            for (int i = from; i < chars.length; i++) {
                curr = curr.child.get(chars[i]);
                if (curr == null) {
                    break;
                } else if (curr.end) {
                    res.add(i);
                }
            }
            return res;
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, new TrieNode());
                }
                curr = curr.child.get(ch);
            }
            curr.end = true;
        }



        // dfs + backtrack 超时
        public boolean wordBreak(String s, List<String> wordDict) {
            List<String> ans = new ArrayList<>();
            return backtrack(s, 0, wordDict, ans);
        }

        public boolean backtrack(String s, int i, List<String> wordDict, List<String> ans) {
            if (s.length() == i) {
                return true;
            }
            boolean found = false;
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i, j + 1);
                if (wordDict.contains(temp)) {
                    ans.add(temp);
                    if(backtrack(s, j + 1, wordDict, ans)){
                        found = true;
                        break;
                    }
                    ans.remove(ans.size() - 1);
                }
            }
            return found;
        }


        // dp
        public boolean wordBreak3(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}




