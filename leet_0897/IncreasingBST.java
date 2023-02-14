package leet_0897;

import java.util.Objects;


public class IncreasingBST {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 10, 5, 15, 3, 7, null, 18 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.increasingBST(root1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 10, 5, 15, 3, 7, 13, 18, 1, null, 6 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.increasingBST(root2));

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
        TreeNode dummy = new TreeNode();
        TreeNode pre = dummy;

        public TreeNode increasingBST(TreeNode root) {
            dfs(root);
            return dummy.right;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);

            pre.right = root;
            root.left = null;
            pre = pre.right;

            dfs(root.right);
        }
    }

}