/**
 * BST.java
 * @author Uriel Garcia
 * @author Andrew Nowinski
 * @author Alan Yee
 * @author Maninderjit Singh
 * CIS 22C
 */

import java.awt.*;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST<T extends Comparable<T>> extends Classes{

    private class Node {
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    /***CONSTRUCTORS***/

    /**
     * Default constructor for BST
     * sets root to null
     */
    public BST() {

        root = null;

    }

    /**
     * Copy constructor for BST
     * @param bst the BST to make
     * a copy of
     */
    public BST(BST<T> bst) {

        if(bst == null) {

            return;


        } else {

            copyHelper(bst.root);

        }

    }

    /**
     * Helper method for copy constructor
     * @param node the node containing
     * data to copy
     */
    private void copyHelper(Node node) {

        if(node == null){

            return;

        } else {

            insert(node.data);

            copyHelper(node.left);

            copyHelper(node.right);

        }


    }

    /***ACCESSORS***/

    /**
     * Returns the data stored in the root
     * @precondition !isEmpty()
     * @return the data stored in the root
     * @throws NoSuchElementException when
     * preconditon is violated
     */
    public T getRoot() throws NoSuchElementException{

        if(isEmpty()) {

            throw new NoSuchElementException("getRoot(): cannot get root when BST is empty");

        }



        return root.data;
    }

    /**
     * Determines whether the tree is empty
     * @return whether the tree is empty
     */
    public boolean isEmpty() {

        return root == null;

    }

    /**
     * Returns the current size of the
     * tree (number of nodes)
     * @return the size of the tree
     */
    public int getSize() {

        if(root == null) {

            return 0;

        } else {

            return getSize(root);

        }



    }
    /**

     * Helper method for the getSize method

     * @param node the current node to count

     * @return the size of the tree

     */
    private int getSize(Node node) {

        if(node == null) {

            return 0;

        } else {

            return 1 + getSize(node.left) + getSize(node.right);

        }

    }

    /**
     * Returns the height of tree by
     * counting edges.
     * @return the height of the tree
     */
    public int getHeight() {

        if(root == null) {

            return -1;
        }

        return getHeight(root);

    }

    /**
     * Helper method for getHeight method
     * @param node the current
     * node whose height to count
     * @return the height of the tree
     */
    private int getHeight(Node node) {
        int left = 0;
        int right = 0;

        if (node == null) {

            return -1;

        }

        left = getHeight(node.left);

        right = getHeight(node.right);

        if (left > right) {

            return left + 1; // plus 1 for the root

        } else {

            return right + 1;

        }

    }

    /**
     * Returns the smallest value in the tree
     * @precondition !isEmpty()
     * @return the smallest value in the tree
     * @throws NoSuchElementException when the
     * precondition is violated
     */
    public T findMin() throws NoSuchElementException{

        if(root == null) {

            throw new NoSuchElementException("findMin(): cannot find min when BST is empty.");

        }
        return findMin(root);
    }

    /**
     * Helper method to findMin method
     * @param node the current node to check
     * if it is the smallest
     * @return the smallest value in the tree
     */
    private T findMin(Node node) {

        if(node.left != null) {

            return findMin(node.left);

        } else {

            return node.data;
        }
    }

    /**
     * Returns the largest value in the tree
     * @precondition !isEmpty()
     * @return the largest value in the tree
     * @throws NoSuchElementException when the
     * precondition is violated
     */
    public T findMax() throws NoSuchElementException{

        if(root == null) {

            throw new NoSuchElementException("findMax(): cannot find max when the BST is empty.");
        }

        return findMax(root);
    }

    /**
     * Helper method to findMax method
     * @param node the current node to check
     * if it is the largest
     * @return the largest value in the tree
     */
    private T findMax(Node node) {

        if(node.right != null) {

            return findMax(node.right);

        } else {

            return node.data;
        }
    }

    /**
     * Searches for a specified value
     * in the tree
     * @param data the value to search for
     * @return whether the value is stored
     * in the tree
     */
    public boolean search(T data) {

        if(root == null) {

            return false;
        }

        return search(data, root);

    }

    /**
     * Helper method for the search method
     * @param data the data to search for
     * @param node the current node to check
     * @return whether the data is stored
     * in the tree
     */
    private boolean search(T data, Node node) {

        if(data == node.data) {

            return true;

        } else if(data.compareTo(node.data) < 0) {

            if(node.left == null) {

                return false;

            } else {

                return search(data, node.left);

            }

        } else {

            if(node.right == null) {

                return false;

            } else {

                return search(data, node.right);

            }


        }


    }


    /**
     * Searches for a specified value
     * in the tree
     * @param data the value to search for
     * @return whether the value is stored
     * in the tree
     */
    public boolean search2(T data) {

        if(root == null) {

            return false;
        }

        return search2(data, root);

    }

    /**
     * Helper method for the search method
     * @param data the data to search for
     * @param node the current node to check
     * @return whether the data is stored
     * in the tree
     */
    private boolean search2(T data, Node node) {


        //data == node.data
        if(compare((Classes) data, (Classes) node.data ) == 0) { // 1

            return true; //1a
            //data.compareTo(node.data)
        } else if(compare((Classes) data, (Classes) node.data) < 0) { // 2

            if(node.left == null) {

                return false;

            } else {

                return search2(data, node.left);

            }

        } else {

            if(node.right == null) { // 3a

                return false; //3aa

            } else { //3b

                return search2(data, node.right); //3bb
            }
        }

    }




    /**
     * Determines whether two trees store
     * identical data in the same structural
     * position in the tree
     * @param o another Object
     * @return whether the two trees are equal
     */
    @Override public boolean equals(Object o) {

        if (o == this) {

            return true;

        } else if (!(o instanceof BST)) {

            return false;

        } else {

            BST copy = (BST) o;

            return equals(this.root, copy.root);

        }
    }


    /**
     * Helper method for the equals method
     * @param node1 the node of the first bst
     * @param node2 the node of the second bst
     * @return whether the two trees contain
     * identical data stored in the same structural
     * position inside the trees
     */
    private boolean equals(Node node1, Node node2) {

        if(node1 == node2) {

            return true;

        } else if(node1 == null || node2 == null) {

            return false;

        } else if(node1.data.compareTo(node2.data) != 0) {

            return false;

        } else if(!equals(node1.left, node2.left)) {

            return false;

        } else if(!equals(node1.right, node2.right)) {

            return false;

        } else {

            return true;
        }

    }


    /***MUTATORS***/

    /**
     * Inserts a new node in the tree
     * @param data the data to insert
     */
    public void insert(T data) {

        if(root == null) { // if the BST is empty

            root = new Node(data);  // we make a new node

        } else {

            insert(data, root);
        }

    }

    /**
     * Helper method to insert
     * Inserts a new value in the tree
     * @param data the data to insert
     * @param node the current node in the
     * search for the correct location
     * in which to insert
     */
    private void insert(T data, Node node) {

        if(data.compareTo(node.data) <= 0) {

            if(node.left == null) {

                node.left = new Node(data);

            } else {

                insert(data, node.left);

            }

        } else {

            if(node.right == null) {

                node.right = new Node(data);

            } else {

                insert(data, node.right);

            }

        }

    }

    public void insert2(T data) {

        if(root == null) { // if the BST is empty

            root = new Node(data);  // we make a new node

        } else {

            insert2(data, root);
        }

    }

    private void insert2(T data, Node node) {

        if((compare((Classes) data, (Classes) node.data)) <= 0) {

            if(node.left == null) {

                node.left = new Node(data);

            } else {

                insert2(data, node.left);

            }


        } else {

            if(node.right == null) {

                node.right = new Node(data);

            } else {

                insert2(data, node.right);

            }

        }

    }

    /**
     * Removes a value from the BST
     * @param data the value to remove
     * @precondition !isEmpty()
     * @precondition the data is located in the tree
     * @throws NoSuchElementException when the
     * precondition is violated
     */
    public void remove(T data) throws NoSuchElementException{

        if(isEmpty()) { // root == null

            throw new NoSuchElementException("remove(): cannot remove data when BST is empty.");
        }

        root = remove(data, root);

    }


    /**
     * Helper method to the remove method
     * @param data the data to remove
     * @param node the current node
     * @return an updated reference variable
     */
    private Node remove(T data, Node node) {

        if(node == null) {      // if node is null

            return node;        // return node

        } else if(data.compareTo(node.data) < 0){ // if data < node.data

            node.left = remove(data, node.left); // set the left child equal to the
            // recursive call of remove helper on node's leftchild



        } else if(data.compareTo(node.data) > 0) { // if data > node.data

            node.right = remove(data, node.right); // set the node's rightchild
            // equal to the recrusive call of remove helper
            // on node's rightchild

        } else { // else we found it

            if(node.right == null && node.left == null) { // if node is a leaf

                node = null; // set the node to null

            } else if(node.left != null && node.right == null) { // otherwise if node has a left child but no
                // right child

                node = node.left; // set the left child to be the node

            } else if(node.right != null && node.left == null) { // if node has a rightchild
                // but no leftchild

                node = node.right; // set the rightchild to be the node

            } else { // 4

                node.data = findMin(node.right); // set the node's data to be
                //the minimum value in the node's right subtree

                node.right = remove(findMin(node.right), node.right); //2
                // set the node's rightchild equal to thre recursive call of remove
                //helper, passing it node's rightchild and the minimum data of node's
                // right subtree
            }

        }

        return node; //RETURN THE NODE

    }


    /***ADDITIONAL OPERATIONS***/

    /**
     * Prints the data in pre order
     * to the console
     */
    public void preOrderPrint() {

        if(root == null) {

            return;
        }
        preOrderPrint(root);

        System.out.println("");


    }

    /**
     * Helper method to preOrderPrint method
     * Prints the data in pre order
     * to the console
     */
    private void preOrderPrint(Node node) {

        if(node == null) {

            return;

        } else {

            System.out.print(node.data + " ");

            System.out.println("\n");

            preOrderPrint(node.left);

            preOrderPrint(node.right);

        }

    }

    /**
     * Prints the data in sorted order
     * to the console
     */
    public void inOrderPrint() {
        inOrderPrint(root);
        System.out.println("");
    }

    /**
     * Helper method to inOrderPrint method
     * Prints the data in sorted order
     * to the console
     */
    private void inOrderPrint(Node node) {

        if(node == null) {

            return;

        } else {

            inOrderPrint(node.left);

            System.out.print(node.data + " ");
            System.out.println("\n");

            inOrderPrint(node.right);
        }

    }

    /**
     * Prints the data in post order
     * to the console
     */
    public void postOrderPrint() {

        postOrderPrint(root);

        System.out.println();
    }

    /**
     * Helper method to postOrderPrint method
     * Prints the data in post order
     * to the console
     */
    private void postOrderPrint(Node node) {

        if(node == null) {

            return;

        } else {

            postOrderPrint(node.left);

            postOrderPrint(node.right);

            System.out.print(node.data + " ");
        }

    }

    /**
     * Prints the data in sorted order
     * to the console
     */
    public void PrintRating(Double rating) {
        PrintRating(root, rating);
        System.out.println("");
    }

    /**
     * Helper method to inOrderPrint method
     * Prints the data in sorted order
     * to the console
     */
    private void PrintRating(Node node, Double rating) {

        Classes ratingOnly = new Classes("Default CRN",0.0, "Default Subject", "Default Course"
                ,"Default Days", "Default", "Default Prof", rating);
        List<Classes> list = new List<Classes>();

        if(node == null) {

            return;

        } else {

            PrintRating(node.left, rating);

            if(compare((Classes) node.data , ratingOnly) == 0) {

                list.addLast((Classes) node.data);

            }

            PrintRating(node.right, rating);
        }


        for(int i = 0; i < list.getLength(); i++) {

            System.out.println(list.toString());

            System.out.println("\n");

        }

    }

//toString to write out to print writer

    public String inOrderToString() {
        return inOrderToString(root);
    }


    private String inOrderToString(Node node) {
        String result = "";
        if (node == null) {
            return "";
        }
        result += inOrderToString(node.left);
        result += node.data.toString() + "\n\n";
        result += inOrderToString(node.right);

        return result;

    }


}