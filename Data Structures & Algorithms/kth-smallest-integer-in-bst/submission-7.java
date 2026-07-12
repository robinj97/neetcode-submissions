/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        treeToList(root, list);
        System.out.println(list);
        list.stream().sorted().collect(Collectors.toList());
        return list.get(k-1);
        
    }

   private void treeToList(TreeNode node, List<Integer> list) {
    if (node == null) {
        return;
    }
    // Traverse the left subtree
    treeToList(node.left, list);
    // Add the current node's value
    list.add(node.val);
    // Traverse the right subtree
    treeToList(node.right, list);
}
}
