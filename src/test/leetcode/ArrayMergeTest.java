package leetcode;

import org.junit.Test;

public class ArrayMergeTest {

    private ArrayMerge s = new ArrayMerge();

    @Test
    public void merge() {
        int[][] inp = new int[][]{
                new int[]{1, 2, 3, 0, 0, 0},
                new int[]{2, 5, 6},
                new int[]{3, 3},

                new int[]{1, 5, 8, 0, 0, 0, 0, 0},
                new int[]{-1, 2, 2, 4, 6},
                new int[]{3, 5},

                new int[]{1},
                new int[]{},
                new int[]{1, 0},

                new int[]{0},
                new int[]{1},
                new int[]{0, 1},

                new int[]{2, 0},
                new int[]{1},
                new int[]{1, 1},

                new int[]{4,5,6,0,0,0},
                new int[]{1,2,3},
                new int[]{3, 3},
        };
        for (int i = 0; i < inp.length / 3; i++) {
            int[] rst = s.merge1(inp[3*i], inp[3*i + 2][0], inp[3*i + 1], inp[3*i + 2][1]);
            for (int v : rst) {
                System.out.print(v);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }
}
