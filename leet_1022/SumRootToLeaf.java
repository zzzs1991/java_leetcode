package leet_1022;

import java.util.Objects;

public class SumRootToLeaf {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 1,0,1,0,1,0,1 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.sumRootToLeaf(root1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 0 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.sumRootToLeaf(root2));

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
        int sum;
        public int sumRootToLeaf(TreeNode root) {
            dfs(root, 0);
            return sum;
        }
        private void dfs(TreeNode node, int val) {
            if (node == null) return;
            val = val * 2 + node.val;
            if (node.left == null && node.right == null) {
                sum += val;
            }
            dfs(node.left, val);
            dfs(node.right, val);
        }
    }

}