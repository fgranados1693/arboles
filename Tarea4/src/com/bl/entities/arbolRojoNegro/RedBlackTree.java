package com.bl.entities.arbolRojoNegro;

public class RedBlackTree {
    private static RedBlackNode nullNode = new RedBlackNode(0);
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode header;
    private RedBlackNode grand;
    private RedBlackNode great;
    static final int RED = 0;
    static final int BLACK = 1;

    public RedBlackTree(int header) {
        this.header = new RedBlackNode(header);
        this.header.leftChild = nullNode;
        this.header.rightChild = nullNode;
    }

    public void removeAll() {
        this.header.rightChild = nullNode;
    }

    public boolean checkEmpty() {
        return this.header.rightChild == nullNode;
    }

    public void insertNewNode(int newElement) {
        this.current = this.parent = this.grand = this.header;
        nullNode.element = newElement;

        while(this.current.element != newElement) {
            this.great = this.grand;
            this.grand = this.parent;
            this.parent = this.current;
            this.current = newElement < this.current.element ? this.current.leftChild : this.current.rightChild;
            if (this.current.leftChild.color == 0 && this.current.rightChild.color == 0) {
                this.handleColors(newElement);
            }
        }

        if (this.current == nullNode) {
            this.current = new RedBlackNode(newElement, nullNode, nullNode);
            if (newElement < this.parent.element) {
                this.parent.leftChild = this.current;
            } else {
                this.parent.rightChild = this.current;
            }

            this.handleColors(newElement);
        }
    }

    private void handleColors(int newElement) {
        this.current.color = 0;
        this.current.leftChild.color = 1;
        this.current.rightChild.color = 1;
        if (this.parent.color == 0) {
            this.grand.color = 0;
            if (newElement < this.grand.element && this.grand.element != newElement && newElement < this.parent.element) {
                this.parent = this.performRotation(newElement, this.grand);
            }

            this.current = this.performRotation(newElement, this.great);
            this.current.color = 1;
        }

        this.header.rightChild.color = 1;
    }

    private RedBlackNode performRotation(int newElement, RedBlackNode parent) {
        return newElement < parent.element ? (parent.leftChild = newElement < parent.leftChild.element ? this.rotationWithLeftChild(parent.leftChild) : this.rotationWithRightChild(parent.leftChild)) : (parent.rightChild = newElement < parent.rightChild.element ? this.rotationWithLeftChild(parent.rightChild) : this.rotationWithRightChild(parent.rightChild));
    }

    private RedBlackNode rotationWithLeftChild(RedBlackNode node2) {
        RedBlackNode node1 = node2.leftChild;
        node2.leftChild = node1.rightChild;
        node1.rightChild = node2;
        return node1;
    }

    private RedBlackNode rotationWithRightChild(RedBlackNode node1) {
        RedBlackNode node2 = node1.rightChild;
        node1.rightChild = node2.leftChild;
        node2.leftChild = node1.leftChild;
        return node2;
    }

    public int nodesInTree() {
        return this.nodesInTree(this.header.rightChild);
    }

    private int nodesInTree(RedBlackNode node) {
        if (node == nullNode) {
            return 0;
        } else {
            int sized = 1;
            int size = sized + this.nodesInTree(node.leftChild);
            size += this.nodesInTree(node.rightChild);
            return size;
        }
    }

    public boolean searchNode(int value) {
        return this.searchNode(this.header.rightChild, value);
    }

    private boolean searchNode(RedBlackNode node, int value) {
        boolean check;
        for(check = false; node != nullNode && !check; check = this.searchNode(node, value)) {
            int nodeValue = node.element;
            if (value < nodeValue) {
                node = node.leftChild;
            } else {
                if (value <= nodeValue) {
                    check = true;
                    break;
                }

                node = node.rightChild;
            }
        }

        return check;
    }

    public void preorderTraversal() {
        this.preorderTraversal(this.header.rightChild);
    }

    private void preorderTraversal(RedBlackNode node) {
        if (node != nullNode) {
            char c = 'R';
            if (node.color == 1) {
                c = 'B';
            }

            System.out.print(node.element + c + " ");
            this.preorderTraversal(node.leftChild);
            this.preorderTraversal(node.rightChild);
        }

    }

    public void inorderTraversal() {
        this.inorderTraversal(this.header.rightChild);
    }

    private void inorderTraversal(RedBlackNode node) {
        if (node != nullNode) {
            this.inorderTraversal(node.leftChild);
            char c = 'R';
            if (node.color == 1) {
                c = 'B';
            }

            System.out.print(node.element + c + " ");
            this.inorderTraversal(node.rightChild);
        }

    }

    public void postorderTraversal() {
        this.postorderTraversal(this.header.rightChild);
    }

    private void postorderTraversal(RedBlackNode node) {
        if (node != nullNode) {
            this.postorderTraversal(node.leftChild);
            this.postorderTraversal(node.rightChild);
            char c = 'R';
            if (node.color == 1) {
                c = 'B';
            }

            System.out.print(node.element + c + " ");
        }

    }

    static {
        nullNode.leftChild = nullNode;
        nullNode.rightChild = nullNode;
    }
}
