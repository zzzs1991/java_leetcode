package leet_0938;

import java.util.Objects;

public class RangeSumBST {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 10, 5, 15, 3, 7, null, 18 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.rangeSumBST(root1, 7, 15));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 10, 5, 15, 3, 7, 13, 18, 1, null, 6 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.rangeSumBST(root2, 6, 10));

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

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
            if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            }
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }


    }

}