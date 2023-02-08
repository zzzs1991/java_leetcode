package leet_2331;

import java.util.Objects;

public class EvaluateTree {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.evaluateTree(root1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 1 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.evaluateTree(root2));

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

        public boolean evaluateTree(TreeNode root) {
            return dfs(root);
        }

        private boolean dfs(TreeNode node) {
            if (node.left == null && node.right == null) {
                return node.val == 1;
            }
            boolean left = dfs(node.left);
            boolean right = dfs(node.right);
            return node.val == 2 ? (left || right) : (left && right);
        }

    }

}