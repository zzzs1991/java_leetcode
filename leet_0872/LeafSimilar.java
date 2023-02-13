package leet_0872;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LeafSimilar {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 3, 5, 1, 6, 2, 9, 8, null, null, 7, 4 });
        TreeNode root1 = assembler1.assembleTree(0);

        Assembler assembler2 = new Assembler(
                new Integer[] { 3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution.leafSimilar(root1, root2));
        
        Solution solution1 = new Solution();

        Assembler assembler3 = new Assembler(new Integer[] { 1, 3, 2 });
        TreeNode root3 = assembler3.assembleTree(0);

        Assembler assembler4 = new Assembler(
                new Integer[] { 1, 2, 3 });
        TreeNode root4 = assembler4.assembleTree(0);
        System.out.println(solution1.leafSimilar(root4, root4));

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
        private List<Integer> result1 = new ArrayList<>();
        private List<Integer> result2 = new ArrayList<>();

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            dfs(root1, result1);
            dfs(root2, result2);
            return result1.size() == result2.size()
                    && IntStream.range(0, result1.size()).allMatch(index -> result1.get(index) == result2.get(index));
        }

        private void dfs(TreeNode root, List<Integer> leaves) {
            if (root == null)
                return;
            dfs(root.left, leaves);
            dfs(root.right, leaves);
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
            }
        }
    }

}