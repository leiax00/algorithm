package leetcode

func TwoSum(numbers []int, target int) []int {
	bi, ei := 0, len(numbers)-1
	for bi < ei {
		tmp := numbers[bi] + numbers[ei]
		if tmp < target {
			bi++
		} else if tmp > target {
			ei--
		} else {
			return []int{bi + 1, ei + 1}
		}
	}
	return nil
}
