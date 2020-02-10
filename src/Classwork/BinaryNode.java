/*
binary node
getters & Setters
length
size
duplicate
pre, post, in
 */

package Classwork;



public class BinaryNode<AnyType> {

    public AnyType element; //Data
    public BinaryNode<AnyType> left, right; //lower nodes

    public BinaryNode(AnyType element){
        this(element, null, null);
    }

    public BinaryNode(){

    }

    public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }
    //O(1)
    public AnyType getElement() {
        return element;
    }

    // O(1)
    public void setElement(AnyType element) {
        this.element = element;
    }

    //O(1)
    public void setLeft(BinaryNode<AnyType> t) {
        this.left = t;
    }

    //O(1)
    public void setRight(BinaryNode<AnyType> t) {
        this.right = t;
    }

    //O(1)
    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    //O(1)
    public BinaryNode<AnyType> getRight() {
        return right;
    }

    //O(n)
    public static <AnyType> int getSize(BinaryNode<AnyType> t){
        if(t == null)
            return 0;
        return 1 + getSize(t.left) + getSize(t.right);
    }

    public int height(BinaryNode<AnyType> t){
        if(t == null)
            return -1;
        else
            return 1 + Math.max(height(t.right),height(t.left));
    }

    //O(n)
    public BinaryNode<AnyType> duplicate(){

        BinaryNode<AnyType> root = new BinaryNode<AnyType>(this.element, null, null);

        if(this.left != null)
            root.left = left.duplicate();
        if(this.right != null)
            root.right = right.duplicate();

        return root;

    }

    public boolean isLeaf(){
        if (getLeft() == null && getRight() == null)
            return true;

        return false;
    }

    //O(n)
    public void printPreOrder(){

        System.out.println(this.element); 	//node

        if (this.left != null)
            left.printPreOrder(); 	//left child

        if(this.right != null)
            right.printPreOrder(); //right child
    }

    //O(n)
    public void printInOrder(){

        if (this.left != null)
            left.printInOrder(); 	//left child

        System.out.println(this.element); 	//node

        if(this.right != null)
            right.printInOrder(); //right child
    }

    //O(n)
    public void printPostOrder(){

        if (this.left != null)
            left.printPostOrder(); 	//left child

        if (this.right != null)
            right.printPostOrder();

        System.out.println(element);
    }// online resource
    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {

        if(right != null)
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│ " : " "), false, sb);

        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(element.toString()).append("\n");

        if(left != null)
            left.toString(new StringBuilder().append(prefix).append(isTail ? " " : "│ "), true, sb);

        return sb;
    }

    // online resource
    @Override
    public String toString() {

        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }



}
