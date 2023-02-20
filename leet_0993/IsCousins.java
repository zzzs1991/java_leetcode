package leet_0993;

import java.util.Objects;

public class IsCousins {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 1, 2, 3,null, 4 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.isCousins(root1, 2, 3));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 1, 2, 3, null, 4, null, 5 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.isCousins(root2, 5, 4));

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
        int targetX;
        int parentX;
        int heightX;
        boolean xFound;

        int targetY;
        int parentY;
        int heightY;
        boolean yFound;


        public boolean isCousins(TreeNode root, int x, int y) {
            targetX = x;
            targetY = y;
            dfs(root, 0, -1);
            return heightX == heightY && parentX != parentY;
        }

        private void dfs(TreeNode root, int level, int parent) {
            if (root == null) return;

            if (root.val == targetX) {
                parentX = parent;
                heightX = level;
                xFound = true;
            } else if (root.val == targetY) {
                parentY = parent;
                heightY = level;
                yFound = true;
            }
            
            if (xFound && yFound) return;
            dfs(root.left, level + 1, root.val);
            if (xFound && yFound) return;
            dfs(root.right, level + 1, root.val);

        }
    }

}