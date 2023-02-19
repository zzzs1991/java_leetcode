package leet_0112;

import java.util.Objects;

public class PathSum {

    public static void main(String[] args) {

        Assembler assembler = new Assembler(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 });
        TreeNode root = assembler.assembleTree(0);
        Solution solution = new Solution();

        assert solution.hasPathSum(root, 22) == true;
        assert solution.hasPathSum(root, 18) == true;
        assert solution.hasPathSum(root, 17) == false;

    }

    public static class Assembler {
        private Integer[] source;

        public Assembler() {
        }

        public Assembler(Integer[] source) {
            this.source = source;
        }

        private TreeNode assembleTree(int target) {
            assert target >= 0;
            // 从数组中取出目标值 并创建节点
            if (target >= source.length || Objects.isNull(source[target]))
                return null;
            TreeNode cur = new TreeNode();
            cur.val = source[target];
            cur.left = assembleTree(target * 2 + 1);
            cur.right = assembleTree(target * 2 + 2);
            return cur;
        }
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null)
                return false;
            if (Objects.isNull(root.left) && Objects.isNull(root.right)
                    && Objects.equals(targetSum, root.val)) {
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val) ||
                    hasPathSum(root.right, targetSum - root.val);
        }
    }

}