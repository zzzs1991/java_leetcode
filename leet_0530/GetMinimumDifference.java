package leet_0530;

import java.util.Objects;

public class GetMinimumDifference {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 236, 104, 701, null, 227, null, 911 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.getMinimumDifference(root1));
        assert solution.getMinimumDifference(root1) == 9;

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 1, null, 2 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.getMinimumDifference(root2));
        assert (solution.getMinimumDifference(root2) == 1);

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

        private int minDiff = Integer.MAX_VALUE;
        private int pre = -1;

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return minDiff;
        }

        private void dfs(TreeNode root) {
            if (root == null)
                return;
            dfs(root.left);
            this.update(pre, root.val);
            pre = root.val;
            dfs(root.right);
        }

        private void update(int pre, int val) {
            if (pre == -1)
                return;
            minDiff = Math.min(minDiff, val - pre);
        }
    }

}