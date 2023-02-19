package leet_0100;

import java.util.Objects;

public class IsSameTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Assembler assembler1 = new Assembler(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        TreeNode root1 = assembler1.assembleTree(0);
        Assembler assembler2 = new Assembler(new Integer[] { 1 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution.isSameTree(root1, root2));

        Solution solution2 = new Solution();
        Assembler assembler3 = new Assembler(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        TreeNode root3 = assembler3.assembleTree(0);
        Assembler assembler4 = new Assembler(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        TreeNode root4 = assembler4.assembleTree(0);
        System.out.println(solution2.isSameTree(root3, root4));
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

        public boolean isSameTree(TreeNode p, TreeNode q) {
            return dfs(p, q);
        }

        private boolean dfs(TreeNode one, TreeNode two) {
            if (one == null && two == null) {
                return true;
            }
            if (one != null && two != null) {
                return one.val == two.val && dfs(one.left, two.left)
                && dfs(one.right, two.right);
            }

            return false;
        }
    }

}