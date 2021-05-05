package com.eplusing.demo1200.leetcode;

public class TreeTest {

    /***
     * 分别按照二叉树先序，中序和后序打印所有的节点。
     * {1,2,3}
     * 返回值
     * 复制
     * [[1,2,3],[2,1,3],[2,3,1]]
     * */


    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        //Arrays.sort(firstOrderArr);

        TreeTest test = new TreeTest();

        TreeNode rootNode = test.buildTree(arr, 0);

        test.threeOrders(rootNode);
    }

    private TreeNode buildTree(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = arr[index];

        node.left = buildTree(arr, 2 * index + 1);
        node.right = buildTree(arr, 2 * index + 2);

        return node;
    }


    public int[][] threeOrders(TreeNode root) {
        // write code here
        firstOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        afterOrder(root);

        //int[][] result = {fisrtResult, midResult, afterResult};

        //return result;

        return null;
    }

    private void afterOrder(TreeNode node) {
        if(node != null){
            firstOrder(node.right);
            System.out.print(node.val + ",");
            firstOrder(node.left);
        }
    }

    private void midOrder(TreeNode node) {

        if(node != null){
            if(node.left != null){
                midOrder(node.left);
            }
            System.out.print(node.val + ",");
            firstOrder(node.right);
        }
    }

    private void firstOrder(TreeNode node) {
        if(node != null){
            System.out.print(node.val + ",");
            firstOrder(node.left);
            firstOrder(node.right);
        }
    }



    public static class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;
    }
}
