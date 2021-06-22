package JIEGOU;


public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;


    public void insert(int data, int index) throws Exception {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超过链表结点范围");
        }
        Node insertedNode = new Node(data);
        if(size == 0) {
            head = insertedNode;
            last = insertedNode;
        }else if(index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        }else if(size == index) {
            last.next = insertedNode;
            last = insertedNode;
        }else {
            Node prevNode = get(index - 1);
                insertedNode.next = prevNode.next;
                prevNode.next = insertedNode;
            }
        size ++;
        }

    public Node remove(int index) throws Exception {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
         Node removedNode = null;
        if(index == 0) {
            removedNode = head;
            head = head.next;
        }else if(index == size - 1) {
            Node prevNode = get(size - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size --;
        return removedNode;
    }



    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }







    public Node get(int index) throws Exception {
        if(index < 0 || index >=size) {
            throw new IndexOutOfBoundsException("超出链表结点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }



    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

        public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(2,0);
        myLinkedList.insert(4,1);
        myLinkedList.insert(34,2);
        myLinkedList.insert(22,2);
        myLinkedList.remove(1);
        myLinkedList.output();


    }
}
