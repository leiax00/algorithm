package leetcode;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
//        return traverse(0, numbers, target);
        return dichotomy(numbers, target);
    }

    public int[] traverse(int preIndex, int[] numbers, int target) {
        if (preIndex + 1 >= numbers.length) {
            return new int[2];
        }
        int lastIndex = preIndex + 1;
        while (lastIndex < numbers.length) {
            if (numbers[preIndex] + numbers[lastIndex] == target) {
                return new int[]{++preIndex, ++lastIndex};
            }
            lastIndex++;
        }
        return traverse(++preIndex, numbers, target);
    }

    public int[] dichotomy(int[] numbers, int target) {
        int beginIndex = 0;
        int lastIndex = numbers.length - 1;
        while (beginIndex < lastIndex) {
            int tmp = numbers[beginIndex] + numbers[lastIndex];
            if (tmp < target) {
                beginIndex++;
            } else if (tmp > target) {
                lastIndex++;
            } else {
                return new int[]{++beginIndex, ++lastIndex};
            }
        }
        return null;
    }
}
