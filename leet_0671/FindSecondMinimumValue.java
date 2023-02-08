package leet_0671;

import java.util.Objects;

public class FindSecondMinimumValue {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 2, 2, 5, null, null, 5, 7 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.findSecondMinimumValue(root1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 2, 2, Integer.MAX_VALUE });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.findSecondMinimumValue(root2));

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
        int ans = -1;
        int min;

        public int findSecondMinimumValue(TreeNode root) {
            min = root.val;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node == null)
                return;
            if (ans != -1 && node.val >= ans) return;


            if (node.val > min) {
                ans = node.val;
            }
            dfs(node.left);
            dfs(node.right);
        }
    }
}