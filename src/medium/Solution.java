package medium;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。 你可以假设除了数字 0
 * 之外，这两个数字都不会以零开头。 
 * 示例： 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 
 * 原因：342 + 465 = 807
 */
public class Solution {
	/**
	 * Definition for singly-linked list. 
	 * ListNode是由自己定义的链表对象
	 */
	public static class ListNode {
		int val;
		ListNode next;// 下一个节点

		ListNode(int x) {
			val = x;
		}

		/**
		 * 构造ListNode数据
		 */
		public static ListNode buildListNode(int[] list) {
			ListNode first = null, last = null, newNode;
			for (int i = 0; i < list.length; i++) {
				newNode = new ListNode(list[i]);
				if (first == null) {
					first = newNode;
					last = newNode;
				} else {
					last.next = newNode;
					last = newNode;
				}
			}
			return first;
		}

		/**
		 * 打印ListNode数据
		 */
		public static String print(ListNode node) {
			String s = "";
			while (node != null) {
				s = s + node.val;
				node = node.next;
			}
			return s;
		}
	}

	/**
	 * 哑结点：https://blog.csdn.net/ermeiyao11/article/details/80808723
	 * (哑结点其实就是放在第一个存放数据结点之前、头结点之后的结点。 加入哑结点之后就可以使所有数据结点都有前驱结点，这样就会方便执行链表的一些操作。)
	 * head->dummyHead->1->2
	 * 
	 * 复杂度分析 时间复杂度：O(max(m,n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m,n) 次。
	 * 空间复杂度：O(max(m,n))， 新列表的长度最多为max(m,n) + 1。
	 */
	public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode(0);// 返回列表的哑结点
		int carry = 0;// 进位
		// 将 p 和 q 分别初始化为列表 l1和 l2 的头部。
		ListNode p = list1, q = list2, curr = dummyHead;// 将当前结点初始化为返回列表的哑结点。

		while (p != null || q != null) {// 遍历列表 l1和 l2 直至到达它们的尾端。
			// 将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
			int x = (p != null) ? p.val : 0;
			// 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
			int y = (q != null) ? q.val : 0;

			int sum = carry + x + y;
			// 更新进位的值
			carry = sum / 10;
			// 创建一个数值为 (sum % 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			// 同时，将 pp 和 qq 前进到下一个结点。
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		// 检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
		if (carry > 0) {
			curr.next = new ListNode(carry);//求和运算最后可能出现额外的进位
		}
		return dummyHead.next;// 返回哑结点的下一个结点---->第一个存放数据的结点
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers(ListNode.buildListNode(new int[] { 2, 4, 3 ,9}),
				ListNode.buildListNode(new int[] { 5, 6, 4 , 9}));
		System.out.println(ListNode.print(result));
	}

}
