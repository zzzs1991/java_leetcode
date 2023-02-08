package leet_1145;

import java.util.Objects;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Assembler assembler1 = new Assembler(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        TreeNode root1 = assembler1.assembleTree(0);
        System.out.println(solution.btreeGameWinningMove(root1, 1, 1));

        Solution solution2 = new Solution();
        Assembler assembler2 = new Assembler(new Integer[] { 1 });
        TreeNode root2 = assembler2.assembleTree(0);
        System.out.println(solution2.btreeGameWinningMove(root2,1,1));

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

        /*
         * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。

            最开始时：

            「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
            「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
            「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。

            之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。

            如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。

            若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。

            现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。


         */
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            return true;
        }
    }

}