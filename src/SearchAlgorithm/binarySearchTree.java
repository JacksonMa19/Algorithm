package SearchAlgorithm;

public class binarySearchTree {
    private class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
           this.data = data;
        }
    }

    /**
     * 查找结点
     * @param data
     * @return
     */
    public Node search(int data, Node root) {
        Node target = root;
        while (target != null && target.data != data) {
            if (data > target.data) {
                target = target.right;
            } else {
                target = target.left;
            }

        }
        if (target == null) {
            System.out.println("无此节点" + data);
        } else {
            System.out.println("找到结点" + data);
        }
        return target;
    }

    public boolean insert(int data, Node root) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return true;
        }

        Node target = root;
        while (target != null) {
            if (data == target.data) {
                return false;
            } else if (data > target.data) {
                if (target.right == null) {
                    target.right = node;
                    return true;
                }
                target = target.right;
            } else {
                if (target.left == null) {
                    target.left = node;
                    return true;
                }
                target = target.left;
            }

        }
        return true;
    }
}
