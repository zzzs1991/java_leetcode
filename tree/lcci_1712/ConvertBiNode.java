package lcci_1712;

import java.util.Objects;

public class ConvertBiNode {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.convertBiNode(root1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 1 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.convertBiNode(root2));

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
        public TreeNode convertBiNode(TreeNode root) {
            dfs(root);
            return dummy.right;
        }

        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            
            node.left = null;
            pre.right = node;
            pre = pre.right;

            dfs(node.right);
        }
    }

}