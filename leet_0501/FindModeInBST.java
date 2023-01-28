package leet_0501;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class FindModeInBST {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 0, null, 2, 2 });
        TreeNode root1 = assembler1.assembleTree(0);

        assert solution.findMode(root1)[0] == 2;

        Assembler assembler2 = new Assembler(new Integer[] { 7, 7, 8, 5, 7, 8, 8 });
        TreeNode root2 = assembler2.assembleTree(0);

        assert solution.findMode(root2)[1] == 8;

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
        private List<Integer> result = new ArrayList<>();
        private int base, count, maxCount;

        public int[] findMode(TreeNode root) {
            this.dfs(root);
            int[] answer = new int[result.size()];
            IntStream.range(0, result.size()).forEach(num -> {
                answer[num] = result.get(num);
            });
            return answer;
        }

        private void dfs(TreeNode root) {
            if (root == null)
                return;
            dfs(root.left);
            this.update(root.val);
            dfs(root.right);
        }

        private void update(int val) {
            if (val == base) {
                count++;
            } else {
                count = 1;
                base = val;
            }

            if (count == maxCount) {
                result.add(val);
            }
            if (count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(val);
            }
        }
    }

}