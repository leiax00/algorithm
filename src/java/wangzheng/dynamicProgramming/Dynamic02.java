package wangzheng.dynamicProgramming;

/**
 * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。如果我们要支付 w 元，求最少需要多少个硬币。
 * 比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）。
 */
public class Dynamic02 {
    public void solve(int payV) {
        int[][] rst = new int[payV][payV];
    }

    public static void main(String[] args) {
        int payV = 9;
        new Dynamic02().solve(payV);
    }
}
