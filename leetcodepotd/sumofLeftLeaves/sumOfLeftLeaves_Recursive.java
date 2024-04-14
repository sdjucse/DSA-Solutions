import java.util.*;

public class sumOfLeftLeaves_Recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter the values of the tree nodes separated by spaces:");
        String[] vals = new String[10];
        while (i < vals.length) {
            vals[i] = sc.nextLine();
            i++;
        }
        TreeNode root = constructTree(vals, 0);
        Solution sol = new Solution();
        int leftSum = sol.sumOfLeftLeaves(root);
        System.out.println("Sum of all values of all left leaves: " + leftSum);
        sc.close();
    }

    private static TreeNode constructTree(String[] values, int ind) {
        if (ind >= values.length || values[ind].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[ind]));
        root.left = constructTree(values, 2 * ind + 1);
        root.right = constructTree(values, 2 * ind + 2);
        return root;
    }

}

class TreeNode {
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

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
