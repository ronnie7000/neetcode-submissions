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
    static class LevelNode {
        int level;
        TreeNode node;

        LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return res;
        }
        int currLevel = 0;
        Deque<LevelNode> deque = new LinkedList<>();
        List<Integer> currLevelValues = new ArrayList<>();
        LevelNode rootLevelNode = new LevelNode(root, 0);
        deque.add(rootLevelNode);

        while(!deque.isEmpty()) {
            LevelNode levelNode = deque.poll();

            if(levelNode.level != currLevel) {
                res.add(new ArrayList<>(currLevelValues));
                currLevelValues.clear();
                currLevel = levelNode.level;
            }

            currLevelValues.add(levelNode.node.val);
            if(levelNode.node.left != null) {
                deque.add(new LevelNode(levelNode.node.left, currLevel + 1));
            }
            if(levelNode.node.right != null) {
                deque.add(new LevelNode(levelNode.node.right, currLevel + 1));
            }
        }
        res.add(currLevelValues);
        return res;
    }
}
