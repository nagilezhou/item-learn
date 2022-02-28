package leetcode.editor.cn.sort;

/**
 * @author nagile_zhou
 * @date Created by moxu at 2022/2/28
 */
public class Lift {
    public static void main(String[] args) {
        /**
         基础问题：微软亚洲研究所所在的希格玛大厦一共有6部电梯。在高峰时间，每层都有人上下，电梯在每层都停。实习生小飞常常会被每层都停的电梯弄得很不耐烦，于是他提出了这样一个办法：
         由于楼层并不太高看没在繁忙的上下班时间，每层电梯从一层往上走时，我们只允许电梯停在其中的某一层。所有的乘客都从一楼上电梯，到达某层楼后，电梯停下来，所有乘客再从这里爬楼梯到自己的目的层。在一楼的时候，每个乘客选择自己的目的层，电梯则自动计算出应停的楼层。

         */
        int[] person = new int[] {100000, 3, 1, 4, 5, 2, 3};
        System.out.println(helper(person, 7));
        System.out.println(helper2(person, 7));

    }
    /**
     解法1:暴力求解
     */
    /**
     * params person : int[] person[i]表示到第i层下电梯的有多少人
     * params N : int 表示一共有多少个楼层
     */
    public static int helper(int[] person, int N) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            // nFloor表示在第i层之下下电梯的人数总共需要走的步数+i层之上下电梯的人数总共需要走的步数之和
            int nFloor = 0;
            for (int j = 1; j < i; j++) { nFloor += person[j] * (i - j); }
            for (int j = i + 1; j < N; j++) { nFloor += person[j] * (j - i); }
            if (nFloor < res) { res = nFloor; }
        }
        return res;
    }
    /**
     解法2:
     技巧求解¥
     */
    /**
     * params person : int[] person[i]表示到第i层下电梯的有多少人
     * params N : int 表示一共有多少个楼层
     * 3 1 4 5 2 3
     */
    public static int helper2(int[] person, int N) {
        int nTargetFloor = 1;
        int nMinFloor = 0;
        // 表示在第i层楼之下的乘客
        int N1 = 0;
        // 表示在第i层楼的乘客
        int N2 = person[1];
        // 表示在第i层楼之上的乘客
        int N3 = 0;
        for (int i = 2; i < N; i++) {
            N3 += person[i];
            nMinFloor += person[i] * (i - 1);
        }
        for (int i = 2; i < N; i++) {
            // 往下爬的人大于往上爬的人
            if (N1 + N2 < N3) {
                nTargetFloor = i;
                nMinFloor += (N1 + N2 - N3);
                N1 += N2;
                N2 = person[i];
                N3 -= person[i];
            } else {
                break;
            }
        }
        System.out.println(nTargetFloor);
        return nMinFloor;

    }

    /**
     * 拓展问题：
     * 1 往上爬楼梯总是比往下走要累的，假设往上爬一个楼层需要消耗k单位的能量，往下爬楼梯需要消耗1单位的能量，
     * 如果题目修改为消耗的能量最少，这个问题怎么解决？
     * answer：在乘以人数的时候再乘以能量就好了呀
     * 2 在一个高楼里面，电梯只在某一个楼层停，这个政策还是不太人性化，如果电梯在k个楼层停呢？
     * 解答：以k=2为例
     * 电梯在2个楼层停，设为楼层A和楼层B(A < B ) ，那么目的地在楼层1至楼层(A+B)/2的人会选择在楼层A下电梯，目的地在楼层(A+B)/2+1至顶楼的人会选择在楼层B下电梯；由此问题分解为两个子问题，1楼至楼层
     * (A+B)/2和楼层(A+B)/2+1至顶楼，那么每个子问题都可以采用书中的方法进行求解。
     */
    public static int helper3(int[] person, int N, int k) {
        int nTargetFloor = 1;
        int nMinFloor = 0;
        // 表示在第i层楼之下的乘客
        int N1 = 0;
        // 表示在第i层楼的乘客
        int N2 = person[1];
        // 表示在第i层楼之上的乘客
        int N3 = 0;
        for (int i = 2; i < N; i++) {
            N3 += person[i];
            nMinFloor += person[i] * (i - 1) * 1;
        }
        for (int i = 2; i < N; i++) {
            if (N1 * 1 + N2 < N3 * k) {
                nTargetFloor = i;
                nMinFloor += (N1 * 1 + N2 - N3 * k);
                N1 += N2;
                N2 = person[i];
                N3 -= person[i];
            } else { break; }
        }
        System.out.println(nTargetFloor);
        return nMinFloor;

    }
}
