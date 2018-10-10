package easy;

import java.util.Arrays;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 */
public class _001TwoSum {
	
	/**
	 * 方法1：循环两次
	 * 
	 * 复杂度分析：
	 * 时间复杂度：O(n^2)， 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)
	 * 的时间。因此时间复杂度为 O(n^2)
	 * 空间复杂度：O(1)
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[]{i, j};
				}
			}
		}
//		return null;//官方题解
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		_001TwoSum solution = new _001TwoSum();
		int[] nums = new int[] { 0, 1, 3, 2, 7, 11, 15 };
		int target = 20;
		System.out.println(Arrays.toString(solution.twoSum(nums, target)));
	}
}
