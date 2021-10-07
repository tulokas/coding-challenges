/** The Problem
 * Design an algorithm to serialize and deserialize a binary tree. 
 * Serialization is the process of converting a tree into a string, and deserialization is the reverse process.
 * 
 * Examples:
 * Input: [1, 2, 3, null, null, 4, 5]
 * Output: Same tree structure recreated
 **/

import java.util.*;

public class SerializeDeserializeTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);
        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized root value: " + deserialized.val);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String serialize(TreeNode root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(nodes);
    }

    private static TreeNode helper(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = helper(nodes);
        node.right = helper(nodes);
        return node;
    }
}
