package com.bl.entities.arbolRojoNegro;

public class RedBlackNode {
    RedBlackNode leftChild;
    RedBlackNode rightChild;
    int element;
    int color;

    public RedBlackNode(int element) {
        this(element, (RedBlackNode)null, (RedBlackNode)null);
    }

    public RedBlackNode(int element, RedBlackNode leftChild, RedBlackNode rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.color = 1;
    }
}
