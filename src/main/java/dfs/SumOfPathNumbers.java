package dfs;

class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (currentNode == null)
            return 0;

        // calculate the path number of the current node
        pathSum = 10 * pathSum + currentNode.val;

        // if the current node is a leaf, return the current path sum.
        if (currentNode.left == null && currentNode.right == null) {
            return pathSum;
        }

        // traverse the left and the right sub-tree
        return findRootToLeafPathNumbers(currentNode.left, pathSum) +
                findRootToLeafPathNumbers(currentNode.right, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
/**
 * Time: O(N), where 'N' is the total number of nodes in the tree. We traverse each node once.
 * Space: O(N) in the worst case. This space will be used to store the recursion stack. The worst case will
 * happen when the given tree is a linked list.(every node has only one child)
 */
