package xuzheng;

import java.util.Arrays;

/**
 * kmp算法，匹配字符串
 */
public class KmpDemo {
    public int kmp(String mainStr, String modeStr) {
        char[] chars = mainStr.toCharArray();
        char[] chars1 = modeStr.toCharArray();
        int[] nexts = this.getNexts(chars1);
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            while (index > 0 && chars[i] != chars1[index]) {
                index = nexts[index - 1] + 1;
            }
            if (chars[i] == chars1[index]) {
                index++;
            }
            if (index == chars1.length) {
                return i - chars.length + 1;
            }
        }
        return -1;
    }

    public int[] getNexts(char[] modeArray) {
        int len = modeArray.length;
        int[] nexts = new int[len];
        nexts[0] = -1; // 一个字节不存在子串
        int k = -1;
        for (int i = 1; i < len; i++) {
            while (k != -1 && modeArray[k + 1] != modeArray[i]) {
                k = nexts[k];
            }
            if (modeArray[k + 1] == modeArray[i]) {
                k++;
            }
            nexts[i] = k;
        }
        return nexts;
    }

    public static void main(String[] args) {
        String str = "ababacd";
        KmpDemo demo = new KmpDemo();
        char[] chars = str.toCharArray();
        int[] nexts = demo.getNexts(chars);
        System.out.println(Arrays.toString(nexts));
    }
}
