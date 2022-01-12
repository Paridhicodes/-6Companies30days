package Amazon;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public void serialize(Node root, ArrayList<Integer> A) {
        // code here
        Queue<Node> q = new LinkedList<>();

        int val = (root != null) ? root.data : -1;
        A.add(val);
        if (val != -1) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            Node curr = q.remove();
            int leftData = (curr.left != null) ? curr.left.data : -1;
            int rightData = (curr.right != null) ? curr.right.data : -1;
            A.add(leftData);
            A.add(rightData);
            if (leftData != -1) {
                q.add(curr.left);
            }
            if (rightData != -1) {
                q.add(curr.right);
            }
        }
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        if (A.size() == 0) {
            return null;
        }
        Queue<deNode> q = new LinkedList<>();
        Node root = new Node(A.get(0));
        q.add(new deNode(root, 0));
        int i = 0;
        while (!q.isEmpty()) {
            deNode curr = q.remove();
            Node currNode = curr.node;
            int currIndex = curr.index;
            if (A.get((currIndex * 2) + 1) != -1) {
                Node newNode = new Node(A.get((currIndex * 2) + 1));
                currNode.left = newNode;
                q.add(new deNode(newNode, ++i));
            } else {
                currNode.left = null;
            }
            if (A.get((currIndex * 2) + 2) != -1) {
                Node newNode = new Node(A.get((currIndex * 2) + 2));
                currNode.right = newNode;
                q.add(new deNode(newNode, ++i));
            } else {
                currNode.right = null;
            }
        }

        return root;
    }
};

class deNode {
    Node node;
    int index;

    public deNode(Node node, int index) {
        this.node = node;
        this.index = index;
    }
}