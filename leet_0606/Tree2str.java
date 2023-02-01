package leet_0606;

import java.util.Objects;

public class Tree2str {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 1, 2, 3, null, 4 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.tree2str(root1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 1 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.tree2str(root2));

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
        public String tree2str(TreeNode root) {
            String result = dfs(root);

            return result.substring(1, result.length() - 1);
        }

        private String dfs(TreeNode root) {
            if (root == null)
                return "()";
            return "(" +
                    root.val +
                    (root.left == null && root.right == null ? ""
                            : dfs(root.left))
                    +

                    (root.right == null ? ""
                            : dfs(root.right))
                    +

                    ")";
        }
    }

}