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
    

    public TreeNode buildTree(int[] A, int[] B) {
        int size = A.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < size; i++) {
            map.put(B[i], i);
        }

        return getBinaryTree(B, A, map, 0, size - 1, 0);
    }

    private TreeNode getBinaryTree(int[] inOrder,
                                   int[] preOrder,
                                   Map<Integer, Integer> map,
                                   int inStart, 
                                   int inEnd, 
                                   int preStart) {
        if(inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);
        int nodeIdx = map.get(preOrder[preStart]);
        int leftCount = nodeIdx - inStart;

        node.left = getBinaryTree(inOrder, preOrder, map, inStart, nodeIdx - 1, preStart + 1);
        node.right = getBinaryTree(inOrder, preOrder, map, nodeIdx + 1, inEnd, preStart + leftCount + 1);

        return node;
    }
}
