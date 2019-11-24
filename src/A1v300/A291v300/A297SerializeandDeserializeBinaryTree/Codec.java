package A1v300.A291v300.A297SerializeandDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
public class Codec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        Queue<TreeNode> levelTraversal = new LinkedList<>();
        levelTraversal.add(root);
        StringBuffer res = new StringBuffer();
        while (!levelTraversal.isEmpty()) {
            TreeNode tmp = levelTraversal.peek();
            levelTraversal.remove();
            if (tmp != null) {
                levelTraversal.add(tmp.left);
                levelTraversal.add(tmp.right);
                res.append(",").append(tmp.val);
            } else {
                res.append(",null");
            }
        }
        res.deleteCharAt(0);
        String str = res.toString();
        int end = str.length() - 1;
        int start = end - 4;
        while (start >= 0) {
            if (str.substring(start, end + 1).equals(",null")) {
                str = str.substring(0, start);
                start = start - 5;
                end = end - 5;
            } else {
                break;
            }
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] values = data.split(",");
        List<TreeNode> list = new LinkedList<>();
        TreeNode head = createNode(values[0]);
        list.add(head);
        int rootIndex = 0;
        int valueIndex = 1;
        while (rootIndex < list.size()) {
            TreeNode root = list.get(rootIndex++);
            if (valueIndex < values.length){
                root.left = createNode(values[valueIndex++]);
                root.right = createNode(values[valueIndex++]);
            }
            if (root.left != null)
                list.add(root.left);
            if (root.right != null)
                list.add(root.right);
        }
        return head;
    }

    private TreeNode createNode(String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("null")) {
            return null;
        } else {
            int integer = Integer.parseInt(str);
            return new TreeNode(integer);
        }
    }

}
