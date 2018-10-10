package easy;

import java.util.Arrays;

/**
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
 * ʾ��:
 * ���� nums = [2, 7, 11, 15], target = 9
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9 ���Է��� [0, 1]
 */
public class _001TwoSum {
	
	/**
	 * ����1��ѭ������
	 * 
	 * ���Ӷȷ�����
	 * ʱ�临�Ӷȣ�O(n^2)�� ����ÿ��Ԫ�أ�������ͼͨ��������������ಿ����Ѱ��������Ӧ��Ŀ��Ԫ�أ��⽫�ķ� O(n)
	 * ��ʱ�䡣���ʱ�临�Ӷ�Ϊ O(n^2)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[]{i, j};
				}
			}
		}
//		return null;//�ٷ����
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		_001TwoSum solution = new _001TwoSum();
		int[] nums = new int[] { 0, 1, 3, 2, 7, 11, 15 };
		int target = 20;
		System.out.println(Arrays.toString(solution.twoSum(nums, target)));
	}
}
