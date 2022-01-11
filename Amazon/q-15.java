package Amazon;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    static void linkdelete(Node head, int M, int N) {
        Node tempHead = head;
        // your code here
        while (tempHead != null) {
            for (int i = 1; i < M && tempHead.next != null; i++) {
                tempHead = tempHead.next;
            }

            Node temp = tempHead.next;
            for (int i = 1; i <= N && temp != null; i++) {
                temp = temp.next;
            }
            tempHead.next = temp;
            tempHead = tempHead.next;
        }

    }
}
