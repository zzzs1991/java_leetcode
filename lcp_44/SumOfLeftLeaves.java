package lcp_44;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.numColor(root1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 1 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.numColor(root2));

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
        private Set<Integer> set = new HashSet<>();

        public int numColor(TreeNode root) {
            dfs(root);
            return set.size();
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            dfs(root.right);
            set.add(root.val);
        }
    }

}