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
    List<Integer> inOrder = new ArrayList<>();
    List<Integer> preOrder = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] A, int[] B) {
        int size = A.length;

        for(int i = 0; i < size; i++) {
            preOrder.add(A[i]);
            inOrder.add(B[i]);
            map.put(B[i], i);
        }

        return getBinaryTree(0, size - 1, 0);
    }

    private TreeNode getBinaryTree(int inStart, int inEnd, int preStart) {
        if(inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder.get(preStart));
        int nodeIdx = map.get(preOrder.get(preStart));
        int leftCount = nodeIdx - inStart;

        node.left = getBinaryTree(inStart, nodeIdx - 1, preStart + 1);
        node.right = getBinaryTree(nodeIdx + 1, inEnd, preStart + leftCount + 1);

        return node;
    }
}
