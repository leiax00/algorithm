package xuzheng.dynamicProgramming;

/**
 *                      5
 *                    /   \
 *                  7      8
 *                / \    /  \
 *              2     3      4
 *            /  \  /  \   /  \
 *          4     9      6     1
 *        /  \  /  \   /  \   / \
 *      2     7      9      4    5
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。请你编程求出从最高层移动到最底层的最短路径长度。
 */
public class Dynamic01 {
    public void solve(int[] src) {
        int depth = this.getTreeDepth(src);
        int[][] rst = new int[depth][(int) Math.pow(2, depth - 1)];
        rst[0][0] = src[0];
        for (int i = 1; i < depth; i++) {
            for (int j = (int) Math.pow(2, i) - 1; j >= 0; j--) {
                rst[i][j] = rst[i - 1][j / 2] + src[calcIndex(i, j)];
            }
        }
//        for (int i = 0; i < depth; i++) {
//            System.out.println(Arrays.toString(rst[i]));
//        }
        // calc min value
        int index = 0;
        for (int i = 1; i < rst[depth - 1].length; i++) {
            if (rst[depth - 1][i] < rst[depth - 1][index]) {
                index = i;
            }
        }

        // print
        this.print(src, depth, index);

    }

    public int calcIndex(int depth, int rstY) {
        int index = 0;
        while (depth > 0) {
            index += depth;
            if (rstY % 2 == 1) {
                index += 1;
            }
            rstY /= 2;
            depth--;
        }
        return index;
    }

    public int[] calcIndexStep(int treeDepth, int rstY) {
        int[] steps = new int[treeDepth];
        while (treeDepth > 0) {
            steps[treeDepth - 1] += treeDepth;
            if (rstY % 2 == 1) {
                steps[treeDepth - 1] += 1;
            }
            rstY /= 2;
            treeDepth--;
        }
        return steps;
    }

    public int getTreeDepth(int[] tree) {
        // s = n(n+1)/2
        int s = tree.length;
        int n = 1;
        while (s - n >= 0) {
            s -= n++;
        }
        return --n;
    }

    public void print(int[] src, int depth, int minIndex) {
        int[] steps = this.calcIndexStep(depth - 1, minIndex);
        int index = 0;
        System.out.println(src[index]);
        for (int step : steps) {
            index += step;
            System.out.println(src[index]);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{5, 7, 8, 2, 3, 4, 4, 9, 6, 1, 2, 7, 9, 4, 5};
        new Dynamic01().solve(list);
    }
}
