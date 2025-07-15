import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathToNode {
    public static boolean getPath(TreeNode node, int target, List<Integer> list) {
        if (node == null) {
            return false;
        }

        list.add(node.val);

        if (node.val == target) {
            return true;
        }

        if(getPath(node.left, target, list) || getPath(node.right, target, list)) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }

    public static List<Integer> pathToNode(TreeNode root, int target) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        getPath(root, target, list);

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values for the tree nodes (space-separated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        System.out.println("Enter the desired node:");
        int target = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        List<Integer> list = pathToNode(root, target);

        System.out.println("Path to the desired Node is:");
        for(int val: list) {
            System.out.print(val + " ");
        }

    }
}
