package leetcode;
/***/
class ArrayMerge {
    public int[] merge(int[] A, int m, int[] B, int n) {
        if (n <= 0) {
            return A;
        }
        for (int i = 0; i < m; i++) {
            if (A[i] > B[0]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if ((i + j) >= m) {
                        A[i + j] = B[j];
                        B[j] = 0;
                        count++;
                    } else if (A[i + j] > B[j]) {
                        int tmp = A[i + j];
                        A[i + j] = B[j];
                        B[j] = tmp;
                    }
                }
                m += count;
                n -= count;
            }
        }
        for (int i = 0; i < n; i++) {
            A[m++] = B[i];
        }
        return A;
    }

    public int[] merge1(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        for (int i = 0; i < n; i++) {
            A[i] = B[i];
        }
        return A;
    }
}