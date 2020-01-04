package LeetCode.weekCompetition;

import java.util.*;

public class C148 {

    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            int ans1 = 0;
            int ans2 = 0;
            int n = nums.length;

            for (int i = 0; i < nums.length; i += 2) {
                int rest = 0;
                if (i - 1 >= 0 && nums[i] >= nums[i - 1]) {
                    rest = Math.max(rest, Math.abs(nums[i] - nums[i - 1]) + 1);
                }
                if (i + 1 < n && nums[i] >= nums[i + 1]) {
                    rest = Math.max(rest, Math.abs(nums[i] - nums[i + 1]) + 1);
                }
                ans1 += rest;
            }
            for (int i = 1; i < nums.length; i += 2) {
                int rest = 0;
                if (i - 1 >= 0 && nums[i] >= nums[i - 1]) {
                    rest = Math.max(rest, Math.abs(nums[i] - nums[i - 1]) + 1);
                }
                if (i + 1 < n && nums[i] >= nums[i + 1]) {
                    rest = Math.max(rest, Math.abs(nums[i] - nums[i + 1]) + 1);
                }
                ans2 += rest;
            }

            return Math.min(ans1, ans2);
        }
    }

    /**
     * Definition for a binary tree Node.
     */
    class Solution2 {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            int left = 0;
            int right = 0;
            Queue<TreeNode> levelTraversal = new LinkedList<>();
            levelTraversal.add(root);
            int times = 0;
            TreeNode findX = new TreeNode(0);
            while (!levelTraversal.isEmpty()) {
                TreeNode tmp = levelTraversal.remove();
                if (tmp.val == x) {
                    findX = tmp;
                    break;
                }
                if (tmp.left != null) {
                    levelTraversal.add(tmp.left);
                }
                if (tmp.right != null) {
                    levelTraversal.add(tmp.right);
                }
            }
            levelTraversal = new LinkedList<>();
            TreeNode leftNode = findX.left;
            TreeNode rightNode = findX.right;
            if (leftNode != null) {
                levelTraversal.add(leftNode);
            }
            while (!levelTraversal.isEmpty()) {
                TreeNode tmp = levelTraversal.remove();
                left++;
                if (tmp.left != null) {
                    levelTraversal.add(tmp.left);
                }
                if (tmp.right != null) {
                    levelTraversal.add(tmp.right);
                }
            }
            levelTraversal = new LinkedList<>();
            if (rightNode != null) {
                levelTraversal.add(rightNode);
            }
            while (!levelTraversal.isEmpty()) {
                TreeNode tmp = levelTraversal.remove();
                right++;
                if (tmp.left != null) {
                    levelTraversal.add(tmp.left);
                }
                if (tmp.right != null) {
                    levelTraversal.add(tmp.right);
                }
            }
            System.out.println(left);
            System.out.println(right);
            return left > n - left || right > n - right || n - right - left > left + right;
        }
    }

    class SnapshotArray {
        int snap_id;
        ArrayList<TreeMap<Integer,Integer>> list = new ArrayList<TreeMap<Integer,Integer>>();
        public SnapshotArray(int length) {
            list.clear();
            for(int i = 0;i < length;i++) {
                list.add(new TreeMap<Integer,Integer>());
            }
        }
        public void set(int index, int val) {
            TreeMap<Integer, Integer> pairMap = list.get(index);
            Integer value = pairMap.getOrDefault(snap_id, val);
            pairMap.put(snap_id, val);
        }
        public int snap() {
            return snap_id++;
        }
        public int get(int index, int snap_id) {
            Map.Entry<Integer, Integer> entry = list.get(index).floorEntry(snap_id);
            return entry == null ? 0 : entry.getValue();
        }
    }

    class Solution4 {
        public int longestDecomposition(String text) {
            int l = text.length();
            for (int i = 0;i<l/2;i++){
                if (text.substring(0,i).equals(text.substring(l - i,l))){
                    return 2 + longestDecomposition(text.substring(i,l - i));
                }
            }
            return l == 0 ? 0 : 1;
        }
    }
}
