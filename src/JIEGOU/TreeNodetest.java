package JIEGOU;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNodetest {

    /**
     * 构建二叉树
     * @param inputlist
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputlist) {
       TreeNode node = null;
       if (inputlist == null || inputlist.isEmpty()) {
           return null;
       }
       Integer data = inputlist.removeFirst();

       if(data != null) {
           node = new TreeNode(data);
           node.leftChild = createBinaryTree(inputlist);
           node.rightchild = createBinaryTree(inputlist);
       }
       return node;

    }


    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
            System.out.print(node.data);
            preOrderTraveral(node.leftChild);
            preOrderTraveral(node.rightchild);

    }

    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.data);
        inOrderTraveral(node.rightchild);
    }

    public static  void  postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightchild);
        System.out.print(node.data);
    }




    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightchild;

        TreeNode(int data) {
            this.data = data;
        }

    }

    /**
     * 二叉树非递归前序遍历
     * @param root
     */
    public static void preOrderTravelWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while(treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightchild;
            }
        }
    }

    /**
     * 二叉树非递归中序遍历
     * @param root
     */
    public static void inOrderTravelWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;

            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightchild;
            }
        }
    }


//    /**
//     * 二叉树非递归后序遍历
//     * @param root
//     */
//    public static void postOrderTravelWithStack(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode treeNode = root;
//        while (treeNode != null || !stack.isEmpty()) {
//            while (treeNode != null) {
//                stack.push(treeNode);
//                treeNode = treeNode.leftChild;
//            }
//            if (!stack.isEmpty()) {
//                treeNode = stack.pop();
//                if (treeNode.rightchild == null) {
//                    System.out.println(treeNode.data);
//
//                } else {
//                    stack.push(treeNode.rightchild);
//                }
//            }
//
//        }
//
//    }

    public static void main(String[] args) {
        LinkedList<Integer> inputlist = new LinkedList<Integer>(Arrays.asList
                (new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputlist);

        //postOrderTravelWithStack(treeNode);
        //levelOrderTraversal(treeNode);

        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println();

        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println();

        System.out.println("后序遍历");
        postOrderTraveral(treeNode);
        System.out.println();


    }


    /**
     * 二叉树层序遍历
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightchild != null) {
                queue.offer(node.rightchild);
            }
        }

    }
}
