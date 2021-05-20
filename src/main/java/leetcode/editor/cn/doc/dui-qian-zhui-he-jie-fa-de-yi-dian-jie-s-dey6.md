[前缀和解法原址](https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/) 原作者: 失火的夏天

在看这个解法的时候花了点时间，每个人理解方式有差异，写这个是希望能帮助到部分朋友。

主要有四个地方会卡住：
-  前缀和定义
-  用它干什么
- HashMap存的是什么
-  恢复状态代码的意义 
```
//恢复状态代码
prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1); 
```
## 前缀和定义
> 一个节点的前缀和就是`该节点`到`根`之间的路径和。

拿下图解释：
节点4的前缀和为：1 + 2 + 4 = 7
节点8的前缀和：1 + 2 + 4 + 8 = 15   
节点9的前缀和：1 + 2 + 5 + 9 = 17

```
      1
     /  \
    2    3
   / \    \
  4   5    6
 / \   \
7   8   9
```

## 前缀和对于本题的作用
题目要求的是找出`路径和等于给定数值`的路径总数, 而:

> 两节点间的路径和 = 两节点的前缀和之差

还是拿下图解释：

```
                     1
                    / 
                   2    
                  / 
                 3   
                / 
               4  
```

假如题目给定数值为5

```
节点1的前缀和为: 1
节点3的前缀和为: 1 + 2 + 3 = 6

prefix(3) - prefix(1) == 5
所以 节点1 到 节点3 之间有一条符合要求的路径( 2 --> 3 )
```
理解了这个之后，问题就得以简化：

> 我们只用遍历整颗树一次，记录每个节点的前缀和，并查询该节点的祖先节点中符合条件的个数，将这个数量加到最终结果上。


## HashMap存的是什么
HashMap的key是前缀和， value是该前缀和的节点数量，记录数量是因为有出现复数路径的可能。

拿图说明：

下图树中，前缀和为1的节点有两个: 1, 0

所以路径和为2的路径数就有两条: 0 --> 2, 2

```
      1
     / 
    0
   /
  2
```

## 恢复状态的意义
由于题目要求：```路径方向必须是向下的（只能从父节点到子节点）```

当我们讨论两个节点的前缀和差值时，有一个前提： 

> 一个节点必须是另一个节点的祖先节点

换句话说，当我们把一个节点的前缀和信息更新到map里时，它应当只对其子节点们有效。

举个例子，下图中有两个值为2的节点（A, B)。
```
      0
     /  \
    A:2  B:2
   / \    \
  4   5    6
 / \   \
7   8   9
```

当我们遍历到最右方的节点6时，对于它来说，此时的前缀和为2的节点只该有B, 因为从A向下到不了节点6(A并不是节点6的祖先节点)。

如果我们不做状态恢复，当遍历右子树时，左子树中A的信息仍会保留在map中，那此时节点6就会认为A, B都是可追溯到的节点，从而产生错误。

状态恢复代码的作用就是： 在遍历完一个节点的所有子节点后，将其从map中除去。

## 完整代码
```java
class Solution {
    Map<Integer, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root, int sum) {
        prefixMap = new HashMap<>();
        target = sum;

        prefixMap.put(0, 1);
        return recur(root, 0);
    }

    private int recur(TreeNode node, int curSum) {
        if(node == null) {
            return 0;
        }

        int res = 0;
        curSum += node.val;

        res += prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        int left = recur(node.left, curSum);
        int right = recur(node.right, curSum);

        res = res + left + right;

        prefixMap.put(curSum, prefixMap.get(curSum) - 1);

        return res;
    }
}
```

## 结
写的很粗糙，可能也有地方说的不对，欢迎指正。





