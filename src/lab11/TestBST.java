package lab11;

import java.util.ArrayList;

public class TestBST {
    public static void main(String[] args) {
        Integer[] integers = {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        BST<Integer> bst = new BST<>(integers);

        System.out.print("Inputted Data: ");
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

        System.out.print("\nInorder (sorted): ");
        bst.inorder(bst.root);
        System.out.println("");

        System.out.print("Postorder: ");
        bst.postorder(bst.root);
        System.out.println("");

        System.out.print("Preorder: ");
        bst.preorder(bst.root);
        System.out.println("");

        System.out.print("Height of BST: " + bst.height());

        System.out.print("\nRoot of BST is: " + bst.root.element);
        System.out.print("\nCheck whether 10 in in the tree? " + bst.search(10));
        System.out.print("\nDelete 53" + bst.delete(53));

        System.out.print("\nUpdated inorder data (sorted): ");
        bst.inorder(bst.root);
        System.out.print("\nMin Value: " + bst.minValue());
        System.out.print("\nMax Value: " + bst.maxValue());

        System.out.print("\nA path from the root to 6 is: ");
        ArrayList<TreeNode<Integer>> path = bst.path(6);
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i).element + " ");
        }
        System.out.println();

    }
}
