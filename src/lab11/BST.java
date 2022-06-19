package lab11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST <E extends Comparable<E>> {

    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {

    }

    public BST(E[] objects){
        for (E x : objects) {
            insert(x);
        }
    }

    public boolean search(E e){
        TreeNode<E> cur = root;
        while (cur != null){
            if(cur.element.compareTo(e) > 0){
                cur = cur.left;
            } else if(cur.element.compareTo(e) < 0){
                cur = cur.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean insert (E e){
        if (root == null){
            root = new TreeNode<>(e);
        } else {
            TreeNode<E> current = root, parent = null;
            while (current != null){
                parent = current;
                if (current.element.compareTo(e) > 0)
                    current = current.left;
                else if (current.element.compareTo(e) < 0)
                    current = current.right;
                else // duplicate element
                    return false;
            }
            // insert new node
            if (parent.element.compareTo(e) > 0)
                parent.left = new TreeNode<>(e);
            else
                parent.right = new TreeNode<>(e);
        }
        size++;
        return true;
    }

    public int getSize(){
        return size;
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode<E> node){
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height2 (TreeNode<E> node) {
        if (node == null)
            return 0;

        Queue<TreeNode<E>> q = new LinkedList();
        int height = 0;
        q.offer(node);

        while (q.isEmpty()){
            int sizeQueue = q.size();
            height++;
            for (int i = 0; i < sizeQueue; i++) {
                TreeNode<E> temp = q.poll();
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
        }
        return height;
    }

    public E getRoot(){
        return root.element;
    }

    public E minValue(){
        E min = null;
        TreeNode<E> current = root;
        while (current != null){
            min = current.element;
            current = current.left; // because in a binary tree, the minimum elements are on the left side
        }
        return min;
    }

    public E maxValue(){
        E max = null;
        TreeNode<E> current = root;
        while (current != null){
            max = current.element;
            current = current.right;
        }
        return max;
    }

    public ArrayList<TreeNode<E>> path(E e){
        ArrayList<TreeNode<E>> path = new ArrayList<TreeNode<E>>();

        TreeNode<E> current = root;
        while (current != null){
            path.add(current);
            if (current.element.compareTo(e) > 0)
                current = current.left;
            else if (current.element.compareTo(e) < 0)
                current = current.right;
            else
                break;
        }
        return path;
    }

    public boolean delete(E e){
        TreeNode<E> current = root, parent = null;

        while (current != null){
            if (current.element.equals(e))
                break;
            parent = current;
            if (current.element.compareTo(e) > 0)
                current = current.left;
            else
                current = current.right;
        }

        // the node is not found
        if (current == null)
            return false;

        // case 1, no left child
        if (current.left == null){
            if (parent == null)
                root = current.right; // the root element is to be deleted
            else if (current.element.compareTo(parent.element) < 0) // smaller than parent
                parent.left = current.right; // deleting the link from parent's left to current, and forming link to current's right element to the parent
            else // bigger than parent
                parent.right = current.right; // deleting current, and forming link to current's right
        } else { // case 2, got left child
            TreeNode<E> parentOfRightmost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null){
                parentOfRightmost = rightMost;
                rightMost = rightMost.right;
            }
            // Replace the element in current by the element in the rightmost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if(parentOfRightmost.right == rightMost)
                parentOfRightmost.right = rightMost.left;
            else
                parentOfRightmost.left = rightMost.left;
        }
        size--;
        return true;
    }

    public boolean clear() {
        if (root == null)
            return false;
        root = null;
        size = 0;
        return true;
    }

    protected void inorder (TreeNode<E> root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    protected void postorder (TreeNode<E> root){
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    protected void preorder (TreeNode<E> root){
        if (root == null)
            return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
