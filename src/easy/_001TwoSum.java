package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
//		return null;
		throw new IllegalArgumentException("No two sum solution");//官方题解
	}

	/**
	 * 方法2：两遍哈希表
	 * 使用了两次迭代。 通过以空间换取速度的方式，我们可以将查找时间从 O(n) 降低到 O(1)
	 * 保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表
	 * 
	 * 复杂度分析：
	 * 时间复杂度：O(n)， 我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)，所以时间复杂度为 O(n)。
	 * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
	 */
	public int[] twoSum2(int[] nums, int target) {
		//在第一次迭代中，我们将每个元素的值和它的索引添加到表中
		Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);//每个元素与其索引
	    }
	    //在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。
	    //注意，该目标元素不能是 nums[i]nums[i] 本身
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * 方法三：一遍哈希表 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
	 * 如果它存在，那我们已经找到了对应解，并立即将其返回。
	 * 
	 * 时间复杂度：O(n)， 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1)的时间。
	 * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素
	 */
	public int[] twoSum3(int[] nums, int target) {
		  Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement)) {
		            return new int[] { map.get(complement), i };
		        }
		        map.put(nums[i], i);
		    }
		    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) {
		_001TwoSum solution = new _001TwoSum();
		int[] nums = new int[] { 0, 1, 3, 2, 7, 11, 15 };
		int target = 12;
		System.out.println(Arrays.toString(solution.twoSum3(nums, target)));
	}
}
