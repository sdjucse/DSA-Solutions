package kthcommonancestorbst.bruteforce;

import java.util.*;

class Node {
    Node left;
    Node right;
    int d;

    Node(int d) {
        this.d = d;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        List<Integer> list = new ArrayList<>();
        helper(root, Math.min(x, y), Math.max(x, y), list);
        int size = list.size();
        if (size - k >= 0)
            return list.get(size - k);
        return -1;
    }

    private void helper(Node root, int x, int y, List<Integer> arr) {
        if (root == null) {
            return;
        }
        int data = root.d;
        arr.add(data);
        if (data > x && data < y)
            return;
        else if (data < x && data < y) {
            helper(root.right, x, y, arr);
        } else if (data > x && data > y) {
            helper(root.left, x, y, arr);
        }
    }
}

public class kthcommancbst_bruteforce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of root node:");
        int rootval = sc.nextInt();
        Node root = new Node(rootval);
        System.out.println("Enter the left child of" + rootval + ":");
        int leftrootval = sc.nextInt();
        root.left = new Node(leftrootval);
        System.out.println("Enter the right child of" + rootval + ":");
        int rightrootval = sc.nextInt();
        root.right = new Node(rightrootval);
        System.out.println("Enter the value of node x:");
        int x = sc.nextInt();
        System.out.print("Enter the valueof node y:");
        int y = sc.nextInt();
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        Solution sol = new Solution();
        int kthCommonAncestor = sol.kthCommonAncestor(root, k, x, y);
        if (kthCommonAncestor != -1) {
            System.out.println(
                    "The " + k + "th common ancestor of nodes " + x + " and " + y + " is: " + kthCommonAncestor);
        } else {
            System.out.println("The " + k + "th common ancestor does not exist.");
        }

        // Close the scanner
        sc.close();
    }
}
