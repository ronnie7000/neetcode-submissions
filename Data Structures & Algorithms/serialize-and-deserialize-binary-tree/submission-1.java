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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> levelOrderTraversal = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if(node == null) {
                levelOrderTraversal.add("^");
                continue;
            }
            
            levelOrderTraversal.add(String.valueOf(node.val));
        
            deque.add(node.left);
            deque.add(node.right);
        }

        String serializedTree = String.join(",", levelOrderTraversal);

        return serializedTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodesArray = data.split(",");
        if(nodesArray.length == 0 || nodesArray[0].equals("^")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodesArray[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int idx = 1;

        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if(node == null) {
                continue;
            }

            if(!nodesArray[idx].equals("^")) {
                int leftVal = Integer.parseInt(nodesArray[idx]);
                node.left = new TreeNode(leftVal);
            }

            if(!nodesArray[idx + 1].equals("^")) {
                int rightVal = Integer.parseInt(nodesArray[idx + 1]);
                node.right = new TreeNode(rightVal);
            }

            idx += 2;

            deque.add(node.left);
            deque.add(node.right);
        }
        return root;
    }
}
