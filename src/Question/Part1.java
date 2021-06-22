package Question;

public class Part1 {
    //有一个单向链表，判断是否有环？
    //solution

    /**
     *
     * @param head
     * @return
     */
    public static boolean isRing(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }


    //求出环的长度?
    /**
     *
     * @param head
     * @return
     */
    public static int ringNum(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                int index = 0;
                while (p1 != null && p2 != null){
                    p1 = p1.next;
                    p2 = p2.next.next;
                    index ++;
                    if (p1 == p2) {
                        return index;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 计算入环点
     * @param head
     * @return
     */
    public static Node enterPoint(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = head;
                while (p1 != null && p2 != null) {
                    p1 = p1.next;
                    p2 = p2.next;
                    if (p1 == p2) {
                        return p1;
                    }
                }

            }
        }
        return null;
    }

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(9);
        Node node4 = new Node(8);
        Node node5 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;


        System.out.println(isRing(node1));
        System.out.println(ringNum(node1));
        Node point = enterPoint(node1);
        System.out.println(point.data);


    }
}
