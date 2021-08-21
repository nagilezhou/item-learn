//Given the root of a binary tree and an integer targetSum, return the number of
// paths where the sum of the values along the path equals targetSum.
//
// The path does not need to start or end at the root or a leaf, but it must go
//downwards (i.e., traveling only from parent nodes to child nodes).
//
//
// Example 1:
//
//
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
//
//
// Example 2:
//
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 1000].
// -109 <= Node.val <= 109
// -1000 <= targetSum <= 1000
//
// Related Topics 树
// 👍 853 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：Path Sum III 二叉树 回溯 前缀和
// 2021-08-21 review 1
public class P437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public int pathSum(TreeNode root, int targetSum) {
            Map<Integer, Integer> pathMap = new HashMap<>();
            pathMap.put(0, 1);
            return backtrack(root, pathMap, targetSum, 0);
        }

        private int backtrack(TreeNode root, Map<Integer, Integer> pathMap, int target, int currentSum) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            currentSum += root.val;
            res += pathMap.getOrDefault(currentSum - target, 0);
            pathMap.put(currentSum, pathMap.getOrDefault(currentSum, 0) + 1);
            res += backtrack(root.left, pathMap, target, currentSum);
            res += backtrack(root.right, pathMap, target, currentSum);
            pathMap.put(currentSum, pathMap.get(currentSum) - 1);
            return res;
        }

        public int pathSum2(TreeNode root, int targetSum) {
            // key是前缀和, value是大小为key的前缀和出现的次数
            Map<Integer, Integer> prefixSumCount = new HashMap<>();
            // 前缀和为0的一条路径
            prefixSumCount.put(0, 1);
            // 前缀和的递归回溯思路
            return recursionPathSum(root, prefixSumCount, targetSum, 0);
        }

        private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
            // 1.递归终止条件
            if (node == null) {
                return 0;
            }
            // 2.本层要做的事情
            int res = 0;
            // 当前路径上的和
            currSum += node.val;

            //---核心代码
            // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
            // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
            // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
            res += prefixSumCount.getOrDefault(currSum - target, 0);
            // 更新路径上当前节点前缀和的个数
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
            //---核心代码

            // 3.进入下一层
            res += recursionPathSum(node.left, prefixSumCount, target, currSum);
            res += recursionPathSum(node.right, prefixSumCount, target, currSum);

            // 4.回到本层，恢复状态，去除当前节点的前缀和数量
            prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
            return res;
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode() {
            }

            public TreeNode(int val) {
                this.val = val;
            }

            public TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}



