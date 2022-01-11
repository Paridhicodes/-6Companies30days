package Amazon;

//User function Template for Java

class Solution {

    static int globalTime = 0;

    public static int minTime(Node root, int target) {
        // Your code goes here
        helper(root, target);
        return globalTime;
    }

    public static int helper(Node root, int target) {
        if (root == null) {
            return -1;
        }

        if (root.data == target) {
            burnTree(root, null, 0);
            return 1;
        }

        int leftTime = helper(root.left, target);
        if (leftTime != -1) {
            burnTree(root, root.left, leftTime);
            return leftTime + 1;
        }

        int rightTime = helper(root.right, target);
        if (rightTime != -1) {
            burnTree(root, root.right, rightTime);
            return rightTime + 1;
        }
        return -1;
    }

    public static void burnTree(Node node, Node blockedNode, int t) {
        if (node == null || node == blockedNode) {
            return;
        }

        globalTime = Math.max(globalTime, t);
        burnTree(node.left, blockedNode, t + 1);
        burnTree(node.right, blockedNode, t + 1);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}