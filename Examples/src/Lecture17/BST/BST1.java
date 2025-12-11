package Lecture17.BST;

public class BST1<T extends Comparable<T>> {
    public class Node {
        Node parent;
        Node left;
        Node right;
        T value;

        public Node(Node parent, Node left, Node right, T value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }
    }

    private Node root;

    public BST1() {
        root = null;
    }

    public void add(T value) {
        root = addRecursive(root, value, null);
    }

    private Node addRecursive(Node current, T value, Node parent) {
        if (current == null) {
            return new Node(parent, null, null, value);
        }

        if (current.value.compareTo(value) < 0) {
            current.right = addRecursive(current.right, value, current);
        } else if (current.value.compareTo(value) > 0) {
            current.left = addRecursive(current.left, value, current);
        }

        return current;
    }

    public Node find(T value) {
        return findRecursive(value, root);
    }

    private Node findRecursive(T value, Node currNode) {

        if (currNode == null) {
            return null;
        }

        if (currNode.value.compareTo(value) == 0) {
            return currNode;
        } else if (currNode.value.compareTo(value) < 0) {
            return findRecursive(value, currNode.right);
        } else {
            return findRecursive(value, currNode.left);
        }

    }

    private boolean isLeaf(Node node) {
        return node.right == null && node.left == null;
    }

    public Node findMax() {
        return findMaxRecursive(root);
    }

    private Node findMaxRecursive(Node currNode) {
        if (currNode == null || currNode.right == null) {
            return currNode;
        }
        return findMaxRecursive(currNode.right);
    }

    public Node findMin() {
        return findMinRecursive(root);
    }

    private Node findMinRecursive(Node currNode) {
        if (currNode == null || currNode.left == null) {
            return currNode;
        }
        return findMinRecursive(currNode.left);
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node currNode, T value) {

        if (currNode == null) {
            return null;
        }

        if (currNode.value.compareTo(value) < 0) {
            currNode.right = deleteRecursive(currNode.right, value);
        } else if (currNode.value.compareTo(value) > 0) {
            currNode.left = deleteRecursive(currNode.left, value);
        } else {
            if (isLeaf(currNode)) {
                return null;
            } else if (currNode.right == null) {
                return currNode.left;
            } else if (currNode.left == null) {
                return currNode.right;
            } else {
                Node min = findMinRecursive(currNode.right);
                currNode.value = min.value;
                currNode.right = deleteRecursive(currNode.right, min.value);
            }
        }
        return currNode;
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public void printTree() {
        printTree(root, "", false);
    }

}
