package lcci_0402;

import java.util.Objects;

public class SortedArrayToBST {

    public static void main(String[] args) {
        Solution solution = new Solution();
       TreeNode result = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
       System.out.println(result);
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
        int[] source;
        public TreeNode sortedArrayToBST(int[] nums) {
            source = nums;
            return dfs(0, source.length - 1);
        }

        private TreeNode dfs(int start, int end) {
            if (start > end) return null;
            int mid = (start + end) / 2;
            TreeNode cur = new TreeNode(source[mid]);
            cur.left = dfs(start, mid - 1);
            cur.right = dfs(mid + 1, end);
            return cur;
        }
    }

}