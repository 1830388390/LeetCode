package LeetCode.A1v300.A101v110.A109ConvertSortedListtoBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {

        List<Integer> nums = new ArrayList<>();
        while (head != null){
            nums.add(head.val);
            head = head.next;
        }

        return sortedArrayToBST(nums, 0, nums.size());
    }

    private TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
